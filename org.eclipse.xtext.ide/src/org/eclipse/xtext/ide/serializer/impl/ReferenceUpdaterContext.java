/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.serializer.impl;

import java.util.List;

import org.eclipse.xtext.formatting2.regionaccess.ITextRegionDiffBuilder;
import org.eclipse.xtext.ide.serializer.hooks.IReferenceUpdaterContext;
import org.eclipse.xtext.ide.serializer.hooks.IUpdatableReference;
import org.eclipse.xtext.ide.serializer.impl.EObjectDescriptionDeltaProvider.Deltas;
import org.eclipse.xtext.ide.serializer.impl.RelatedResourcesProvider.RelatedResource;
import org.eclipse.xtext.resource.XtextResource;

import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 *
 * @since 2.13
 */
public class ReferenceUpdaterContext implements IReferenceUpdaterContext {

	private final Deltas deltas;
	private final ITextRegionDiffBuilder diffBuilder;
	private final List<Runnable> handler = Lists.newArrayList();
	private final List<IUpdatableReference> references = Lists.newArrayList();
	private final RelatedResource relatedResource;

	public ReferenceUpdaterContext(Deltas deltas, ITextRegionDiffBuilder diffBuilder) {
		super();
		this.deltas = deltas;
		this.diffBuilder = diffBuilder;
		this.relatedResource = null;
	}

	public ReferenceUpdaterContext(Deltas deltas, ITextRegionDiffBuilder diffBuilder, RelatedResource relatedResource) {
		this.deltas = deltas;
		this.diffBuilder = diffBuilder;
		this.relatedResource = relatedResource;
	}

	@Override
	public Deltas getEObjectDescriptionDeltas() {
		return deltas;
	}

	protected List<Runnable> getModifications() {
		return handler;
	}

	@Override
	public ITextRegionDiffBuilder getModifyableDocument() {
		return this.diffBuilder;
	}

	@Override
	public RelatedResource getRelatedResource() {
		return relatedResource;
	}

	@Override
	public XtextResource getResource() {
		return diffBuilder.getOriginalTextRegionAccess().getResource();
	}

	@Override
	public List<IUpdatableReference> getUpdatableReferences() {
		return references;
	}

	@Override
	public void modifyModel(Runnable runnable) {
		handler.add(runnable);
	}

	@Override
	public void updateReference(IUpdatableReference updatableReference) {
		references.add(updatableReference);
	}

}
