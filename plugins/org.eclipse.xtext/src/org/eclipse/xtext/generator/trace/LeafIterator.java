/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import java.util.LinkedList;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LeafIterator extends AbstractIterator<ITraceRegion> {
	private ITraceRegion current;
	private int expectedOffset;
	private LinkedList<Integer> traversalIndizes = Lists.newLinkedList();

	public LeafIterator(ITraceRegion root) {
		current = root;
		expectedOffset = root.getFromOffset();
	}
	
	@Override
	protected ITraceRegion computeNext() {
		if (current.getFromOffset() == expectedOffset) {
			return firstLeafOfCurrent();
		} else {
			if (current.getNestedRegions().isEmpty()) 
				current = current.getParent();
			int idx = traversalIndizes.removeLast();
			while(idx == current.getNestedRegions().size() - 1) {
				if (expectedOffset != current.getFromOffset() + current.getFromLength()) {
					traversalIndizes.add(idx);
					ITraceRegion result = new AbstractStatefulTraceRegion(expectedOffset, current.getFromOffset() + current.getFromLength() - expectedOffset, current.getToOffset(), current.getToLength()) {
						public ITraceRegion getParent() {
							return current;
						}
					};
					expectedOffset = current.getFromOffset() + current.getFromLength();
					return result;
				}
				if (traversalIndizes.isEmpty())
					return endOfData();
				current = current.getParent();
				idx = traversalIndizes.removeLast();
			}
			if (idx < current.getNestedRegions().size() - 1) {
				ITraceRegion next = current.getNestedRegions().get(idx + 1);
				if (next.getFromOffset() == expectedOffset) {
					current = next;
					traversalIndizes.add(idx + 1);
					return firstLeafOfCurrent();
				} else {
					final ITraceRegion parent = current;
					ITraceRegion result = new AbstractStatefulTraceRegion(expectedOffset, next.getFromOffset() - expectedOffset, current.getToOffset(), current.getToLength()) {
						public ITraceRegion getParent() {
							return parent;
						}
					};
					traversalIndizes.add(idx);
					expectedOffset = next.getFromOffset();
					return result;
				}
			}
		}
		return endOfData();
	}

	protected ITraceRegion firstLeafOfCurrent() {
		while(!current.getNestedRegions().isEmpty()) {
			ITraceRegion next = current.getNestedRegions().get(0);
			if (next.getFromOffset() != current.getFromOffset()) {
				ITraceRegion result = new AbstractStatefulTraceRegion(current.getFromOffset(), next.getFromOffset() - current.getFromOffset(), current.getToOffset(), current.getToLength()) {
					public ITraceRegion getParent() {
						return current;
					}
				};
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