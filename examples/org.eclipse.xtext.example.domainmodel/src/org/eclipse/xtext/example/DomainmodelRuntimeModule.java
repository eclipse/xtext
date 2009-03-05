/*
Generated with Xtext
*/
package org.eclipse.xtext.example;

import com.google.inject.Binder;

/**
 * used to register components to be used within the IDE.
 */
public class DomainmodelRuntimeModule extends AbstractDomainmodelRuntimeModule {

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(DomainModelValidator.class).asEagerSingleton();
	}

}
