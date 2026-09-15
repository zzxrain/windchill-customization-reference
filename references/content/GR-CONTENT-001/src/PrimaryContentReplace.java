package com.company.windchill.reference.content;

import java.io.InputStream;

import wt.content.ApplicationData;
import wt.content.ContentHelper;
import wt.content.ContentHolder;
import wt.content.ContentItem;
import wt.content.ContentRoleType;
import wt.content.ContentServerHelper;
import wt.fc.ObjectReference;
import wt.pom.Transaction;
import wt.util.WTException;

public final class PrimaryContentReplace {

    public static void replace(
            ContentHolder holder,
            String fileName,
            InputStream input) throws Exception {

        Transaction tx = null;
        try {
            tx = new Transaction();
            tx.start();

            ContentItem existing = ContentHelper.service.getPrimaryContent(
                    ObjectReference.newObjectReference(holder));

            if (existing != null) {
                ContentServerHelper.service.deleteContent(holder, existing);
            }

            ApplicationData data = ApplicationData.newApplicationData(holder);
            data.setFileName(fileName);
            data.setRole(ContentRoleType.PRIMARY);

            ContentServerHelper.service.updateContent(holder, data, input);

            tx.commit();
            tx = null;
        } finally {
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    private PrimaryContentReplace() {
    }
}
