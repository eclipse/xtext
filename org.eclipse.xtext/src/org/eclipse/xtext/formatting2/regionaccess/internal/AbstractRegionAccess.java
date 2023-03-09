/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.debug.TextRegionAccessToString;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.ILineRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegionFinder;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegionsFinder;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionExtensions;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractRegionAccess implements ITextRegionAccess, ITextRegionExtensions {

	@Override
	public ITextRegionExtensions getExtensions() {
		return this;
	}

	@Override
	public Iterable<ISemanticRegion> allSemanticRegions(EObject object) {
		AbstractEObjectRegion region = regionForEObject(object);
		if (region == null)
			return Collections.emptyList();
		return region.getAllSemanticRegions();
	}

	@Override
	public Iterable<ISemanticRegion> semanticRegions(EObject object) {
		AbstractEObjectRegion region = regionForEObject(object);
		if (region == null)
			return Collections.emptyList();
		return region.getSemanticRegions();
	}

	@Override
	public ISemanticRegionsFinder allRegionsFor(EObject object) {
		AbstractEObjectRegion region = regionForEObject(object);
		if (region == null)
			return SemanticRegionNullFinder.INSTANCE;
		return region.getAllRegionsFor();
	}

	@Override
	public EObject grammarElement(EObject obj) {
		AbstractEObjectRegion tokens = regionForEObject(obj);
		if (tokens == null)
			return null;
		return tokens.getGrammarElement();
	}

	@Override
	public TextRegionRewriter getRewriter() {
		return new TextRegionRewriter(this);
	}

	protected abstract String getText();

	@Override
	public ITextRegionAccess getTextRegionAccess() {
		return this;
	}

	@Override
	public ISemanticRegionFinder immediatelyFollowing(EObject owner) {
		AbstractEObjectRegion region = regionForEObject(owner);
		if (region != null)
			return region.immediatelyFollowing();
		return SemanticRegionNullFinder.INSTANCE;
	}

	@Override
	public ISemanticRegionFinder immediatelyPreceding(EObject owner) {
		AbstractEObjectRegion region = regionForEObject(owner);
		if (region != null)
			return region.immediatelyPreceding();
		return SemanticRegionNullFinder.INSTANCE;
	}

	protected Map<? extends EObject, ? extends AbstractEObjectRegion> initMap() {
		return null;
	}

	@Override
	public boolean isMultiline(EObject object) {
		AbstractEObjectRegion tokens = regionForEObject(object);
		if (tokens == null)
			return false;
		return tokens.isMultiline();
	}

	@Override
	public IHiddenRegion previousHiddenRegion(EObject owner) {
		AbstractEObjectRegion tokens = regionForEObject(owner);
		if (tokens == null)
			return null;
		return tokens.getLeadingHiddenRegion();
	}

	@Override
	public ISemanticRegionsFinder regionFor(EObject object) {
		AbstractEObjectRegion region = regionForEObject(object);
		if (region != null)
			return region.getRegionFor();
		else
			return SemanticRegionNullFinder.INSTANCE;
	}

	@Override
	public abstract AbstractEObjectRegion regionForEObject(EObject object);

	@Override
	public ILineRegion regionForLineAtOffset(int offset) {
		String text = getText();
		if (offset < 0 || offset > text.length())
			return null;
		int start = text.lastIndexOf('\n', offset) + 1;
		if (start < 0)
			start = 0;
		int end = text.indexOf('\n', offset + 1);
		if (end > 0) {
			if (text.charAt(end - 1) == '\r')
				end = end - 1;
		} else
			end = text.length();
		return new LineRegion(this, start, end - start);
	}

	@Override
	public ITextSegment regionForOffset(int offset, int length) {
		return new TextSegment(this, offset, length);
	}

	@Override
	public String toString() {
		return new TextRegionAccessToString().withRegionAccess(this).toString();
	}

	@Override
	public IHiddenRegion nextHiddenRegion(EObject owner) {
		AbstractEObjectRegion tokens = regionForEObject(owner);
		if (tokens == null)
			return null;
		return tokens.getTrailingHiddenRegion();
	}

}
