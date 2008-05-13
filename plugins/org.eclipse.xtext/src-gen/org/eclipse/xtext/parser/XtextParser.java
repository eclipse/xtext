
package org.eclipse.xtext.parser;


import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parser.IParseErrorHandler;
import org.eclipse.xtext.core.parser.antlr.AntlrExceptionTool;
import org.eclipse.xtext.core.parser.antlr.TokenTool;

import org.eclipse.xtext.parser.internal.InternalXtextLexer;
import org.eclipse.xtext.parser.internal.InternalXtextParser;


public class XtextParser extends org.eclipse.xtext.core.parser.AbstractParser {
	@Override
	protected Object parse(ANTLRInputStream in, IElementFactory factory,
			final IParseErrorHandler handler) {
		InternalXtextLexer lexer = new InternalXtextLexer(in) {
			@Override
			public void reportError(RecognitionException re) {
				Token t = AntlrExceptionTool.getToken(re);
				handler.handleParserError(TokenTool.getOffset(t), TokenTool
						.getLength(t), TokenTool.getText(t), getErrorMessage(
						re, getTokenNames()));
			}
		};
		CommonTokenStream stream = new CommonTokenStream(lexer);
		InternalXtextParser parser = new InternalXtextParser(
				stream, factory) {
			@Override
			public void reportError(RecognitionException re) {
				Token t = AntlrExceptionTool.getToken(re);
				handler.handleParserError(TokenTool.getOffset(t), TokenTool
						.getLength(t), TokenTool.getText(t), getErrorMessage(
						re, getTokenNames()));
			}
		};
		try {
			return parser.parse();
		} catch (RecognitionException re) {
			Token t = AntlrExceptionTool.getToken(re);
			handler.handleParserError(TokenTool.getOffset(t), TokenTool
					.getLength(t), TokenTool.getText(t), re.getMessage());
		}
		return null;
	}
}
