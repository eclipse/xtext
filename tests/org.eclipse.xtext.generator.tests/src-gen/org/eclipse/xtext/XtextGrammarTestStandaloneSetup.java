/*
Generated with Xtext
*/
package org.eclipse.xtext;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.services.XtextGrammarTestGrammarAccess;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.services.XtextGrammarTestMetamodelAccess;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.GenericEcoreElementFactory;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parser.XtextGrammarTestParser;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.services.XtextGrammarTestResourceFactory;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor;
import org.eclipse.xtext.parsetree.reconstr.XtextGrammarTestParseTreeConstructor;

import org.eclipse.xtext.IXtextGrammarTest;

public abstract class XtextGrammarTestStandaloneSetup {

	private static boolean isInitialized = false;

	public synchronized static void doSetup() {
		if(!isInitialized) {
			
			// setup super language first
			org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup.doSetup();
			
			ILanguageDescriptor languageDescriptor = 
				LanguageDescriptorFactory.createLanguageDescriptor(
					IXtextGrammarTest.ID, 
					IXtextGrammarTest.NAME, 
					IXtextGrammarTest.NAMESPACE, 
					LanguageDescriptorFactory.get("org.eclipse.xtext.builtin.XtextBuiltin"));
			ServiceRegistry.registerService(languageDescriptor, IGrammarAccess.class, XtextGrammarTestGrammarAccess.class);
			ServiceRegistry.registerService(languageDescriptor, IMetamodelAccess.class, XtextGrammarTestMetamodelAccess.class);
			ServiceRegistry.registerService(languageDescriptor, IAstFactory.class, GenericEcoreElementFactory.class);
			ServiceRegistry.registerService(languageDescriptor, IParser.class, XtextGrammarTestParser.class);
			ServiceRegistry.registerService(languageDescriptor, IResourceFactory.class, XtextGrammarTestResourceFactory.class);
			ServiceRegistry.registerService(languageDescriptor, IParseTreeConstructor.class, XtextGrammarTestParseTreeConstructor.class);
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new XtextGrammarTestResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xtextgrammartest", resourceFactory);
			
			
			// initialize EPackages
			
				if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/2008/Test/XtextTest")) {
					EPackage XtextTest = EcoreUtil2.loadEPackage(
							"classpath:/org/eclipse/xtext/XtextTest.ecore",
							XtextGrammarTestStandaloneSetup.class.getClassLoader());
					if (XtextTest == null)
						throw new IllegalStateException(
								"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/XtextTest.ecore'");
					EPackage.Registry.INSTANCE.put("http://www.eclipse.org/2008/Test/XtextTest", XtextTest);
				}
			
			isInitialized = true;
		}
	}
	
	public static synchronized ILanguageDescriptor getLanguageDescriptor() {
		if(!isInitialized) {
			doSetup();
		}
		return LanguageDescriptorFactory.get(IXtextGrammarTest.ID);
	}
			
}
