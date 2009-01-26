/*
Generated with Xtext
*/

package org.eclipse.xtext.testlanguages;

import org.eclipse.xtext.ui.common.xtend.contentassist.AbstractXtendProposalProvider;

/**
 * A {@link IProposalProvider} that calls Xtend extensions.
 */
public class XtendContentAssistTestLanguageProposalProvider extends AbstractXtendProposalProvider {

	private static final String UI_PLUGIN_ID = "";
		
	@Override
	protected ClassLoader getClassLoader() {
		return this.getClass().getClassLoader();
	}

	@Override
	protected String getMasterXtendFileName() {
		return "org::eclipse::xtext::testlanguages::ContentAssistTestLanguageProposals";	
	}
	
	@Override
	protected String getPluginId() {
		return UI_PLUGIN_ID;
	}
}
