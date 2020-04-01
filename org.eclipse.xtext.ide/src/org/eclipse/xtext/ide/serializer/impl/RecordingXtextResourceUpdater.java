/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.serializer.impl;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccessDiff;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionDiffBuilder;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.formatting2.regionaccess.internal.StringBasedTextRegionAccessDiffBuilder;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.ide.serializer.IEmfResourceChange;
import org.eclipse.xtext.ide.serializer.hooks.IReferenceUpdater;
import org.eclipse.xtext.ide.serializer.hooks.IResourceSnapshot;
import org.eclipse.xtext.ide.serializer.hooks.IUpdatableReference;
import org.eclipse.xtext.ide.serializer.impl.ChangeTreeProvider.ResourceRecording;
import org.eclipse.xtext.ide.serializer.impl.ChangeTreeProvider.ResourceSetRecording;
import org.eclipse.xtext.ide.serializer.impl.EObjectDescriptionDeltaProvider.Deltas;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.IAcceptor;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 *
 * @since 2.13
 */
public class RecordingXtextResourceUpdater extends RecordingResourceUpdater {

	@Inject
	private ChangeTreeProvider changeTreeProvider;

	private ITextRegionDiffBuilder document;

	@Inject
	private RegionDiffFormatter formatter;

	@Inject
	private PartialSerializer partialSerializer;

	private ChangeRecorder recorder;

	@Inject
	private IReferenceUpdater referenceUpdater;

	private IChangeSerializer serializer;

	private IResourceSnapshot snapshot;

	@Inject
	private EObjectSnapshotProvider snapshotProvider;

	@Override
	public void applyChange(Deltas deltas, IAcceptor<IEmfResourceChange> changeAcceptor) {
		Resource resource = snapshot.getResource();
		ResourceSet rs = resource.getResourceSet();
		ReferenceUpdaterContext ctx = new ReferenceUpdaterContext(deltas, document);
		if (serializer.isUpdateCrossReferences()) {
			referenceUpdater.update(ctx);
			for (Runnable run : ctx.getModifications()) {
				run.run();
			}
		}
		ChangeDescription recording = recorder.endRecording();
		if (recording != null) {
			List<IResourceSnapshot> snapshots = Collections.singletonList(snapshot);
			ResourceSetRecording tree = changeTreeProvider.createChangeTree(rs, snapshots, recording);
			ResourceRecording recordedResource = tree.getRecordedResource(resource);
			partialSerializer.serializeChanges(recordedResource, document);
		}
		recorder.dispose();
		List<IUpdatableReference> updatableReferences = ctx.getUpdatableReferences();
		for (IUpdatableReference upd : updatableReferences) {
			referenceUpdater.updateReference(document, upd);
		}
		ITextRegionAccessDiff rewritten = document.create();
		List<ITextReplacement> rep = formatter.format(rewritten);
		URI oldUri = snapshot.getURI();
		TextDocumentChange change = new TextDocumentChange(rewritten, oldUri, rep);
		changeAcceptor.accept(change);
	}

	public ITextRegionDiffBuilder beginRecording(IChangeSerializer serializer, XtextResource resource) {
		this.serializer = serializer;
		this.snapshot = snapshotProvider.createResourceSnapshot(resource, serializer.isUpdateCrossReferences());
		this.document = new StringBasedTextRegionAccessDiffBuilder(this.snapshot.getRegions());
		EcoreUtil.resolveAll(resource);
		this.recorder = createChangeRecorder(resource);
		return this.document;
	}

	protected ChangeRecorder createChangeRecorder(XtextResource resource) {
		return new ChangeRecorder(resource.getContents().get(0));
	}

	public ITextRegionDiffBuilder getDocument() {
		return document;
	}

	@Override
	public Resource getResource() {
		return snapshot.getResource();
	}

	@Override
	public IResourceSnapshot getSnapshot() {
		return snapshot;
	}

	@Override
	public void unload() {
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
		if (document != null) {
			result.append("\n" + document);
		}
		return result.toString();
	}

}
