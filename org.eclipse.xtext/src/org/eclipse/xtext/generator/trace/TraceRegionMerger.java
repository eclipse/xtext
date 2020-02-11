/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Sets.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;

/**
 * Copied and adapted from 
 * <code>org.eclipse.xtext.ui.editor.syntaxcoloring.MergingHighlightedPositionAcceptor</code>.
 * 
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 * @author Jan Koehnlein - Initial contribution and API
 */
public class TraceRegionMerger {
	
	private List<AbstractTraceRegion> leafRegions;

	public AbstractTraceRegion mergeTraceRegions(List<AbstractTraceRegion> roots) {
		leafRegions = newArrayList();
		for (AbstractTraceRegion root: roots) {
			for(Iterator<AbstractTraceRegion> iter = root.leafIterator(); iter.hasNext();)
				leafRegions.add(clone(iter.next()));
			
		}
		mergeLeafRegions();
		AbstractTraceRegion firstLeaf = leafRegions.get(0);
		AbstractTraceRegion lastLeaf = leafRegions.get(leafRegions.size() - 1);
		AbstractTraceRegion mergedRoot = new TraceRegion(
				firstLeaf.getMyOffset(),
				lastLeaf.getMyOffset() + lastLeaf.getMyLength() - firstLeaf.getMyOffset(), 
				firstLeaf.getMyLineNumber(), 
				lastLeaf.getMyEndLineNumber(), 
				true,
				(Collection<ILocationData>) Collections.<ILocationData>emptyList(), null);
		for(AbstractTraceRegion leafRegion: leafRegions) 
			leafRegion.setParent(mergedRoot);
		return mergedRoot;
	}
	
	private void mergeLeafRegions() {
		if (leafRegions.size() < 2)
			return;
		Collections.sort(leafRegions, getComparator());
		AbstractTraceRegion prev = leafRegions.get(0);
		int i = 1;
		while(i < leafRegions.size()) {
			AbstractTraceRegion next = leafRegions.get(i);
			int exclusiveEndOffset = prev.getMyOffset() + prev.getMyLength();
			int exclusiveEndLine = prev.getMyEndLineNumber();
			if (next.getMyOffset() < exclusiveEndOffset) {
				int newLength = next.getMyOffset() - prev.getMyOffset();
				prev = replaceTruncated(i - 1, prev, newLength, next.getMyLineNumber());
				doMergeLeafRegions(i, exclusiveEndOffset, exclusiveEndLine, prev.getAssociatedLocations());
				if (prev.getMyLength() == 0) {
					if (prev != leafRegions.remove(i - 1))
						throw new IllegalStateException("removed position is not 'prev'");
				}
			}
			if (prev.getMyLength() != 0) {
				i++;
			}
			prev = leafRegions.get(i - 1);
		}
	}
	
	private void doMergeLeafRegions(int listIdx, int exclusiveEndOffset, int inclusiveEndLine, List<ILocationData> locations) {
		int i = listIdx;
		List<AbstractTraceRegion> newRegions = null;
		AbstractTraceRegion prev = null;
		while(i < leafRegions.size()) {
			AbstractTraceRegion next = leafRegions.get(i);
			if (next.getMyOffset() >= exclusiveEndOffset) {
				newRegions = addPendingRegions(prev, exclusiveEndOffset, inclusiveEndLine, locations, newRegions);
				partialSortRegions(listIdx, exclusiveEndOffset, i, newRegions);
				return;
			}
			if (prev != null) {
				int prevEnd = prev.getMyOffset() + prev.getMyLength();
				if (prevEnd < next.getMyOffset()) {
					if (newRegions == null)
						newRegions = Lists.newArrayListWithExpectedSize(4);
					newRegions.add(new TraceRegion(prevEnd, next.getMyOffset() - prevEnd, 
							prev.getMyEndLineNumber(), next.getMyLineNumber(), true, (Collection<ILocationData>) locations, null));
				}
			}
			if (next.getMyOffset() + next.getMyLength() <= exclusiveEndOffset) {
				next = replaceMerged(i, next, locations);
			} else {
				int oldLength = next.getMyLength();
				int oldEndLine = next.getMyEndLineNumber();
				next = replaceTruncated(i, next, exclusiveEndOffset - next.getMyOffset(), inclusiveEndLine);
				if (newRegions == null)
					newRegions = Lists.newArrayListWithExpectedSize(4);
				newRegions.add(new TraceRegion(
						next.getMyOffset() + next.getMyLength(), 
						oldLength - next.getMyLength(), 
						inclusiveEndLine, 
						oldEndLine,
						true,
						(Collection<ILocationData>) next.getAssociatedLocations(), 
						null));
				next = replaceMerged(i, next, locations);
			}
			i++;
			prev = next;
		}
		newRegions = addPendingRegions(prev, exclusiveEndOffset, inclusiveEndLine, locations, newRegions);
		partialSortRegions(listIdx, exclusiveEndOffset, i, newRegions);
	}

