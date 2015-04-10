/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import java.util.List;

import org.eclipse.xtext.formatting2.FormattingNotApplicableException;
import org.eclipse.xtext.formatting2.ISubFormatter;
import org.eclipse.xtext.formatting2.ITextReplacer;
import org.eclipse.xtext.formatting2.ITextReplacerContext;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.formatting2.regionaccess.internal.TextSegment;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

public class ConditionalReplacer extends AbstractTextReplacer implements ICompositeTextReplacer {
	private final List<ISubFormatter> subFormatters;
	private final List<ITextReplacer> replacers = Lists.newArrayList();

	public ConditionalReplacer(FormattableDocument document, int offset, int length, List<ISubFormatter> subFormatters) {
		super(document, new TextSegment(document.getTextRegionAccess(), offset, length));
		Preconditions.checkArgument(subFormatters.size() > 0);
		this.subFormatters = subFormatters;
	}

	@Override
	public ITextReplacerContext createReplacements(ITextReplacerContext context) {
		context.setNextReplacerIsChild();
		for (ISubFormatter formatter : subFormatters) {
			try {
				ITextSegment region = getRegion();
				SubDocument subDocument = new SubDocument(region, getDocument());
				for (ITextReplacer replacer : replacers)
					subDocument.addReplacer(replacer);
				formatter.format(subDocument);
				ITextReplacerContext first = context.withReplacer(subDocument);
				ITextReplacerContext last = subDocument.createReplacements(first);
				return last;
			} catch (FormattingNotApplicableException e) {
				// no need to do anything.
				// Try the next SubFormatter until one doens't throw a FormattingNotApplicableException 
			}
		}
		throw new FormattingNotApplicableException();
	}

	@Override
	public void addReplacer(ITextReplacer replacer) {
		replacers.add(replacer);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName();
	}

}