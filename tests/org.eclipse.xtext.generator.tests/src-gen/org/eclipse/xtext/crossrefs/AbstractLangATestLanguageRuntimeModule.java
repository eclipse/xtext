/*
Generated with Xtext
*/
package org.eclipse.xtext.crossrefs;

import org.eclipse.xtext.service.DefaultRuntimeModule;
import org.eclipse.xtext.service.IServiceScope;

import com.google.inject.Binder;

/**
 * GENERATED! Manual modification goes to LangATestLanguageRuntimeModule
 */
public abstract class AbstractLangATestLanguageRuntimeModule extends DefaultRuntimeModule {
	
	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(IServiceScope.class).toInstance(org.eclipse.xtext.crossrefs.ILangATestLanguage.SCOPE);
	}
	
	@Override
	protected Class<? extends org.eclipse.xtext.IMetamodelAccess> getIMetamodelAccess() {
		return org.eclipse.xtext.crossrefs.services.LangATestLanguageMetamodelAccess.class;
	}
	@Override
	protected Class<? extends org.eclipse.xtext.IGrammarAccess> getIGrammarAccess() {
		return org.eclipse.xtext.crossrefs.services.LangATestLanguageGrammarAccess.class;
	}
	@Override
	protected Class<? extends org.eclipse.xtext.parser.IAstFactory> getIAstFactory() {
		return org.eclipse.xtext.parser.DefaultEcoreElementFactory.class;
	}
	@Override
	protected Class<? extends org.eclipse.xtext.resource.IResourceFactory> getIResourceFactory() {
		return org.eclipse.xtext.crossrefs.services.LangATestLanguageResourceFactory.class;
	}
	@Override
	protected Class<? extends org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor> getIParseTreeConstructor() {
		return org.eclipse.xtext.crossrefs.parsetree.reconstr.LangATestLanguageParseTreeConstructor.class;
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
		return org.eclipse.xtext.crossrefs.parser.antlr.LangATestLanguageParser.class;
	}
	@Override
	protected Class<? extends org.eclipse.xtext.parser.ITokenToStringConverter> getITokenToStringConverter() {
		return org.eclipse.xtext.parser.antlr.AntlrTokenToStringConverter.class;
	}
	@Override
	protected Class<? extends org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider> getIAntlrTokenFileProvider() {
		return org.eclipse.xtext.crossrefs.parser.antlr.LangATestLanguageAntlrTokenFileProvider.class;
	}
	@Override
	protected Class<? extends org.eclipse.xtext.parser.antlr.Lexer> getLexer() {
		return org.eclipse.xtext.crossrefs.parser.antlr.internal.InternalLangATestLanguageLexer.class;
	}
	@Override
	protected Class<? extends org.eclipse.xtext.parser.packrat.IPackratParser> getIPackratParser() {
		return org.eclipse.xtext.crossrefs.parser.packrat.LangATestLanguagePackratParser.class;
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
