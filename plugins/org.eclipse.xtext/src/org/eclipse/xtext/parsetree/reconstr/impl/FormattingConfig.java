/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import org.eclipse.xtext.AbstractElement;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class FormattingConfig extends AbstractFormattingConfig {
	private class FormattingRunner extends ConfigRunner {
		protected int column = 0;
		protected int indentationLevel = 0;

		@Override
		public String getSummarizedSpaces() {
			boolean nospace = false;
			int wrap = wrapNeeded() ? 1 : 0;
			for (ElementLocator e : activeLocators)
				if (e instanceof LinewrapLocator)
					wrap = Math.max(wrap, ((LinewrapLocator) e).getLines());
			for (ElementLocator e : activeLocators) {
				if (e instanceof NoSpaceLocator)
					nospace = true;
				else if (e instanceof NoLinewrapLocator)
					wrap = 0;
				else if (e instanceof IndentationLocatorStart)
					indentationLevel++;
				else if (e instanceof IndentationLocatorEnd)
					indentationLevel--;
			}
			if (wrap > 0)
				return wrap(wrap);
			else if (nospace)
				return "";
			else
				return " ";
		}

//		public void seek(int cols) {
//			column += cols;
//		}

		protected String wrap(int lines) {
			column = 0;
			StringBuffer r = new StringBuffer();
			for (int i = 0; i < lines; i++)
				r.append("\n");
			for (int i = 0; i < indentationLevel; i++)
				r.append(indentationSpace);
			return r.toString();
		}

		protected boolean wrapNeeded() {
			return charsPerLine < column;
		}

	}

	public class IndentationLocatorEnd extends ElementLocator {

		public IndentationLocatorEnd(AbstractElement ele) {
			super();
			before(ele);
		}

	}

	public class IndentationLocatorStart extends ElementLocator {

		public IndentationLocatorStart(AbstractElement ele) {
			super();
			after(ele);
		}

	}

	public class LinewrapLocator extends ElementLocator {

		private final int lines;

		public LinewrapLocator(int lines) {
			super();
			this.lines = lines;
		}

		public int getLines() {
			return lines;
		}

		public LinewrapLocator() {
			this(1);
		}

		@Override
		public void after(AbstractElement left) {
			super.after(left);
		}

		@Override
		public void before(AbstractElement right) {
			super.before(right);
		}

		@Override
		public void between(AbstractElement left, AbstractElement right) {
			super.between(left, right);
		}

	}

	public class NoLinewrapLocator extends ElementLocator {

		@Override
		public void after(AbstractElement left) {
			super.after(left);
		}

		@Override
		public void before(AbstractElement right) {
			super.before(right);
		}

		@Override
		public void between(AbstractElement left, AbstractElement right) {
			super.between(left, right);
		}

		@Override
		public void range(AbstractElement left, AbstractElement right) {
			super.range(left, right);
		}

	}

	public class NoSpaceLocator extends ElementLocator {

		@Override
		public void after(AbstractElement left) {
			super.after(left);
		}

		@Override
		public void before(AbstractElement right) {
			super.before(right);
		}

		@Override
		public void between(AbstractElement left, AbstractElement right) {
			super.between(left, right);
		}

		@Override
		public void range(AbstractElement left, AbstractElement right) {
			super.range(left, right);
		}

		@Override
		public void around(AbstractElement ele) {
			super.around(ele);
		}

	}

	protected int charsPerLine;

	protected String indentationSpace = "  ";

	@Override
	public ConfigRunner run() {
		return new FormattingRunner();
	}

	public void setAutoLinewrap(int charsPerLine) {
		this.charsPerLine = charsPerLine;
	}

	public void setIndentation(AbstractElement beginElement,
			AbstractElement endElement) {
		new IndentationLocatorStart(beginElement);
		new IndentationLocatorEnd(endElement);
	}

	public void setIndentationSpace(String indentationSpace) {
		this.indentationSpace = indentationSpace;
	}

	public LinewrapLocator setLinewrap() {
		return new LinewrapLocator();
	}

	public LinewrapLocator setLinewrap(int lines) {
		return new LinewrapLocator(lines);
	}

	public NoLinewrapLocator setNoLinewrap() {
		return new NoLinewrapLocator();
	}

	public NoSpaceLocator setNoSpace() {
		return new NoSpaceLocator();
	}
}
