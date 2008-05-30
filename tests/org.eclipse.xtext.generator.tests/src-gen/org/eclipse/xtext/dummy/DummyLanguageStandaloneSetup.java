package org.eclipse.xtext.dummy;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.LanguageFacadeFactory;
import org.eclipse.xtext.ILanguageFacade;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.dummy.services.*;

public abstract class DummyLanguageStandaloneSetup {

	public static void doSetup() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xmi", new XMIResourceFactoryImpl());
		getLanguageDescriptor();
		ServiceRegistry.registerFactory(new DummyLanguageParserServiceFactory());
		ServiceRegistry.registerFactory(new DummyLanguageASTFactoryServiceFactory());
		ServiceRegistry.registerFactory(new DummyLanguageParseTreeConstructorServiceFactory());
		ServiceRegistry.registerFactory(new DummyLanguageResourceFactoryServiceFactory());
		ServiceRegistry.registerFactory(new DummyLanguageGrammarAccessServiceFactory());
		ServiceRegistry.registerFactory(new DummyLanguageMetamodelAccessServiceFactory());
		if (LanguageFacadeFactory.getFacade("org.eclipse.xtext.dummy.DummyLanguage")==null) {
			ILanguageFacade facade = new DummyLanguageLanguageFacade();
			LanguageFacadeFactory.register(facade);
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"dummylanguage", facade.getResourceFactory());
		}
	}
	
	private static ILanguageDescriptor INSTANCE;
	
	public static final String LANGUAGE_ID = "org.eclipse.xtext.dummy.DummyLanguage";
	public static final String LANGUAGE_NAME = "DummyLanguage";
	public static final String NAMESPACE = "org/eclipse/xtext/dummy";
    
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
