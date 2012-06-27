package org.eclipse.xpect.lib;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;

public interface IXpectURIProvider {

	Collection<URI> getAllURIs();

	URI resolveURI(URI base, String newURI);

	String getTitle(URI uri);
}
