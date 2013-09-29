package org.branch.volunteernow.gae.controller;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import org.branch.volunteernow.gae.dao.ProfileDao;
import org.branch.volunteernow.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Thomas Beauvais <thomas.beauvais@silbury.de>
 * @since 8/15/13
 */
@Controller
@RequestMapping("/profile")
public class ProfileController
{
    @Autowired
    private ProfileDao profileDao;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView get()
    {
        final UserService userService = UserServiceFactory.getUserService();
        final User currentUser = userService.getCurrentUser();

        final Map<String, Object> model = new HashMap<String, Object>();

        final Profile profile = profileDao.getProfileForEmail(currentUser.getEmail());
        if (profile == null)
        {
            return new ModelAndView("redirect:/profile/edit", model);
        }

        model.put("profile", profile);

        return new ModelAndView("profile", model);
    }

    @RequestMapping(value ="edit", method = RequestMethod.GET)
    public ModelAndView edit() {
        final Map<String, Object> model = new HashMap<String, Object>();

        return new ModelAndView("profile_edit", model);
    }
}

