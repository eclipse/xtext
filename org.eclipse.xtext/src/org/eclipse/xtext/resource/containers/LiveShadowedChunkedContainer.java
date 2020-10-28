/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource.containers;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Iterables.size;

import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions;
import org.eclipse.xtext.resource.impl.LiveShadowedChunkedResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.common.annotations.Beta;

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.14
 */
@Beta
public class LiveShadowedChunkedContainer implements IContainer {
	private final LiveShadowedChunkedResourceDescriptions descriptions;

	private final String containerName;

	private IProjectConfig projectConfig;

	private boolean isProjectConfigSet = false;

	public LiveShadowedChunkedContainer(LiveShadowedChunkedResourceDescriptions descriptions, String containerName) {
		this.descriptions = descriptions;
		this.containerName = containerName;
	}

	protected ChunkedResourceDescriptions getChunkedResourceDescriptions() {
		return (ChunkedResourceDescriptions) descriptions.getGlobalDescriptions();
	}

	protected IProjectConfig getProjectConfig() {
		if (!isProjectConfigSet) {
			projectConfig = descriptions.getWorkspaceConfig() == null ? null
					: descriptions.getWorkspaceConfig().findProjectByName(containerName);
			isProjectConfigSet = true;
		}
		return projectConfig;
	}

	protected ResourceDescriptionsData getChunk() {
		ResourceDescriptionsData container = getChunkedResourceDescriptions().getContainer(containerName);
		if (container != null)
			return container;
		return new ResourceDescriptionsData(Collections.emptyList());
	}

	protected Iterable<IResourceDescription> getContainedLocalDescriptions() {
		return filter(descriptions.getLocalDescriptions().getAllResourceDescriptions(), it -> isContained(it.getURI()));
	}

	protected boolean isContained(URI uri) {
		return (getChunk().getResourceDescription(uri) != null)
				|| (getProjectConfig() != null && getProjectConfig().findSourceFolderContaining(uri) != null);
	}

	@Override
	public IResourceDescription getResourceDescription(URI uri) {
		return isContained(uri) ? descriptions.getResourceDescription(uri) : null;
	}

	@Override
	public int getResourceDescriptionCount() {
		return size(getResourceDescriptions());
	}

	@Override
	public Iterable<IResourceDescription> getResourceDescriptions() {
		Set<URI> localURIs = getExistingOrRenamedResourceURIs();
		return concat(getContainedLocalDescriptions(),
				filter(getChunk().getAllResourceDescriptions(), it -> !localURIs.contains(it.getURI())));
	}

	@Override
	public boolean hasResourceDescription(URI uri) {
		return getChunk().getResourceDescription(uri) != null;
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjects() {
		Set<URI> localURIs = getExistingOrRenamedResourceURIs();
		return concat(concat(transform(getContainedLocalDescriptions(), it -> it.getExportedObjects())),
				filter(getChunk().getExportedObjects(), it -> !localURIs.contains(it.getEObjectURI().trimFragment())));
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjects(EClass type, QualifiedName name, boolean ignoreCase) {
		Set<URI> localURIs = getExistingOrRenamedResourceURIs();
		return concat(concat(transform(getContainedLocalDescriptions(), it -> it.getExportedObjects(type, name, ignoreCase))),
				filter(getChunk().getExportedObjects(type, name, ignoreCase),
						it -> !localURIs.contains(it.getEObjectURI().trimFragment())));
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByObject(final EObject object) {
		Set<URI> localURIs = getExistingOrRenamedResourceURIs();
		return concat(concat(transform(getContainedLocalDescriptions(), it -> it.getExportedObjectsByObject(object))),
				filter(getChunk().getExportedObjectsByObject(object),
						it -> !localURIs.contains(it.getEObjectURI().trimFragment())));
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByType(EClass type) {
		Set<URI> localURIs = getExistingOrRenamedResourceURIs();
		return concat(concat(transform(getContainedLocalDescriptions(), it -> it.getExportedObjectsByType(type))),
				filter(getChunk().getExportedObjectsByType(type),
						it -> !localURIs.contains(it.getEObjectURI().trimFragment())));
	}

	@Override
	public boolean isEmpty() {
		return IterableExtensions.isEmpty(getContainedLocalDescriptions()) && getChunk().isEmpty();
	}

	protected Set<URI> getExistingOrRenamedResourceURIs() {
		ResourceSet resourceSet = descriptions.getResourceSet();
		if (resourceSet instanceof ResourceSetImpl)
			return ((ResourceSetImpl) resourceSet).getURIResourceMap().keySet();
		throw new IllegalStateException("ResourceSet is not a an instance of ResourceSetImpl.");
	}
}
