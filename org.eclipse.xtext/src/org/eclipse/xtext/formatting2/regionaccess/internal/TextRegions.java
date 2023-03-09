/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.eclipse.xtext.formatting2.regionaccess.ILineRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.util.ITextRegion;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.9
 */
public class TextRegions {

	private static enum Comp implements Comparator<ITextRegion> {
		INSTANCE;

		@Override
		public int compare(ITextRegion o1, ITextRegion o2) {
			int cmp1 = o1.getOffset() - o2.getOffset();
			if (cmp1 != 0)
				return cmp1;
			int cmp2 = o1.getLength() - o2.getLength();
			if (cmp2 != 0)
				return cmp2;
			return 0;
		}
	}

	public static <T extends ITextRegion> List<T> difference(Iterable<T> r1, Iterable<? extends ITextRegion> r2) {
		ArrayList<T> regions1 = Lists.newArrayList(r1);
		ArrayList<ITextRegion> regions2 = Lists.newArrayList(r2);
		Collections.sort(regions1, Comp.INSTANCE);
		Collections.sort(regions2, Comp.INSTANCE);
		List<T> missing = Lists.newArrayList();
		int i1 = 0, i2 = 0;
		while (i1 < regions1.size() && i2 < regions2.size()) {
			T t1 = regions1.get(i1);
			ITextRegion t2 = regions2.get(i2);
			int compareTo = Comp.INSTANCE.compare(t1, t2);
			if (compareTo == 0) {
				i1++;
				i2++;
			} else if (compareTo < 1) {
				missing.add(t1);
				i1++;
			} else {
				i2++;
			}
		}
		while (i1 < regions1.size()) {
			missing.add(regions1.get(i1));
			i1++;
		}
		return ImmutableList.copyOf(missing);
	}

	public static ITextSegment merge(Iterable<? extends ITextSegment> segments) {
		Iterator<? extends ITextSegment> it = segments.iterator();
		if (!it.hasNext())
			throw new IllegalStateException();
		ITextSegment first = it.next();
		int minOffset = first.getOffset();
		int maxEndOffset = first.getEndOffset();
		while (it.hasNext()) {
			ITextSegment next = it.next();
			int offset = next.getOffset();
			int endOffset = next.getEndOffset();
			if (offset < minOffset)
				minOffset = offset;
			if (endOffset > maxEndOffset)
				maxEndOffset = endOffset;
		}
		return new TextSegment(first.getTextRegionAccess(), minOffset, maxEndOffset - minOffset);
	}

	public static List<ILineRegion> expandToLines(ITextSegment segment, int leadingLinesToAdd, int trailingLinesToAdd) {
		List<ILineRegion> lines = Lists.newArrayList(segment.getLineRegions());
		for (int i = 1; i < leadingLinesToAdd; i++) {
			ILineRegion line = lines.get(0).getPreviousLine();
			if (line != null)
				lines.add(0, line);
		}
		for (int i = 1; i < trailingLinesToAdd; i++) {
			ILineRegion line = lines.get(lines.size() - 1).getNextLine();
			if (line != null)
				lines.add(line);
		}
		return lines;
	}

}
