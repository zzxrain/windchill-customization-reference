package com.company.windchill.reference.ui;

import com.ptc.mvc.components.AbstractComponentBuilder;
import com.ptc.mvc.components.ColumnConfig;
import com.ptc.mvc.components.ComponentConfig;
import com.ptc.mvc.components.ComponentConfigFactory;
import com.ptc.mvc.components.ComponentParams;
import com.ptc.mvc.components.TableConfig;

import wt.util.WTException;

public class ReferenceTableBuilder extends AbstractComponentBuilder {

    @Override
    public ComponentConfig buildComponentConfig(ComponentParams params) throws WTException {
        ComponentConfigFactory factory = getComponentConfigFactory();
        TableConfig table = factory.newTableConfig();
        table.setLabel("Reference Objects");
        table.setSelectable(true);
        table.setShowCount(true);

        ColumnConfig number = factory.newColumnConfig("number", true);
        number.setSortable(true);
        table.addComponent(number);

        ColumnConfig name = factory.newColumnConfig("name", true);
        name.setSortable(true);
        name.setInfoPageLink(true);
        table.addComponent(name);

        return table;
    }

    @Override
    public Object buildComponentData(ComponentConfig config, ComponentParams params) throws WTException {
        // Resolve project-specific filters/context first, then execute the minimum required query.
        // Do not use an unrestricted "all objects" QuerySpec in production code.
        return java.util.Collections.emptyList();
    }
}
