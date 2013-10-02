package org.branch.volunteernow.gae.dao;

import org.branch.volunteernow.gae.model.OrganizationProfile;
import org.springframework.stereotype.Repository;

/**
 * Concrete implementations are welcome here.  This is to properly use the Java Generics all of the way through the
 * hierarchy and with the JDO implementation.
 *
 * @author Thomas Beauvais <thomas.beauvais@silbury.de>
 * @since 8/15/13
 */
@Repository
public class OrganizationProfileJdoDao<T extends OrganizationProfile> extends AbstractProfileJdoDao<OrganizationProfile>
{
    public OrganizationProfileJdoDao()
    {
    }
}
