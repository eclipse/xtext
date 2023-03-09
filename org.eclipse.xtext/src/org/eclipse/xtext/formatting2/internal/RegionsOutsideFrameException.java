/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import java.util.List;

import org.eclipse.xtext.formatting2.debug.TextRegionsWithTitleToString;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.util.Pair;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class RegionsOutsideFrameException extends RuntimeException {

	private static final long serialVersionUID = 3957771424755606694L;

	private final ITextSegment frameRegion;
	private final String frameTitle;
	private final Pair<String, ITextSegment>[] regions;

	@SafeVarargs
	public RegionsOutsideFrameException(String title, ITextSegment frame, Pair<String, ITextSegment>... regions) {
		this.frameTitle = title;
		this.frameRegion = frame;
		this.regions = regions;
	}

	@Override
	public String getMessage() {
		String regionsStr;
		if (regions.length == 1) {
			regionsStr = "region " + regions[0].getFirst();
		} else {
			List<String> titles = Lists.newArrayList();
			for (Pair<String, ITextSegment> p : regions)
				titles.add(p.getFirst());
			regionsStr = "regions " + Joiner.on(", ").join(titles);
		}
		StringBuilder builder = new StringBuilder();
		builder.append("The " + regionsStr + " must not be outside " + frameTitle + ".\n");
		TextRegionsWithTitleToString toStr = new TextRegionsWithTitleToString();
		toStr.add(frameTitle, frameRegion);
		for (Pair<String, ITextSegment> p : regions)
			toStr.add(p.getFirst(), p.getSecond());
		builder.append(toStr);
		return builder.toString();
	}

}
