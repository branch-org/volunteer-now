package org.branch.volunteernow.gae.model.jdo;

import org.branch.volunteernow.model.MemberProfile;

import javax.jdo.annotations.*;

//@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class MemberProfileImpl extends AbstractEntityImpl implements MemberProfile
{
    @Persistent
    @Unique
    private String email;

    @Persistent
    private String lastName;

    @Persistent
    private String firstName;

    public MemberProfileImpl()
    {
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String name)
    {
        this.firstName = name;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getLastName()
    {
        return lastName;
    }

    @Override
    public String getEmail()
    {
        return email;
    }

    @Override
    public String getDisplayName()
    {
        return getFirstName();
    }
}
