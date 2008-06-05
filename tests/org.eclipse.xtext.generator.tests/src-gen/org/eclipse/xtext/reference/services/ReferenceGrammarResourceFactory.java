package org.eclipse.xtext.reference.services;
import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.xtext.resource.AbstractXtextResourceFactory;

public class ReferenceGrammarResourceFactory extends AbstractXtextResourceFactory {

	public ReferenceGrammarResourceFactory() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("referencegrammar", this);
	}
	
	public String getModelFileExtension() {
		return "referencegrammar";
	}
	
} 
