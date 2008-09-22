/*
Generated with Xtext
*/
package org.eclipse.xtext.grammarinheritance;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceScopeFactory;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.grammarinheritance.services.ConcreteTestLanguageGrammarAccess;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.grammarinheritance.services.ConcreteTestLanguageMetamodelAccess;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.GenericEcoreElementFactory;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.grammarinheritance.parser.ConcreteTestLanguageParser;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.grammarinheritance.services.ConcreteTestLanguageResourceFactory;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor;
import org.eclipse.xtext.grammarinheritance.parsetree.reconstr.ConcreteTestLanguageParseTreeConstructor;

import org.eclipse.xtext.grammarinheritance.IConcreteTestLanguage;

public abstract class ConcreteTestLanguageStandaloneSetup {

	private static boolean isInitialized = false;

	public synchronized static void doSetup() {
		if(!isInitialized) {
			
			// setup super language first
			org.eclipse.xtext.grammarinheritance.AbstractTestLanguageStandaloneSetup.doSetup();
			
			ServiceRegistry.registerService(org.eclipse.xtext.grammarinheritance.IConcreteTestLanguage.SCOPE, IGrammarAccess.class, ConcreteTestLanguageGrammarAccess.class);
			ServiceRegistry.registerService(org.eclipse.xtext.grammarinheritance.IConcreteTestLanguage.SCOPE, IMetamodelAccess.class, ConcreteTestLanguageMetamodelAccess.class);
			ServiceRegistry.registerService(org.eclipse.xtext.grammarinheritance.IConcreteTestLanguage.SCOPE, IAstFactory.class, GenericEcoreElementFactory.class);
			ServiceRegistry.registerService(org.eclipse.xtext.grammarinheritance.IConcreteTestLanguage.SCOPE, IParser.class, ConcreteTestLanguageParser.class);
			ServiceRegistry.registerService(org.eclipse.xtext.grammarinheritance.IConcreteTestLanguage.SCOPE, IResourceFactory.class, ConcreteTestLanguageResourceFactory.class);
			ServiceRegistry.registerService(org.eclipse.xtext.grammarinheritance.IConcreteTestLanguage.SCOPE, IParseTreeConstructor.class, ConcreteTestLanguageParseTreeConstructor.class);
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new ConcreteTestLanguageResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("concretetestlanguage", resourceFactory);
			
			
			// initialize EPackages
			
				if (!EPackage.Registry.INSTANCE.containsKey("http://holla")) {
					EPackage foo = EcoreUtil2.loadEPackage(
							"classpath:/org/eclipse/xtext/grammarinheritance/foo.ecore",
							ConcreteTestLanguageStandaloneSetup.class.getClassLoader());
					if (foo == null)
						throw new IllegalStateException(
								"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/grammarinheritance/foo.ecore'");
					EPackage.Registry.INSTANCE.put("http://holla", foo);
				}
			
			isInitialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
		return org.eclipse.xtext.grammarinheritance.IConcreteTestLanguage.SCOPE;
	}
}
