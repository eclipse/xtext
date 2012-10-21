package org.eclipse.xpect.ui.editor;

import org.eclipse.xpect.util.AbstractDelegatingModule;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.validation.IResourceValidator;

import com.google.inject.Binder;

public class AssimilatingModule extends AbstractDelegatingModule {

	@Override
	public void configure(Binder binder) {
		overrideAndBackup(binder, IHighlightingConfiguration.class, XpectHighlightingConfiguration.class);
		overrideAndBackup(binder, ISemanticHighlightingCalculator.class, XpectHighlightingCalculator.class);
		overrideAndBackup(binder, IResourceValidator.class, XpectResourceValidator.class);
	}

}
