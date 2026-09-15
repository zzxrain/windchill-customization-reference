package com.company.windchill.reference.persistence;

import wt.pom.Transaction;
import wt.util.WTException;

public final class TransactionBoundary {

    public static void execute() throws WTException {
        Transaction tx = null;
        try {
            tx = new Transaction();
            tx.start();

            // 多个属于同一业务动作的 Persistence 操作放在同一事务中。
            // doBusinessPersistence();

            tx.commit();
            tx = null;
        } finally {
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    private TransactionBoundary() {
    }
}
