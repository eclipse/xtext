package org.eclipse.xtext.builtin;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.builtin.conversion.XtextBuiltInConverters;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;

public class XtextBuiltinStandaloneSetup {
	public final static void doSetup() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xmi", new XMIResourceFactoryImpl());
		
		ServiceRegistry.registerService(getLanguageDescriptor(), IGrammarAccess.class, XtextBuiltinGrammarAccess.class);
		ServiceRegistry.registerService(getLanguageDescriptor(), IMetamodelAccess.class, XtextBuiltinMetamodelAccess.class);
		ServiceRegistry.registerService(getLanguageDescriptor(), IValueConverterService.class, XtextBuiltInConverters.class);
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
