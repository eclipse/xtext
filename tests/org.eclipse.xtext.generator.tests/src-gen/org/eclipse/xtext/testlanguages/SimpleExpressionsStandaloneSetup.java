/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.testlanguages.services.SimpleExpressionsGrammarAccess;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.testlanguages.services.SimpleExpressionsMetamodelAccess;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.GenericEcoreElementFactory;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.testlanguages.parser.SimpleExpressionsParser;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.testlanguages.services.SimpleExpressionsResourceFactory;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor;
import org.eclipse.xtext.testlanguages.parsetree.reconstr.SimpleExpressionsParseTreeConstructor;

import org.eclipse.xtext.testlanguages.ISimpleExpressions;

public abstract class SimpleExpressionsStandaloneSetup {

	private static boolean isInitialized = false;

	public synchronized static void doSetup() {
		if(!isInitialized) {
			
			// setup super language first
			org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup.doSetup();
			
			ILanguageDescriptor languageDescriptor = 
				LanguageDescriptorFactory.createLanguageDescriptor(
					ISimpleExpressions.ID, 
					ISimpleExpressions.NAME, 
					ISimpleExpressions.NAMESPACE, 
					LanguageDescriptorFactory.get("org.eclipse.xtext.builtin.XtextBuiltin"));
			ServiceRegistry.registerService(languageDescriptor, IGrammarAccess.class, SimpleExpressionsGrammarAccess.class);
			ServiceRegistry.registerService(languageDescriptor, IMetamodelAccess.class, SimpleExpressionsMetamodelAccess.class);
			ServiceRegistry.registerService(languageDescriptor, IAstFactory.class, GenericEcoreElementFactory.class);
			ServiceRegistry.registerService(languageDescriptor, IParser.class, SimpleExpressionsParser.class);
			ServiceRegistry.registerService(languageDescriptor, IResourceFactory.class, SimpleExpressionsResourceFactory.class);
			ServiceRegistry.registerService(languageDescriptor, IParseTreeConstructor.class, SimpleExpressionsParseTreeConstructor.class);
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new SimpleExpressionsResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("simpleexpressions", resourceFactory);
			
			
			// initialize EPackages
			
				if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/xtext/test/simpleExpressions")) {
					EPackage simpleExpressions = EcoreUtil2.loadEPackage(
							"classpath:/org/eclipse/xtext/testlanguages/simpleExpressions.ecore",
							SimpleExpressionsStandaloneSetup.class.getClassLoader());
					if (simpleExpressions == null)
						throw new IllegalStateException(
								"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/testlanguages/simpleExpressions.ecore'");
					EPackage.Registry.INSTANCE.put("http://www.eclipse.org/xtext/test/simpleExpressions", simpleExpressions);
				}
			
			isInitialized = true;
		}
	}
	
	public static synchronized ILanguageDescriptor getLanguageDescriptor() {
		if(!isInitialized) {
			doSetup();
		}
		return LanguageDescriptorFactory.get(ISimpleExpressions.ID);
	}
			
}
