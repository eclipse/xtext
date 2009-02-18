
/*
*/
package org.eclipse.xtext.crossrefs;

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
public class LangATestLanguageStandaloneSetup implements ISetup {

	public static void doSetup() {
		new LangATestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}

	public Injector createInjectorAndDoEMFRegistration() {
		
		org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup.doSetup();
		Injector injector = createInjector();
		register(injector);
		return injector;
	}
	
	public Injector createInjector() {
		return Guice.createInjector(new org.eclipse.xtext.crossrefs.LangATestLanguageRuntimeModule());
	}
	
	public void register(Injector injector) {
	if (!EPackage.Registry.INSTANCE.containsKey("http://eclipse.org/xtext/langATestLanguage")) {
		EPackage.Registry.INSTANCE.put("http://eclipse.org/xtext/langATestLanguage", org.eclipse.xtext.crossrefs.langATestLanguage.LangATestLanguagePackage.eINSTANCE);
	}


		org.eclipse.xtext.resource.IResourceFactory resourceFactory = injector.getInstance(org.eclipse.xtext.resource.IResourceFactory.class);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("langatestlanguage", resourceFactory);
		

	//TODO registration of EValidators should be added here, too

	}
}
