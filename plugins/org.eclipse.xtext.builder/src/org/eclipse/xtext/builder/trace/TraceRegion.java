/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.trace;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.URI;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
public class TraceRegion extends AbstractTraceRegion {

	private final URI toPath;
	private final ITraceRegion parent;
	private List<TraceRegion> nestedRegions;
	private final String toProjectName;
	
	public TraceRegion(int fromOffset, int fromLength, int toOffset, int toLength, TraceRegion parent, URI toPath, String toProjectName) {
		super(fromOffset, fromLength, toOffset, toLength);
		this.parent = parent;
		this.toPath = toPath;
		this.toProjectName = toProjectName;
		if (parent != null) {
			if (parent.nestedRegions == null) {
				parent.nestedRegions = Lists.newArrayListWithCapacity(4);
			}
			parent.nestedRegions.add(this);
		} else {
			if (toPath == null) {
				throw new IllegalArgumentException("toPath may not be null");
			}
			if (toProjectName == null) {
				throw new IllegalArgumentException("toProjectName may not be null");
			}
		}
	}

	@Override
	public Iterator<ITraceRegion> leafIterator() {
		if (nestedRegions == null)
			return Collections.<ITraceRegion>singleton(this).iterator();
		return new AbstractIterator<ITraceRegion>() {
			
			private ITraceRegion current = TraceRegion.this;
			private int expectedOffset = getFromOffset();
			private LinkedList<Integer> traversalIndizes = Lists.newLinkedList();
			
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
							ITraceRegion result = new AbstractTraceRegion(expectedOffset, current.getFromOffset() + current.getFromLength() - expectedOffset, current.getToOffset(), current.getToLength()) {
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
							ITraceRegion result = new AbstractTraceRegion(expectedOffset, next.getFromOffset() - expectedOffset, current.getToOffset(), current.getToLength()) {
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
						ITraceRegion result = new AbstractTraceRegion(current.getFromOffset(), next.getFromOffset() - current.getFromOffset(), current.getToOffset(), current.getToLength()) {
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
		};
	}
	
	@Override
	public URI getToPath() {
		if (toPath == null && parent != null)
			return parent.getToPath();
		return toPath;
	}
	
	@Override
	public List<TraceRegion> getNestedRegions() {
		if (nestedRegions != null)
			return Collections.unmodifiableList(nestedRegions);
		return Collections.emptyList();
	}
	
	public ITraceRegion getParent() {
		return parent;
	}
	
	@Override
	public String getToProjectName() {
		if (toProjectName == null && parent != null)
			return parent.getToProjectName();
		return toProjectName;
	}
	
}
