/*
Generated with Xtext
*/
package org.eclipse.xtext.crossrefs;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.service.IServiceRegistrationFactory.IServiceRegistration;

import org.eclipse.xtext.crossrefs.ILangA;

public abstract class LangAStandaloneSetup {

	private static boolean isInitialized = false;

	public synchronized static void doSetup() {
		if(!isInitialized) {
			// setup super language first
			org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup.doSetup();
			
			for (IServiceRegistration reg :  new org.eclipse.xtext.crossrefs.LangARuntimeConfig().registrations()) {
				ServiceRegistry.registerFactory(reg.scope(), reg.serviceFactory(), reg.priority());
			}
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new org.eclipse.xtext.crossrefs.services.LangAResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("langa", resourceFactory);
			
			
			// initialize EPackages
			
				if (!EPackage.Registry.INSTANCE.containsKey("http://eclipse.org/xtext/langA")) {
					EPackage langA = EcoreUtil2.loadEPackage(
							"classpath:/org/eclipse/xtext/crossrefs/langA.ecore",
							LangAStandaloneSetup.class.getClassLoader());
					if (langA == null)
						throw new IllegalStateException(
								"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/crossrefs/langA.ecore'");
					EPackage.Registry.INSTANCE.put("http://eclipse.org/xtext/langA", langA);
				}
			
			isInitialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
		return org.eclipse.xtext.crossrefs.ILangA.SCOPE;
	}
}
