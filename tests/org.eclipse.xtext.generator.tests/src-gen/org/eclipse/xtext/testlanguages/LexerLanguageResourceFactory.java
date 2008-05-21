package org.eclipse.xtext.testlanguages;

import org.eclipse.xtext.ILanguageFacade;
import org.eclipse.xtext.resource.AbstractXtextResourceFactory;

public class LexerLanguageResourceFactory extends AbstractXtextResourceFactory {

	private ILanguageFacade facade;

	protected LexerLanguageResourceFactory(ILanguageFacade facade) {
		this.facade = facade;
	}	

	@Override
	protected ILanguageFacade getLanguageFacade() {
		return facade;
	}
	
} 
