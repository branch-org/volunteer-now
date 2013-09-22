package org.branch.volunteernow.gae.dao.jdo;

import org.branch.volunteernow.gae.dao.ProfileDao;
import org.branch.volunteernow.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jdo.LocalPersistenceManagerFactoryBean;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileJdoDao extends DefaultJdoDao<Profile> implements ProfileDao
{
    @Autowired
    public ProfileJdoDao(LocalPersistenceManagerFactoryBean persistenceManagerFactory)
    {
        super(persistenceManagerFactory);
    }

    @Override
    public <E extends Profile> E getProfileForEmail(String email)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
