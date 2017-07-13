/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.formatting2.debug.TextRegionAccessToString;
import org.eclipse.xtext.formatting2.regionaccess.IComment;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegionPart;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegionFinder;
import org.eclipse.xtext.formatting2.regionaccess.ISequentialRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.formatting2.regionaccess.IWhitespace;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractHiddenRegion extends AbstractTextSegment implements IHiddenRegion {
	private final ITextRegionAccess access;
	private final List<IHiddenRegionPart> hiddens = Lists.newArrayList();
	private ISemanticRegion next;
	private ISemanticRegion previous;

	protected AbstractHiddenRegion(ITextRegionAccess access) {
		super();
		this.access = access;
	}

	protected void addPart(IHiddenRegionPart part) {
		this.hiddens.add(part);
	}

	protected List<ITextSegment> collectAlternatingSpaceAndComments(boolean includeComments) {
		List<IHiddenRegionPart> parts = getParts();
		if (parts.isEmpty()) {
			return Collections.<ITextSegment> singletonList(this);
		} else {
			ITextSegment last = null;
			List<ITextSegment> result = Lists.newArrayList();
			for (IHiddenRegionPart part : parts) {
				if (part instanceof IWhitespace) {
					if (last == null || last instanceof IComment) {
						result.add(part);
					} else {
						int mergedLength = last.getLength() + part.getLength();
						result.set(result.size() - 1, new TextSegment(access, last.getOffset(), mergedLength));
					}
				} else if (part instanceof IComment) {
					if (last == null || last instanceof IComment) {
						result.add(new TextSegment(access, part.getOffset(), 0));
					}
					if (includeComments)
						result.add(part);
				}
				if (!result.isEmpty())
					last = result.get(result.size() - 1);
			}
			if (last instanceof IComment) {
				result.add(new TextSegment(access, last.getOffset() + last.getLength(), 0));
			}
			return ImmutableList.copyOf(result);
		}
	}

	@Override
	public boolean containsComment() {
		for (IHiddenRegionPart hidden : hiddens)
			if (hidden instanceof IComment)
				return true;
		return false;
	}

	@Override
	public List<ITextSegment> getAlternatingMergedSpaceAndComments() {
		return collectAlternatingSpaceAndComments(true);
	}

	@Override
	public int getLength() {
		if (hiddens.isEmpty())
			return 0;
		int start = hiddens.get(0).getOffset();
		int end = hiddens.get(hiddens.size() - 1).getEndOffset();
		return end - start;
	}

	@Override
	public IHiddenRegion getNextHiddenRegion() {
		return next == null ? null : next.getNextHiddenRegion();
	}

	@Override
	public ISemanticRegion getNextSemanticRegion() {
		return next;
	}
	
	@Override
	public ISequentialRegion getNextSequentialRegion() {
		return next;
	}

	@Override
	public int getOffset() {
		if (hiddens.isEmpty()) {
			if (previous != null)
				return previous.getOffset() + previous.getLength();
			return 0;
		} else {
			return hiddens.get(0).getOffset();
		}
	}

	@Override
	public List<IHiddenRegionPart> getParts() {
		return ImmutableList.<IHiddenRegionPart> copyOf(hiddens);
	}

	@Override
	public IHiddenRegion getPreviousHiddenRegion() {
		return previous == null ? null : previous.getPreviousHiddenRegion();
	}

	@Override
	public ISemanticRegion getPreviousSemanticRegion() {
		return previous;
	}
	
	@Override
	public ISequentialRegion getPreviousSequentialRegion() {
		return previous;
	}

	@Override
	public List<ITextSegment> getMergedSpaces() {
		return collectAlternatingSpaceAndComments(false);
	}

	@Override
	public ITextRegionAccess getTextRegionAccess() {
		return access;
	}

	protected void setNext(ISemanticRegion next) {
		this.next = next;
	}

	protected void setPrevious(ISemanticRegion previous) {
		this.previous = previous;
	}

	@Override
	public String toString() {
		return new TextRegionAccessToString().withOrigin(this).hightlightOrigin().toString();
	}

	@Override
	public ISemanticRegionFinder immediatelyFollowing() {
		return new SemanticRegionMatcher(getNextSemanticRegion());
	}

	@Override
	public ISemanticRegionFinder immediatelyPreceding() {
		return new SemanticRegionMatcher(getPreviousSemanticRegion());
	}
}