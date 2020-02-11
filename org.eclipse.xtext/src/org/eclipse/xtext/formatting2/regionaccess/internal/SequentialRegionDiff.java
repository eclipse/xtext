/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISequentialRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegmentDiff;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SequentialRegionDiff implements Comparable<SequentialRegionDiff>, ITextSegmentDiff {
	private final ITextSegment originalFirst;
	private final ITextSegment originalLast;
	private final ITextSegment substituteFirst;
	private final ITextSegment substituteLast;

	public SequentialRegionDiff(ISequentialRegion originalFirst, ISequentialRegion originalLast) {
		this(originalFirst, originalLast, null, null);
	}

	public SequentialRegionDiff(ITextSegment originalFirst, ITextSegment originalLast, ITextSegment substituteFirst,
			ITextSegment substituteLast) {
		super();
		this.originalFirst = originalFirst;
		this.originalLast = originalLast;
		this.substituteFirst = substituteFirst;
		this.substituteLast = substituteLast;
	}

	@Override
	public int compareTo(SequentialRegionDiff o) {
		return originalFirst.compareTo(o.originalFirst);
	}

	@Override
	public ITextSegment getModifiedFirstRegion() {
		return this.substituteFirst;
	}

	@Override
	public ITextSegment getModifiedLastRegion() {
		return this.substituteLast;
	}

	@Override
	public ITextSegment getModifiedRegion() {
		if (isSingleSemanticRegion()) {
			return substituteFirst;
		}
		return getRegion(substituteFirst, substituteLast);
	}

	@Override
	public ITextSegment getOriginalFirstRegion() {
		return this.originalFirst;
	}

	@Override
	public ITextSegment getOriginalLastRegion() {
		return this.originalLast;
	}

	@Override
	public ITextSegment getOriginalRegion() {
		if (isSingleSemanticRegion()) {
			return originalFirst;
		}
		return getRegion(originalFirst, originalLast);
	}

	protected ITextSegment getRegion(ITextSegment first, ITextSegment last) {
		int offset = first instanceof IHiddenRegion ? first.getOffset() : first.getEndOffset();
		int endOffset = last instanceof IHiddenRegion ? last.getEndOffset() : last.getOffset();
		return first.getTextRegionAccess().regionForOffset(offset, endOffset - offset);
	}

	protected boolean isSingleSemanticRegion() {
		return originalFirst == originalLast && substituteFirst == substituteLast
				&& originalFirst instanceof ISemanticRegion && substituteFirst instanceof ISemanticRegion;
	}

}