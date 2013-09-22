package org.branch.volunteernow.model.jdo;

import org.branch.volunteernow.model.Profile;

import javax.jdo.annotations.*;

/**
 * @author Thomas Beauvais <thomas.beauvais@silbury.de>
 * @since 8/15/13
 */
@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class OrganizationProfile extends AbstractEntity implements Profile
{
    @Persistent
    private String name;

    public OrganizationProfile()
    {
    }

    @Persistent
    private String mission;

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
}
