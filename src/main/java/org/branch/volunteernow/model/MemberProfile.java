package org.branch.volunteernow.model;

import javax.jdo.annotations.PersistenceCapable;

/**
 * @author Thomas Beauvais <thomas.beauvais@silbury.de>
 * @since 8/15/13
 */
public interface MemberProfile extends Profile
{
    String getFirstName();

    void setFirstName(String bruce);
}
