package org.eclipse.xtext.builder.impl.javasupport;

import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJarEntryResource;
import org.eclipse.xtext.builder.impl.ResourceProvider;

import com.google.inject.Inject;

public class JdtResourceProvider extends ResourceProvider {
	
	@Inject
	private JdtUriUtil uriUtil;
	
	@Override
	public URI getURI(IStorage resource) {
		if (resource instanceof IJarEntryResource) {
			return uriUtil.getURI((IJarEntryResource)resource);
		}
		return super.getURI(resource);
	}
}
