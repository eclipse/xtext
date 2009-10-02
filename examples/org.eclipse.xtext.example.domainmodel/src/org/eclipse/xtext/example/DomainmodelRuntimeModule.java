/*
Generated with Xtext
*/
package org.eclipse.xtext.example;

import org.eclipse.xtext.example.scoping.DomainmodelScopeProvider;
import org.eclipse.xtext.scoping.IQualifiedNameProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.namespaces.DefaultDeclarativeQualifiedNameProvider;


/**
 * used to register components to be used within the IDE.
 */
public class DomainmodelRuntimeModule extends AbstractDomainmodelRuntimeModule {
	
	@Override
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return DomainmodelScopeProvider.class;
	}
	
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return DefaultDeclarativeQualifiedNameProvider.class;
	}
}
