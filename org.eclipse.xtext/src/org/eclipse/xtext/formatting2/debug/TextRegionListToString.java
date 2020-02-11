/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.debug;

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
		int lengthDigits = 0;
		for (Item item : items) {
			if (item.region != null) {
				int lengthD = String.valueOf(item.region.getLength()).length();
				if (lengthDigits < lengthD)
					lengthDigits = lengthD;
				int lengthO = String.valueOf(item.region.getOffset()).length();
				if (offsetDigits < lengthO)
					offsetDigits = lengthO;
			}
		}
		List<String> result = Lists.newArrayListWithExpectedSize(items.size());
		String prefix = Strings.repeat(" ", offsetDigits + lengthDigits + 2);
		for (Item item : items) {
			String[] lines = item.text.split("\n");
			if (item.region != null) {
				String offset = Strings.padStart(String.valueOf(item.region.getOffset()), offsetDigits, ' ');
				String length = Strings.padStart(String.valueOf(item.region.getLength()), lengthDigits, ' ');
				if (lines.length == 1) {
					result.add(offset + " " + length + " " + lines[0]);
				} else {
					String offsetSpace = Strings.repeat(" ", offsetDigits);
					String lengthSpace = Strings.repeat(" ", lengthDigits);
					for (int i = 0; i < lines.length; i++) {
						String first = i == 0 ? offset : offsetSpace;
						String second = i == lines.length - 1 ? length : lengthSpace;
						result.add(first + " " + second + " " + lines[i]);
					}
				}
			} else if (item.indented) {
				for (int i = 0; i < lines.length; i++)
					result.add(prefix + lines[i]);
			} else {
				for (int i = 0; i < lines.length; i++)
					result.add(lines[i]);
			}
		}
		return Joiner.on("\n").join(result);
	}
}
