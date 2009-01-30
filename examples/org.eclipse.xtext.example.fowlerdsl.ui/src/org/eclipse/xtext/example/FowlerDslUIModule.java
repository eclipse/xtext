/*
Generated with Xtext
*/
package org.eclipse.xtext.example;

import org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider;


/**
 * used to manually extend and modify configuration for components used within the IDE.
 */
public class FowlerDslUIModule extends AbstractFowlerDslUiModule {

	@Override
	public Class<? extends IProposalProvider> bindIProposalProvider() {
		return FowlerDslProposalProvider.class;
	}
	
}
