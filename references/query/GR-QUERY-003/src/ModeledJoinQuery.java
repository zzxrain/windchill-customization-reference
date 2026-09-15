package com.company.windchill.reference.query;

import wt.folder.FolderMembership;
import wt.folder.SubFolder;
import wt.part.WTPart;
import wt.query.ClassAttribute;
import wt.query.QuerySpec;
import wt.util.WTException;

/**
 * QuerySpec modeled-join pattern derived from the PTC Customization Guide.
 *
 * The point of this sample is appendJoin(): use the modeled link roles instead
 * of hard-coding database foreign-key column names.
 */
public final class ModeledJoinQuery {

    private ModeledJoinQuery() {
    }

    public static QuerySpec buildFolderPartQuery() throws WTException {
        QuerySpec query = new QuerySpec();

        int folderIndex = query.appendClassList(SubFolder.class, false);
        int linkIndex = query.appendClassList(FolderMembership.class, false);
        int partIndex = query.appendClassList(WTPart.class, false);

        query.appendSelect(
                new ClassAttribute(SubFolder.class, SubFolder.NAME),
                new int[]{folderIndex},
                false);
        query.appendSelect(
                new ClassAttribute(WTPart.class, WTPart.NAME),
                new int[]{partIndex},
                false);

        query.appendJoin(linkIndex, FolderMembership.FOLDER_ROLE, folderIndex);
        query.appendJoin(linkIndex, FolderMembership.MEMBER_ROLE, partIndex);

        return query;
    }
}
