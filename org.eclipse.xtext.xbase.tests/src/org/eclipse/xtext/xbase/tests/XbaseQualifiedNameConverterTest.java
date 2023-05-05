/**
 * Copyright (c) 2017, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.xbase.XbaseQualifiedNameConverter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Karsten Thoms (karsten.thoms@itemis.de) - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XbaseInjectorProvider.class)
public class XbaseQualifiedNameConverterTest {
	@Inject
	private XbaseQualifiedNameConverter converter;

	@Test
	public void test_toQualifiedName() {
		Map<List<String>, String> testdata = new HashMap<>();
		testdata.put(Lists.newArrayList("foo"), "foo");
		testdata.put(Lists.newArrayList("foo", "bar"), "foo.bar");
		testdata.put(Lists.newArrayList(".."), "..");
		testdata.put(Lists.newArrayList("..<"), "..<");
		testdata.put(Lists.newArrayList(">.."), ">..");
		for (Map.Entry<List<String>, String> e : testdata.entrySet()) {
			Assert.assertEquals(QualifiedName.create(e.getKey()), converter.toQualifiedName(e.getValue()));
		}
	}

	@Test
	public void test_toQualifiedName_null() {
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> converter.toQualifiedName(null));
		assertEquals("Qualified name cannot be null", e.getMessage());
	}

	@Test
	public void test_toQualifiedName_empty() {
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> converter.toQualifiedName(""));
		assertEquals("Qualified name cannot be empty", e.getMessage());
	}
}
