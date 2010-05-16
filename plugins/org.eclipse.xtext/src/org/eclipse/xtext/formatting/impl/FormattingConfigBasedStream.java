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
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.formatting.IElementMatcherProvider.IElementMatcher;
import org.eclipse.xtext.formatting.impl.AbstractFormattingConfig.ElementLocator;
import org.eclipse.xtext.formatting.impl.AbstractFormattingConfig.ElementPattern;
import org.eclipse.xtext.formatting.impl.AbstractFormattingConfig.LocatorType;
import org.eclipse.xtext.formatting.impl.FormattingConfig.IndentationLocatorEnd;
import org.eclipse.xtext.formatting.impl.FormattingConfig.IndentationLocatorStart;
import org.eclipse.xtext.formatting.impl.FormattingConfig.LinewrapLocator;
import org.eclipse.xtext.formatting.impl.FormattingConfig.SpaceLocator;
import org.eclipse.xtext.parsetree.reconstr.IHiddenTokenHelper;
import org.eclipse.xtext.parsetree.reconstr.ITokenStream;
import org.eclipse.xtext.parsetree.reconstr.impl.TokenStringBuffer;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class FormattingConfigBasedStream extends BaseTokenStream {

	protected class Line {
		protected List<LineEntry> entries;
		protected String indent = null;
		protected int lastBreakableEntryIndex;
		protected int leftover;
		protected boolean startWithNL;
		protected int totalLength;

		public Line() {
			this(null);
		}

		protected Line(int leftover) {
			this(null, leftover);
		}

		protected Line(List<LineEntry> entries) {
			this(entries, 0);
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
					if (l instanceof LinewrapLocator && ((LinewrapLocator) l).getMaxWrap() > 0) {
						lastBreakableEntryIndex = entries.size() - 1;
						return flushLine();
					}
				}
			if (totalLength > cfg.getCharsPerLine() && lastBreakableEntryIndex > 0)
				return flushLine();
			return null;
		}

		protected void addSpacesToTotalLength(LineEntry lineEntry, boolean first) {
			Pair<AbstractRule, String> spaces = getSpaces(lineEntry, first);
			if (spaces != null) {
				int lastIndexOfNL = spaces.getSecond().lastIndexOf('\n');
				if (lastIndexOfNL >= 0)
					totalLength += spaces.getSecond().length() - lastIndexOfNL;
				else
					totalLength += spaces.getSecond().length();
			}
		}

		public void flush() throws IOException {
			flush(out, this.entries.size());
			// TokenStringBuffer b = new TokenStringBuffer();
			// flush(b, this.entries.size());
			// System.out.println("BreakLine: \"" + this + "\"");
		}

		/**
		 * @param endIndex
		 *            the index of the last entry to flush, exclusive.
		 */
		protected void flush(ITokenStream intoStream, int endIndex) throws IOException {
			for (int i = 0; i < endIndex; i++) {
				LineEntry e = this.entries.get(i);
				Pair<AbstractRule, String> spaces = getSpaces(e, i == 0);
				// System.out.println("Spaces: '" + sp + "' before '" + e.val
				// + "'");
				if (spaces != null)
					intoStream.writeHidden(spaces.getFirst(), spaces.getSecond());
				if (e.isHidden)
					intoStream.writeHidden(e.grammarElement, e.value);
				else
					intoStream.writeSemantic(e.grammarElement, e.value);
			}
		}

		protected Line flushLine() throws IOException {
			flush(out, lastBreakableEntryIndex);
			// TokenStringBuffer b = new TokenStringBuffer();
			// flush(b, lastBreakable);
			// System.out.println("WrapLine: \"" + b + "\"");
			return new Line(Lists.newArrayList(entries.subList(lastBreakableEntryIndex, entries.size())));
		}

		protected String getIndentation(int indentation) {
			if (leftover > 0)
				return "";
			if (indentation <= 0)
				return indentationPrefix;
			StringBuffer result = new StringBuffer(indentation * cfg.getIndentationSpace().length()
					+ indentationPrefix.length());
			result.append(indentationPrefix);
			for (int i = 0; i < indentation; i++)
				result.append(cfg.getIndentationSpace());
			return result.toString();
		}

		public Pair<AbstractRule, String> getSpaces(LineEntry entry, boolean isLineStart) {
			String space = getSpacesStr(entry, isLineStart);
			if (space == null)
				return null;
			AbstractRule rule = hiddenTokenHelper.getWhitespaceRuleFor(entry.hiddenTokenDefinition, space);
			if (rule == null)
				return null;
			return Tuples.create(rule, space);
		}

		public String getSpacesStr(LineEntry entry, boolean isLineStart) {
			if (preserveSpaces && entry.leadingWS != null)
				return entry.leadingWS;
			if (entry.leadingLocators == null)
				return null;
			String space = null;
			for (ElementLocator leadingLocator : entry.leadingLocators)
				if (leadingLocator instanceof SpaceLocator) {
					String s = ((SpaceLocator) leadingLocator).getSpace();
					if (space == null || s.length() > space.length())
						space = s;
				}
			if (space != null)
				return space;
			int def = isLineStart && startWithNL && leftover <= 0 ? 1 : 0, min = def, max = def;
			boolean noWrap = false;
			for (ElementLocator leadingLocator : entry.leadingLocators)
				if (leadingLocator instanceof LinewrapLocator) {
					LinewrapLocator l = (LinewrapLocator) leadingLocator;
					min = Math.max(min, l.getMinWrap());
					def = Math.max(def, l.getDefaultWrap());
					max = Math.max(max, l.getMaxWrap());
					if (l.getMaxWrap() == 0)
						noWrap = true;
				}
			if (!noWrap) {
				if (min != max) {
					int existing = entry.countExistingLeadingNewlines();
					if (existing >= 0)
						def = existing;
				}
				def = Math.max(min, Math.min(def, max));
				if (def > 0)
					return wrap(def, indent);
				else if (isLineStart && indent.length() > 0)
					return indent;
			}
			return isLineStart && !startWithNL ? null : " ";
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

		protected String wrap(int lines, String indent) {
			StringBuffer result = new StringBuffer(lines + indent.length());
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

	protected class LineEntry {
		protected EObject grammarElement;
		protected ParserRule hiddenTokenDefinition;
		protected int indent;
		protected boolean isHidden;
		protected Set<ElementLocator> leadingLocators;
		protected String leadingWS;
		protected String value;

		public LineEntry(EObject grammarElement, String value, boolean isHidden, Set<ElementLocator> beforeLocators,
				String leadingWS, int indent, ParserRule hiddenTokenDefition) {
			super();
			this.grammarElement = grammarElement;
			this.value = value;
			this.isHidden = isHidden;
			this.leadingLocators = beforeLocators;
			this.indent = indent;
			this.leadingWS = leadingWS;
			this.hiddenTokenDefinition = hiddenTokenDefition;
		}

		protected int countCharactersInLastLine() {
			int lastNLIndex = value.lastIndexOf('\n');
			if (lastNLIndex >= 0)
				return (value.length() - lastNLIndex) - 1;
			if (preserveSpaces && leadingWS != null) {
				int lastNLIndexInLeadingWs = leadingWS.lastIndexOf('\n');
				if (lastNLIndexInLeadingWs >= 0)
					return ((leadingWS.length() - lastNLIndexInLeadingWs) + value.length()) - 1;
			}
			return -1;
		}

		protected int countExistingLeadingNewlines() {
			if (leadingWS == null)
				return -1;
			int c = 0, i = -1;
			while ((i = leadingWS.indexOf('\n', i + 1)) >= 0)
				c++;
			return c;
		}

		protected boolean isBreakable() {
			if (leadingLocators == null)
				return false;
			for (ElementLocator e : leadingLocators) {
				if (e instanceof LinewrapLocator && ((LinewrapLocator) e).getMaxWrap() == 0)
					return false;
				if (e instanceof SpaceLocator)
					return false;
			}
			return hiddenTokenHelper.getWhitespaceRuleFor(hiddenTokenDefinition, "\n") != null;
		}

		@Override
		public String toString() {
			return leadingLocators + " --> " + (leadingWS != null ? "[" + leadingWS + "] " : "") + value;
		}
	}

	protected Set<ElementLocator> activeRangeLocators = Sets.newHashSet();

	protected FormattingConfig cfg;

	protected Line currentLine = null;

	protected IHiddenTokenHelper hiddenTokenHelper;

	protected int indentationLevel = 0;

	protected String indentationPrefix = "";

	protected EObject last = null;

	protected IElementMatcher<ElementPattern> matcher;

	protected String preservedWS = "";

	protected boolean preserveSpaces;

	public FormattingConfigBasedStream(ITokenStream out, String indentation, FormattingConfig cfg,
			IElementMatcher<ElementPattern> matcher, IHiddenTokenHelper hiddenTokenHelper, boolean preserveSpaces) {
		super(out);
		this.cfg = cfg;
		this.matcher = matcher;
		this.hiddenTokenHelper = hiddenTokenHelper;
		this.preserveSpaces = preserveSpaces;
		this.indentationPrefix = indentation == null ? "" : indentation;
	}

	protected void addLineEntry(EObject grammarElement, String value, boolean isHidden) throws IOException {
		Pair<Integer, RuleCall> hiddenTokenDefCall1 = findTopmostHiddenTokenDef();
		Set<ElementLocator> locators = collectLocators(grammarElement);
		//		System.out.println(locators + " --> " + value.replaceAll("\n", "\\n"));
		Pair<Integer, RuleCall> hiddenTokenDefCall2 = findTopmostHiddenTokenDef();
		ParserRule hiddenTokenDef = null;
		if (hiddenTokenDefCall1 != null && hiddenTokenDefCall2 != null) {
			if (hiddenTokenDefCall1.getFirst() < hiddenTokenDefCall2.getFirst())
				hiddenTokenDef = (ParserRule) hiddenTokenDefCall1.getSecond().getRule();
			else
				hiddenTokenDef = (ParserRule) hiddenTokenDefCall2.getSecond().getRule();
		}
		LineEntry e = new LineEntry(grammarElement, value, true, locators, preservedWS, indentationLevel,
				hiddenTokenDef);
		preservedWS = null;
		if (currentLine == null)
			currentLine = new Line();
		Line newLine = currentLine.add(e);
		if (newLine != null)
			currentLine = newLine;
	}

	protected Set<ElementLocator> collectLocators(EObject ele) {
		Set<ElementLocator> result = Sets.newHashSet(activeRangeLocators);
		Collection<ElementLocator> loc = Sets.newHashSet();
		if (ele instanceof AbstractElement)
			for (ElementPattern pattern : matcher.matchNext((AbstractElement) ele))
				loc.add(pattern.getLocator());
		if ((last instanceof AbstractRule && hiddenTokenHelper.isComment((AbstractRule) last))
				|| (ele instanceof AbstractRule && hiddenTokenHelper.isComment((AbstractRule) ele)))
			loc = collectLocatorsForComments(loc, last, ele);
		last = ele;
		for (ElementLocator locator : loc)
			if (locator.getType() == LocatorType.RANGE && !activeRangeLocators.add(locator))
				activeRangeLocators.remove(locator);
		result.addAll(loc);
		for (ElementLocator locator : result) {
			if (locator instanceof IndentationLocatorStart)
				indentationLevel++;
			else if (locator instanceof IndentationLocatorEnd)
				indentationLevel--;
		}
		return result;
	}

	protected Set<ElementLocator> collectLocatorsForComments(Collection<ElementLocator> semanticLocators, EObject left,
			EObject right) {
		Set<ElementLocator> result = Sets.newHashSet();
		for (ElementLocator semantic : semanticLocators)
			if (semantic instanceof IndentationLocatorStart || semantic instanceof IndentationLocatorEnd
					|| (semantic.getRight() != null && semantic.getRight() == right)
					|| (semantic.getLeft() != null && semantic.getLeft() == left))
				result.add(semantic);
		if (left != null)
			result.addAll(cfg.getLocatorsForCommentTokensAfter(left));
		if (right != null) {
			List<ElementLocator> leadingElementLocators = cfg.getLocatorsForCommentTokensBefore(right);
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
		}
		return result;
	}

	protected Pair<Integer, RuleCall> findTopmostHiddenTokenDef() {
		return matcher.findTopmostRuleCall(new Predicate<RuleCall>() {
			public boolean apply(RuleCall input) {
				return ((ParserRule) input.getRule()).isDefinesHiddenTokens();
			}
		});
	}

	@Override
	public void flush() throws IOException {
		if (currentLine != null) {
			matcher.finish();
			currentLine.flush();
			currentLine = null;
		}
		super.flush();
	}

	@Override
	@SuppressWarnings("deprecation")
	public void writeHidden(EObject grammarElement, String value) throws IOException {
		boolean isWhitespace = grammarElement instanceof AbstractRule
				&& hiddenTokenHelper.isWhitespace((AbstractRule) grammarElement);
		if (isWhitespace || cfg.getWhitespaceRule() == grammarElement) {
			if (preservedWS == null)
				preservedWS = value;
			else
				preservedWS += value;
		} else
			addLineEntry(grammarElement, value, true);
	}

	@Override
	public void writeSemantic(EObject grammarElement, String value) throws IOException {
		addLineEntry(grammarElement, value, false);
	}
}
