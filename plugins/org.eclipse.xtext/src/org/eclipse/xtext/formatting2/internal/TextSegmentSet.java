/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.List;

import org.eclipse.xtext.formatting2.IMerger;
import org.eclipse.xtext.formatting2.ITextSegment;
import org.eclipse.xtext.util.ITextRegion;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class TextSegmentSet<T extends ITextSegment> implements Iterable<T> {

	protected final static Comparator<? super ITextRegion> COMPARATOR = new Comparator<ITextRegion>() {
		public int compare(ITextRegion o1, ITextRegion o2) {
			int cmp1 = o1.getOffset() - o2.getOffset();
			if (cmp1 != 0)
				return cmp1;
			int cmp2 = o1.getLength() - o2.getLength();
			if (cmp2 != 0)
				return cmp2;
			return 0;
		}
	};

	private final IdentityHashMap<T, Throwable> traces = new IdentityHashMap<T, Throwable>();

	public List<T> add(T segment) {
		return add(segment, null);
	}

	public abstract List<T> add(T segment, IMerger<T> merger);

	public IdentityHashMap<T, Throwable> getTraces() {
		return traces;
	}

	protected boolean isConflict(T region1, T region2) {
		int offset1 = region1.getOffset();
		int length1 = region1.getLength();
		int offset2 = region2.getOffset();
		int length2 = region2.getLength();
		if (offset1 < offset2) {
			return offset1 + length1 > offset2;
		} else if (offset1 > offset2) {
			return offset2 + length2 > offset1;
		}
		return !(length1 == 0 ^ length2 == 0);
	}

	@Override
	public String toString() {
		return new RegionsToString<ITextSegment>().apply(this);
	}

}
