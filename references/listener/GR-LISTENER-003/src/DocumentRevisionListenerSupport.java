package com.company.windchill.reference.listener;

import wt.doc.WTDocument;
import wt.events.KeyedEvent;
import wt.fc.Iterated;
import wt.vc.VersionControlHelper;
import wt.vc.VersionControlServiceEvent;

public final class DocumentRevisionListenerSupport {

    public static void onNewVersion(KeyedEvent event) throws Exception {
        if (!(event instanceof VersionControlServiceEvent)) {
            return;
        }

        Iterated target = ((VersionControlServiceEvent) event).getIteration();
        if (!(target instanceof WTDocument)) {
            return;
        }

        WTDocument current = (WTDocument) target;

        // 仅在业务确实需要 predecessor 时获取。
        Object predecessorRef = VersionControlHelper.getPredecessor(current);
        if (predecessorRef != null) {
            Object previous = ((wt.fc.ObjectReference) predecessorRef).getObject();
            // compare / validate previous vs current
        }
    }

    private DocumentRevisionListenerSupport() {
    }
}
