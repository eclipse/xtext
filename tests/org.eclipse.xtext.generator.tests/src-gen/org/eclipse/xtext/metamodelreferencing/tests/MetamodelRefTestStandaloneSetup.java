/*
Generated with Xtext
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
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.parser.GenericEcoreElementFactory;
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
			ServiceRegistry.registerService(languageDescriptor, IGrammarAccess.class, MetamodelRefTestGrammarAccess.class);
			ServiceRegistry.registerService(languageDescriptor, IMetamodelAccess.class, MetamodelRefTestMetamodelAccess.class);
			ServiceRegistry.registerService(languageDescriptor, IElementFactory.class, GenericEcoreElementFactory.class);
			ServiceRegistry.registerService(languageDescriptor, IParser.class, MetamodelRefTestParser.class);
			ServiceRegistry.registerService(languageDescriptor, IResourceFactory.class, MetamodelRefTestResourceFactory.class);
			ServiceRegistry.registerService(languageDescriptor, IParseTreeConstructor.class, MetamodelRefTestParseTreeConstructor.class);
			
			// register resource factory to EMF
			ServiceRegistry.getService(languageDescriptor, IResourceFactory.class);
			isInitialized = true;
		}
	}
	
//TODO private constructor?
//	private MetamodelRefTestStandaloneSetup() {
//	}

	private static class InstanceHolder {
		private static ILanguageDescriptor INSTANCE;

		static {
			INSTANCE = LanguageDescriptorFactory.get(IMetamodelRefTest.ID);
			if (INSTANCE == null) {
				// TODO put super grammar
				INSTANCE = LanguageDescriptorFactory.createLanguageDescriptor(IMetamodelRefTest.ID,
						IMetamodelRefTest.NAME, IMetamodelRefTest.NAMESPACE, XtextBuiltinStandaloneSetup
								.getLanguageDescriptor());
			}
		}
	}

	public static ILanguageDescriptor getLanguageDescriptor() {
		return InstanceHolder.INSTANCE;
	}
}
