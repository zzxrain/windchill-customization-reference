package com.company.windchill.reference.resource;

import wt.util.resource.RBEntry;
import wt.util.resource.RBUUID;
import wt.util.resource.WTListResourceBundle;

@RBUUID("com.company.windchill.reference.resource.ReferenceUIResource")
public final class ReferenceUIResource extends WTListResourceBundle {

    @RBEntry("Reference Objects")
    public static final String TABLE_LABEL = "reference.table.label";

    @RBEntry("The requested operation is not permitted.")
    public static final String OPERATION_DENIED = "reference.operation.denied";
}
