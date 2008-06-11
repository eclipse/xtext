/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;

import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestGrammarAccess;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestMetamodelAccess;
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.parser.GenericEcoreElementFactory;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parsetree.reconstr.parser.ComplexReconstrTestParser;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestResourceFactory;
import org.eclipse.xtext.parsetree.IParseTreeConstructor;
import org.eclipse.xtext.parsetree.reconstr.parsetree.ComplexReconstrTestParseTreeConstructor;


public abstract class ComplexReconstrTestStandaloneSetup {

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
			ServiceRegistry.registerService(languageDescriptor, IGrammarAccess.class, ComplexReconstrTestGrammarAccess.class);
			ServiceRegistry.registerService(languageDescriptor, IMetamodelAccess.class, ComplexReconstrTestMetamodelAccess.class);
			ServiceRegistry.registerService(languageDescriptor, IElementFactory.class, GenericEcoreElementFactory.class);
			ServiceRegistry.registerService(languageDescriptor, IParser.class, ComplexReconstrTestParser.class);
			ServiceRegistry.registerService(languageDescriptor, IResourceFactory.class, ComplexReconstrTestResourceFactory.class);
			ServiceRegistry.registerService(languageDescriptor, IParseTreeConstructor.class, ComplexReconstrTestParseTreeConstructor.class);
			
			// register resource factory to EMF
			ServiceRegistry.getService(languageDescriptor, IResourceFactory.class);
			isInitialized = true;
		}
	}
	
//TODO private constructor?
//	private ComplexReconstrTestStandaloneSetup() {
//	}

	private static class InstanceHolder {
		private static ILanguageDescriptor INSTANCE;

		static {
			INSTANCE = LanguageDescriptorFactory.get(IComplexReconstrTest.ID);
			if (INSTANCE == null) {
				// TODO put super grammar
				INSTANCE = LanguageDescriptorFactory.createLanguageDescriptor(IComplexReconstrTest.ID,
						IComplexReconstrTest.NAME, IComplexReconstrTest.NAMESPACE, XtextBuiltinStandaloneSetup
								.getLanguageDescriptor());
			}
		}
	}

	public static ILanguageDescriptor getLanguageDescriptor() {
		return InstanceHolder.INSTANCE;
	}
}
