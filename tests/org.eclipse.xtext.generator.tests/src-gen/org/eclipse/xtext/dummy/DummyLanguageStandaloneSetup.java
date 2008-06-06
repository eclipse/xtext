/*
Generated using Xtext at Fri Jun 06 17:58:57 CEST 2008
*/
package org.eclipse.xtext.dummy;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;

import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.dummy.services.DummyLanguageGrammarAccess;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.dummy.services.DummyLanguageMetamodelAccess;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.dummy.parser.DummyLanguageParser;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.dummy.services.DummyLanguageResourceFactory;
import org.eclipse.xtext.parsetree.IParseTreeConstructor;
import org.eclipse.xtext.dummy.parsetree.DummyLanguageParseTreeConstructor;


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
			ServiceRegistry.registerService(languageDescriptor, new DummyLanguageGrammarAccess(), IGrammarAccess.class);
			ServiceRegistry.registerService(languageDescriptor, new DummyLanguageMetamodelAccess(), IMetamodelAccess.class);
			ServiceRegistry.registerService(languageDescriptor, new DummyLanguageParser(), IParser.class);
			ServiceRegistry.registerService(languageDescriptor, new DummyLanguageResourceFactory(), IResourceFactory.class);
			ServiceRegistry.registerService(languageDescriptor, new DummyLanguageParseTreeConstructor(), IParseTreeConstructor.class);
			
			// register resource factory to EMF
			ServiceRegistry.getService(languageDescriptor, IResourceFactory.class);
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
