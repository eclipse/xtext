package org.eclipse.xtext.testlanguages;

import java.util.Set;

import org.eclipse.xtext.service.AbstractServiceRegistrationFactory;

/**
 * used to register components to be used at runtime.
 */
public class ReferenceGrammarRuntimeConfig extends AbstractServiceRegistrationFactory {

	public Set<IServiceRegistration> registrations() {
		return scope(org.eclipse.xtext.testlanguages.IReferenceGrammar.SCOPE)
		.with(org.eclipse.xtext.IGrammarAccess.class, org.eclipse.xtext.testlanguages.services.ReferenceGrammarGrammarAccess.class)
		.with(org.eclipse.xtext.IMetamodelAccess.class, org.eclipse.xtext.testlanguages.services.ReferenceGrammarMetamodelAccess.class)
		.with(org.eclipse.xtext.parser.IAstFactory.class, org.eclipse.xtext.parser.GenericEcoreElementFactory.class)
		.with(org.eclipse.xtext.parser.IParser.class, org.eclipse.xtext.testlanguages.parser.ReferenceGrammarParser.class)
		.with(org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider.class, org.eclipse.xtext.testlanguages.parser.ReferenceGrammarAntlrTokenFileProvider.class)
		.with(org.eclipse.xtext.resource.IResourceFactory.class, org.eclipse.xtext.testlanguages.services.ReferenceGrammarResourceFactory.class)
		.with(org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.class, org.eclipse.xtext.testlanguages.parsetree.reconstr.ReferenceGrammarParseTreeConstructor.class)
		.with(org.eclipse.xtext.parser.antlr.Lexer.class, org.eclipse.xtext.testlanguages.parser.internal.InternalReferenceGrammarLexer.class)
		
			.registrations();
	}

}
			
