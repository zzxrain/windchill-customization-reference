package com.company.windchill.reference.validator;

import java.util.Locale;

import com.ptc.core.ui.validation.DefaultUIComponentValidator;
import com.ptc.core.ui.validation.UIValidationCriteria;
import com.ptc.core.ui.validation.UIValidationKey;
import com.ptc.core.ui.validation.UIValidationResult;
import com.ptc.core.ui.validation.UIValidationStatus;

import wt.util.WTException;

/**
 * Reference pattern for Windchill wizard post-submit validation.
 *
 * Windchill 13.1.2.0 Customization Guide documents PERMITTED,
 * DENIED and PROMPT_FOR_CONFIRMATION as possible outcomes of
 * validateFormSubmission().
 *
 * PROMPT_FOR_CONFIRMATION also requires the corresponding wizard
 * client-side post-submit validation configuration. Returning the status
 * alone is not sufficient to establish the complete confirmation flow.
 */
public class ReferenceFormSubmissionValidator extends DefaultUIComponentValidator {

    @Override
    public UIValidationResult validateFormSubmission(
            UIValidationKey key,
            UIValidationCriteria criteria,
            Locale locale) throws WTException {

        if (hasBlockingValidationError(criteria)) {
            UIValidationResult result = UIValidationResult.newInstance(
                    key,
                    UIValidationStatus.DENIED);

            // Add a localized feedback message in the real project
            // implementation so the user knows what must be corrected.
            return result;
        }

        if (hasAdvisoryWarning(criteria)) {
            // Windchill 13.1.2.0 documents this status for post-submit
            // validation. The wizard must also use the corresponding
            // client-side post-submit validation configuration.
            return UIValidationResult.newInstance(
                    key,
                    UIValidationStatus.PROMPT_FOR_CONFIRMATION);
        }

        return UIValidationResult.newInstance(
                key,
                UIValidationStatus.PERMITTED);
    }

    private boolean hasBlockingValidationError(UIValidationCriteria criteria)
            throws WTException {

        // criteria.getFormData() can be used when validation depends on
        // submitted wizard values.
        //
        // Return true only for conditions that must prevent submission.
        return false;
    }

    private boolean hasAdvisoryWarning(UIValidationCriteria criteria)
            throws WTException {

        // Return true only for a condition where the user may explicitly
        // confirm and continue.
        //
        // Do not infer this semantic from an XWorks optional-condition hook;
        // implement it according to the Windchill post-submit contract.
        return false;
    }
}