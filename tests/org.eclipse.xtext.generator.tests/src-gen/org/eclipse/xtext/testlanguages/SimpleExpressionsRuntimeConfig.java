package org.eclipse.xtext.testlanguages;

import java.util.Set;

import org.eclipse.xtext.service.AbstractServiceRegistrationFactory;

/**
 * used to register components to be used at runtime.
 */
public class SimpleExpressionsRuntimeConfig extends AbstractServiceRegistrationFactory {

	public Set<IServiceRegistration> registrations() {
		return scope(org.eclipse.xtext.testlanguages.ISimpleExpressions.SCOPE)
		.with(org.eclipse.xtext.IGrammarAccess.class, org.eclipse.xtext.testlanguages.services.SimpleExpressionsGrammarAccess.class)
		.with(org.eclipse.xtext.IMetamodelAccess.class, org.eclipse.xtext.testlanguages.services.SimpleExpressionsMetamodelAccess.class)
		.with(org.eclipse.xtext.parser.IAstFactory.class, org.eclipse.xtext.parser.GenericEcoreElementFactory.class)
		.with(org.eclipse.xtext.parser.IParser.class, org.eclipse.xtext.testlanguages.parser.SimpleExpressionsParser.class)
		.with(org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider.class, org.eclipse.xtext.testlanguages.parser.SimpleExpressionsAntlrTokenFileProvider.class)
		.with(org.eclipse.xtext.resource.IResourceFactory.class, org.eclipse.xtext.testlanguages.services.SimpleExpressionsResourceFactory.class)
		.with(org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.class, org.eclipse.xtext.testlanguages.parsetree.reconstr.SimpleExpressionsParseTreeConstructor.class)
		.with(org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructorCallback.class, org.eclipse.xtext.parsetree.reconstr.callbacks.WhitespacePreservingCallback.class)
		.with(org.eclipse.xtext.parsetree.reconstr.ICrossReferenceSerializer.class, org.eclipse.xtext.parsetree.reconstr.impl.SimpleCrossReferenceSerializer.class)
		.with(org.eclipse.xtext.parser.antlr.Lexer.class, org.eclipse.xtext.testlanguages.parser.internal.InternalSimpleExpressionsLexer.class)
		
			.registrations();
	}

}
			
