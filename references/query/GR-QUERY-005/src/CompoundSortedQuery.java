package com.company.windchill.reference.query;

import wt.doc.WTDocument;
import wt.part.WTPart;
import wt.query.ClassAttribute;
import wt.query.CompoundQuerySpec;
import wt.query.OrderBy;
import wt.query.QuerySpec;
import wt.query.SetOperator;
import wt.util.WTException;

/**
 * Demonstrates how to keep compound-query select lists and sorting aligned.
 * Execution is intentionally not included because advanced-query execution
 * has important access-control implications.
 */
public final class CompoundSortedQuery {

    private CompoundSortedQuery() {
    }

    public static CompoundQuerySpec build() throws WTException {
        String alias = "sortName";

        QuerySpec partQuery = new QuerySpec();
        int partIndex = partQuery.appendClassList(WTPart.class, false);
        ClassAttribute partName = new ClassAttribute(WTPart.class, WTPart.NAME);
        partName.setColumnAlias(alias);
        partQuery.appendSelect(partName, new int[]{partIndex}, false);

        QuerySpec docQuery = new QuerySpec();
        int docIndex = docQuery.appendClassList(WTDocument.class, false);
        ClassAttribute docName = new ClassAttribute(WTDocument.class, WTDocument.NAME);
        docName.setColumnAlias(alias);
        docQuery.appendSelect(docName, new int[]{docIndex}, false);

        CompoundQuerySpec query = new CompoundQuerySpec();
        query.setSetOperator(SetOperator.UNION);
        query.addComponent(partQuery);
        query.addComponent(docQuery);
        query.appendOrderBy(new OrderBy(partName, true));

        return query;
    }
}
