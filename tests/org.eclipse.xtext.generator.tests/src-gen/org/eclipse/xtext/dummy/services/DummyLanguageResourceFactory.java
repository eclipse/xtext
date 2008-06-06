/*
Generated using Xtext at Fri Jun 06 17:58:57 CEST 2008
*/
package org.eclipse.xtext.dummy.services;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.AbstractXtextResourceFactory;

public class DummyLanguageResourceFactory extends AbstractXtextResourceFactory {

	public DummyLanguageResourceFactory() {
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("dummylanguage", this);
		
	}
	
	public String[] getModelFileExtensions() {
		return new String[] { "dummylanguage" };
	}
	
} 
