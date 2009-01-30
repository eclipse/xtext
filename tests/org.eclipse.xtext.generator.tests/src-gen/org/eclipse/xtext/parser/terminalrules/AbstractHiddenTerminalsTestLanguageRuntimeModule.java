/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules;

import org.eclipse.xtext.service.DefaultRuntimeModule;
import org.eclipse.xtext.service.IServiceScope;

import com.google.inject.Binder;

/**
 * GENERATED! Manual modification goes to HiddenTerminalsTestLanguageRuntimeModule
 */
public abstract class AbstractHiddenTerminalsTestLanguageRuntimeModule extends DefaultRuntimeModule {
	
	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(IServiceScope.class).toInstance(org.eclipse.xtext.parser.terminalrules.IHiddenTerminalsTestLanguage.SCOPE);
	}
	
	@Override
	protected Class<? extends org.eclipse.xtext.IMetamodelAccess> getIMetamodelAccess() {
		return org.eclipse.xtext.parser.terminalrules.services.HiddenTerminalsTestLanguageMetamodelAccess.class;
	}
	@Override
	protected Class<? extends org.eclipse.xtext.IGrammarAccess> getIGrammarAccess() {
		return org.eclipse.xtext.parser.terminalrules.services.HiddenTerminalsTestLanguageGrammarAccess.class;
	}
	@Override
	protected Class<? extends org.eclipse.xtext.parser.IAstFactory> getIAstFactory() {
		return org.eclipse.xtext.parser.DefaultEcoreElementFactory.class;
	}
	@Override
	protected Class<? extends org.eclipse.xtext.resource.IResourceFactory> getIResourceFactory() {
		return org.eclipse.xtext.parser.terminalrules.services.HiddenTerminalsTestLanguageResourceFactory.class;
	}
	@Override
	protected Class<? extends org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor> getIParseTreeConstructor() {
		return org.eclipse.xtext.parser.terminalrules.parsetree.reconstr.HiddenTerminalsTestLanguageParseTreeConstructor.class;
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
		return org.eclipse.xtext.parser.terminalrules.parser.antlr.HiddenTerminalsTestLanguageParser.class;
	}
	@Override
	protected Class<? extends org.eclipse.xtext.parser.ITokenToStringConverter> getITokenToStringConverter() {
		return org.eclipse.xtext.parser.antlr.AntlrTokenToStringConverter.class;
	}
	@Override
	protected Class<? extends org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider> getIAntlrTokenFileProvider() {
		return org.eclipse.xtext.parser.terminalrules.parser.antlr.HiddenTerminalsTestLanguageAntlrTokenFileProvider.class;
	}
	@Override
	protected Class<? extends org.eclipse.xtext.parser.antlr.Lexer> getLexer() {
		return org.eclipse.xtext.parser.terminalrules.parser.antlr.internal.InternalHiddenTerminalsTestLanguageLexer.class;
	}
	@Override
	protected Class<? extends org.eclipse.xtext.parser.packrat.IPackratParser> getIPackratParser() {
		return org.eclipse.xtext.parser.terminalrules.parser.packrat.HiddenTerminalsTestLanguagePackratParser.class;
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
