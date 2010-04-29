/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.formatting.impl.AbstractFormattingConfig.ElementLocator;
import org.eclipse.xtext.formatting.impl.AbstractFormattingConfig.LocatorType;
import org.eclipse.xtext.formatting.impl.FormattingConfig.IndentationLocatorEnd;
import org.eclipse.xtext.formatting.impl.FormattingConfig.IndentationLocatorStart;
import org.eclipse.xtext.formatting.impl.FormattingConfig.LinewrapLocator;
import org.eclipse.xtext.formatting.impl.FormattingConfig.NoLinewrapLocator;
import org.eclipse.xtext.formatting.impl.FormattingConfig.NoSpaceLocator;
import org.eclipse.xtext.parsetree.reconstr.ITokenStream;
import org.eclipse.xtext.parsetree.reconstr.impl.TokenStringBuffer;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class FormattingConfigBasedStream extends BaseTokenStream {

	protected static class LineEntry {
		protected EObject grammarElement;
		protected String value;
		protected boolean isHidden;
		protected Set<ElementLocator> leadingLocators;
		protected String leadingWS;
		protected int indent;

		@Override
		public String toString() {
			return leadingLocators + " --> " + (leadingWS != null ? "[" + leadingWS + "] " : "") +  value;
		}

		public LineEntry(EObject grammarElement, String value, boolean isHidden,
				Set<ElementLocator> beforeLocators, String leadingWS, int indent) {
			super();
			this.grammarElement = grammarElement;
			this.value = value;
			this.isHidden = isHidden;
			this.leadingLocators = beforeLocators;
			this.indent = indent;
			this.leadingWS = leadingWS;
		}

		protected int countCharactersInLastLine() {
			int lastNLIndex = value.lastIndexOf('\n');
			if (lastNLIndex >= 0)
				return (value.length() - lastNLIndex) - 1;
			if (leadingWS != null) {
				int lastNLIndexInLeadingWs = leadingWS.lastIndexOf('\n');
				if (lastNLIndexInLeadingWs >= 0)
					return ((leadingWS.length() - lastNLIndexInLeadingWs) + value.length()) - 1;
			}
			return -1;
		}

		protected boolean isBreakable() {
			if (leadingLocators == null)
				return false;
			for (ElementLocator e : leadingLocators)
				if (e instanceof NoLinewrapLocator)
					return false;
			return true;
		}
	}

	protected class Line {
		protected int totalLength;
		protected List<LineEntry> entries;
		protected int lastBreakableEntryIndex;
		protected boolean startWithNL;
		protected String indent = null;
		protected int leftover;

		public Line() {
			this(null);
		}

		@Override
		public String toString() {
			TokenStringBuffer result = new TokenStringBuffer();
			try {
				flush(result, entries.size());
			} catch (IOException e) {
				e.printStackTrace();
				return "Error: " + e.getMessage();
			}
			return result.toString();
		}

		protected Line(int leftover) {
			this(null, leftover);
		}

		protected Line(List<LineEntry> entries) {
			this(entries, 0);
		}

		protected String getIndentation(int indentation) {
			if (leftover > 0)
				return "";
			if (indentation == 0)
				return indentationPrefix;
			StringBuffer result = new StringBuffer(
					indentation * cfg.getIndentationSpace().length() + indentationPrefix.length());
			result.append(indentationPrefix);
			for (int i = 0; i < indentation; i++)
				result.append(cfg.getIndentationSpace());
			return result.toString();
		}

		protected Line(List<LineEntry> initialEntries, int leftover) {
			super();
			this.leftover = leftover;
			this.totalLength = leftover;
			this.entries = initialEntries == null ? new ArrayList<LineEntry>() : initialEntries;
			this.lastBreakableEntryIndex = -1;
			this.startWithNL = initialEntries != null;
			if (initialEntries != null && initialEntries.size() > 0)
				indent = getIndentation(initialEntries.get(0).indent);
			for (int i = 0; i < this.entries.size(); i++) {
				LineEntry lineEntry = this.entries.get(i);
				this.totalLength += lineEntry.value.length();
				addSpacesToTotalLength(lineEntry, i == 0);
				if (lineEntry.isBreakable())
					lastBreakableEntryIndex = i;
			}
		}

		public Line add(LineEntry lineEntry) throws IOException {
			entries.add(lineEntry);
			if (indent == null) {
				indent = getIndentation(entries.get(0).indent);
			}
			addSpacesToTotalLength(lineEntry, entries.size() == 1);
			int lastLineLength = lineEntry.countCharactersInLastLine();
			if (lastLineLength >= 0) {
				flush();
				return new Line(lastLineLength);
			}
			if (lineEntry.isBreakable())
				lastBreakableEntryIndex = entries.size() - 1;
			totalLength += lineEntry.value.length();
			if (lineEntry.leadingLocators != null)
				for (ElementLocator l : lineEntry.leadingLocators) {
					if (l instanceof LinewrapLocator) {
						lastBreakableEntryIndex = entries.size() - 1;
						return flushLine();
					}
				}
			if (totalLength > cfg.getCharsPerLine() && lastBreakableEntryIndex > 0)
				return flushLine();
			return null;
		}

		protected void addSpacesToTotalLength(LineEntry lineEntry, boolean first) {
			String spaces = getSpaces(lineEntry, first);
			if (spaces != null) {
				int lastIndexOfNL = spaces.lastIndexOf('\n'); 
				if (lastIndexOfNL >= 0)
					totalLength += spaces.length() - lastIndexOfNL;
				else
					totalLength += spaces.length();
			}
		}

		protected Line flushLine() throws IOException {
			flush(out, lastBreakableEntryIndex);
			// TokenStringBuffer b = new TokenStringBuffer();
			// flush(b, lastBreakable);
			// System.out.println("WrapLine: \"" + b + "\"");
			return new Line(Lists.newArrayList(
					entries.subList(lastBreakableEntryIndex, entries.size())));
		}

		public void flush() throws IOException {
			flush(out, this.entries.size());
			// TokenStringBuffer b = new TokenStringBuffer();
			// flush(b, this.entries.size());
			// System.out.println("BreakLine: \"" + this + "\"");
		}

		/**
		 * @param endIndex the index of the last entry to flush, exclusive.
		 */
		protected void flush(ITokenStream intoStream, int endIndex) throws IOException {
			for (int i = 0; i < endIndex; i++) {
				LineEntry e = this.entries.get(i);
				String sp = getSpaces(e, i == 0);
				// System.out.println("Spaces: '" + sp + "' before '" + e.val
				// + "'");
				if (sp != null)
					intoStream.writeHidden(cfg.getWhitespaceRule(), sp);
				if (e.isHidden)
					intoStream.writeHidden(e.grammarElement, e.value);
				else
					intoStream.writeSemantic(e.grammarElement, e.value);
			}
		}

		public String getSpaces(LineEntry entry, boolean isLineStart) {
			if (entry.leadingWS != null)
				return entry.leadingWS;
			if (entry.leadingLocators == null)
				return null;
			boolean nospace = false;
			int wrap = isLineStart && startWithNL && leftover <= 0 ? 1 : 0;
			for (ElementLocator leadingLocator : entry.leadingLocators)
				if (leadingLocator instanceof LinewrapLocator)
					wrap = Math.max(wrap, ((LinewrapLocator) leadingLocator).getLines());
			for (ElementLocator leadingLocator : entry.leadingLocators) {
				if (leadingLocator instanceof NoSpaceLocator)
					nospace = true;
				else if (leadingLocator instanceof NoLinewrapLocator)
					wrap = 0;
			}
			if (wrap > 0)
				return wrap(wrap, indent);
			else if (nospace)
				return null;
			else if (isLineStart && indent.length() > 0)
				return indent;
			return isLineStart && !startWithNL ? null : " ";
		}

		protected String wrap(int lines, String indent) {
			StringBuffer result = new StringBuffer(lines + indent);
			for (int i = 0; i < lines; i++)
				result.append("\n");
			// do not indent too deep as there would be no space left
			// for semantic information
			int indentLength = indent.length();
			while ((cfg.getCharsPerLine() * 2 / 3) < indentLength) {
				indentLength = indentLength - cfg.getCharsPerLine() / 2;
			}
			if (indentLength != indent.length())
				indent = indent.substring(0, indentLength);
			result.append(indent);
			return result.toString();
		}

	}

	protected List<ElementLocator> activeRangeLocators = new ArrayList<ElementLocator>();

	protected FormattingConfig cfg;

	protected int indentationLevel = 0;

	protected String indentationPrefix = "";

	protected EObject last = null;

	protected boolean preserveSpaces;

	public FormattingConfigBasedStream(ITokenStream out, String indentation,
			FormattingConfig cfg, boolean preserveSpaces) {
		super(out);
		this.cfg = cfg;
		this.preserveSpaces = preserveSpaces;
		this.indentationPrefix = indentation == null ? "" : indentation;
	}

	public Set<ElementLocator> collectLocators(EObject left, EObject right) {
		Set<ElementLocator> result = Sets.newHashSet(activeRangeLocators);

		if (left != null) {
			Assignment assignment = GrammarUtil.containingAssignment(left);
			List<ElementLocator> trailingElementLocators;
			if (assignment == null)
				trailingElementLocators = cfg.getAfter(left);
			else {
				trailingElementLocators = new ArrayList<ElementLocator>(cfg.getAfter(left));
				trailingElementLocators.addAll(cfg.getAfter(assignment));
			}

			result.addAll(trailingElementLocators);
			for (ElementLocator locator : trailingElementLocators)
				if (locator.getType() == LocatorType.RANGE)
					activeRangeLocators.add(locator);
		}
		if (right != null) {
			Assignment assignment = GrammarUtil.containingAssignment(right);
			List<ElementLocator> leadingElementLocators;
			if (assignment == null)
				leadingElementLocators = cfg.getBefore(right);
			else {
				leadingElementLocators = new ArrayList<ElementLocator>(cfg.getBefore(right));
				leadingElementLocators.addAll(cfg.getBefore(assignment));
			}
			for (Iterator<ElementLocator> i = result.iterator(); i.hasNext();) {
				ElementLocator locator = i.next();
				if (locator.getType() == LocatorType.BETWEEN && !leadingElementLocators.contains(locator))
					i.remove();
			}
			for (Iterator<ElementLocator> i = leadingElementLocators.iterator(); i.hasNext();) {
				if (i.next().getType() == LocatorType.BETWEEN)
					i.remove();
			}
			result.addAll(leadingElementLocators);
			for (ElementLocator locator : leadingElementLocators)
				if (locator.getType() == LocatorType.RANGE)
					activeRangeLocators.remove(locator);
		}
		for (ElementLocator locator : result) {
			if (locator instanceof IndentationLocatorStart)
				indentationLevel++;
			else if (locator instanceof IndentationLocatorEnd)
				indentationLevel--;
		}
		// System.out.println(r);
		return result;
	}

	protected String preservedWS = null;

	protected Line currentLine = null;

	@Override
	public void writeHidden(EObject grammarElement, String value)
			throws IOException {
		if (cfg.getWhitespaceRule() == grammarElement) {
			if (preserveSpaces) {
				if (preservedWS == null)
					preservedWS = value;
				else
					preservedWS += value;
			}
		} else
			addLineEntry(grammarElement, value, true);
	}

	protected void addLineEntry(EObject grammarElement, String value,
			boolean isHidden) throws IOException {
		Set<ElementLocator> locators = collectLocators(last, grammarElement);
		// System.out.println(loc + " --> " + value.replaceAll("\n", "\\n"));
		last = grammarElement;
		LineEntry e = new LineEntry(grammarElement, value, true, locators, preservedWS,
				indentationLevel);
		preservedWS = null;
		if (currentLine == null)
			currentLine = new Line();
		Line newLine = currentLine.add(e);
		if (newLine != null)
			currentLine = newLine;
	}

	@Override
	public void flush() throws IOException {
		if (currentLine != null)
			currentLine.flush();
		super.flush();
	}

	@Override
	public void writeSemantic(EObject grammarElement, String value)
			throws IOException {
		addLineEntry(grammarElement, value, false);
	}
}
