/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatter.impl;

import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.xtext.formatter.ITextRegion;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class RegionsToString<T extends ITextRegion> implements Function<Iterable<? extends T>, String> {

	private Function<? super T, String> regionToString = Functions.toStringFunction();
	private ITextRegion root = null;

	public String apply(Iterable<? extends T> input) {
		ArrayList<T> list = Lists.newArrayList(input);
		if (list.isEmpty())
			return root == null ? "(empty)" : root.getText();
		Collections.sort(list);
		if (root == null)
			root = (ITextRegion) list.get(0).getTokenAccess();
		String text = root.getText();
		int lastOffset = 0;
		StringBuilder result = new StringBuilder();
		for (T r : list) {
			int offset = r.getOffset() - root.getOffset();
			result.append(text.substring(lastOffset, offset));
			result.append(regionToString.apply(r));
			lastOffset = offset + r.getLength();
		}
		result.append(text.substring(lastOffset, text.length()));
		return result.toString();
	}

	public RegionsToString<T> withRegionToString(Function<? super T, String> regionToString) {
		this.regionToString = regionToString;
		return this;
	}

	public RegionsToString<T> withRoot(ITextRegion root) {
		this.root = root;
		return this;
	}

}
