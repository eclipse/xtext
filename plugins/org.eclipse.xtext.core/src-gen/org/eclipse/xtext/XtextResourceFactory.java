package org.eclipse.xtext;

import org.eclipse.xtext.resource.AbstractXtextResourceFactory;

public class XtextResourceFactory extends AbstractXtextResourceFactory {

	private ILanguageFacade facade = new XtextLanguageFacade();

	@Override
	protected ILanguageFacade getLanguageFacade() {
		return facade;
	}
	
} 
