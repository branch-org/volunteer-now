package org.branch.volunteernow.gae.dao;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import org.branch.volunteernow.model.Entity;

import org.junit.*;

/**
 * @author Thomas Beauvais <thomas.beauvais@silbury.de>
 * @since 8/15/13
 */
public abstract class AbstractDaoTest<T extends Entity>
{
    private final LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

    private Dao<T> testDao;

    protected void setTestDao(Dao<T> testDao)
    {
        this.testDao = testDao;
    }

    protected Dao<T> getTestDao()
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
        final T original = createInstance();
        final T saved = testDao.save(original);

        Assert.assertNotNull(saved);
        Assert.assertNotNull(saved.getId());
        Assert.assertEquals(original, saved);

        assertSave(original, saved);
    }

    @Test
    public void expiration()
    {
        final T original = createInstance();
        final T saved = testDao.save(original);

        // This was throwing, "Object with id ... is managed by a different Object Manager"
        // This test is made to exercise cross transaction saves
        testDao.save(saved);
    }

    @Test
    public void findById() {
        final T original = createInstance();
        final T saved = testDao.save(original);

        final T found = testDao.findById(saved.getId());
    }

    protected abstract void assertSave(T original, T saved);

    protected abstract T createInstance();
}
