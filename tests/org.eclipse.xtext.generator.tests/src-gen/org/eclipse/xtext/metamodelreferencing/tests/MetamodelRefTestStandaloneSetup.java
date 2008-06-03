package org.eclipse.xtext.metamodelreferencing.tests;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.LanguageFacadeFactory;
import org.eclipse.xtext.ILanguageFacade;

import org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.metamodelreferencing.tests.services.*;

public abstract class MetamodelRefTestStandaloneSetup {

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
			
			ServiceRegistry.registerFactory(languageDescriptor, new MetamodelRefTestParserServiceFactory());
			
			ServiceRegistry.registerFactory(languageDescriptor, new MetamodelRefTestASTFactoryServiceFactory());
			
			ServiceRegistry.registerFactory(languageDescriptor, new MetamodelRefTestParseTreeConstructorServiceFactory());
			
			ServiceRegistry.registerFactory(languageDescriptor, new MetamodelRefTestResourceFactoryServiceFactory());
			
			ServiceRegistry.registerFactory(languageDescriptor, new MetamodelRefTestGrammarAccessServiceFactory());
			
			ServiceRegistry.registerFactory(languageDescriptor, new MetamodelRefTestMetamodelAccessServiceFactory());
			
			if (LanguageFacadeFactory.getFacade("org.eclipse.xtext.metamodelreferencing.tests.MetamodelRefTest")==null) {
				ILanguageFacade facade = new MetamodelRefTestLanguageFacade();
				LanguageFacadeFactory.register(facade);
				Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
					"metamodelreftest", facade.getResourceFactory());
			}
			isInitialized = true;
		}
	}
	
	private static ILanguageDescriptor INSTANCE;
	
	public static final String LANGUAGE_ID = "org.eclipse.xtext.metamodelreferencing.tests.MetamodelRefTest";
	public static final String LANGUAGE_NAME = "MetamodelRefTest";
	public static final String NAMESPACE = "org/eclipse/xtext/metamodelreferencing/tests";
    
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
