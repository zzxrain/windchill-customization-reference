package com.company.windchill.reference.bom;

import wt.fc.PersistenceServerHelper;
import wt.part.WTPart;
import wt.part.WTPartUsageLink;
import wt.util.WTException;

public final class UsageLinkCreate {

    public static WTPartUsageLink create(
            WTPart parentWorkingCopy,
            WTPart child,
            double amount) throws WTException {

        WTPartUsageLink link = WTPartUsageLink.newWTPartUsageLink(
                parentWorkingCopy,
                child.getMaster());

        link.getQuantity().setAmount(amount);

        return (WTPartUsageLink) PersistenceServerHelper.manager.insert(link);
    }

    private UsageLinkCreate() {
    }
}
