package org.eclipse.xtext;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;

public abstract class XtextStandaloneSetup {

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
			ServiceRegistry.registerService(languageDescriptor, org.eclipse.xtext.parser.IParser.class, org.eclipse.xtext.parser.XtextParser.class);
			ServiceRegistry.registerService(languageDescriptor, org.eclipse.xtext.parser.IElementFactory.class, org.eclipse.xtext.parser.GenericEcoreElementFactory.class);
			ServiceRegistry.registerService(languageDescriptor, org.eclipse.xtext.resource.IResourceFactory.class, org.eclipse.xtext.services.XtextResourceFactory.class);
			ServiceRegistry.registerService(languageDescriptor, org.eclipse.xtext.IGrammarAccess.class, org.eclipse.xtext.services.XtextGrammarAccess.class);
			ServiceRegistry.registerService(languageDescriptor, org.eclipse.xtext.IMetamodelAccess.class, org.eclipse.xtext.services.XtextMetamodelAccess.class);
			ServiceRegistry.registerService(languageDescriptor, org.eclipse.xtext.parsetree.IParseTreeConstructor.class, org.eclipse.xtext.parsetree.XtextParseTreeConstructor.class);
			ServiceRegistry.registerService(languageDescriptor, org.eclipse.xtext.conversion.IValueConverterService.class, org.eclipse.xtext.builtin.conversion.XtextBuiltInConverters.class);
				
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
					"xtext", ServiceRegistry.getService(languageDescriptor, IResourceFactory.class));
			isInitialized = true;
		}
	}
	
	private static ILanguageDescriptor INSTANCE;
	private final static Object LOCK = new Object();
    
    public static ILanguageDescriptor getLanguageDescriptor() {
    	if (INSTANCE == null) {
    		synchronized(LOCK) {
	    		INSTANCE = LanguageDescriptorFactory.get(IXtext.ID);
	    		if(INSTANCE == null) {
	    			// TODO put super grammar
	    			INSTANCE = LanguageDescriptorFactory.createLanguageDescriptor(IXtext.ID, IXtext.NAME, IXtext.NAMESPACE, XtextBuiltinStandaloneSetup.getLanguageDescriptor());
	    		}
    		}
    	}
    	return INSTANCE;
    }
    
}
