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

import org.eclipse.xtext.parser.terminalrules.IXtextTerminalsTestLanguage;

public abstract class XtextTerminalsTestLanguageStandaloneSetup {

	private static boolean isInitialized = false;

	public synchronized static void doSetup() {
		if(!isInitialized) {
			
			for (IServiceRegistration reg :  new org.eclipse.xtext.parser.terminalrules.XtextTerminalsTestLanguageRuntimeConfig().registrations()) {
				ServiceRegistry.registerFactory(reg.scope(), reg.serviceFactory(), reg.priority());
			}
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xtextterminalstestlanguage", resourceFactory);
			
			
			// initialize EPackages
			
				if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/2008/tmf/xtext/XtextTerminalsTestLanguage")) {
					EPackage XtextTerminalsTestLanguage = EcoreUtil2.loadEPackage(
							"classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.ecore",
							XtextTerminalsTestLanguageStandaloneSetup.class.getClassLoader());
					if (XtextTerminalsTestLanguage == null)
						throw new IllegalStateException(
								"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.ecore'");
					EPackage.Registry.INSTANCE.put("http://www.eclipse.org/2008/tmf/xtext/XtextTerminalsTestLanguage", XtextTerminalsTestLanguage);
				}
			
			isInitialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
		return org.eclipse.xtext.parser.terminalrules.IXtextTerminalsTestLanguage.SCOPE;
	}
}
