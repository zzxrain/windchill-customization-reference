package com.company.windchill.reference.security;

import wt.org.WTPrincipal;
import wt.session.SessionHelper;
import wt.util.WTException;

public final class PrincipalScope {

    public static void executeAsAdministrator() throws WTException {
        WTPrincipal previous = SessionHelper.manager.getPrincipal();
        try {
            SessionHelper.manager.setAdministrator();

            // administrativeOperation();

        } finally {
            if (previous != null) {
                SessionHelper.manager.setPrincipal(previous.getName());
            }
        }
    }

    private PrincipalScope() {
    }
}
