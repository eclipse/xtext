package org.eclipse.xtext.testlanguages;

import org.eclipse.xtext.ILanguageFacade;
import org.eclipse.xtext.resource.AbstractXtextResourceFactory;

public class ActionTestLanguageResourceFactory extends AbstractXtextResourceFactory {

	private ILanguageFacade facade;

	protected ActionTestLanguageResourceFactory(ILanguageFacade facade) {
		this.facade = facade;
	}	

	@Override
	protected ILanguageFacade getLanguageFacade() {
		return facade;
	}
	
} 
