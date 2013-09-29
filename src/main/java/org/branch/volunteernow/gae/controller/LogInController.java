package org.branch.volunteernow.gae.controller;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import org.branch.volunteernow.constants.PathConstants;
import org.branch.volunteernow.gae.dao.ProfileDao;
import org.branch.volunteernow.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Thomas Beauvais <thomas.beauvais@silbury.de>
 * @since 8/15/13
 */
@Controller
@RequestMapping("/login")
public class LogInController implements PathConstants
{
    @Autowired
    private ProfileDao profileDao;

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView login()
    {
        final UserService userService = UserServiceFactory.getUserService();
        final User currentUser = userService.getCurrentUser();

        final Map<String, Object> model = new HashMap<String, Object>();

        if (currentUser == null)
        {
            return new ModelAndView("login", model);
        }

        final Profile profile = profileDao.getProfileForEmail(currentUser.getEmail());
        if (profile == null)
        {
            return new ModelAndView("redirect:" + URL_PROFILE_EDIT, model);
        }

        model.put("profile", profile);

        return new ModelAndView("redirect:/", model);
    }
}
