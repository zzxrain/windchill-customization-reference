package com.company.windchill.reference.queue;

import wt.session.SessionContext;
import wt.session.SessionHelper;
import wt.session.SessionServerHelper;
import wt.util.WTException;

/**
 * Two scope patterns documented by PTC for Queue Service calls.
 */
public final class QueueSecurityScope {

    private QueueSecurityScope() {
    }

    public static void runAsAdministrator(QueueOperation operation) throws WTException {
        SessionContext previous = SessionContext.newContext();
        try {
            SessionHelper.manager.setAdministrator();
            operation.run();
        } finally {
            SessionContext.setContext(previous);
        }
    }

    public static void runWithoutAccessEnforcement(QueueOperation operation) throws WTException {
        boolean previous = SessionServerHelper.manager.setAccessEnforced(false);
        try {
            operation.run();
        } finally {
            SessionServerHelper.manager.setAccessEnforced(previous);
        }
    }

    @FunctionalInterface
    public interface QueueOperation {
        void run() throws WTException;
    }
}
