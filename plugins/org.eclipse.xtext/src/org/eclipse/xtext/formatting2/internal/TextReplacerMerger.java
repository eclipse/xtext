/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;

import java.util.List;

import org.eclipse.xtext.formatting2.IFormattableSubDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatting;
import org.eclipse.xtext.formatting2.IInternalFormatter;
import org.eclipse.xtext.formatting2.IMerger;
import org.eclipse.xtext.formatting2.ITextReplacer;

import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TextReplacerMerger implements IMerger<ITextReplacer> {

	private final IInternalFormatter formatter;
	private final IMerger<IHiddenRegionFormatting> merger;

	public TextReplacerMerger(IInternalFormatter formatter) {
		super();
		this.formatter = formatter;
		this.merger = formatter.createHiddenRegionFormattingMerger();
	}

	public ITextReplacer merge(List<? extends ITextReplacer> conflicting) {
		List<IHiddenRegionFormatting> formattings = Lists.newArrayList();
		for (ITextReplacer replacer : conflicting)
			if (replacer instanceof HiddenRegionReplacer)
				formattings.add(((HiddenRegionReplacer) replacer).getFormatting());
		if (formattings.size() == conflicting.size()) {
			IHiddenRegionFormatting mergedFormatting = merger.merge(formattings);
			if (mergedFormatting != null)
				return formatter.createHiddenRegionReplacer(mergedFormatting);
			return null;
		}
		List<ConditionalReplacer> conditionals = newArrayList(filter(conflicting, ConditionalReplacer.class));
		if (conditionals.size() == 1) {
			ConditionalReplacer conditional = conditionals.get(0);
			for (ITextReplacer r : conflicting)
				if (r != conditional)
					conditional.addReplacer(r);
			return conditional;
		}
		List<IFormattableSubDocument> subdoc = newArrayList(filter(conflicting, IFormattableSubDocument.class));
		if (subdoc.size() == 1) {
			IFormattableSubDocument sub = subdoc.get(0);
			for (ITextReplacer r : conflicting)
				if (r != sub)
					sub.addReplacer(r);
			return (ITextReplacer) sub;
		}
		return null;
	}
}
