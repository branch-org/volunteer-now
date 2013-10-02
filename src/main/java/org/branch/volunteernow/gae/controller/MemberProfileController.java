package org.branch.volunteernow.gae.controller;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import org.branch.volunteernow.gae.dao.MemberProfileJdoDao;
import org.branch.volunteernow.gae.model.MemberProfile;
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
@Transactional
 public class MemberProfileController extends BaseController
{

    @Autowired
    private MemberProfileJdoDao<MemberProfile> profileDao;

    @ModelAttribute
    public MemberProfile getMemberProfile()
    {
        final UserService userService = UserServiceFactory.getUserService();
        final User currentUser = userService.getCurrentUser();

        MemberProfile memberProfile = profileDao.findByEmail(currentUser.getEmail());
        if (memberProfile == null)
        {
            memberProfile = new MemberProfile();
            memberProfile.setEmail(currentUser.getEmail());
        }

        return memberProfile;
    }

    @RequestMapping(value = URL_MEMBERS_PROFILE, method = RequestMethod.GET)
    public ModelAndView profileGet()
    {
        final Map<String, Object> model = new HashMap<String, Object>();

        return new ModelAndView(PAGE_MEMBERS_PROFILE, model);
    }

    @RequestMapping(value = URL_MEMBERS_PROFILE_EDIT, method = RequestMethod.GET)
    public ModelAndView editGet()
    {
        final Map<String, Object> model = new HashMap<String, Object>();

        return new ModelAndView(PAGE_MEMBERS_PROFILE_EDIT, model);
    }

    @RequestMapping(value = URL_MEMBERS_PROFILE_EDIT, method = RequestMethod.POST)
    public ModelAndView editPost(@ModelAttribute MemberProfile memberProfile, BindingResult result, HttpServletRequest request)
    {
        final Map<String, Object> model = new HashMap<String, Object>();

        profileDao.save(memberProfile);

        return new ModelAndView(PAGE_MEMBERS_PROFILE);//, model);
    }
}

