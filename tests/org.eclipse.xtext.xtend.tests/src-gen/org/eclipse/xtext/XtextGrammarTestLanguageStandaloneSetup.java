/*
Generated with Xtext
*/
package org.eclipse.xtext;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;

import com.google.inject.Guice;
import com.google.inject.Injector;

import org.eclipse.xtext.IXtextGrammarTestLanguage;

public abstract class XtextGrammarTestLanguageStandaloneSetup {

	private static boolean isInitialized = false;

	public synchronized static void doSetup() {
		if(!isInitialized) {
		    
		    Injector injector = Guice.createInjector(new org.eclipse.xtext.XtextGrammarTestLanguageRuntimeModule());
			ServiceRegistry.registerInjector(org.eclipse.xtext.IXtextGrammarTestLanguage.SCOPE, injector);
			
			
			
			org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup.doSetup();
			
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new org.eclipse.xtext.services.XtextGrammarTestLanguageResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xtextgrammartestlanguage", resourceFactory);
			
			
			// initialize EPackages
			
				if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/2008/Test/XtextTest")) {
					EPackage XtextTest = EcoreUtil2.loadEPackage(
							"classpath:/org/eclipse/xtext/XtextTest.ecore",
							XtextGrammarTestLanguageStandaloneSetup.class.getClassLoader());
					if (XtextTest == null)
						throw new IllegalStateException(
								"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/XtextTest.ecore'");
					EPackage.Registry.INSTANCE.put("http://www.eclipse.org/2008/Test/XtextTest", XtextTest);
				}
			
			isInitialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
	   doSetup();
	   return org.eclipse.xtext.IXtextGrammarTestLanguage.SCOPE;
	}
	
}
