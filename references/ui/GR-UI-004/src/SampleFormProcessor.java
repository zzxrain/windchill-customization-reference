package com.company.windchill.reference.ui;

import java.util.List;

import com.ptc.core.components.beans.ObjectBean;
import com.ptc.core.components.forms.DefaultObjectFormProcessor;
import com.ptc.core.components.forms.FormResult;
import com.ptc.netmarkets.util.beans.NmCommandBean;

import wt.util.WTException;

public class SampleFormProcessor extends DefaultObjectFormProcessor {

    @Override
    public FormResult doOperation(
            NmCommandBean clientData,
            List<ObjectBean> objectBeans) throws WTException {

        FormResult result = super.doOperation(clientData, objectBeans);

        Object primary = clientData.getPrimaryOid() == null
                ? null
                : clientData.getPrimaryOid().getRefObject();

        // Validate request context, then delegate real business logic to a service/helper.
        process(primary, clientData);

        return result;
    }

    private void process(Object primary, NmCommandBean commandBean) throws WTException {
        // business service call
    }
}
