/*
Generated with Xtext
*/
package org.eclipse.xtext.example;

import org.eclipse.emf.emfindex.Index;
import org.eclipse.emf.emfindex.MemoryIndexImpl;
import org.eclipse.xtext.example.scoping.DomainmodelScopeProvider;
import org.eclipse.xtext.scoping.IQualifiedNameProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.DefaultDeclarativeQualifiedNameProvider;

import com.google.inject.Provider;


/**
 * used to register components to be used within the IDE.
 */
public class DomainmodelRuntimeModule extends AbstractDomainmodelRuntimeModule {
	
	public Provider<Index> provideIndex() {
		return new Provider<Index>() {
			public Index get() {
				return new MemoryIndexImpl();
			}
		};
	}
	
	@Override
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return DomainmodelScopeProvider.class;
	}
	
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return DefaultDeclarativeQualifiedNameProvider.class;
	}
}
