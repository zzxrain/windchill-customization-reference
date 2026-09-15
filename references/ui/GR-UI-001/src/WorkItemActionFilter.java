package com.company.windchill.reference.ui;

import com.ptc.core.ui.validation.DefaultSimpleValidationFilter;
import com.ptc.core.ui.validation.UIValidationCriteria;
import com.ptc.core.ui.validation.UIValidationKey;
import com.ptc.core.ui.validation.UIValidationStatus;

import wt.workflow.work.WfAssignedActivity;
import wt.workflow.work.WorkItem;

public class WorkItemActionFilter extends DefaultSimpleValidationFilter {

    @Override
    public UIValidationStatus preValidateAction(
            UIValidationKey key,
            UIValidationCriteria criteria) {

        Object context = criteria.getContextObject().getObject();

        if (!(context instanceof WorkItem)) {
            return UIValidationStatus.ENABLED;
        }

        try {
            WorkItem workItem = (WorkItem) context;
            WfAssignedActivity activity =
                    (WfAssignedActivity) workItem.getSource().getObject();

            if (activity.isComplete()) {
                return UIValidationStatus.HIDDEN;
            }

            return UIValidationStatus.ENABLED;
        } catch (Exception e) {
            // Fail closed/open policy must be project-defined.
            return UIValidationStatus.HIDDEN;
        }
    }
}
