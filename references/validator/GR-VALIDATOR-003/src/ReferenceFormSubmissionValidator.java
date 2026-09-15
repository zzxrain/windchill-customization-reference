package com.company.windchill.reference.validator;

import java.util.Locale;

import com.ptc.core.ui.validation.DefaultUIComponentValidator;
import com.ptc.core.ui.validation.UIValidationCriteria;
import com.ptc.core.ui.validation.UIValidationKey;
import com.ptc.core.ui.validation.UIValidationResult;
import com.ptc.core.ui.validation.UIValidationStatus;

import wt.util.WTException;

public class ReferenceFormSubmissionValidator extends DefaultUIComponentValidator {

    @Override
    public UIValidationResult validateFormSubmission(
            UIValidationKey key,
            UIValidationCriteria criteria,
            Locale locale) throws WTException {

        if (isFormValid(criteria)) {
            return UIValidationResult.newInstance(key, UIValidationStatus.PERMITTED);
        }

        UIValidationResult result = UIValidationResult.newInstance(
                key,
                UIValidationStatus.DENIED);
        // Add a localized feedback message in the real project implementation.
        return result;
    }

    private boolean isFormValid(UIValidationCriteria criteria) throws WTException {
        // criteria.getFormData() can be used when the validation needs submitted values.
        return true;
    }
}
