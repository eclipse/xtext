/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.ConflictingFormattingException;
import org.eclipse.xtext.formatting2.FormatterRequest;
import org.eclipse.xtext.formatting2.IAutowrapFormatter;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatting;
import org.eclipse.xtext.formatting2.debug.HiddenRegionFormattingToString;

public class HiddenRegionFormatting implements IHiddenRegionFormatting {
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

	@Override
	public Integer getAutowrap() {
		return this.autowrap;
	}

	public AbstractFormatter2 getFormatter() {
		return formatter;
	}

	@Override
	public Integer getIndentationDecrease() {
		return indentationDecrease;
	}

	@Override
	public Integer getIndentationIncrease() {
		return indentationIncrease;
	}

	@Override
	public Integer getNewLineDefault() {
		return newLineDefault;
	}

	@Override
	public Integer getNewLineMax() {
		return newLineMax;
	}

	@Override
	public Integer getNewLineMin() {
		return newLineMin;
	}

	@Override
	public Boolean getNoIndentation() {
		return noIndentation;
	}

	@Override
	public IAutowrapFormatter getOnAutowrap() {
		return onAutowrap;
	}

	@Override
	public int getPriority() {
		return priority;
	}

	@Override
	public FormatterRequest getRequest() {
		return formatter.getRequest();
	}

	@Override
	public String getSpace() {
		return space;
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

	@Override
	public void mergeValuesFrom(IHiddenRegionFormatting other) throws ConflictingFormattingException {
		int strategy = Integer.compare(other.getPriority(), getPriority());
		setSpace(merge(getSpace(), other.getSpace(), strategy, "space"));
		setNewLinesMin(merge(getNewLineMin(), other.getNewLineMin(), strategy, "newLineMin"));
		setNewLinesDefault(merge(getNewLineDefault(), other.getNewLineDefault(), strategy, "newLineDefault"));
		setNewLinesMax(merge(getNewLineMax(), other.getNewLineMax(), strategy, "newLineMax"));
		setAutowrap(merge(getAutowrap(), other.getAutowrap(), strategy, "autowrap"));
		setOnAutowrap(merge(getOnAutowrap(), other.getOnAutowrap(), strategy, "onAutowrap"));
		setNoIndentation(merge(getNoIndentation(), other.getNoIndentation(), strategy, "noIndentation"));
		setPriority(merge(getPriority(), other.getPriority(), strategy, "priority"));

		if (getIndentationIncrease() != null && other.getIndentationIncrease() != null)
			setIndentationIncrease(getIndentationIncrease() + other.getIndentationIncrease());
		else
			setIndentationIncrease(
					getIndentationIncrease() != null ? getIndentationIncrease() : other.getIndentationIncrease());
		if (getIndentationDecrease() != null && other.getIndentationDecrease() != null)
			setIndentationDecrease(getIndentationDecrease() + other.getIndentationDecrease());
		else
			setIndentationDecrease(
					getIndentationDecrease() != null ? getIndentationDecrease() : other.getIndentationDecrease());
	}

	@Override
	public void setAutowrap(Integer value) {
		this.autowrap = value;
	}

	@Override
	public void setIndentationDecrease(Integer indentation) {
		this.indentationDecrease = indentation;
	}

	@Override
	public void setIndentationIncrease(Integer indentation) {
		this.indentationIncrease = indentation;
	}

	@Override
	public void setNewLinesDefault(Integer newLines) {
		this.newLineDefault = newLines;
	}

	@Override
	public void setNewLinesMax(Integer newLines) {
		this.newLineMax = newLines;
	}

	@Override
	public void setNewLinesMin(Integer newLines) {
		this.newLineMin = newLines;
	}

	@Override
	public void setNoIndentation(Boolean value) {
		this.noIndentation = value;
	}

	@Override
	public void setOnAutowrap(IAutowrapFormatter formatter) {
		this.onAutowrap = formatter;
	}

	@Override
	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
	public void setSpace(String space) {
		this.space = space;
	}

	@Override
	public String toString() {
		return new HiddenRegionFormattingToString().apply(this);
	}

}