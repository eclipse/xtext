/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import java.util.LinkedList;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
public class LeafIterator extends AbstractIterator<AbstractTraceRegion> {

	private AbstractTraceRegion current;
	private int expectedOffset;
	private int expectedLine;
	private LinkedList<Integer> traversalIndizes = Lists.newLinkedList();

	public LeafIterator(AbstractTraceRegion root) {
		current = root;
		expectedOffset = root.getMyOffset();
		expectedLine = root.getMyLineNumber();
	}
	
	@Override
	protected AbstractTraceRegion computeNext() {
		if (current.getMyOffset() == expectedOffset) {
			return firstLeafOfCurrent();
		} else {
			if (current.getNestedRegions().isEmpty()) 
				current = current.getParent();
			int idx = traversalIndizes.removeLast();
			while(idx == current.getNestedRegions().size() - 1) {
				if (expectedOffset != current.getMyOffset() + current.getMyLength()) {
					traversalIndizes.add(idx);
					AbstractTraceRegion result = new TemporaryTraceRegion(
							expectedOffset, current.getMyOffset() + current.getMyLength() - expectedOffset,
							expectedLine, current.getMyEndLineNumber(),
							current.isUseForDebugging(),
							current.getAssociatedLocations(), current);
					expectedOffset = current.getMyOffset() + current.getMyLength();
					expectedLine = current.getMyEndLineNumber();
					return result;
				}
				if (traversalIndizes.isEmpty())
					return endOfData();
				current = current.getParent();
				idx = traversalIndizes.removeLast();
			}
			if (idx < current.getNestedRegions().size() - 1) {
				AbstractTraceRegion next = current.getNestedRegions().get(idx + 1);
				if (next.getMyOffset() < expectedOffset) {
					return endOfData();
				} else if (next.getMyOffset() == expectedOffset) {
					current = next;
					traversalIndizes.add(idx + 1);
					return firstLeafOfCurrent();
				} else {
					final AbstractTraceRegion parent = current;
					AbstractTraceRegion result = new TemporaryTraceRegion(
							expectedOffset, next.getMyOffset() - expectedOffset,
							expectedLine, next.getMyLineNumber(),
							current.isUseForDebugging(),
							current.getAssociatedLocations(), parent);
					traversalIndizes.add(idx);
					expectedOffset = next.getMyOffset();
					expectedLine = next.getMyLineNumber();
					return result;
				}
			}
		}
		return endOfData();
	}

	protected AbstractTraceRegion firstLeafOfCurrent() {
		while(!current.getNestedRegions().isEmpty()) {
			AbstractTraceRegion next = current.getNestedRegions().get(0);
			if (next.getMyOffset() != current.getMyOffset()) {
				AbstractTraceRegion result = new TemporaryTraceRegion(
						current.getMyOffset(), next.getMyOffset() - current.getMyOffset(),
						current.getMyLineNumber(), next.getMyLineNumber(),
						current.isUseForDebugging(),
						current.getAssociatedLocations(), current);
				traversalIndizes.add(-1);
				expectedOffset = next.getMyOffset();
				expectedLine = next.getMyLineNumber();
				return result;
			}
			traversalIndizes.add(0);
			current = next;
		}
		expectedOffset = current.getMyOffset() + current.getMyLength();
		expectedLine = current.getMyEndLineNumber();
		return current;
	}
}