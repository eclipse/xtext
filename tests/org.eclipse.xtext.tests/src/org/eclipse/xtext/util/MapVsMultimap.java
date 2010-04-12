/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import com.google.common.collect.Lists;
import com.google.inject.internal.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class MapVsMultimap extends TestCase {

	private int valuesPerBatch = 0;
	private int batches = 500000;
	private int iterations = 10;
	private List<String> allElements;
	private Map<String, Object> multimap;
	private Map<String, String> map;
	
	@SuppressWarnings("unchecked")
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		allElements = Lists.newArrayList();
		for(int batch = 0; batch < batches; batch++) {
			char c = 'A';
			c = (char) (c + (batch % 26));
			StringBuilder builder = new StringBuilder();
			for(int i = 0; i < valuesPerBatch; i++) {
				builder.append(c);
			}
			String s = builder.toString() + Integer.toString(batch);
			char[] chars = s.toCharArray();
			allElements.add(s);
			for(int i = 0; i < valuesPerBatch; i++) {
				if (batch % 20 == 0) {
					chars[i] = Character.toLowerCase(chars[i]);
				}
				allElements.add(new String(chars));
			}
		}
		map = Maps.newHashMap();
		for(String s: allElements) {
			map.put(s, s);
		}
		multimap = Maps.newHashMap();
		for(int i = 0; i< allElements.size(); i++) {
			String element = allElements.get(i);
			String lowerCase = element.toLowerCase();
			Object value = multimap.get(lowerCase);
			if (value == null) {
				multimap.put(lowerCase, element);
			} else if (value instanceof String) {
				value = Lists.newArrayList(value, element);
				multimap.put(lowerCase, value);
			} else {
				((List<Object>) value).add(element);
			}
		}
	}
	
	@Override
	protected void tearDown() throws Exception {
		map = null;
		multimap = null;
		allElements = null;
		super.tearDown();
	}
	
	public void testHashMultiMap() {
		for(int i = 0; i < iterations; i++) {
			for(int j = 0; j< allElements.size(); j++) {
				String s = allElements.get(j);
				String lowerCase = s.toLowerCase();
				Object value = multimap.get(lowerCase);
				if (value instanceof String) {
					value.equals(s);
				} else if (value instanceof List<?>) {
					List<?> values = (List<?>) value;
					for(int k = 0; k < values.size(); k++) {
						if (values.get(k).equals(s))
							break;
					}
				}
			}
		}
	}
	
	public void testHashMap() {
		for(int i = 0; i < iterations; i++) {
			for(String s: allElements) {
				map.get(s);
			}
		}
	}
	
}
