
package org.eclipse.xtext.testlanguages.parser;


import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.eclipse.xtext.*;
import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parser.IParseErrorHandler;
import org.eclipse.xtext.core.parser.antlr.AntlrExceptionTool;
import org.eclipse.xtext.core.parser.antlr.TokenTool;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.testlanguages.parser.internal.InternalLexerLanguageLexer;
import org.eclipse.xtext.testlanguages.parser.internal.InternalLexerLanguageParser;


public class LexerLanguageParser extends org.eclipse.xtext.core.parser.AbstractParser {
	@Override
	protected EObject parse(ANTLRInputStream in, IElementFactory factory,
			final IParseErrorHandler handler) {
		InternalLexerLanguageLexer lexer = new InternalLexerLanguageLexer(in) {
			@Override
			public void reportError(RecognitionException re) {
				Token t = AntlrExceptionTool.getToken(re);
				handler.handleParserError(TokenTool.getLine(t), TokenTool.getOffset(t), TokenTool.getLength(t), -1, TokenTool.getText(t), getErrorMessage(
						re, getTokenNames()), re);
			}
		};
		CommonTokenStream stream = new CommonTokenStream(lexer);
		InternalLexerLanguageParser parser = new InternalLexerLanguageParser(
				stream, factory) {
			@Override
			public void reportError(RecognitionException re) {
				Token t = AntlrExceptionTool.getToken(re);
				handler.handleParserError(TokenTool.getLine(t), TokenTool.getOffset(t), TokenTool.getLength(t), t
						.getType(), TokenTool.getText(t), getErrorMessage(
						re, getTokenNames()), re);
			}
		};
		try {
			return parser.parse();
		} catch (RecognitionException re) {
			Token t = AntlrExceptionTool.getToken(re);
			handler.handleParserError(TokenTool.getLine(t), TokenTool.getOffset(t), TokenTool.getLength(t), t
						.getType(), TokenTool.getText(t), re.getMessage(), re);
		}
		return null;
	}
	
	protected IElementFactory getDefaultASTFactory() {
		return LanguageFacadeFactory.getFacade("org/eclipse/xtext/testlanguages/LexerLanguage").getElementFactory();
	}
}
