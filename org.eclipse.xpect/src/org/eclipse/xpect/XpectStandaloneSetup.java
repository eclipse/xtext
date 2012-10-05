package org.eclipse.xpect;

import org.eclipse.emf.ecore.EPackage;

import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages without equinox extension
 * registry
 */
public class XpectStandaloneSetup extends XpectStandaloneSetupGenerated {

	public static void doSetup() {
		new XpectStandaloneSetup().createInjectorAndDoEMFRegistration();
	}

	@Override
	public void register(Injector injector) {
		if (!EPackage.Registry.INSTANCE.containsKey(XpectPackage.eNS_URI))
			EPackage.Registry.INSTANCE.put(XpectPackage.eNS_URI, XpectPackage.eINSTANCE);
		super.register(injector);
	}
}
