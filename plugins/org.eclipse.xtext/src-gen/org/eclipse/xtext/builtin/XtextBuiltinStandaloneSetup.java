/*
Generated with Xtext
*/
package org.eclipse.xtext.builtin;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;

import com.google.inject.Guice;
import com.google.inject.Injector;

import org.eclipse.xtext.builtin.IXtextBuiltin;

public abstract class XtextBuiltinStandaloneSetup {

	private static boolean isInitialized = false;

	public synchronized static void doSetup() {
		if(!isInitialized) {
		    
			
			// register default ePackages
			if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("ecore"))
				Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
					"ecore", new org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl());
			if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("xmi"))
				Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
					"xmi", new org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl());
			if (!EPackage.Registry.INSTANCE.containsKey(org.eclipse.xtext.XtextPackage.eNS_URI))
				EPackage.Registry.INSTANCE.put(org.eclipse.xtext.XtextPackage.eNS_URI, org.eclipse.xtext.XtextPackage.eINSTANCE);
			
			
			
			// initialize EPackages
			
			isInitialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
	   doSetup();
	   return org.eclipse.xtext.builtin.IXtextBuiltin.SCOPE;
	}
	
}
