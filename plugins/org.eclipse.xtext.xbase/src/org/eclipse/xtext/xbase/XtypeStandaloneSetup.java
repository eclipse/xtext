
package org.eclipse.xtext.xbase;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.xtype.XtypePackage;

import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class XtypeStandaloneSetup extends XtypeStandaloneSetupGenerated{

	public static void doSetup() {
		new XtypeStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
	
	@Override
	public Injector createInjectorAndDoEMFRegistration() {
		EPackage.Registry.INSTANCE.put(TypesPackage.eINSTANCE.getNsURI(), TypesPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(XtypePackage.eINSTANCE.getNsURI(), XtypePackage.eINSTANCE);
		return super.createInjectorAndDoEMFRegistration();
	}
}

