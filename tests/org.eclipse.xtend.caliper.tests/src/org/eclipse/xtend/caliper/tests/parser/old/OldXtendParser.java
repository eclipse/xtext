package org.eclipse.xtend.caliper.tests.parser.old;

import org.eclipse.xtend.core.services.XtendGrammarAccess;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

import com.google.inject.Inject;

public class OldXtendParser extends AbstractAntlrParser {
	
	@Inject
	private XtendGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected OldInternalXtendParser createParser(XtextTokenStream stream) {
		return new OldInternalXtendParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "File";
	}
	
	public XtendGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(XtendGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}