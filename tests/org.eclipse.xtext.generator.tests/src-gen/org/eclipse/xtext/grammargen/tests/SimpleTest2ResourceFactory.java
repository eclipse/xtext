package org.eclipse.xtext.grammargen.tests;

import org.eclipse.xtext.ILanguageFacade;
import org.eclipse.xtext.resource.AbstractXtextResourceFactory;

public class SimpleTest2ResourceFactory extends AbstractXtextResourceFactory {

	private ILanguageFacade facade;

	protected SimpleTest2ResourceFactory(ILanguageFacade facade) {
		this.facade = facade;
	}	

	@Override
	protected ILanguageFacade getLanguageFacade() {
		return facade;
	}
	
} 
