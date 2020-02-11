/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.formatting2.regionaccess.IAstRegion;
import org.eclipse.xtext.formatting2.regionaccess.IEObjectRegion;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegionFinder;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegionsFinder;
import org.eclipse.xtext.formatting2.regionaccess.ISequentialRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractEObjectRegion extends AbstractTextSegment implements IEObjectRegion {
	private final ITextRegionAccess access;
	private final List<IAstRegion> children = Lists.newArrayList();
	private EObject grammarElement;
	private int indexInFeature = -2;
	private IHiddenRegion nextHidden;
	private IEObjectRegion parent;
	private IHiddenRegion previousHidden;
	private EObject semanticElement;

	public AbstractEObjectRegion(AbstractRegionAccess access) {
		super();
		this.access = access;
	}

	public void addChild(IAstRegion astRegion) {
		if (astRegion instanceof AbstractEObjectRegion) {
			((AbstractEObjectRegion) astRegion).parent = this;
		}
		this.children.add(astRegion);
	}

	@Override
	public ISemanticRegionsFinder getAllRegionsFor() {
		return new SemanticRegionInIterableFinder(getAllSemanticRegions());
	}

	@Override
	public Iterable<ISemanticRegion> getAllSemanticRegions() {
		ISemanticRegion first = previousHidden.getNextSemanticRegion();
		ISemanticRegion last = nextHidden.getPreviousSemanticRegion();
		return new SemanticRegionIterable(first, last);
	}

	@Override
	public Iterable<IAstRegion> getAstRegions() {
		return children;
	}

	@Override
	public EStructuralFeature getContainingFeature() {
		if(semanticElement.eContainer() == null) {
			return null;
		}
		String feature = null;
		if (grammarElement instanceof Action) {
			feature = ((Action) grammarElement).getFeature();
		} else {
			Assignment assignment = GrammarUtil.containingAssignment(getGrammarElement());
			if (assignment != null) {
				feature = assignment.getFeature();
			}
		}
		if (feature == null) {
			return null;
		}
		return semanticElement.eContainer().eClass().getEStructuralFeature(feature);
	}

	@Override
	public IEObjectRegion getContainingRegion() {
		return parent;
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
				((AbstractEObjectRegion) parent).initChildrenFeatureIndexes();
			} else {
				indexInFeature = -1;
			}
		}
		return indexInFeature;
	}

	public IHiddenRegion getLeadingHiddenRegion() {
		return previousHidden;
	}

	@Override
	public int getLength() {
		return nextHidden.getOffset() - getOffset();
	}

	@Override
	public IHiddenRegion getNextHiddenRegion() {
		return nextHidden;
	}

	@Override
	public ISemanticRegion getNextSemanticRegion() {
		return nextHidden.getNextSemanticRegion();
	}

	@Override
	public ISequentialRegion getNextSequentialRegion() {
		return nextHidden;
	}

	@Override
	public int getOffset() {
		return previousHidden.getEndOffset();
	}

	@Override
	public IHiddenRegion getPreviousHiddenRegion() {
		return previousHidden;
	}

	@Override
	public ISemanticRegion getPreviousSemanticRegion() {
		return previousHidden.getPreviousSemanticRegion();
	}

	@Override
	public ISequentialRegion getPreviousSequentialRegion() {
		return previousHidden;
	}

	@Override
	public ISemanticRegionsFinder getRegionFor() {
		return new SemanticRegionInIterableFinder(getSemanticRegions());
	}

	@Override
	public EObject getSemanticElement() {
		return semanticElement;
	}

	@Override
	public Iterable<ISemanticRegion> getSemanticRegions() {
		return Iterables.filter(children, ISemanticRegion.class);
	}

	@Override
	public ITextRegionAccess getTextRegionAccess() {
		return access;
	}

	public IHiddenRegion getTrailingHiddenRegion() {
		return nextHidden;
	}

	@Override
	public ISemanticRegionFinder immediatelyFollowing() {
		return new SemanticRegionMatcher(getNextSemanticRegion());
	}

	@Override
	public ISemanticRegionFinder immediatelyPreceding() {
		return new SemanticRegionMatcher(getPreviousSemanticRegion());
	}

	protected void initChildrenFeatureIndexes() {
		EClass clazz = semanticElement.eClass();
		int[] indices = new int[clazz.getFeatureCount()];
		Arrays.fill(indices, 0);
		for (IAstRegion ele : children) {
			EStructuralFeature feat = ele.getContainingFeature();
			if (feat != null && feat.isMany()) {
				int id = clazz.getFeatureID(feat);
				if (ele instanceof AbstractEObjectRegion) {
					((AbstractEObjectRegion) ele).indexInFeature = indices[id];
				} else if (ele instanceof NodeSemanticRegion) {
					((NodeSemanticRegion) ele).indexInFeature = indices[id];
				} else if (ele instanceof StringSemanticRegion) {
					((StringSemanticRegion) ele).indexInFeature = indices[id];
				}
				indices[id]++;
			}
		}
	}

	protected void setGrammarElement(EObject grammarElement) {
		this.grammarElement = grammarElement;
	}

	protected void setLeadingHiddenRegion(IHiddenRegion leading) {
		this.previousHidden = leading;
	}

	protected void setSemanticElement(EObject semanticElement) {
		this.semanticElement = semanticElement;
	}

	protected void setTrailingHiddenRegion(IHiddenRegion trailing) {
		this.nextHidden = trailing;
	}

}
