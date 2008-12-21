/*
Generated with Xtext
 */
package org.eclipse.xtext.example;

import java.util.Set;

import org.eclipse.xtext.service.ServiceRegistry;

/**
 * used to register components to be used within the IDE.
 */
public class FowlerDslUiConfig extends org.eclipse.xtext.example.GenFowlerDslUiConfig {

	public Set<IServiceRegistration> registrations() {
		Set<IServiceRegistration> registrations = super.registrations();
		registrations.addAll(scope(org.eclipse.xtext.example.IFowlerDsl.SCOPE).with(
				org.eclipse.xtext.ui.common.editor.codecompletion.IProposalProvider.class,
				org.eclipse.xtext.example.FowlerDslProposalProvider.class, ServiceRegistry.PRIORITY_MAX)
				.registrations());
		return registrations;
	}

}
