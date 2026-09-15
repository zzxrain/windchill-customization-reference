package com.company.windchill.reference.type;

import com.ptc.core.meta.common.TypeIdentifierHelper;

import wt.fc.Persistable;

public final class TypeInternalName {

    public static String of(Persistable object) throws Exception {
        return TypeIdentifierHelper.getType(object).getTypeInternalName();
    }

    private TypeInternalName() {
    }
}
