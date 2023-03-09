/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.xtext.formatting2.IMerger;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ArrayListTextSegmentSet<T> extends TextSegmentSet<T> {

	private final List<T> contents = Lists.newArrayList();

	public ArrayListTextSegmentSet(Function<? super T, ? extends ITextSegment> region,
			Function<? super T, String> title) {
		super(region, title);
	}

	public ArrayListTextSegmentSet(Function<? super T, ? extends ITextSegment> region,
			Function<? super T, String> title, boolean trace) {
		super(region, title, trace);
	}

	@Override
	public void add(T segment, IMerger<T> merger) throws ConflictingRegionsException, RegionTraceMissingException {
		Preconditions.checkNotNull(segment);
		trace(segment);
		if (contents.isEmpty()) {
			contents.add(segment);
		} else {
			int searchResult = Collections.binarySearch(contents, segment, new RegionComparator<T>(getRegionAccess()));
			if (searchResult >= 0)
				replaceExistingEntry(segment, searchResult, merger);
			else
				insertAtIndex(segment, -searchResult - 1, merger);
		}
	}

	@Override
	public T get(T segment) {
		int searchResult = Collections.binarySearch(contents, segment, new RegionComparator<T>(getRegionAccess()));
		return searchResult >= 0 ? contents.get(searchResult) : null;
	}

	protected void insertAtIndex(T segment, int newIndex, IMerger<T> merger)
			throws ConflictingRegionsException, RegionTraceMissingException {
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
			trace(segment);
			contents.add(newIndex, segment);
		} else {
			conflicting.add(0, segment);
			try {
				T merged = merger != null ? merger.merge(conflicting) : null;
				if (merged != null) {
					for (int i = high - 1; i > low; i--)
						contents.remove(i);
					trace(merged);
					contents.add(low + 1, merged);
				} else {
					int segmentLengh = getRegion(segment).getLength();
					int totalLength = 0;
					for (int i = 1; i < conflicting.size(); i++)
						totalLength += getRegion(conflicting.get(i)).getLength();
					if (segmentLengh >= totalLength)
						for (int i = high - 1; i > low; i--)
							contents.remove(i);
					if (segmentLengh > totalLength) {
						trace(segment);
						contents.add(low + 1, segment);
					}
					handleConflict(conflicting, null);
				}
			} catch (ConflictingRegionsException e) {
				throw e;
			} catch (Exception e) {
				handleConflict(conflicting, e);
			}
		}
	}

	@Override
	public Iterator<T> iterator() {
		return Iterables.unmodifiableIterable(contents).iterator();
	}

	@Override
	public Iterator<T> iteratorAfter(T segment) {
		int searchResult = 1 + Collections.binarySearch(contents, segment, new RegionComparator<T>(getRegionAccess()));
		if (searchResult < 1) {
			return Collections.emptyIterator();
		}
		return new AbstractIterator<T>() {
			private int index = searchResult;

			@Override
			protected T computeNext() {
				if (index >= contents.size())
					return endOfData();
				return contents.get(index++);
			}
		};
	}

	@Override
	public Iterable<T> reverseIterable() {
		return new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				return new AbstractIterator<T>() {
					private int index = contents.size() - 1;

					@Override
					protected T computeNext() {
						if (index < 0)
							return endOfData();
						return contents.get(index--);
					}
				};
			}
		};
	}

	protected void replaceExistingEntry(T segment, int index, IMerger<T> merger)
			throws ConflictingRegionsException, RegionTraceMissingException {
		T existing = contents.get(index);
		List<T> conflicting = ImmutableList.of(segment, existing);
		try {
			T merged = merger != null ? merger.merge(conflicting) : null;
			if (merged != null) {
				trace(merged);
				contents.set(index, merged);
			} else {
				contents.remove(index);
				handleConflict(conflicting, null);
			}
		} catch (ConflictingRegionsException e) {
			throw e;
		} catch (Exception e) {
			handleConflict(conflicting, e);
		}
	}

}
