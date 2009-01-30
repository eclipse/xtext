/*
Generated with Xtext
*/
package org.eclipse.xtext.example;

import org.eclipse.xtext.ui.common.service.DefaultUIModule;

/**
 * GENERATED! Manual modification goes to DomainmodelUIModule
 */
public abstract class AbstractDomainmodelUiModule extends DefaultUIModule {
	
	
	@Override
	protected Class<? extends org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider> getIProposalProvider() {
		return org.eclipse.xtext.example.GenDomainmodelProposalProvider.class;
	}
	
	
	
}
