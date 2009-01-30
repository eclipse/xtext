/*
Generated with Xtext
*/
package org.eclipse.xtext.reference;

import org.eclipse.xtext.ui.common.service.DefaultUIModule;

/**
 * GENERATED! Manual modification goes to ReferenceGrammarUIModule
 */
public abstract class AbstractReferenceGrammarUiModule extends DefaultUIModule {
	
	
	@Override
	protected Class<? extends org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider> getIProposalProvider() {
		return org.eclipse.xtext.reference.GenReferenceGrammarProposalProvider.class;
	}
	
	
	
}
