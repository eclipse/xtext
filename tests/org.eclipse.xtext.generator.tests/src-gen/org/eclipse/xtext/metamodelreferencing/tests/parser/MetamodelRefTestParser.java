
package org.eclipse.xtext.metamodelreferencing.tests.parser;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.LanguageFacadeFactory;
import org.eclipse.xtext.service.InjectedService;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.LeafNode;

import org.eclipse.xtext.metamodelreferencing.tests.parser.internal.InternalMetamodelRefTestLexer;
import org.eclipse.xtext.metamodelreferencing.tests.parser.internal.InternalMetamodelRefTestParser;


public class MetamodelRefTestParser extends org.eclipse.xtext.parser.AbstractParser {
	private IElementFactory astElementFactory;
	
	@Override
	protected IParseResult parse(ANTLRInputStream in, IElementFactory factory,
			final IParseErrorHandler handler) {
		InternalMetamodelRefTestLexer lexer = new InternalMetamodelRefTestLexer(in);
		CommonTokenStream stream = new CommonTokenStream(lexer);
		InternalMetamodelRefTestParser parser = new InternalMetamodelRefTestParser(
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
	
	@InjectedService
	public void setDefaultASTElementFactory(IElementFactory astElementFactory) {
		this.astElementFactory = astElementFactory;
	}
	
	protected IElementFactory getDefaultASTFactory() {
		return LanguageFacadeFactory.getFacade("org.eclipse.xtext.metamodelreferencing.tests.MetamodelRefTest").getElementFactory();
	}
}
