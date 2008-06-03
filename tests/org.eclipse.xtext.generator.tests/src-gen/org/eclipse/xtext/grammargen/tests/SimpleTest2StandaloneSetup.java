package org.eclipse.xtext.grammargen.tests;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.LanguageFacadeFactory;
import org.eclipse.xtext.ILanguageFacade;

import org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.grammargen.tests.services.*;

public abstract class SimpleTest2StandaloneSetup {

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
			
			ServiceRegistry.registerFactory(languageDescriptor, new SimpleTest2ParserServiceFactory());
			
			ServiceRegistry.registerFactory(languageDescriptor, new SimpleTest2ASTFactoryServiceFactory());
			
			ServiceRegistry.registerFactory(languageDescriptor, new SimpleTest2ParseTreeConstructorServiceFactory());
			
			ServiceRegistry.registerFactory(languageDescriptor, new SimpleTest2ResourceFactoryServiceFactory());
			
			ServiceRegistry.registerFactory(languageDescriptor, new SimpleTest2GrammarAccessServiceFactory());
			
			ServiceRegistry.registerFactory(languageDescriptor, new SimpleTest2MetamodelAccessServiceFactory());
			
			if (LanguageFacadeFactory.getFacade("org.eclipse.xtext.grammargen.tests.SimpleTest2")==null) {
				ILanguageFacade facade = new SimpleTest2LanguageFacade();
				LanguageFacadeFactory.register(facade);
				Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
					"simpletest2", facade.getResourceFactory());
			}
			isInitialized = true;
		}
	}
	
	private static ILanguageDescriptor INSTANCE;
	
	public static final String LANGUAGE_ID = "org.eclipse.xtext.grammargen.tests.SimpleTest2";
	public static final String LANGUAGE_NAME = "SimpleTest2";
	public static final String NAMESPACE = "org/eclipse/xtext/grammargen/tests";
    
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
