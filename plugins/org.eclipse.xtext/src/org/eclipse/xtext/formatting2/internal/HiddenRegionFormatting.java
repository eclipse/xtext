/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.ConflictingFormattingException;
import org.eclipse.xtext.formatting2.FormatterRequest;
import org.eclipse.xtext.formatting2.IAutowrapFormatter;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatting;
import org.eclipse.xtext.formatting2.debug.HiddenRegionFormattingToString;

import com.google.common.base.Preconditions;

public class HiddenRegionFormatting implements IHiddenRegionFormatter, IHiddenRegionFormatting {
	private Integer autowrap = null;
	private final AbstractFormatter2 formatter;
	private Integer indentationDecrease = null;
	private Integer indentationIncrease = null;
	private Integer newLineDefault = null;
	private Integer newLineMax = null;
	private Integer newLineMin = null;
	private Boolean noIndentation;
	private IAutowrapFormatter onAutowrap;
	private int priority = IHiddenRegionFormatter.NORMAL_PRIORITY;
	private String space = null;

	public HiddenRegionFormatting(AbstractFormatter2 formatter) {
		super();
		this.formatter = formatter;
	}

	public IHiddenRegionFormatting asBean() {
		return this;
	}

	public IHiddenRegionFormatter asFormatter() {
		return this;
	}

	public void autowrap() {
		if (this.autowrap == null || this.autowrap < 0)
			this.autowrap = 0; // TODO: can newLineMax = 0 suppress autowrap?
	}

	public void autowrap(int triggerLenght) {
		autowrap = triggerLenght;
	}

	public void decreaseIndentation() {
		indentationDecrease = indentationDecrease == null ? 1 : indentationDecrease + 1;
	}

	public Integer getAutowrap() {
		return this.autowrap;
	}

	public AbstractFormatter2 getFormatter() {
		return formatter;
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

	public Boolean getNoIndetation() {
		return noIndentation;
	}

	public IAutowrapFormatter getOnAutowrap() {
		return onAutowrap;
	}

	public int getPriority() {
		return priority;
	}

	public FormatterRequest getRequest() {
		return formatter.getRequest();
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

	protected <T> T merge(T val1, T val2, int strategy, String propertyname) throws ConflictingFormattingException {
		if (val1 != null && val2 != null) {
			if (val1.equals(val2) || strategy < 0)
				return val1;
			if (strategy > 0)
				return val2;
			String message = "Conflicting values for '" + propertyname + "': '" + val1 + "' and '" + val2 + "'.";
			throw new ConflictingFormattingException(message);
		}
		return val1 != null ? val1 : val2;
	}

	public void mergeValuesFrom(IHiddenRegionFormatting other) throws ConflictingFormattingException {
		int strategy = other.getPriority() - getPriority();
		setSpace(merge(getSpace(), other.getSpace(), strategy, "space"));
		setNewLinesMin(merge(getNewLineMin(), other.getNewLineMin(), strategy, "newLineMin"));
		setNewLinesDefault(merge(getNewLineDefault(), other.getNewLineDefault(), strategy, "newLineDefault"));
		setNewLinesMax(merge(getNewLineMax(), other.getNewLineMax(), strategy, "newLineMax"));
		setAutowrap(merge(getAutowrap(), other.getAutowrap(), strategy, "autowrap"));
		setOnAutowrap(merge(getOnAutowrap(), other.getOnAutowrap(), strategy, "onAutowrap"));
		setNoIndentation(merge(getNoIndetation(), other.getNoIndetation(), strategy, "noIndentation"));

		if (getIndentationIncrease() != null && other.getIndentationIncrease() != null)
			setIndentationIncrease(getIndentationIncrease() + other.getIndentationIncrease());
		else
			setIndentationIncrease(getIndentationIncrease() != null ? getIndentationIncrease() : other
					.getIndentationIncrease());
		if (getIndentationDecrease() != null && other.getIndentationDecrease() != null)
			setIndentationDecrease(getIndentationDecrease() + other.getIndentationDecrease());
		else
			setIndentationDecrease(getIndentationDecrease() != null ? getIndentationDecrease() : other
					.getIndentationDecrease());
	}

	public void newLine() {
		setNewLines(1);
	}

	public void noAutowrap() {
		this.autowrap = -1;
	}

	public void noIndentation() {
		this.noIndentation = Boolean.TRUE;
	}

	public void noSpace() {
		setSpace("");
	}

	public void oneSpace() {
		setSpace(" ");
	}

	public void setAutowrap(Integer value) {
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

	public void setNoIndentation(Boolean value) {
		this.noIndentation = value;
	}

	public void setOnAutowrap(IAutowrapFormatter formatter) {
		autowrap();
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