package org.branch.volunteernow.gae.dao;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import org.branch.volunteernow.dao.Dao;
import org.branch.volunteernow.model.Entity;

import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Thomas Beauvais <thomas.beauvais@silbury.de>
 * @since 8/15/13
 */
public abstract class AbstractDaoTest<Generic extends Entity, GenericDao extends Dao<Generic>>
{
    private final LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

    private GenericDao testDao;

    @Autowired
    protected void setTestDao(GenericDao testDao)
    {
        this.testDao = testDao;
    }

    protected GenericDao getTestDao()
    {
        return testDao;
    }

    @Before
    public void setUp()
    {
        helper.setUp();
    }

    @After
    public void tearDown()
    {
        helper.tearDown();
    }

    @Test
    public void save()
    {
        final Generic original = createInstance();
        final Generic saved = getTestDao().save(original);

        Assert.assertNotNull(saved);
        Assert.assertNotNull(saved.getId());
        Assert.assertEquals(original, saved);

        assertSave(original, saved);
    }

    @Test
    public void expiration()
    {
        final Generic original = createInstance();
        final Generic saved = getTestDao().save(original);

        // This was throwing, "Object with id ... is managed by a different Object Manager"
        // This test is made to exercise cross transaction saves
        testDao.save(saved);
    }

    @Test
    public void findById() {
        final Generic original = createInstance();
        final Generic saved = getTestDao().save(original);

        final Generic found = getTestDao().findById(saved.getId());
    }

    protected abstract void assertSave(Generic original, Generic saved);

    protected abstract Generic createInstance();
}
