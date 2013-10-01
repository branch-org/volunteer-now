package org.branch.volunteernow.dao;

import org.branch.volunteernow.model.Profile;

/**
 * @author Thomas Beauvais <thomas.beauvais@silbury.de>
 * @since 8/15/13
 */
public interface ProfileDao<T extends Profile> extends Dao<T>
{
    T findByEmail(String email);
}
