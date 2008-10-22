package org.eclipse.xtext.grammarinheritance;

import java.util.Set;

import org.eclipse.xtext.service.AbstractServiceRegistrationFactory;

/**
 * used to register components to be used at runtime.
 */
public class AbstractAbstractTestLanguageRuntimeConfig extends AbstractServiceRegistrationFactory {

	public Set<IServiceRegistration> registrations() {
		return scope(org.eclipse.xtext.grammarinheritance.IAbstractTestLanguage.SCOPE)
		.with(org.eclipse.xtext.IGrammarAccess.class, org.eclipse.xtext.grammarinheritance.services.AbstractTestLanguageGrammarAccess.class)
		.with(org.eclipse.xtext.IMetamodelAccess.class, org.eclipse.xtext.grammarinheritance.services.AbstractTestLanguageMetamodelAccess.class)
		
			.registrations();
	}

}
			
