
package org.eclipse.xtext.parser;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.LanguageFacadeFactory;
import org.eclipse.xtext.parser.internal.InternalXtextLexer;
import org.eclipse.xtext.parser.internal.InternalXtextParser;
import org.eclipse.xtext.parsetree.LeafNode;


public class XtextParser extends org.eclipse.xtext.parser.AbstractParser {
	@Override
	protected IParseResult parse(ANTLRInputStream in, IElementFactory factory,
			final IParseErrorHandler handler) {
		InternalXtextLexer lexer = new InternalXtextLexer(in);
		CommonTokenStream stream = new CommonTokenStream(lexer);
		InternalXtextParser parser = new InternalXtextParser(
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
		return LanguageFacadeFactory.getFacade("org/eclipse/xtext/Xtext").getElementFactory();
	}
}
