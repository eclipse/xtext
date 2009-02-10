/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.ISetup;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceFactory;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Generated from StandaloneSetup.xpt!
 */
public class ContentAssistTestLanguageStandaloneSetup implements ISetup {

	public static void doSetup() {
		new ContentAssistTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}

	public Injector createInjectorAndDoEMFRegistration() {
		
		org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup.doSetup();
		registerEPackages();
		Injector injector = createInjector();
		IResourceFactory resourceFactory = injector.getInstance(IResourceFactory.class);
		registerResourceFactory(resourceFactory);
		return injector;
	}
	
	public Injector createInjector() {
		return Guice.createInjector(new org.eclipse.xtext.testlanguages.ContentAssistTestLanguageRuntimeModule());
	}
	
	public void registerResourceFactory(IResourceFactory resourceFactory) {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("contentassisttestlanguage", resourceFactory);
		
	}

	/**
	 * Initializes all EPackages generated for this language and registers them with EPackage.Registry.INSTANCE
	 */	
	public void registerEPackages() {
		if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/2008/xtext/tests/ContentAssist")) {
			EPackage contentAssistTestLanguage = EcoreUtil2.loadEPackage(
				"classpath:/org/eclipse/xtext/testlanguages/contentAssistTestLanguage.ecore",
				ContentAssistTestLanguageStandaloneSetup.class.getClassLoader());
			if (contentAssistTestLanguage == null)
				throw new IllegalStateException(
					"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/testlanguages/contentAssistTestLanguage.ecore'");
			EPackage.Registry.INSTANCE.put("http://www.eclipse.org/2008/xtext/tests/ContentAssist", contentAssistTestLanguage);
		}
	}
	
}
