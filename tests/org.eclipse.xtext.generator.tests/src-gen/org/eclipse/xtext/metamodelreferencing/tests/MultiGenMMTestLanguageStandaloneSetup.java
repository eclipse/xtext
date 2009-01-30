/*
Generated with Xtext
*/
package org.eclipse.xtext.metamodelreferencing.tests;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;

import com.google.inject.Guice;
import com.google.inject.Injector;

import org.eclipse.xtext.metamodelreferencing.tests.IMultiGenMMTestLanguage;

public abstract class MultiGenMMTestLanguageStandaloneSetup {

	private static boolean isInitialized = false;

	public synchronized static void doSetup() {
		if(!isInitialized) {
		    
		    Injector injector = Guice.createInjector(new org.eclipse.xtext.metamodelreferencing.tests.MultiGenMMTestLanguageRuntimeModule());
			ServiceRegistry.registerInjector(org.eclipse.xtext.metamodelreferencing.tests.IMultiGenMMTestLanguage.SCOPE, injector);
			
			
			
			org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup.doSetup();
			
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new org.eclipse.xtext.metamodelreferencing.tests.services.MultiGenMMTestLanguageResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("multigenmmtestlanguage", resourceFactory);
			
			
			// initialize EPackages
			
				if (!EPackage.Registry.INSTANCE.containsKey("http://eclipse.org/xtext/tests/SimpleTest")) {
					EPackage SimpleTest = EcoreUtil2.loadEPackage(
							"classpath:/org/eclipse/xtext/metamodelreferencing/tests/SimpleTest.ecore",
							MultiGenMMTestLanguageStandaloneSetup.class.getClassLoader());
					if (SimpleTest == null)
						throw new IllegalStateException(
								"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/metamodelreferencing/tests/SimpleTest.ecore'");
					EPackage.Registry.INSTANCE.put("http://eclipse.org/xtext/tests/SimpleTest", SimpleTest);
				}
			
				if (!EPackage.Registry.INSTANCE.containsKey("http://eclipse.org/xtext/tests/OtherTest")) {
					EPackage OtherTest = EcoreUtil2.loadEPackage(
							"classpath:/org/eclipse/xtext/metamodelreferencing/tests/OtherTest.ecore",
							MultiGenMMTestLanguageStandaloneSetup.class.getClassLoader());
					if (OtherTest == null)
						throw new IllegalStateException(
								"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/metamodelreferencing/tests/OtherTest.ecore'");
					EPackage.Registry.INSTANCE.put("http://eclipse.org/xtext/tests/OtherTest", OtherTest);
				}
			
			isInitialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
	   doSetup();
	   return org.eclipse.xtext.metamodelreferencing.tests.IMultiGenMMTestLanguage.SCOPE;
	}
	
}
