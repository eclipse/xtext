/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.service.IServiceRegistrationFactory.IServiceRegistration;

import org.eclipse.xtext.parser.terminalrules.ITerminalRulesTestLanguage;

public abstract class TerminalRulesTestLanguageStandaloneSetup {

	private static boolean isInitialized = false;

	public synchronized static void doSetup() {
		if(!isInitialized) {
			
			for (IServiceRegistration reg :  new org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguageRuntimeConfig().registrations()) {
				ServiceRegistry.registerFactory(reg.scope(), reg.serviceFactory(), reg.priority());
			}
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new org.eclipse.xtext.parser.terminalrules.services.TerminalRulesTestLanguageResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("terminalrulestestlanguage", resourceFactory);
			
			
			// initialize EPackages
			
				if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/2008/tmf/xtext/TerminalRulesTest")) {
					EPackage TerminalRulesTestLanguage = EcoreUtil2.loadEPackage(
							"classpath:/org/eclipse/xtext/parser/terminalrules/TerminalRulesTestLanguage.ecore",
							TerminalRulesTestLanguageStandaloneSetup.class.getClassLoader());
					if (TerminalRulesTestLanguage == null)
						throw new IllegalStateException(
								"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/parser/terminalrules/TerminalRulesTestLanguage.ecore'");
					EPackage.Registry.INSTANCE.put("http://www.eclipse.org/2008/tmf/xtext/TerminalRulesTest", TerminalRulesTestLanguage);
				}
			
			isInitialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
		return org.eclipse.xtext.parser.terminalrules.ITerminalRulesTestLanguage.SCOPE;
	}
}
