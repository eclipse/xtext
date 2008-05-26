
package org.eclipse.xtext.testlanguages.parser;

import java.util.List;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.LanguageFacadeFactory;
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.parser.IParseErrorHandler;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.LeafNode;

import org.eclipse.xtext.testlanguages.parser.internal.InternalLexerLanguageLexer;
import org.eclipse.xtext.testlanguages.parser.internal.InternalLexerLanguageParser;


public class LexerLanguageParser extends org.eclipse.xtext.parser.AbstractParser {
	@Override
	protected IParseResult parse(ANTLRInputStream in, IElementFactory factory,
			final IParseErrorHandler handler) {
		InternalLexerLanguageLexer lexer = new InternalLexerLanguageLexer(in);
		CommonTokenStream stream = new CommonTokenStream(lexer);
		InternalLexerLanguageParser parser = new InternalLexerLanguageParser(
				stream, factory) {
			@Override
			public void reportError(RecognitionException re, LeafNode ln) {
				handler.handleParserError(ln, getErrorMessage(
						re, getTokenNames()), re);
			}
		};
		try {
			return parser.parse();
		} catch (RecognitionException re) {
			handler.handleParserError(null, re.getMessage(), re);
		}
		return null;
	}
	
	protected IElementFactory getDefaultASTFactory() {
		return LanguageFacadeFactory.getFacade("org/eclipse/xtext/testlanguages/LexerLanguage").getElementFactory();
	}
}
