package org.eclipse.xtext.test;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public abstract class TestLanguageStandaloneSetup {

	public static void doSetup() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xmi", new XMIResourceFactoryImpl());
		
		//TODO org.eclipse.xtext.impl.GeneratedMetamodelImpl@e2c0b5 (alias: null) (nsURI: "http://www.eclipse.org/2008/xtext/TestLang", name: TestLang)
		
	}

}
