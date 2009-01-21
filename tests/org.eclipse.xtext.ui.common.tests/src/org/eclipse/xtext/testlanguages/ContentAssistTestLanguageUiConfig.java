/*
Generated with Xtext
 */
package org.eclipse.xtext.testlanguages;

import java.util.Set;

import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.ui.common.editor.contentassist.impl.IContentAssistInvocationHandler;

/**
 * used to register components to be used within the IDE.
 */
public class ContentAssistTestLanguageUiConfig extends
		org.eclipse.xtext.testlanguages.GenContentAssistTestLanguageUiConfig {

	public Set<IServiceRegistration> registrations() {
		Set<IServiceRegistration> registrations = super.registrations();
		if (UseXtendSwitch.useXtend) {
			registrations.addAll(scope(org.eclipse.xtext.testlanguages.IContentAssistTestLanguage.SCOPE).with(
					IContentAssistInvocationHandler.class, ContentAssistTestLanguageXtendContentAssistInvoker.class,
					ServiceRegistry.PRIORITY_MAX).registrations());
		}
		return registrations;
	}

}
