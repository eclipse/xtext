/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import static java.lang.String.*;

import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.formatting2.FormatterProblemReporter;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.ITextReplacement;
import org.eclipse.xtext.formatting2.ITextReplacer;
import org.eclipse.xtext.formatting2.ITextReplacerContext;
import org.eclipse.xtext.formatting2.ITextSegment;
import org.eclipse.xtext.formatting2.TextReplacements;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.xbase.lib.Pair;

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

	protected abstract void report(String message, Throwable cause);

	@Override
	public void reportMergeConflict(IFormattableDocument document, List<ITextReplacer> conflicting) {
		List<Pair<ITextSegment, Throwable>> items = Lists.newArrayListWithExpectedSize(conflicting.size());
		for (ITextReplacer replacer : conflicting)
			items.add(Pair.<ITextSegment, Throwable> of(replacer.getRegion(), document.getTrace(replacer)));
		reportMergeConflict(items);
	}

	@Override
	public void reportMergeConflict(ITextReplacerContext context, List<ITextReplacement> conflicting) {
		List<Pair<ITextSegment, Throwable>> items = Lists.newArrayListWithExpectedSize(conflicting.size());
		for (ITextReplacement replacement : conflicting)
			items.add(Pair.<ITextSegment, Throwable> of(replacement, context.getTrace(replacement)));
		reportMergeConflict(items);
	}

	protected void reportMergeConflict(List<Pair<ITextSegment, Throwable>> conflicting) {
		List<Throwable> throwable = Lists.newArrayList();
		StringBuilder message = new StringBuilder();
		message.append("A conflict occurred between regions:\n");
		for (Pair<ITextSegment, Throwable> pair : conflicting) {
			ITextSegment segment = pair.getKey();
			Throwable trace = pair.getValue();
			message.append(visualizeRegion(segment));
			message.append("\n");
			throwable.add(trace);
		}
		message.append(visualizeMultipleStackTraces(throwable.toArray(new Throwable[throwable.size()])));
		report(message.toString(), null);
	}

	@Override
	public void reportOutsideOfRegion(IFormattableDocument document, ITextReplacer region) {
		String cntName = document.getClass().getSimpleName();
		String regName = region.getClass().getSimpleName();
		String message = visualizeOutOfRegion(cntName, regName, document.getRegion(), region.getRegion());
		report(message, new RuntimeException());
	}

	@Override
	public void reportOutsideOfRegion(ITextReplacerContext context, ITextReplacement region) {
		String cntName = context.getReplacer().getClass().getSimpleName();
		String regName = region.getClass().getSimpleName();
		String message = visualizeOutOfRegion(cntName, regName, context.getReplacer().getRegion(), region);
		report(message, new RuntimeException());
	}

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

	protected String visualizeOutOfRegion(String cntName, String regName, ITextSegment container, ITextSegment region) {
		ITextRegionAccess regionAccess = region.getTextRegionAccess();
		ITextSegment expanded = regionAccess.expandRegionsByLines(4, 4, container, region);
		StringBuilder builder = new StringBuilder();
		String cntRegion = "offset=" + container.getOffset() + " lenght:" + container.getLength();
		String regRegion = "offset=" + region.getOffset() + " lenght:" + region.getLength();
		builder.append(regName + " is supposed to be inside " + cntName + ", but it is not.\n");
		builder.append("<<<>>>: " + cntName + " at " + cntRegion + "\n");
		builder.append("[[[]]]: " + regName + " at " + regRegion + "\n");
		List<ITextReplacement> replacements = Lists.newArrayList();
		int offset = expanded.getOffset();
		replacements.add(new TextReplacement(regionAccess, container.getOffset() - offset, 0, "<<<"));
		replacements.add(new TextReplacement(regionAccess, container.getEndOffset() - offset, 0, ">>>"));
		replacements.add(new TextReplacement(regionAccess, region.getOffset() - offset, 0, "[[["));
		replacements.add(new TextReplacement(regionAccess, region.getEndOffset() - offset, 0, "]]]"));
		String vizualized = TextReplacements.apply(expanded.getText(), replacements);
		builder.append(box("document snippet", vizualized));
		return builder.toString();
	}

	protected String visualizeRegion(ITextSegment region) {
		String msg = format("%s offset=%d length=%d: %s", region.getClass().getSimpleName(), region.getOffset(),
				region.getLength(), region.toString());
		String content = new RegionsToString<ITextSegment>().withRegionToString(new Function<ITextSegment, String>() {
			public String apply(ITextSegment input) {
				return "[[[" + input.getText() + "]]]";
			}
		}).apply(Collections.singleton(region));
		return box(msg, content);
	}

}
