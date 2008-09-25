package org.eclipse.xtext.testlanguages;

import java.util.Set;

import org.eclipse.xtext.service.AbstractServiceRegistrationFactory;

/**
 * used to register components to be used at runtime.
 */
public class TestLanguageRuntimeConfig extends AbstractServiceRegistrationFactory {

	public Set<IServiceRegistration> registrations() {
		return scope(org.eclipse.xtext.testlanguages.ITestLanguage.SCOPE)
		.with(org.eclipse.xtext.IGrammarAccess.class, org.eclipse.xtext.testlanguages.services.TestLanguageGrammarAccess.class)
		.with(org.eclipse.xtext.IMetamodelAccess.class, org.eclipse.xtext.testlanguages.services.TestLanguageMetamodelAccess.class)
		.with(org.eclipse.xtext.parser.IAstFactory.class, org.eclipse.xtext.parser.GenericEcoreElementFactory.class)
		.with(org.eclipse.xtext.parser.IParser.class, org.eclipse.xtext.testlanguages.parser.TestLanguageParser.class)
		.with(org.eclipse.xtext.resource.IResourceFactory.class, org.eclipse.xtext.testlanguages.services.TestLanguageResourceFactory.class)
		.with(org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.class, org.eclipse.xtext.testlanguages.parsetree.reconstr.TestLanguageParseTreeConstructor.class)
		
			.registrations();
	}

}
			
