/*
Generated using Xtext at Sun Jun 08 11:15:28 CEST 2008
*/
package org.eclipse.xtext.reference.services;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.AbstractXtextResourceFactory;

public class ReferenceGrammarResourceFactory extends AbstractXtextResourceFactory {

	public ReferenceGrammarResourceFactory() {
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("referencegrammar", this);
		
	}
	
	public String[] getModelFileExtensions() {
		return new String[] { "referencegrammar" };
	}
	
} 
