package org.eclipse.xtext.grammargen.tests;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.LanguageFacadeFactory;
import org.eclipse.xtext.ILanguageFacade;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.grammargen.tests.services.*;

public abstract class SimpleTestStandaloneSetup {

	public static void doSetup() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xmi", new XMIResourceFactoryImpl());
		getLanguageDescriptor();
		ServiceRegistry.registerFactory(new SimpleTestParserServiceFactory());
		ServiceRegistry.registerFactory(new SimpleTestASTFactoryServiceFactory());
		ServiceRegistry.registerFactory(new SimpleTestParseTreeConstructorServiceFactory());
		ServiceRegistry.registerFactory(new SimpleTestResourceFactoryServiceFactory());
		ServiceRegistry.registerFactory(new SimpleTestGrammarAccessServiceFactory());
		ServiceRegistry.registerFactory(new SimpleTestMetamodelAccessServiceFactory());
		if (LanguageFacadeFactory.getFacade("org.eclipse.xtext.grammargen.tests.SimpleTest")==null) {
			ILanguageFacade facade = new SimpleTestLanguageFacade();
			LanguageFacadeFactory.register(facade);
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"simpletest", facade.getResourceFactory());
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
    			INSTANCE = LanguageDescriptorFactory.createLanguageDescriptor(LANGUAGE_ID, LANGUAGE_NAME, NAMESPACE);
    		}
    	}
    	return INSTANCE;
    }
    
}
