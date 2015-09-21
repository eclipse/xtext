package org.eclipse.xtext.idea;

import org.eclipse.xtext.validation.ResourceValidatorImpl;
import org.eclipse.xtext.xtext.ReducedXtextResourceValidator;

public class XtextIdeaModule extends AbstractXtextIdeaModule {

	public Class<? extends ResourceValidatorImpl> bindResourceValidator() {
		return ReducedXtextResourceValidator.class;
	}
	
}
