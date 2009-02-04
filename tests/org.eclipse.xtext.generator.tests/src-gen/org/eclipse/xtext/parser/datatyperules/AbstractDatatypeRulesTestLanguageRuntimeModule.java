/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.datatyperules;

import org.eclipse.xtext.service.DefaultRuntimeModule;
import org.eclipse.xtext.service.IServiceScope;

import com.google.inject.Binder;

/**
 * GENERATED! Manual modification goes to DatatypeRulesTestLanguageRuntimeModule
 */
public abstract class AbstractDatatypeRulesTestLanguageRuntimeModule extends DefaultRuntimeModule {
	
	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(IServiceScope.class).toInstance(org.eclipse.xtext.parser.datatyperules.IDatatypeRulesTestLanguage.SCOPE);
	}
	
	public Class<? extends org.eclipse.xtext.IMetamodelAccess> bindIMetamodelAccess() {
		return org.eclipse.xtext.parser.datatyperules.services.DatatypeRulesTestLanguageMetamodelAccess.class;
	}
	public Class<? extends org.eclipse.xtext.IGrammarAccess> bindIGrammarAccess() {
		return org.eclipse.xtext.parser.datatyperules.services.DatatypeRulesTestLanguageGrammarAccess.class;
	}
	public Class<? extends org.eclipse.xtext.parser.IAstFactory> bindIAstFactory() {
		return org.eclipse.xtext.parser.DefaultEcoreElementFactory.class;
	}
	public Class<? extends org.eclipse.xtext.resource.IResourceFactory> bindIResourceFactory() {
		return org.eclipse.xtext.parser.datatyperules.services.DatatypeRulesTestLanguageResourceFactory.class;
	}
	public Class<? extends org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor> bindIParseTreeConstructor() {
		return org.eclipse.xtext.parser.datatyperules.parsetree.reconstr.DatatypeRulesTestLanguageParseTreeConstructor.class;
	}
	public Class<? extends org.eclipse.xtext.parsetree.reconstr.ITokenSerializer> bindITokenSerializer() {
		return org.eclipse.xtext.parsetree.reconstr.impl.WhitespacePreservingTokenSerializer.class;
	}
	public Class<? extends org.eclipse.xtext.parsetree.reconstr.ICrossReferenceSerializer> bindICrossReferenceSerializer() {
		return org.eclipse.xtext.parsetree.reconstr.impl.SimpleCrossReferenceSerializer.class;
	}
	public Class<? extends org.eclipse.xtext.parsetree.reconstr.ITransientValueService> bindITransientValueService() {
		return org.eclipse.xtext.parsetree.reconstr.impl.SimpleTransientValueService.class;
	}
	public Class<? extends org.eclipse.xtext.parser.antlr.IAntlrParser> bindIAntlrParser() {
		return org.eclipse.xtext.parser.datatyperules.parser.antlr.DatatypeRulesTestLanguageParser.class;
	}
	public Class<? extends org.eclipse.xtext.parser.ITokenToStringConverter> bindITokenToStringConverter() {
		return org.eclipse.xtext.parser.antlr.AntlrTokenToStringConverter.class;
	}
	public Class<? extends org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider> bindIAntlrTokenFileProvider() {
		return org.eclipse.xtext.parser.datatyperules.parser.antlr.DatatypeRulesTestLanguageAntlrTokenFileProvider.class;
	}
	public Class<? extends org.eclipse.xtext.parser.antlr.Lexer> bindLexer() {
		return org.eclipse.xtext.parser.datatyperules.parser.antlr.internal.InternalDatatypeRulesTestLanguageLexer.class;
	}
	public Class<? extends org.eclipse.xtext.parser.antlr.ITokenDefProvider> bindITokenDefProvider() {
		return org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider.class;
	}
	public Class<? extends org.eclipse.xtext.parser.packrat.IPackratParser> bindIPackratParser() {
		return org.eclipse.xtext.parser.datatyperules.parser.packrat.DatatypeRulesTestLanguagePackratParser.class;
	}
	public Class<? extends org.eclipse.xtext.parser.packrat.IParseResultFactory> bindIParseResultFactory() {
		return org.eclipse.xtext.parser.packrat.ParseResultFactory.class;
	}
	public Class<? extends org.eclipse.xtext.parser.ISwitchingParser> bindISwitchingParser() {
		return org.eclipse.xtext.parser.SwitchingParser.class;
	}
	
	
}
