package org.branch.volunteernow.gae.dao;

import org.branch.volunteernow.gae.model.MemberProfile;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Thomas Beauvais <thomas.beauvais@silbury.de>
 * @since 8/15/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class MemberProfileDaoTest extends AbstractProfileDaoTest<MemberProfile, MemberProfileJdoDao<MemberProfile>>
{
    @Test
    public void changeFirstName() {
        final MemberProfile original = createAndSave();

        original.setFirstName("Bruce");

        final MemberProfile saved = getTestDao().save(original);

        Assert.assertEquals(saved.getFirstName(), "Bruce");
    }

    @Override
    protected void assertSame(MemberProfile expected, MemberProfile actual)
    {
        Assert.assertEquals(expected.getFirstName(), actual.getFirstName());
    }

    @Override
    protected MemberProfile createInstance()
    {
        final MemberProfile memberProfile = new MemberProfile();
        memberProfile.setFirstName("John");
        memberProfile.setLastName("Daily");
        memberProfile.setEmail("test@example.com");

        memberProfile.getPrimaryAddress().setCity("Nürnberg");
        memberProfile.getPrimaryAddress().setState("Bayern");
        memberProfile.getPrimaryAddress().setCountry("Deustchland");

        return (MemberProfile) memberProfile;
    }
}
