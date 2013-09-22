package org.branch.volunteernow.gae.filters;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Thomas Beauvais <thomas.beauvais@silbury.de>
 * @since 8/15/13
 */
public class CurrentUserInterceptor implements HandlerInterceptor
{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
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
            if (request.getUserPrincipal() != null)
            {
                modelAndView.getModel().put("logoutUrl", userService.createLogoutURL(thisURL));
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
