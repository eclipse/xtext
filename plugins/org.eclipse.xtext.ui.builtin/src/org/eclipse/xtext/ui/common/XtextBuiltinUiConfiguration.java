package org.eclipse.xtext.ui.common;

import java.util.Set;

import org.eclipse.xtext.builtin.IXtextBuiltin;
import org.eclipse.xtext.service.AbstractServiceRegistrationFactory;
import org.eclipse.xtext.ui.core.editor.XtextSourceViewerConfiguration;

public class XtextBuiltinUiConfiguration extends AbstractServiceRegistrationFactory {

	public Set<IServiceRegistration> registrations() {
		return scope(IXtextBuiltin.SCOPE)
			.with(XtextSourceViewerConfiguration.class).registrations();
	}

}
