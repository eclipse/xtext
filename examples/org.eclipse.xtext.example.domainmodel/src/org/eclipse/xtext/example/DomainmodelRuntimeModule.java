/*
Generated with Xtext
*/
package org.eclipse.xtext.example;

import org.eclipse.emf.index.IndexStore;
import org.eclipse.emf.index.impl.PersistableIndexStore;
import org.eclipse.xtext.index.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.index.DefaultIndexBasedScopeProvider;
import org.eclipse.xtext.index.IQualifiedNameProvider;
import org.eclipse.xtext.scoping.IScopeProvider;


/**
 * used to register components to be used within the IDE.
 */
public class DomainmodelRuntimeModule extends AbstractDomainmodelRuntimeModule {
	
	public IndexStore bindIndexStore() {
		return new PersistableIndexStore();
	}
	
	@Override
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return DefaultIndexBasedScopeProvider.class;
	}
	
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return DefaultDeclarativeQualifiedNameProvider.class;
	}
}
