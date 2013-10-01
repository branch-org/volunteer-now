package org.branch.volunteernow.gae.dao.jdo;

import com.google.appengine.api.datastore.Key;
import org.branch.volunteernow.dao.Dao;
import org.branch.volunteernow.model.Entity;
import org.branch.volunteernow.gae.model.jdo.MemberProfileImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jdo.LocalPersistenceManagerFactoryBean;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.jdo.PersistenceManager;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author Thomas Beauvais <thomas.beauvais@silbury.de>
 * @since 8/15/13
 */
public class DefaultJdoDao<T extends Entity> extends AbstractJdoDao implements Dao<T>
{
    private final Class<T> persistenceClass;

    @Autowired
    public DefaultJdoDao()
    {
        final Type genericSuperclass = getClass().getGenericSuperclass();
        final ParameterizedType genericSuperclass1 = (ParameterizedType) genericSuperclass;
        final Type[] actualTypeArguments = genericSuperclass1.getActualTypeArguments();

        persistenceClass = (Class<T>) actualTypeArguments[0];
    }

    protected Class<T> getPersistenceClass()
    {
        return persistenceClass;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public T save(T object)
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
    public T findById(Key id)
    {
        final javax.jdo.Query query = getPersistenceManager().newQuery(MemberProfileImpl.class);
        query.setFilter("id == key");
        query.declareParameters(Key.class.getName() + " key");

        try
        {
            final List<T> results = (List<T>) query.execute(id);
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
