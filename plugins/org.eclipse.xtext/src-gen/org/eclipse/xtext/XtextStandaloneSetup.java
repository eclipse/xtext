package org.eclipse.xtext;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.LanguageFacadeFactory;
import org.eclipse.xtext.ILanguageFacade;
import org.eclipse.xtext.service.ILanguageDescriptor;

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
	
	private static ILanguageDescriptor DESC = new ILanguageDescriptor() {

		public String getId() {
			return "Xtext";
		}

		public String getName() {
			return "Xtext";
		}

		public String getNameSpace() {
			return "org.eclipse.xtext";
		}};

	public static ILanguageDescriptor getLanguageDescriptor() {
		return DESC;
	}

}
