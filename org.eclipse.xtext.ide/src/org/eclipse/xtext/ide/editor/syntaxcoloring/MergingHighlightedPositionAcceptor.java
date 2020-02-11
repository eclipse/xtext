/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.syntaxcoloring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.ide.editor.syntaxcoloring.LightweightPosition.IntToStringArray;

import com.google.common.collect.Lists;

/**
 * Accepts a bunch of positions and creates a list
 * of positions from them that do not overlap.
 * 
 * @since 2.9
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class MergingHighlightedPositionAcceptor implements IHighlightedPositionAcceptor, ISemanticHighlightingCalculator {

	private final ISemanticHighlightingCalculator delegate;
	private final List<LightweightPosition> positions;
	private int timestamp;
	private int expectedOffset;
	private boolean requireMerge;
	
	public MergingHighlightedPositionAcceptor(ISemanticHighlightingCalculator delegate) {
		this.delegate = delegate;
		this.positions = new ArrayList<LightweightPosition>(50);
		initialize();
	}

	@Override
	public void addPosition(int offset, int length, String... ids) {
		if (length > 0) {
			this.getPositions().add(newPosition(offset, length, timestamp, ids));
			if (offset < expectedOffset)
				requireMerge = true;
			expectedOffset = offset + length;
		}
		timestamp++;
	}

	protected LightweightPosition newPosition(int offset, int length, int timestamp, String... ids) {
		return new LightweightPosition(offset, length, timestamp, ids);
	}
	
	protected LightweightPosition newPosition(int offset, int length, int timestamp, IntToStringArray[] ids) {
		return new LightweightPosition(offset, length, timestamp, ids);
	}

	@Override
	public void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor, CancelIndicator cancelIndicator) {
		initialize();
		delegate.provideHighlightingFor(resource, this, cancelIndicator);
		mergePositions();
		for(LightweightPosition pos: getPositions())
			acceptor.addPosition(pos.getOffset(), pos.getLength(), pos.getIds());
	}

	private void initialize() {
		if (!getPositions().isEmpty())
			getPositions().clear();
		timestamp = 0;
		expectedOffset = 0;
		requireMerge = false;
	}

	public void mergePositions() {
		if (getPositions().size() < 2 || !requireMerge)
			return;
		Collections.sort(getPositions());
		LightweightPosition prev = getPositions().get(0);
		int i = 1;
		while(i < getPositions().size()) {
			LightweightPosition next = getPositions().get(i);
			int exclusiveEndOffset = prev.getOffset() + prev.getLength();
			if (next.getOffset() < exclusiveEndOffset) {
				int newLength = next.getOffset() - prev.getOffset();
				prev.setLength(newLength);
				mergePositions(i, exclusiveEndOffset, prev.getTimestamp(), prev.internalGetIds());
				if (prev.getLength() == 0) {
					if (prev != getPositions().remove(i - 1))
						throw new IllegalStateException("removed position is not 'prev'");
				}
			}
			if (prev.getLength() != 0) {
				i++;
			}
			prev = getPositions().get(i - 1);
		}
	}
	
	private void mergePositions(int listIdx, int exclusiveEndOffset, int timestamp, IntToStringArray[] ids) {
		int i = listIdx;
		List<LightweightPosition> newPositions = null;
		LightweightPosition prev = null;
		while(i < getPositions().size()) {
			LightweightPosition next = getPositions().get(i);
			if (next.getOffset() >= exclusiveEndOffset) {
				newPositions = addPendingPosition(prev, exclusiveEndOffset, timestamp, ids, newPositions);
				partialSortPositions(listIdx, exclusiveEndOffset, i, newPositions);
				return;
			}
			if (prev != null) {
				int prevEnd = prev.getOffset() + prev.getLength();
				if (prevEnd < next.getOffset()) {
					if (newPositions == null)
						newPositions = Lists.newArrayListWithExpectedSize(4);
					newPositions.add(newPosition(prevEnd, next.getOffset() - prevEnd, timestamp, ids));
				}
			}
			if (next.getOffset() + next.getLength() <= exclusiveEndOffset) {
				next.merge(ids);
			} else {
				int oldLength = next.getLength();
				next.setLength(exclusiveEndOffset - next.getOffset());
				if (newPositions == null)
					newPositions = Lists.newArrayListWithExpectedSize(4);
				newPositions.add(newPosition(next.getOffset() + next.getLength(), oldLength - next.getLength(), next.getTimestamp(), next.getIds()));
				next.merge(ids);
			}
			i++;
			prev = next;
		}
		newPositions = addPendingPosition(prev, exclusiveEndOffset, timestamp, ids, newPositions);
		partialSortPositions(listIdx, exclusiveEndOffset, i, newPositions);
	}

	private void partialSortPositions(int listIdx, int exclusiveEndOffset, int insertionIndex,
			List<LightweightPosition> addedPositions) {
		int newPosSize = addedPositions != null ? addedPositions.size() : 0;
		if (newPosSize != 0)
			getPositions().addAll(insertionIndex, addedPositions);
		if (insertionIndex + newPosSize != listIdx) {
			int endIdx = insertionIndex + newPosSize;
			while(endIdx < getPositions().size() && getPositions().get(endIdx).getOffset() == exclusiveEndOffset) {
				endIdx++;
			}
			Collections.sort(getPositions().subList(listIdx, endIdx));
		}
	}

	private List<LightweightPosition> addPendingPosition(LightweightPosition pending, int expectedEndOffset,
			int timestamp, IntToStringArray[] ids, List<LightweightPosition> result) {
		if (pending != null) {
			int prevEnd = pending.getOffset() + pending.getLength();
			if (prevEnd < expectedEndOffset) {
				LightweightPosition position = newPosition(prevEnd, expectedEndOffset - prevEnd, timestamp, ids);
				if (result == null)
					result = Collections.singletonList(position);
				else
					result.add(position);
			}
		}
		return result;
	}

	public List<LightweightPosition> getPositions() {
		return positions;
	}
	
}
