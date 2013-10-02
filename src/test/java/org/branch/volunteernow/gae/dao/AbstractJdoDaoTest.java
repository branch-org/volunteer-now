package org.branch.volunteernow.gae.dao;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import org.branch.volunteernow.gae.model.AbstractEntity;

import org.junit.*;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

/**
 * @author Thomas Beauvais <thomas.beauvais@silbury.de>
 * @since 8/15/13
 */
public abstract class AbstractJdoDaoTest<Generic extends AbstractEntity, GenericDao extends DefaultJdoDao<Generic>>
{
    private final LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
//    private final LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalMemcacheServiceTestConfig());

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

        assertSame(original, saved);
    }

    @Test
    public void expiration()
    {
        final Generic saved = createAndSave();

        // This was throwing, "Object with id ... is managed by a different Object Manager"
        // This test is made to exercise cross transaction saves
        getTestDao().save(saved);
    }

    @Test
    public void findById()
    {
        final Generic saved = createAndSave();

        final Generic found = getTestDao().findById(saved.getId());

        Assert.assertNotNull(found);

        assertSame(saved, found);
    }

    @Test
    public void findAll()
    {
        final Generic saved1 = createAndSave();
        final Generic saved2 = createAndSave();

        final List<Generic> original = Arrays.asList(saved1, saved2);

        final List<Generic> found = getTestDao().findAll();

        for (int i = 0; i < original.size(); i++) {
            assertSame(original.get(i), found.get(i));
        }
    }

    protected Generic createAndSave()
    {
        final Generic original = createInstance();

        return getTestDao().save(original);
    }

    protected abstract void assertSame(Generic expected, Generic actual);

    protected abstract Generic createInstance();
}
