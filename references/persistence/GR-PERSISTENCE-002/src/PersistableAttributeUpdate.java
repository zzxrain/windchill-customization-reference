package com.company.windchill.reference.persistence;

import java.util.Locale;

import com.ptc.core.lwc.server.PersistableAdapter;
import com.ptc.core.meta.common.UpdateOperationIdentifier;

import wt.fc.Persistable;
import wt.fc.PersistenceHelper;
import wt.util.WTException;

public final class PersistableAttributeUpdate {

    public static Persistable update(
            Persistable object,
            String attributeName,
            Object value) throws WTException {

        Persistable refreshed = PersistenceHelper.manager.refresh(object);

        PersistableAdapter adapter = new PersistableAdapter(
                refreshed,
                null,
                Locale.US,
                new UpdateOperationIdentifier());

        adapter.load(attributeName);
        adapter.set(attributeName, value);

        Persistable applied = adapter.apply();
        return PersistenceHelper.manager.modify(applied);
    }

    private PersistableAttributeUpdate() {
    }
}
