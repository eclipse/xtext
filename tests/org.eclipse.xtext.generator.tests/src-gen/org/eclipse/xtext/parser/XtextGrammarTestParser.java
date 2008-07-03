/*
Generated with Xtext
*/
package org.eclipse.xtext.parser;

import org.antlr.runtime.ANTLRInputStream;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

import org.eclipse.xtext.parser.internal.InternalXtextGrammarTestLexer;
import org.eclipse.xtext.parser.internal.InternalXtextGrammarTestParser;


public class XtextGrammarTestParser extends org.eclipse.xtext.parser.AbstractParser {
	
	@Override
	protected IParseResult parse(String ruleName, ANTLRInputStream in, IAstFactory factory) {
		InternalXtextGrammarTestLexer lexer = new InternalXtextGrammarTestLexer(in);
		XtextTokenStream stream = new XtextTokenStream(lexer);
		InternalXtextGrammarTestParser parser = new InternalXtextGrammarTestParser(
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
