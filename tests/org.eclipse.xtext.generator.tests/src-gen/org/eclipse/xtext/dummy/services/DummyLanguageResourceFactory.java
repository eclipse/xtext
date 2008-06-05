package org.eclipse.xtext.dummy.services;
import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.xtext.resource.AbstractXtextResourceFactory;

public class DummyLanguageResourceFactory extends AbstractXtextResourceFactory {

	public DummyLanguageResourceFactory() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("dummylanguage", this);
	}
	
	public String getModelFileExtension() {
		return "dummylanguage";
	}
	
} 
