package org.eclipse.xtext.example.domainmodel.tests;

import org.eclipse.xtext.example.domainmodel.DomainmodelInjectorProvider;
import org.eclipse.xtext.example.domainmodel.DomainmodelRuntimeModule;
import org.eclipse.xtext.example.domainmodel.DomainmodelStandaloneSetup;
import org.eclipse.xtext.junit4.GlobalRegistries;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class InjectorProviderCustom extends DomainmodelInjectorProvider {
	
	public Injector getInjector() {
		if (injector == null) {
			stateBeforeInjectorCreation = GlobalRegistries.makeCopyOfGlobalState();
			this.injector = new DomainmodelStandaloneSetup() {
				@Override
				public Injector createInjector() {
					return Guice.createInjector(new DomainmodelRuntimeModule() {
						@Override
						public ClassLoader bindClassLoaderToInstance() {
							return InjectorProviderCustom.class.getClassLoader();
						}
					});
				}
			}.createInjectorAndDoEMFRegistration();
			stateAfterInjectorCreation = GlobalRegistries.makeCopyOfGlobalState();
		}
		return injector;
	}
}
