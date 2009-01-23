/*
Generated with Xtext
 */
package org.eclipse.xtext.testlanguages;

import java.util.Set;

import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider;

/**
 * used to register components to be used within the IDE.
 */
public class TreeTestLanguageUiConfig extends org.eclipse.xtext.testlanguages.GenTreeTestLanguageUiConfig {

	public Set<IServiceRegistration> registrations() {
		Set<IServiceRegistration> registrations = super.registrations();
		registrations.addAll(scope(TreeTestLanguageStandaloneSetup.getServiceScope()).with(
				IProposalProvider.class,
				(UseXtendSwitch.useXtend) ? XtendTreeTestLanguageProposalProvider.class
						: GenTreeTestLanguageProposalProvider.class, ServiceRegistry.PRIORITY_MAX).registrations());
		return registrations;
	}

}
