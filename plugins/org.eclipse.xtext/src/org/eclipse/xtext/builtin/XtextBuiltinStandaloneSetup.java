package org.eclipse.xtext.builtin;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.service.impl.SingletonLanguageServiceFactory;

public class XtextBuiltinStandaloneSetup {
	public final static void doSetup() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xmi", new XMIResourceFactoryImpl());
		
		ServiceRegistry.registerFactory(getLanguageDescriptor(), new SingletonLanguageServiceFactory(new XtextBuiltinGrammarAccess(), IGrammarAccess.class));
		ServiceRegistry.registerFactory(getLanguageDescriptor(), new SingletonLanguageServiceFactory(new XtextBuiltinMetamodelAccess(), IMetamodelAccess.class));
	}
	
	private static ILanguageDescriptor INSTANCE;
	
	public static final String LANGUAGE_ID = IXtextBuiltin.ID;
	public static final String LANGUAGE_NAME = "XtextBuiltin";
	public static final String NAMESPACE = "org/eclipse/xtext/builtin";
    
    public static ILanguageDescriptor getLanguageDescriptor() {
    	if (INSTANCE == null) {
    		INSTANCE = LanguageDescriptorFactory.get(LANGUAGE_ID);
    		if(INSTANCE == null) {
    			INSTANCE = LanguageDescriptorFactory.createLanguageDescriptor(LANGUAGE_ID, LANGUAGE_NAME, NAMESPACE, null);
    		}
    	}
    	return INSTANCE;
	}
}
