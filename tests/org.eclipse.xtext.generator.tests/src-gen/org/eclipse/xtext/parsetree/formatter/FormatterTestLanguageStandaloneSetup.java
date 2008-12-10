/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.formatter;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.service.IServiceRegistrationFactory.IServiceRegistration;

import org.eclipse.xtext.parsetree.formatter.IFormatterTestLanguage;

public abstract class FormatterTestLanguageStandaloneSetup {

	private static boolean isInitialized = false;

	public synchronized static void doSetup() {
		if(!isInitialized) {
			// setup super language first
			org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup.doSetup();
			
			for (IServiceRegistration reg :  new org.eclipse.xtext.parsetree.formatter.FormatterTestLanguageRuntimeConfig().registrations()) {
				ServiceRegistry.registerFactory(reg.scope(), reg.serviceFactory(), reg.priority());
			}
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new org.eclipse.xtext.parsetree.formatter.services.FormatterTestLanguageResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("formattertestlanguage", resourceFactory);
			
			
			// initialize EPackages
			
				if (!EPackage.Registry.INSTANCE.containsKey("http://simple/formattertestlanguage")) {
					EPackage formattertestlanguage = EcoreUtil2.loadEPackage(
							"classpath:/org/eclipse/xtext/parsetree/formatter/formattertestlanguage.ecore",
							FormatterTestLanguageStandaloneSetup.class.getClassLoader());
					if (formattertestlanguage == null)
						throw new IllegalStateException(
								"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/parsetree/formatter/formattertestlanguage.ecore'");
					EPackage.Registry.INSTANCE.put("http://simple/formattertestlanguage", formattertestlanguage);
				}
			
			isInitialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
		return org.eclipse.xtext.parsetree.formatter.IFormatterTestLanguage.SCOPE;
	}
}
