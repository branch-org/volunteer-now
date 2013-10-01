package org.branch.volunteernow.gae.model.jdo;

import com.google.appengine.api.datastore.Key;

import javax.jdo.annotations.*;
import java.io.Serializable;

/**
 * @author Thomas Beauvais <thomas.beauvais@silbury.de>
 * @since 8/15/13
 */
@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.SUBCLASS_TABLE)
public abstract class AbstractEntityImpl implements Serializable
{
    protected AbstractEntityImpl()
    {
    }

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key id;

    public void setId(Key id)
    {
        this.id = id;
    }

    public Key getId()
    {
        return id;
    }
}
