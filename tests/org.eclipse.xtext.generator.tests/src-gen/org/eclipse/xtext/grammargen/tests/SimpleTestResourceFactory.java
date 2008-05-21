package org.eclipse.xtext.grammargen.tests;

import org.eclipse.xtext.ILanguageFacade;
import org.eclipse.xtext.resource.AbstractXtextResourceFactory;

public class SimpleTestResourceFactory extends AbstractXtextResourceFactory {

	private ILanguageFacade facade;

	protected SimpleTestResourceFactory(ILanguageFacade facade) {
		this.facade = facade;
	}	

	@Override
	protected ILanguageFacade getLanguageFacade() {
		return facade;
	}
	
} 
