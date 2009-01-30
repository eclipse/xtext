/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages;

import org.eclipse.xtext.ui.common.service.DefaultUIModule;

/**
 * GENERATED! Manual modification goes to TreeTestLanguageUIModule
 */
public abstract class AbstractTreeTestLanguageUiModule extends DefaultUIModule {
	
	
	@Override
	protected Class<? extends org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider> getIProposalProvider() {
		return org.eclipse.xtext.testlanguages.GenTreeTestLanguageProposalProvider.class;
	}
	
	
	
}
