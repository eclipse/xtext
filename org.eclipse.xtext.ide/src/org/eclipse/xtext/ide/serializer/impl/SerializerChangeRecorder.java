/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.serializer.impl;

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

	protected <T> T getLanguageService(Resource resource, Class<T> clazz) {
		if (resource instanceof XtextResource) {
			return ((XtextResource) resource).getResourceServiceProvider().get(clazz);
		}
		return IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(resource.getURI()).get(clazz);
	}

	private Map<Resource, IResourceSnapshot> changes = Maps.newHashMap();

	private ChangeRecorder recorder = null;
	private ResourceSet resourceSet = null;

	public ResourceSet getResourceSet() {
		return resourceSet;
	}

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

	@Inject
	private EObjectDescriptionDeltaProvider deltaProvider;

	public Deltas getDeltas() {
		return deltaProvider.getDelta(changes.values());
	}

	public ChangeDescription endRecording() {
		ChangeDescription recording = recorder.endRecording();
		return recording;
	}

}
