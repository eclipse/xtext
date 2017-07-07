/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.serializer.impl;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.formatting2.regionaccess.IEObjectRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
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

	public List<IUpdatableReference> getUpdatableReferences() {
		return references;
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
	public void modifyModel(Runnable runnable) {
		handler.add(runnable);
	}

	@Override
	public void updateReference(EObject owner, EReference reference) {
		IEObjectRegion objectRegion = diffBuilder.getOriginalTextRegionAccess().regionForEObject(owner);
		ISemanticRegion region = objectRegion.getRegionFor().feature(reference);
		EObject target = (EObject) owner.eGet(reference);
		CrossReference crossref = GrammarUtil.containingCrossReference(region.getGrammarElement());
		references.add(new UpdatableReference(owner, reference, -1, target, crossref, region));

	}

	@Override
	public void updateReference(EObject owner, EReference reference, int index) {
		IEObjectRegion objectRegion = diffBuilder.getOriginalTextRegionAccess().regionForEObject(owner);
		List<ISemanticRegion> regions = objectRegion.getRegionFor().features(reference);
		ISemanticRegion region = regions.get(index);
		EObject target = (EObject) ((List<?>) owner.eGet(reference)).get(index);
		CrossReference crossref = GrammarUtil.containingCrossReference(region.getGrammarElement());
		references.add(new UpdatableReference(owner, reference, index, target, crossref, region));
	}

}
