/*
Generated with Xtext
*/
package org.eclipse.xtext.reference;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;

import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.reference.services.ReferenceGrammarGrammarAccess;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.reference.services.ReferenceGrammarMetamodelAccess;
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.parser.GenericEcoreElementFactory;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.reference.parser.ReferenceGrammarParser;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.reference.services.ReferenceGrammarResourceFactory;
import org.eclipse.xtext.parsetree.IParseTreeConstructor;
import org.eclipse.xtext.reference.parsetree.ReferenceGrammarParseTreeConstructor;


public abstract class ReferenceGrammarStandaloneSetup {

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
			ServiceRegistry.registerService(languageDescriptor, IGrammarAccess.class, ReferenceGrammarGrammarAccess.class);
			ServiceRegistry.registerService(languageDescriptor, IMetamodelAccess.class, ReferenceGrammarMetamodelAccess.class);
			ServiceRegistry.registerService(languageDescriptor, IElementFactory.class, GenericEcoreElementFactory.class);
			ServiceRegistry.registerService(languageDescriptor, IParser.class, ReferenceGrammarParser.class);
			ServiceRegistry.registerService(languageDescriptor, IResourceFactory.class, ReferenceGrammarResourceFactory.class);
			ServiceRegistry.registerService(languageDescriptor, IParseTreeConstructor.class, ReferenceGrammarParseTreeConstructor.class);
			
			// register resource factory to EMF
			ServiceRegistry.getService(languageDescriptor, IResourceFactory.class);
			isInitialized = true;
		}
	}
	
//TODO private constructor?
//	private ReferenceGrammarStandaloneSetup() {
//	}

	private static class InstanceHolder {
		private static ILanguageDescriptor INSTANCE;

		static {
			INSTANCE = LanguageDescriptorFactory.get(IReferenceGrammar.ID);
			if (INSTANCE == null) {
				// TODO put super grammar
				INSTANCE = LanguageDescriptorFactory.createLanguageDescriptor(IReferenceGrammar.ID,
						IReferenceGrammar.NAME, IReferenceGrammar.NAMESPACE, XtextBuiltinStandaloneSetup
								.getLanguageDescriptor());
			}
		}
	}

	public static ILanguageDescriptor getLanguageDescriptor() {
		return InstanceHolder.INSTANCE;
	}
}
