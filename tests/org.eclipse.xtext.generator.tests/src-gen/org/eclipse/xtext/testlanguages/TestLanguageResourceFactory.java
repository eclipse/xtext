package org.eclipse.xtext.testlanguages;

import org.eclipse.xtext.ILanguageFacade;
import org.eclipse.xtext.resource.AbstractXtextResourceFactory;

public class TestLanguageResourceFactory extends AbstractXtextResourceFactory {

	private ILanguageFacade facade;

	protected TestLanguageResourceFactory(ILanguageFacade facade) {
		this.facade = facade;
	}	

	@Override
	protected ILanguageFacade getLanguageFacade() {
		return facade;
	}
	
} 
