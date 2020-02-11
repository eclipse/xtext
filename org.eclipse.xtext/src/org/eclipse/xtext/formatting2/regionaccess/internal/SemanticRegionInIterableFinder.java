/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SemanticRegionInIterableFinder extends AbstractSemanticRegionsFinder {

	private final Iterable<ISemanticRegion> regions;

	public SemanticRegionInIterableFinder(Iterable<ISemanticRegion> regions) {
		super();
		this.regions = regions;
	}

	@Override
	protected ImmutableList<ISemanticRegion> findAll(Predicate<ISemanticRegion> predicate) {
		Builder<ISemanticRegion> builder = ImmutableList.builder();
		for (ISemanticRegion region : regions)
			if (predicate.apply(region))
				builder.add(region);
		return builder.build();
	}

	@Override
	protected ISemanticRegion findFirst(Predicate<ISemanticRegion> predicate) {
		for (ISemanticRegion region : regions)
			if (predicate.apply(region))
				return region;
		return null;
	}
}
