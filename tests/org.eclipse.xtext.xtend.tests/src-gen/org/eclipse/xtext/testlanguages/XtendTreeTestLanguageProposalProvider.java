/*
Generated with Xtext
*/

package org.eclipse.xtext.testlanguages;

import org.eclipse.xtext.xtend.contentassist.AbstractXtendProposalProvider;

/**
 * A {@link IProposalProvider} that calls Xtend extensions.
 */
public class XtendTreeTestLanguageProposalProvider extends AbstractXtendProposalProvider {

	private static final String UI_PLUGIN_ID = ".";
		
	@Override
	protected ClassLoader getClassLoader() {
		return this.getClass().getClassLoader();
	}

	@Override
	protected String getMasterXtendFileName() {
		return "org::eclipse::xtext::testlanguages::TreeTestLanguageProposals";	
	}
	
	@Override
	protected String getPluginId() {
		return UI_PLUGIN_ID;
	}
}
