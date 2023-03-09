/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.util;

import java.util.Comparator;

import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;

import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import static com.google.common.collect.ComparisonChain.*;

/**
 * Null-safe comparator for {@link Range range} instances.
 * 
 * <p>
 * Compares {@link Range#getStart() start positions} first, then
 * {@link Range#getEnd() end positions}.
 * 
 * @author akos.kitta - Initial contribution and API
 * 
 * @see PositionComparator
 */
@Singleton
public class RangeComparator implements Comparator<Range> {

	private final Comparator<Range> delegate;

	/**
	 * Creates a new range comparator with the give comparator delegate for
	 * {@link Position positions}.
	 * 
	 * @param positionComparator
	 *            the delegate comparator for the positions. Cannot be
	 *            {@code null}.
	 */
	@Inject
	public RangeComparator(final PositionComparator positionComparator) {
		Preconditions.checkNotNull(positionComparator, "positionComparator");
		
		delegate = (left, right) -> start().compare(left.getStart(), right.getStart(), positionComparator)
				.compare(left.getEnd(), right.getEnd(), positionComparator).result();
	}

	@Override
	public int compare(final Range left, final Range right) {
		return Ordering.from(delegate).nullsLast().compare(left, right);
	}

}
