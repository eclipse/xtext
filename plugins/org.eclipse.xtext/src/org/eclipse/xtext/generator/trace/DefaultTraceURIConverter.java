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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.ISourceFolder;
import org.eclipse.xtext.workspace.IWorkspaceConfig;
import org.eclipse.xtext.workspace.IWorkspaceConfigProvider;

import com.google.inject.Inject;

public class DefaultTraceURIConverter implements ITraceURIConverter {
	
	@Inject(optional = true) 
	private IWorkspaceConfigProvider configProvider;

	@Override
	public URI getURIForTrace(IProjectConfig projectConfig, URI qualifiedUri) {
		ISourceFolder sourceFolder = projectConfig.findSourceFolderContaining(qualifiedUri);
		if (sourceFolder != null) {
			return qualifiedUri.deresolve(sourceFolder.getPath());
		}
		return getUriForTrace(qualifiedUri);
	}

	@Override
	public URI getURIForTrace(Resource resource) {
		if (configProvider != null) {
			IWorkspaceConfig workspaceConfig = configProvider.getWorkspaceConfig(resource.getResourceSet());
			IProjectConfig projectConfig = workspaceConfig.findProjectContaining(resource.getURI());
			if (projectConfig != null) {
				return getURIForTrace(projectConfig, resource.getURI());
			}
		}
		return getUriForTrace(resource.getURI());
	}

	private URI getUriForTrace(URI qualifiedUri) {
		if (qualifiedUri.isPlatform()) {
			// create a URI that is relative to the contained projects.
			List<String> segments = qualifiedUri.segmentsList().subList(2, qualifiedUri.segmentCount());
			return URI.createHierarchicalURI(segments.toArray(new String[segments.size()]), null, null);
		}
		return qualifiedUri.trimFragment().trimQuery();
	}
}
