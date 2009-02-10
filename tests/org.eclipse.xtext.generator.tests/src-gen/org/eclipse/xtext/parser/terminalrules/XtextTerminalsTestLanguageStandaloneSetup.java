/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.ISetup;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceFactory;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class XtextTerminalsTestLanguageStandaloneSetup implements ISetup {

	public static void doSetup() {
		new XtextTerminalsTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}

	public Injector createInjectorAndDoEMFRegistration() {
			// register default ePackages
			if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("ecore"))
				Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
					"ecore", new org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl());
			if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("xmi"))
				Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
					"xmi", new org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl());
			if (!EPackage.Registry.INSTANCE.containsKey(org.eclipse.xtext.XtextPackage.eNS_URI))
				EPackage.Registry.INSTANCE.put(org.eclipse.xtext.XtextPackage.eNS_URI, org.eclipse.xtext.XtextPackage.eINSTANCE);
			
		    registerEPackages();
		    
		    Injector injector = createInjector();
		    IResourceFactory resourceFactory = injector.getInstance(IResourceFactory.class);
		    registerResourceFactory(resourceFactory);
		    return injector;
		    
	}
	
    
	public Injector createInjector() {
		return Guice.createInjector(new org.eclipse.xtext.parser.terminalrules.XtextTerminalsTestLanguageRuntimeModule());
	}
	
	public void registerResourceFactory(IResourceFactory resourceFactory) {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xtextterminalstestlanguage", resourceFactory);
		
	}
    

	/**
	 * initializes all EPackages generated for this language and registers them at EPackage.Registry.INSTANCE
	 */	
	public void registerEPackages() {
		
			if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/2008/tmf/xtext/XtextTerminalsTestLanguage")) {
				EPackage XtextTerminalsTestLanguage = EcoreUtil2.loadEPackage(
						"classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.ecore",
						XtextTerminalsTestLanguageStandaloneSetup.class.getClassLoader());
				if (XtextTerminalsTestLanguage == null)
					throw new IllegalStateException(
							"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.ecore'");
				EPackage.Registry.INSTANCE.put("http://www.eclipse.org/2008/tmf/xtext/XtextTerminalsTestLanguage", XtextTerminalsTestLanguage);
			}
		
	}
	
}
