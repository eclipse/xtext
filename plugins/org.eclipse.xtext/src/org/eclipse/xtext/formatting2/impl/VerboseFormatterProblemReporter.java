/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.impl;

import static java.lang.String.*;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;

import org.eclipse.xtext.formatting2.FormatterProblemReporter;
import org.eclipse.xtext.formatting2.ITextRegion2;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class VerboseFormatterProblemReporter extends FormatterProblemReporter {

	protected String box(String title, String content) {
		final int width = 80;
		final int min = 3;
		int titleLenght = title.length() + 2;
		final int left = Math.max((width - titleLenght) / 2, min);
		StringBuilder result = new StringBuilder();
		result.append(Strings.repeat("-", left));
		result.append(" ");
		result.append(title);
		result.append(" ");
		if (left > min)
			result.append(Strings.repeat("-", width - left - titleLenght));
		result.append("\n");
		result.append(org.eclipse.xtext.util.Strings.trimTrailingLineBreak(content));
		result.append("\n");
		result.append(Strings.repeat("-", width));
		return result.toString();
	}

	@Override
	public void handleMergeConflict(RegionSet<?> regionSet, ITextRegion2 existing, ITextRegion2 add) {
		ITextRegion2 root = regionSet.getRoot();
		IdentityHashMap<?, Throwable> traces = regionSet.getTraces();
		StringBuilder message = new StringBuilder();
		message.append("A conflict occurred between two regions:\n");
		message.append(visualizeRegion(root, existing));
		message.append("\n");
		message.append(visualizeRegion(root, add));
		message.append("\n");
		message.append(visualizeMultipleStackTraces(traces.get(existing), traces.get(add)));
		report(message.toString(), null);
	}

	@Override
	public void handleOutsideOfRegion(RegionSet<?> regionSet, ITextRegion2 region) {
		report("Outside of Region: " + region, null);
	}

	protected abstract void report(String message, Throwable cause);

	protected String visualizeMultipleStackTraces(Throwable... throwables) {
		StackTraceElement[][] traces = new StackTraceElement[throwables.length][];
		for (int i = 0; i < throwables.length; i++)
			traces[i] = throwables[i].getStackTrace();
		int commenElement = Integer.MAX_VALUE;
		StackTraceElement[] first = traces[0];
		for (int i = 1; i < traces.length; i++) {
			StackTraceElement[] trace = traces[i];
			for (int e = 1; e < first.length && e < trace.length && e < commenElement; e++)
				if (!first[first.length - e].equals(trace[trace.length - e])) {
					commenElement = e;
					break;
				}
		}
		if (commenElement == Integer.MAX_VALUE)
			commenElement = 1;
		List<String> lines = Lists.newArrayList();
		for (int i = 0; i < traces.length; i++) {
			String message = throwables[i].getMessage();
			if (!Strings.isNullOrEmpty(message))
				lines.add((i == 0 ? "   " : "|  ") + throwables[i].getClass().getName() + ": " + message);
			StackTraceElement[] trace = traces[i];
			int max = trace.length - commenElement;
			for (int e = 0; e <= max; e++) {
				String prefix = i == 0 ? (e == max ? ",- " : "   ") : (e == max ? "|- " : "|  ");
				lines.add(prefix + trace[e].toString());
			}
		}
		int min = first.length - commenElement + 1;
		int max = first.length - Math.max(0, commenElement - 10);
		for (int i = min; i < max; i++)
			lines.add(first[i].toString());
		return Joiner.on('\n').join(lines);
	}

	protected String visualizeRegion(ITextRegion2 root, ITextRegion2 region) {
		String msg = format("Region offset=%d length=%d: %s", region.getOffset(), region.getLength(), region.toString());
		String content = new RegionsToString<ITextRegion2>().withRoot(root)
				.withRegionToString(new Function<ITextRegion2, String>() {
					public String apply(ITextRegion2 input) {
						return "[[[" + input.getText() + "]]]";
					}
				}).apply(Collections.singleton(region));
		return box(msg, content);
	}

}
