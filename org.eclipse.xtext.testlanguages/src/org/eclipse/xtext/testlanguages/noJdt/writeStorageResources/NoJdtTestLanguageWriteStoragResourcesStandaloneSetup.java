 package org.eclipse.xtext.testlanguages.noJdt.writeStorageResources;

import org.eclipse.xtext.testlanguages.noJdt.NoJdtTestLanguageStandaloneSetupGenerated;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class NoJdtTestLanguageWriteStoragResourcesStandaloneSetup extends NoJdtTestLanguageStandaloneSetupGenerated{

	public Injector createInjector() {
		return Guice.createInjector(new NoJdtTestLanguageWriteStorageResourcesRuntimeModule());
	}
}

