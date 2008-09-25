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
import org.eclipse.xtext.service.IServiceRegistrationFactory.IServiceRegistration;

import org.eclipse.xtext.metamodelreferencing.tests.IMetamodelRefTest;

public abstract class MetamodelRefTestStandaloneSetup {

	private static boolean isInitialized = false;

	public synchronized static void doSetup() {
		if(!isInitialized) {
			// setup super language first
			org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup.doSetup();
			
			for (IServiceRegistration reg :  new org.eclipse.xtext.metamodelreferencing.tests.MetamodelRefTestRuntimeConfig().registrations()) {
				ServiceRegistry.registerFactory(reg.scope(), reg.serviceFactory(), reg.priority());
			}
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new org.eclipse.xtext.metamodelreferencing.tests.services.MetamodelRefTestResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("metamodelreftest", resourceFactory);
			
			
			// initialize EPackages
			
				if (!EPackage.Registry.INSTANCE.containsKey("http://eclipse.org/xtext/tests/SimpleTest")) {
					EPackage SimpleTest = EcoreUtil2.loadEPackage(
							"classpath:/org/eclipse/xtext/metamodelreferencing/tests/SimpleTest.ecore",
							MetamodelRefTestStandaloneSetup.class.getClassLoader());
					if (SimpleTest == null)
						throw new IllegalStateException(
								"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/metamodelreferencing/tests/SimpleTest.ecore'");
					EPackage.Registry.INSTANCE.put("http://eclipse.org/xtext/tests/SimpleTest", SimpleTest);
				}
			
			isInitialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
		return org.eclipse.xtext.metamodelreferencing.tests.IMetamodelRefTest.SCOPE;
	}
}
