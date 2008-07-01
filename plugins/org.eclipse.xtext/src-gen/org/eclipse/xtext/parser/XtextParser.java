/*
Generated with Xtext
*/
package org.eclipse.xtext.parser;

import org.antlr.runtime.ANTLRInputStream;
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

import org.eclipse.xtext.parser.internal.InternalXtextLexer;
import org.eclipse.xtext.parser.internal.InternalXtextParser;


public class XtextParser extends org.eclipse.xtext.parser.AbstractParser {
	
	@Override
	protected IParseResult parse(String ruleName, ANTLRInputStream in, IElementFactory factory) {
		InternalXtextLexer lexer = new InternalXtextLexer(in);
		XtextTokenStream stream = new XtextTokenStream(lexer);
		InternalXtextParser parser = new InternalXtextParser(
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
		return "Grammar";
	}
}
