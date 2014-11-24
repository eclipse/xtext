/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import java.util.List;

import org.eclipse.xtext.util.ITextRegion;

import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TextRegionListToString {

	protected static class Item {
		private boolean indented;
		private ITextRegion region;
		private String text;

		public Item(ITextRegion region, String text, boolean indented) {
			super();
			this.region = region;
			this.text = text;
			this.indented = indented;
		}
	}

	private List<Item> items = Lists.newArrayList();

	public void add(ITextRegion region, String text) {
		add(region, text, true);
	}

	protected void add(ITextRegion region, String text, boolean indented) {
		items.add(new Item(region, text, indented));
	}

	public void add(String text) {
		add(null, text, true);
	}

	public void add(String text, boolean indented) {
		add(null, text, indented);
	}

	@Override
	public String toString() {
		int offsetDigits = 0;
		int lenghtDigits = 0;
		for (Item item : items) {
			if (item.region != null) {
				int lenghtD = String.valueOf(item.region.getLength()).length();
				if (lenghtDigits < lenghtD)
					lenghtDigits = lenghtD;
				int lenghtO = String.valueOf(item.region.getOffset()).length();
				if (offsetDigits < lenghtO)
					offsetDigits = lenghtO;
			}
		}
		List<String> result = Lists.newArrayListWithExpectedSize(items.size());
		String prefix = Strings.repeat(" ", offsetDigits + lenghtDigits + 2);
		for (Item item : items) {
			if (item.region != null) {
				String offset = Strings.padStart(String.valueOf(item.region.getOffset()), offsetDigits, ' ');
				String length = Strings.padStart(String.valueOf(item.region.getLength()), lenghtDigits, ' ');
				result.add(offset + " " + length + " " + item.text);
			} else if (item.indented) {
				result.add(prefix + item.text);
			} else {
				result.add(item.text);
			}
		}
		return Joiner.on("\n").join(result);
	}
}
