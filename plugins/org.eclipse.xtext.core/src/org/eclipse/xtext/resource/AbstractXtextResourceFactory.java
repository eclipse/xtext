package org.eclipse.xtext.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ILanguageFacade;

public abstract class AbstractXtextResourceFactory implements Resource.Factory {

	public Resource createResource(URI uri) {
		ILanguageFacade facade = getLanguageFacade();
		XtextResource xtextResource = new XtextResource(facade, uri);
		return xtextResource;
	}

	protected abstract ILanguageFacade getLanguageFacade();

}
