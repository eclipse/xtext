package org.eclipse.xtext;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.LanguageFacadeFactory;
import org.eclipse.xtext.ILanguageFacade;

import org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.services.*;

public abstract class XtextGrammarTestStandaloneSetup {

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
			
			ServiceRegistry.registerFactory(languageDescriptor, new XtextGrammarTestParserServiceFactory());
			
			ServiceRegistry.registerFactory(languageDescriptor, new XtextGrammarTestASTFactoryServiceFactory());
			
			ServiceRegistry.registerFactory(languageDescriptor, new XtextGrammarTestParseTreeConstructorServiceFactory());
			
			ServiceRegistry.registerFactory(languageDescriptor, new XtextGrammarTestResourceFactoryServiceFactory());
			
			ServiceRegistry.registerFactory(languageDescriptor, new XtextGrammarTestGrammarAccessServiceFactory());
			
			ServiceRegistry.registerFactory(languageDescriptor, new XtextGrammarTestMetamodelAccessServiceFactory());
			
			if (LanguageFacadeFactory.getFacade("org.eclipse.xtext.XtextGrammarTest")==null) {
				ILanguageFacade facade = new XtextGrammarTestLanguageFacade();
				LanguageFacadeFactory.register(facade);
				Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
					"xtextgrammartest", facade.getResourceFactory());
			}
			isInitialized = true;
		}
	}
	
	private static ILanguageDescriptor INSTANCE;
	
	public static final String LANGUAGE_ID = "org.eclipse.xtext.XtextGrammarTest";
	public static final String LANGUAGE_NAME = "XtextGrammarTest";
	public static final String NAMESPACE = "org/eclipse/xtext";
    
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
