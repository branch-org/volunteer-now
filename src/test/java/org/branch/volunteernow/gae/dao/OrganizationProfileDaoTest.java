package org.branch.volunteernow.gae.dao;

import org.branch.volunteernow.model.Profile;
import org.branch.volunteernow.model.jdo.MemberProfile;
import org.branch.volunteernow.model.jdo.OrganizationProfile;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Thomas Beauvais <thomas.beauvais@silbury.de>
 * @since 8/15/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class OrganizationProfileDaoTest extends AbstractProfileDaoTest<OrganizationProfile>
{
    @Override
    protected void assertSave(OrganizationProfile original, OrganizationProfile saved)
    {
        System.out.println("Original: " + original);
        System.out.println("Saved: " + saved);
    }

    @Override
    protected OrganizationProfile createInstance()
    {
        final OrganizationProfile profile = new OrganizationProfile();
        profile.setName("Name1");

        return profile;
    }
}
