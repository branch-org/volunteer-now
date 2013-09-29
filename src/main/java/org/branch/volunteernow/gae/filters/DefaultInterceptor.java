package org.branch.volunteernow.gae.filters;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Thomas Beauvais <thomas.beauvais@silbury.de>
 * @since 8/15/13
 */
public class DefaultInterceptor implements HandlerInterceptor
{
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception
    {
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception
    {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception
    {

    }

    protected void doRedirect( HttpServletResponse response, String targetUrl, ModelAndView modelAndView ) throws IOException
    {
        if ( modelAndView != null ) {
            final RedirectView rView = new RedirectView(targetUrl, true);
//            rView.setStatusCode(HttpStatus.);
            rView.setHttp10Compatible(false);
            rView.setExposeModelAttributes(false);
            modelAndView.setView(rView);
        }

        response.sendRedirect(targetUrl);
    }
}
