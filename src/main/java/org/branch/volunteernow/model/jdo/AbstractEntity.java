package org.branch.volunteernow.model.jdo;

import com.google.appengine.api.datastore.Key;

import javax.jdo.annotations.*;

/**
 * @author Thomas Beauvais <thomas.beauvais@silbury.de>
 * @since 8/15/13
 */
@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.SUBCLASS_TABLE)
public abstract class AbstractEntity
{
    protected AbstractEntity()
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
