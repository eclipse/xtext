package org.eclipse.xtext.testlanguages;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.LanguageFacadeFactory;
import org.eclipse.xtext.ILanguageFacade;

public abstract class SimpleExpressionsStandaloneSetup {

	public static void doSetup() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xmi", new XMIResourceFactoryImpl());
		if (LanguageFacadeFactory.getFacade("org/eclipse/xtext/testlanguages/SimpleExpressions")==null) {
			ILanguageFacade facade = new SimpleExpressionsLanguageFacade();
			LanguageFacadeFactory.register(facade);
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"simpleexpressions", facade.getResourceFactory());
		}
	}

}
