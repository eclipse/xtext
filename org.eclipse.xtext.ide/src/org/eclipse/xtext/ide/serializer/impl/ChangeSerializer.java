/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.serializer.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccessDiff;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionDiffBuilder;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder;
import org.eclipse.xtext.formatting2.regionaccess.internal.StringBasedTextRegionAccessDiffBuilder;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.ide.serializer.IEmfResourceChange;
import org.eclipse.xtext.ide.serializer.hooks.IReferenceUpdater;
import org.eclipse.xtext.ide.serializer.hooks.IResourceSnapshot;
import org.eclipse.xtext.ide.serializer.hooks.IUpdatableReference;
import org.eclipse.xtext.ide.serializer.impl.ChangeTreeProvider.ResourceRecording;
import org.eclipse.xtext.ide.serializer.impl.ChangeTreeProvider.ResourceSetRecording;
import org.eclipse.xtext.ide.serializer.impl.EObjectDescriptionDeltaProvider.Deltas;
import org.eclipse.xtext.ide.serializer.impl.RelatedResourcesProvider.RelatedResource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.util.IAcceptor;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ChangeSerializer implements IChangeSerializer {

	private Map<Resource, ITextRegionDiffBuilder> builders = Maps.newHashMap();

	@Inject
	private ChangeTreeProvider changeTreeProvider;

	@Inject
	private RegionDiffFormatter formatter;

	@Inject
	private ResourceLifecycleManager lifecycleManager;

	@Inject
	private SerializerChangeRecorder recorder;

	@Inject
	private IReferenceUpdater referenceUpdater;

	@Inject
	private RelatedResourcesProvider relatedResourcesProvider;

	@Inject
	private PartialSerializer serializer;

	@Inject
	private Provider<TextRegionAccessBuilder> textRegionBuilderProvider;

	private boolean updateCrossReferences = true;

	private boolean updateRelatedFiles = true;

	protected void applyChange(Deltas deltas, ResourceSet rs, RelatedResource refs, IAcceptor<IEmfResourceChange> acc) {
		Resource resource = lifecycleManager.openAndApplyReferences(rs, refs);
		try {
			if (resource instanceof XtextResource) {
				XtextResource xtextResource = (XtextResource) resource;
				ITextRegionAccess base = textRegionBuilderProvider.get().forNodeModel(xtextResource).create();
				ITextRegionDiffBuilder rewriter = new StringBasedTextRegionAccessDiffBuilder(base);
				ReferenceUpdaterContext context = new ReferenceUpdaterContext(deltas, rewriter);
				referenceUpdater.update(context);
				if (!context.getModifications().isEmpty()) {
					ChangeRecorder rec = new ChangeRecorder(resource);
					for (Runnable run : context.getModifications()) {
						run.run();
					}
					ChangeDescription recording = rec.endRecording();
					ResourceSetRecording tree = changeTreeProvider.createChangeTree(rs, Collections.emptyList(),
							recording);
					ResourceRecording recordedResource = tree.getRecordedResource(resource);
					serializer.serializeChanges(recordedResource, rewriter);
				}
				for (IUpdatableReference upd : context.getUpdatableReferences()) {
					referenceUpdater.updateReference(rewriter, upd);
				}
				ITextRegionAccessDiff rewritten = rewriter.create();
				List<ITextReplacement> rep = formatter.format(rewritten);
				TextDocumentChange change = new TextDocumentChange(rewritten, refs.getUri(), rep);
				acc.accept(change);
			} else {
				EmfResourceChange change = new EmfResourceChange(resource, refs.getUri());
				acc.accept(change);
			}
		} finally {
			lifecycleManager.close(resource);
		}
	}

	protected void applyChange(ResourceRecording rec, ReferenceUpdaterContext loaded,
			IAcceptor<IEmfResourceChange> changeAcceptor) {
		ITextRegionDiffBuilder rewriter = loaded.getModifyableDocument();
		serializer.serializeChanges(rec, rewriter);
		for (Runnable run : loaded.getModifications()) {
			run.run();
		}
		for (IUpdatableReference upd : loaded.getUpdatableReferences()) {
			referenceUpdater.updateReference(rewriter, upd);
		}
		ITextRegionAccessDiff rewritten = rewriter.create();
		List<ITextReplacement> rep = formatter.format(rewritten);
		URI oldUri = rec.getSnapshot().getURI();
		TextDocumentChange change = new TextDocumentChange(rewritten, oldUri, rep);
		changeAcceptor.accept(change);
	}

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
		ResourceSet resourceSet = recorder.getResourceSet();
		Map<Resource, ReferenceUpdaterContext> loaded = Maps.newHashMap();
		for (IResourceSnapshot resource : deltas.getSnapshots()) {
			ReferenceUpdaterContext references = updateReferences(deltas, resource);
			loaded.put(resource.getResource(), references);
		}
		ChangeDescription recording = recorder.endRecording();
		Collection<IResourceSnapshot> snapshots = recorder.getSnapshots();
		ResourceSetRecording tree = changeTreeProvider.createChangeTree(resourceSet, snapshots, recording);
		for (ResourceRecording l : tree.getRecordedResources()) {
			Resource resource = l.getResource();
			ReferenceUpdaterContext context = loaded.get(resource);
			applyChange(l, context, changeAcceptor);
		}
		if (updateRelatedFiles && updateCrossReferences) {
			List<RelatedResource> related = relatedResourcesProvider.getRelatedResources(deltas.getSnapshots());
			for (RelatedResource ref : related) {
				if (referenceUpdater.isAffected(deltas, ref)) {
					applyChange(deltas, resourceSet, ref, changeAcceptor);
				}
			}
		}
	}

	@Override
	public boolean isUpdateCrossReferences() {
		return updateCrossReferences;
	}

	@Override
	public boolean isUpdateRelatedFiles() {
		return updateRelatedFiles;
	}

	public void setErrorAcceptor(Acceptor acceptor) {
		serializer.setErrorAcceptor(acceptor);
	}

	@Override
	public void setUpdateCrossReferences(boolean value) {
		this.updateCrossReferences = value;
	}

	@Override
	public void setUpdateRelatedFiles(boolean value) {
		this.updateRelatedFiles = value;
	}

	protected ReferenceUpdaterContext updateReferences(Deltas deltas, IResourceSnapshot snapshot) {
		ReferenceUpdaterContext ctx = new ReferenceUpdaterContext(deltas, builders.get(snapshot.getResource()));
		if (updateCrossReferences) {
			referenceUpdater.update(ctx);
		}
		return ctx;
	}

}