	private void partialSortRegions(int listIdx, int exclusiveEndOffset, int insertionIndex,
			List<AbstractTraceRegion> addedRegions) {
		int addedRegionsSize = addedRegions != null ? addedRegions.size() : 0;
		if (addedRegionsSize != 0)
			leafRegions.addAll(insertionIndex, addedRegions);
		if (insertionIndex + addedRegionsSize != listIdx) {
			int endIdx = insertionIndex + addedRegionsSize;
			while(endIdx < leafRegions.size() && leafRegions.get(endIdx).getMyOffset() == exclusiveEndOffset) {
				endIdx++;
			}
			Collections.sort(leafRegions.subList(listIdx, endIdx), getComparator());
		}
	}

	private List<AbstractTraceRegion> addPendingRegions(AbstractTraceRegion pending, int expectedEndOffset, int expectedEndLine,
			List<ILocationData> locations, List<AbstractTraceRegion> result) {
		if (pending != null) {
			int prevEnd = pending.getMyOffset() + pending.getMyLength();
			if (prevEnd < expectedEndOffset) {
				AbstractTraceRegion fillRegion = new TraceRegion(
						prevEnd, expectedEndOffset - prevEnd, 
						pending.getMyEndLineNumber(), expectedEndLine,
						true,
						(Collection<ILocationData>) locations, null);
				if (result == null)
					result = Collections.singletonList(fillRegion);
				else
					result.add(fillRegion);
			}
		}
		return result;
	}
	
	private Comparator<AbstractTraceRegion> getComparator() {
		return new Comparator<AbstractTraceRegion>() {
			@Override
			public int compare(AbstractTraceRegion left, AbstractTraceRegion right) {
				int offsetDelta = left.getMyOffset() - right.getMyOffset();
				return (offsetDelta != 0) 
					? offsetDelta
					: right.getMyLength()- left.getMyLength();
			}
		};
	}
	
	private AbstractTraceRegion replaceTruncated(int index, AbstractTraceRegion region, int newLength, int newEndLine) {
		AbstractTraceRegion truncated = new TraceRegion(
				region.getMyOffset(), newLength, 
				region.getMyLineNumber(), newEndLine,
				true,
				(Collection<ILocationData>) region.getAssociatedLocations(), null);
		leafRegions.set(index, truncated);
		return truncated;
	}

	private AbstractTraceRegion replaceMerged(int index, AbstractTraceRegion region, List<ILocationData> locationData) {
		Set<ILocationData> mergedLocations = newLinkedHashSet(region.getAssociatedLocations());
		mergedLocations.addAll(locationData);
		AbstractTraceRegion merged = new TraceRegion(
				region.getMyOffset(), region.getMyLength(),
				region.getMyLineNumber(), region.getMyEndLineNumber(),
				true,
				mergedLocations, null);
		leafRegions.set(index, merged);
		return merged;
	}
	
	private AbstractTraceRegion clone(AbstractTraceRegion region) {
		AbstractTraceRegion merged = new TraceRegion(
				region.getMyOffset(), region.getMyLength(),
				region.getMyLineNumber(), region.getMyEndLineNumber(),
				true,
				(Collection<ILocationData>) region.getAssociatedLocations(), null);
		return merged;
	}
}
