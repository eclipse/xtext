package org.eclipse.xtext.testlanguages;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.LanguageFacadeFactory;
import org.eclipse.xtext.ILanguageFacade;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup;
import org.eclipse.xtext.testlanguages.services.*;

public abstract class TestLanguageStandaloneSetup {

	public static void doSetup() {
		
		// setup super language first
		XtextBuiltinStandaloneSetup.doSetup();
		
		getLanguageDescriptor();
		
		ServiceRegistry.registerFactory(new TestLanguageParserServiceFactory());
		
		ServiceRegistry.registerFactory(new TestLanguageASTFactoryServiceFactory());
		
		ServiceRegistry.registerFactory(new TestLanguageParseTreeConstructorServiceFactory());
		
		ServiceRegistry.registerFactory(new TestLanguageResourceFactoryServiceFactory());
		
		ServiceRegistry.registerFactory(new TestLanguageGrammarAccessServiceFactory());
		
		ServiceRegistry.registerFactory(new TestLanguageMetamodelAccessServiceFactory());
		
		if (LanguageFacadeFactory.getFacade("org.eclipse.xtext.testlanguages.TestLanguage")==null) {
			ILanguageFacade facade = new TestLanguageLanguageFacade();
			LanguageFacadeFactory.register(facade);
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"testlanguage", facade.getResourceFactory());
		}
	}
	
	private static ILanguageDescriptor INSTANCE;
	
	public static final String LANGUAGE_ID = "org.eclipse.xtext.testlanguages.TestLanguage";
	public static final String LANGUAGE_NAME = "TestLanguage";
	public static final String NAMESPACE = "org/eclipse/xtext/testlanguages";
    
    public static ILanguageDescriptor getLanguageDescriptor() {
    	if (INSTANCE == null) {
    		INSTANCE = LanguageDescriptorFactory.get(LANGUAGE_ID);
    		if(INSTANCE == null) {
    			INSTANCE = LanguageDescriptorFactory.createLanguageDescriptor(LANGUAGE_ID, LANGUAGE_NAME, NAMESPACE, XtextBuiltinStandaloneSetup.getLanguageDescriptor());
    		}
    	}
    	return INSTANCE;
    }
    
}
