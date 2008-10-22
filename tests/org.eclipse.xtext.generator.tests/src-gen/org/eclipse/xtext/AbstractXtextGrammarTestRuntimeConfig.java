package org.eclipse.xtext;

import java.util.Set;

import org.eclipse.xtext.service.AbstractServiceRegistrationFactory;

/**
 * used to register components to be used at runtime.
 */
public class AbstractXtextGrammarTestRuntimeConfig extends AbstractServiceRegistrationFactory {

	public Set<IServiceRegistration> registrations() {
		return scope(org.eclipse.xtext.IXtextGrammarTest.SCOPE)
		.with(org.eclipse.xtext.IGrammarAccess.class, org.eclipse.xtext.services.XtextGrammarTestGrammarAccess.class)
		.with(org.eclipse.xtext.IMetamodelAccess.class, org.eclipse.xtext.services.XtextGrammarTestMetamodelAccess.class)
		.with(org.eclipse.xtext.parser.IAstFactory.class, org.eclipse.xtext.parser.GenericEcoreElementFactory.class)
		.with(org.eclipse.xtext.parser.IParser.class, org.eclipse.xtext.parser.XtextGrammarTestParser.class)
		.with(org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider.class, org.eclipse.xtext.parser.XtextGrammarTestAntlrTokenFileProvider.class)
		.with(org.eclipse.xtext.resource.IResourceFactory.class, org.eclipse.xtext.services.XtextGrammarTestResourceFactory.class)
		.with(org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.class, org.eclipse.xtext.parsetree.reconstr.XtextGrammarTestParseTreeConstructor.class)
		.with(org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructorCallback.class, org.eclipse.xtext.parsetree.reconstr.callbacks.WhitespacePreservingCallback.class)
		.with(org.eclipse.xtext.parsetree.reconstr.ICrossReferenceSerializer.class, org.eclipse.xtext.parsetree.reconstr.impl.SimpleCrossReferenceSerializer.class)
		.with(org.eclipse.xtext.parser.antlr.Lexer.class, org.eclipse.xtext.parser.internal.InternalXtextGrammarTestLexer.class)
		
			.registrations();
	}

}
			
