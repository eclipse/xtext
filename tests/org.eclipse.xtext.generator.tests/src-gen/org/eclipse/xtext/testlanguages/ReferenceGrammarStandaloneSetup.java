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
import org.eclipse.xtext.testlanguages.services.ReferenceGrammarGrammarAccess;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.testlanguages.services.ReferenceGrammarMetamodelAccess;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.GenericEcoreElementFactory;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.testlanguages.parser.ReferenceGrammarParser;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.testlanguages.services.ReferenceGrammarResourceFactory;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor;
import org.eclipse.xtext.testlanguages.parsetree.reconstr.ReferenceGrammarParseTreeConstructor;

import org.eclipse.xtext.testlanguages.IReferenceGrammar;

public abstract class ReferenceGrammarStandaloneSetup {

	private static boolean isInitialized = false;

	public synchronized static void doSetup() {
		if(!isInitialized) {
			
			// setup super language first
			org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup.doSetup();
			
			IServiceScope scope = ServiceScopeFactory.createScope(
					IReferenceGrammar.ID, 
					ServiceScopeFactory.get("org.eclipse.xtext.builtin.XtextBuiltin"));
			ServiceRegistry.registerService(scope, IGrammarAccess.class, ReferenceGrammarGrammarAccess.class);
			ServiceRegistry.registerService(scope, IMetamodelAccess.class, ReferenceGrammarMetamodelAccess.class);
			ServiceRegistry.registerService(scope, IAstFactory.class, GenericEcoreElementFactory.class);
			ServiceRegistry.registerService(scope, IParser.class, ReferenceGrammarParser.class);
			ServiceRegistry.registerService(scope, IResourceFactory.class, ReferenceGrammarResourceFactory.class);
			ServiceRegistry.registerService(scope, IParseTreeConstructor.class, ReferenceGrammarParseTreeConstructor.class);
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new ReferenceGrammarResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("referencegrammar", resourceFactory);
			
			
			// initialize EPackages
			
				if (!EPackage.Registry.INSTANCE.containsKey("http://eclipse.org/xtext/reference/ReferenceGrammar")) {
					EPackage ReferenceGrammar = EcoreUtil2.loadEPackage(
							"classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.ecore",
							ReferenceGrammarStandaloneSetup.class.getClassLoader());
					if (ReferenceGrammar == null)
						throw new IllegalStateException(
								"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.ecore'");
					EPackage.Registry.INSTANCE.put("http://eclipse.org/xtext/reference/ReferenceGrammar", ReferenceGrammar);
				}
			
			isInitialized = true;
		}
	}
	
	public static synchronized IServiceScope getServiceScope() {
		if(!isInitialized) {
			doSetup();
		}
		return ServiceScopeFactory.get(IReferenceGrammar.ID);
	}
			
}
