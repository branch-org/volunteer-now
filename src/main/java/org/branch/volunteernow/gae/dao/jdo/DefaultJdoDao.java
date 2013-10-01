package org.branch.volunteernow.gae.dao.jdo;

import com.google.appengine.api.datastore.Key;
import org.branch.volunteernow.gae.dao.Dao;
import org.branch.volunteernow.model.Entity;
import org.branch.volunteernow.model.jdo.MemberProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jdo.LocalPersistenceManagerFactoryBean;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.jdo.PersistenceManager;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author Thomas Beauvais <thomas.beauvais@silbury.de>
 * @since 8/15/13
 */
public class DefaultJdoDao<T extends Entity> extends AbstractJdoDao implements Dao<T>
{
    private final Class<T> persistentClass;

    @Autowired
    public DefaultJdoDao(LocalPersistenceManagerFactoryBean persistenceManagerFactory)
    {
        super(persistenceManagerFactory);

        persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public <E extends T> E save(E object)
    {
        final PersistenceManager pm = getPersistenceManager();

        try
        {
            return pm.makePersistent(object);
        }
        finally
        {
            pm.close();
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public <E extends T> E findById(Key id)
    {
        final javax.jdo.Query query = getPersistenceManager().newQuery(MemberProfile.class);
        query.setFilter("id == key");
        query.declareParameters(Key.class.getName() + " key");

        try
        {
            final List<E> results = (List<E>) query.execute(id);
            if (!results.isEmpty())
            {
                return results.get(0);
            }
            else
            {
                return null;
            }
        }
        finally
        {
            query.closeAll();
        }
    }
//
//    public List<E> getAll(Class<E> clazz)
//    {
//        final javax.jdo.Query query = getPersistenceManager().newQuery(clazz);
//
//        return (List<E>) query.execute();
//    }
}
