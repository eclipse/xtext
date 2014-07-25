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
import org.eclipse.xtext.formatting2.ITextReplacer;
import org.eclipse.xtext.formatting2.ITextReplacerContext;
import org.eclipse.xtext.formatting2.ITextSegment;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegionPart;
import org.eclipse.xtext.formatting2.regionaccess.IWhitespace;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class HiddenRegionReplacer implements ITextReplacer {

	private final IHiddenRegionFormatting formatting;
	private final IHiddenRegion region;

	public HiddenRegionReplacer(IHiddenRegion region, IHiddenRegionFormatting formatting) {
		super();
		this.region = region;
		this.formatting = formatting;
	}

	public ITextReplacerContext createReplacements(ITextReplacerContext context) {
		List<IHiddenRegionPart> hiddens = region.getParts();
		if (formatting.getAutowrap() == Boolean.TRUE)
			context.setCanAutowrap(true);
		if (region.isUndefined() || hiddens.isEmpty()) {
			return createWhitespaceReplacer(context, region).createReplacements(context);
		} else if ((hiddens.size() == 1 && hiddens.get(0) instanceof IWhitespace)) {
			return createWhitespaceReplacer(context, hiddens.get(0)).createReplacements(context);
		} else {
			// TODO
			return context;
		}
	}

	protected ITextReplacer createWhitespaceReplacer(ITextReplacerContext context, ITextSegment region) {
		return context.getFormatter().createWhitespaceReplacer(region, formatting);
	}

	public IHiddenRegionFormatting getFormatting() {
		return formatting;
	}

	public IHiddenRegion getRegion() {
		return region;
	}

	@Override
	public String toString() {
		return new HiddenRegionFormattingToString().apply(formatting);
	}
}
