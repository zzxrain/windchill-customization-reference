package com.company.windchill.reference.queue;

import java.io.Serializable;

import wt.fc.Persistable;
import wt.fc.ObjectReference;
import wt.util.WTException;

/**
 * Prefer a small reference-like payload over serializing a large object graph.
 */
public final class LightweightQueueArgument implements Serializable {
    private static final long serialVersionUID = 1L;

    private final ObjectReference objectReference;

    public LightweightQueueArgument(Persistable persistable) throws WTException {
        this.objectReference = ObjectReference.newObjectReference(persistable);
    }

    public Persistable resolve() throws WTException {
        return (Persistable) objectReference.getObject();
    }
}
