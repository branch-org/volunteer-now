package org.branch.volunteernow.gae.controller;

import org.branch.volunteernow.constants.PathConstants;

/**
 * @author Thomas Beauvais <thomas.beauvais@silbury.de>
 * @since 8/15/13
 */
public class BaseController implements PathConstants
{
    protected String redirect(String url)
    {
        return "redirect:" + url;
    }
}
