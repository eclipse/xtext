/*
Generated with Xtext
*/
package org.eclipse.xtext.grammargen.tests.parser;

import org.antlr.runtime.ANTLRInputStream;
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

import org.eclipse.xtext.grammargen.tests.parser.internal.InternalSimpleTest2Lexer;
import org.eclipse.xtext.grammargen.tests.parser.internal.InternalSimpleTest2Parser;


public class SimpleTest2Parser extends org.eclipse.xtext.parser.AbstractParser {
	
	@Override
	protected IParseResult parse(String ruleName, ANTLRInputStream in, IElementFactory factory) {
		InternalSimpleTest2Lexer lexer = new InternalSimpleTest2Lexer(in);
		XtextTokenStream stream = new XtextTokenStream(lexer);
		InternalSimpleTest2Parser parser = new InternalSimpleTest2Parser(
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
