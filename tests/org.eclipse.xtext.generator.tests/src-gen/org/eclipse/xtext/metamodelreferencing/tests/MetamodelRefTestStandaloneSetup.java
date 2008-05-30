package org.eclipse.xtext.metamodelreferencing.tests;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.LanguageFacadeFactory;
import org.eclipse.xtext.ILanguageFacade;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.metamodelreferencing.tests.services.*;

public abstract class MetamodelRefTestStandaloneSetup {

	public static void doSetup() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xmi", new XMIResourceFactoryImpl());
		getLanguageDescriptor();
		ServiceRegistry.registerFactory(new MetamodelRefTestParserServiceFactory());
		ServiceRegistry.registerFactory(new MetamodelRefTestASTFactoryServiceFactory());
		ServiceRegistry.registerFactory(new MetamodelRefTestParseTreeConstructorServiceFactory());
		ServiceRegistry.registerFactory(new MetamodelRefTestResourceFactoryServiceFactory());
		ServiceRegistry.registerFactory(new MetamodelRefTestGrammarAccessServiceFactory());
		ServiceRegistry.registerFactory(new MetamodelRefTestMetamodelAccessServiceFactory());
		if (LanguageFacadeFactory.getFacade("org.eclipse.xtext.metamodelreferencing.tests.MetamodelRefTest")==null) {
			ILanguageFacade facade = new MetamodelRefTestLanguageFacade();
			LanguageFacadeFactory.register(facade);
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"metamodelreftest", facade.getResourceFactory());
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
    			INSTANCE = LanguageDescriptorFactory.createLanguageDescriptor(LANGUAGE_ID, LANGUAGE_NAME, NAMESPACE);
    		}
    	}
    	return INSTANCE;
    }
    
}
