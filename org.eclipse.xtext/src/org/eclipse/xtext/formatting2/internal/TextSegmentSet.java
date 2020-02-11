/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.xtext.formatting2.IMerger;
import org.eclipse.xtext.formatting2.debug.TextRegionsToString;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class TextSegmentSet<T> implements Iterable<T> {

	private final Function<? super T, ? extends ITextSegment> regionGetter;
	private final Function<? super T, String> titleGetter;
	private final IdentityHashMap<T, RegionTrace> traces;

	public TextSegmentSet(Function<? super T, ? extends ITextSegment> region, Function<? super T, String> title) {
		this(region, title, true);
	}

	public TextSegmentSet(Function<? super T, ? extends ITextSegment> region, Function<? super T, String> title,
			boolean trace) {
		super();
		this.regionGetter = region;
		this.titleGetter = title;
		this.traces = trace ? new IdentityHashMap<T, RegionTrace>() : null;
	}

	public void add(T segment) throws ConflictingRegionsException, RegionTraceMissingException {
		add(segment, null);
	}

	public abstract void add(T segment, IMerger<T> merger) throws ConflictingRegionsException;

	public abstract T get(T segment);

	protected ITextSegment getRegion(T t) {
		return regionGetter.apply(t);
	}

	public Function<? super T, ? extends ITextSegment> getRegionAccess() {
		return regionGetter;
	}

	protected String getTitle(T t) {
		return titleGetter.apply(t);
	}

	@Deprecated
	public IdentityHashMap<T, RegionTrace> getTraces() {
		return traces;
	}

	protected void handleConflict(List<T> conflicts, Exception cause)
			throws ConflictingRegionsException, RegionTraceMissingException {
		if (traces == null) {
			throw new RegionTraceMissingException(cause);
		}
		List<RegionTrace> causes = Lists.newArrayList();
		for (T t : conflicts) {
			RegionTrace exception = traces.get(t);
			if (exception != null)
				causes.add(exception);
		}
		throw new ConflictingRegionsException("Conflicting Regions", cause, causes);
	}

	protected boolean isConflict(ITextSegment region1, ITextSegment region2) {
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

	protected boolean isConflict(T t1, T t2) {
		return isConflict(getRegion(t1), getRegion(t2));
	}

	public abstract Iterator<T> iteratorAfter(T segment);

	/**
	 * @since 2.13
	 */
	public abstract Iterable<T> reverseIterable();

	@Override
	public String toString() {
		TextRegionsToString toString = new TextRegionsToString();
		toString.setTitle(getClass().getSimpleName());
		for (T t : this)
			toString.add(getRegion(t), getTitle(t));
		return toString.toString();
	}

	protected void trace(T segment) {
		if (traces != null) {
			traces.put(segment, new RegionTrace(getTitle(segment), getRegion(segment)));
		}
	}
}
