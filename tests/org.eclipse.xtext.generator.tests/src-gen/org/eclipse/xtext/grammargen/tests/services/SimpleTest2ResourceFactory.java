/*
Generated with Xtext
*/
package org.eclipse.xtext.grammargen.tests.services;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.AbstractXtextResourceFactory;

public class SimpleTest2ResourceFactory extends AbstractXtextResourceFactory {

	public SimpleTest2ResourceFactory() {
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("simpletest2", this);
		
	}
	
	public String[] getModelFileExtensions() {
		return new String[] { "simpletest2" };
	}
	
} 
