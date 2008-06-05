package org.eclipse.xtext.testlanguages.services;
import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.xtext.resource.AbstractXtextResourceFactory;

public class OptionalEmptyLanguageResourceFactory extends AbstractXtextResourceFactory {

	public OptionalEmptyLanguageResourceFactory() {
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("optionalemptylanguage", this);
		
	}
	
	public String[] getModelFileExtensions() {
		return new String[] { "optionalemptylanguage" };
	}
	
} 
