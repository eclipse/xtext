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

import org.eclipse.xtext.testlanguages.ILexerLanguage;

public abstract class LexerLanguageStandaloneSetup {

	private static boolean isInitialized = false;

	public synchronized static void doSetup() {
		if(!isInitialized) {
			// setup super language first
			org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup.doSetup();
			
			for (IServiceRegistration reg :  new org.eclipse.xtext.testlanguages.LexerLanguageRuntimeConfig().registrations()) {
				ServiceRegistry.registerFactory(reg.scope(), reg.serviceFactory(), reg.priority());
			}
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new org.eclipse.xtext.testlanguages.services.LexerLanguageResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("lexerlanguage", resourceFactory);
			
			
			// initialize EPackages
			
				if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/2008/xtext/LexerLang")) {
					EPackage LexerLang = EcoreUtil2.loadEPackage(
							"classpath:/org/eclipse/xtext/testlanguages/LexerLang.ecore",
							LexerLanguageStandaloneSetup.class.getClassLoader());
					if (LexerLang == null)
						throw new IllegalStateException(
								"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/testlanguages/LexerLang.ecore'");
					EPackage.Registry.INSTANCE.put("http://www.eclipse.org/2008/xtext/LexerLang", LexerLang);
				}
			
			isInitialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
		return org.eclipse.xtext.testlanguages.ILexerLanguage.SCOPE;
	}
}
