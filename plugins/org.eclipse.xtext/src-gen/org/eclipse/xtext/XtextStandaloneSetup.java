package org.eclipse.xtext;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public abstract class XtextStandaloneSetup {

	public static void doSetup() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xmi", new XMIResourceFactoryImpl());
		
		//TODO org.eclipse.xtext.impl.GeneratedMetamodelImpl@952be0 (alias: null) (name: xtext, nsURI: "http://www.eclipse.org/2008/Xtext")
		
	}

}
