/*
Generated with Xtext
*/
package org.eclipse.xtext.parser;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.parser.IParseError;
import org.eclipse.xtext.parser.IParseErrorHandler;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.impl.ParseError;

import org.eclipse.xtext.parser.internal.InternalXtextGrammarTestLexer;
import org.eclipse.xtext.parser.internal.InternalXtextGrammarTestParser;


public class XtextGrammarTestParser extends org.eclipse.xtext.parser.AbstractParser {
	
	@Override
	protected IParseResult parse(String ruleName, ANTLRInputStream in, IElementFactory factory,
			final IParseErrorHandler handler) {
		InternalXtextGrammarTestLexer lexer = new InternalXtextGrammarTestLexer(in);
		XtextTokenStream stream = new XtextTokenStream(lexer);
		InternalXtextGrammarTestParser parser = new InternalXtextGrammarTestParser(
				stream, factory, grammarAccess.getGrammar()) {
					@Override
			protected void reportError(IParseError error, RecognitionException re) {
				handler.handleParserError(error);
			}
		};
		try {
			if(ruleName != null) {
				return parser.parse(ruleName);
			} else {
				return parser.parse();
			}
		} catch (Exception re) {
			CommonToken lt = (CommonToken) parser.getInput().LT(parser.getInput().index());
			ParseError error = new ParseError(lt.getLine(), lt.getStartIndex(), lt.getText() != null ? lt.getText().length()
					: 0, lt.getText(), re.getMessage(), re);
			handler.handleParserError(error);
		}
		return null;
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "Grammar";
	}
}
