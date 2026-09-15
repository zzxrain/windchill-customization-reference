package com.company.windchill.reference.xworks;

import java.util.List;

import com.ptc.core.components.beans.ObjectBean;
import com.ptc.core.components.forms.FormProcessingStatus;
import com.ptc.core.components.forms.FormResult;
import com.ptc.netmarkets.util.beans.NmCommandBean;
import com.ptc.xworks.xmlobject.XmlObject;
import com.ptc.xworks.xmlobject.workflow.WorkflowTaskFormProcessorDelegate;

import wt.util.WTException;

/**
 * XWorks-only skeleton: keep business validation inside the dedicated
 * complete-task hook instead of mixing it with persistence code.
 */
public class RequiredWorkflowFormValidation
        extends WorkflowTaskFormProcessorDelegate {

    @Override
    public FormResult validateBeforeCompleteForRequiredCondition(
            NmCommandBean clientData,
            List<ObjectBean> objectBeans,
            List<XmlObject> xmlObjectsFromWeb) throws WTException {

        FormResult result = new FormResult(FormProcessingStatus.SUCCESS);

        // Validate only conditions that MUST be corrected before Complete.
        // On failure:
        // result.setStatus(FormProcessingStatus.FAILURE);
        // result.addFeedbackMessage(...);

        return result;
    }
}
