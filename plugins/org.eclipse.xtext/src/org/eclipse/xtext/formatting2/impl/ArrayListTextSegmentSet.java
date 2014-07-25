/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.impl;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.xtext.formatting2.FormatterProblemReporter;
import org.eclipse.xtext.formatting2.ITextSegment;
import org.eclipse.xtext.formatting2.ITextSegmentMerger;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ArrayListTextSegmentSet<T extends ITextSegment> extends TextSegmentSet<T> {

	private final List<T> contents = Lists.newArrayList();

	public ArrayListTextSegmentSet(ITextSegment root, ITextSegmentMerger<T> merger,
			FormatterProblemReporter problemHandler) {
		super(root, merger, problemHandler);
	}

	@Override
	public void add(T segment) {
		Preconditions.checkNotNull(segment);
		getTraces().put(segment, new RuntimeException());
		if (segment.getOffset() < getRoot().getOffset() || segment.getEndOffset() > getRoot().getEndOffset()) {
			getProblemHandler().reportOutsideOfRegion(this, segment);
			return;
		}
		if (contents.isEmpty()) {
			contents.add(segment);
			return;
		}
		int search = Collections.binarySearch(contents, segment, COMPARATOR);
		if (search >= 0) {
			T existing = contents.get(search);
			List<T> conflict = ImmutableList.of(segment, existing);
			T merged = merge(conflict);
			if (merged != null)
				contents.set(search, merged);
			else {
				contents.remove(search);
				getProblemHandler().reportMergeConflict(this, conflict);
			}
		} else {
			int newIndex = -search - 1;
			List<T> conflicts = null;
			int low = newIndex;
			while (--low >= 0) {
				T item = contents.get(low);
				if (isConflict(item, segment)) {
					if (conflicts == null)
						conflicts = Lists.newArrayList();
					conflicts.add(item);
				} else
					break;
			}
			int high = newIndex - 1;
			while (++high < contents.size()) {
				T item = contents.get(high);
				if (isConflict(item, segment)) {
					if (conflicts == null)
						conflicts = Lists.newArrayList();
					conflicts.add(item);
				} else
					break;
			}
			if (conflicts == null) {
				contents.add(newIndex, segment);
			} else {
				conflicts.add(0, segment);
				T merged = merge(conflicts);
				if (merged != null) {
					for (int i = high - 1; i > low; i--)
						contents.remove(i);
					contents.add(low + 1, merged);
				} else {
					int segmentLengh = segment.getLength();
					int totalLenght = 0;
					for (T item : conflicts)
						totalLenght += item.getLength();
					if (segmentLengh >= totalLenght)
						for (int i = high - 1; i > low; i--)
							contents.remove(i);
					if (segmentLengh > totalLenght)
						contents.add(low + 1, segment);
					getProblemHandler().reportMergeConflict(this, conflicts);
				}
			}
		}

	}

	public Iterator<T> iterator() {
		return ImmutableList.copyOf(contents).iterator();
	}
}
