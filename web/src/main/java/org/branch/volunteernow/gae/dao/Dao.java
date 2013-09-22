package org.branch.volunteernow.gae.dao;

import com.google.appengine.api.datastore.Key;
import org.branch.volunteernow.model.Entity;

import java.util.List;

/**
 * @author Thomas Beauvais <thomas.beauvais@silbury.de>
 * @since 8/15/13
 */
//public interface Dao<T extends Entity, E extends T>
public interface Dao<T extends Entity>
{
    <E extends T> E save(E entity);

//    <E extends T> List<E> getAll(Class<E> clazz);
//
//    <E extends T> E get(Class<E> clazz, Key id);
}
