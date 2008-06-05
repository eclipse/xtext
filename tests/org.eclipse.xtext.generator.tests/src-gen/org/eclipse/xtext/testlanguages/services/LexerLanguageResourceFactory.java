package org.eclipse.xtext.testlanguages.services;
import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.xtext.resource.AbstractXtextResourceFactory;

public class LexerLanguageResourceFactory extends AbstractXtextResourceFactory {

	public LexerLanguageResourceFactory() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("lexerlanguage", this);
	}
	
	public String getModelFileExtension() {
		return "lexerlanguage";
	}
	
} 
