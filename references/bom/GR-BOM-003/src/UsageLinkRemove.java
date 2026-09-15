package com.company.windchill.reference.bom;

import wt.fc.Persistable;
import wt.fc.PersistenceServerHelper;
import wt.fc.QueryResult;
import wt.part.WTPart;
import wt.part.WTPartConfigSpec;
import wt.part.WTPartHelper;
import wt.part.WTPartUsageLink;
import wt.util.WTException;

public final class UsageLinkRemove {

    public static void removeByComponentId(
            WTPart parentWorkingCopy,
            WTPartConfigSpec configSpec,
            String componentId) throws WTException {

        QueryResult result = WTPartHelper.service.getUsesWTParts(
                parentWorkingCopy,
                configSpec);

        while (result.hasMoreElements()) {
            Persistable[] row = (Persistable[]) result.nextElement();
            WTPartUsageLink link = (WTPartUsageLink) row[0];

            if (componentId.equals(link.getComponentId())) {
                PersistenceServerHelper.manager.remove(link);
                return;
            }
        }
    }

    private UsageLinkRemove() {
    }
}
