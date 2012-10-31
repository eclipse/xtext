package org.xpect.ui;

import org.eclipse.xtext.ui.LanguageSpecific;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.validation.IResourceValidator;
import org.xpect.registry.AbstractDelegatingModule;
import org.xpect.ui.highlighting.XtHighlightingCalculator;
import org.xpect.ui.highlighting.XtHighlightingConfiguration;
import org.xpect.ui.services.XtLanguageSpecificURIEditorOpener;
import org.xpect.ui.services.XtResourceValidator;

import com.google.inject.Binder;

public class XtUIModule extends AbstractDelegatingModule {

	@Override
	public void configure(Binder binder) {
		overrideAndBackup(binder, IHighlightingConfiguration.class, XtHighlightingConfiguration.class);
		overrideAndBackup(binder, ISemanticHighlightingCalculator.class, XtHighlightingCalculator.class);
		overrideAndBackup(binder, IResourceValidator.class, XtResourceValidator.class);
		overrideAndBackup(binder, IURIEditorOpener.class, LanguageSpecific.class, XtLanguageSpecificURIEditorOpener.class);
	}

}
