package org.eclipse.xtext.metamodelreferencing.tests;

import java.util.Set;

import org.eclipse.xtext.service.AbstractServiceRegistrationFactory;

/**
 * used to register components to be used at runtime.
 */
public class MetamodelRefTestRuntimeConfig extends AbstractServiceRegistrationFactory {

	public Set<IServiceRegistration> registrations() {
		return scope(org.eclipse.xtext.metamodelreferencing.tests.IMetamodelRefTest.SCOPE)
		.with(org.eclipse.xtext.IGrammarAccess.class, org.eclipse.xtext.metamodelreferencing.tests.services.MetamodelRefTestGrammarAccess.class)
		.with(org.eclipse.xtext.IMetamodelAccess.class, org.eclipse.xtext.metamodelreferencing.tests.services.MetamodelRefTestMetamodelAccess.class)
		.with(org.eclipse.xtext.parser.IAstFactory.class, org.eclipse.xtext.parser.GenericEcoreElementFactory.class)
		.with(org.eclipse.xtext.parser.IParser.class, org.eclipse.xtext.metamodelreferencing.tests.parser.MetamodelRefTestParser.class)
		.with(org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider.class, org.eclipse.xtext.metamodelreferencing.tests.parser.MetamodelRefTestAntlrTokenFileProvider.class)
		.with(org.eclipse.xtext.resource.IResourceFactory.class, org.eclipse.xtext.metamodelreferencing.tests.services.MetamodelRefTestResourceFactory.class)
		.with(org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.class, org.eclipse.xtext.metamodelreferencing.tests.parsetree.reconstr.MetamodelRefTestParseTreeConstructor.class)
		
			.registrations();
	}

}
			
