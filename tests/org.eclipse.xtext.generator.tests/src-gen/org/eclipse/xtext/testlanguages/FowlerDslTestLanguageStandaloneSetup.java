/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.service.IServiceRegistrationFactory.IServiceRegistration;

import org.eclipse.xtext.testlanguages.IFowlerDslTestLanguage;

public abstract class FowlerDslTestLanguageStandaloneSetup {

	private static boolean isInitialized = false;

	public synchronized static void doSetup() {
		if(!isInitialized) {
			// setup super language first
			org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup.doSetup();
			
			for (IServiceRegistration reg :  new org.eclipse.xtext.testlanguages.FowlerDslTestLanguageRuntimeConfig().registrations()) {
				ServiceRegistry.registerFactory(reg.scope(), reg.serviceFactory(), reg.priority());
			}
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new org.eclipse.xtext.testlanguages.services.FowlerDslTestLanguageResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("fowlerdsltestlanguage", resourceFactory);
			
			
			// initialize EPackages
			
				if (!EPackage.Registry.INSTANCE.containsKey("http://example.xtext.org/FowlerDslTestLanguage")) {
					EPackage fowlerdsl = EcoreUtil2.loadEPackage(
							"classpath:/org/eclipse/xtext/testlanguages/fowlerdsl.ecore",
							FowlerDslTestLanguageStandaloneSetup.class.getClassLoader());
					if (fowlerdsl == null)
						throw new IllegalStateException(
								"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/testlanguages/fowlerdsl.ecore'");
					EPackage.Registry.INSTANCE.put("http://example.xtext.org/FowlerDslTestLanguage", fowlerdsl);
				}
			
			isInitialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
		return org.eclipse.xtext.testlanguages.IFowlerDslTestLanguage.SCOPE;
	}
}
