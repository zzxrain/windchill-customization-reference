package com.company.windchill.reference.queue;

import wt.org.WTPrincipal;
import wt.queue.ProcessingQueue;
import wt.queue.QueueHelper;
import wt.util.WTException;

public final class QueueSubmission {

    private QueueSubmission() {
    }

    public static void enqueue(
            ProcessingQueue queue,
            WTPrincipal principal,
            String method,
            String className,
            Class<?>[] argumentTypes,
            Object[] argumentValues) throws WTException {

        QueueHelper.manager.addEntry(
                queue,
                principal,
                method,
                className,
                argumentTypes,
                argumentValues);
    }
}
