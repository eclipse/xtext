package org.eclipse.xtext.testlanguages;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.LanguageFacadeFactory;
import org.eclipse.xtext.ILanguageFacade;

public abstract class LexerLanguageStandaloneSetup {

	public static void doSetup() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xmi", new XMIResourceFactoryImpl());
		if (LanguageFacadeFactory.getFacade("org/eclipse/xtext/testlanguages/LexerLanguage")==null) {
			ILanguageFacade facade = new LexerLanguageLanguageFacade();
			LanguageFacadeFactory.register(facade);
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"lexerlanguage", facade.getResourceFactory());
		}
	}

}
