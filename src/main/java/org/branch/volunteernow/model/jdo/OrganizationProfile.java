package org.branch.volunteernow.model.jdo;

import org.branch.volunteernow.model.Profile;

import javax.jdo.annotations.*;

/**
 * @author Thomas Beauvais <thomas.beauvais@silbury.de>
 * @since 8/15/13
 */
//@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class OrganizationProfile extends AbstractEntity implements Profile
{
    @Persistent
    private String name;

    @Persistent
    private String email;

    @Persistent
    private String mission;

    public OrganizationProfile()
    {
    }

    public String getMission()
    {
        return mission;
    }

    public void setMission(String mission)
    {
        this.mission = mission;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Override
    public String getEmail()
    {
        return this.email;
    }

    @Override
    public String getDisplayName()
    {
        return getName();
    }
}
