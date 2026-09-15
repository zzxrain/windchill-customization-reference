package com.company.windchill.reference.ui;

import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import com.ptc.core.components.descriptor.ModelContext;
import com.ptc.core.components.factory.AbstractDataUtility;
import com.ptc.core.components.rendering.guicomponents.TextDisplayComponent;

import wt.util.WTException;

/**
 * Reference pattern for prefetching column display data.
 *
 * This example intentionally stores prepared values in an instance field.
 * Therefore the DataUtility registration/lifecycle must prevent unrelated
 * requests from sharing this mutable state.
 *
 * See GR-UI-008 for the corresponding registration pattern and verify the
 * exact lifecycle/cardinality behavior against the target Windchill version.
 */
public class ReferenceDataUtility extends AbstractDataUtility {

    private final Map<Object, String> displayValues = new IdentityHashMap<>();

    @Override
    public void setModelData(String componentId, List<?> objects, ModelContext modelContext)
            throws WTException {

        displayValues.clear();

        // Prefetch data for the object set here.
        // Prefer one or a small number of batch operations instead of
        // issuing one database query for every table cell.
        for (Object object : objects) {
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