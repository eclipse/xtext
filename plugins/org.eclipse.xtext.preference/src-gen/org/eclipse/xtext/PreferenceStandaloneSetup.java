/*
Generated with Xtext
*/
package org.eclipse.xtext;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.services.PreferenceGrammarAccess;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.services.PreferenceMetamodelAccess;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.GenericEcoreElementFactory;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parser.PreferenceParser;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.services.PreferenceResourceFactory;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor;
import org.eclipse.xtext.parsetree.reconstr.PreferenceParseTreeConstructor;

import org.eclipse.xtext.IPreference;

public abstract class PreferenceStandaloneSetup {

	private static boolean isInitialized = false;

	public synchronized static void doSetup() {
		if(!isInitialized) {
			
			// setup super language first
			XtextBuiltinStandaloneSetup.doSetup();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new XMIResourceFactoryImpl());
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xmi", new XMIResourceFactoryImpl());
			ILanguageDescriptor languageDescriptor = 
				LanguageDescriptorFactory.createLanguageDescriptor(
					IPreference.ID, 
					IPreference.NAME, 
					IPreference.NAMESPACE, 
					LanguageDescriptorFactory.get("org.eclipse.xtext.builtin.XtextBuiltin"));
			ServiceRegistry.registerService(languageDescriptor, IGrammarAccess.class, PreferenceGrammarAccess.class);
			ServiceRegistry.registerService(languageDescriptor, IMetamodelAccess.class, PreferenceMetamodelAccess.class);
			ServiceRegistry.registerService(languageDescriptor, IAstFactory.class, GenericEcoreElementFactory.class);
			ServiceRegistry.registerService(languageDescriptor, IParser.class, PreferenceParser.class);
			ServiceRegistry.registerService(languageDescriptor, IResourceFactory.class, PreferenceResourceFactory.class);
			ServiceRegistry.registerService(languageDescriptor, IParseTreeConstructor.class, PreferenceParseTreeConstructor.class);
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new PreferenceResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("pref", resourceFactory);
			
			
			isInitialized = true;
		}
	}
	
	public static ILanguageDescriptor getLanguageDescriptor() {
		if(!isInitialized) {
			doSetup();
		}
		return LanguageDescriptorFactory.get(IPreference.ID);
	}
			
}
