package org.branch.volunteernow.model.jdo;

import org.branch.volunteernow.model.Profile;

import javax.jdo.annotations.*;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class MemberProfile extends AbstractEntity implements Profile
{
    public MemberProfile()
    {
    }

    @Persistent
    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
