/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.regionaccess.IEObjectRegion;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegionFinder;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegionsFinder;
import org.eclipse.xtext.formatting2.regionaccess.ISequentialRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;

import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractEObjectRegion extends AbstractTextSegment implements IEObjectRegion {
	private final ITextRegionAccess access;
	private EObject grammarElement;
	private IHiddenRegion nextHidden;
	private IHiddenRegion previousHidden;
	private EObject semanticElement;
	private final List<ISemanticRegion> semanticRegions = Lists.newArrayList();

	public AbstractEObjectRegion(AbstractRegionAccess access) {
		super();
		this.access = access;
	}

	@Override
	public EObject getGrammarElement() {
		return grammarElement;
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
	public EObject getSemanticElement() {
		return semanticElement;
	}

	@Override
	public List<ISemanticRegion> getSemanticRegions() {
		return semanticRegions;
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

	@Override
	public ISemanticRegionsFinder getRegionFor() {
		return new SemanticRegionInIterableFinder(semanticRegions);
	}

	@Override
	public Iterable<ISemanticRegion> getAllSemanticRegions() {
		ISemanticRegion first = previousHidden.getNextSemanticRegion();
		ISemanticRegion last = nextHidden.getPreviousSemanticRegion();
		return new SemanticRegionIterable(first, last);
	}

	@Override
	public ISemanticRegionsFinder getAllRegionsFor() {
		return new SemanticRegionInIterableFinder(getAllSemanticRegions());
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