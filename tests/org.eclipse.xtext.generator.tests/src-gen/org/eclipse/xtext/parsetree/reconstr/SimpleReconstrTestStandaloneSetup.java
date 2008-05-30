package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.LanguageFacadeFactory;
import org.eclipse.xtext.ILanguageFacade;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.parsetree.reconstr.services.*;

public abstract class SimpleReconstrTestStandaloneSetup {

	public static void doSetup() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xmi", new XMIResourceFactoryImpl());
		getLanguageDescriptor();
		ServiceRegistry.registerFactory(new SimpleReconstrTestParserServiceFactory());
		ServiceRegistry.registerFactory(new SimpleReconstrTestASTFactoryServiceFactory());
		ServiceRegistry.registerFactory(new SimpleReconstrTestParseTreeConstructorServiceFactory());
		ServiceRegistry.registerFactory(new SimpleReconstrTestResourceFactoryServiceFactory());
		ServiceRegistry.registerFactory(new SimpleReconstrTestGrammarAccessServiceFactory());
		ServiceRegistry.registerFactory(new SimpleReconstrTestMetamodelAccessServiceFactory());
		if (LanguageFacadeFactory.getFacade("org.eclipse.xtext.parsetree.reconstr.SimpleReconstrTest")==null) {
			ILanguageFacade facade = new SimpleReconstrTestLanguageFacade();
			LanguageFacadeFactory.register(facade);
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"simplereconstrtest", facade.getResourceFactory());
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
    			INSTANCE = LanguageDescriptorFactory.createLanguageDescriptor(LANGUAGE_ID, LANGUAGE_NAME, NAMESPACE);
    		}
    	}
    	return INSTANCE;
    }
    
}
