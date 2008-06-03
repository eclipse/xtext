package org.eclipse.xtext.testlanguages;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup;

import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.testlanguages.services.*;

public abstract class OptionalEmptyLanguageStandaloneSetup {

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
			ServiceRegistry.registerService(languageDescriptor, new org.eclipse.xtext.testlanguages.parser.OptionalEmptyLanguageParser(), org.eclipse.xtext.parser.IParser.class);
			ServiceRegistry.registerService(languageDescriptor, new org.eclipse.xtext.parser.GenericEcoreElementFactory(), org.eclipse.xtext.parser.IElementFactory.class);
			ServiceRegistry.registerService(languageDescriptor, new org.eclipse.xtext.testlanguages.services.OptionalEmptyLanguageResourceFactory(), org.eclipse.xtext.resource.IResourceFactory.class);
			ServiceRegistry.registerService(languageDescriptor, new org.eclipse.xtext.testlanguages.services.OptionalEmptyLanguageGrammarAccess(), org.eclipse.xtext.IGrammarAccess.class);
			ServiceRegistry.registerService(languageDescriptor, new org.eclipse.xtext.testlanguages.services.OptionalEmptyLanguageMetamodelAccess(), org.eclipse.xtext.IMetamodelAccess.class);
			ServiceRegistry.registerService(languageDescriptor, new org.eclipse.xtext.testlanguages.parsetree.OptionalEmptyLanguageParseTreeConstructor(), org.eclipse.xtext.parsetree.IParseTreeConstructor.class);
				
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
					"optionalemptylanguage", ServiceRegistry.getService(languageDescriptor, IResourceFactory.class));
			isInitialized = true;
		}
	}
	
	private static ILanguageDescriptor INSTANCE;
	private final static Object LOCK = new Object();
    
    public static ILanguageDescriptor getLanguageDescriptor() {
    	if (INSTANCE == null) {
    		synchronized(LOCK) {
	    		INSTANCE = LanguageDescriptorFactory.get(IOptionalEmptyLanguage.ID);
	    		if(INSTANCE == null) {
	    			// TODO put super grammar
	    			INSTANCE = LanguageDescriptorFactory.createLanguageDescriptor(IOptionalEmptyLanguage.ID, IOptionalEmptyLanguage.NAME, IOptionalEmptyLanguage.NAMESPACE, XtextBuiltinStandaloneSetup.getLanguageDescriptor());
	    		}
    		}
    	}
    	return INSTANCE;
    }
    
}
