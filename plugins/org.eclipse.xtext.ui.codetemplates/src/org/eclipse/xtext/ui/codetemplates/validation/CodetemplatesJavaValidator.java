package org.eclipse.xtext.ui.codetemplates.validation;

import org.eclipse.xtext.ui.codetemplates.templates.Dollar;
import org.eclipse.xtext.validation.Check;
 

public class CodetemplatesJavaValidator extends AbstractCodetemplatesJavaValidator {

	@Check
	public void checkDollarEscaped(Dollar dollar) {
		assertTrue("Invalid escape sequence '$'", null, dollar.isEscaped());
	}

}
