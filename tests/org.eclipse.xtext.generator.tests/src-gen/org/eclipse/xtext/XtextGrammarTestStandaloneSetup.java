package org.eclipse.xtext;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.LanguageFacadeFactory;
import org.eclipse.xtext.ILanguageFacade;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.services.*;

public abstract class XtextGrammarTestStandaloneSetup {

	public static void doSetup() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xmi", new XMIResourceFactoryImpl());
		getLanguageDescriptor();
		ServiceRegistry.registerFactory(new XtextGrammarTestParserServiceFactory());
		ServiceRegistry.registerFactory(new XtextGrammarTestASTFactoryServiceFactory());
		ServiceRegistry.registerFactory(new XtextGrammarTestParseTreeConstructorServiceFactory());
		ServiceRegistry.registerFactory(new XtextGrammarTestResourceFactoryServiceFactory());
		ServiceRegistry.registerFactory(new XtextGrammarTestGrammarAccessServiceFactory());
		ServiceRegistry.registerFactory(new XtextGrammarTestMetamodelAccessServiceFactory());
		if (LanguageFacadeFactory.getFacade("org.eclipse.xtext.XtextGrammarTest")==null) {
			ILanguageFacade facade = new XtextGrammarTestLanguageFacade();
			LanguageFacadeFactory.register(facade);
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xtextgrammartest", facade.getResourceFactory());
		}
	}
	
	private static ILanguageDescriptor INSTANCE;
	
	public static final String LANGUAGE_ID = "org.eclipse.xtext.XtextGrammarTest";
	public static final String LANGUAGE_NAME = "XtextGrammarTest";
	public static final String NAMESPACE = "org/eclipse/xtext";
    
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
