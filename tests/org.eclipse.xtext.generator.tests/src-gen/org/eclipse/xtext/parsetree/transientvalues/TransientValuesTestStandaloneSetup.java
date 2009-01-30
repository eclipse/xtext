/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.transientvalues;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;

import com.google.inject.Guice;
import com.google.inject.Injector;

import org.eclipse.xtext.parsetree.transientvalues.ITransientValuesTest;

public abstract class TransientValuesTestStandaloneSetup {

	private static boolean isInitialized = false;

	public synchronized static void doSetup() {
		if(!isInitialized) {
		    
		    Injector injector = Guice.createInjector(new org.eclipse.xtext.parsetree.transientvalues.TransientValuesTestRuntimeModule());
			ServiceRegistry.registerInjector(org.eclipse.xtext.parsetree.transientvalues.ITransientValuesTest.SCOPE, injector);
			
			
			
			org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup.doSetup();
			
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new org.eclipse.xtext.parsetree.transientvalues.services.TransientValuesTestResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("transientvaluestest", resourceFactory);
			
			
			// initialize EPackages
			
				if (!EPackage.Registry.INSTANCE.containsKey("http://simple/transientvaluestest")) {
					EPackage transientvaluestest = EcoreUtil2.loadEPackage(
							"classpath:/org/eclipse/xtext/parsetree/transientvalues/transientvaluestest.ecore",
							TransientValuesTestStandaloneSetup.class.getClassLoader());
					if (transientvaluestest == null)
						throw new IllegalStateException(
								"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/parsetree/transientvalues/transientvaluestest.ecore'");
					EPackage.Registry.INSTANCE.put("http://simple/transientvaluestest", transientvaluestest);
				}
			
			isInitialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
	   doSetup();
	   return org.eclipse.xtext.parsetree.transientvalues.ITransientValuesTest.SCOPE;
	}
	
}
