/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting.impl;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.formatting.IIndentationInformation;
import org.eclipse.xtext.parsetree.reconstr.IHiddenTokenHelper;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class FormattingConfig extends AbstractFormattingConfig {

	public interface IDoLinewrapLocator extends IAfterLocator, IBeforeLocator, IBetweenLocator {
	}

	public interface IDoSpaceLocator extends IAfterLocator, IAroundLocator, IBeforeLocator, IBetweenLocator, IBoundsLocator,
			IRangeLocator {
	}

	public class IndentationLocatorEnd extends ElementLocator {

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

		public IndentationLocatorStart(AbstractElement ele) {
			super();
			after(ele);
		}

		@Override
		public String toString() {
			return ">>";
		}
	}

	public interface INoLinewrapLocator extends IAfterLocator, IAroundLocator, IBeforeLocator, IBetweenLocator,
			IRangeLocator {
	}

	public interface INoSpaceLocator extends IAfterLocator, IAroundLocator, IBeforeLocator, IBetweenLocator, IBoundsLocator,
			IRangeLocator {
	}

	public class LinewrapLocator extends ElementLocator implements IDoLinewrapLocator, INoLinewrapLocator {

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

	public class SpaceLocator extends ElementLocator implements IDoSpaceLocator, INoSpaceLocator {

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

	protected String indentationSpace = null;

	protected IIndentationInformation indentInfo;

	protected TerminalRule whitespaceRule = null;

	public FormattingConfig(IHiddenTokenHelper hiddenTokenHelper, IIndentationInformation indentInfo) {
		super(hiddenTokenHelper);
		this.indentInfo = indentInfo;
	}

	public int getCharsPerLine() {
		return charsPerLine;
	}

	public String getIndentationSpace() {
		if (indentationSpace != null)
			return indentationSpace;
		return indentInfo.getIndentString();
	}

	@Deprecated
	public TerminalRule getWhitespaceRule() {
		return whitespaceRule;
	}

	public void setAutoLinewrap(int charsPerLine) {
		this.charsPerLine = charsPerLine;
	}

	public void setIndentation(AbstractElement beginElement, AbstractElement endElement) {
		new IndentationLocatorStart(beginElement);
		new IndentationLocatorEnd(endElement);
	}

	/**
	 * use {@link IIndentationInformation} instead
	 */
	@Deprecated
	public void setIndentationSpace(String indentationSpace) {
		this.indentationSpace = indentationSpace;
	}

	public IDoLinewrapLocator setLinewrap() {
		return new LinewrapLocator(1);
	}

	public IDoLinewrapLocator setLinewrap(int lines) {
		return new LinewrapLocator(lines);
	}

	public IDoLinewrapLocator setLinewrap(int minWraps, int defaultWraps, int maxWraps) {
		return new LinewrapLocator(minWraps, defaultWraps, maxWraps);
	}

	public INoLinewrapLocator setNoLinewrap() {
		return new LinewrapLocator(0);
	}

	public INoSpaceLocator setNoSpace() {
		return new SpaceLocator();
	}

	public IDoSpaceLocator setSpace(String space) {
		return new SpaceLocator(space);
	}

	@Deprecated
	public void setWhitespaceRule(TerminalRule rule) {
		whitespaceRule = rule;
	}
}
