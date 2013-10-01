package org.branch.volunteernow.gae.filters;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import org.branch.volunteernow.constants.PathConstants;
import org.branch.volunteernow.dao.MemberProfileDao;
import org.branch.volunteernow.dao.ProfileDao;
import org.branch.volunteernow.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Thomas Beauvais <thomas.beauvais@silbury.de>
 * @since 8/15/13
 */
public class CurrentUserInterceptor extends DefaultInterceptor implements HandlerInterceptor, PathConstants
{

    @Autowired
    private MemberProfileDao profileDao;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        final String thisURL = request.getRequestURI();

        // This ensures that the user has a profile that is filled out.
        if (!URL_MEMBERS_PROFILE_EDIT.equals(thisURL))
        {
            final UserService userService = UserServiceFactory.getUserService();
            final User currentUser = userService.getCurrentUser();
            if (currentUser != null)
            {
                final Profile profile = profileDao.findByEmail(currentUser.getEmail());

                if (profile == null)
                {
                    doRedirect(response, URL_MEMBERS_PROFILE_EDIT, null);
                }
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception
    {
        if (modelAndView != null)
        {
            final UserService userService = UserServiceFactory.getUserService();
            final User currentUser = userService.getCurrentUser();

            final String thisURL = request.getRequestURI();
            if (currentUser != null)
            {
                modelAndView.getModel().put("logoutUrl", userService.createLogoutURL("/"));
            }
            else
            {
                modelAndView.getModel().put("loginUrl", userService.createLoginURL(thisURL));
            }
            modelAndView.getModel().put("currentUser", currentUser);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception
    {
    }
}
