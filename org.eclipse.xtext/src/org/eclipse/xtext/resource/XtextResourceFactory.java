package org.eclipse.xtext.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class XtextResourceFactory implements IResourceFactory {

	private Provider<XtextResource> provider;

	@Inject
	public XtextResourceFactory(Provider<XtextResource> resourceProvider) {
		this.provider = resourceProvider;
	}
	
	@Override
	public Resource createResource(URI uri) {
		XtextResource xtextResource = provider.get();
		xtextResource.setURI(uri);
		return xtextResource;
	}

}
