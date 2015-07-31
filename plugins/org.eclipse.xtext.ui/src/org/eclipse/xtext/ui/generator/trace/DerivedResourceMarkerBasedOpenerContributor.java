/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.generator.trace;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.ui.generator.IDerivedResourceMarkers;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.Pair;

import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class DerivedResourceMarkerBasedOpenerContributor extends OppositeFileOpenerContributor {

	private final static Logger LOG = Logger.getLogger(DerivedResourceMarkerBasedOpenerContributor.class);

	@Inject
	private IDerivedResourceMarkers derivedResourceMarkers;

	@Inject
	private IStorage2UriMapper storage2UriMapper;

	@Override
	public boolean collectGeneratedFileOpeners(IEditorPart editor, IAcceptor<FileOpener> acceptor) {
		IStorage storage = getStorage(editor);
		if (storage != null) {
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			URI uri = URI.createPlatformResourceURI(storage.getFullPath().toString(), true);
			try {
				List<IFile> resources = derivedResourceMarkers.findDerivedResources(root, uri.toString());
				for (IFile file : resources)
					acceptor.accept(createOpener(file));
				return true;
			} catch (CoreException e) {
				LOG.error(e.getMessage(), e);
			}
		}
		return false;
	}

	@Override
	public boolean collectSourceFileOpeners(IEditorPart editor, IAcceptor<FileOpener> acceptor) {
		IStorage storage = getStorage(editor);
		if (storage instanceof IResource) {
			IResource resource = (IResource) storage;
			try {
				Set<URI> uris = Sets.newHashSet();
				IMarker[] markers = derivedResourceMarkers.findDerivedResourceMarkers(resource);
				for (IMarker marker : markers) {
					String source = derivedResourceMarkers.getSource(marker);
					if (source != null)
						uris.add(URI.createURI(source));
				}
				for (URI uri : uris)
					for (Pair<IStorage, IProject> destination : storage2UriMapper.getStorages(uri))
						acceptor.accept(createOpener(destination.getFirst()));
				return true;
			} catch (CoreException e) {
				LOG.error(e.getMessage(), e);
			}
		}
		return false;
	}

}
