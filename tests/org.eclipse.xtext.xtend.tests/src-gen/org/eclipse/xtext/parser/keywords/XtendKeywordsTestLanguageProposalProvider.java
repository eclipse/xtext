/*
Generated with Xtext
*/

package org.eclipse.xtext.parser.keywords;

import org.eclipse.xtext.xtend.contentassist.AbstractXtendProposalProvider;

/**
 * A {@link IProposalProvider} that calls Xtend extensions.
 */
public class XtendKeywordsTestLanguageProposalProvider extends AbstractXtendProposalProvider {

	private static final String UI_PLUGIN_ID = "org.eclipse.xtext.xtend.tests";
		
	@Override
	protected ClassLoader getClassLoader() {
		return this.getClass().getClassLoader();
	}

	@Override
	protected String getMasterXtendFileName() {
		return "org::eclipse::xtext::parser::keywords::KeywordsTestLanguageProposals";	
	}
	
	@Override
	protected String getPluginId() {
		return UI_PLUGIN_ID;
	}
}
