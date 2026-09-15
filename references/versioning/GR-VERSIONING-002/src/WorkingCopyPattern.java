package com.company.windchill.reference.versioning;

import wt.fc.Persistable;
import wt.util.WTException;
import wt.vc.wip.WorkInProgressHelper;
import wt.vc.wip.Workable;

public final class WorkingCopyPattern {

    public static Workable workingCopy(Workable object, String checkoutComment) throws WTException {
        if (!WorkInProgressHelper.isCheckedOut(object)) {
            return (Workable) WorkInProgressHelper.service
                    .checkout(
                            object,
                            WorkInProgressHelper.service.getCheckoutFolder(),
                            checkoutComment)
                    .getWorkingCopy();
        }

        if (WorkInProgressHelper.isWorkingCopy(object)) {
            return object;
        }

        return (Workable) WorkInProgressHelper.service.workingCopyOf(object);
    }

    public static Persistable checkin(Workable workingCopy, String comment) throws WTException {
        return (Persistable) WorkInProgressHelper.service.checkin(workingCopy, comment);
    }

    private WorkingCopyPattern() {
    }
}
