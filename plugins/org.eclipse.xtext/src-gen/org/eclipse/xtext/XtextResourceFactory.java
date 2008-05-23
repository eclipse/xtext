package org.eclipse.xtext;

import org.eclipse.xtext.ILanguageFacade;
import org.eclipse.xtext.resource.AbstractXtextResourceFactory;

public class XtextResourceFactory extends AbstractXtextResourceFactory {

	private ILanguageFacade facade;

	protected XtextResourceFactory(ILanguageFacade facade) {
		this.facade = facade;
	}	

	@Override
	protected ILanguageFacade getLanguageFacade() {
		return facade;
	}
	
} 
