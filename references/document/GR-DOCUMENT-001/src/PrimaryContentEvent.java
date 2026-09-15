package com.company.windchill.reference.document;

import wt.content.ApplicationData;
import wt.content.ContentItem;
import wt.content.ContentRoleType;
import wt.content.HolderToContent;
import wt.doc.WTDocument;
import wt.fc.Persistable;

public final class PrimaryContentEvent {

    public static ApplicationData primaryApplicationData(Object eventTarget) {
        if (!(eventTarget instanceof HolderToContent)) {
            return null;
        }

        HolderToContent link = (HolderToContent) eventTarget;
        Persistable holder = link.getRoleAObject();
        Persistable content = link.getRoleBObject();

        if (!(holder instanceof WTDocument)
                || !(content instanceof ApplicationData)) {
            return null;
        }

        ContentItem item = (ContentItem) content;
        return ContentRoleType.PRIMARY.equals(item.getRole())
                ? (ApplicationData) content
                : null;
    }

    private PrimaryContentEvent() {
    }
}
