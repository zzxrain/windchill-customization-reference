package com.company.windchill.reference.ui;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import com.ptc.core.components.descriptor.ModelContext;
import com.ptc.core.components.factory.AbstractDataUtility;
import com.ptc.core.components.rendering.guicomponents.TextDisplayComponent;

import wt.util.WTException;

public class ReferenceDataUtility extends AbstractDataUtility {

    private final Map<Object, String> displayValues = new IdentityHashMap<>();

    @Override
    public void setModelData(String componentId, List<?> objects, ModelContext modelContext)
            throws WTException {
        displayValues.clear();
        for (Object object : objects) {
            // Batch/prefetch real data here. Avoid one DB query per table cell.
            displayValues.put(object, String.valueOf(object));
        }
    }

    @Override
    public Object getDataValue(String componentId, Object datum, ModelContext modelContext)
            throws WTException {
        TextDisplayComponent component = new TextDisplayComponent(componentId);
        component.setValue(displayValues.getOrDefault(datum, ""));
        return component;
    }
}
