/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceScopeFactory;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.parsetree.reconstr.services.SimpleReconstrTestGrammarAccess;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parsetree.reconstr.services.SimpleReconstrTestMetamodelAccess;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.GenericEcoreElementFactory;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parsetree.reconstr.parser.SimpleReconstrTestParser;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.parsetree.reconstr.services.SimpleReconstrTestResourceFactory;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor;
import org.eclipse.xtext.parsetree.reconstr.parsetree.reconstr.SimpleReconstrTestParseTreeConstructor;

import org.eclipse.xtext.parsetree.reconstr.ISimpleReconstrTest;

public abstract class SimpleReconstrTestStandaloneSetup {

	private static boolean isInitialized = false;

	public synchronized static void doSetup() {
		if(!isInitialized) {
			
			// setup super language first
			org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup.doSetup();
			
			ServiceRegistry.registerService(org.eclipse.xtext.parsetree.reconstr.ISimpleReconstrTest.SCOPE, IGrammarAccess.class, SimpleReconstrTestGrammarAccess.class);
			ServiceRegistry.registerService(org.eclipse.xtext.parsetree.reconstr.ISimpleReconstrTest.SCOPE, IMetamodelAccess.class, SimpleReconstrTestMetamodelAccess.class);
			ServiceRegistry.registerService(org.eclipse.xtext.parsetree.reconstr.ISimpleReconstrTest.SCOPE, IAstFactory.class, GenericEcoreElementFactory.class);
			ServiceRegistry.registerService(org.eclipse.xtext.parsetree.reconstr.ISimpleReconstrTest.SCOPE, IParser.class, SimpleReconstrTestParser.class);
			ServiceRegistry.registerService(org.eclipse.xtext.parsetree.reconstr.ISimpleReconstrTest.SCOPE, IResourceFactory.class, SimpleReconstrTestResourceFactory.class);
			ServiceRegistry.registerService(org.eclipse.xtext.parsetree.reconstr.ISimpleReconstrTest.SCOPE, IParseTreeConstructor.class, SimpleReconstrTestParseTreeConstructor.class);
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new SimpleReconstrTestResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("simplereconstrtest", resourceFactory);
			
			
			// initialize EPackages
			
				if (!EPackage.Registry.INSTANCE.containsKey("http://simple/rewrite/test")) {
					EPackage simplerewritetest = EcoreUtil2.loadEPackage(
							"classpath:/org/eclipse/xtext/parsetree/reconstr/simplerewritetest.ecore",
							SimpleReconstrTestStandaloneSetup.class.getClassLoader());
					if (simplerewritetest == null)
						throw new IllegalStateException(
								"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/parsetree/reconstr/simplerewritetest.ecore'");
					EPackage.Registry.INSTANCE.put("http://simple/rewrite/test", simplerewritetest);
				}
			
			isInitialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
		return org.eclipse.xtext.parsetree.reconstr.ISimpleReconstrTest.SCOPE;
	}
}
