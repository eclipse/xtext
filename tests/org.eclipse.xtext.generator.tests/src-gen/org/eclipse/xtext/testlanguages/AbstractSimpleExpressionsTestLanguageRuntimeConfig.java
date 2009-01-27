package org.eclipse.xtext.testlanguages;

import java.util.Set;

import org.eclipse.xtext.service.AbstractServiceRegistrationFactory;

/**
 * used to register components to be used at runtime.
 */
public abstract class AbstractSimpleExpressionsTestLanguageRuntimeConfig extends AbstractServiceRegistrationFactory {

	protected Class<? extends org.eclipse.xtext.IMetamodelAccess> getIMetamodelAccess() {
		return org.eclipse.xtext.testlanguages.services.SimpleExpressionsTestLanguageMetamodelAccess.class;
	}
		
	protected Class<? extends org.eclipse.xtext.IGrammarAccess> getIGrammarAccess() {
		return org.eclipse.xtext.testlanguages.services.SimpleExpressionsTestLanguageGrammarAccess.class;
	}
		
	protected Class<? extends org.eclipse.xtext.resource.IResourceFactory> getIResourceFactory() {
		return org.eclipse.xtext.testlanguages.services.SimpleExpressionsTestLanguageResourceFactory.class;
	}
		
	protected Class<? extends org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor> getIParseTreeConstructor() {
		return org.eclipse.xtext.testlanguages.parsetree.reconstr.SimpleExpressionsTestLanguageParseTreeConstructor.class;
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
		
	protected Class<? extends org.eclipse.xtext.parser.IAstFactory> getIAstFactory() {
		return org.eclipse.xtext.parser.antlr.AntlrEcoreElementFactory.class;
	}
		
	protected Class<? extends org.eclipse.xtext.parser.IParser> getIParser() {
		return org.eclipse.xtext.testlanguages.parser.antlr.SimpleExpressionsTestLanguageParser.class;
	}
		
	protected Class<? extends org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider> getIAntlrTokenFileProvider() {
		return org.eclipse.xtext.testlanguages.parser.antlr.SimpleExpressionsTestLanguageAntlrTokenFileProvider.class;
	}
		
	protected Class<? extends org.eclipse.xtext.parser.antlr.Lexer> getLexer() {
		return org.eclipse.xtext.testlanguages.parser.antlr.internal.InternalSimpleExpressionsTestLanguageLexer.class;
	}
		
	protected Class<? extends org.eclipse.xtext.parser.packrat.IPackratParser> getIPackratParser() {
		return org.eclipse.xtext.testlanguages.parser.packrat.SimpleExpressionsTestLanguagePackratParser.class;
	}
		
	
	public Set<IServiceRegistration> registrations() {
		return scope(org.eclipse.xtext.testlanguages.ISimpleExpressionsTestLanguage.SCOPE)
		.with(org.eclipse.xtext.IMetamodelAccess.class, getIMetamodelAccess())
		.with(org.eclipse.xtext.IGrammarAccess.class, getIGrammarAccess())
		.with(org.eclipse.xtext.resource.IResourceFactory.class, getIResourceFactory())
		.with(org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.class, getIParseTreeConstructor())
		.with(org.eclipse.xtext.parsetree.reconstr.ITokenSerializer.class, getITokenSerializer())
		.with(org.eclipse.xtext.parsetree.reconstr.ICrossReferenceSerializer.class, getICrossReferenceSerializer())
		.with(org.eclipse.xtext.parsetree.reconstr.ITransientValueService.class, getITransientValueService())
		.with(org.eclipse.xtext.parser.IAstFactory.class, getIAstFactory())
		.with(org.eclipse.xtext.parser.IParser.class, getIParser())
		.with(org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider.class, getIAntlrTokenFileProvider())
		.with(org.eclipse.xtext.parser.antlr.Lexer.class, getLexer())
		.with(org.eclipse.xtext.parser.packrat.IPackratParser.class, getIPackratParser())
		
			.registrations();
	}

}
			
