package com.company.windchill.reference.validator;

import java.util.Locale;

import com.ptc.core.ui.validation.DefaultUIComponentValidator;
import com.ptc.core.ui.validation.UIValidationCriteria;
import com.ptc.core.ui.validation.UIValidationKey;
import com.ptc.core.ui.validation.UIValidationResult;
import com.ptc.core.ui.validation.UIValidationResultSet;
import com.ptc.core.ui.validation.UIValidationStatus;

import wt.util.WTException;

public class ReferencePreValidator extends DefaultUIComponentValidator {

    @Override
    public UIValidationResultSet performFullPreValidation(
            UIValidationKey key,
            UIValidationCriteria criteria,
            Locale locale) throws WTException {

        UIValidationResultSet results = UIValidationResultSet.newInstance();

        boolean visible = isVisible(criteria);
        UIValidationStatus status = visible
                ? UIValidationStatus.ENABLED
                : UIValidationStatus.HIDDEN;

        results.addResult(UIValidationResult.newInstance(key, status));
        return results;
    }

    private boolean isVisible(UIValidationCriteria criteria) throws WTException {
        // Use only the minimum context required for validation.
        return true;
    }
}
