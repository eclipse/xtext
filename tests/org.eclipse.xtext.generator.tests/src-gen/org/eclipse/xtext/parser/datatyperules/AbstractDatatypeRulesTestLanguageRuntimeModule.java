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
	
	@Override
	protected Class<? extends org.eclipse.xtext.IMetamodelAccess> getIMetamodelAccess() {
		return org.eclipse.xtext.parser.datatyperules.services.DatatypeRulesTestLanguageMetamodelAccess.class;
	}
	@Override
	protected Class<? extends org.eclipse.xtext.IGrammarAccess> getIGrammarAccess() {
		return org.eclipse.xtext.parser.datatyperules.services.DatatypeRulesTestLanguageGrammarAccess.class;
	}
	@Override
	protected Class<? extends org.eclipse.xtext.parser.IAstFactory> getIAstFactory() {
		return org.eclipse.xtext.parser.DefaultEcoreElementFactory.class;
	}
	@Override
	protected Class<? extends org.eclipse.xtext.resource.IResourceFactory> getIResourceFactory() {
		return org.eclipse.xtext.parser.datatyperules.services.DatatypeRulesTestLanguageResourceFactory.class;
	}
	@Override
	protected Class<? extends org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor> getIParseTreeConstructor() {
		return org.eclipse.xtext.parser.datatyperules.parsetree.reconstr.DatatypeRulesTestLanguageParseTreeConstructor.class;
	}
	@Override
	protected Class<? extends org.eclipse.xtext.parsetree.reconstr.ITokenSerializer> getITokenSerializer() {
		return org.eclipse.xtext.parsetree.reconstr.impl.WhitespacePreservingTokenSerializer.class;
	}
	@Override
	protected Class<? extends org.eclipse.xtext.parsetree.reconstr.ICrossReferenceSerializer> getICrossReferenceSerializer() {
		return org.eclipse.xtext.parsetree.reconstr.impl.SimpleCrossReferenceSerializer.class;
	}
	@Override
	protected Class<? extends org.eclipse.xtext.parsetree.reconstr.ITransientValueService> getITransientValueService() {
		return org.eclipse.xtext.parsetree.reconstr.impl.SimpleTransientValueService.class;
	}
	@Override
	protected Class<? extends org.eclipse.xtext.parser.antlr.IAntlrParser> getIAntlrParser() {
		return org.eclipse.xtext.parser.datatyperules.parser.antlr.DatatypeRulesTestLanguageParser.class;
	}
	@Override
	protected Class<? extends org.eclipse.xtext.parser.ITokenToStringConverter> getITokenToStringConverter() {
		return org.eclipse.xtext.parser.antlr.AntlrTokenToStringConverter.class;
	}
	@Override
	protected Class<? extends org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider> getIAntlrTokenFileProvider() {
		return org.eclipse.xtext.parser.datatyperules.parser.antlr.DatatypeRulesTestLanguageAntlrTokenFileProvider.class;
	}
	@Override
	protected Class<? extends org.eclipse.xtext.parser.antlr.Lexer> getLexer() {
		return org.eclipse.xtext.parser.datatyperules.parser.antlr.internal.InternalDatatypeRulesTestLanguageLexer.class;
	}
	@Override
	protected Class<? extends org.eclipse.xtext.parser.packrat.IPackratParser> getIPackratParser() {
		return org.eclipse.xtext.parser.datatyperules.parser.packrat.DatatypeRulesTestLanguagePackratParser.class;
	}
	@Override
	protected Class<? extends org.eclipse.xtext.parser.packrat.IParseResultFactory> getIParseResultFactory() {
		return org.eclipse.xtext.parser.packrat.ParseResultFactory.class;
	}
	@Override
	protected Class<? extends org.eclipse.xtext.parser.ISwitchingParser> getISwitchingParser() {
		return org.eclipse.xtext.parser.SwitchingParser.class;
	}
	
	
}
