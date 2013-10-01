package org.branch.volunteernow.gae.dao.jdo;

import org.branch.volunteernow.dao.MemberProfileDao;
import org.branch.volunteernow.gae.model.jdo.MemberProfileImpl;
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
public class MemberProfileDaoImpl<T extends MemberProfileImpl> extends AbstractProfileDao<MemberProfileImpl> implements MemberProfileDao<MemberProfileImpl>
{
    @Override
    public T findMemberByTest()
    {
        return null;
    }
}
