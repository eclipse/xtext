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
import java.util.HashSet;
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

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class FormattingConfigBasedStream extends BaseTokenStream {

	protected class LineEntry {
		protected EObject grammarEle;
		protected String val;
		protected boolean isHidden;
		protected Set<ElementLocator> beforeLoc;
		protected String beforeWS;
		protected int indent;

		@Override
		public String toString() {
			return beforeLoc + " --> " + val;
		}

		public LineEntry(EObject grammarEle, String val, boolean isHidden,
				Set<ElementLocator> beforeLoc, String beforeWS, int indent) {
			super();
			this.grammarEle = grammarEle;
			this.val = val;
			this.isHidden = isHidden;
			this.beforeLoc = beforeLoc;
			this.indent = indent;
			this.beforeWS = beforeWS;
		}

		protected int charsInNewLine() {
			int pos = val.lastIndexOf('\n');
			if (pos >= 0)
				return (val.length() - pos) - 1;
			if (beforeWS != null && (pos = beforeWS.lastIndexOf('\n')) >= 0)
				return ((beforeWS.length() - pos) + val.length()) - 1;
			return -1;
		}

		protected boolean isBreakable() {
			if (beforeLoc == null)
				return false;
			for (ElementLocator e : beforeLoc)
				if (e instanceof NoLinewrapLocator)
					return false;
			return true;
		}
	}

	protected class Line {
		protected int length;
		protected List<LineEntry> entries;
		protected int lastBreakable;
		protected boolean startWithNL;
		protected String indent = null;
		protected int leftover;

		public Line() {
			this(null);
		}

		@Override
		public String toString() {
			TokenStringBuffer b = new TokenStringBuffer();
			try {
				flush(b, entries.size());
			} catch (IOException e) {
				e.printStackTrace();
				return "Error: " + e.getMessage();
			}
			return b.toString();
		}

		protected Line(int leftover) {
			this(null, leftover);
		}

		protected Line(List<LineEntry> e) {
			this(e, 0);
		}

		protected String getIndentation(int indentation) {
			if (leftover > 0)
				return "";
			StringBuffer b = new StringBuffer();
			b.append(indentationPrefix);
			for (int i = 0; i < indentation; i++)
				b.append(cfg.getIndentationSpace());
			return b.toString();
		}

		protected Line(List<LineEntry> e, int leftover) {
			super();
			this.leftover = leftover;
			this.length = leftover;
			this.entries = e == null ? new ArrayList<LineEntry>() : e;
			this.lastBreakable = -1;
			this.startWithNL = e != null;
			if (e != null && e.size() > 0)
				indent = getIndentation(e.get(0).indent);
			for (int i = 0; i < this.entries.size(); i++) {
				this.length += this.entries.get(i).val.length();
				if (this.entries.get(i).isBreakable())
					lastBreakable = i;
			}
		}

		public Line add(LineEntry e) throws IOException {
			entries.add(e);
			if (indent == null)
				indent = getIndentation(entries.get(0).indent);
			int nl = e.charsInNewLine();
			if (nl >= 0) {
				flush();
				return new Line(nl);
			}
			if (e.isBreakable())
				lastBreakable = entries.size() - 1;
			length += e.val.length();
			if (e.beforeLoc != null)
				for (ElementLocator l : e.beforeLoc)
					if (l instanceof LinewrapLocator) {
						lastBreakable = entries.size() - 1;
						return flushLine();
					}
			if (length > cfg.getCharsPerLine() && lastBreakable > 0)
				return flushLine();
			return null;
		}

		protected Line flushLine() throws IOException {
			flush(out, lastBreakable);
			// TokenStringBuffer b = new TokenStringBuffer();
			// flush(b, lastBreakable);
			// System.out.println("WrapLine: \"" + b + "\"");
			return new Line(new ArrayList<LineEntry>(entries.subList(
					lastBreakable, entries.size())));
		}

		public void flush() throws IOException {
			flush(out, this.entries.size());
			// TokenStringBuffer b = new TokenStringBuffer();
			// flush(b, this.entries.size());
			// System.out.println("BreakLine: \"" + this + "\"");
		}

		protected void flush(ITokenStream str, int limit) throws IOException {
			for (int i = 0; i < limit; i++) {
				LineEntry e = this.entries.get(i);
				String sp = getSpaces(e, i == 0);
				// System.out.println("Spaces: '" + sp + "' before '" + e.val
				// + "'");
				if (sp != null)
					str.writeHidden(cfg.getWhitespaceRule(), sp);
				if (e.isHidden)
					str.writeHidden(e.grammarEle, e.val);
				else
					str.writeSemantic(e.grammarEle, e.val);
			}
		}

		public String getSpaces(LineEntry e, boolean isLineStart) {
			if (e.beforeWS != null)
				return e.beforeWS;
			if (e.beforeLoc == null)
				return null;
			boolean nospace = false;
			int wrap = isLineStart && startWithNL && leftover <= 0 ? 1 : 0;
			for (ElementLocator l : e.beforeLoc)
				if (l instanceof LinewrapLocator)
					wrap = Math.max(wrap, ((LinewrapLocator) l).getLines());
			for (ElementLocator l : e.beforeLoc) {
				if (l instanceof NoSpaceLocator)
					nospace = true;
				else if (l instanceof NoLinewrapLocator)
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
			StringBuffer r = new StringBuffer();
			for (int i = 0; i < lines; i++)
				r.append("\n");
			r.append(indent);
			return r.toString();
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
		Set<ElementLocator> r = new HashSet<ElementLocator>(activeRangeLocators);

		if (left != null) {
			Assignment lass = GrammarUtil.containingAssignment(left);
			List<ElementLocator> lel;
			if (lass == null)
				lel = cfg.getAfter(left);
			else {
				lel = new ArrayList<ElementLocator>(cfg.getAfter(left));
				lel.addAll(cfg.getAfter(lass));
			}

			r.addAll(lel);
			for (ElementLocator l : lel)
				if (l.getType() == LocatorType.RANGE)
					activeRangeLocators.add(l);
		}
		if (right != null) {
			Assignment rass = GrammarUtil.containingAssignment(right);
			List<ElementLocator> rel;
			if (rass == null)
				rel = cfg.getBefore(right);
			else {
				rel = new ArrayList<ElementLocator>(cfg.getBefore(right));
				rel.addAll(cfg.getBefore(rass));
			}
			for (Iterator<ElementLocator> i = r.iterator(); i.hasNext();) {
				ElementLocator l = i.next();
				if (l.getType() == LocatorType.BETWEEN && !rel.contains(l))
					i.remove();
			}
			for (Iterator<ElementLocator> i = rel.iterator(); i.hasNext();) {
				if (i.next().getType() == LocatorType.BETWEEN)
					i.remove();
			}
			r.addAll(rel);
			for (ElementLocator l : rel)
				if (l.getType() == LocatorType.RANGE)
					activeRangeLocators.remove(l);
		}
		for (ElementLocator e : r) {
			if (e instanceof IndentationLocatorStart)
				indentationLevel++;
			else if (e instanceof IndentationLocatorEnd)
				indentationLevel--;
		}
		// System.out.println(r);
		return r;
	}

	protected String lastWS = null;

	protected Line line = null;

	@Override
	public void writeHidden(EObject grammarElement, String value)
			throws IOException {
		if (cfg.getWhitespaceRule() == grammarElement) {
			if (preserveSpaces) {
				if (lastWS == null)
					lastWS = value;
				else
					lastWS += value;
			}
		} else
			addLineEntry(grammarElement, value, true);
	}

	protected void addLineEntry(EObject grammarEle, String value,
			boolean isHidden) throws IOException {
		Set<ElementLocator> loc = collectLocators(last, grammarEle);
		// System.out.println(loc + " --> " + value.replaceAll("\n", "\\n"));
		last = grammarEle;
		LineEntry e = new LineEntry(grammarEle, value, true, loc, lastWS,
				indentationLevel);
		lastWS = null;
		if (line == null)
			line = new Line();
		Line newLine = line.add(e);
		if (newLine != null)
			line = newLine;
	}

	@Override
	public void close() throws IOException {
		if (line != null)
			line.flush();
		super.close();
	}

	@Override
	public void writeSemantic(EObject grammarElement, String value)
			throws IOException {
		addLineEntry(grammarElement, value, false);
	}
}
