package com.company.windchill.reference.listener;

import wt.events.KeyedEvent;
import wt.fc.PersistenceManagerEvent;
import wt.part.WTPart;
import wt.services.ServiceEventListenerAdapter;
import wt.vc.wip.WorkInProgressServiceEvent;

public class GenericListener extends ServiceEventListenerAdapter {

    public GenericListener(String managerName) {
        super(managerName);
    }

    @Override
    public void notifyVetoableEvent(Object event) throws Exception {
        if (!(event instanceof KeyedEvent)) {
            return;
        }

        KeyedEvent keyedEvent = (KeyedEvent) event;
        Object target = keyedEvent.getEventTarget();

        if (WorkInProgressServiceEvent.POST_CHECKIN.equals(keyedEvent.getEventType())
                && target instanceof WTPart) {
            onPartPostCheckin((WTPart) target);
            return;
        }

        if (PersistenceManagerEvent.POST_MODIFY.equals(keyedEvent.getEventType())
                && target instanceof WTPart) {
            onPartPostModify((WTPart) target);
        }
    }

    private void onPartPostCheckin(WTPart part) throws Exception {
        // Keep listener work small; enqueue heavy work when appropriate.
    }

    private void onPartPostModify(WTPart part) throws Exception {
        // Avoid recursive modification loops.
    }
}
