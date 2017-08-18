/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.serializer.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.ide.serializer.hooks.IResourceSnapshot;
import org.eclipse.xtext.ide.serializer.impl.EObjectDescriptionDeltaProvider.Deltas;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;

import com.google.common.collect.Maps;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SerializerChangeRecorder {

	private Map<Resource, IResourceSnapshot> changes = Maps.newLinkedHashMap();

	@Inject
	private EObjectDescriptionDeltaProvider deltaProvider;

	private ChangeRecorder recorder = null;
	private ResourceSet resourceSet = null;

	public IResourceSnapshot beginRecording(Resource resource) {
		EcoreUtil.resolveAll(resource);
		if (recorder == null) {
			recorder = new ChangeRecorder(resource.getResourceSet());
			resourceSet = resource.getResourceSet();
		} else {
			if (resourceSet != resource.getResourceSet()) {
				throw new IllegalStateException("Wrong resource.");
			}
		}
		EObjectSnapshotProvider strategy = getLanguageService(resource, EObjectSnapshotProvider.class);
		IResourceSnapshot snapshot = strategy.createResourceSnapshot(resource);
		changes.put(resource, snapshot);
		return snapshot;
	}

	public ChangeDescription endRecording() {
		ChangeDescription recording = recorder.endRecording();
		recorder.dispose();
		return recording;
	}

	public Deltas getDeltas(ChangeSerializer serializer) {
		return deltaProvider.getDelta(serializer, changes.values());
	}

	protected <T> T getLanguageService(Resource resource, Class<T> clazz) {
		if (resource instanceof XtextResource) {
			return ((XtextResource) resource).getResourceServiceProvider().get(clazz);
		}
		return IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(resource.getURI()).get(clazz);
	}

	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	public Collection<IResourceSnapshot> getSnapshots() {
		return changes.values();
	}

}
