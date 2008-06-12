/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.services;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.AbstractXtextResourceFactory;

public class LookaheadLangResourceFactory extends AbstractXtextResourceFactory {

	public LookaheadLangResourceFactory() {
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("lookaheadlanguage", this);
		
	}
	
	public String[] getModelFileExtensions() {
		return new String[] { "lookaheadlanguage" };
	}
	
} 
