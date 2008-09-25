package org.eclipse.xtext.grammarinheritance;

import java.util.Set;

import org.eclipse.xtext.service.AbstractServiceRegistrationFactory;

/**
 * used to register components to be used at runtime.
 */
public class ConcreteTestLanguageRuntimeConfig extends AbstractServiceRegistrationFactory {

	public Set<IServiceRegistration> registrations() {
		return scope(org.eclipse.xtext.grammarinheritance.IConcreteTestLanguage.SCOPE)
		.with(org.eclipse.xtext.IGrammarAccess.class, org.eclipse.xtext.grammarinheritance.services.ConcreteTestLanguageGrammarAccess.class)
		.with(org.eclipse.xtext.IMetamodelAccess.class, org.eclipse.xtext.grammarinheritance.services.ConcreteTestLanguageMetamodelAccess.class)
		.with(org.eclipse.xtext.parser.IAstFactory.class, org.eclipse.xtext.parser.GenericEcoreElementFactory.class)
		.with(org.eclipse.xtext.parser.IParser.class, org.eclipse.xtext.grammarinheritance.parser.ConcreteTestLanguageParser.class)
		.with(org.eclipse.xtext.resource.IResourceFactory.class, org.eclipse.xtext.grammarinheritance.services.ConcreteTestLanguageResourceFactory.class)
		.with(org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.class, org.eclipse.xtext.grammarinheritance.parsetree.reconstr.ConcreteTestLanguageParseTreeConstructor.class)
		
			.registrations();
	}

}
			
