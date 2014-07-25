/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatter.impl;

import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.TreeSet;

import org.eclipse.xtext.formatter.IFormatter.ProblemHandler;
import org.eclipse.xtext.formatter.ITextRegion;
import org.eclipse.xtext.formatter.ITextReplacer.Mergeable;

import com.google.common.base.Preconditions;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class RegionSet<T extends ITextRegion> implements Iterable<T> {

	private final ProblemHandler problemHandler;
	private final ITextRegion root;
	private final TreeSet<T> set = new TreeSet<T>();
	private final IdentityHashMap<T, Throwable> traces = new IdentityHashMap<T, Throwable>();

	public RegionSet(ITextRegion root, ProblemHandler problemHandler) {
		super();
		this.root = root;
		this.problemHandler = problemHandler;
	}

	public void add(T add) {
		Preconditions.checkNotNull(add);
		Preconditions.checkArgument(add.getTokenAccess() == root.getTokenAccess());
		traces.put(add, new RuntimeException(add.toString()));
		if (add.getOffset() < root.getOffset() || add.getEndOffset() > root.getEndOffset()) {
			problemHandler.handleOutsideOfRegion(this, add);
			return;
		}
		T floor = set.floor(add);
		if (floor != null && (floor.getEndOffset() > add.getOffset() || floor.getOffset() == add.getOffset())) {
			T merged = merge(floor, add);
			if (merged == null) {
				problemHandler.handleMergeConflict(this, floor, add);
				return;
			} else {
				set.remove(floor);
				add = merged;
			}
		}
		T ceiling = set.ceiling(add);
		if (ceiling != null && (ceiling.getOffset() < add.getEndOffset() || ceiling.getOffset() == add.getOffset())) {
			T merged = merge(ceiling, add);
			if (merged == null) {
				problemHandler.handleMergeConflict(this, ceiling, add);
				return;
			} else {
				set.remove(ceiling);
				add = merged;
			}
		}
		set.add(add);
	}

	public ProblemHandler getProblemHandler() {
		return problemHandler;
	}

	public ITextRegion getRoot() {
		return root;
	}

	public IdentityHashMap<T, Throwable> getTraces() {
		return traces;
	}

	public Iterator<T> iterator() {
		return set.iterator();
	}

	@SuppressWarnings("unchecked")
	protected T merge(T oldRegion, T newRegion) {
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
