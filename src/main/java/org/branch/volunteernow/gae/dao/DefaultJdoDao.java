package org.branch.volunteernow.gae.dao;

import com.google.appengine.api.datastore.Key;
import org.branch.volunteernow.gae.model.AbstractEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author Thomas Beauvais <thomas.beauvais@silbury.de>
 * @since 8/15/13
 */
public class DefaultJdoDao<T extends AbstractEntity> extends AbstractJdoDao
{
    private final Class<T> persistenceClass;

    @Autowired
    public DefaultJdoDao()
    {
        final Type genericSuperclass = getClass().getGenericSuperclass();
        final ParameterizedType parameterizedType;
        if (genericSuperclass instanceof ParameterizedType) {
            parameterizedType = (ParameterizedType) genericSuperclass;
        } else if (genericSuperclass instanceof Class) {
            parameterizedType = (ParameterizedType) ((Class<T>) genericSuperclass).getGenericSuperclass();
        } else {
            throw new RuntimeException("The DAO isn't properly parametrized.  Please see examples and fix hierarchy.");
        }

        final Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();

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
    public T findById(Key id)
    {
        final PersistenceManager pm = getPersistenceManager();

        try
        {
            return (T) pm.getObjectById(getPersistenceClass(), id);
        }
        finally
        {
            pm.close();
        }
    }

    public List<T> findAll()
    {
        return findAll(getPersistenceClass());
    }

    public List<T> findAll(Class<? extends T> clazz)
    {
        final PersistenceManager pm = getPersistenceManager();

        try
        {
            final Query q = pm.newQuery(getPersistenceClass());

            return (List<T>) q.execute();
        }
        finally
        {
            pm.close();
        }
    }
}
