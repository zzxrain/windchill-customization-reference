package com.company.windchill.reference.security;

import wt.session.SessionServerHelper;
import wt.util.WTException;

public final class AccessEnforcementScope {

    public static void executePrivileged() throws WTException {
        boolean previous = SessionServerHelper.manager.setAccessEnforced(false);
        try {
            // privilegedOperation();
        } finally {
            SessionServerHelper.manager.setAccessEnforced(previous);
        }
    }

    private AccessEnforcementScope() {
    }
}
