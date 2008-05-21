package org.eclipse.xtext.dummy;

import org.eclipse.xtext.ILanguageFacade;
import org.eclipse.xtext.resource.AbstractXtextResourceFactory;

public class DummyLanguageResourceFactory extends AbstractXtextResourceFactory {

	private ILanguageFacade facade;

	protected DummyLanguageResourceFactory(ILanguageFacade facade) {
		this.facade = facade;
	}	

	@Override
	protected ILanguageFacade getLanguageFacade() {
		return facade;
	}
	
} 
