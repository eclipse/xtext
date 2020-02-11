/*******************************************************************************
 * Copyright (c) 2018 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.serializer.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.ide.serializer.IEmfResourceChange;
import org.eclipse.xtext.ide.serializer.hooks.IResourceSnapshot;
import org.eclipse.xtext.ide.serializer.impl.EObjectDescriptionDeltaProvider.Deltas;
import org.eclipse.xtext.util.IAcceptor;

import com.google.inject.Inject;

/**
 * @since 2.14
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class RecordingEmfResourceUpdater extends RecordingResourceUpdater {

	private IChangeSerializer serializer;

	private IResourceSnapshot snapshot;

	@Inject
	private EObjectSnapshotProvider snapshotProvider;

	@Override
	public void applyChange(Deltas deltas, IAcceptor<IEmfResourceChange> changeAcceptor) {
		EmfResourceChange change = new EmfResourceChange(snapshot.getResource(), snapshot.getURI());
		changeAcceptor.accept(change);
	}

	public void beginRecording(IChangeSerializer serializer, Resource resource) {
		this.serializer = serializer;
		this.snapshot = snapshotProvider.createResourceSnapshot(resource, serializer.isUpdateCrossReferences());
		EcoreUtil.resolveAll(resource);
	}

	@Override
	public Resource getResource() {
		return snapshot.getResource();
	}

	public IChangeSerializer getSerializer() {
		return serializer;
	}

	@Override
	public IResourceSnapshot getSnapshot() {
		return snapshot;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(getClass().getSimpleName());
		URI oldURI = getSnapshot().getURI();
		URI newURI = getResource().getURI();
		if (oldURI.equals(newURI)) {
			result.append(" " + oldURI);
		} else {
			result.append(" " + oldURI + " -> " + newURI);
		}
		return result.toString();
	}

	@Override
	public void unload() {
	}

}
