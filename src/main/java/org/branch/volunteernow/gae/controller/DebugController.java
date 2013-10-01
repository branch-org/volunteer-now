package org.branch.volunteernow.gae.controller;

/**
* Created with IntelliJ IDEA.
* User: tbeauvais
* Date: 6/8/13
* Time: 4:59 PM
* To change this template use File | Settings | File Templates.
*/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/debug")
public class DebugController extends BaseController {
    @ResponseBody
    @RequestMapping(value = "/ping")
    public String pong() {
        return "Pong?";
    }
}