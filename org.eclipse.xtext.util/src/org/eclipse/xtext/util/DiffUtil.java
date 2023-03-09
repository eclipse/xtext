/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util;

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.4
 */
public class DiffUtil {

	public static String diff(String one, String two) {
		int start = 0;
		int end = 0;
		int minLength = Math.min(one.length(), two.length());
		for (int i = 0; i < minLength; ++i) {
			if (one.charAt(i) == two.charAt(i))
				start = i + 1;
			else
				break;
		}
		if (start == one.length() && start == two.length())
			return null;
		if (start != 0 || one.length() != two.length()) {
			for (int i = 1; i <= minLength - start; ++i) {
				if (one.charAt(one.length() - i) == two.charAt(two.length() - i))
					end = i;
				else
					break;
			}
		}
		String commonPrefix = (start == 0) ? "" : shorten(one.substring(0, start), true);
		String commonSuffix = (end == 0) ? "" : shorten(one.substring(one.length() - end, one.length()), false);
		return commonPrefix + "[" + one.substring(start, one.length() - end) + "]" + commonSuffix
				+ "\nvs\n"
				+ commonPrefix + "[" + two.substring(start, two.length() - end) + "]" + commonSuffix;
	}
	
	protected static String shorten(String string, boolean isPrefix) {
		if(string.length() > 10) 
			if(isPrefix) 
				return "..." + string.substring(string.length() - 10);
			else
				return string.substring(0, 10) + "...";
		else
			return string;
	}
}
