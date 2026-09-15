package com.company.windchill.reference.service;

import wt.method.RemoteInterface;
import wt.util.WTException;

@RemoteInterface
public interface ExampleService {
    void performBusinessOperation(String objectIdentifier) throws WTException;
}
