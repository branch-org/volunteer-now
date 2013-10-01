package org.branch.volunteernow.gae.controller;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import org.branch.volunteernow.constants.PathConstants;
import org.branch.volunteernow.dao.MemberProfileDao;
import org.branch.volunteernow.model.MemberProfile;
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
public class LogInController extends BaseController
{
    @Autowired
    private MemberProfileDao<MemberProfile> profileDao;

    @RequestMapping(value = URL_LOGIN, method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView loginGet()
    {
        final UserService userService = UserServiceFactory.getUserService();
        final User currentUser = userService.getCurrentUser();

        final Map<String, Object> model = new HashMap<String, Object>();

        if (currentUser == null)
        {
            return new ModelAndView(PAGE_LOGIN, model);
        }

        final MemberProfile profile = profileDao.findByEmail(currentUser.getEmail());
        if (profile == null)
        {
            return new ModelAndView(redirect(URL_MEMBERS_PROFILE_EDIT), model);
        }

        return new ModelAndView(redirect(URL_HOME), model);
    }
}
