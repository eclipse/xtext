package org.eclipse.xtext.example.domainmodel.tests;

import org.eclipse.xtext.example.domainmodel.DomainmodelInjectorProvider;
import org.eclipse.xtext.example.domainmodel.DomainmodelRuntimeModule;
import org.eclipse.xtext.example.domainmodel.DomainmodelStandaloneSetup;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class InjectorProviderCustom extends DomainmodelInjectorProvider {

	public Injector internalCreateInjector() {
			return new DomainmodelStandaloneSetup() {
				@Override
				public Injector createInjector() {
					return Guice.createInjector(new DomainmodelRuntimeModule() {
						@Override
						public ClassLoader bindClassLoaderToInstance() {
							return InjectorProviderCustom.class
									.getClassLoader();
						}

					});
				}
			}.createInjectorAndDoEMFRegistration();
	}

}
