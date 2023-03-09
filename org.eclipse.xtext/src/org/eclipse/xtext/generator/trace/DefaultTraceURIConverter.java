/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.IProjectConfigProvider;

import com.google.inject.Inject;

/**
 * Default implementation of the {@link ITraceURIConverter} that is based on the
 * workspace data (see {@link IProjectConfigProvider}).
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class DefaultTraceURIConverter implements ITraceURIConverter {
	
	@Inject(optional = true) 
	private IProjectConfigProvider configProvider;

	@Override
	public SourceRelativeURI getURIForTrace(IProjectConfig projectConfig, AbsoluteURI absoluteURI) {
		SourceRelativeURI result = absoluteURI.deresolve(projectConfig);
		if (result == null) {
			return getURIForTrace(absoluteURI.getURI());
		}
		return result;
	}

	@Override
	public SourceRelativeURI getURIForTrace(Resource resource) {
		if (configProvider != null) {
			IProjectConfig projectConfig = configProvider.getProjectConfig(resource.getResourceSet());
			if (projectConfig != null) {
				return getURIForTrace(projectConfig, new AbsoluteURI(resource.getURI()));
			}
		}
		// tests and in-memory resources often use relative uris, e.g. __synthetic.mydsl
		URI uri = resource.getURI();
		if (uri.isRelative()) {
			return new SourceRelativeURI(uri);
		}
		return getURIForTrace(uri);
	}

	private SourceRelativeURI getURIForTrace(URI qualifiedURI) {
		if (qualifiedURI.isPlatform()) {
			// create a URI that is relative to the containing project or bundle
			List<String> segments = qualifiedURI.segmentsList().subList(2, qualifiedURI.segmentCount());
			return new SourceRelativeURI(URI.createHierarchicalURI(segments.toArray(new String[segments.size()]), null, null));
		}
		return SourceRelativeURI.fromAbsolute(qualifiedURI);
	}
}
