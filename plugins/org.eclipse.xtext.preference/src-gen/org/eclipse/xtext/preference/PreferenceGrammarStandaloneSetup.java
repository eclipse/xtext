/*
Generated with Xtext
*/
package org.eclipse.xtext.preference;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.preference.services.PreferenceGrammarGrammarAccess;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.preference.services.PreferenceGrammarMetamodelAccess;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.GenericEcoreElementFactory;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.preference.parser.PreferenceGrammarParser;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.preference.services.PreferenceGrammarResourceFactory;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor;
import org.eclipse.xtext.preference.parsetree.reconstr.PreferenceGrammarParseTreeConstructor;

import org.eclipse.xtext.preference.IPreferenceGrammar;

public abstract class PreferenceGrammarStandaloneSetup {

	private static boolean isInitialized = false;

	public synchronized static void doSetup() {
		if(!isInitialized) {
			
			// setup super language first
			org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup.doSetup();
			
			ILanguageDescriptor languageDescriptor = 
				LanguageDescriptorFactory.createLanguageDescriptor(
					IPreferenceGrammar.ID, 
					IPreferenceGrammar.NAME, 
					IPreferenceGrammar.NAMESPACE, 
					LanguageDescriptorFactory.get("org.eclipse.xtext.builtin.XtextBuiltin"));
			ServiceRegistry.registerService(languageDescriptor, IGrammarAccess.class, PreferenceGrammarGrammarAccess.class);
			ServiceRegistry.registerService(languageDescriptor, IMetamodelAccess.class, PreferenceGrammarMetamodelAccess.class);
			ServiceRegistry.registerService(languageDescriptor, IAstFactory.class, GenericEcoreElementFactory.class);
			ServiceRegistry.registerService(languageDescriptor, IParser.class, PreferenceGrammarParser.class);
			ServiceRegistry.registerService(languageDescriptor, IResourceFactory.class, PreferenceGrammarResourceFactory.class);
			ServiceRegistry.registerService(languageDescriptor, IParseTreeConstructor.class, PreferenceGrammarParseTreeConstructor.class);
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new PreferenceGrammarResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("pref", resourceFactory);
			
			
			// initialize EPackages
			
				if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/xtext/preference")) {
					EPackage pref = EcoreUtil2.loadEPackage(
							"classpath:/org/eclipse/xtext/preference/pref.ecore",
							PreferenceGrammarStandaloneSetup.class.getClassLoader());
					if (pref == null)
						throw new IllegalStateException(
								"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/preference/pref.ecore'");
					EPackage.Registry.INSTANCE.put("http://www.eclipse.org/xtext/preference", pref);
				}
			
			isInitialized = true;
		}
	}
	
	public static synchronized ILanguageDescriptor getLanguageDescriptor() {
		if(!isInitialized) {
			doSetup();
		}
		return LanguageDescriptorFactory.get(IPreferenceGrammar.ID);
	}
			
}
