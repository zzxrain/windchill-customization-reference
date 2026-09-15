package com.company.windchill.reference.model;

import wt.fc.WTObject;
import wt.util.WTException;
import wt.util.WTPropertyVetoException;

/**
 * Skeleton showing the factory/initialize convention for a modeled class.
 * A real modeled Windchill class must follow the generated/annotation model
 * required by the target release.
 */
public abstract class FactoryInitializePattern extends WTObject {

    private String businessName;

    protected void initialize(String name) throws WTException {
        super.initialize();
        try {
            setBusinessName(name);
        } catch (WTPropertyVetoException e) {
            throw new WTException(e);
        }
    }

    protected void setBusinessName(String name) throws WTPropertyVetoException {
        this.businessName = name;
    }

    public String getBusinessName() {
        return businessName;
    }
}
