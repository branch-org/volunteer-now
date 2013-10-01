package org.branch.volunteernow.gae.dao.jdo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jdo.LocalPersistenceManagerFactoryBean;
import sun.rmi.transport.ObjectTable;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import java.lang.reflect.ParameterizedType;

/**
 * @author Thomas Beauvais <thomas.beauvais@silbury.de>
 * @since 8/15/13
 */
public abstract class AbstractJdoDao
{

    public static final String PERSISTENCE_UNIT = "persistence-unit";

    protected PersistenceManager getPersistenceManager()
    {
        return JDOHelper.getPersistenceManagerFactory(PERSISTENCE_UNIT).getPersistenceManager();
    }
}
