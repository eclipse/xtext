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

public abstract class LexerLanguageStandaloneSetup {

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
			
			ServiceRegistry.registerFactory(languageDescriptor, new LexerLanguageParserServiceFactory());
			
			ServiceRegistry.registerFactory(languageDescriptor, new LexerLanguageASTFactoryServiceFactory());
			
			ServiceRegistry.registerFactory(languageDescriptor, new LexerLanguageParseTreeConstructorServiceFactory());
			
			ServiceRegistry.registerFactory(languageDescriptor, new LexerLanguageResourceFactoryServiceFactory());
			
			ServiceRegistry.registerFactory(languageDescriptor, new LexerLanguageGrammarAccessServiceFactory());
			
			ServiceRegistry.registerFactory(languageDescriptor, new LexerLanguageMetamodelAccessServiceFactory());
			
			if (LanguageFacadeFactory.getFacade("org.eclipse.xtext.testlanguages.LexerLanguage")==null) {
				ILanguageFacade facade = new LexerLanguageLanguageFacade();
				LanguageFacadeFactory.register(facade);
				Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
					"lexerlanguage", facade.getResourceFactory());
			}
			isInitialized = true;
		}
	}
	
	private static ILanguageDescriptor INSTANCE;
	
	public static final String LANGUAGE_ID = "org.eclipse.xtext.testlanguages.LexerLanguage";
	public static final String LANGUAGE_NAME = "LexerLanguage";
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
