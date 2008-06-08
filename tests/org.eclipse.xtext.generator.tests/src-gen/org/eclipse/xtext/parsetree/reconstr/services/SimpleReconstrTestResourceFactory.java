/*
Generated using Xtext at Sun Jun 08 11:15:26 CEST 2008
*/
package org.eclipse.xtext.parsetree.reconstr.services;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.AbstractXtextResourceFactory;

public class SimpleReconstrTestResourceFactory extends AbstractXtextResourceFactory {

	public SimpleReconstrTestResourceFactory() {
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("simplereconstrtest", this);
		
	}
	
	public String[] getModelFileExtensions() {
		return new String[] { "simplereconstrtest" };
	}
	
} 
