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
import org.eclipse.xtext.testlanguages.services.ActionTestLanguageGrammarAccess;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.testlanguages.services.ActionTestLanguageMetamodelAccess;
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.parser.GenericEcoreElementFactory;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.testlanguages.parser.ActionTestLanguageParser;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.testlanguages.services.ActionTestLanguageResourceFactory;
import org.eclipse.xtext.parsetree.IParseTreeConstructor;
import org.eclipse.xtext.testlanguages.parsetree.ActionTestLanguageParseTreeConstructor;


public abstract class ActionTestLanguageStandaloneSetup {

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
			ServiceRegistry.registerService(languageDescriptor, IGrammarAccess.class, ActionTestLanguageGrammarAccess.class);
			ServiceRegistry.registerService(languageDescriptor, IMetamodelAccess.class, ActionTestLanguageMetamodelAccess.class);
			ServiceRegistry.registerService(languageDescriptor, IElementFactory.class, GenericEcoreElementFactory.class);
			ServiceRegistry.registerService(languageDescriptor, IParser.class, ActionTestLanguageParser.class);
			ServiceRegistry.registerService(languageDescriptor, IResourceFactory.class, ActionTestLanguageResourceFactory.class);
			ServiceRegistry.registerService(languageDescriptor, IParseTreeConstructor.class, ActionTestLanguageParseTreeConstructor.class);
			
			// register resource factory to EMF
			ServiceRegistry.getService(languageDescriptor, IResourceFactory.class);
			isInitialized = true;
		}
	}
	
//TODO private constructor?
//	private ActionTestLanguageStandaloneSetup() {
//	}

	private static class InstanceHolder {
		private static ILanguageDescriptor INSTANCE;

		static {
			INSTANCE = LanguageDescriptorFactory.get(IActionTestLanguage.ID);
			if (INSTANCE == null) {
				// TODO put super grammar
				INSTANCE = LanguageDescriptorFactory.createLanguageDescriptor(IActionTestLanguage.ID,
						IActionTestLanguage.NAME, IActionTestLanguage.NAMESPACE, XtextBuiltinStandaloneSetup
								.getLanguageDescriptor());
			}
		}
	}

	public static ILanguageDescriptor getLanguageDescriptor() {
		return InstanceHolder.INSTANCE;
	}
}
