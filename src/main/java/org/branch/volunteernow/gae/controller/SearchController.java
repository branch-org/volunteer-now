package org.branch.volunteernow.gae.controller;

import org.branch.volunteernow.gae.model.jdo.OpportunityImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Thomas Beauvais <thomas.beauvais@silbury.de>
 * @since 8/15/13
 */
@Controller
public class SearchController extends BaseController
{
    @RequestMapping(URL_SEARCH)
    public ModelAndView search(@RequestParam(defaultValue = "") String searchInput)
    {
        final Map<String, Object> model = new HashMap<String, Object>();

        model.put("searchInput", searchInput);
        model.put("searchResults", new ArrayList(Arrays.asList(
                new OpportunityImpl("asdf", "asdf", "asdf", "asdf"),
                new OpportunityImpl("asdf", "asdf", "asdf", "asdf"),
                new OpportunityImpl("asdf", "asdf", "asdf", "asdf"),
                new OpportunityImpl("asdf", "asdf", "asdf", "asdf"),
                new OpportunityImpl("asdf", "asdf", "asdf", "asdf"),
                new OpportunityImpl("asdf", "asdf", "asdf", "asdf"),
                new OpportunityImpl("asdf", "asdf", "asdf", "asdf")
        )));

        return new ModelAndView("search", model);
    }
}
