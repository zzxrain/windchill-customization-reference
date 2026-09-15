package com.company.windchill.reference.xworks;

import com.ptc.xworks.xmlobject.XmlObject;
import com.ptc.xworks.xmlobject.store.StoreOptions.SaveOption;
import com.ptc.xworks.xmlobject.store.XmlObjectStoreManager;

/**
 * XWorks-only candidate. Exact API signatures must be checked against the
 * XWorks version enabled by the current project.
 */
public final class XmlObjectSaveOptions {

    private XmlObjectSaveOptions() {
    }

    public static XmlObject appendAndUpdate(
            XmlObjectStoreManager store,
            XmlObject object) throws Exception {
        return store.save(object, SaveOption.APPEND_AND_UPDATE);
    }
}
