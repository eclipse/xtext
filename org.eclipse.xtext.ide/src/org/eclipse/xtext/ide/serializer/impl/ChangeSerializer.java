/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.serializer.impl;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionDiffBuilder;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.ide.serializer.IEmfResourceChange;
import org.eclipse.xtext.ide.serializer.hooks.IResourceSnapshot;
import org.eclipse.xtext.ide.serializer.impl.EObjectDescriptionDeltaProvider.Deltas;
import org.eclipse.xtext.ide.serializer.impl.RelatedResourcesProvider.RelatedResource;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ChangeSerializer implements IChangeSerializer {

	@Inject
	private EObjectDescriptionDeltaProvider deltaProvider;

	@Inject
	private RelatedResourcesProvider relatedResourcesProvider;

	private ResourceSet resourceSet = null;

	private boolean updateCrossReferences = true;

	private boolean updateRelatedFiles = true;

	private IProgressMonitor monitor = new NullProgressMonitor();

	private Map<Resource, RecordingResourceUpdater> updaters = Maps.newLinkedHashMap();

	private List<Pair<Notifier, IModification<? extends Notifier>>> modifications = Lists.newArrayList();

	@Override
	public <T extends Notifier> void addModification(T context, IModification<T> modification) {
		modifications.add(Tuples.create(context, modification));
	}

	@Override
	public void applyModifications(IAcceptor<IEmfResourceChange> changeAcceptor) {
		monitor.setTaskName("Preparing Text Changes...");
		Set<Resource> resources = Sets.newLinkedHashSet();
		for (Pair<Notifier, IModification<? extends Notifier>> p : modifications) {
			Notifier context = p.getFirst();
			if (context instanceof EObject)
				resources.add(((EObject) context).eResource());
			else if (context instanceof Resource)
				resources.add((Resource) context);
			else if (context instanceof ResourceSet) {
				throw new IllegalStateException("Not supported");
			}
		}
		for (Resource res : resources) {
			// TODO: use the exact context
			beginRecordChanges(res);
		}
		checkCanceled();
		for (Pair<Notifier, IModification<? extends Notifier>> entry : modifications) {
			apply(entry.getFirst(), entry.getSecond());
		}
		checkCanceled();
		endRecordChanges(changeAcceptor);
	}

	protected void checkCanceled() {
		if (monitor.isCanceled()) {
			throw new OperationCanceledException();
		}
	}

	@SuppressWarnings("unchecked")
	protected <T extends Notifier> void apply(Notifier context, IModification<T> modification) {
		modification.modify((T) context);
	}

	protected void beginRecordChanges(Resource resource) {
		RecordingResourceUpdater updater = updaters.get(resource);
		if (updater != null) {
			return;
		}
		if (resourceSet == null) {
			resourceSet = resource.getResourceSet();
		} else {
			if (resource.getResourceSet() != resourceSet) {
				throw new IllegalStateException("Wrong ResourceSet.");
			}
		}
		updater = createResourceUpdater(resource);
		updaters.put(resource, updater);
	}

	protected RelatedResourceUpdater createResourceUpdater(RelatedResource relatedResource) {
		URI uri = relatedResource.getUri();
		IGrammarAccess grammar = getService(uri, IGrammarAccess.class);
		RelatedResourceUpdater updater;
		if (grammar != null) {
			updater = getService(uri, RelatedXtextResourceUpdater.class);
		} else {
			updater = getService(uri, RelatedEmfResourceUpdater.class);
		}
		updater.init(this, resourceSet, relatedResource);
		return updater;
	}

	protected RecordingResourceUpdater createResourceUpdater(Resource resource) {
		if (resource instanceof XtextResource) {
			RecordingXtextResourceUpdater updater = getService(resource, RecordingXtextResourceUpdater.class);
			updater.beginRecording(this, (XtextResource) resource);
			return updater;
		} else {
			RecordingEmfResourceUpdater updater = getService(resource, RecordingEmfResourceUpdater.class);
			updater.beginRecording(this, resource);
			return updater;
		}
	}

	protected void endRecordChanges(IAcceptor<IEmfResourceChange> changeAcceptor) {
		if (updaters.isEmpty()) {
			return;
		}
		List<IResourceSnapshot> snapshots = getSnapshots();
		Deltas deltas = deltaProvider.getDelta(this, snapshots);
		List<ResourceUpdater> updaters = Lists.newArrayList(this.updaters.values());
		if (updateRelatedFiles && updateCrossReferences) {
			List<RelatedResource> related = relatedResourcesProvider.getRelatedResources(deltas.getSnapshots());
			for (RelatedResource ref : related) {
				RelatedResourceUpdater updater = createResourceUpdater(ref);
				updaters.add(updater);
			}
		}
		monitor.beginTask("Creating Text Changes...", updaters.size());
		for (ResourceUpdater updater : updaters) {
			updater.applyChange(deltas, changeAcceptor);
			monitor.worked(1);
			checkCanceled();
		}
		for (ResourceUpdater updater : updaters) {
			updater.unload();
		}
	}

	protected void resetState() {
		modifications.clear();
		updaters.clear();
		resourceSet = null;
	}

	@Override
	public ITextRegionDiffBuilder getModifiableDocument(Resource resource) {
		RecordingResourceUpdater updater = this.updaters.get(resource);
		if (updater instanceof RecordingXtextResourceUpdater) {
			return ((RecordingXtextResourceUpdater) updater).getDocument();
		}
		return null;
	}

	protected <T> T getService(Resource resource, Class<T> clazz) {
		if (resource instanceof XtextResource) {
			return ((XtextResource) resource).getResourceServiceProvider().get(clazz);
		}
		return getService(resource.getURI(), clazz);
	}

	protected <T> T getService(URI uri, Class<T> clazz) {
		return IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(uri).get(clazz);
	}

	protected List<IResourceSnapshot> getSnapshots() {
		return updaters.values().stream().map(u -> u.getSnapshot()).collect(toList());
	}

	@Override
	public boolean isUpdateCrossReferences() {
		return updateCrossReferences;
	}

	@Override
	public boolean isUpdateRelatedFiles() {
		return updateRelatedFiles;
	}

	@Override
	public void setUpdateCrossReferences(boolean value) {
		this.updateCrossReferences = value;
	}

	@Override
	public void setUpdateRelatedFiles(boolean value) {
		this.updateRelatedFiles = value;
	}

	@Override
	public void setProgressMonitor(IProgressMonitor monitor) {
		this.monitor = monitor;
	}

}
