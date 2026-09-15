package com.company.windchill.reference.query;

import java.util.ArrayList;
import java.util.List;

import wt.fc.Persistable;
import wt.fc.QueryResult;
import wt.util.WTException;

public final class QueryResultIteration {

    public static <T extends Persistable> List<T> collect(QueryResult result, Class<T> type)
            throws WTException {

        List<T> values = new ArrayList<>();

        while (result.hasMoreElements()) {
            Object row = result.nextElement();

            // 部分多表 Select / QuerySpec 返回 Persistable[]；单类查询通常直接返回对象。
            Object candidate = row instanceof Persistable[] ? ((Persistable[]) row)[0] : row;

            if (type.isInstance(candidate)) {
                values.add(type.cast(candidate));
            }
        }

        return values;
    }

    private QueryResultIteration() {
    }
}
