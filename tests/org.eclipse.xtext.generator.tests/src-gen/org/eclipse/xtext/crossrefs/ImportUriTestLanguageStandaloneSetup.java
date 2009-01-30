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

import com.google.inject.Guice;
import com.google.inject.Injector;

import org.eclipse.xtext.crossrefs.IImportUriTestLanguage;

public abstract class ImportUriTestLanguageStandaloneSetup {

	private static boolean isInitialized = false;

	public synchronized static void doSetup() {
		if(!isInitialized) {
		    
		    Injector injector = Guice.createInjector(new org.eclipse.xtext.crossrefs.ImportUriTestLanguageRuntimeModule());
			ServiceRegistry.registerInjector(org.eclipse.xtext.crossrefs.IImportUriTestLanguage.SCOPE, injector);
			
			
			
			org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup.doSetup();
			
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new org.eclipse.xtext.crossrefs.services.ImportUriTestLanguageResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("importuritestlanguage", resourceFactory);
			
			
			// initialize EPackages
			
				if (!EPackage.Registry.INSTANCE.containsKey("http://eclipse.org/xtext/importUriTestLanguage")) {
					EPackage importedURI = EcoreUtil2.loadEPackage(
							"classpath:/org/eclipse/xtext/crossrefs/importedURI.ecore",
							ImportUriTestLanguageStandaloneSetup.class.getClassLoader());
					if (importedURI == null)
						throw new IllegalStateException(
								"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/crossrefs/importedURI.ecore'");
					EPackage.Registry.INSTANCE.put("http://eclipse.org/xtext/importUriTestLanguage", importedURI);
				}
			
			isInitialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
	   doSetup();
	   return org.eclipse.xtext.crossrefs.IImportUriTestLanguage.SCOPE;
	}
	
}
