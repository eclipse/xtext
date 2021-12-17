/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import java.util.List;

import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatting;
import org.eclipse.xtext.formatting2.IMerger;

import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class HiddenRegionFormattingMerger implements IMerger<IHiddenRegionFormatting> {

	private final AbstractFormatter2 formatter;

	public HiddenRegionFormattingMerger(AbstractFormatter2 formatter) {
		super();
		this.formatter = formatter;
	}

	@Override
	public IHiddenRegionFormatting merge(List<? extends IHiddenRegionFormatting> conflicting) {
		// If there are only 2 conflicts,
		// usages of this method expect the second value to be updated to the merge result
		// TODO: Fix those usages so they no longer expect this method to edit its input
		if (conflicting.size() == 2) {
			conflicting.get(1).mergeValuesFrom(conflicting.get(0));
			return conflicting.get(1);
		}
		IHiddenRegionFormatting result = formatter.createHiddenRegionFormatting();
		// Reversed so the merging order is consistent with the special case above
		for (IHiddenRegionFormatting conflict : Lists.reverse(conflicting))
			result.mergeValuesFrom(conflict);
		return result;
	}

}
