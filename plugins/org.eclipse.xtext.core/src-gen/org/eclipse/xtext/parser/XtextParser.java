
package org.eclipse.xtext.parser;


import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.LanguageFacadeFactory;
import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parser.IParseErrorHandler;
import org.eclipse.xtext.parser.internal.InternalXtextLexer;
import org.eclipse.xtext.parser.internal.InternalXtextParser;


public class XtextParser extends org.eclipse.xtext.core.parser.AbstractParser {
	@Override
	protected EObject parse(ANTLRInputStream in, IElementFactory factory,
			final IParseErrorHandler handler) {
		InternalXtextLexer lexer = new InternalXtextLexer(in);
		CommonTokenStream stream = new CommonTokenStream(lexer);
		InternalXtextParser parser = new InternalXtextParser(
				stream, factory) {
			@Override
			public void reportError(RecognitionException re) {
				handler.handleParserError(null, getErrorMessage(
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
		return LanguageFacadeFactory.getFacade("org/eclipse/xtext/Xtext").getElementFactory();
	}
}
