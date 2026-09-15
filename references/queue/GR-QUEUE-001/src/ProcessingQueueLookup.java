package com.company.windchill.reference.queue;

import wt.queue.ProcessingQueue;
import wt.queue.QueueHelper;
import wt.util.WTException;

/**
 * Prefer consuming a preconfigured queue from business code.
 */
public final class ProcessingQueueLookup {

    private ProcessingQueueLookup() {
    }

    public static ProcessingQueue require(String queueName) throws WTException {
        ProcessingQueue queue = QueueHelper.manager.getQueue(queueName);
        if (queue == null) {
            throw new WTException("ProcessingQueue is not configured: " + queueName);
        }
        return queue;
    }
}
