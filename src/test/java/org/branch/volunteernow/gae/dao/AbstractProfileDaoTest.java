package org.branch.volunteernow.gae.dao;

import org.branch.volunteernow.dao.ProfileDao;
import org.branch.volunteernow.model.Profile;
import org.junit.*;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author Thomas Beauvais <thomas.beauvais@silbury.de>
 * @since 8/15/13
 */
public abstract class AbstractProfileDaoTest<Generic extends Profile, GenericDao extends ProfileDao<Generic>> extends AbstractDaoTest<Generic, GenericDao>
{
    @Test
    @Transactional
    public void findByEmail() {
        final Profile original = createInstance();

        final String email = original.getEmail();

        Assert.assertNotNull(email);

        final Profile found = getTestDao().findByEmail(email);

        Assert.assertNotNull(found);
        Assert.assertEquals(original.getId(), original.getId());
    }
}
