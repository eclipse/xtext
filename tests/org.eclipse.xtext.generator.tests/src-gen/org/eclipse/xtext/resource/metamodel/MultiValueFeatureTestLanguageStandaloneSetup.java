/*
Generated with Xtext
*/
package org.eclipse.xtext.resource.metamodel;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;

import com.google.inject.Guice;
import com.google.inject.Injector;

import org.eclipse.xtext.resource.metamodel.IMultiValueFeatureTestLanguage;

public abstract class MultiValueFeatureTestLanguageStandaloneSetup {

	private static boolean isInitialized = false;

	public synchronized static void doSetup() {
		if(!isInitialized) {
		    
		    Injector injector = Guice.createInjector(new org.eclipse.xtext.resource.metamodel.MultiValueFeatureTestLanguageRuntimeModule());
			ServiceRegistry.registerInjector(org.eclipse.xtext.resource.metamodel.IMultiValueFeatureTestLanguage.SCOPE, injector);
			
			
			
			org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup.doSetup();
			
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new org.eclipse.xtext.resource.metamodel.services.MultiValueFeatureTestLanguageResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("multivaluefeaturetestlanguage", resourceFactory);
			
			
			// initialize EPackages
			
				if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/2008/xtext/MultiValueFeatureTestLanguage")) {
					EPackage MultiValueFeatureTestLanguage = EcoreUtil2.loadEPackage(
							"classpath:/org/eclipse/xtext/resource/metamodel/MultiValueFeatureTestLanguage.ecore",
							MultiValueFeatureTestLanguageStandaloneSetup.class.getClassLoader());
					if (MultiValueFeatureTestLanguage == null)
						throw new IllegalStateException(
								"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/resource/metamodel/MultiValueFeatureTestLanguage.ecore'");
					EPackage.Registry.INSTANCE.put("http://www.eclipse.org/2008/xtext/MultiValueFeatureTestLanguage", MultiValueFeatureTestLanguage);
				}
			
			isInitialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
	   doSetup();
	   return org.eclipse.xtext.resource.metamodel.IMultiValueFeatureTestLanguage.SCOPE;
	}
	
}
