package com.company.windchill.reference.persistence;

import wt.fc.Persistable;
import wt.fc.PersistenceHelper;
import wt.util.WTException;

public final class PersistenceRefresh {

    public static <T extends Persistable> T saveAndRefresh(T object) throws WTException {
        @SuppressWarnings("unchecked")
        T saved = (T) PersistenceHelper.manager.save(object);

        @SuppressWarnings("unchecked")
        T refreshed = (T) PersistenceHelper.manager.refresh(saved);

        return refreshed;
    }

    public static <T extends Persistable> T modifyAndRefresh(T object) throws WTException {
        @SuppressWarnings("unchecked")
        T modified = (T) PersistenceHelper.manager.modify(object);

        @SuppressWarnings("unchecked")
        T refreshed = (T) PersistenceHelper.manager.refresh(modified);

        return refreshed;
    }

    private PersistenceRefresh() {
    }
}
