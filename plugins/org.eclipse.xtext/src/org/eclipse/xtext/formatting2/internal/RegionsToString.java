/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.formatting2.ITextSegment;
import org.eclipse.xtext.util.ITextRegion;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class RegionsToString<T> implements Function<Iterable<? extends T>, String> {

	private final class CastToRegion implements Function<T, ITextRegion> {
		public ITextRegion apply(T input) {
			return (ITextRegion) input;
		}
	}

	private Function<? super T, ? extends ITextRegion> regionAccess = new CastToRegion();
	private Function<? super T, String> regionToString = Functions.toStringFunction();
	private ITextSegment root = null;

	public String apply(Iterable<? extends T> input) {
		if (root == null || root.getTextRegionAccess() == null)
			return applyAsList(input);
		else
			return applyAsReplacements(input);
	}

	public String applyAsList(Iterable<? extends T> input) {
		List<String> result = Lists.newArrayList();
		for (T i : input) {
			ITextRegion region = regionAccess.apply(i);
			result.add(String.format("[%d,%d]", region.getOffset(), region.getLength()));
		}
		return Joiner.on('\n').join(result);
	}

	public String applyAsReplacements(Iterable<? extends T> input) {
		ArrayList<T> list = Lists.newArrayList(input);
		if (list.isEmpty())
			return root == null ? "(empty)" : root.getText();
		Collections.sort(list, new RegionComparator<T>(regionAccess));
		if (root == null)
			root = (ITextSegment) ((ITextSegment) regionAccess.apply(list.get(0))).getTextRegionAccess();
		String text = root.getText();
		int lastOffset = 0;
		StringBuilder result = new StringBuilder();
		for (T r : list) {
			ITextRegion region = regionAccess.apply(r);
			int offset = region.getOffset() - root.getOffset();
			result.append(text.substring(lastOffset, offset));
			result.append(regionToString.apply(r));
			lastOffset = offset + region.getLength();
		}
		result.append(text.substring(lastOffset, text.length()));
		return result.toString();
	}

	public RegionsToString<T> withRegionAccess(Function<? super T, ? extends ITextRegion> regionAccess) {
		this.regionAccess = regionAccess;
		return this;
	}

	public RegionsToString<T> withRegionToString(Function<? super T, String> regionToString) {
		this.regionToString = regionToString;
		return this;
	}

	public RegionsToString<T> withRoot(ITextSegment root) {
		this.root = root;
		return this;
	}

}
