package org.eclipse.xtext.testlanguages;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.LanguageFacadeFactory;
import org.eclipse.xtext.ILanguageFacade;

import org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.testlanguages.services.*;

public abstract class TestLanguageStandaloneSetup {

	private static boolean isInitialized = false;

	public static void doSetup() {
		if(!isInitialized) {
			
			// setup super language first
			XtextBuiltinStandaloneSetup.doSetup();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new XMIResourceFactoryImpl());
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xmi", new XMIResourceFactoryImpl());
			ILanguageDescriptor languageDescriptor = getLanguageDescriptor();
			
			ServiceRegistry.registerFactory(languageDescriptor, new TestLanguageParserServiceFactory());
			
			ServiceRegistry.registerFactory(languageDescriptor, new TestLanguageASTFactoryServiceFactory());
			
			ServiceRegistry.registerFactory(languageDescriptor, new TestLanguageParseTreeConstructorServiceFactory());
			
			ServiceRegistry.registerFactory(languageDescriptor, new TestLanguageResourceFactoryServiceFactory());
			
			ServiceRegistry.registerFactory(languageDescriptor, new TestLanguageGrammarAccessServiceFactory());
			
			ServiceRegistry.registerFactory(languageDescriptor, new TestLanguageMetamodelAccessServiceFactory());
			
			if (LanguageFacadeFactory.getFacade("org.eclipse.xtext.testlanguages.TestLanguage")==null) {
				ILanguageFacade facade = new TestLanguageLanguageFacade();
				LanguageFacadeFactory.register(facade);
				Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
					"testlanguage", facade.getResourceFactory());
			}
			isInitialized = true;
		}
	}
	
	private static ILanguageDescriptor INSTANCE;
	
	public static final String LANGUAGE_ID = "org.eclipse.xtext.testlanguages.TestLanguage";
	public static final String LANGUAGE_NAME = "TestLanguage";
	public static final String NAMESPACE = "org/eclipse/xtext/testlanguages";
    
    public static ILanguageDescriptor getLanguageDescriptor() {
    	if (INSTANCE == null) {
    		INSTANCE = LanguageDescriptorFactory.get(LANGUAGE_ID);
    		if(INSTANCE == null) {
    			// TODO put super grammar
    			INSTANCE = LanguageDescriptorFactory.createLanguageDescriptor(LANGUAGE_ID, LANGUAGE_NAME, NAMESPACE, null);
    		}
    	}
    	return INSTANCE;
    }
    
}
