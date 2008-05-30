package org.eclipse.xtext.testlanguages;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.LanguageFacadeFactory;
import org.eclipse.xtext.ILanguageFacade;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.testlanguages.services.*;

public abstract class OptionalEmptyLanguageStandaloneSetup {

	public static void doSetup() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xmi", new XMIResourceFactoryImpl());
		getLanguageDescriptor();
		ServiceRegistry.registerFactory(new OptionalEmptyLanguageParserServiceFactory());
		ServiceRegistry.registerFactory(new OptionalEmptyLanguageASTFactoryServiceFactory());
		ServiceRegistry.registerFactory(new OptionalEmptyLanguageParseTreeConstructorServiceFactory());
		ServiceRegistry.registerFactory(new OptionalEmptyLanguageResourceFactoryServiceFactory());
		ServiceRegistry.registerFactory(new OptionalEmptyLanguageGrammarAccessServiceFactory());
		ServiceRegistry.registerFactory(new OptionalEmptyLanguageMetamodelAccessServiceFactory());
		if (LanguageFacadeFactory.getFacade("org.eclipse.xtext.testlanguages.OptionalEmptyLanguage")==null) {
			ILanguageFacade facade = new OptionalEmptyLanguageLanguageFacade();
			LanguageFacadeFactory.register(facade);
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"optionalemptylanguage", facade.getResourceFactory());
		}
	}
	
	private static ILanguageDescriptor INSTANCE;
	
	public static final String LANGUAGE_ID = "org.eclipse.xtext.testlanguages.OptionalEmptyLanguage";
	public static final String LANGUAGE_NAME = "OptionalEmptyLanguage";
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
