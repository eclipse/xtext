/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceScopeFactory;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.testlanguages.services.LookaheadLanguageGrammarAccess;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.testlanguages.services.LookaheadLanguageMetamodelAccess;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.GenericEcoreElementFactory;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.testlanguages.parser.LookaheadLanguageParser;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.testlanguages.services.LookaheadLanguageResourceFactory;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor;
import org.eclipse.xtext.testlanguages.parsetree.reconstr.LookaheadLanguageParseTreeConstructor;

import org.eclipse.xtext.testlanguages.ILookaheadLanguage;

public abstract class LookaheadLanguageStandaloneSetup {

	private static boolean isInitialized = false;

	public synchronized static void doSetup() {
		if(!isInitialized) {
			
			// setup super language first
			org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup.doSetup();
			
			ServiceRegistry.registerService(org.eclipse.xtext.testlanguages.ILookaheadLanguage.SCOPE, IGrammarAccess.class, LookaheadLanguageGrammarAccess.class);
			ServiceRegistry.registerService(org.eclipse.xtext.testlanguages.ILookaheadLanguage.SCOPE, IMetamodelAccess.class, LookaheadLanguageMetamodelAccess.class);
			ServiceRegistry.registerService(org.eclipse.xtext.testlanguages.ILookaheadLanguage.SCOPE, IAstFactory.class, GenericEcoreElementFactory.class);
			ServiceRegistry.registerService(org.eclipse.xtext.testlanguages.ILookaheadLanguage.SCOPE, IParser.class, LookaheadLanguageParser.class);
			ServiceRegistry.registerService(org.eclipse.xtext.testlanguages.ILookaheadLanguage.SCOPE, IResourceFactory.class, LookaheadLanguageResourceFactory.class);
			ServiceRegistry.registerService(org.eclipse.xtext.testlanguages.ILookaheadLanguage.SCOPE, IParseTreeConstructor.class, LookaheadLanguageParseTreeConstructor.class);
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new LookaheadLanguageResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("lookaheadlanguage", resourceFactory);
			
			
			// initialize EPackages
			
				if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/2008/xtext/LookaheadLang")) {
					EPackage LookaheadLang = EcoreUtil2.loadEPackage(
							"classpath:/org/eclipse/xtext/testlanguages/LookaheadLang.ecore",
							LookaheadLanguageStandaloneSetup.class.getClassLoader());
					if (LookaheadLang == null)
						throw new IllegalStateException(
								"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/testlanguages/LookaheadLang.ecore'");
					EPackage.Registry.INSTANCE.put("http://www.eclipse.org/2008/xtext/LookaheadLang", LookaheadLang);
				}
			
			isInitialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
		return org.eclipse.xtext.testlanguages.ILookaheadLanguage.SCOPE;
	}
}
