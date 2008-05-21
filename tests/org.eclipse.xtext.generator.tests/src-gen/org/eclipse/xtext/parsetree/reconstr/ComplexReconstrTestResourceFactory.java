package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.xtext.ILanguageFacade;
import org.eclipse.xtext.resource.AbstractXtextResourceFactory;

public class ComplexReconstrTestResourceFactory extends AbstractXtextResourceFactory {

	private ILanguageFacade facade;

	protected ComplexReconstrTestResourceFactory(ILanguageFacade facade) {
		this.facade = facade;
	}	

	@Override
	protected ILanguageFacade getLanguageFacade() {
		return facade;
	}
	
} 
