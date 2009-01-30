/*
Generated with Xtext
*/
package org.eclipse.xtext.ui.integration;

import org.eclipse.xtext.ui.common.service.DefaultUIModule;

/**
 * GENERATED! Manual modification goes to TestLanguageUIModule
 */
public abstract class AbstractTestLanguageUiModule extends DefaultUIModule {
	
	
	public Class<? extends org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider> bindIProposalProvider() {
		return org.eclipse.xtext.ui.integration.GenTestLanguageProposalProvider.class;
	}
	
	
	
}
