/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;

/**
 * This URI handler implements a heuristic approach to work around
 * a mismatch with platform URIs in the dev workspace and the deployed variant.
 * Also deals with illegally resolved classpath URIs.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 * @since 2.4
 */
public class XtextPlatformResourceURIHandler extends URIHandlerImpl {
	
	@Override
	public URI resolve(URI uri) {
		if (resolve && uri.isRelative() && uri.hasRelativePath()) {
			URI result = uri.resolve(baseURI);
			if (baseURI.isPlatform()) {
				if (result.isPlatform() && !(result.isPlatformPlugin() || result.isPlatformResource())) {
					String[] segments = getRelevantPlatformSegments(result);
					URI newResult = baseURI.trimSegments(baseURI.segmentCount() - 1).appendSegments(segments);
					newResult = newResult.appendFragment(result.fragment());
					return newResult;
				}
			} else if (ClasspathUriUtil.isClasspathUri(baseURI)) {
				if (ClasspathUriUtil.isClasspathUri(result) && "..".equals(result.segment(0))) {
					String[] segments = getRelevantClasspathSegments(result);
					URI newResult = URI.createHierarchicalURI(result.scheme(), result.authority(), result.device(), segments, result.query(), result.fragment());
					return newResult;
				}			
			}
			return result;
		}
		return uri;
	}
	
	protected String[] getRelevantClasspathSegments(URI uri) {
		List<String> resultSegments = uri.segmentsList();
		for(int i = 0, size = resultSegments.size(); i < size; i++) {
			if (!"..".equals(resultSegments.get(i))) {
				if (i != 0) {
					int skip = i * 2;
					String[] segments = new String[size - skip];
					for(int j = skip, k = 0; j < size; j++, k++) {
						segments[k] = resultSegments.get(j);
					}
					return segments; 
				} else {
					String[] segments = uri.segments();
					return segments;
				}
			}
		}
		return uri.segments();
	}

	protected String[] getRelevantPlatformSegments(URI uri) {
		List<String> resultSegments = uri.segmentsList();
		for(int i = 0, size = resultSegments.size(); i < size; i++) {
			if (!"..".equals(resultSegments.get(i))) {
				if (i != 0) {
					String[] segments = new String[size - i];
					for(int j = i, k = 0; j < size; j++, k++) {
						segments[k] = resultSegments.get(j);
					}
					return segments; 
				} else {
					String[] segments = uri.segments();
					return segments;
				}
			}
		}
		return uri.segments();
	}
	
}
