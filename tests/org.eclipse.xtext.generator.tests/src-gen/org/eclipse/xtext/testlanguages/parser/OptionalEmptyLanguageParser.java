
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

import org.eclipse.xtext.testlanguages.parser.internal.InternalOptionalEmptyLanguageLexer;
import org.eclipse.xtext.testlanguages.parser.internal.InternalOptionalEmptyLanguageParser;


public class OptionalEmptyLanguageParser extends org.eclipse.xtext.core.parser.AbstractParser {
	@Override
	protected EObject parse(ANTLRInputStream in, IElementFactory factory,
			final IParseErrorHandler handler) {
		InternalOptionalEmptyLanguageLexer lexer = new InternalOptionalEmptyLanguageLexer(in);
		CommonTokenStream stream = new CommonTokenStream(lexer);
		InternalOptionalEmptyLanguageParser parser = new InternalOptionalEmptyLanguageParser(
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
		return LanguageFacadeFactory.getFacade("org/eclipse/xtext/testlanguages/OptionalEmptyLanguage").getElementFactory();
	}
}
