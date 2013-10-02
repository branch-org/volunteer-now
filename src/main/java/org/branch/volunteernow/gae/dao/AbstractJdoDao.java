package org.branch.volunteernow.gae.dao;

import org.springframework.beans.factory.annotation.Autowired;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

/**
 * @author Thomas Beauvais <thomas.beauvais@silbury.de>
 * @since 8/15/13
 */
public abstract class AbstractJdoDao
{

    public static final String PERSISTENCE_UNIT = "persistence-unit";

    @Autowired
    private PersistenceManagerFactory persistenceManagerFactory;

    protected PersistenceManager getPersistenceManager()
    {
        return persistenceManagerFactory.getPersistenceManager();
    }
}
