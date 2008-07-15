/*
Generated with Xtext
*/
package org.eclipse.xtext.metamodelreferencing.tests;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceScopeFactory;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.metamodelreferencing.tests.services.MetamodelRefTestGrammarAccess;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.metamodelreferencing.tests.services.MetamodelRefTestMetamodelAccess;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.GenericEcoreElementFactory;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.metamodelreferencing.tests.parser.MetamodelRefTestParser;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.metamodelreferencing.tests.services.MetamodelRefTestResourceFactory;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor;
import org.eclipse.xtext.metamodelreferencing.tests.parsetree.reconstr.MetamodelRefTestParseTreeConstructor;

import org.eclipse.xtext.metamodelreferencing.tests.IMetamodelRefTest;

public abstract class MetamodelRefTestStandaloneSetup {

	private static boolean isInitialized = false;

	public synchronized static void doSetup() {
		if(!isInitialized) {
			
			// setup super language first
			org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup.doSetup();
			
			IServiceScope scope = ServiceScopeFactory.createScope(
					IMetamodelRefTest.ID, 
					ServiceScopeFactory.get("org.eclipse.xtext.builtin.XtextBuiltin"));
			ServiceRegistry.registerService(scope, IGrammarAccess.class, MetamodelRefTestGrammarAccess.class);
			ServiceRegistry.registerService(scope, IMetamodelAccess.class, MetamodelRefTestMetamodelAccess.class);
			ServiceRegistry.registerService(scope, IAstFactory.class, GenericEcoreElementFactory.class);
			ServiceRegistry.registerService(scope, IParser.class, MetamodelRefTestParser.class);
			ServiceRegistry.registerService(scope, IResourceFactory.class, MetamodelRefTestResourceFactory.class);
			ServiceRegistry.registerService(scope, IParseTreeConstructor.class, MetamodelRefTestParseTreeConstructor.class);
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new MetamodelRefTestResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("metamodelreftest", resourceFactory);
			
			
			// initialize EPackages
			
				if (!EPackage.Registry.INSTANCE.containsKey("http://eclipse.org/xtext/tests/SimpleTest")) {
					EPackage SimpleTest = EcoreUtil2.loadEPackage(
							"classpath:/org/eclipse/xtext/metamodelreferencing/tests/SimpleTest.ecore",
							MetamodelRefTestStandaloneSetup.class.getClassLoader());
					if (SimpleTest == null)
						throw new IllegalStateException(
								"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/metamodelreferencing/tests/SimpleTest.ecore'");
					EPackage.Registry.INSTANCE.put("http://eclipse.org/xtext/tests/SimpleTest", SimpleTest);
				}
			
			isInitialized = true;
		}
	}
	
	public static synchronized IServiceScope getServiceScope() {
		if(!isInitialized) {
			doSetup();
		}
		return ServiceScopeFactory.get(IMetamodelRefTest.ID);
	}
			
}
