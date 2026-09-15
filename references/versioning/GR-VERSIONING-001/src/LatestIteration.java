package com.company.windchill.reference.versioning;

import wt.vc.Iterated;
import wt.util.WTException;
import wt.vc.VersionControlHelper;

public final class LatestIteration {

    public static <T extends Iterated> T ensureLatestIteration(T object) throws WTException {
        if (object.isLatestIteration()) {
            return object;
        }

        @SuppressWarnings("unchecked")
        T latest = (T) VersionControlHelper.service.getLatestIteration(object, false);
        return latest;
    }

    private LatestIteration() {
    }
}
