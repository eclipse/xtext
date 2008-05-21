package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.LanguageFacadeFactory;
import org.eclipse.xtext.ILanguageFacade;

public abstract class ComplexReconstrTestStandaloneSetup {

	public static void doSetup() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xmi", new XMIResourceFactoryImpl());
		if (LanguageFacadeFactory.getFacade("org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest")==null) {
			ILanguageFacade facade = new ComplexReconstrTestLanguageFacade();
			LanguageFacadeFactory.register(facade);
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"complexreconstrtest", facade.getResourceFactory());
		}
	}

}
