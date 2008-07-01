/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser;

import org.antlr.runtime.ANTLRInputStream;
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

import org.eclipse.xtext.testlanguages.parser.internal.InternalLookaheadLanguageLexer;
import org.eclipse.xtext.testlanguages.parser.internal.InternalLookaheadLanguageParser;


public class LookaheadLanguageParser extends org.eclipse.xtext.parser.AbstractParser {
	
	@Override
	protected IParseResult parse(String ruleName, ANTLRInputStream in, IElementFactory factory) {
		InternalLookaheadLanguageLexer lexer = new InternalLookaheadLanguageLexer(in);
		XtextTokenStream stream = new XtextTokenStream(lexer);
		InternalLookaheadLanguageParser parser = new InternalLookaheadLanguageParser(
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
		return "Entry";
	}
}
