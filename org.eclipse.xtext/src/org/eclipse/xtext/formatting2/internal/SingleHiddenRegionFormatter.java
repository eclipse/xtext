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
public class SingleHiddenRegionFormatter extends AbstractHiddenRegionFormatter {

	private final IHiddenRegionFormatting formatting;

	public SingleHiddenRegionFormatter(IHiddenRegionFormatting formatting) {
		super();
		this.formatting = formatting;
	}

	@Override
	public void autowrap() {
		Integer old = formatting.getAutowrap();
		if (old == null || old < 0)
			formatting.setAutowrap(0);
	}

	@Override
	public void autowrap(int triggerLength) {
		formatting.setAutowrap(triggerLength);
	}

	@Override
	public FormatterRequest getRequest() {
		return formatting.getRequest();
	}

	@Override
	public void indent() {
		Integer inc = formatting.getIndentationIncrease();
		Integer dec = formatting.getIndentationDecrease();
		formatting.setIndentationIncrease(inc == null ? 1 : inc + 1);
		formatting.setIndentationDecrease(dec == null ? 1 : dec + 1);
	}

	@Override
	public void noAutowrap() {
		formatting.setAutowrap(-1);
	}

	@Override
	public void noIndentation() {
		formatting.setNoIndentation(true);
	}

	@Override
	public void setNewLines(int minNewLines, int defaultNewLines, int maxNewLines) {
		formatting.setNewLinesMin(minNewLines);
		formatting.setNewLinesDefault(defaultNewLines);
		formatting.setNewLinesMax(maxNewLines);
	}

	@Override
	public void setOnAutowrap(IAutowrapFormatter formatter) {
		autowrap();
		formatting.setOnAutowrap(formatter);
	}

	@Override
	public void setPriority(int priority) {
		formatting.setPriority(priority);
	}

	@Override
	public void setSpace(String space) {
		formatting.setSpace(space);
	}

}
