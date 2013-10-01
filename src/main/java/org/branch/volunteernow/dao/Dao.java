package org.branch.volunteernow.dao;

import com.google.appengine.api.datastore.Key;
import org.branch.volunteernow.model.Entity;

import java.util.List;

/**
 * @author Thomas Beauvais <thomas.beauvais@silbury.de>
 * @since 8/15/13
 */
public interface Dao<T extends Entity>
{
    T save(T entity);

    T findById(Key id);

    List<T> findAll(Class<? extends T> clazz);

    List<T> findAll();
}
