/*
Generated using Xtext at Fri Jun 06 17:58:57 CEST 2008
*/
package org.eclipse.xtext.metamodelreferencing.tests;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;

import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.metamodelreferencing.tests.services.MetamodelRefTestGrammarAccess;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.metamodelreferencing.tests.services.MetamodelRefTestMetamodelAccess;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.metamodelreferencing.tests.parser.MetamodelRefTestParser;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.metamodelreferencing.tests.services.MetamodelRefTestResourceFactory;
import org.eclipse.xtext.parsetree.IParseTreeConstructor;
import org.eclipse.xtext.metamodelreferencing.tests.parsetree.MetamodelRefTestParseTreeConstructor;


public abstract class MetamodelRefTestStandaloneSetup {

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
			ServiceRegistry.registerService(languageDescriptor, new MetamodelRefTestGrammarAccess(), IGrammarAccess.class);
			ServiceRegistry.registerService(languageDescriptor, new MetamodelRefTestMetamodelAccess(), IMetamodelAccess.class);
			ServiceRegistry.registerService(languageDescriptor, new MetamodelRefTestParser(), IParser.class);
			ServiceRegistry.registerService(languageDescriptor, new MetamodelRefTestResourceFactory(), IResourceFactory.class);
			ServiceRegistry.registerService(languageDescriptor, new MetamodelRefTestParseTreeConstructor(), IParseTreeConstructor.class);
			
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
	    		INSTANCE = LanguageDescriptorFactory.get(IMetamodelRefTest.ID);
	    		if(INSTANCE == null) {
	    			// TODO put super grammar
	    			INSTANCE = LanguageDescriptorFactory.createLanguageDescriptor(IMetamodelRefTest.ID, IMetamodelRefTest.NAME, IMetamodelRefTest.NAMESPACE, XtextBuiltinStandaloneSetup.getLanguageDescriptor());
	    		}
    		}
    	}
    	return INSTANCE;
    }
    
}
