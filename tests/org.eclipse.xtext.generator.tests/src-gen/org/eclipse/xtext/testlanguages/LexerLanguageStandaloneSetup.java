package org.eclipse.xtext.testlanguages;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.LanguageFacadeFactory;
import org.eclipse.xtext.ILanguageFacade;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.testlanguages.services.*;

public abstract class LexerLanguageStandaloneSetup {

	public static void doSetup() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xmi", new XMIResourceFactoryImpl());
		getLanguageDescriptor();
		ServiceRegistry.registerFactory(new LexerLanguageParserServiceFactory());
		ServiceRegistry.registerFactory(new LexerLanguageASTFactoryServiceFactory());
		ServiceRegistry.registerFactory(new LexerLanguageParseTreeConstructorServiceFactory());
		ServiceRegistry.registerFactory(new LexerLanguageResourceFactoryServiceFactory());
		ServiceRegistry.registerFactory(new LexerLanguageGrammarAccessServiceFactory());
		ServiceRegistry.registerFactory(new LexerLanguageMetamodelAccessServiceFactory());
		if (LanguageFacadeFactory.getFacade("org.eclipse.xtext.testlanguages.LexerLanguage")==null) {
			ILanguageFacade facade = new LexerLanguageLanguageFacade();
			LanguageFacadeFactory.register(facade);
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"lexerlanguage", facade.getResourceFactory());
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
    			INSTANCE = LanguageDescriptorFactory.createLanguageDescriptor(LANGUAGE_ID, LANGUAGE_NAME, NAMESPACE);
    		}
    	}
    	return INSTANCE;
    }
    
}
