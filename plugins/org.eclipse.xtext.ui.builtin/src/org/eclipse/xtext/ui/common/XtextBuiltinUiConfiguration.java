package org.eclipse.xtext.ui.common;

import java.util.Set;

import org.eclipse.xtext.builtin.IXtextBuiltin;
import org.eclipse.xtext.service.AbstractServiceRegistrationFactory;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.DefaultTokenScanner;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.ITokenColorer;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.tokens.BuiltinTokenColorer;
import org.eclipse.xtext.ui.core.editor.XtextSourceViewerConfiguration;

public class XtextBuiltinUiConfiguration extends AbstractServiceRegistrationFactory {

	public Set<IServiceRegistration> registrations() {
		return scope(IXtextBuiltin.SCOPE)
			.with(XtextSourceViewerConfiguration.class)
			.with(ITokenColorer.class, BuiltinTokenColorer.class)
			.with(DefaultTokenScanner.class).registrations();
	}

}
