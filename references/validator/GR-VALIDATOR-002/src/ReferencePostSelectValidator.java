package com.company.windchill.reference.validator;

import java.util.Locale;

import com.ptc.core.ui.validation.DefaultUIComponentValidator;
import com.ptc.core.ui.validation.UIValidationCriteria;
import com.ptc.core.ui.validation.UIValidationKey;
import com.ptc.core.ui.validation.UIValidationResult;
import com.ptc.core.ui.validation.UIValidationStatus;

import wt.util.WTException;

public class ReferencePostSelectValidator extends DefaultUIComponentValidator {

    @Override
    public UIValidationResult validateSelectedAction(
            UIValidationKey key,
            UIValidationCriteria criteria,
            Locale locale) throws WTException {

        if (!isAllowed(criteria)) {
            return UIValidationResult.newInstance(key, UIValidationStatus.DENIED);
        }

        if (requiresConfirmation(criteria)) {
            return UIValidationResult.newInstance(
                    key,
                    UIValidationStatus.PROMPT_FOR_CONFIRMATION);
        }

        return UIValidationResult.newInstance(key, UIValidationStatus.PERMITTED);
    }

    private boolean isAllowed(UIValidationCriteria criteria) {
        return true;
    }

    private boolean requiresConfirmation(UIValidationCriteria criteria) {
        return false;
    }
}
