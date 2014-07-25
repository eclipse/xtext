/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import java.util.List;

import org.eclipse.xtext.formatting2.IHiddenRegionFormatting;
import org.eclipse.xtext.formatting2.IInternalFormatter;
import org.eclipse.xtext.formatting2.IMerger;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class HiddenRegionFormattingMerger implements IMerger<IHiddenRegionFormatting> {

	private final IInternalFormatter formatter;

	public HiddenRegionFormattingMerger(IInternalFormatter formatter) {
		super();
		this.formatter = formatter;
	}

	public IHiddenRegionFormatting merge(List<? extends IHiddenRegionFormatting> conflicting) {
		if (conflicting.isEmpty())
			return null;
		IHiddenRegionFormatting current = conflicting.get(0);
		for (int i = 1; i < conflicting.size() && current != null; i++)
			current = merge(current, conflicting.get(i));
		return current;
	}

	protected <T> T merge(T val1, T val2, int strategy) {
		if (val1 != null && val2 != null) {
			if (val1.equals(val2) || strategy < 0)
				return val1;
			if (strategy > 0)
				return val2;
			return null;
		}
		return val1 != null ? val1 : val2;
	}

	public IHiddenRegionFormatting merge(IHiddenRegionFormatting f1, IHiddenRegionFormatting f2) {
		if (f1.getHiddenRegion() != f2.getHiddenRegion())
			return null;
		int strategy = f2.getPriority() - f1.getPriority();
		IHiddenRegionFormatting m = formatter.createHiddenRegionFormatting(f1.getDocument(), f1.getHiddenRegion());
		m.setSpace(merge(f1.getSpace(), f2.getSpace(), strategy));
		m.setNewLinesMin(merge(f1.getNewLineMin(), f2.getNewLineMin(), strategy));
		m.setNewLinesDefault(merge(f1.getNewLineDefault(), f2.getNewLineDefault(), strategy));
		m.setNewLinesMax(merge(f1.getNewLineMax(), f2.getNewLineMax(), strategy));
		m.setAutowrap(merge(f1.getAutowrap(), f2.getAutowrap(), strategy));
		m.setOnAutowrap(merge(f1.getOnAutowrap(), f2.getOnAutowrap(), strategy));

		if (f1.getIndentationIncrease() != null && f2.getIndentationIncrease() != null)
			m.setIndentationIncrease(f1.getIndentationIncrease() + f2.getIndentationIncrease());
		else
			m.setIndentationIncrease(f1.getIndentationIncrease() != null ? f1.getIndentationIncrease() : f2
					.getIndentationIncrease());
		if (f1.getIndentationDecrease() != null && f2.getIndentationIncrease() != null)
			m.setIndentationDecrease(f1.getIndentationDecrease() + f2.getIndentationDecrease());
		else
			m.setIndentationDecrease(f1.getIndentationDecrease() != null ? f1.getIndentationDecrease() : f2
					.getIndentationDecrease());
		return m;
	}

}
