package org.eclipse.xtext.dummy;

import java.util.Set;

import org.eclipse.xtext.service.AbstractServiceRegistrationFactory;

/**
 * used to register components to be used at runtime.
 */
public class AbstractDummyLanguageRuntimeConfig extends AbstractServiceRegistrationFactory {

	public Set<IServiceRegistration> registrations() {
		return scope(org.eclipse.xtext.dummy.IDummyLanguage.SCOPE)
		.with(org.eclipse.xtext.IGrammarAccess.class, org.eclipse.xtext.dummy.services.DummyLanguageGrammarAccess.class)
		.with(org.eclipse.xtext.IMetamodelAccess.class, org.eclipse.xtext.dummy.services.DummyLanguageMetamodelAccess.class)
		.with(org.eclipse.xtext.parser.IAstFactory.class, org.eclipse.xtext.parser.GenericEcoreElementFactory.class)
		.with(org.eclipse.xtext.parser.IParser.class, org.eclipse.xtext.dummy.parser.DummyLanguageParser.class)
		.with(org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider.class, org.eclipse.xtext.dummy.parser.DummyLanguageAntlrTokenFileProvider.class)
		.with(org.eclipse.xtext.resource.IResourceFactory.class, org.eclipse.xtext.dummy.services.DummyLanguageResourceFactory.class)
		.with(org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.class, org.eclipse.xtext.dummy.parsetree.reconstr.DummyLanguageParseTreeConstructor.class)
		.with(org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructorCallback.class, org.eclipse.xtext.parsetree.reconstr.callbacks.WhitespacePreservingCallback.class)
		.with(org.eclipse.xtext.parsetree.reconstr.ICrossReferenceSerializer.class, org.eclipse.xtext.parsetree.reconstr.impl.SimpleCrossReferenceSerializer.class)
		.with(org.eclipse.xtext.parser.antlr.Lexer.class, org.eclipse.xtext.dummy.parser.internal.InternalDummyLanguageLexer.class)
		
			.registrations();
	}

}
			
