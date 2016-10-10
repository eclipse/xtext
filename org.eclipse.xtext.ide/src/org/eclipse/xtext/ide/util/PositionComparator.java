/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.util;

import static com.google.common.collect.ComparisonChain.*;

import java.util.Comparator;

import com.google.common.collect.Ordering;
import com.google.inject.Singleton;

import io.typefox.lsapi.Position;

/**
 * Null-safe comparator for {@link Position position} instances.
 * 
 * <p>
 * Compares {@link Position#getLine() lines} first, then
 * {@link Position#getCharacter() character offsets}.
 * 
 * @author akos.kitta - Initial contribution and API
 */
@Singleton
public class PositionComparator implements Comparator<Position> {

	private final Comparator<Position> delegate;

	/**
	 * Sole constructor. Creates a new comparator for {@link Position position}
	 * instances.
	 */
	public PositionComparator() {
		delegate = (left, right) -> start().compare(left.getLine(), right.getLine())
				.compare(left.getCharacter(), right.getCharacter()).result();
	}

	@Override
	public int compare(final Position left, final Position right) {
		return Ordering.from(delegate).nullsLast().compare(left, right);
	}

}
