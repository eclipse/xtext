/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import java.util.LinkedList;

import org.eclipse.jdt.annotation.NonNullByDefault;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
@NonNullByDefault
public class LeafIterator extends AbstractIterator<AbstractTraceRegion> {

	/**
	 * A trace region that will not be added to the child list of the given parent.
	 */
	protected static class TemporaryTraceRegion extends AbstractStatefulTraceRegion {
		protected TemporaryTraceRegion(int fromOffset, int fromLength, int toOffset, int toLength,
				AbstractTraceRegion parent) {
			super(fromOffset, fromLength, toOffset, toLength, parent);
		}

		@Override
		protected void setAsChildIn(AbstractTraceRegion parent) {
			// we don't want to add temporary regions to the parent's child list
		}
	}

	private AbstractTraceRegion current;
	private int expectedOffset;
	private LinkedList<Integer> traversalIndizes = Lists.newLinkedList();

	public LeafIterator(AbstractTraceRegion root) {
		current = root;
		expectedOffset = root.getFromOffset();
	}
	
	@Override
	protected AbstractTraceRegion computeNext() {
		if (current.getFromOffset() == expectedOffset) {
			return firstLeafOfCurrent();
		} else {
			if (current.getNestedRegions().isEmpty()) 
				current = current.getParent();
			int idx = traversalIndizes.removeLast();
			while(idx == current.getNestedRegions().size() - 1) {
				if (expectedOffset != current.getFromOffset() + current.getFromLength()) {
					traversalIndizes.add(idx);
					AbstractTraceRegion result = new TemporaryTraceRegion(expectedOffset, current.getFromOffset() + current.getFromLength() - expectedOffset, current.getToOffset(), current.getToLength(), current);
					expectedOffset = current.getFromOffset() + current.getFromLength();
					return result;
				}
				if (traversalIndizes.isEmpty())
					return endOfData();
				current = current.getParent();
				idx = traversalIndizes.removeLast();
			}
			if (idx < current.getNestedRegions().size() - 1) {
				AbstractTraceRegion next = current.getNestedRegions().get(idx + 1);
				if (next.getFromOffset() == expectedOffset) {
					current = next;
					traversalIndizes.add(idx + 1);
					return firstLeafOfCurrent();
				} else {
					final AbstractTraceRegion parent = current;
					AbstractTraceRegion result = new TemporaryTraceRegion(expectedOffset, next.getFromOffset() - expectedOffset, current.getToOffset(), current.getToLength(), parent);
					traversalIndizes.add(idx);
					expectedOffset = next.getFromOffset();
					return result;
				}
			}
		}
		return endOfData();
	}

	protected AbstractTraceRegion firstLeafOfCurrent() {
		while(!current.getNestedRegions().isEmpty()) {
			AbstractTraceRegion next = current.getNestedRegions().get(0);
			if (next.getFromOffset() != current.getFromOffset()) {
				AbstractTraceRegion result = new TemporaryTraceRegion(current.getFromOffset(), next.getFromOffset() - current.getFromOffset(), current.getToOffset(), current.getToLength(), current);
				traversalIndizes.add(-1);
				expectedOffset = next.getFromOffset();
				return result;
			}
			traversalIndizes.add(0);
			current = next;
		}
		expectedOffset = current.getFromOffset() + current.getFromLength();
		return current;
	}
}