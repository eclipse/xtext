/*
Generated with Xtext
*/
package org.eclipse.xtext.reference.parser.antlr;

import org.antlr.runtime.ANTLRInputStream;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

import com.google.inject.Inject;

import org.eclipse.xtext.reference.parser.antlr.internal.InternalReferenceGrammarLexer;
import org.eclipse.xtext.reference.parser.antlr.internal.InternalReferenceGrammarParser;

public class ReferenceGrammarParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject 
    protected ITokenDefProvider antlrTokenDefProvider;
	
	@Override
	protected IParseResult parse(String ruleName, ANTLRInputStream in) {
		InternalReferenceGrammarLexer lexer = new InternalReferenceGrammarLexer(in);
		XtextTokenStream stream = new XtextTokenStream(lexer, antlrTokenDefProvider);
		InternalReferenceGrammarParser parser = new InternalReferenceGrammarParser(
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
		return "Spielplatz";
	}
}
