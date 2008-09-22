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
import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestGrammarAccess;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestMetamodelAccess;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.GenericEcoreElementFactory;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parsetree.reconstr.parser.ComplexReconstrTestParser;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestResourceFactory;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor;
import org.eclipse.xtext.parsetree.reconstr.parsetree.reconstr.ComplexReconstrTestParseTreeConstructor;

import org.eclipse.xtext.parsetree.reconstr.IComplexReconstrTest;

public abstract class ComplexReconstrTestStandaloneSetup {

	private static boolean isInitialized = false;

	public synchronized static void doSetup() {
		if(!isInitialized) {
			
			// setup super language first
			org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup.doSetup();
			
			ServiceRegistry.registerService(org.eclipse.xtext.parsetree.reconstr.IComplexReconstrTest.SCOPE, IGrammarAccess.class, ComplexReconstrTestGrammarAccess.class);
			ServiceRegistry.registerService(org.eclipse.xtext.parsetree.reconstr.IComplexReconstrTest.SCOPE, IMetamodelAccess.class, ComplexReconstrTestMetamodelAccess.class);
			ServiceRegistry.registerService(org.eclipse.xtext.parsetree.reconstr.IComplexReconstrTest.SCOPE, IAstFactory.class, GenericEcoreElementFactory.class);
			ServiceRegistry.registerService(org.eclipse.xtext.parsetree.reconstr.IComplexReconstrTest.SCOPE, IParser.class, ComplexReconstrTestParser.class);
			ServiceRegistry.registerService(org.eclipse.xtext.parsetree.reconstr.IComplexReconstrTest.SCOPE, IResourceFactory.class, ComplexReconstrTestResourceFactory.class);
			ServiceRegistry.registerService(org.eclipse.xtext.parsetree.reconstr.IComplexReconstrTest.SCOPE, IParseTreeConstructor.class, ComplexReconstrTestParseTreeConstructor.class);
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new ComplexReconstrTestResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("complexreconstrtest", resourceFactory);
			
			
			// initialize EPackages
			
				if (!EPackage.Registry.INSTANCE.containsKey("http://complex/rewrite/test")) {
					EPackage complexrewritetest = EcoreUtil2.loadEPackage(
							"classpath:/org/eclipse/xtext/parsetree/reconstr/complexrewritetest.ecore",
							ComplexReconstrTestStandaloneSetup.class.getClassLoader());
					if (complexrewritetest == null)
						throw new IllegalStateException(
								"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/parsetree/reconstr/complexrewritetest.ecore'");
					EPackage.Registry.INSTANCE.put("http://complex/rewrite/test", complexrewritetest);
				}
			
			isInitialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
		return org.eclipse.xtext.parsetree.reconstr.IComplexReconstrTest.SCOPE;
	}
}
