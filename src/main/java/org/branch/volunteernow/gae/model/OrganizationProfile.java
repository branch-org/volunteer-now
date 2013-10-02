package org.branch.volunteernow.gae.model;

import javax.jdo.annotations.*;

/**
 * @author Thomas Beauvais <thomas.beauvais@silbury.de>
 * @since 8/15/13
 */
@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class OrganizationProfile extends Profile
{
    @Persistent
    private String name;

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
}
