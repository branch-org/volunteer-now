package org.branch.volunteernow.gae.dao.jdo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jdo.LocalPersistenceManagerFactoryBean;

import javax.jdo.PersistenceManager;
import java.lang.reflect.ParameterizedType;

/**
 * @author Thomas Beauvais <thomas.beauvais@silbury.de>
 * @since 8/15/13
 */
public abstract class AbstractJdoDao
{
    private LocalPersistenceManagerFactoryBean persistenceManagerFactoryBean;

    @Autowired
    protected AbstractJdoDao(LocalPersistenceManagerFactoryBean persistenceManagerFactory)
    {
        this.persistenceManagerFactoryBean = persistenceManagerFactory;
    }

    protected PersistenceManager getPersistenceManager()
    {
        return persistenceManagerFactoryBean.getObject().getPersistenceManager();
    }
}
