package org.branch.volunteernow.gae.dao;

import org.branch.volunteernow.dao.MemberProfileDao;
import org.branch.volunteernow.model.MemberProfile;
import org.branch.volunteernow.gae.model.jdo.MemberProfileImpl;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Thomas Beauvais <thomas.beauvais@silbury.de>
 * @since 8/15/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class MemberProfileDaoTest extends AbstractProfileDaoTest<MemberProfile, MemberProfileDao<MemberProfile>>
{
    @Override
    protected void assertSame(MemberProfile expected, MemberProfile actual)
    {
        Assert.assertEquals(expected.getFirstName(), actual.getFirstName());
    }

    @Override
    protected MemberProfile createInstance()
    {
        final MemberProfileImpl memberProfile = new MemberProfileImpl();
        memberProfile.setFirstName("John");
        memberProfile.setLastName("Daily");
        memberProfile.setEmail("test@example.com");

        return (MemberProfile) memberProfile;
    }
}
