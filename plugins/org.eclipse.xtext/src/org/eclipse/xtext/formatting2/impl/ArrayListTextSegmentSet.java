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

import org.eclipse.xtext.formatting2.IMerger;
import org.eclipse.xtext.formatting2.ITextSegment;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ArrayListTextSegmentSet<T extends ITextSegment> extends TextSegmentSet<T> {

	private final List<T> contents = Lists.newArrayList();

	@Override
	public List<T> add(T segment, IMerger<T> merger) {
		Preconditions.checkNotNull(segment);
		getTraces().put(segment, new RuntimeException());
		if (contents.isEmpty()) {
			contents.add(segment);
		} else {
			int searchResult = Collections.binarySearch(contents, segment, COMPARATOR);
			if (searchResult >= 0)
				return replaceExistingEntry(segment, searchResult, merger);
			else
				return insertAtIndex(segment, -searchResult - 1, merger);
		}
		return Collections.emptyList();
	}

	protected List<T> insertAtIndex(T segment, int newIndex, IMerger<T> merger) {
		List<T> conflicting = null;
		int low = newIndex;
		while (--low >= 0) {
			T item = contents.get(low);
			if (isConflict(item, segment)) {
				if (conflicting == null)
					conflicting = Lists.newArrayList();
				conflicting.add(item);
			} else
				break;
		}
		int high = newIndex - 1;
		while (++high < contents.size()) {
			T item = contents.get(high);
			if (isConflict(item, segment)) {
				if (conflicting == null)
					conflicting = Lists.newArrayList();
				conflicting.add(item);
			} else
				break;
		}
		if (conflicting == null) {
			contents.add(newIndex, segment);
		} else {
			conflicting.add(0, segment);
			T merged = merger != null ? merger.merge(conflicting) : null;
			if (merged != null) {
				for (int i = high - 1; i > low; i--)
					contents.remove(i);
				contents.add(low + 1, merged);
			} else {
				int segmentLengh = segment.getLength();
				int totalLenght = 0;
				for (int i = 1; i < conflicting.size(); i++)
					totalLenght += conflicting.get(i).getLength();
				if (segmentLengh >= totalLenght)
					for (int i = high - 1; i > low; i--)
						contents.remove(i);
				if (segmentLengh > totalLenght)
					contents.add(low + 1, segment);
				return conflicting;
			}
		}
		return Collections.emptyList();
	}

	public Iterator<T> iterator() {
		return Iterables.unmodifiableIterable(contents).iterator();
	}

	protected List<T> replaceExistingEntry(T segment, int index, IMerger<T> merger) {
		T existing = contents.get(index);
		List<T> conflicting = ImmutableList.of(segment, existing);
		T merged = merger != null ? merger.merge(conflicting) : null;
		if (merged != null)
			contents.set(index, merged);
		else {
			contents.remove(index);
			return conflicting;
		}
		return Collections.emptyList();
	}

}
