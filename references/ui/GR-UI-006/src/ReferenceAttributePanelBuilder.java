package com.company.windchill.reference.ui;

import com.ptc.mvc.components.AbstractComponentBuilder;
import com.ptc.mvc.components.AttributeConfig;
import com.ptc.mvc.components.AttributePanelConfig;
import com.ptc.mvc.components.ComponentConfig;
import com.ptc.mvc.components.ComponentConfigFactory;
import com.ptc.mvc.components.ComponentParams;
import com.ptc.mvc.components.GroupConfig;

import wt.util.WTException;

/**
 * Java-configured attribute panel pattern.
 *
 * For TypeManaged objects, prefer a Type and Attribute Management layout when
 * that satisfies the requirement. Use a Java builder when code-level control is
 * actually required.
 */
public class ReferenceAttributePanelBuilder extends AbstractComponentBuilder {

    @Override
    public ComponentConfig buildComponentConfig(ComponentParams params) throws WTException {
        ComponentConfigFactory factory = getComponentConfigFactory();
        AttributePanelConfig panel = factory.newAttributePanelConfig("reference.attributes");

        GroupConfig group = factory.newGroupConfig("general");
        group.setLabel("General");

        AttributeConfig number = factory.newAttributeConfig("number");
        AttributeConfig name = factory.newAttributeConfig("name");
        group.addComponent(number);
        group.addComponent(name);

        panel.addComponent(group);
        return panel;
    }

    @Override
    public Object buildComponentData(ComponentConfig config, ComponentParams params) throws WTException {
        // Return the current object or model expected by this panel.
        return params.getContextObject();
    }
}
