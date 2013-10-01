package org.branch.volunteernow.gae.model.jdo;

import org.branch.volunteernow.model.OrganizationProfile;

import javax.jdo.annotations.*;

/**
 * @author Thomas Beauvais <thomas.beauvais@silbury.de>
 * @since 8/15/13
 */
@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class OrganizationProfileImpl extends AbstractEntityImpl implements OrganizationProfile
{
    @Persistent
    private String name;

    @Persistent
    private String email;

    @Persistent
    private String mission;

    public OrganizationProfileImpl()
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
