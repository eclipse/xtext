package org.eclipse.xtext.idea;

import org.eclipse.xtext.ide.editor.bracketmatching.IBracePairProvider;
import org.eclipse.xtext.ide.editor.bracketmatching.XtextBracePairProvider;
import org.eclipse.xtext.validation.ResourceValidatorImpl;
import org.eclipse.xtext.xtext.ReducedXtextResourceValidator;

public class XtextIdeaModule extends AbstractXtextIdeaModule {

	public Class<? extends ResourceValidatorImpl> bindResourceValidator() {
		return ReducedXtextResourceValidator.class;
	}
	
	@Override
	public Class<? extends IBracePairProvider> bindIBracePairProvider() {
		return XtextBracePairProvider.class;
	}
	
}
