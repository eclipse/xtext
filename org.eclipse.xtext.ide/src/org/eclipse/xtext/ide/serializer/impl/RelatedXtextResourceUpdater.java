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

import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccessDiff;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionDiffBuilder;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder;
import org.eclipse.xtext.formatting2.regionaccess.internal.StringBasedTextRegionAccessDiffBuilder;
import org.eclipse.xtext.ide.serializer.IEmfResourceChange;
import org.eclipse.xtext.ide.serializer.hooks.IReferenceUpdater;
import org.eclipse.xtext.ide.serializer.hooks.IUpdatableReference;
import org.eclipse.xtext.ide.serializer.impl.ChangeTreeProvider.ResourceRecording;
import org.eclipse.xtext.ide.serializer.impl.ChangeTreeProvider.ResourceSetRecording;
import org.eclipse.xtext.ide.serializer.impl.EObjectDescriptionDeltaProvider.Deltas;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.IAcceptor;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 *
 * @since 2.13
 */
public class RelatedXtextResourceUpdater extends RelatedResourceUpdater {

	@Inject
	private ChangeTreeProvider changeTreeProvider;

	@Inject
	private RegionDiffFormatter formatter;

	@Inject
	private IReferenceUpdater referenceUpdater;

	@Inject
	private PartialSerializer serializer;

	@Inject
	private Provider<TextRegionAccessBuilder> textRegionBuilderProvider;

	@Inject
	private ResourceLifecycleManager lifecycleManager;

	@Override
	public void applyChange(Deltas deltas, IAcceptor<IEmfResourceChange> changeAcceptor) {
		XtextResource res = (XtextResource) lifecycleManager.openAndApplyReferences(getResourceSet(), getResource());
		if (!referenceUpdater.isAffected(deltas, getResource())) {
			return;
		}
		ITextRegionAccess base = textRegionBuilderProvider.get().forNodeModel(res).create();
		ITextRegionDiffBuilder rewriter = new StringBasedTextRegionAccessDiffBuilder(base);
		ReferenceUpdaterContext context = new ReferenceUpdaterContext(deltas, rewriter, getResource());
		referenceUpdater.update(context);
		if (!context.getModifications().isEmpty()) {
			ChangeRecorder rec = createChangeRecorder(res);
			try {
				for (Runnable run : context.getModifications()) {
					run.run();
				}
				ChangeDescription recording = rec.endRecording();
				ResourceSet rs = res.getResourceSet();
				ResourceSetRecording tree = changeTreeProvider.createChangeTree(rs, Collections.emptyList(), recording);
				ResourceRecording recordedResource = tree.getRecordedResource(res);
				if (recordedResource != null) {
					serializer.serializeChanges(recordedResource, rewriter);
				}
			} finally {
				rec.dispose();
			}
		}
		for (IUpdatableReference upd : context.getUpdatableReferences()) {
			referenceUpdater.updateReference(rewriter, upd);
		}
		ITextRegionAccessDiff rewritten = rewriter.create();
		List<ITextReplacement> rep = formatter.format(rewritten);
		TextDocumentChange change = new TextDocumentChange(rewritten, getResource().getUri(), rep);
		changeAcceptor.accept(change);
	}

	protected ChangeRecorder createChangeRecorder(XtextResource res) {
		return new ChangeRecorder(res.getContents().get(0));
	}

	@Override
	public void unload() {
	}
}
