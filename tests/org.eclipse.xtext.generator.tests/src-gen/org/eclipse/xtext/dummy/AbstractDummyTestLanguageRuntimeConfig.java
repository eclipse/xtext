package org.eclipse.xtext.dummy;

import java.util.Set;

import org.eclipse.xtext.service.AbstractServiceRegistrationFactory;

/**
 * used to register components to be used at runtime.
 */
public abstract class AbstractDummyTestLanguageRuntimeConfig extends AbstractServiceRegistrationFactory {

	protected Class<? extends org.eclipse.xtext.IMetamodelAccess> getIMetamodelAccess() {
		return org.eclipse.xtext.dummy.services.DummyTestLanguageMetamodelAccess.class;
	}
		
	protected Class<? extends org.eclipse.xtext.IGrammarAccess> getIGrammarAccess() {
		return org.eclipse.xtext.dummy.services.DummyTestLanguageGrammarAccess.class;
	}
		
	protected Class<? extends org.eclipse.xtext.parser.IAstFactory> getIAstFactory() {
		return org.eclipse.xtext.parser.DefaultEcoreElementFactory.class;
	}
		
	protected Class<? extends org.eclipse.xtext.resource.IResourceFactory> getIResourceFactory() {
		return org.eclipse.xtext.dummy.services.DummyTestLanguageResourceFactory.class;
	}
		
	protected Class<? extends org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor> getIParseTreeConstructor() {
		return org.eclipse.xtext.dummy.parsetree.reconstr.DummyTestLanguageParseTreeConstructor.class;
	}
		
	protected Class<? extends org.eclipse.xtext.parsetree.reconstr.ITokenSerializer> getITokenSerializer() {
		return org.eclipse.xtext.parsetree.reconstr.impl.WhitespacePreservingTokenSerializer.class;
	}
		
	protected Class<? extends org.eclipse.xtext.parsetree.reconstr.ICrossReferenceSerializer> getICrossReferenceSerializer() {
		return org.eclipse.xtext.parsetree.reconstr.impl.SimpleCrossReferenceSerializer.class;
	}
		
	protected Class<? extends org.eclipse.xtext.parsetree.reconstr.ITransientValueService> getITransientValueService() {
		return org.eclipse.xtext.parsetree.reconstr.impl.SimpleTransientValueService.class;
	}
		
	protected Class<? extends org.eclipse.xtext.parser.antlr.IAntlrParser> getIAntlrParser() {
		return org.eclipse.xtext.dummy.parser.antlr.DummyTestLanguageParser.class;
	}
		
	protected Class<? extends org.eclipse.xtext.parser.ITokenToStringConverter> getITokenToStringConverter() {
		return org.eclipse.xtext.parser.antlr.AntlrTokenToStringConverter.class;
	}
		
	protected Class<? extends org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider> getIAntlrTokenFileProvider() {
		return org.eclipse.xtext.dummy.parser.antlr.DummyTestLanguageAntlrTokenFileProvider.class;
	}
		
	protected Class<? extends org.eclipse.xtext.parser.antlr.Lexer> getLexer() {
		return org.eclipse.xtext.dummy.parser.antlr.internal.InternalDummyTestLanguageLexer.class;
	}
		
	protected Class<? extends org.eclipse.xtext.parser.packrat.IPackratParser> getIPackratParser() {
		return org.eclipse.xtext.dummy.parser.packrat.DummyTestLanguagePackratParser.class;
	}
		
	protected Class<? extends org.eclipse.xtext.parser.packrat.IParseResultFactory> getIParseResultFactory() {
		return org.eclipse.xtext.parser.packrat.ParseResultFactory.class;
	}
		
	protected Class<? extends org.eclipse.xtext.parser.ISwitchingParser> getISwitchingParser() {
		return org.eclipse.xtext.parser.SwitchingParser.class;
	}
		
	
	public Set<IServiceRegistration> registrations() {
		return scope(org.eclipse.xtext.dummy.IDummyTestLanguage.SCOPE)
		.with(org.eclipse.xtext.IMetamodelAccess.class, getIMetamodelAccess())
		.with(org.eclipse.xtext.IGrammarAccess.class, getIGrammarAccess())
		.with(org.eclipse.xtext.parser.IAstFactory.class, getIAstFactory())
		.with(org.eclipse.xtext.resource.IResourceFactory.class, getIResourceFactory())
		.with(org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.class, getIParseTreeConstructor())
		.with(org.eclipse.xtext.parsetree.reconstr.ITokenSerializer.class, getITokenSerializer())
		.with(org.eclipse.xtext.parsetree.reconstr.ICrossReferenceSerializer.class, getICrossReferenceSerializer())
		.with(org.eclipse.xtext.parsetree.reconstr.ITransientValueService.class, getITransientValueService())
		.with(org.eclipse.xtext.parser.antlr.IAntlrParser.class, getIAntlrParser())
		.with(org.eclipse.xtext.parser.ITokenToStringConverter.class, getITokenToStringConverter())
		.with(org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider.class, getIAntlrTokenFileProvider())
		.with(org.eclipse.xtext.parser.antlr.Lexer.class, getLexer())
		.with(org.eclipse.xtext.parser.packrat.IPackratParser.class, getIPackratParser())
		.with(org.eclipse.xtext.parser.packrat.IParseResultFactory.class, getIParseResultFactory())
		.with(org.eclipse.xtext.parser.ISwitchingParser.class, getISwitchingParser())
		
			.registrations();
	}

}
			
