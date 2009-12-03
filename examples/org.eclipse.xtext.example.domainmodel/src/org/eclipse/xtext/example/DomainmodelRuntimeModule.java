/*
Generated with Xtext
*/
package org.eclipse.xtext.example;

import org.eclipse.xtext.example.scoping.DomainmodelScopeProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.namespaces.QualifiedNameScopeProvider;

import com.google.inject.Binder;


/**
 * used to register components to be used within the IDE.
 */
public class DomainmodelRuntimeModule extends AbstractDomainmodelRuntimeModule {
	
	@Override
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return DomainmodelScopeProvider.class;
	}
	
	@Override
	public void configureIScopeProviderDelegate(Binder binder) {
		binder.bind(org.eclipse.xtext.scoping.IScopeProvider.class).annotatedWith(com.google.inject.name.Names.named("org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider.delegate")).to(QualifiedNameScopeProvider.class);
	}
	
}
