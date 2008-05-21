package org.eclipse.xtext.metamodelreferencing.tests;

import org.eclipse.xtext.ILanguageFacade;
import org.eclipse.xtext.resource.AbstractXtextResourceFactory;

public class MetamodelRefTestResourceFactory extends AbstractXtextResourceFactory {

	private ILanguageFacade facade;

	protected MetamodelRefTestResourceFactory(ILanguageFacade facade) {
		this.facade = facade;
	}	

	@Override
	protected ILanguageFacade getLanguageFacade() {
		return facade;
	}
	
} 
