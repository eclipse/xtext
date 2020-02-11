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
import org.eclipse.xtext.formatting2.ITextReplacer;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;

import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TextReplacerMerger implements IMerger<ITextReplacer> {

	private final AbstractFormatter2 formatter;
	private final IMerger<IHiddenRegionFormatting> merger;

	public TextReplacerMerger(AbstractFormatter2 formatter) {
		super();
		this.formatter = formatter;
		this.merger = formatter.createHiddenRegionFormattingMerger();
	}

	@Override
	public ITextReplacer merge(List<? extends ITextReplacer> conflicting) {
		ITextReplacer result = mergeHiddenRegionReplacers(conflicting);
		if (result == null)
			result = mergeCompositeReplacers(conflicting);
		return result;
	}

	protected ITextReplacer mergeCompositeReplacers(List<? extends ITextReplacer> conflicting) {
		ICompositeTextReplacer composite = null;
		for (ITextReplacer replacer : conflicting)
			if (replacer instanceof ICompositeTextReplacer) {
				if (composite == null)
					composite = ((ICompositeTextReplacer) replacer);
				else
					return null;
			}
		if (composite == null)
			return null;
		for (ITextReplacer r : conflicting)
			if (r != composite)
				composite.addReplacer(r);
		return composite;
	}

	protected ITextReplacer mergeHiddenRegionReplacers(List<? extends ITextReplacer> conflicting) {
		List<IHiddenRegionFormatting> formattings = Lists.newArrayList();
		IHiddenRegion region = null;
		for (ITextReplacer replacer : conflicting) {
			if (replacer instanceof HiddenRegionReplacer) {
				HiddenRegionReplacer hiddenRegionReplacer = (HiddenRegionReplacer) replacer;
				formattings.add(hiddenRegionReplacer.getFormatting());
				if (region == null)
					region = hiddenRegionReplacer.getRegion();
				else if (region != hiddenRegionReplacer.getRegion())
					return null;
			} else
				return null;
		}
		IHiddenRegionFormatting mergedFormatting = merger.merge(formattings);
		if (mergedFormatting != null)
			return formatter.createHiddenRegionReplacer(region, mergedFormatting);
		return null;
	}
}
