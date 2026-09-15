package com.company.windchill.reference.query;

import wt.fc.PersistenceHelper;
import wt.fc.QueryResult;
import wt.inf.container.WTContainer;
import wt.query.QuerySpec;
import wt.query.SearchCondition;
import wt.util.WTException;

public final class QueryByAttribute {

    public static WTContainer findContainerByName(String name) throws WTException {
        QuerySpec query = new QuerySpec(WTContainer.class);
        query.appendWhere(
                new SearchCondition(
                        WTContainer.class,
                        WTContainer.NAME,
                        SearchCondition.EQUAL,
                        name),
                new int[]{0});

        QueryResult result = PersistenceHelper.manager.find(query);
        return result.hasMoreElements() ? (WTContainer) result.nextElement() : null;
    }

    private QueryByAttribute() {
    }
}
