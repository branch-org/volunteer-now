package org.branch.volunteernow.gae.controller;

/**
 * Created with IntelliJ IDEA.
 * User: tbeauvais
 * Date: 6/8/13
 * Time: 4:59 PM
 * To change this template use File | Settings | File Templates.
 */

import org.branch.volunteernow.gae.dao.ProfileDao;
import org.branch.volunteernow.model.Profile;
import org.branch.volunteernow.model.jdo.MemberProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/members")
public class MembersController
{
    @Autowired
    private ProfileDao membersDao;

    @ResponseBody
    @RequestMapping("/list")
    public String list()
    {
//        return membersDao.getAll(Profile.class).toString();
        return null;
    }

    @RequestMapping("/add")
    public void add(@RequestParam String name)
    {
        final MemberProfile member = new MemberProfile();
        member.setName(name);

        membersDao.save(member);
    }
}