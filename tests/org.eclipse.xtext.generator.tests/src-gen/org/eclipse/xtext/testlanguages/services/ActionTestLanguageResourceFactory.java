package org.eclipse.xtext.testlanguages.services;
import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.xtext.resource.AbstractXtextResourceFactory;

public class ActionTestLanguageResourceFactory extends AbstractXtextResourceFactory {

	public ActionTestLanguageResourceFactory() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("actiontestlanguage", this);
	}
	
	public String getModelFileExtension() {
		return "actiontestlanguage";
	}
	
} 
