/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.impl;

import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IFormatterRequest;
import org.eclipse.xtext.formatting2.IHiddenRegion;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatting;
import org.eclipse.xtext.formatting2.ITextReplacer.Mergeable;

import com.google.common.base.Preconditions;

public class HiddenRegionFormatting implements IHiddenRegionFormatting, Mergeable<IHiddenRegionFormatting> {
	private Boolean autowrap = null;
	private final IFormattableDocument document;
	private final IHiddenRegion gap;
	private Integer indentationDecrease = null;
	private Integer indentationIncrease = null;
	private Integer newLineDefault = null;
	private Integer newLineMax = null;
	private Integer newLineMin = null;
	private int priority = IHiddenRegionFormatting.NORMAL_PRIORITY;
	private String space = null;

	public HiddenRegionFormatting(IFormattableDocument document, IHiddenRegion gap) {
		super();
		this.gap = gap;
		this.document = document;
	}

	public void autowrap() {
		this.autowrap = Boolean.TRUE; // TODO: can newLineMax = 0 suppress autowrap?
	}

	public void decreaseIndentation() {
		indentationDecrease = indentationDecrease == null ? 1 : indentationDecrease + 1;
	}

	public Boolean getAutowrapValue() {
		return this.autowrap;
	}

	public IFormattableDocument getDocument() {
		return document;
	}

	public IHiddenRegion getGapValue() {
		return gap;
	}

	public Integer getIndentationDecreaseValue() {
		return indentationDecrease;
	}

	public Integer getIndentationIncreaseValue() {
		return indentationIncrease;
	}

	public Integer getNewLineDefaultValue() {
		return newLineDefault;
	}

	public Integer getNewLineMaxValue() {
		return newLineMax;
	}

	public Integer getNewLineMinValue() {
		return newLineMin;
	}

	public int getPriority() {
		return priority;
	}

	public IFormatterRequest getRequest() {
		return document.getRequest();
	}

	public String getSpace() {
		return space;
	}

	public void highPriority() {
		setPriority(IHiddenRegionFormatting.HIGH_PRIORITY);
	}

	public void increaseIndentation() {
		indentationIncrease = indentationIncrease == null ? 1 : indentationIncrease + 1;
	}

	public void lowPriority() {
		setPriority(IHiddenRegionFormatting.LOW_PRIORITY);
	}

	protected <T> T merge(T val1, T val2, int strategy) {
		if (val1 != null && val2 != null) {
			if (val1.equals(val2) || strategy < 0)
				return val1;
			if (strategy > 0)
				return val2;
			return null;
		}
		return val1 != null ? val1 : val2;
	}

	public IHiddenRegionFormatting mergeWith(IHiddenRegionFormatting o) {
		if (gap != o.getGapValue())
			return null;
		int strategy = o.getPriority() - getPriority();
		HiddenRegionFormatting m = new HiddenRegionFormatting(document, gap);
		m.space = merge(space, o.getSpace(), strategy);
		m.newLineMin = merge(newLineMin, o.getNewLineMinValue(), strategy);
		m.newLineDefault = merge(newLineDefault, o.getNewLineDefaultValue(), strategy);
		m.newLineMax = merge(newLineMax, o.getNewLineMaxValue(), strategy);
		m.autowrap = merge(autowrap, o.getAutowrapValue(), strategy);

		if (indentationIncrease != null && o.getIndentationIncreaseValue() != null)
			m.indentationIncrease = indentationIncrease + o.getIndentationIncreaseValue();
		else
			m.indentationIncrease = indentationIncrease != null ? indentationIncrease : o.getIndentationIncreaseValue();
		if (indentationDecrease != null && o.getIndentationIncreaseValue() != null)
			m.indentationDecrease = indentationDecrease + o.getIndentationDecreaseValue();
		else
			m.indentationDecrease = indentationDecrease != null ? indentationDecrease : o.getIndentationDecreaseValue();
		return m;
	}

	public void newLine() {
		setNewLines(1);
	}

	public void noAutowrap() {
		this.autowrap = Boolean.FALSE;
	}

	public void noSpace() {
		setSpace("");
	}

	public void oneSpace() {
		setSpace(" ");
	}

	public void setDecreaseIndentation(int indentation) {
		this.indentationDecrease = indentation;
	}

	public void setIncreaseIndentation(int indentation) {
		this.indentationIncrease = indentation;
	}

	public void setNewLines(int newLines) {
		setNewLines(newLines, newLines, newLines);
	}

	public void setNewLines(int minNewLines, int defaultNewLines, int maxNewLines) {
		Preconditions.checkArgument(minNewLines >= 0);
		Preconditions.checkArgument(defaultNewLines >= 0);
		Preconditions.checkArgument(maxNewLines >= 0);
		this.newLineMin = minNewLines;
		this.newLineDefault = defaultNewLines;
		this.newLineMax = maxNewLines;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public void setSpace(String space) {
		this.space = space;
	}

	@Override
	public String toString() {
		return new HiddenRegionFormattingToString().apply(this);
	}
}