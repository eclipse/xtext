/*
Generated with Xtext
*/
package org.eclipse.xtext.dummy.parser;

import org.antlr.runtime.ANTLRInputStream;
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

import org.eclipse.xtext.dummy.parser.internal.InternalDummyLanguageLexer;
import org.eclipse.xtext.dummy.parser.internal.InternalDummyLanguageParser;


public class DummyLanguageParser extends org.eclipse.xtext.parser.AbstractParser {
	
	@Override
	protected IParseResult parse(String ruleName, ANTLRInputStream in, IElementFactory factory) {
		InternalDummyLanguageLexer lexer = new InternalDummyLanguageLexer(in);
		XtextTokenStream stream = new XtextTokenStream(lexer);
		InternalDummyLanguageParser parser = new InternalDummyLanguageParser(
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
