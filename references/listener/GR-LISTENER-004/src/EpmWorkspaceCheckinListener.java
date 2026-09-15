package com.company.windchill.reference.listener;

import com.ptc.xworks.windchill.listener.VetoableEventListener;

import wt.epm.EPMDocument;
import wt.epm.workspaces.EPMWorkspaceManagerEvent;
import wt.events.KeyedEvent;
import wt.vc.VersionControlServiceEvent;

public class EpmWorkspaceCheckinListener implements VetoableEventListener {

    private static final String[] EVENTS = {
            VersionControlServiceEvent.generateEventKey(
                    EPMWorkspaceManagerEvent.POST_WORKSPACE_CHECKIN)
    };

    @Override
    public String[] eventKeyToListen() {
        return EVENTS;
    }

    @Override
    public boolean acceptEventTarget(Object target) {
        return target instanceof EPMDocument;
    }

    @Override
    public void notifyVetoableEvent(KeyedEvent event) throws Exception {
        if (!EPMWorkspaceManagerEvent.POST_WORKSPACE_CHECKIN.equals(event.getEventType())) {
            return;
        }

        EPMDocument epm = (EPMDocument) event.getEventTarget();
        // Validate type / attributes, then perform the minimum required action.
    }
}
