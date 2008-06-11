/*
Generated with Xtext
*/
package org.eclipse.xtext.services;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.AbstractXtextResourceFactory;

public class XtextResourceFactory extends AbstractXtextResourceFactory {

	public XtextResourceFactory() {
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xtext", this);
		
	}
	
	public String[] getModelFileExtensions() {
		return new String[] { "xtext" };
	}
	
} 
