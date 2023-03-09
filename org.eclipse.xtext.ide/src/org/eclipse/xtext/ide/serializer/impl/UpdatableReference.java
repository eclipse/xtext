/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.serializer.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.ide.serializer.hooks.IUpdatableReference;

import com.google.common.base.Preconditions;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 *
 * @since 2.13
 */
public class UpdatableReference implements IUpdatableReference {
	private final CrossReference crossref;
	private final int index;
	private final EObject owner;
	private final EReference reference;
	private final ISemanticRegion region;
	private final EObject target;

	public UpdatableReference(EObject owner, EReference reference, int index, EObject target, CrossReference crossref,
			ISemanticRegion region) {
		super();
		Preconditions.checkNotNull(owner);
		Preconditions.checkNotNull(reference);
		Preconditions.checkArgument(!reference.isContainment());
		Preconditions.checkNotNull(target);
		Preconditions.checkNotNull(crossref);
		Preconditions.checkNotNull(region);
		this.owner = owner;
		this.reference = reference;
		this.index = index;
		this.target = target;
		this.crossref = crossref;
		this.region = region;
	}

	@Override
	public CrossReference getCrossReference() {
		return crossref;
	}

	@Override
	public EReference getEReference() {
		return reference;
	}

	@Override
	public int getIndexInList() {
		return index;
	}

	@Override
	public ISemanticRegion getReferenceRegion() {
		return region;
	}

	@Override
	public EObject getSourceEObject() {
		return owner;
	}

	@Override
	public EObject getTargetEObject() {
		return target;
	}

}