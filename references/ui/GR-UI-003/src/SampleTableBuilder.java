package com.company.windchill.reference.ui;

import java.util.List;

import com.ptc.mvc.components.AbstractComponentBuilder;
import com.ptc.mvc.components.ColumnConfig;
import com.ptc.mvc.components.ComponentBuilder;
import com.ptc.mvc.components.ComponentConfig;
import com.ptc.mvc.components.ComponentConfigFactory;
import com.ptc.mvc.components.ComponentParams;
import com.ptc.mvc.components.TableConfig;

import wt.util.WTException;

@ComponentBuilder("com.company.reference.sampleTable")
public class SampleTableBuilder extends AbstractComponentBuilder {

    @Override
    public ComponentConfig buildComponentConfig(ComponentParams params) throws WTException {
        ComponentConfigFactory factory = getComponentConfigFactory();

        TableConfig table = factory.newTableConfig();
        table.setId("com.company.reference.sampleTable");
        table.setLabel("Sample");
        table.setShowCount(true);
        table.setConfigurable(true);

        ColumnConfig number = factory.newColumnConfig("number", "Number", true);
        ColumnConfig name = factory.newColumnConfig("name", "Name", true);

        table.addComponent(number);
        table.addComponent(name);

        return table;
    }

    @Override
    public Object buildComponentData(
            ComponentConfig config,
            ComponentParams params) throws Exception {

        return loadRows(params);
    }

    private List<?> loadRows(ComponentParams params) throws Exception {
        return List.of();
    }
}
