/*
Generated with Xtext
*/
package org.eclipse.xtext.example;

import org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider;


/**
 * used to manually extend and modify configuration for components used within the IDE.
 */
public class FowlerDslUIModule extends AbstractFowlerDslUiModule {
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.example.AbstractFowlerDslUiModule#getIProposalProvider()
	 */
	@Override
	protected Class<? extends IProposalProvider> getIProposalProvider() {
		return FowlerDslProposalProvider.class;
	}
	
}
