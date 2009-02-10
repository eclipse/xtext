/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.keywords;

import org.eclipse.xtext.ui.common.service.DefaultUIModule;

/**
 * Generated from ServiceConfig.xpt!
 * Manual modifications go to KeywordsTestLanguageUIModule
 */
public abstract class AbstractKeywordsTestLanguageUiModule extends DefaultUIModule {
	public Class<? extends org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider> bindIProposalProvider() {
		return org.eclipse.xtext.parser.keywords.GenKeywordsTestLanguageProposalProvider.class;
	}
	public Class<? extends org.eclipse.xtext.ui.common.editor.syntaxcoloring.antlr.ITokenColorer> bindITokenColorer() {
		return org.eclipse.xtext.ui.common.editor.syntaxcoloring.antlr.BuiltinAntlrTokenColorer.class;
	}
	public Class<? extends org.eclipse.jface.text.rules.ITokenScanner> bindITokenScanner() {
		return org.eclipse.xtext.ui.common.editor.syntaxcoloring.antlr.AntlrTokenScanner.class;
	}
}
