package com.company.windchill.reference.ui;

import com.ptc.mvc.components.ColumnConfig;
import com.ptc.mvc.components.ComponentConfigFactory;
import com.ptc.mvc.components.TableConfig;

public final class DataUtilityColumnBinding {

    private DataUtilityColumnBinding() {
    }

    public static void addColumn(ComponentConfigFactory factory, TableConfig table) {
        ColumnConfig column = factory.newColumnConfig("companyDisplay", true);
        column.setDataUtilityId("company.reference.display");
        table.addComponent(column);
    }
}
