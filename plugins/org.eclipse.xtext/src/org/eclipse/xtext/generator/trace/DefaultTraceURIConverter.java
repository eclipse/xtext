/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.XtextResource;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class DefaultTraceURIConverter implements ITraceURIConverter {

	public URI getURIForTrace(XtextResource context) {
		URI uri = context.getURI();
		return getURIForTrace(uri);
	}

	public URI getURIForTrace(URI uri) {
		if (uri.isPlatform()) {
			// create a URI that is relative to the contained projects sourcefolder.
			List<String> segments = uri.segmentsList().subList(3, uri.segmentCount());
			return URI.createHierarchicalURI(segments.toArray(new String[segments.size()]), null, null);
		}
		return uri.trimFragment().trimQuery();
	}

	// this method is used by subclasses
	protected boolean isPrefix(URI prefix, URI uri) {
		if (prefix.scheme() == null || !prefix.scheme().equals(uri.scheme()))
			return false;
		String[] prefixSeg = prefix.segments();
		String[] uriSeg = uri.segments();
		if (prefixSeg.length == 0 || uriSeg.length == 0)
			return false;
		if (!"".equals(prefixSeg[prefixSeg.length - 1])) // this is true when the URI has a trailing slash ("/").
			return false;
		if (uriSeg.length < prefixSeg.length - 1)
			return false;
		for (int i = 0; i < prefixSeg.length - 1; i++)
			if (!uriSeg[i].equals(prefixSeg[i]))
				return false;
		return true;
	}
}
