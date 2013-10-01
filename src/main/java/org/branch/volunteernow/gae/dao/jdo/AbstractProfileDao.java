package org.branch.volunteernow.gae.dao.jdo;

import org.branch.volunteernow.dao.ProfileDao;
import org.branch.volunteernow.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jdo.LocalPersistenceManagerFactoryBean;
import org.springframework.stereotype.Repository;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import java.util.List;

public abstract class AbstractProfileDao<T extends Profile> extends DefaultJdoDao<T> implements ProfileDao<T>
{
    @Override
    public T findByEmail(String e)
    {
        final PersistenceManager pm = getPersistenceManager();
        final Query q = pm.newQuery(getPersistenceClass());
//        q.setFilter("email == e");
//        q.declareParameters("String e");

        try
        {
            final List<T> results = (List<T>) q.execute();
            if (!results.isEmpty())
            {
                return (T) results.get(0);
            }
            else
            {
                return null;
            }
        }
        finally
        {
            q.closeAll();
            pm.close();
        }
    }
}
