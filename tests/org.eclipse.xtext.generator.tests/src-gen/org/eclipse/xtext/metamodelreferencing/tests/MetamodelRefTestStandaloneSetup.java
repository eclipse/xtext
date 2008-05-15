package org.eclipse.xtext.metamodelreferencing.tests;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public abstract class MetamodelRefTestStandaloneSetup {

	public static void doSetup() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xmi", new XMIResourceFactoryImpl());
		
		//TODO org.eclipse.xtext.impl.ReferencedMetamodelImpl@885e10 (alias: xtext) (uri: "http://www.eclipse.org/2008/Xtext")
		
		//TODO org.eclipse.xtext.impl.GeneratedMetamodelImpl@d79cec (alias: null) (nsURI: "http://eclipse.org/xtext/tests/SimpleTest", name: SimpleTest)
		
	}

}
