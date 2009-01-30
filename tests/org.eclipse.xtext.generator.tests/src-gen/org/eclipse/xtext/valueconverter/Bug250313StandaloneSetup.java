/*
Generated with Xtext
*/
package org.eclipse.xtext.valueconverter;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;

import com.google.inject.Guice;
import com.google.inject.Injector;

import org.eclipse.xtext.valueconverter.IBug250313;

public abstract class Bug250313StandaloneSetup {

	private static boolean isInitialized = false;

	public synchronized static void doSetup() {
		if(!isInitialized) {
		    
		    Injector injector = Guice.createInjector(new org.eclipse.xtext.valueconverter.Bug250313RuntimeModule());
			ServiceRegistry.registerInjector(org.eclipse.xtext.valueconverter.IBug250313.SCOPE, injector);
			
			
			
			org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup.doSetup();
			
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new org.eclipse.xtext.valueconverter.services.Bug250313ResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("bug250313", resourceFactory);
			
			
			// initialize EPackages
			
				if (!EPackage.Registry.INSTANCE.containsKey("http://org.eclipse.xtext.valueconverter.Bug250313")) {
					EPackage bug250313 = EcoreUtil2.loadEPackage(
							"classpath:/org/eclipse/xtext/valueconverter/bug250313.ecore",
							Bug250313StandaloneSetup.class.getClassLoader());
					if (bug250313 == null)
						throw new IllegalStateException(
								"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/valueconverter/bug250313.ecore'");
					EPackage.Registry.INSTANCE.put("http://org.eclipse.xtext.valueconverter.Bug250313", bug250313);
				}
			
			isInitialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
	   doSetup();
	   return org.eclipse.xtext.valueconverter.IBug250313.SCOPE;
	}
	
}
