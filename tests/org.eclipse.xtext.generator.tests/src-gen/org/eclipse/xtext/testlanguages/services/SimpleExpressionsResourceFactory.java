package org.eclipse.xtext.testlanguages.services;
import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.xtext.resource.AbstractXtextResourceFactory;

public class SimpleExpressionsResourceFactory extends AbstractXtextResourceFactory {

	public SimpleExpressionsResourceFactory() {
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("simpleexpressions", this);
		
	}
	
	public String[] getModelFileExtensions() {
		return new String[] { "simpleexpressions" };
	}
	
} 
