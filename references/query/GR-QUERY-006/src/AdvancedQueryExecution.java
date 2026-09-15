package com.company.windchill.reference.query;

import wt.fc.PersistenceHelper;
import wt.fc.QueryResult;
import wt.query.QuerySpec;
import wt.util.WTException;

/**
 * High-risk execution boundary for an advanced QuerySpec.
 *
 * Do not use this helper as a general replacement for PersistenceHelper.manager.find().
 * The caller must explicitly review access-control implications.
 */
public final class AdvancedQueryExecution {

    private AdvancedQueryExecution() {
    }

    public static QueryResult executeReviewedAdvancedQuery(QuerySpec query)
            throws WTException {
        query.setAdvancedQueryEnabled(true);
        return PersistenceHelper.manager.query(query);
    }
}
