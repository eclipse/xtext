package org.eclipse.xtext;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public abstract class XtextStandaloneSetup {

	public static void doSetup() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xmi", new XMIResourceFactoryImpl());
		if (LanguageFacadeFactory.getFacade("org/eclipse/xtext/Xtext")==null) {
			ILanguageFacade facade = new XtextLanguageFacade();
			LanguageFacadeFactory.register(facade);
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xtext", facade.getResourceFactory());
		}
	}
	
	public static final String LANGUAGE_ID = "org/eclipse/xtext/Xtext";
}
