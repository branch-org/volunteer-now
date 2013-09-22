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

        assertSave(original, saved);

        System.out.println("Saved       :" + saved);

//        final MemberProfile retrieved = profileDao.get(MemberProfile.class, saved.getId());
//        System.out.println("Retrieved   :" + retrieved);
//
//        Assert.assertEquals(saved.getName(), retrieved.getName());
//        Assert.assertEquals(saved.getId(), retrieved.getId());
//        Assert.assertEquals(saved, retrieved);
    }

    protected abstract void assertSave(T original, T saved);

    protected abstract T createInstance();
}
