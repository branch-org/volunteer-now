package org.branch.volunteernow.gae.controller;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import org.branch.volunteernow.constants.PathConstants;
import org.branch.volunteernow.gae.dao.ProfileDao;
import org.branch.volunteernow.model.jdo.MemberProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Thomas Beauvais <thomas.beauvais@silbury.de>
 * @since 8/15/13
 */
@Controller
@RequestMapping("/profile")
@Transactional
 public class ProfileController implements PathConstants
{
    @Autowired
    private ProfileDao profileDao;

    @ModelAttribute("myprofile")
    public MemberProfile getMemberProfile()
    {
        final UserService userService = UserServiceFactory.getUserService();
        final User currentUser = userService.getCurrentUser();

        MemberProfile memberProfile = profileDao.findByEmail(currentUser.getEmail());
        if (memberProfile == null)
        {
            memberProfile = new MemberProfile();
            memberProfile.setEmail(currentUser.getEmail());

            return memberProfile;
        }

        memberProfile.setEmail(currentUser.getEmail());

        return memberProfile;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView get()
    {
        final Map<String, Object> model = new HashMap<String, Object>();

        return new ModelAndView("profile", model);
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public ModelAndView editGet()
    {
        final Map<String, Object> model = new HashMap<String, Object>();

        return new ModelAndView("profile_edit", model);
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public ModelAndView editPost(@ModelAttribute("myprofile") MemberProfile profile, BindingResult result, HttpServletRequest request)
    {
        final Map<String, Object> model = new HashMap<String, Object>();

        profileDao.save(profile);

        return new ModelAndView("profile", model);
    }
}

