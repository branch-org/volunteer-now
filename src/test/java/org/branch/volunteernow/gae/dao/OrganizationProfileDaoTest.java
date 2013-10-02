package org.branch.volunteernow.gae.dao;

import org.branch.volunteernow.gae.model.OrganizationProfile;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Thomas Beauvais <thomas.beauvais@silbury.de>
 * @since 8/15/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class OrganizationProfileDaoTest extends AbstractJdoDaoTest<OrganizationProfile, OrganizationProfileJdoDao<OrganizationProfile>>
{
    @Override
    protected void assertSame(OrganizationProfile expected, OrganizationProfile actual)
    {
    }

    @Override
    protected OrganizationProfile createInstance()
    {
        final OrganizationProfile profile = new OrganizationProfile();
        profile.setName("Name1");
        profile.setMission("Mission1");

        return (OrganizationProfile) profile;
    }
}
