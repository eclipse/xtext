/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages;

import org.eclipse.xtext.ui.common.service.DefaultUIModule;

/**
 * GENERATED! Manual modification goes to ContentAssistTestLanguageUIModule
 */
public abstract class AbstractContentAssistTestLanguageUiModule extends DefaultUIModule {
	
	
	public Class<? extends org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider> bindIProposalProvider() {
		return org.eclipse.xtext.testlanguages.XtendContentAssistTestLanguageProposalProvider.class;
	}
	
	public Class<? extends org.eclipse.xtext.ui.common.editor.syntaxcoloring.antlr.ITokenColorer> bindITokenColorer() {
		return org.eclipse.xtext.ui.common.editor.syntaxcoloring.antlr.BuiltinAntlrTokenColorer.class;
	}
	
	public Class<? extends org.eclipse.jface.text.rules.ITokenScanner> bindITokenScanner() {
		return org.eclipse.xtext.ui.common.editor.syntaxcoloring.antlr.AntlrTokenScanner.class;
	}
	
	
	
}
