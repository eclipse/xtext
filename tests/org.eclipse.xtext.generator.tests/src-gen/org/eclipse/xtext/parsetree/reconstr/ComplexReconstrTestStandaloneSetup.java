package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.LanguageFacadeFactory;
import org.eclipse.xtext.ILanguageFacade;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup;
import org.eclipse.xtext.parsetree.reconstr.services.*;

public abstract class ComplexReconstrTestStandaloneSetup {

	public static void doSetup() {
		
		// setup super language first
		XtextBuiltinStandaloneSetup.doSetup();
		
		getLanguageDescriptor();
		
		ServiceRegistry.registerFactory(new ComplexReconstrTestParserServiceFactory());
		
		ServiceRegistry.registerFactory(new ComplexReconstrTestASTFactoryServiceFactory());
		
		ServiceRegistry.registerFactory(new ComplexReconstrTestParseTreeConstructorServiceFactory());
		
		ServiceRegistry.registerFactory(new ComplexReconstrTestResourceFactoryServiceFactory());
		
		ServiceRegistry.registerFactory(new ComplexReconstrTestGrammarAccessServiceFactory());
		
		ServiceRegistry.registerFactory(new ComplexReconstrTestMetamodelAccessServiceFactory());
		
		if (LanguageFacadeFactory.getFacade("org.eclipse.xtext.parsetree.reconstr.ComplexReconstrTest")==null) {
			ILanguageFacade facade = new ComplexReconstrTestLanguageFacade();
			LanguageFacadeFactory.register(facade);
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"complexreconstrtest", facade.getResourceFactory());
		}
	}
	
	private static ILanguageDescriptor INSTANCE;
	
	public static final String LANGUAGE_ID = "org.eclipse.xtext.parsetree.reconstr.ComplexReconstrTest";
	public static final String LANGUAGE_NAME = "ComplexReconstrTest";
	public static final String NAMESPACE = "org/eclipse/xtext/parsetree/reconstr";
    
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
