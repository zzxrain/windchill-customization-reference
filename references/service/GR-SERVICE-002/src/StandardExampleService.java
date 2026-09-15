package com.company.windchill.reference.service;

import wt.services.StandardManager;
import wt.util.WTException;

public class StandardExampleService extends StandardManager implements ExampleService {

    public static StandardExampleService newStandardExampleService() throws WTException {
        StandardExampleService instance = new StandardExampleService();
        instance.initialize();
        return instance;
    }

    @Override
    public void performBusinessOperation(String objectIdentifier) throws WTException {
        // Encapsulate the complete Windchill business operation here.
        // Add an explicit Transaction when multiple persistent changes must be atomic.
    }
}
