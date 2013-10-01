package org.branch.volunteernow.gae.dao;

import org.branch.volunteernow.model.jdo.MemberProfile;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Thomas Beauvais <thomas.beauvais@silbury.de>
 * @since 8/15/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class MemberProfileDaoTest extends AbstractProfileDaoTest<MemberProfile>
{
    @Override
    protected void assertSave(MemberProfile original, MemberProfile saved)
    {
    }

    @Override
    protected MemberProfile createInstance()
    {
        final MemberProfile memberProfile = new MemberProfile();
        memberProfile.setFirstName("John");
        memberProfile.setLastName("Daily");
        memberProfile.setEmail("test@example.com");

        return memberProfile;
    }
}
