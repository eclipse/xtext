/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import org.eclipse.xtext.formatting2.FormatterRequest;
import org.eclipse.xtext.formatting2.IAutowrapFormatter;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatting;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.9
 */
public class DoubleHiddenRegionFormatter extends AbstractHiddenRegionFormatter {

	private final IHiddenRegionFormatting first;
	private final IHiddenRegionFormatting second;

	public DoubleHiddenRegionFormatter(IHiddenRegionFormatting first, IHiddenRegionFormatting second) {
		super();
		this.first = first;
		this.second = second;
	}

	@Override
	public void autowrap() {
		Integer old1 = first.getAutowrap();
		if (old1 == null || old1 < 0)
			first.setAutowrap(0);
		Integer old2 = second.getAutowrap();
		if (old2 == null || old2 < 0)
			second.setAutowrap(0);
	}

	@Override
	public void autowrap(int triggerLength) {
		first.setAutowrap(triggerLength);
		second.setAutowrap(triggerLength);
	}

	@Override
	public FormatterRequest getRequest() {
		return first.getRequest();
	}

	@Override
	public void indent() {
		Integer inc = first.getIndentationIncrease();
		Integer dec = second.getIndentationDecrease();
		first.setIndentationIncrease(inc == null ? 1 : inc + 1);
		second.setIndentationDecrease(dec == null ? 1 : dec + 1);
	}

	@Override
	public void noAutowrap() {
		first.setAutowrap(-1);
		second.setAutowrap(-1);
	}

	@Override
	public void noIndentation() {
		first.setNoIndentation(true);
		second.setNoIndentation(true);
	}

	@Override
	public void setNewLines(int minNewLines, int defaultNewLines, int maxNewLines) {
		first.setNewLinesMin(minNewLines);
		first.setNewLinesDefault(defaultNewLines);
		first.setNewLinesMax(maxNewLines);
		second.setNewLinesMin(minNewLines);
		second.setNewLinesDefault(defaultNewLines);
		second.setNewLinesMax(maxNewLines);
	}

	@Override
	public void setOnAutowrap(IAutowrapFormatter formatter) {
		autowrap();
		first.setOnAutowrap(formatter);
		second.setOnAutowrap(formatter);
	}

	@Override
	public void setPriority(int priority) {
		first.setPriority(priority);
		second.setPriority(priority);
	}

	@Override
	public void setSpace(String space) {
		first.setSpace(space);
		second.setSpace(space);
	}

}
