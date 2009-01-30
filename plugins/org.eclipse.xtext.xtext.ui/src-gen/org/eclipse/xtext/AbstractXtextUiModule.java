/*
Generated with Xtext
*/
package org.eclipse.xtext;

import org.eclipse.xtext.ui.common.service.DefaultUIModule;

/**
 * GENERATED! Manual modification goes to XtextUIModule
 */
public abstract class AbstractXtextUiModule extends DefaultUIModule {
	
	
	@Override
	protected Class<? extends org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider> getIProposalProvider() {
		return org.eclipse.xtext.GenXtextProposalProvider.class;
	}
	
	
	
}
