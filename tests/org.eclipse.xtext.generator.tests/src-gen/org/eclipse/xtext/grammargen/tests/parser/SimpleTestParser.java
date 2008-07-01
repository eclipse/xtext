/*
Generated with Xtext
*/
package org.eclipse.xtext.grammargen.tests.parser;

import org.antlr.runtime.ANTLRInputStream;
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

import org.eclipse.xtext.grammargen.tests.parser.internal.InternalSimpleTestLexer;
import org.eclipse.xtext.grammargen.tests.parser.internal.InternalSimpleTestParser;


public class SimpleTestParser extends org.eclipse.xtext.parser.AbstractParser {
	
	@Override
	protected IParseResult parse(String ruleName, ANTLRInputStream in, IElementFactory factory) {
		InternalSimpleTestLexer lexer = new InternalSimpleTestLexer(in);
		XtextTokenStream stream = new XtextTokenStream(lexer);
		InternalSimpleTestParser parser = new InternalSimpleTestParser(
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
		return "Foo";
	}
}
