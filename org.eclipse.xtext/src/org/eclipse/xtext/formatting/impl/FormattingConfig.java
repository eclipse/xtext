/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting.impl;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.formatting.IIndentationInformation;
import org.eclipse.xtext.parsetree.reconstr.IHiddenTokenHelper;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class FormattingConfig extends AbstractFormattingConfig {

	public class IndentationLocatorEnd extends ElementLocator {

		public IndentationLocatorEnd() {
		}

		public IndentationLocatorEnd(AbstractElement ele) {
			super();
			before(ele);
		}

		@Override
		public String toString() {
			return "<<";
		}
	}

	public class IndentationLocatorStart extends ElementLocator {

		public IndentationLocatorStart() {
		}

		public IndentationLocatorStart(AbstractElement ele) {
			super();
			after(ele);
		}

		@Override
		public String toString() {
			return ">>";
		}
	}

	public class LinewrapLocator extends ElementLocator {

		protected final int defaultWrap;
		protected final int maxWrap;
		protected final int minWrap;

		public LinewrapLocator(int wrap) {
			super();
			this.minWrap = wrap;
			this.defaultWrap = wrap;
			this.maxWrap = wrap;
		}

		public LinewrapLocator(int min, int def, int max) {
			super();
			this.minWrap = min;
			this.defaultWrap = def;
			this.maxWrap = max;
		}

		public int getDefaultWrap() {
			return defaultWrap;
		}

		public int getMaxWrap() {
			return maxWrap;
		}

		public int getMinWrap() {
			return minWrap;
		}

		@Override
		public String toString() {
			if (maxWrap == 0)
				return "!\\n";
			if (minWrap == defaultWrap && defaultWrap == maxWrap) {
				StringBuilder b = new StringBuilder();
				for (int i = 0; i < defaultWrap; i++)
					b.append("\\n");
				return b.toString();
			}
			return "\\n[" + minWrap + "," + defaultWrap + "," + maxWrap + "]";
		}
	}

	public class NoLinewrapLocator extends LinewrapLocator {

		public NoLinewrapLocator(int wrap) {
			super(wrap);
		}
	}

	public class NoSpaceLocator extends SpaceLocator {

	}

	public class SpaceLocator extends ElementLocator {

		protected String space;

		public SpaceLocator() {
			this.space = "";
		}

		public SpaceLocator(String space) {
			super();
			this.space = space;
		}

		public String getSpace() {
			return space;
		}

		@Override
		public String toString() {
			if (space.length() == 0)
				return "-";
			else
				return "'" + space + "'";
		}
	}

	protected int charsPerLine = 80;

	protected IIndentationInformation indentInfo;

	/**
	 * @since 2.0
	 */
	protected int wrappedLineIndentation = 0;
	
	/**
	 * @since 2.0
	 */
	public int getWrappedLineIndentation() {
		return wrappedLineIndentation;
	}
	
	/**
	 * @since 2.0
	 */
	public void setWrappedLineIndentation(int wrapIndent) {
		this.wrappedLineIndentation = wrapIndent;
	}
	
	//TODO remove deprecated code and fix usages
	
	@Deprecated
	protected TerminalRule whitespaceRule = null;

	@Deprecated
	public TerminalRule getWhitespaceRule() {
		return whitespaceRule;
	}
	@Deprecated
	public void setWhitespaceRule(TerminalRule rule) {
		whitespaceRule = rule;
	}
	
	/**
	 * @deprecated use {@link FormattingConfig2} instead
	 */
	@Deprecated
	public FormattingConfig(IGrammarAccess grammarAccess, IHiddenTokenHelper hiddenTokenHelper,
			IIndentationInformation indentInfo) {
		super(grammarAccess, hiddenTokenHelper);
		this.indentInfo = indentInfo;
	}

	public int getCharsPerLine() {
		return charsPerLine;
	}

	public String getIndentationSpace() {
		return indentInfo.getIndentString();
	}


	public void setAutoLinewrap(int charsPerLine) {
		this.charsPerLine = charsPerLine;
	}

	public void setIndentation(AbstractElement beginElement, AbstractElement endElement) {
		new IndentationLocatorStart(beginElement);
		new IndentationLocatorEnd(endElement);
	}

	public IndentationLocatorStart setIndentationIncrement() {
		return new IndentationLocatorStart();
	}

	public IndentationLocatorEnd setIndentationDecrement() {
		return new IndentationLocatorEnd();
	}


	public LinewrapLocator setLinewrap() {
		return new LinewrapLocator(1);
	}

	public LinewrapLocator setLinewrap(int lines) {
		return new LinewrapLocator(lines);
	}

	public LinewrapLocator setLinewrap(int minWraps, int defaultWraps, int maxWraps) {
		return new LinewrapLocator(minWraps, defaultWraps, maxWraps);
	}

	public NoLinewrapLocator setNoLinewrap() {
		return new NoLinewrapLocator(0);
	}

	public NoSpaceLocator setNoSpace() {
		return new NoSpaceLocator();
	}

	public SpaceLocator setSpace(String space) {
		return new SpaceLocator(space);
	}

}
