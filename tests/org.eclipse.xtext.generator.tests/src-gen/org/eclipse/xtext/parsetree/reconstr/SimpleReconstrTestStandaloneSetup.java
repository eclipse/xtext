/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.service.IServiceRegistrationFactory.IServiceRegistration;

import org.eclipse.xtext.parsetree.reconstr.ISimpleReconstrTest;

public abstract class SimpleReconstrTestStandaloneSetup {

	private static boolean isInitialized = false;

	public synchronized static void doSetup() {
		if(!isInitialized) {
			// setup super language first
			org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup.doSetup();
			
			for (IServiceRegistration reg :  new org.eclipse.xtext.parsetree.reconstr.SimpleReconstrTestRuntimeConfig().registrations()) {
				ServiceRegistry.registerFactory(reg.scope(), reg.serviceFactory(), reg.priority());
			}
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new org.eclipse.xtext.parsetree.reconstr.services.SimpleReconstrTestResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("simplereconstrtest", resourceFactory);
			
			
			// initialize EPackages
			
				if (!EPackage.Registry.INSTANCE.containsKey("http://simple/rewrite/test")) {
					EPackage simplerewritetest = EcoreUtil2.loadEPackage(
							"classpath:/org/eclipse/xtext/parsetree/reconstr/simplerewritetest.ecore",
							SimpleReconstrTestStandaloneSetup.class.getClassLoader());
					if (simplerewritetest == null)
						throw new IllegalStateException(
								"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/parsetree/reconstr/simplerewritetest.ecore'");
					EPackage.Registry.INSTANCE.put("http://simple/rewrite/test", simplerewritetest);
				}
			
			isInitialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
		return org.eclipse.xtext.parsetree.reconstr.ISimpleReconstrTest.SCOPE;
	}
}
