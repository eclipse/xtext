/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.testlanguages.services.OptionalEmptyLanguageGrammarAccess;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.testlanguages.services.OptionalEmptyLanguageMetamodelAccess;
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.parser.GenericEcoreElementFactory;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.testlanguages.parser.OptionalEmptyLanguageParser;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.testlanguages.services.OptionalEmptyLanguageResourceFactory;
import org.eclipse.xtext.parsetree.IParseTreeConstructor;
import org.eclipse.xtext.testlanguages.parsetree.OptionalEmptyLanguageParseTreeConstructor;

import org.eclipse.xtext.testlanguages.IOptionalEmptyLanguage;

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
			ILanguageDescriptor languageDescriptor = 
				LanguageDescriptorFactory.createLanguageDescriptor(
					IOptionalEmptyLanguage.ID, 
					IOptionalEmptyLanguage.NAME, 
					IOptionalEmptyLanguage.NAMESPACE, 
					LanguageDescriptorFactory.get("org.eclipse.xtext.builtin.XtextBuiltin"));
			ServiceRegistry.registerService(languageDescriptor, IGrammarAccess.class, OptionalEmptyLanguageGrammarAccess.class);
			ServiceRegistry.registerService(languageDescriptor, IMetamodelAccess.class, OptionalEmptyLanguageMetamodelAccess.class);
			ServiceRegistry.registerService(languageDescriptor, IElementFactory.class, GenericEcoreElementFactory.class);
			ServiceRegistry.registerService(languageDescriptor, IParser.class, OptionalEmptyLanguageParser.class);
			ServiceRegistry.registerService(languageDescriptor, IResourceFactory.class, OptionalEmptyLanguageResourceFactory.class);
			ServiceRegistry.registerService(languageDescriptor, IParseTreeConstructor.class, OptionalEmptyLanguageParseTreeConstructor.class);
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new OptionalEmptyLanguageResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("optionalemptylanguage", resourceFactory);
			
			
			isInitialized = true;
		}
	}
	
	public static ILanguageDescriptor getLanguageDescriptor() {
		if(!isInitialized) {
			doSetup();
		}
		return LanguageDescriptorFactory.get(IOptionalEmptyLanguage.ID);
	}
			
}
