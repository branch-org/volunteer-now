package org.branch.volunteernow.gae.dao;

import org.branch.volunteernow.gae.model.Profile;
import org.junit.*;

/**
 * @author Thomas Beauvais <thomas.beauvais@silbury.de>
 * @since 8/15/13
 */
public abstract class AbstractProfileDaoTest<Generic extends Profile, GenericDao extends AbstractProfileJdoDao<Generic>> extends AbstractJdoDaoTest<Generic, GenericDao>
{
    @Test
    public void findByEmail() {
        final Generic saved = createAndSave();

        final String email = saved.getEmail();

        Assert.assertNotNull(email);

        final Generic found = getTestDao().findByEmail(email);

        Assert.assertNotNull(found);
        Assert.assertEquals(saved.getId(), saved.getId());
    }
}

