/*
Generated with Xtext
*/
package org.eclipse.xtext;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceScopeFactory;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.services.XtextGrammarAccess;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.services.XtextMetamodelAccess;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.GenericEcoreElementFactory;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parser.XtextParser;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.services.XtextResourceFactory;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor;
import org.eclipse.xtext.parsetree.reconstr.XtextParseTreeConstructor;

import org.eclipse.xtext.IXtext;

public abstract class XtextStandaloneSetup {

	private static boolean isInitialized = false;

	public synchronized static void doSetup() {
		if(!isInitialized) {
			
			// setup super language first
			org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup.doSetup();
			
			ServiceRegistry.registerService(org.eclipse.xtext.IXtext.SCOPE, IGrammarAccess.class, XtextGrammarAccess.class);
			ServiceRegistry.registerService(org.eclipse.xtext.IXtext.SCOPE, IMetamodelAccess.class, XtextMetamodelAccess.class);
			ServiceRegistry.registerService(org.eclipse.xtext.IXtext.SCOPE, IAstFactory.class, GenericEcoreElementFactory.class);
			ServiceRegistry.registerService(org.eclipse.xtext.IXtext.SCOPE, IParser.class, XtextParser.class);
			ServiceRegistry.registerService(org.eclipse.xtext.IXtext.SCOPE, IResourceFactory.class, XtextResourceFactory.class);
			ServiceRegistry.registerService(org.eclipse.xtext.IXtext.SCOPE, IParseTreeConstructor.class, XtextParseTreeConstructor.class);
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new XtextResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xtext", resourceFactory);
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xtext2", resourceFactory);
			
			
			// initialize EPackages
			
				if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/2008/Xtext")) {
					EPackage xtext = EcoreUtil2.loadEPackage(
							"classpath:/org/eclipse/xtext/xtext.ecore",
							XtextStandaloneSetup.class.getClassLoader());
					if (xtext == null)
						throw new IllegalStateException(
								"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/xtext.ecore'");
					EPackage.Registry.INSTANCE.put("http://www.eclipse.org/2008/Xtext", xtext);
				}
			
			isInitialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
		return org.eclipse.xtext.IXtext.SCOPE;
	}
}
