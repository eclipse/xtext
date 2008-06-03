package org.eclipse.xtext.testlanguages;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup;

import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.testlanguages.services.*;

public abstract class ActionTestLanguageStandaloneSetup {

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
			ServiceRegistry.registerFactory(languageDescriptor, new ActionTestLanguageParserServiceFactory());
			ServiceRegistry.registerFactory(languageDescriptor, new ActionTestLanguageASTFactoryServiceFactory());
			ServiceRegistry.registerFactory(languageDescriptor, new ActionTestLanguageParseTreeConstructorServiceFactory());
			ServiceRegistry.registerFactory(languageDescriptor, new ActionTestLanguageResourceFactoryServiceFactory());
			ServiceRegistry.registerFactory(languageDescriptor, new ActionTestLanguageGrammarAccessServiceFactory());
			ServiceRegistry.registerFactory(languageDescriptor, new ActionTestLanguageMetamodelAccessServiceFactory());
			
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
					"actiontestlanguage", ServiceRegistry.getService(languageDescriptor, IResourceFactory.class));
			isInitialized = true;
		}
	}
	
	private static ILanguageDescriptor INSTANCE;
    
    public static ILanguageDescriptor getLanguageDescriptor() {
    	if (INSTANCE == null) {
    		INSTANCE = LanguageDescriptorFactory.get(IActionTestLanguage.ID);
    		if(INSTANCE == null) {
    			// TODO put super grammar
    			INSTANCE = LanguageDescriptorFactory.createLanguageDescriptor(IActionTestLanguage.ID, IActionTestLanguage.NAME, IActionTestLanguage.NAMESPACE, XtextBuiltinStandaloneSetup.getLanguageDescriptor());
    		}
    	}
    	return INSTANCE;
    }
    
}
