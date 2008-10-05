package org.eclipse.xtext.parsetree.reconstr;

import java.util.Set;

import org.eclipse.xtext.service.AbstractServiceRegistrationFactory;

/**
 * used to register components to be used at runtime.
 */
public class SimpleReconstrTestRuntimeConfig extends AbstractServiceRegistrationFactory {

	public Set<IServiceRegistration> registrations() {
		return scope(org.eclipse.xtext.parsetree.reconstr.ISimpleReconstrTest.SCOPE)
		.with(org.eclipse.xtext.IGrammarAccess.class, org.eclipse.xtext.parsetree.reconstr.services.SimpleReconstrTestGrammarAccess.class)
		.with(org.eclipse.xtext.IMetamodelAccess.class, org.eclipse.xtext.parsetree.reconstr.services.SimpleReconstrTestMetamodelAccess.class)
		.with(org.eclipse.xtext.parser.IAstFactory.class, org.eclipse.xtext.parser.GenericEcoreElementFactory.class)
		.with(org.eclipse.xtext.parser.IParser.class, org.eclipse.xtext.parsetree.reconstr.parser.SimpleReconstrTestParser.class)
		.with(org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider.class, org.eclipse.xtext.parsetree.reconstr.parser.SimpleReconstrTestAntlrTokenFileProvider.class)
		.with(org.eclipse.xtext.resource.IResourceFactory.class, org.eclipse.xtext.parsetree.reconstr.services.SimpleReconstrTestResourceFactory.class)
		.with(org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.class, org.eclipse.xtext.parsetree.reconstr.parsetree.reconstr.SimpleReconstrTestParseTreeConstructor.class)
		
			.registrations();
	}

}
			
