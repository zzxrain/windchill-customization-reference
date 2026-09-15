package com.company.windchill.reference.listener;

import wt.events.KeyedEventListener;
import wt.fc.PersistenceManagerEvent;
import wt.services.ManagerException;
import wt.services.StandardManager;
import wt.vc.wip.WorkInProgressServiceEvent;

public class StandardListenerService extends StandardManager {

    @Override
    protected synchronized void performStartupProcess() throws ManagerException {
        super.performStartupProcess();

        KeyedEventListener listener = new GenericListener(getClass().getName());

        getManagerService().addEventListener(
                listener,
                WorkInProgressServiceEvent.generateEventKey(
                        WorkInProgressServiceEvent.POST_CHECKIN));

        getManagerService().addEventListener(
                listener,
                PersistenceManagerEvent.generateEventKey(
                        PersistenceManagerEvent.POST_MODIFY));
    }
}
