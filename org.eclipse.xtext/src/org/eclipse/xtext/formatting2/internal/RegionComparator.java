/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import java.util.Comparator;

import org.eclipse.xtext.util.ITextRegion;

import com.google.common.base.Function;

public class RegionComparator<T> implements Comparator<T> {
	private final Function<? super T, ? extends ITextRegion> regionAccess;

	public RegionComparator(Function<? super T, ? extends ITextRegion> regionAccess) {
		super();
		this.regionAccess = regionAccess;
	}

	public Function<? super T, ? extends ITextRegion> getRegionAccess() {
		return regionAccess;
	}

	@Override
	public int compare(T t1, T t2) {
		ITextRegion o1 = regionAccess.apply(t1);
		ITextRegion o2 = regionAccess.apply(t2);
		int cmp1 = o1.getOffset() - o2.getOffset();
		if (cmp1 != 0)
			return cmp1;
		int cmp2 = o1.getLength() - o2.getLength();
		if (cmp2 != 0)
			return cmp2;
		return 0;
	}
}