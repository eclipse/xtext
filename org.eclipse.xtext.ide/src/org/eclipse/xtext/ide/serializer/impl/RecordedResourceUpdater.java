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

	private Deltas deltas;

	private ITextRegionDiffBuilder document;

	@Inject
	private RegionDiffFormatter formatter;

	@Inject
	private PartialSerializer partialSerializer;

	@Inject
	private IReferenceUpdater referenceUpdater;

	private IChangeSerializer serializer;

	private IResourceSnapshot snapshot;

	private List<IUpdatableReference> updatableReferences;

	public void applyChange(ResourceRecording rec, IAcceptor<IEmfResourceChange> changeAcceptor) {
		partialSerializer.serializeChanges(rec, document);
		for (IUpdatableReference upd : updatableReferences) {
			referenceUpdater.updateReference(document, upd);
		}
		ITextRegionAccessDiff rewritten = document.create();
		List<ITextReplacement> rep = formatter.format(rewritten);
		URI oldUri = rec.getSnapshot().getURI();
		TextDocumentChange change = new TextDocumentChange(rewritten, oldUri, rep);
		changeAcceptor.accept(change);
	}

	public Resource getResource() {
		return snapshot.getResource();
	}

	public IResourceSnapshot getSnapshot() {
		return snapshot;
	}

	public void init(IChangeSerializer ser, Deltas deltas, IResourceSnapshot snap, ITextRegionDiffBuilder doc) {
		this.serializer = ser;
		this.deltas = deltas;
		this.snapshot = snap;
		this.document = doc;
	}

	public void updateReferences() {
		ReferenceUpdaterContext ctx = new ReferenceUpdaterContext(deltas, document);
		if (serializer.isUpdateCrossReferences()) {
			referenceUpdater.update(ctx);
			for (Runnable run : ctx.getModifications()) {
				run.run();
			}
		}
		this.updatableReferences = ctx.getUpdatableReferences();
	}

}
