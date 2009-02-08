/*
Generated with Xtext
*/

package org.eclipse.xtext.testlanguages;

import org.eclipse.xtext.xtend.contentassist.AbstractXtendProposalProvider;

/**
 * A {@link IProposalProvider} that calls Xtend extensions.
 */
public class XtendReferenceGrammarTestLanguageProposalProvider extends AbstractXtendProposalProvider {

	private static final String UI_PLUGIN_ID = "org.eclipse.xtext.xtend.tests";
		
	@Override
	protected ClassLoader getClassLoader() {
		return this.getClass().getClassLoader();
	}

	@Override
	protected String getMasterXtendFileName() {
		return "org::eclipse::xtext::testlanguages::ReferenceGrammarTestLanguageProposals";	
	}
	
	@Override
	protected String getPluginId() {
		return UI_PLUGIN_ID;
	}
}
