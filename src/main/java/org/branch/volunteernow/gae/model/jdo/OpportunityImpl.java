package org.branch.volunteernow.gae.model.jdo;

/**
 * @author Thomas Beauvais <thomas.beauvais@silbury.de>
 * @since 8/15/13
 */
public class OpportunityImpl
{
    private final String description;

    private final String location;

    private final String organization;

    private final String title;

    public OpportunityImpl(String title, String organization, String location, String description)
    {
        this.title = title;
        this.organization = organization;
        this.location = location;
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }

    public String getLocation()
    {
        return location;
    }

    public String getOrganization()
    {
        return organization;
    }

    public String getTitle()
    {
        return title;
    }
}