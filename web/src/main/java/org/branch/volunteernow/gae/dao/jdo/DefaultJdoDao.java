package org.branch.volunteernow.gae.dao.jdo;

import org.branch.volunteernow.gae.dao.Dao;
import org.branch.volunteernow.model.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jdo.LocalPersistenceManagerFactoryBean;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;

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
        return getPersistenceManager().makePersistent(object);
    }

//    public E get(Class<E> clazz, Key key)
//    {
//        final javax.jdo.Query query = getPersistenceManager().newQuery(clazz);
//        query.setFilter("id == key");
//        query.declareParameters(Key.class.getName() + " key");
//
//        try
//        {
//            final List<E> results = (List<E>) query.execute(key);
//            if (!results.isEmpty())
//            {
//                return results.get(0);
//            }
//            else
//            {
//                return null;
//            }
//        }
//        finally
//        {
//            query.closeAll();
//        }
//    }
//
//    public List<E> getAll(Class<E> clazz)
//    {
//        final javax.jdo.Query query = getPersistenceManager().newQuery(clazz);
//
//        return (List<E>) query.execute();
//    }
}
