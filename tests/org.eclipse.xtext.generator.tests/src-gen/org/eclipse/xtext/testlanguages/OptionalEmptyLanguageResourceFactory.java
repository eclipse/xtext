package org.eclipse.xtext.testlanguages;

import org.eclipse.xtext.ILanguageFacade;
import org.eclipse.xtext.resource.AbstractXtextResourceFactory;

public class OptionalEmptyLanguageResourceFactory extends AbstractXtextResourceFactory {

	private ILanguageFacade facade;

	protected OptionalEmptyLanguageResourceFactory(ILanguageFacade facade) {
		this.facade = facade;
	}	

	@Override
	protected ILanguageFacade getLanguageFacade() {
		return facade;
	}
	
} 
