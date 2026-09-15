package com.company.windchill.reference.xworks;

import com.ptc.xworks.windchill.listener.VetoableEventListener;

import wt.events.KeyedEvent;
import wt.fc.PersistenceManagerEvent;
import wt.part.WTPartUsageLink;

public class UsageLinkVetoableListener implements VetoableEventListener {

    private static final String[] EVENTS = {
            PersistenceManagerEvent.generateEventKey(PersistenceManagerEvent.PRE_INSERT),
            PersistenceManagerEvent.generateEventKey(PersistenceManagerEvent.PRE_DELETE),
            PersistenceManagerEvent.generateEventKey(PersistenceManagerEvent.POST_MODIFY)
    };

    @Override
    public String[] eventKeyToListen() {
        return EVENTS;
    }

    @Override
    public boolean acceptEventTarget(Object target) {
        return target instanceof WTPartUsageLink;
    }

    @Override
    public void notifyVetoableEvent(KeyedEvent event) throws Exception {
        WTPartUsageLink link = (WTPartUsageLink) event.getEventTarget();

        if (PersistenceManagerEvent.PRE_INSERT.equals(event.getEventType())) {
            // Validate insertion. Throw only when the business rule truly vetoes the operation.
        }
    }
}
