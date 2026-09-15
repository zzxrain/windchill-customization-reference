package com.company.windchill.reference.bom;

import java.util.ArrayList;
import java.util.List;

import wt.fc.Persistable;
import wt.fc.QueryResult;
import wt.part.WTPart;
import wt.part.WTPartConfigSpec;
import wt.part.WTPartHelper;
import wt.part.WTPartUsageLink;
import wt.util.WTException;

public final class BomTraversal {

    public static List<WTPartUsageLink> directUsageLinks(
            WTPart parent,
            WTPartConfigSpec configSpec) throws WTException {

        List<WTPartUsageLink> links = new ArrayList<>();
        QueryResult result = WTPartHelper.service.getUsesWTParts(parent, configSpec);

        while (result.hasMoreElements()) {
            Persistable[] row = (Persistable[]) result.nextElement();
            links.add((WTPartUsageLink) row[0]);
        }

        return links;
    }

    private BomTraversal() {
    }
}
