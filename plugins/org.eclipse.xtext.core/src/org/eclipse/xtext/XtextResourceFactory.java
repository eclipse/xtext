package org.eclipse.xtext;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

public class XtextResourceFactory implements Resource.Factory {

	public Resource createResource(URI uri) {
		ILanguageFacade facade = LanguageFacadeFactory.getFacade(getLanguageID(uri));
		if(facade != null) {
			XtextResource xtextResource = new XtextResource(facade, uri);
			return xtextResource;
		}
		throw new IllegalArgumentException("Cannot find language facade for " + uri.toString());
	}
	
	private String getLanguageID(URI uri) {
		return uri.fileExtension();
	}

}
