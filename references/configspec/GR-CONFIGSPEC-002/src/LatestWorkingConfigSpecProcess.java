package com.company.windchill.reference.configspec;

import wt.fc.QueryResult;
import wt.util.WTException;
import wt.vc.config.LatestConfigSpec;

public final class LatestWorkingConfigSpecProcess {

    private LatestWorkingConfigSpecProcess() {
    }

    public static QueryResult process(QueryResult candidates) throws WTException {
        if (candidates == null || !candidates.hasMoreElements()) {
            return candidates;
        }
        return new LatestConfigSpec().process(candidates);
    }
}
