package org.eclipse.xtext.dummy;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup;

import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.dummy.services.*;

public abstract class DummyLanguageStandaloneSetup {

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
			ServiceRegistry.registerService(languageDescriptor, new org.eclipse.xtext.dummy.parser.DummyLanguageParser(), org.eclipse.xtext.parser.IParser.class);
			ServiceRegistry.registerService(languageDescriptor, new org.eclipse.xtext.parser.GenericEcoreElementFactory(), org.eclipse.xtext.parser.IElementFactory.class);
			ServiceRegistry.registerService(languageDescriptor, new org.eclipse.xtext.dummy.services.DummyLanguageResourceFactory(), org.eclipse.xtext.resource.IResourceFactory.class);
			ServiceRegistry.registerService(languageDescriptor, new org.eclipse.xtext.dummy.services.DummyLanguageGrammarAccess(), org.eclipse.xtext.IGrammarAccess.class);
			ServiceRegistry.registerService(languageDescriptor, new org.eclipse.xtext.dummy.services.DummyLanguageMetamodelAccess(), org.eclipse.xtext.IMetamodelAccess.class);
			ServiceRegistry.registerService(languageDescriptor, new org.eclipse.xtext.dummy.parsetree.DummyLanguageParseTreeConstructor(), org.eclipse.xtext.parsetree.IParseTreeConstructor.class);
				
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
					"dummylanguage", ServiceRegistry.getService(languageDescriptor, IResourceFactory.class));
			isInitialized = true;
		}
	}
	
	private static ILanguageDescriptor INSTANCE;
	private final static Object LOCK = new Object();
    
    public static ILanguageDescriptor getLanguageDescriptor() {
    	if (INSTANCE == null) {
    		synchronized(LOCK) {
	    		INSTANCE = LanguageDescriptorFactory.get(IDummyLanguage.ID);
	    		if(INSTANCE == null) {
	    			// TODO put super grammar
	    			INSTANCE = LanguageDescriptorFactory.createLanguageDescriptor(IDummyLanguage.ID, IDummyLanguage.NAME, IDummyLanguage.NAMESPACE, XtextBuiltinStandaloneSetup.getLanguageDescriptor());
	    		}
    		}
    	}
    	return INSTANCE;
    }
    
}
