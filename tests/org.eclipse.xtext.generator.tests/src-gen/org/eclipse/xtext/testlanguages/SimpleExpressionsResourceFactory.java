package org.eclipse.xtext.testlanguages;

import org.eclipse.xtext.ILanguageFacade;
import org.eclipse.xtext.resource.AbstractXtextResourceFactory;

public class SimpleExpressionsResourceFactory extends AbstractXtextResourceFactory {

	private ILanguageFacade facade;

	protected SimpleExpressionsResourceFactory(ILanguageFacade facade) {
		this.facade = facade;
	}	

	@Override
	protected ILanguageFacade getLanguageFacade() {
		return facade;
	}
	
} 
