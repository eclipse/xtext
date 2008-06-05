package org.eclipse.xtext.grammargen.tests;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup;

import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.grammargen.tests.services.*;

public abstract class SimpleTestStandaloneSetup {

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
			ServiceRegistry.registerService(languageDescriptor, new org.eclipse.xtext.grammargen.tests.parser.SimpleTestParser(), org.eclipse.xtext.parser.IParser.class);
			ServiceRegistry.registerService(languageDescriptor, new org.eclipse.xtext.parser.GenericEcoreElementFactory(), org.eclipse.xtext.parser.IElementFactory.class);
			ServiceRegistry.registerService(languageDescriptor, new org.eclipse.xtext.grammargen.tests.services.SimpleTestResourceFactory(), org.eclipse.xtext.resource.IResourceFactory.class);
			ServiceRegistry.registerService(languageDescriptor, new org.eclipse.xtext.grammargen.tests.services.SimpleTestGrammarAccess(), org.eclipse.xtext.IGrammarAccess.class);
			ServiceRegistry.registerService(languageDescriptor, new org.eclipse.xtext.grammargen.tests.services.SimpleTestMetamodelAccess(), org.eclipse.xtext.IMetamodelAccess.class);
			ServiceRegistry.registerService(languageDescriptor, new org.eclipse.xtext.grammargen.tests.parsetree.SimpleTestParseTreeConstructor(), org.eclipse.xtext.parsetree.IParseTreeConstructor.class);
			ServiceRegistry.registerService(languageDescriptor, new org.eclipse.xtext.builtin.conversion.XtextBuiltInConverters(), org.eclipse.xtext.conversion.IValueConverterService.class);
			
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
	    		INSTANCE = LanguageDescriptorFactory.get(ISimpleTest.ID);
	    		if(INSTANCE == null) {
	    			// TODO put super grammar
	    			INSTANCE = LanguageDescriptorFactory.createLanguageDescriptor(ISimpleTest.ID, ISimpleTest.NAME, ISimpleTest.NAMESPACE, XtextBuiltinStandaloneSetup.getLanguageDescriptor());
	    		}
    		}
    	}
    	return INSTANCE;
    }
    
}
