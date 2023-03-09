/**
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.formatting2.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;

import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TestableTextSegmentSet {
	private List<String> issues = new ArrayList<>();

	private TextSegmentSet<ITextSegment> set;

	public TestableTextSegmentSet(TextSegmentSet<ITextSegment> set) {
		this.set = set;
	}

	private String fmt(ITextSegment region) {
		return "[" + region.getOffset() + "," + region.getLength() + "]";
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("issues=");
		builder.append(Joiner.on(", ").join(issues));
		builder.append("\n");
		builder.append("set=");
		builder.append(Iterables.transform(set, it -> "[" + it.getOffset() + "," + it.getLength() + "]")
				.toString().replace("\n", ", "));
		builder.append("\n");
		return builder.toString();
	}

	public void add(ITextSegment segment) {
		try {
			set.add(segment);
		} catch (ConflictingRegionsException e) {
			Iterable<ITextSegment> conflicting = Iterables.transform(e.getTraces(), RegionTrace::getRegion);
			issues.add("mergeConflict:" + Joiner.on("<>")
					.join(Iterables.transform(conflicting, this::fmt)));
		}
	}

}
