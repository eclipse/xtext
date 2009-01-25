/*
Generated with Xtext
*/
package org.eclipse.xtext;

import java.util.Set;

import org.eclipse.xtext.service.ServiceRegistry;

/**
 * used to register components to be used within the IDE.
 */
public class XtextUiConfig extends org.eclipse.xtext.GenXtextUiConfig {

	public Set<IServiceRegistration> registrations() {
		Set<IServiceRegistration> registrations = super.registrations();
		registrations.addAll(
				scope(org.eclipse.xtext.IXtext.SCOPE)
					.with(org.eclipse.xtext.ui.common.editor.outline.ISemanticModelTransformer.class, org.eclipse.xtext.xtext.ui.editor.outline.XtextSemanticModelTransformer.class, ServiceRegistry.PRIORITY_MAX)
				.registrations());
		return registrations;

	}

}
