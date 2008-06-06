/*
Generated using Xtext at Fri Jun 06 17:58:57 CEST 2008
*/
package org.eclipse.xtext.metamodelreferencing.tests.services;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.AbstractXtextResourceFactory;

public class MetamodelRefTestResourceFactory extends AbstractXtextResourceFactory {

	public MetamodelRefTestResourceFactory() {
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("metamodelreftest", this);
		
	}
	
	public String[] getModelFileExtensions() {
		return new String[] { "metamodelreftest" };
	}
	
} 
