package org.eclipse.xtext.services;

import org.eclipse.xtext.resource.AbstractXtextResourceFactory;

public class XtextResourceFactory extends AbstractXtextResourceFactory {

	public String[] getModelFileExtensions() {
		return new String[]{"xtext"};
	}
	
} 
