/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.impl;

import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.TreeSet;

import org.eclipse.xtext.formatting2.FormatterProblemReporter;
import org.eclipse.xtext.formatting2.ITextRegion2;
import org.eclipse.xtext.formatting2.ITextRegionMerger;
import org.eclipse.xtext.formatting2.ITextReplacer.Mergeable;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class RegionSet<T extends ITextRegion2> implements Iterable<T> {

	private final FormatterProblemReporter problemHandler;
	private final ITextRegion2 root;
	private final TreeSet<T> set = new TreeSet<T>();
	private final IdentityHashMap<T, Throwable> traces = new IdentityHashMap<T, Throwable>();
	private final ITextRegionMerger<T> merger;

	public RegionSet(ITextRegion2 root, ITextRegionMerger<T> merger, FormatterProblemReporter problemHandler) {
		super();
		this.root = root;
		this.merger = merger;
		this.problemHandler = problemHandler;
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

	protected void cleanupConflict(T region1, T region2) {
		int length1 = region1.getLength();
		int length2 = region2.getLength();
		if (length1 <= length2)
			set.remove(region1);
		if (length1 >= length2)
			set.remove(region2);
	}

	public void add(T add) {
		Preconditions.checkNotNull(add);
		traces.put(add, new RuntimeException(add.toString()));
		if (!root.contains(add)) {
			problemHandler.handleOutsideOfRegion(this, add);
			return;
		}
		T floor = set.floor(add);
		if (floor != null && isConflict(floor, add)) {
			T merged = merge(floor, add);
			if (merged == null) {
				set.add(add);
				cleanupConflict(floor, add);
				problemHandler.handleMergeConflict(this, floor, add);
				return;
			} else {
				set.remove(floor);
				add = merged;
			}
		}
		T ceiling = set.ceiling(add);
		if (ceiling != null && isConflict(ceiling, add)) {
			T merged = merge(ceiling, add);
			if (merged == null) {
				set.add(add);
				cleanupConflict(ceiling, add);
				problemHandler.handleMergeConflict(this, ceiling, add);
				return;
			} else {
				set.remove(ceiling);
				add = merged;
			}
		}
		set.add(add);
	}

	public FormatterProblemReporter getProblemHandler() {
		return problemHandler;
	}

	public ITextRegion2 getRoot() {
		return root;
	}

	public IdentityHashMap<T, Throwable> getTraces() {
		return traces;
	}

	public Iterator<T> iterator() {
		return ImmutableSet.copyOf(set).iterator();
	}

	@SuppressWarnings("unchecked")
	protected T merge(T oldRegion, T newRegion) {
		if (merger != null)
			return merger.merge(oldRegion, newRegion);
		T merged = null;
		if (newRegion instanceof Mergeable)
			merged = ((Mergeable<T>) newRegion).mergeWith(oldRegion);
		if (merged == null && oldRegion instanceof Mergeable)
			merged = ((Mergeable<T>) oldRegion).mergeWith(newRegion);
		return merged;
	}

	@Override
	public String toString() {
		return new RegionsToString<T>().withRoot(root).apply(this);
	}

}
