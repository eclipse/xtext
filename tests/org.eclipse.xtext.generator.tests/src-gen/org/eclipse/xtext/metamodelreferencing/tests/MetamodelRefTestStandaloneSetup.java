package org.eclipse.xtext.metamodelreferencing.tests;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.LanguageFacadeFactory;

public abstract class MetamodelRefTestStandaloneSetup {

	public static void doSetup() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xmi", new XMIResourceFactoryImpl());
		if (LanguageFacadeFactory.getFacade("org/eclipse/xtext/metamodelreferencing/tests/MetamodelRefTest")==null)
			LanguageFacadeFactory.register("org/eclipse/xtext/metamodelreferencing/tests/MetamodelRefTest",new MetamodelRefTestLanguageFacade());
	}

}
