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
import org.eclipse.xtext.testlanguages.services.SimpleExpressionsGrammarAccess;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.testlanguages.services.SimpleExpressionsMetamodelAccess;
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.parser.GenericEcoreElementFactory;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.testlanguages.parser.SimpleExpressionsParser;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.testlanguages.services.SimpleExpressionsResourceFactory;
import org.eclipse.xtext.parsetree.IParseTreeConstructor;
import org.eclipse.xtext.testlanguages.parsetree.SimpleExpressionsParseTreeConstructor;

import org.eclipse.xtext.testlanguages.ISimpleExpressions;

public abstract class SimpleExpressionsStandaloneSetup {

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
					ISimpleExpressions.ID, 
					ISimpleExpressions.NAME, 
					ISimpleExpressions.NAMESPACE, 
					LanguageDescriptorFactory.get("org.eclipse.xtext.builtin.XtextBuiltin"));
			ServiceRegistry.registerService(languageDescriptor, IGrammarAccess.class, SimpleExpressionsGrammarAccess.class);
			ServiceRegistry.registerService(languageDescriptor, IMetamodelAccess.class, SimpleExpressionsMetamodelAccess.class);
			ServiceRegistry.registerService(languageDescriptor, IElementFactory.class, GenericEcoreElementFactory.class);
			ServiceRegistry.registerService(languageDescriptor, IParser.class, SimpleExpressionsParser.class);
			ServiceRegistry.registerService(languageDescriptor, IResourceFactory.class, SimpleExpressionsResourceFactory.class);
			ServiceRegistry.registerService(languageDescriptor, IParseTreeConstructor.class, SimpleExpressionsParseTreeConstructor.class);
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new SimpleExpressionsResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("simpleexpressions", resourceFactory);
			
			
			isInitialized = true;
		}
	}
	
	public static ILanguageDescriptor getLanguageDescriptor() {
		if(!isInitialized) {
			doSetup();
		}
		return LanguageDescriptorFactory.get(ISimpleExpressions.ID);
	}
			
}
