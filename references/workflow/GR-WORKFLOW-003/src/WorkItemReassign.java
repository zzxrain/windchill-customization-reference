package com.company.windchill.reference.workflow;

import wt.org.WTPrincipal;
import wt.util.WTException;
import wt.workflow.work.WorkItem;
import wt.workflow.work.WorkflowHelper;

public final class WorkItemReassign {

    private WorkItemReassign() {
    }

    public static void reassign(WorkItem workItem, WTPrincipal targetPrincipal)
            throws WTException {
        WorkflowHelper.service.delegate(workItem, targetPrincipal);
    }
}
