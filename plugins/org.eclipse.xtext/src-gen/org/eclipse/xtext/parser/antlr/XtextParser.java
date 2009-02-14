/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.antlr;

import org.antlr.runtime.ANTLRInputStream;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.internal.InternalXtextLexer;
import org.eclipse.xtext.parser.antlr.internal.InternalXtextParser;

import org.eclipse.xtext.services.XtextGrammarAccess;

public class XtextParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject 
    protected ITokenDefProvider antlrTokenDefProvider;
	
	@Inject
	private XtextGrammarAccess grammarAccess;
	
	@Override
	protected IParseResult parse(String ruleName, ANTLRInputStream in) {
		InternalXtextLexer lexer = new InternalXtextLexer(in);
		XtextTokenStream stream = new XtextTokenStream(lexer, antlrTokenDefProvider);
		stream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
		InternalXtextParser parser = new InternalXtextParser(
				stream, getElementFactory(), grammarAccess);
		parser.setTokenTypeMap(antlrTokenDefProvider.getTokenDefMap());
		try {
			if(ruleName != null)
				return parser.parse(ruleName);
			return parser.parse();
		} catch (Exception re) {
			throw new ParseException(re.getMessage(),re);
		}
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "Grammar";
	}
	
	public XtextGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(XtextGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
