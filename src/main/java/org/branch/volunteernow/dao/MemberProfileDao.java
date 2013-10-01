package org.branch.volunteernow.dao;

import org.branch.volunteernow.model.MemberProfile;

/**
 * @author Thomas Beauvais <thomas.beauvais@silbury.de>
 * @since 8/15/13
 */
public interface MemberProfileDao<T extends MemberProfile> extends ProfileDao<T>
{
    T findMemberByTest();
}
