package com.company.windchill.reference.lifecycle;

import wt.lifecycle.LifeCycleManaged;
import wt.lifecycle.LifeCycleHelper;
import wt.lifecycle.State;
import wt.util.WTException;

public final class LifecycleStateChange {

    public static LifeCycleManaged setState(
            LifeCycleManaged object,
            String stateInternalName) throws WTException {

        return LifeCycleHelper.service.setLifeCycleState(
                object,
                State.toState(stateInternalName));
    }

    private LifecycleStateChange() {
    }
}
