/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser;

import org.antlr.runtime.ANTLRInputStream;
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

import org.eclipse.xtext.testlanguages.parser.internal.InternalActionTestLanguageLexer;
import org.eclipse.xtext.testlanguages.parser.internal.InternalActionTestLanguageParser;


public class ActionTestLanguageParser extends org.eclipse.xtext.parser.AbstractParser {
	
	@Override
	protected IParseResult parse(String ruleName, ANTLRInputStream in, IElementFactory factory) {
		InternalActionTestLanguageLexer lexer = new InternalActionTestLanguageLexer(in);
		XtextTokenStream stream = new XtextTokenStream(lexer);
		InternalActionTestLanguageParser parser = new InternalActionTestLanguageParser(
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
		return "Model";
	}
}
