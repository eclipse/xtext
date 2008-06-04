package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup;

import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.parsetree.reconstr.services.*;

public abstract class SimpleReconstrTestStandaloneSetup {

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
			ServiceRegistry.registerService(languageDescriptor, new org.eclipse.xtext.parsetree.reconstr.parser.SimpleReconstrTestParser(), org.eclipse.xtext.parser.IParser.class);
			ServiceRegistry.registerService(languageDescriptor, new org.eclipse.xtext.parser.GenericEcoreElementFactory(), org.eclipse.xtext.parser.IElementFactory.class);
			ServiceRegistry.registerService(languageDescriptor, new org.eclipse.xtext.parsetree.reconstr.services.SimpleReconstrTestResourceFactory(), org.eclipse.xtext.resource.IResourceFactory.class);
			ServiceRegistry.registerService(languageDescriptor, new org.eclipse.xtext.parsetree.reconstr.services.SimpleReconstrTestGrammarAccess(), org.eclipse.xtext.IGrammarAccess.class);
			ServiceRegistry.registerService(languageDescriptor, new org.eclipse.xtext.parsetree.reconstr.services.SimpleReconstrTestMetamodelAccess(), org.eclipse.xtext.IMetamodelAccess.class);
			ServiceRegistry.registerService(languageDescriptor, new org.eclipse.xtext.parsetree.reconstr.parsetree.SimpleReconstrTestParseTreeConstructor(), org.eclipse.xtext.parsetree.IParseTreeConstructor.class);
			ServiceRegistry.registerService(languageDescriptor, new org.eclipse.xtext.builtin.conversion.XtextBuiltInConverters(), org.eclipse.xtext.conversion.IValueConverterService.class);
				
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
					"simplereconstrtest", ServiceRegistry.getService(languageDescriptor, IResourceFactory.class));
			isInitialized = true;
		}
	}
	
	private static ILanguageDescriptor INSTANCE;
	private final static Object LOCK = new Object();
    
    public static ILanguageDescriptor getLanguageDescriptor() {
    	if (INSTANCE == null) {
    		synchronized(LOCK) {
	    		INSTANCE = LanguageDescriptorFactory.get(ISimpleReconstrTest.ID);
	    		if(INSTANCE == null) {
	    			// TODO put super grammar
	    			INSTANCE = LanguageDescriptorFactory.createLanguageDescriptor(ISimpleReconstrTest.ID, ISimpleReconstrTest.NAME, ISimpleReconstrTest.NAMESPACE, XtextBuiltinStandaloneSetup.getLanguageDescriptor());
	    		}
    		}
    	}
    	return INSTANCE;
    }
    
}
