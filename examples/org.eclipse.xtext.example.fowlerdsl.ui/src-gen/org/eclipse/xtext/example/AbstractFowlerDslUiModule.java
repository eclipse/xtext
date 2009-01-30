/*
Generated with Xtext
*/
package org.eclipse.xtext.example;

import org.eclipse.xtext.ui.common.service.DefaultUIModule;

/**
 * GENERATED! Manual modification goes to FowlerDslUIModule
 */
public abstract class AbstractFowlerDslUiModule extends DefaultUIModule {
	
	
	public Class<? extends org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider> bindIProposalProvider() {
		return org.eclipse.xtext.example.GenFowlerDslProposalProvider.class;
	}
	
	
	
}
