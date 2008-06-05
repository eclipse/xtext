package org.eclipse.xtext.parsetree.reconstr.services;
import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.xtext.resource.AbstractXtextResourceFactory;

public class ComplexReconstrTestResourceFactory extends AbstractXtextResourceFactory {

	public ComplexReconstrTestResourceFactory() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("complexreconstrtest", this);
	}
	
	public String getModelFileExtension() {
		return "complexreconstrtest";
	}
	
} 
