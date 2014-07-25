/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import org.eclipse.xtext.formatting2.IAutowrapFormatter;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatting;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;

import com.google.common.base.Preconditions;

public class HiddenRegionFormatting implements IHiddenRegionFormatter, IHiddenRegionFormatting {
	private Boolean autowrap = null;
	private final IFormattableDocument document;
	private final IHiddenRegion hiddenRegion;
	private Integer indentationDecrease = null;
	private Integer indentationIncrease = null;
	private Integer newLineDefault = null;
	private Integer newLineMax = null;
	private Integer newLineMin = null;
	private IAutowrapFormatter onAutowrap;
	private int priority = IHiddenRegionFormatter.NORMAL_PRIORITY;
	private String space = null;

	public HiddenRegionFormatting(IFormattableDocument document, IHiddenRegion hiddenRegion) {
		super();
		this.hiddenRegion = hiddenRegion;
		this.document = document;
	}

	public IHiddenRegionFormatting asBean() {
		return this;
	}

	public IHiddenRegionFormatter asFormatter() {
		return this;
	}

	public void autowrap() {
		this.autowrap = Boolean.TRUE; // TODO: can newLineMax = 0 suppress autowrap?
	}

	public void decreaseIndentation() {
		indentationDecrease = indentationDecrease == null ? 1 : indentationDecrease + 1;
	}

	public Boolean getAutowrap() {
		return this.autowrap;
	}

	public IFormattableDocument getDocument() {
		return document;
	}

	public IHiddenRegion getHiddenRegion() {
		return hiddenRegion;
	}

	public Integer getIndentationDecrease() {
		return indentationDecrease;
	}

	public Integer getIndentationIncrease() {
		return indentationIncrease;
	}

	public Integer getNewLineDefault() {
		return newLineDefault;
	}

	public Integer getNewLineMax() {
		return newLineMax;
	}

	public Integer getNewLineMin() {
		return newLineMin;
	}

	public IAutowrapFormatter getOnAutowrap() {
		return onAutowrap;
	}

	public int getPriority() {
		return priority;
	}

	public String getSpace() {
		return space;
	}

	public void highPriority() {
		setPriority(IHiddenRegionFormatter.HIGH_PRIORITY);
	}

	public void increaseIndentation() {
		indentationIncrease = indentationIncrease == null ? 1 : indentationIncrease + 1;
	}

	public void lowPriority() {
		setPriority(IHiddenRegionFormatter.LOW_PRIORITY);
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

	public void setAutowrap(Boolean value) {
		this.autowrap = value;
	}

	public void setDecreaseIndentation(int indentation) {
		this.indentationDecrease = indentation;
	}

	public void setIncreaseIndentation(int indentation) {
		this.indentationIncrease = indentation;
	}

	public void setIndentationDecrease(Integer indentation) {
		this.indentationDecrease = indentation;
	}

	public void setIndentationIncrease(Integer indentation) {
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

	public void setNewLinesDefault(Integer newLines) {
		this.newLineDefault = newLines;
	}

	public void setNewLinesMax(Integer newLines) {
		this.newLineMax = newLines;
	}

	public void setNewLinesMin(Integer newLines) {
		this.newLineMin = newLines;
	}

	public void setOnAutowrap(IAutowrapFormatter formatter) {
		this.autowrap = true;
		this.onAutowrap = formatter;
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