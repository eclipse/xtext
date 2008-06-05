package org.eclipse.xtext.metamodelreferencing.tests.services;
import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.xtext.resource.AbstractXtextResourceFactory;

public class MetamodelRefTestResourceFactory extends AbstractXtextResourceFactory {

	public MetamodelRefTestResourceFactory() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("metamodelreftest", this);
	}
	
	public String getModelFileExtension() {
		return "metamodelreftest";
	}
	
} 
