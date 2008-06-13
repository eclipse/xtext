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
import org.eclipse.xtext.services.XtextGrammarTestGrammarAccess;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.services.XtextGrammarTestMetamodelAccess;
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.parser.GenericEcoreElementFactory;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parser.XtextGrammarTestParser;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.services.XtextGrammarTestResourceFactory;
import org.eclipse.xtext.parsetree.IParseTreeConstructor;
import org.eclipse.xtext.parsetree.XtextGrammarTestParseTreeConstructor;

import org.eclipse.xtext.IXtextGrammarTest;

public abstract class XtextGrammarTestStandaloneSetup {

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
					IXtextGrammarTest.ID, 
					IXtextGrammarTest.NAME, 
					IXtextGrammarTest.NAMESPACE, 
					LanguageDescriptorFactory.get("org.eclipse.xtext.builtin.XtextBuiltin"));
			ServiceRegistry.registerService(languageDescriptor, IGrammarAccess.class, XtextGrammarTestGrammarAccess.class);
			ServiceRegistry.registerService(languageDescriptor, IMetamodelAccess.class, XtextGrammarTestMetamodelAccess.class);
			ServiceRegistry.registerService(languageDescriptor, IElementFactory.class, GenericEcoreElementFactory.class);
			ServiceRegistry.registerService(languageDescriptor, IParser.class, XtextGrammarTestParser.class);
			ServiceRegistry.registerService(languageDescriptor, IResourceFactory.class, XtextGrammarTestResourceFactory.class);
			ServiceRegistry.registerService(languageDescriptor, IParseTreeConstructor.class, XtextGrammarTestParseTreeConstructor.class);
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new XtextGrammarTestResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xtextgrammartest", resourceFactory);
			
			
		}
	}
	
	public static ILanguageDescriptor getLanguageDescriptor() {
		return LanguageDescriptorFactory.get(IXtextGrammarTest.ID);
	}
			
}
