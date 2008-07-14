/*
Generated with Xtext
*/
package org.eclipse.xtext.dummy;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.dummy.services.DummyLanguageGrammarAccess;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.dummy.services.DummyLanguageMetamodelAccess;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.GenericEcoreElementFactory;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.dummy.parser.DummyLanguageParser;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.dummy.services.DummyLanguageResourceFactory;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor;
import org.eclipse.xtext.dummy.parsetree.reconstr.DummyLanguageParseTreeConstructor;

import org.eclipse.xtext.dummy.IDummyLanguage;

public abstract class DummyLanguageStandaloneSetup {

	private static boolean isInitialized = false;

	public synchronized static void doSetup() {
		if(!isInitialized) {
			
			// setup super language first
			org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup.doSetup();
			
			ILanguageDescriptor languageDescriptor = 
				LanguageDescriptorFactory.createLanguageDescriptor(
					IDummyLanguage.ID, 
					IDummyLanguage.NAME, 
					IDummyLanguage.NAMESPACE, 
					LanguageDescriptorFactory.get("org.eclipse.xtext.builtin.XtextBuiltin"));
			ServiceRegistry.registerService(languageDescriptor, IGrammarAccess.class, DummyLanguageGrammarAccess.class);
			ServiceRegistry.registerService(languageDescriptor, IMetamodelAccess.class, DummyLanguageMetamodelAccess.class);
			ServiceRegistry.registerService(languageDescriptor, IAstFactory.class, GenericEcoreElementFactory.class);
			ServiceRegistry.registerService(languageDescriptor, IParser.class, DummyLanguageParser.class);
			ServiceRegistry.registerService(languageDescriptor, IResourceFactory.class, DummyLanguageResourceFactory.class);
			ServiceRegistry.registerService(languageDescriptor, IParseTreeConstructor.class, DummyLanguageParseTreeConstructor.class);
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new DummyLanguageResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("dummylanguage", resourceFactory);
			
			
			// initialize EPackages
			
				if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/2008/xtext/DummyLang")) {
					EPackage DummyLang = EcoreUtil2.loadEPackage(
							"classpath:/org/eclipse/xtext/dummy/DummyLang.ecore",
							DummyLanguageStandaloneSetup.class.getClassLoader());
					if (DummyLang == null)
						throw new IllegalStateException(
								"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/dummy/DummyLang.ecore'");
					EPackage.Registry.INSTANCE.put("http://www.eclipse.org/2008/xtext/DummyLang", DummyLang);
				}
			
			isInitialized = true;
		}
	}
	
	public static synchronized ILanguageDescriptor getLanguageDescriptor() {
		if(!isInitialized) {
			doSetup();
		}
		return LanguageDescriptorFactory.get(IDummyLanguage.ID);
	}
			
}
