package com.company.windchill.reference.listener;

import wt.events.KeyedEvent;
import wt.fc.PersistenceManagerEvent;
import wt.services.ManagerException;
import wt.services.ServiceEventListenerAdapter;
import wt.services.StandardManager;
import wt.util.WTException;

public final class StandardListenService extends StandardManager {

    public static StandardListenService newStandardListenService() throws WTException {
        StandardListenService instance = new StandardListenService();
        instance.initialize();
        return instance;
    }

    @Override
    protected void performStartupProcess() throws ManagerException {
        super.performStartupProcess();

        getManagerService().addEventListener(
                new ServiceEventListenerAdapter(getClass().getName()) {
                    @Override
                    public void notifyVetoableEvent(Object event) throws WTException {
                        if (!(event instanceof KeyedEvent keyedEvent)) {
                            return;
                        }

                        Object target = keyedEvent.getEventTarget();
                        // Validate the target type and business condition here.
                        // Throw WTException only when the operation must be vetoed.
                    }
                },
                PersistenceManagerEvent.generateEventKey(
                        PersistenceManagerEvent.class.getName(),
                        PersistenceManagerEvent.PRE_DELETE));
    }
}
