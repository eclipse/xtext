package org.eclipse.xtext;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;

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
	
	private static ILanguageDescriptor INSTANCE;
    
    public static final String LANGUAGE_ID = "org/eclipse/xtext/Xtext";
    public static final String LANGUAGE_NAME = "XtextGrammarTest";
    public static final String NAMESPACE = "org/eclipse/xtext";
    
    public static ILanguageDescriptor getLanguageDescriptor() {
        if (INSTANCE == null) {
            INSTANCE = LanguageDescriptorFactory.get(LANGUAGE_ID);
            if(INSTANCE == null) {
                INSTANCE = LanguageDescriptorFactory.createLanguageDescriptor(LANGUAGE_ID, LANGUAGE_NAME, NAMESPACE);
            }
        }
        return INSTANCE;
    }
}
