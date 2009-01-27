/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser.antlr;

import org.antlr.runtime.ANTLRInputStream;
import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.service.Inject;

import org.eclipse.xtext.testlanguages.parser.antlr.internal.InternalLookaheadTestLanguageLexer;
import org.eclipse.xtext.testlanguages.parser.antlr.internal.InternalLookaheadTestLanguageParser;

public class LookaheadTestLanguageParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject 
    protected AntlrTokenDefProvider antlrTokenDefProvider;
	
	@Override
	protected IParseResult parse(String ruleName, ANTLRInputStream in) {
		InternalLookaheadTestLanguageLexer lexer = new InternalLookaheadTestLanguageLexer(in);
		XtextTokenStream stream = new XtextTokenStream(lexer, antlrTokenDefProvider);
		InternalLookaheadTestLanguageParser parser = new InternalLookaheadTestLanguageParser(
				stream, getElementFactory(), grammarAccess.getGrammar());
		parser.setTokenTypeMap(antlrTokenDefProvider.getTokenDefMap());
		try {
			if(ruleName != null) {
				return parser.parse(ruleName);
			} else {
				return parser.parse();
			}
		} catch (Exception re) {
			throw new ParseException(re.getMessage(),re);
		}
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "Entry";
	}
}
