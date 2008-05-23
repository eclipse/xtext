
package org.eclipse.xtext.parsetree.reconstr.parser;

import java.util.List;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.LanguageFacadeFactory;
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.parser.IParseErrorHandler;
import org.eclipse.xtext.parsetree.LeafNode;

import org.eclipse.xtext.parsetree.reconstr.parser.internal.InternalSimpleReconstrTestLexer;
import org.eclipse.xtext.parsetree.reconstr.parser.internal.InternalSimpleReconstrTestParser;


public class SimpleReconstrTestParser extends org.eclipse.xtext.parser.AbstractParser {
	@Override
	protected EObject parse(ANTLRInputStream in, IElementFactory factory,
			final IParseErrorHandler handler) {
		InternalSimpleReconstrTestLexer lexer = new InternalSimpleReconstrTestLexer(in);
		CommonTokenStream stream = new CommonTokenStream(lexer);
		InternalSimpleReconstrTestParser parser = new InternalSimpleReconstrTestParser(
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
		return LanguageFacadeFactory.getFacade("org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest").getElementFactory();
	}
}
