package org.eclipse.xtext.lexer;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public abstract class LexerLanguageStandaloneSetup {

	public static void doSetup() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xmi", new XMIResourceFactoryImpl());
		
		//TODO org.eclipse.xtext.impl.GeneratedMetamodelImpl@991da9 (alias: null) (nsURI: "http://www.eclipse.org/2008/xtext/LexerLang", name: TestLang)
		
	}

}
