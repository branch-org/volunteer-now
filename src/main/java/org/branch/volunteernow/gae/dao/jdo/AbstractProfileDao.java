package org.branch.volunteernow.gae.dao.jdo;

import org.branch.volunteernow.dao.ProfileDao;
import org.branch.volunteernow.model.Profile;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import java.util.List;

public abstract class AbstractProfileDao<T extends Profile> extends DefaultJdoDao<T> implements ProfileDao<T>
{
    @Override
    public T findByEmail(String email)
    {
        final PersistenceManager pm = getPersistenceManager();
        final Query q = pm.newQuery(getPersistenceClass());
        q.setFilter("email == inEmail");
        q.declareParameters("String inEmail");

        try
        {
            Object execute = q.execute(email);
            final List<T> results = (List<T>) execute;
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
