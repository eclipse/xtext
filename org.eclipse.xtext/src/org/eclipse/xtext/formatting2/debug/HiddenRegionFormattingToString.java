/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.debug;

import static com.google.common.base.Preconditions.*;

import java.util.List;

import org.eclipse.xtext.formatting2.IHiddenRegionFormatting;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class HiddenRegionFormattingToString implements Function<IHiddenRegionFormatting, String> {
	@Override
	public String apply(IHiddenRegionFormatting gapFormatting) {
		String space = gapFormatting.getSpace();
		Integer nlMin = gapFormatting.getNewLineMin();
		Integer nlDefault = gapFormatting.getNewLineDefault();
		Integer nlMax = gapFormatting.getNewLineMax();
		Integer autowrap = gapFormatting.getAutowrap();
		Integer indentationIncrease = gapFormatting.getIndentationIncrease();
		Integer indentationDecrease = gapFormatting.getIndentationDecrease();
		List<String> result = Lists.newArrayList();
		if (space != null)
			result.add("space='" + space.replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t") + "'");
		if (nlDefault != null && nlDefault.equals(nlMin) && nlDefault.equals(nlMax))
			result.add("newLine=" + nlDefault);
		else if (nlMin != null || nlDefault != null || nlMax != null) {
			String x = firstNonNull(nlMin, "?") + "-" + firstNonNull(nlDefault, "?") + "-" + firstNonNull(nlMax, "?");
			result.add("newLine=" + x);
		}
		if (autowrap != null)
			result.add(autowrap >= 0 ? ("autowrap" + ((autowrap > 0) ? "(" + autowrap + ")" : "")) : "noAutowrap");
		if (indentationIncrease != null)
			result.add("indentInc=" + indentationIncrease);
		if (indentationDecrease != null)
			result.add("indentDec=" + indentationDecrease);
		return Joiner.on(";").join(result);
	}
	
	private static <T> T firstNonNull(T first, T second) {
		return first != null ? first : checkNotNull(second);
	}
}
