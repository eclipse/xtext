package org.eclipse.xpect.ui;

import org.eclipse.xpect.registry.AbstractDelegatingModule;
import org.eclipse.xpect.ui.highlighting.XtHighlightingCalculator;
import org.eclipse.xpect.ui.highlighting.XtHighlightingConfiguration;
import org.eclipse.xpect.ui.services.XtResourceValidator;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.validation.IResourceValidator;

import com.google.inject.Binder;

public class XtUIModule extends AbstractDelegatingModule {

	@Override
	public void configure(Binder binder) {
		overrideAndBackup(binder, IHighlightingConfiguration.class, XtHighlightingConfiguration.class);
		overrideAndBackup(binder, ISemanticHighlightingCalculator.class, XtHighlightingCalculator.class);
		overrideAndBackup(binder, IResourceValidator.class, XtResourceValidator.class);
	}

}
