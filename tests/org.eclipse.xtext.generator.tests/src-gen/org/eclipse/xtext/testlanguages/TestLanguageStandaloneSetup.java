package org.eclipse.xtext.testlanguages;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup;

import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.testlanguages.services.*;

public abstract class TestLanguageStandaloneSetup {

	private static boolean isInitialized = false;

	public synchronized static void doSetup() {
		if(!isInitialized) {
			
			// setup super language first
			XtextBuiltinStandaloneSetup.doSetup();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new XMIResourceFactoryImpl());
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xmi", new XMIResourceFactoryImpl());
			ILanguageDescriptor languageDescriptor = getLanguageDescriptor();
			ServiceRegistry.registerFactory(languageDescriptor, new TestLanguageParserServiceFactory());
			ServiceRegistry.registerFactory(languageDescriptor, new TestLanguageASTFactoryServiceFactory());
			ServiceRegistry.registerFactory(languageDescriptor, new TestLanguageParseTreeConstructorServiceFactory());
			ServiceRegistry.registerFactory(languageDescriptor, new TestLanguageResourceFactoryServiceFactory());
			ServiceRegistry.registerFactory(languageDescriptor, new TestLanguageGrammarAccessServiceFactory());
			ServiceRegistry.registerFactory(languageDescriptor, new TestLanguageMetamodelAccessServiceFactory());
			
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
					"testlanguage", ServiceRegistry.getService(languageDescriptor, IResourceFactory.class));
			isInitialized = true;
		}
	}
	
	private static ILanguageDescriptor INSTANCE;
	private final static Object LOCK = new Object();
    
    public static ILanguageDescriptor getLanguageDescriptor() {
    	if (INSTANCE == null) {
    		synchronized(LOCK) {
	    		INSTANCE = LanguageDescriptorFactory.get(ITestLanguage.ID);
	    		if(INSTANCE == null) {
	    			// TODO put super grammar
	    			INSTANCE = LanguageDescriptorFactory.createLanguageDescriptor(ITestLanguage.ID, ITestLanguage.NAME, ITestLanguage.NAMESPACE, XtextBuiltinStandaloneSetup.getLanguageDescriptor());
	    		}
    		}
    	}
    	return INSTANCE;
    }
    
}
