package org.branch.volunteernow.gae.dao;

import org.branch.volunteernow.gae.dao.AbstractDaoTest;
import org.branch.volunteernow.gae.dao.ProfileDao;
import org.branch.volunteernow.gae.dao.jdo.DefaultJdoDao;
import org.branch.volunteernow.model.Profile;
import org.branch.volunteernow.model.jdo.MemberProfile;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import org.junit.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Thomas Beauvais <thomas.beauvais@silbury.de>
 * @since 8/15/13
 */
public abstract class AbstractProfileDaoTest<T extends Profile> extends AbstractDaoTest<T>
{
    @Autowired
    public void setProfileDao(ProfileDao profileDao)
    {
        super.setTestDao((Dao<T>) profileDao);
    }
}
