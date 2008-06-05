package org.eclipse.xtext.testlanguages.services;
import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.xtext.resource.AbstractXtextResourceFactory;

public class TestLanguageResourceFactory extends AbstractXtextResourceFactory {

	public TestLanguageResourceFactory() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("testlanguage", this);
	}
	
	public String getModelFileExtension() {
		return "testlanguage";
	}
	
} 
