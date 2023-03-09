/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.resource;

import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.persistence.ResourceStorageFacade;
import org.eclipse.xtext.resource.persistence.ResourceStorageLoadable;
import org.eclipse.xtext.resource.persistence.ResourceStorageWritable;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.IProjectConfigProvider;
import org.eclipse.xtext.workspace.ISourceFolder;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class BatchLinkableResourceStorageFacade extends ResourceStorageFacade {
	@Inject
	private IProjectConfigProvider projectConfigProvider;

	@Override
	public ResourceStorageLoadable createResourceStorageLoadable(InputStream in) {
		return new BatchLinkableResourceStorageLoadable(in, isStoreNodeModel());
	}

	@Override
	public ResourceStorageWritable createResourceStorageWritable(OutputStream out) {
		return new BatchLinkableResourceStorageWritable(out, isStoreNodeModel());
	}

	@Override
	protected URI getSourceContainerURI(StorageAwareResource resource) {
		URI uri = resource.getURI();
		IProjectConfig mainProject = projectConfigProvider.getProjectConfig(resource.getResourceSet());
		if (mainProject != null) {
			IProjectConfig project = mainProject.getWorkspaceConfig().findProjectContaining(uri);
			if (project != null) {
				ISourceFolder sourceFolder = project.findSourceFolderContaining(uri);
				if (sourceFolder != null) {
					return sourceFolder.getPath();
				}
			}
		}
		return super.getSourceContainerURI(resource);
	}
}
