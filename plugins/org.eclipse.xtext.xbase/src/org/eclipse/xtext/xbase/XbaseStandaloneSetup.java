
package org.eclipse.xtext.xbase;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.xbase.jvmmodel.JvmModelInferrerRegistry;

import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class XbaseStandaloneSetup extends XbaseStandaloneSetupGenerated{

	public static void doSetup() {
		new XbaseStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
	
	@Override
	public Injector createInjectorAndDoEMFRegistration() {
		EPackage.Registry.INSTANCE.put(XbasePackage.eINSTANCE.getNsURI(),XbasePackage.eINSTANCE);
		return super.createInjectorAndDoEMFRegistration();
	}
	
	@Override
	public void register(Injector injector) {
		// no equinox registry reading if standalone setup is executed.
		JvmModelInferrerRegistry.INSTANCE.setUseRegistry(false);
		super.register(injector);
	}
}

