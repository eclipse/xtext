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

public abstract class SimpleTestStandaloneSetup {

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
			
			ServiceRegistry.registerFactory(languageDescriptor, new SimpleTestParserServiceFactory());
			
			ServiceRegistry.registerFactory(languageDescriptor, new SimpleTestASTFactoryServiceFactory());
			
			ServiceRegistry.registerFactory(languageDescriptor, new SimpleTestParseTreeConstructorServiceFactory());
			
			ServiceRegistry.registerFactory(languageDescriptor, new SimpleTestResourceFactoryServiceFactory());
			
			ServiceRegistry.registerFactory(languageDescriptor, new SimpleTestGrammarAccessServiceFactory());
			
			ServiceRegistry.registerFactory(languageDescriptor, new SimpleTestMetamodelAccessServiceFactory());
			
			if (LanguageFacadeFactory.getFacade("org.eclipse.xtext.grammargen.tests.SimpleTest")==null) {
				ILanguageFacade facade = new SimpleTestLanguageFacade();
				LanguageFacadeFactory.register(facade);
				Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
					"simpletest", facade.getResourceFactory());
			}
			isInitialized = true;
		}
	}
	
	private static ILanguageDescriptor INSTANCE;
	
	public static final String LANGUAGE_ID = "org.eclipse.xtext.grammargen.tests.SimpleTest";
	public static final String LANGUAGE_NAME = "SimpleTest";
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
