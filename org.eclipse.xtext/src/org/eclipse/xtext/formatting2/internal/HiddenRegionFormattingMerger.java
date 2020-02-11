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
		if (conflicting.size() == 2) {
			// TODO: don't do this
			conflicting.get(1).mergeValuesFrom(conflicting.get(0));
			return conflicting.get(1);
		}
		IHiddenRegionFormatting result = formatter.createHiddenRegionFormatting();
		for (IHiddenRegionFormatting conflict : conflicting)
			result.mergeValuesFrom(conflict);
		return result;
	}

}
