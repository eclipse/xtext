/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.util.Strings;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TestDataUtil {

	public final static String ENCODING = "UTF-8";
	public final static String KEY_VALUE_SEPARATOR = "=";
	public final static String SEGMENT_SEPARATOR = ";";

	public static Map<String, String> decode(String data) {
		try {
			if (Strings.isEmpty(data))
				return Collections.emptyMap();
			Map<String, String> result = Maps.newHashMap();
			String[] strings = data.split(SEGMENT_SEPARATOR);
			if (strings.length == 1)
				result.put("title", strings[0]);
			else
				for (String segment : strings) {
					String items[] = segment.split(KEY_VALUE_SEPARATOR, 2);
					if (items.length == 2)
						result.put(items[0], URLDecoder.decode(items[1], ENCODING));
				}
			return result;
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	public static String encode(Map<String, String> data) {
		try {
			List<String> result = Lists.newArrayList();
			for (Map.Entry<String, String> e : data.entrySet())
				result.add(e.getKey() + KEY_VALUE_SEPARATOR + URLEncoder.encode(e.getValue(), ENCODING));
			return Joiner.on(SEGMENT_SEPARATOR).join(result);
		} catch (UnsupportedEncodingException e1) {
			throw new RuntimeException(e1);
		}
	}

}
