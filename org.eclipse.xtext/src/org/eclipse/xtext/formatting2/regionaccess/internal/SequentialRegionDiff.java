/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import org.eclipse.xtext.formatting2.regionaccess.ISequentialRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegmentDiff;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SequentialRegionDiff implements Comparable<SequentialRegionDiff>, ITextSegmentDiff {
	private final ISequentialRegion originalFirst;
	private final ISequentialRegion originalLast;
	private final ISequentialRegion substituteFirst;
	private final ISequentialRegion substituteLast;

	public SequentialRegionDiff(ISequentialRegion originalFirst, ISequentialRegion originalLast) {
		this(originalFirst, originalLast, null, null);
	}

	public SequentialRegionDiff(ISequentialRegion originalFirst, ISequentialRegion originalLast,
			ISequentialRegion substituteFirst, ISequentialRegion substituteLast) {
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
	public ISequentialRegion getModifiedFirstRegion() {
		return this.substituteFirst;
	}

	@Override
	public ISequentialRegion getModifiedLastRegion() {
		return this.substituteLast;
	}

	@Override
	public ISequentialRegion getOriginalFirstRegion() {
		return this.originalFirst;
	}

	@Override
	public ISequentialRegion getOriginalLastRegion() {
		return this.originalLast;
	}

}