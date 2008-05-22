
package org.eclipse.xtext.testlanguages.parser;

import java.util.List;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.LanguageFacadeFactory;
import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parser.IParseErrorHandler;
import org.eclipse.xtext.core.parsetree.LeafNode;

import org.eclipse.xtext.testlanguages.parser.internal.InternalTestLanguageLexer;
import org.eclipse.xtext.testlanguages.parser.internal.InternalTestLanguageParser;


public class TestLanguageParser extends org.eclipse.xtext.core.parser.AbstractParser {
	@Override
	protected EObject parse(ANTLRInputStream in, IElementFactory factory,
			final IParseErrorHandler handler) {
		InternalTestLanguageLexer lexer = new InternalTestLanguageLexer(in);
		CommonTokenStream stream = new CommonTokenStream(lexer);
		InternalTestLanguageParser parser = new InternalTestLanguageParser(
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
		return LanguageFacadeFactory.getFacade("org/eclipse/xtext/testlanguages/TestLanguage").getElementFactory();
	}
}
