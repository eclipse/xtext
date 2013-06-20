package org.eclipse.xtext.ui.codetemplates.validation;

import org.eclipse.xtext.ui.codetemplates.templates.Dollar;
import org.eclipse.xtext.ui.codetemplates.templates.Variable;
import org.eclipse.xtext.validation.Check;
 

public class CodetemplatesJavaValidator extends AbstractCodetemplatesJavaValidator {

	@Check
	public void checkDollarEscaped(Dollar dollar) {
		if (!dollar.isEscaped())
			error("Invalid escape sequence '$'", null);
	}
	
	@Override
	public boolean isLanguageSpecific() {
		return false;
	}

	/**
	 * @since 2.3
	 */
	@Check
	public void checkParameterListIsNotEmpty(Variable variable) {
		if (variable.isExpectingParameters()) {
			if (variable.getParameters().isEmpty()) {
				error("Parameter list may not be empty", null);
			}
		}
	}
	
}
