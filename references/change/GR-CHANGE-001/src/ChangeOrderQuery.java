package com.company.windchill.reference.change;

import java.util.ArrayList;
import java.util.List;

import wt.change2.WTChangeOrder2;
import wt.fc.PersistenceHelper;
import wt.fc.QueryResult;
import wt.query.QuerySpec;
import wt.query.SearchCondition;
import wt.util.WTException;

/**
 * Standard QuerySpec example for querying change orders by number pattern.
 *
 * <p>The pattern is supplied by the caller, for example {@code "CO2026%"}.
 * Keep the pattern as narrow as the business scenario allows to avoid an
 * unnecessarily broad query.</p>
 */
public final class ChangeOrderQuery {

    public static List<WTChangeOrder2> byNumberPattern(String numberPattern) throws WTException {
        QuerySpec querySpec = new QuerySpec(WTChangeOrder2.class);
        querySpec.appendWhere(
                new SearchCondition(
                        WTChangeOrder2.class,
                        WTChangeOrder2.NUMBER,
                        SearchCondition.LIKE,
                        numberPattern),
                new int[]{0});

        QueryResult result = PersistenceHelper.manager.find(querySpec);
        List<WTChangeOrder2> values = new ArrayList<>();

        while (result.hasMoreElements()) {
            values.add((WTChangeOrder2) result.nextElement());
        }

        return values;
    }

    private ChangeOrderQuery() {
    }
}
