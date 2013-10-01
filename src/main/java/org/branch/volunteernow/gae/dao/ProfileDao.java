package org.branch.volunteernow.gae.dao;

import org.branch.volunteernow.model.Profile;

/**
 * @author Thomas Beauvais <thomas.beauvais@silbury.de>
 * @since 8/15/13
 */
//public interface ProfileDao<T extends Profile, E extends T> extends Dao<T, E>
public interface ProfileDao extends Dao<Profile>
{
    <E extends Profile> E findByEmail(String email);
}
