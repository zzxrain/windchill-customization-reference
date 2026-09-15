package com.company.windchill.reference.bom;

import wt.part.WTPartUsageLink;

public final class UsageLinkQuantityCopy {

    public static void copyQuantity(WTPartUsageLink source, WTPartUsageLink target) {
        target.getQuantity().setAmount(source.getQuantity().getAmount());
        target.getQuantity().setUnit(source.getQuantity().getUnit());
    }

    private UsageLinkQuantityCopy() {
    }
}
