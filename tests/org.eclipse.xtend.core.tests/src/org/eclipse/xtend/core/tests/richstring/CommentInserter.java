/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.richstring;

import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.collect.Lists;


/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CommentInserter {
	
	private static boolean DISABLED = false;
	
	private Pattern pattern = Pattern.compile("('''|\u00BB)([^\u00AB]*)(\u00AB|''')");
	
	public List<String> getRichStringWithComments(String richString) {
		if (DISABLED)
			return Collections.singletonList(richString);
		List<String> result = Lists.newArrayList();
		Matcher matcher = pattern.matcher(richString);
		while(matcher.find()) {
			String group = matcher.group(2);
			int start = matcher.start(2);
			for(int i = 0; i <= group.length(); i++) {
				String begin = richString.substring(0, start + i);
				String end = richString.substring(start + i);
				result.add(begin + "\u00AB\u00BB" + end);
				result.add(begin + "\u00AB\n/* comment */\n\t\u00BB" + end);
				for(int j = i; j <= group.length(); j++) {
					String mid = richString.substring(start + i, start + j);
					end = richString.substring(start + j);
					result.add(begin + "\u00AB\u00BB" + mid + "\u00AB\u00BB" + end);
					result.add(begin + "\u00AB\n/* comment */\n\t\u00BB" + mid + "\u00AB\n/* comment */\n\t\u00BB" + end);
				}
			}
		}
		return result;
	}
	
}
