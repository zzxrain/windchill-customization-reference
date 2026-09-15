package com.company.windchill.reference.ui;

import com.ptc.core.components.descriptor.ModelContext;
import com.ptc.core.components.factory.AbstractDataUtility;
import com.ptc.core.components.factory.dataUtilities.AttributeDataUtilityHelper;
import com.ptc.core.components.rendering.guicomponents.TextBox;

import wt.util.WTException;

public class DefaultTextDataUtility extends AbstractDataUtility {

    @Override
    public Object getDataValue(
            String componentId,
            Object datum,
            ModelContext modelContext) throws WTException {

        TextBox textBox = new TextBox();
        textBox.setWidth(40);
        textBox.setValue(buildDefaultValue(datum, modelContext));
        textBox.setColumnName(
                AttributeDataUtilityHelper.getColumnName(
                        componentId,
                        datum,
                        modelContext));

        return textBox;
    }

    private String buildDefaultValue(Object datum, ModelContext context) {
        return "";
    }
}
