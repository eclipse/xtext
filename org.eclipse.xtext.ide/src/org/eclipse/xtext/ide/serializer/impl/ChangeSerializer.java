/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.serializer.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionDiffBuilder;
import org.eclipse.xtext.formatting2.regionaccess.internal.StringBasedTextRegionAccessDiffBuilder;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.ide.serializer.IEmfResourceChange;
import org.eclipse.xtext.ide.serializer.hooks.IResourceSnapshot;
import org.eclipse.xtext.ide.serializer.impl.ChangeTreeProvider.ResourceRecording;
import org.eclipse.xtext.ide.serializer.impl.ChangeTreeProvider.ResourceSetRecording;
import org.eclipse.xtext.ide.serializer.impl.EObjectDescriptionDeltaProvider.Deltas;
import org.eclipse.xtext.ide.serializer.impl.RelatedResourcesProvider.RelatedResource;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.IAcceptor;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ChangeSerializer implements IChangeSerializer {

	private Map<Resource, ITextRegionDiffBuilder> builders = Maps.newHashMap();

	@Inject
	private ChangeTreeProvider changeTreeProvider;

	@Inject
	private SerializerChangeRecorder recorder;

	@Inject
	private RelatedResourcesProvider relatedResourcesProvider;

	private boolean updateCrossReferences = true;

	private boolean updateRelatedFiles = true;

	@Override
	public ITextRegionDiffBuilder beginRecordChanges(Resource resource) {
		IResourceSnapshot snapshot = recorder.beginRecording(resource);
		ITextRegionDiffBuilder result = new StringBasedTextRegionAccessDiffBuilder(snapshot.getRegions());
		builders.put(resource, result);
		return result;
	}

	@Override
	public void endRecordChanges(IAcceptor<IEmfResourceChange> changeAcceptor) {
		Deltas deltas = recorder.getDeltas();
		List<RecordedResourceUpdater> primary = Lists.newArrayList();
		for (IResourceSnapshot resource : deltas.getSnapshots()) {
			Resource res = resource.getResource();
			RecordedResourceUpdater updater = getService(res, RecordedResourceUpdater.class);
			updater.init(this, deltas, resource, builders.get(res));
			primary.add(updater);
		}
		for (RecordedResourceUpdater updater : primary) {
			updater.updateReferences();
		}
		ResourceSet resourceSet = recorder.getResourceSet();
		ChangeDescription recording = recorder.endRecording();
		Collection<IResourceSnapshot> snapshots = recorder.getSnapshots();
		ResourceSetRecording tree = changeTreeProvider.createChangeTree(resourceSet, snapshots, recording);
		for (RecordedResourceUpdater updater : primary) {
			ResourceRecording record = tree.getRecordedResource(updater.getResource());
			updater.applyChange(record, changeAcceptor);
		}
		if (updateRelatedFiles && updateCrossReferences) {
			List<RelatedResource> related = relatedResourcesProvider.getRelatedResources(deltas.getSnapshots());
			for (RelatedResource ref : related) {
				updateRelated(deltas, resourceSet, ref, changeAcceptor);
			}
		}
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

	protected void updateRelated(Deltas delt, ResourceSet rs, RelatedResource r, IAcceptor<IEmfResourceChange> acc) {
		URI uri = r.getUri();
		ResourceLifecycleManager lifecycleManager = getService(uri, ResourceLifecycleManager.class);
		Resource resource = lifecycleManager.openAndApplyReferences(rs, r);
		try {
			if (resource instanceof XtextResource) {
				XtextResource xtextResource = (XtextResource) resource;
				RelatedXtextResourceUpdater updater = getService(uri, RelatedXtextResourceUpdater.class);
				updater.applyChange(delt, xtextResource, r, acc);
			} else {
				RelatedEmfResourceUpdater updater = getService(uri, RelatedEmfResourceUpdater.class);
				updater.applyChange(delt, resource, r, acc);
			}
		} finally {
			lifecycleManager.close(resource);
		}
	}

}
