package org.branch.volunteernow.gae.model;

import javax.jdo.annotations.*;

@PersistenceCapable
public class MemberProfile extends Profile
{
    @Persistent
    private String email;

    @Persistent
    private String lastName;

    @Persistent
    private String firstName;

    @Persistent(dependent = "true", defaultFetchGroup="true")
    private Address primaryAddress = new Address();

    public MemberProfile()
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

    public String getEmail()
    {
        return email;
    }

    public String getDisplayName()
    {
        return getFirstName();
    }

    public Address getPrimaryAddress()
    {
        return primaryAddress;
    }

    public void setPrimaryAddress(Address primaryAddress)
    {
        this.primaryAddress = primaryAddress;
    }
}
