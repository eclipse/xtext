
package org.eclipse.xtext.dummy.parser;

import java.util.List;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.LanguageFacadeFactory;
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.parser.IParseErrorHandler;
import org.eclipse.xtext.parsetree.LeafNode;

import org.eclipse.xtext.dummy.parser.internal.InternalDummyLanguageLexer;
import org.eclipse.xtext.dummy.parser.internal.InternalDummyLanguageParser;


public class DummyLanguageParser extends org.eclipse.xtext.parser.AbstractParser {
	@Override
	protected EObject parse(ANTLRInputStream in, IElementFactory factory,
			final IParseErrorHandler handler) {
		InternalDummyLanguageLexer lexer = new InternalDummyLanguageLexer(in);
		CommonTokenStream stream = new CommonTokenStream(lexer);
		InternalDummyLanguageParser parser = new InternalDummyLanguageParser(
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
		return LanguageFacadeFactory.getFacade("org/eclipse/xtext/dummy/DummyLanguage").getElementFactory();
	}
}
