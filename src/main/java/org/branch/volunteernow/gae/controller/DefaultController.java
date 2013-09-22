package org.branch.volunteernow.gae.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
public class DefaultController
{
    @RequestMapping("/")
    public ModelAndView root(HttpServletRequest request, HttpServletResponse response)
    {
        final Map<String, Object> model = new HashMap<String, Object>();

        return new ModelAndView("index", model);
    }
}
