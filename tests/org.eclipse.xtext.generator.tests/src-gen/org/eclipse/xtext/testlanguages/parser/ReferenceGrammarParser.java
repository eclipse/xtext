/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser;

import org.antlr.runtime.ANTLRInputStream;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

import org.eclipse.xtext.testlanguages.parser.internal.InternalReferenceGrammarLexer;
import org.eclipse.xtext.testlanguages.parser.internal.InternalReferenceGrammarParser;


public class ReferenceGrammarParser extends org.eclipse.xtext.parser.AbstractParser {
	
	@Override
	protected IParseResult parse(String ruleName, ANTLRInputStream in, IAstFactory factory) {
		InternalReferenceGrammarLexer lexer = new InternalReferenceGrammarLexer(in);
		XtextTokenStream stream = new XtextTokenStream(lexer);
		InternalReferenceGrammarParser parser = new InternalReferenceGrammarParser(
				stream, factory, grammarAccess.getGrammar());
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
