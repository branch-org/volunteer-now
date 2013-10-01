package org.branch.volunteernow.gae.dao.jdo;

import org.branch.volunteernow.dao.OrganizationProfileDao;
import org.branch.volunteernow.gae.model.jdo.OrganizationProfileImpl;
import org.branch.volunteernow.model.OrganizationProfile;
import org.springframework.orm.jdo.LocalPersistenceManagerFactoryBean;
import org.springframework.stereotype.Repository;

/**
 * Concrete implementations are welcome here.  This is to properly use the Java Generics all of the way through the
 * hierarchy and with the JDO implementation.
 *
 * @author Thomas Beauvais <thomas.beauvais@silbury.de>
 * @since 8/15/13
 */
@Repository
public class OrganizationProfileDaoImpl<T extends OrganizationProfileImpl> extends AbstractProfileDao<OrganizationProfileImpl> implements OrganizationProfileDao<OrganizationProfileImpl>
{
}
