package org.branch.volunteernow.dao;

import com.google.appengine.api.datastore.Key;
import org.branch.volunteernow.model.Entity;

/**
 * @author Thomas Beauvais <thomas.beauvais@silbury.de>
 * @since 8/15/13
 */
public interface Dao<T extends Entity>
{
    T save(T entity);

    T findById(Key id);

//    <E extends T> List<E> getAll(Class<E> clazz);
//
//    <E extends T> E get(Class<E> clazz, Key id);
}
