/*
Generated with Xtext
*/
package org.eclipse.xtext.reference;

import org.eclipse.xtext.ui.common.service.DefaultUIModule;

/**
 * Generated from ServiceConfig.xpt!
 * Manual modifications go to ReferenceGrammarUIModule
 */
public abstract class AbstractReferenceGrammarUiModule extends DefaultUIModule {
	public Class<? extends org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider> bindIProposalProvider() {
		return org.eclipse.xtext.reference.GenReferenceGrammarProposalProvider.class;
	}
	public Class<? extends org.eclipse.xtext.ui.common.editor.syntaxcoloring.antlr.ITokenColorer> bindITokenColorer() {
		return org.eclipse.xtext.ui.common.editor.syntaxcoloring.antlr.BuiltinAntlrTokenColorer.class;
	}
	public Class<? extends org.eclipse.jface.text.rules.ITokenScanner> bindITokenScanner() {
		return org.eclipse.xtext.ui.common.editor.syntaxcoloring.antlr.AntlrTokenScanner.class;
	}
}
