/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import java.util.Iterator;

import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;

import com.google.common.collect.AbstractIterator;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SemanticRegionIterable implements Iterable<ISemanticRegion> {

	private final ISemanticRegion first;
	private final ISemanticRegion last;

	public SemanticRegionIterable(ISemanticRegion first, ISemanticRegion last) {
		super();
		this.first = first;
		this.last = last;
	}

	@Override
	public Iterator<ISemanticRegion> iterator() {
		return new AbstractIterator<ISemanticRegion>() {
			private ISemanticRegion next = first;

			@Override
			protected ISemanticRegion computeNext() {
				if (next == null)
					return endOfData();
				ISemanticRegion result = next;
				next = next.getNextSemanticRegion();
				if (result == last)
					next = null;
				return result;
			}
		};
	}
}
