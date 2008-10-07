package org.eclipse.xtext.parsetree.reconstr;

import java.util.Set;

import org.eclipse.xtext.service.AbstractServiceRegistrationFactory;

/**
 * used to register components to be used at runtime.
 */
public class ComplexReconstrTestRuntimeConfig extends AbstractServiceRegistrationFactory {

	public Set<IServiceRegistration> registrations() {
		return scope(org.eclipse.xtext.parsetree.reconstr.IComplexReconstrTest.SCOPE)
		.with(org.eclipse.xtext.IGrammarAccess.class, org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestGrammarAccess.class)
		.with(org.eclipse.xtext.IMetamodelAccess.class, org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestMetamodelAccess.class)
		.with(org.eclipse.xtext.parser.IAstFactory.class, org.eclipse.xtext.parser.GenericEcoreElementFactory.class)
		.with(org.eclipse.xtext.parser.IParser.class, org.eclipse.xtext.parsetree.reconstr.parser.ComplexReconstrTestParser.class)
		.with(org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider.class, org.eclipse.xtext.parsetree.reconstr.parser.ComplexReconstrTestAntlrTokenFileProvider.class)
		.with(org.eclipse.xtext.resource.IResourceFactory.class, org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestResourceFactory.class)
		.with(org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.class, org.eclipse.xtext.parsetree.reconstr.parsetree.reconstr.ComplexReconstrTestParseTreeConstructor.class)
		.with(org.eclipse.xtext.parser.antlr.Lexer.class, org.eclipse.xtext.parsetree.reconstr.parser.internal.InternalComplexReconstrTestLexer.class)
		
			.registrations();
	}

}
			
