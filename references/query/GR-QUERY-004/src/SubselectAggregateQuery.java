package com.company.windchill.reference.query;

import java.sql.Timestamp;

import wt.util.WTAttributeNameIfc;
import wt.part.WTPartMaster;
import wt.query.ClassAttribute;
import wt.query.DateExpression;
import wt.query.QuerySpec;
import wt.query.SQLFunction;
import wt.query.SearchCondition;
import wt.query.SubSelectExpression;
import wt.util.WTException;

/**
 * Aggregate + subselect pattern based on the Customization Guide.
 */
public final class SubselectAggregateQuery {

    private SubselectAggregateQuery() {
    }

    public static QuerySpec oldestModifiedAfter(Timestamp cutoff) throws WTException {
        Class<?> targetClass = WTPartMaster.class;

        QuerySpec subSelect = new QuerySpec();
        subSelect.getFromClause().setAliasPrefix("B");
        int subIndex = subSelect.appendClassList(targetClass, false);

        ClassAttribute subModifyStamp = new ClassAttribute(
                targetClass,
                WTAttributeNameIfc.MODIFY_STAMP_NAME);

        SQLFunction minimum = SQLFunction.newSQLFunction(
                SQLFunction.MINIMUM,
                subModifyStamp);

        subSelect.appendSelect(minimum, new int[]{subIndex}, false);
        subSelect.appendWhere(
                new SearchCondition(
                        subModifyStamp,
                        SearchCondition.GREATER_THAN,
                        DateExpression.newExpression(cutoff)),
                new int[]{subIndex});

        QuerySpec outer = new QuerySpec();
        int outerIndex = outer.appendClassList(targetClass, true);
        ClassAttribute outerModifyStamp = new ClassAttribute(
                targetClass,
                WTAttributeNameIfc.MODIFY_STAMP_NAME);

        outer.appendWhere(
                new SearchCondition(
                        outerModifyStamp,
                        SearchCondition.IN,
                        new SubSelectExpression(subSelect)),
                new int[]{outerIndex});

        return outer;
    }
}
