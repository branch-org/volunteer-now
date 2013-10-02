package org.branch.volunteernow.gae.dao;

import org.branch.volunteernow.gae.model.Profile;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import java.util.List;

public abstract class AbstractProfileJdoDao<T extends Profile> extends DefaultJdoDao<T>
{
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
