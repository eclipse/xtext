package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.LanguageFacadeFactory;
import org.eclipse.xtext.ILanguageFacade;

import org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.parsetree.reconstr.services.*;

public abstract class SimpleReconstrTestStandaloneSetup {

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
			
			ServiceRegistry.registerFactory(languageDescriptor, new SimpleReconstrTestParserServiceFactory());
			
			ServiceRegistry.registerFactory(languageDescriptor, new SimpleReconstrTestASTFactoryServiceFactory());
			
			ServiceRegistry.registerFactory(languageDescriptor, new SimpleReconstrTestParseTreeConstructorServiceFactory());
			
			ServiceRegistry.registerFactory(languageDescriptor, new SimpleReconstrTestResourceFactoryServiceFactory());
			
			ServiceRegistry.registerFactory(languageDescriptor, new SimpleReconstrTestGrammarAccessServiceFactory());
			
			ServiceRegistry.registerFactory(languageDescriptor, new SimpleReconstrTestMetamodelAccessServiceFactory());
			
			if (LanguageFacadeFactory.getFacade("org.eclipse.xtext.parsetree.reconstr.SimpleReconstrTest")==null) {
				ILanguageFacade facade = new SimpleReconstrTestLanguageFacade();
				LanguageFacadeFactory.register(facade);
				Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
					"simplereconstrtest", facade.getResourceFactory());
			}
			isInitialized = true;
		}
	}
	
	private static ILanguageDescriptor INSTANCE;
	
	public static final String LANGUAGE_ID = "org.eclipse.xtext.parsetree.reconstr.SimpleReconstrTest";
	public static final String LANGUAGE_NAME = "SimpleReconstrTest";
	public static final String NAMESPACE = "org/eclipse/xtext/parsetree/reconstr";
    
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
