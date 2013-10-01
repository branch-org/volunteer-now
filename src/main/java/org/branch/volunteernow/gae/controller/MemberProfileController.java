package org.branch.volunteernow.gae.controller;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import org.branch.volunteernow.constants.PathConstants;
import org.branch.volunteernow.dao.MemberProfileDao;
import org.branch.volunteernow.model.MemberProfile;
import org.branch.volunteernow.gae.model.jdo.MemberProfileImpl;
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
    private MemberProfileDao<MemberProfile> profileDao;

    @ModelAttribute
    public MemberProfile getMemberProfile()
    {
        final UserService userService = UserServiceFactory.getUserService();
        final User currentUser = userService.getCurrentUser();

        MemberProfile memberProfile = profileDao.findByEmail(currentUser.getEmail());
        if (memberProfile == null)
        {
            memberProfile = new MemberProfileImpl();
            memberProfile.setEmail(currentUser.getEmail());

            return memberProfile;
        }

        memberProfile.setEmail(currentUser.getEmail());

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
    public ModelAndView editPost(@ModelAttribute MemberProfileImpl memberProfile, BindingResult result, HttpServletRequest request)
    {
        final Map<String, Object> model = new HashMap<String, Object>();

        profileDao.save(memberProfile);

        return new ModelAndView(PAGE_MEMBERS_PROFILE, model);
    }
}

