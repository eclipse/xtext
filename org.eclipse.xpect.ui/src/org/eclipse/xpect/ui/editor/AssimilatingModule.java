package org.eclipse.xpect.ui.editor;

import org.eclipse.xpect.registry.DefaultBinding;
import org.eclipse.xpect.util.AbstractDelegatingModule;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.validation.IResourceValidator;

import com.google.inject.Binder;

public class AssimilatingModule extends AbstractDelegatingModule {

	@Override
	public void configure(Binder binder) {
		binder.bind(ISemanticHighlightingCalculator.class).to(XpectSemanticHighlightingCalculator.class);
		Class<? extends ISemanticHighlightingCalculator> originalType = getOriginalType(ISemanticHighlightingCalculator.class);
		if (originalType != null)
			binder.bind(ISemanticHighlightingCalculator.class).annotatedWith(DefaultBinding.class).to(originalType);
		binder.bind(IResourceValidator.class).to(XpectResourceValidator.class);
		Class<? extends IResourceValidator> originalValidator = getOriginalType(IResourceValidator.class);
		binder.bind(IResourceValidator.class).annotatedWith(DefaultBinding.class).to(originalValidator);
	}

}
