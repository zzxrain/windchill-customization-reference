package com.company.windchill.reference.service;

import wt.services.ServiceFactory;

public final class ExampleHelper {
    public static final ExampleService service = ServiceFactory.getService(ExampleService.class);

    private ExampleHelper() {
    }
}
