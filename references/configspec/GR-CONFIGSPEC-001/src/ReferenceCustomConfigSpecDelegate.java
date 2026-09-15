package com.company.windchill.reference.configspec;

import java.util.Map;

import wt.fc.QueryResult;
import wt.query.QueryException;
import wt.query.QuerySpec;
import wt.util.WTException;
import wt.vc.config.custom.CustomConfigSpecAttribute;
import wt.vc.config.custom.CustomConfigSpecDelegate;

/**
 * Minimal delegate skeleton based on the official customization pattern.
 */
public class ReferenceCustomConfigSpecDelegate implements CustomConfigSpecDelegate {

    private Map<String, CustomConfigSpecAttribute> attributesMap;

    @Override
    public QuerySpec appendSearchCriteria(QuerySpec querySpec)
            throws WTException, QueryException {
        QuerySpec clone = (QuerySpec) querySpec.clone();

        // Read configured values from attributesMap and append only the
        // project-specific structure-resolution criteria required here.
        return clone;
    }

    @Override
    public QueryResult process(QueryResult results) throws WTException {
        // Optional post-processing of candidate iterations.
        return results;
    }

    @Override
    public void setAttributesMap(Map<String, CustomConfigSpecAttribute> attributesMap) {
        this.attributesMap = attributesMap;
    }

    @Override
    public Map<String, CustomConfigSpecAttribute> getAttributesMap() {
        return attributesMap;
    }
}
