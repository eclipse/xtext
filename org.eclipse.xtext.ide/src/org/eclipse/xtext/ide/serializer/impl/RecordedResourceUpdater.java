/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.serializer.impl;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccessDiff;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionDiffBuilder;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.ide.serializer.IEmfResourceChange;
import org.eclipse.xtext.ide.serializer.hooks.IReferenceUpdater;
import org.eclipse.xtext.ide.serializer.hooks.IResourceSnapshot;
import org.eclipse.xtext.ide.serializer.hooks.IUpdatableReference;
import org.eclipse.xtext.ide.serializer.impl.ChangeTreeProvider.ResourceRecording;
import org.eclipse.xtext.ide.serializer.impl.EObjectDescriptionDeltaProvider.Deltas;
import org.eclipse.xtext.util.IAcceptor;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class RecordedResourceUpdater {

	private ITextRegionDiffBuilder document;

	@Inject
	private RegionDiffFormatter formatter;

	@Inject
	private PartialSerializer partialSerializer;

	@Inject
	private IReferenceUpdater referenceUpdater;

	private IChangeSerializer serializer;

	private IResourceSnapshot snapshot;

	private Deltas deltas;

	private ReferenceUpdaterContext ctx;

	public IResourceSnapshot getSnapshot() {
		return snapshot;
	}

	public Resource getResource() {
		return snapshot.getResource();
	}

	public void applyChange(ResourceRecording rec, IAcceptor<IEmfResourceChange> changeAcceptor) {
		ITextRegionDiffBuilder rewriter = ctx.getModifyableDocument();
		partialSerializer.serializeChanges(rec, rewriter);
		for (Runnable run : ctx.getModifications()) {
			run.run();
		}
		for (IUpdatableReference upd : ctx.getUpdatableReferences()) {
			referenceUpdater.updateReference(rewriter, upd);
		}
		ITextRegionAccessDiff rewritten = rewriter.create();
		List<ITextReplacement> rep = formatter.format(rewritten);
		URI oldUri = rec.getSnapshot().getURI();
		TextDocumentChange change = new TextDocumentChange(rewritten, oldUri, rep);
		changeAcceptor.accept(change);
	}

	public void init(IChangeSerializer ser, Deltas deltas, IResourceSnapshot snap, ITextRegionDiffBuilder doc) {
		this.serializer = ser;
		this.deltas = deltas;
		this.snapshot = snap;
		this.document = doc;
	}

	public void updateReferences() {
		ctx = new ReferenceUpdaterContext(deltas, document);
		if (serializer.isUpdateCrossReferences()) {
			referenceUpdater.update(ctx);
		}
	}

}
