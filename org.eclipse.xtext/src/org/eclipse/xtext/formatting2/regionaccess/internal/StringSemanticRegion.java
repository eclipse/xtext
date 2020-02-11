/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.formatting2.regionaccess.IEObjectRegion;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegionFinder;
import org.eclipse.xtext.formatting2.regionaccess.ISequentialRegion;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class StringSemanticRegion extends StringRegion implements ISemanticRegion {

	private final AbstractEObjectRegion eObjectRegion;
	private final EObject grammarElement;
	protected int indexInFeature = -2;
	private IHiddenRegion leading;
	private IHiddenRegion trailing;

	protected StringSemanticRegion(StringBasedRegionAccess regionAccess, AbstractEObjectRegion semanticElement,
			EObject grammarElement, int offset, int length) {
		super(regionAccess, offset, length);
		this.eObjectRegion = semanticElement;
		this.grammarElement = grammarElement;
	}

	@Override
	public EStructuralFeature getContainingFeature() {
		Assignment assignment = GrammarUtil.containingAssignment(getGrammarElement());
		if (assignment != null) {
			return getSemanticElement().eClass().getEStructuralFeature(assignment.getFeature());
		}
		return null;
	}

	@Override
	public IEObjectRegion getContainingRegion() {
		return eObjectRegion;
	}

	@Override
	public IEObjectRegion getEObjectRegion() {
		return eObjectRegion;
	}

	@Override
	public EObject getGrammarElement() {
		return grammarElement;
	}

	@Override
	public int getIndexInContainingFeature() {
		if (indexInFeature < -1) {
			EStructuralFeature feature = getContainingFeature();
			if (feature != null && feature.isMany()) {
				((AbstractEObjectRegion) eObjectRegion).initChildrenFeatureIndexes();
			} else {
				indexInFeature = -1;
			}
		}
		return indexInFeature;
	}

	@Override
	public IHiddenRegion getNextHiddenRegion() {
		return trailing;
	}

	@Override
	public ISemanticRegion getNextSemanticRegion() {
		return trailing != null ? trailing.getNextSemanticRegion() : null;
	}

	@Override
	public ISequentialRegion getNextSequentialRegion() {
		return trailing;
	}

	@Override
	public IHiddenRegion getPreviousHiddenRegion() {
		return leading;
	}

	@Override
	public ISemanticRegion getPreviousSemanticRegion() {
		return leading != null ? leading.getPreviousSemanticRegion() : null;
	}

	@Override
	public ISequentialRegion getPreviousSequentialRegion() {
		return leading;
	}

	@Override
	public EObject getSemanticElement() {
		return eObjectRegion.getSemanticElement();
	}

	@Override
	public ISemanticRegionFinder immediatelyFollowing() {
		return new SemanticRegionMatcher(getNextSemanticRegion());
	}

	@Override
	public ISemanticRegionFinder immediatelyPreceding() {
		return new SemanticRegionMatcher(getPreviousSemanticRegion());
	}

	protected void setLeadingHiddenRegion(IHiddenRegion leading) {
		this.leading = leading;
	}

	protected void setTrailingHiddenRegion(IHiddenRegion trailing) {
		this.trailing = trailing;
	}

}
