/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.TerminalRule;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class FormattingConfig extends AbstractFormattingConfig {

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

		public LinewrapLocator() {
			this(1);
		}

		public LinewrapLocator(int lines) {
			super();
			this.lines = lines;
		}

		@Override
		public void after(EObject left) {
			super.after(left);
		}

		@Override
		public void before(EObject right) {
			super.before(right);
		}

		@Override
		public void between(EObject left, EObject right) {
			super.between(left, right);
		}

		public int getLines() {
			return lines;
		}

	}

	public class NoLinewrapLocator extends ElementLocator {

		@Override
		public void around(EObject ele) {
			super.around(ele);
		}

		@Override
		public void after(EObject left) {
			super.after(left);
		}

		@Override
		public void before(EObject right) {
			super.before(right);
		}

		@Override
		public void between(EObject left, EObject right) {
			super.between(left, right);
		}

		@Override
		public void range(EObject left, EObject right) {
			super.range(left, right);
		}

	}

	public class NoSpaceLocator extends ElementLocator {

		@Override
		public void after(EObject left) {
			super.after(left);
		}

		@Override
		public void around(EObject ele) {
			super.around(ele);
		}

		@Override
		public void before(EObject right) {
			super.before(right);
		}

		@Override
		public void between(EObject left, EObject right) {
			super.between(left, right);
		}

		@Override
		public void range(EObject left, EObject right) {
			super.range(left, right);
		}

	}

	protected int charsPerLine = 80;

	protected String indentationSpace = "  ";

	protected TerminalRule whitespaceRule = null;

	public int getCharsPerLine() {
		return charsPerLine;
	}

	public String getIndentationSpace() {
		return indentationSpace;
	}

	public TerminalRule getWhitespaceRule() {
		return whitespaceRule;
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

	public void setWhitespaceRule(TerminalRule rule) {
		whitespaceRule = rule;
	}
}
