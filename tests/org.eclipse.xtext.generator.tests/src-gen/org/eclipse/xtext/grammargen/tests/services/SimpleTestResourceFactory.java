/*
Generated using Xtext at Fri Jun 06 17:58:53 CEST 2008
*/
package org.eclipse.xtext.grammargen.tests.services;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.AbstractXtextResourceFactory;

public class SimpleTestResourceFactory extends AbstractXtextResourceFactory {

	public SimpleTestResourceFactory() {
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("simpletest", this);
		
	}
	
	public String[] getModelFileExtensions() {
		return new String[] { "simpletest" };
	}
	
} 
