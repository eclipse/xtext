/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.syntaxcoloring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.LightweightPosition.IntToStringArray;

import com.google.common.collect.Lists;

/**
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

	public void addPosition(int offset, int length, String... ids) {
		this.getPositions().add(new LightweightPosition(offset, length, timestamp, ids));
		if (offset < expectedOffset)
			requireMerge = true;
		expectedOffset = offset + length;
		timestamp++;
	}

	public void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		initialize();
		delegate.provideHighlightingFor(resource, this);
		mergePositions();
		for(LightweightPosition pos: getPositions())
			acceptor.addPosition(pos.getOffset(), pos.getLength(), pos.getIds());
	}

	private void initialize() {
		if (positions.isEmpty())
			positions.clear();
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
				prev.setLength(next.getOffset() - prev.getOffset());
				mergePositions(i, exclusiveEndOffset, prev.getTimestamp(), prev.internalGetIds());
				if (prev.getLength() == 0) {
					getPositions().remove(i - 1);
				}
			}
			if (prev.getLength() != 0)
				i++;
			prev = next;
			
		}
	}
	
	@SuppressWarnings("null")
	private void mergePositions(int listIdx, int exclusiveEndOffset, int timestamp, IntToStringArray[] ids) {
		int i = listIdx;
		List<LightweightPosition> newPositions = null;
		LightweightPosition prev = null;
		while(i < getPositions().size()) {
			LightweightPosition next = getPositions().get(i);
			if (next.getOffset() >= exclusiveEndOffset) {
				if (prev != null) {
					int prevEnd = prev.getOffset() + prev.getLength();
					if (prevEnd != exclusiveEndOffset) {
						if (newPositions == null)
							newPositions = Lists.newArrayListWithExpectedSize(4);
						newPositions.add(new LightweightPosition(prevEnd, exclusiveEndOffset - prevEnd, timestamp, ids));
					}
				}
				int newPosSize = newPositions != null ? newPositions.size() : 0;
				if (newPosSize != 0)
					getPositions().addAll(i, newPositions);
				if (i + newPosSize != listIdx) {
					Collections.sort(getPositions().subList(listIdx, i + newPosSize));
				}
				return;
			}
			if (prev != null) {
				int prevEnd = prev.getOffset() + prev.getLength();
				if (prevEnd < next.getOffset()) {
					if (newPositions == null)
						newPositions = Lists.newArrayListWithExpectedSize(4);
					newPositions.add(new LightweightPosition(prevEnd, next.getOffset() - prevEnd, timestamp, ids));
				}
			}
			if (next.getOffset() + next.getLength() <= exclusiveEndOffset) {
				next.merge(ids);
			} else {
				int oldLength = next.getLength();
				next.setLength(exclusiveEndOffset - next.getOffset());
				if (newPositions == null)
					newPositions = Lists.newArrayListWithExpectedSize(4);
				newPositions.add(new LightweightPosition(next.getOffset() + next.getLength(), oldLength - next.getLength(), next.getTimestamp(), next.getIds()));
				next.merge(ids);
			}
			i++;
			prev = next;
		}
		if (prev != null) {
			int prevEnd = prev.getOffset() + prev.getLength();
			if (prevEnd < exclusiveEndOffset) {
				if (newPositions == null)
					newPositions = Lists.newArrayListWithExpectedSize(4);
				newPositions.add(new LightweightPosition(prevEnd, exclusiveEndOffset - prevEnd, timestamp, ids));
			}
		}
		int newPosSize = newPositions != null ? newPositions.size() : 0;
		if (newPosSize != 0)
			getPositions().addAll(i, newPositions);
		if (i - 1 + newPosSize != listIdx) {
			Collections.sort(getPositions().subList(listIdx, i - 1 + newPosSize));
		}
	}

	public List<LightweightPosition> getPositions() {
		return positions;
	}
	
}
