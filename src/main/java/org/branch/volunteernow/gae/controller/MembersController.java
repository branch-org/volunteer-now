package org.branch.volunteernow.gae.controller;

/**
 * Created with IntelliJ IDEA.
 * User: tbeauvais
 * Date: 6/8/13
 * Time: 4:59 PM
 * To change this template use File | Settings | File Templates.
 */

import org.branch.volunteernow.dao.MemberProfileDao;
import org.branch.volunteernow.dao.ProfileDao;
import org.branch.volunteernow.gae.model.jdo.MemberProfileImpl;
import org.branch.volunteernow.model.MemberProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/members")
public class MembersController extends BaseController
{
}