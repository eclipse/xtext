package org.eclipse.xtext.ui.core;

import java.util.Set;

import org.eclipse.xtext.service.AbstractServiceRegistrationFactory;

/**
 * used to register components to be used at runtime.
 */
public class TestLanguageRuntimeConfig extends AbstractServiceRegistrationFactory {

	public Set<IServiceRegistration> registrations() {
		return scope(org.eclipse.xtext.ui.core.ITestLanguage.SCOPE)
		.with(org.eclipse.xtext.IGrammarAccess.class, org.eclipse.xtext.ui.core.services.TestLanguageGrammarAccess.class)
		.with(org.eclipse.xtext.IMetamodelAccess.class, org.eclipse.xtext.ui.core.services.TestLanguageMetamodelAccess.class)
		.with(org.eclipse.xtext.parser.IAstFactory.class, org.eclipse.xtext.parser.GenericEcoreElementFactory.class)
		.with(org.eclipse.xtext.parser.IParser.class, org.eclipse.xtext.ui.core.parser.TestLanguageParser.class)
		.with(org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider.class, org.eclipse.xtext.ui.core.parser.TestLanguageAntlrTokenFileProvider.class)
		.with(org.eclipse.xtext.resource.IResourceFactory.class, org.eclipse.xtext.ui.core.services.TestLanguageResourceFactory.class)
		.with(org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.class, org.eclipse.xtext.ui.core.parsetree.reconstr.TestLanguageParseTreeConstructor.class)
		.with(org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructorCallback.class, org.eclipse.xtext.parsetree.reconstr.callbacks.WhitespacePreservingCallback.class)
		.with(org.eclipse.xtext.parser.antlr.Lexer.class, org.eclipse.xtext.ui.core.parser.internal.InternalTestLanguageLexer.class)
		
			.registrations();
	}

}
			
