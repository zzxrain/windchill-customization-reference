package com.company.windchill.reference.workflow;

import wt.fc.Persistable;
import wt.workflow.work.WfAssignedActivity;
import wt.workflow.work.WorkItem;

public final class WorkItemContext {

    public static WfAssignedActivity activity(WorkItem workItem) throws Exception {
        return (WfAssignedActivity) workItem.getSource().getObject();
    }

    public static Persistable primaryBusinessObject(WorkItem workItem) throws Exception {
        return (Persistable) workItem.getPrimaryBusinessObject().getObject();
    }

    private WorkItemContext() {
    }
}
