
package org.eclipse.xtext.dummy.parser;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.LanguageFacadeFactory;
import org.eclipse.xtext.dummy.parser.internal.InternalDummyLanguageLexer;
import org.eclipse.xtext.dummy.parser.internal.InternalDummyLanguageParser;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.LeafNode;

import org.eclipse.xtext.dummy.parser.internal.InternalDummyLanguageLexer;
import org.eclipse.xtext.dummy.parser.internal.InternalDummyLanguageParser;


public class DummyLanguageParser extends org.eclipse.xtext.parser.AbstractParser {
	@Override
	protected IParseResult parse(ANTLRInputStream in, IElementFactory factory,
			final IParseErrorHandler handler) {
		InternalDummyLanguageLexer lexer = new InternalDummyLanguageLexer(in);
		CommonTokenStream stream = new CommonTokenStream(lexer);
		InternalDummyLanguageParser parser = new InternalDummyLanguageParser(
				stream, factory) {
					@Override
			protected void reportError(IParseError error, RecognitionException re) {
				handler.handleParserError(error);
			}
		};
		try {
			return parser.parse();
		} catch (Exception re) {
			CommonToken lt = (CommonToken) parser.getInput().LT(parser.getInput().index());
			ParseError error = new ParseError(lt.getLine(), lt.getStartIndex(), lt.getText() != null ? lt.getText().length()
					: 0, lt.getText(), re.getMessage(), re);
			handler.handleParserError(error);
		}
		return null;
	}
	
	protected IElementFactory getDefaultASTFactory() {
		return LanguageFacadeFactory.getFacade("org/eclipse/xtext/dummy/DummyLanguage").getElementFactory();
	}
}
