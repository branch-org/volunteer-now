package org.branch.volunteernow.gae.dao.jdo;

import org.branch.volunteernow.gae.dao.ProfileDao;
import org.branch.volunteernow.model.Profile;
import org.branch.volunteernow.model.jdo.AbstractEntity;
import org.branch.volunteernow.model.jdo.MemberProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jdo.LocalPersistenceManagerFactoryBean;
import org.springframework.stereotype.Repository;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import java.util.List;

@Repository
public class ProfileJdoDao extends DefaultJdoDao<Profile> implements ProfileDao
{
    @Autowired
    public ProfileJdoDao(LocalPersistenceManagerFactoryBean persistenceManagerFactory)
    {
        super(persistenceManagerFactory);
    }

    @Override
    public <E extends Profile> E findByEmail(String e)
    {
        final PersistenceManager pm = getPersistenceManager();
        final Query q = pm.newQuery(MemberProfile.class);
//        q.setFilter("email == e");
//        q.declareParameters("String e");

        try
        {
//            final List<MemberProfile> results = (List<MemberProfile>) q.execute(e);
            final List<MemberProfile> results = (List<MemberProfile>) q.execute();
            if (!results.isEmpty())
            {
                return (E) results.get(0);
            }
            else
            {
                return null;
            }
        }
        finally
        {
            q.closeAll();
//            pm.close();
        }
    }
}
