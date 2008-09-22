/*
Generated with Xtext
*/
package org.eclipse.xtext.crossrefs;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceScopeFactory;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.crossrefs.services.LangAGrammarAccess;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.crossrefs.services.LangAMetamodelAccess;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.GenericEcoreElementFactory;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.crossrefs.parser.LangAParser;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.crossrefs.services.LangAResourceFactory;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor;
import org.eclipse.xtext.crossrefs.parsetree.reconstr.LangAParseTreeConstructor;

import org.eclipse.xtext.crossrefs.ILangA;

public abstract class LangAStandaloneSetup {

	private static boolean isInitialized = false;

	public synchronized static void doSetup() {
		if(!isInitialized) {
			
			// setup super language first
			org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup.doSetup();
			
			ServiceRegistry.registerService(org.eclipse.xtext.crossrefs.ILangA.SCOPE, IGrammarAccess.class, LangAGrammarAccess.class);
			ServiceRegistry.registerService(org.eclipse.xtext.crossrefs.ILangA.SCOPE, IMetamodelAccess.class, LangAMetamodelAccess.class);
			ServiceRegistry.registerService(org.eclipse.xtext.crossrefs.ILangA.SCOPE, IAstFactory.class, GenericEcoreElementFactory.class);
			ServiceRegistry.registerService(org.eclipse.xtext.crossrefs.ILangA.SCOPE, IParser.class, LangAParser.class);
			ServiceRegistry.registerService(org.eclipse.xtext.crossrefs.ILangA.SCOPE, IResourceFactory.class, LangAResourceFactory.class);
			ServiceRegistry.registerService(org.eclipse.xtext.crossrefs.ILangA.SCOPE, IParseTreeConstructor.class, LangAParseTreeConstructor.class);
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new LangAResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("langa", resourceFactory);
			
			
			// initialize EPackages
			
				if (!EPackage.Registry.INSTANCE.containsKey("http://eclipse.org/xtext/langA")) {
					EPackage langA = EcoreUtil2.loadEPackage(
							"classpath:/org/eclipse/xtext/crossrefs/langA.ecore",
							LangAStandaloneSetup.class.getClassLoader());
					if (langA == null)
						throw new IllegalStateException(
								"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/crossrefs/langA.ecore'");
					EPackage.Registry.INSTANCE.put("http://eclipse.org/xtext/langA", langA);
				}
			
			isInitialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
		return org.eclipse.xtext.crossrefs.ILangA.SCOPE;
	}
}
