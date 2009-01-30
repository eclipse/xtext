/*
Generated with Xtext
*/
package org.eclipse.xtext.reference;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;

import com.google.inject.Guice;
import com.google.inject.Injector;

import org.eclipse.xtext.reference.IReferenceGrammar;

public abstract class ReferenceGrammarStandaloneSetup {

	private static boolean isInitialized = false;

	public synchronized static void doSetup() {
		if(!isInitialized) {
		    
		    Injector injector = Guice.createInjector(new org.eclipse.xtext.reference.ReferenceGrammarRuntimeModule());
			ServiceRegistry.registerInjector(org.eclipse.xtext.reference.IReferenceGrammar.SCOPE, injector);
			
			
			
			org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup.doSetup();
			
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new org.eclipse.xtext.reference.services.ReferenceGrammarResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xtest", resourceFactory);
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("tst", resourceFactory);
			
			
			// initialize EPackages
			
				if (!EPackage.Registry.INSTANCE.containsKey("http://eclipse.org/xtext/reference/ReferenceGrammar")) {
					EPackage ReferenceGrammar = EcoreUtil2.loadEPackage(
							"classpath:/org/eclipse/xtext/reference/ReferenceGrammar.ecore",
							ReferenceGrammarStandaloneSetup.class.getClassLoader());
					if (ReferenceGrammar == null)
						throw new IllegalStateException(
								"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/reference/ReferenceGrammar.ecore'");
					EPackage.Registry.INSTANCE.put("http://eclipse.org/xtext/reference/ReferenceGrammar", ReferenceGrammar);
				}
			
			isInitialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
	   doSetup();
	   return org.eclipse.xtext.reference.IReferenceGrammar.SCOPE;
	}
	
}
