package org.eclipse.xtext.ui.common;

import java.util.Set;

import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.xtext.builtin.IXtextBuiltin;
import org.eclipse.xtext.service.AbstractServiceRegistrationFactory;
import org.eclipse.xtext.ui.common.editor.outline.XtextContentOutlinePage;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.antlr.AntlrTokenScanner;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.antlr.BuiltinAntlrTokenColorer;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.antlr.ITokenColorer;
import org.eclipse.xtext.ui.core.editor.XtextSourceViewerConfiguration;

public class XtextBuiltinUiConfiguration extends AbstractServiceRegistrationFactory {

	public Set<IServiceRegistration> registrations() {
		return scope(IXtextBuiltin.SCOPE)
			.with(XtextSourceViewerConfiguration.class)
			.with(XtextContentOutlinePage.class)
			.with(ITokenColorer.class, BuiltinAntlrTokenColorer.class)
			.with(ITokenScanner.class, AntlrTokenScanner.class).registrations();
	}

}
