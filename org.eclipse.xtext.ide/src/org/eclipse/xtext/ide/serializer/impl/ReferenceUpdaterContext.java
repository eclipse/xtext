/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.serializer.impl;

import java.util.List;

import org.eclipse.xtext.formatting2.regionaccess.ITextRegionDiffBuilder;
import org.eclipse.xtext.ide.serializer.hooks.IReferenceUpdaterContext;
import org.eclipse.xtext.ide.serializer.hooks.IUpdatableReference;
import org.eclipse.xtext.ide.serializer.impl.EObjectDescriptionDeltaProvider.Deltas;
import org.eclipse.xtext.resource.XtextResource;

import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ReferenceUpdaterContext implements IReferenceUpdaterContext {

	private final Deltas deltas;
	private final ITextRegionDiffBuilder diffBuilder;
	private final List<Runnable> handler = Lists.newArrayList();
	private final List<IUpdatableReference> references = Lists.newArrayList();

	public ReferenceUpdaterContext(Deltas deltas, ITextRegionDiffBuilder diffBuilder) {
		super();
		this.deltas = deltas;
		this.diffBuilder = diffBuilder;
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
