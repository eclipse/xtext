/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem.util;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.xtext.xbase.typesystem.util.Maps2;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Objects;

/**
 * @author Stephane Galland - Initial contribution and API
 */
@SuppressWarnings("all")
public class MergedMaps2Test extends Assert {

	private Map<String, String> left;
	private Map<String, String> right1;
	private Map<String, String> right2;
	private Map<String, String> map0;
	private Map<String, String> map1;
	private Map<String, String> map2;
	private Map<String, String> map3;

	@Before
	public void setUp() {
		this.left = new HashMap<String, String>();
		this.left.put("a", "va");
		this.left.put("b", "vb");
		this.left.put("c", "vc");
		this.right1 = new HashMap<String, String>();
		this.right1.put("d", "vd");
		this.right1.put("b", "vb2");
		this.right2 = new HashMap<String, String>();
		this.right2.put("d", "vd");
		this.map0 = Maps2.union(Collections.<String, String>emptyMap(), Collections.<String, String>emptyMap());
		this.map1 = Maps2.union(this.left, this.right1);
		this.map2 = Maps2.union(this.left, this.right2);
		this.map3 = Maps2.union(this.left, Collections.<String, String>emptyMap());
	}

	@After
	public void tearDown() {
		this.left = null;
		this.right1 = null;
		this.right2 = null;
		this.map0 = null;
		this.map1 = null;
		this.map2 = null;
		this.map3 = null;
	}

	@Test
	public void size_map0() {
		assertEquals(0, this.map0.size());
	}

	@Test
	public void size_map1() {
		assertEquals(4, this.map1.size());
	}

	@Test
	public void size_map2() {
		assertEquals(4, this.map2.size());
	}

	@Test
	public void size_map3() {
		assertEquals(3, this.map3.size());
	}

	@Test
	public void isEmpty_map0() {
		assertTrue(this.map0.isEmpty());
	}

	@Test
	public void isEmpty_map1() {
		assertFalse(this.map1.isEmpty());
	}

	@Test
	public void isEmpty_map2() {
		assertFalse(this.map2.isEmpty());
	}

	@Test
	public void isEmpty_map3() {
		assertFalse(this.map3.isEmpty());
	}

	@Test
	public void containsKey_map0() {
		assertFalse(this.map0.containsKey("a"));
		assertFalse(this.map0.containsKey("b"));
		assertFalse(this.map0.containsKey("c"));
		assertFalse(this.map0.containsKey("d"));
		assertFalse(this.map0.containsKey("e"));
	}

	@Test
	public void containsKey_map1() {
		assertTrue(this.map1.containsKey("a"));
		assertTrue(this.map1.containsKey("b"));
		assertTrue(this.map1.containsKey("c"));
		assertTrue(this.map1.containsKey("d"));
		assertFalse(this.map1.containsKey("e"));
	}

	@Test
	public void containsKey_map2() {
		assertTrue(this.map2.containsKey("a"));
		assertTrue(this.map2.containsKey("b"));
		assertTrue(this.map2.containsKey("c"));
		assertTrue(this.map2.containsKey("d"));
		assertFalse(this.map2.containsKey("e"));
	}

	@Test
	public void containsKey_map3() {
		assertTrue(this.map3.containsKey("a"));
		assertTrue(this.map3.containsKey("b"));
		assertTrue(this.map3.containsKey("c"));
		assertFalse(this.map3.containsKey("d"));
		assertFalse(this.map3.containsKey("e"));
	}

	@Test
	public void containsValue_map0() {
		assertFalse(this.map0.containsValue("va"));
		assertFalse(this.map0.containsValue("vb"));
		assertFalse(this.map0.containsValue("vb2"));
		assertFalse(this.map0.containsValue("vc"));
		assertFalse(this.map0.containsValue("vd"));
		assertFalse(this.map0.containsValue("ve"));
	}

	@Test
	public void containsValue_map1() {
		assertTrue(this.map1.containsValue("va"));
		assertFalse(this.map1.containsValue("vb"));
		assertTrue(this.map1.containsValue("vb2"));
		assertTrue(this.map1.containsValue("vc"));
		assertTrue(this.map1.containsValue("vd"));
		assertFalse(this.map1.containsValue("ve"));
	}

	@Test
	public void containsValue_map2() {
		assertTrue(this.map2.containsValue("va"));
		assertTrue(this.map2.containsValue("vb"));
		assertFalse(this.map2.containsValue("vb2"));
		assertTrue(this.map2.containsValue("vc"));
		assertTrue(this.map2.containsValue("vd"));
		assertFalse(this.map2.containsValue("ve"));
	}

	@Test
	public void containsValue_map3() {
		assertTrue(this.map3.containsValue("va"));
		assertTrue(this.map3.containsValue("vb"));
		assertFalse(this.map3.containsValue("vb2"));
		assertTrue(this.map3.containsValue("vc"));
		assertFalse(this.map3.containsValue("vd"));
		assertFalse(this.map3.containsValue("ve"));
	}

	@Test
	public void get_map0() {
		assertNull(this.map0.get("a"));
		assertNull(this.map0.get("b"));
		assertNull(this.map0.get("c"));
		assertNull(this.map0.get("d"));
		assertNull(this.map0.get("e"));
	}

	@Test
	public void get_map1() {
		assertEquals("va", this.map1.get("a"));
		assertEquals("vb2", this.map1.get("b"));
		assertEquals("vc", this.map1.get("c"));
		assertEquals("vd", this.map1.get("d"));
		assertNull(this.map1.get("e"));
	}

	@Test
	public void get_map2() {
		assertEquals("va", this.map2.get("a"));
		assertEquals("vb", this.map2.get("b"));
		assertEquals("vc", this.map2.get("c"));
		assertEquals("vd", this.map2.get("d"));
		assertNull(this.map2.get("e"));
	}

	@Test
	public void get_map3() {
		assertEquals("va", this.map3.get("a"));
		assertEquals("vb", this.map3.get("b"));
		assertEquals("vc", this.map3.get("c"));
		assertNull(this.map3.get("d"));
		assertNull(this.map3.get("e"));
	}

	@Test(expected = UnsupportedOperationException.class)
	public void put_map0() {
		this.map0.put("zz", "zz");
	}

	@Test(expected = UnsupportedOperationException.class)
	public void put_map1() {
		this.map1.put("zz", "zz");
	}

	@Test(expected = UnsupportedOperationException.class)
	public void put_map2() {
		this.map2.put("zz", "zz");
	}

	@Test(expected = UnsupportedOperationException.class)
	public void put_map3() {
		this.map3.put("zz", "zz");
	}

	@Test(expected = UnsupportedOperationException.class)
	public void remove_map0() {
		this.map0.remove("zz");
	}

	@Test(expected = UnsupportedOperationException.class)
	public void remove_map1() {
		this.map1.remove("zz");
	}

	@Test(expected = UnsupportedOperationException.class)
	public void remove_map2() {
		this.map2.remove("zz");
	}

	@Test(expected = UnsupportedOperationException.class)
	public void remove_map3() {
		this.map3.remove("zz");
	}

	@Test(expected = UnsupportedOperationException.class)
	public void putAll_map0() {
		this.map0.putAll(null);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void putAll_map1() {
		this.map1.putAll(null);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void putAll_map2() {
		this.map2.putAll(null);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void putAll_map3() {
		this.map3.putAll(null);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void clear_map0() {
		this.map0.clear();
	}

	@Test(expected = UnsupportedOperationException.class)
	public void clear_map1() {
		this.map1.clear();
	}

	@Test(expected = UnsupportedOperationException.class)
	public void clear_map2() {
		this.map2.clear();
	}

	@Test(expected = UnsupportedOperationException.class)
	public void clear_map3() {
		this.map3.clear();
	}

	@Test
	public void keySet_map0() {
		Set<String> ks = this.map0.keySet();
		assertEquals(0, ks.size());
		assertFalse(this.map0.containsKey("a"));
		assertFalse(this.map0.containsKey("b"));
		assertFalse(this.map0.containsKey("c"));
		assertFalse(this.map0.containsKey("d"));
		assertFalse(this.map0.containsKey("e"));
	}

	@Test
	public void keySet_map1() {
		Set<String> ks = this.map1.keySet();
		assertEquals(4, ks.size());
		assertTrue(this.map1.containsKey("a"));
		assertTrue(this.map1.containsKey("b"));
		assertTrue(this.map1.containsKey("c"));
		assertTrue(this.map1.containsKey("d"));
		assertFalse(this.map1.containsKey("e"));
	}

	@Test
	public void keySet_map2() {
		Set<String> ks = this.map2.keySet();
		assertEquals(4, ks.size());
		assertTrue(this.map2.containsKey("a"));
		assertTrue(this.map2.containsKey("b"));
		assertTrue(this.map2.containsKey("c"));
		assertTrue(this.map2.containsKey("d"));
		assertFalse(this.map2.containsKey("e"));
	}

	@Test
	public void keySet_map3() {
		Set<String> ks = this.map3.keySet();
		assertEquals(3, ks.size());
		assertTrue(this.map3.containsKey("a"));
		assertTrue(this.map3.containsKey("b"));
		assertTrue(this.map3.containsKey("c"));
		assertFalse(this.map3.containsKey("d"));
		assertFalse(this.map3.containsKey("e"));
	}

	@Test
	public void values_map0() {
		Collection<String> vs = this.map0.values();
		assertEquals(0, vs.size());
		assertFalse(vs.contains("va"));
		assertFalse(vs.contains("vb"));
		assertFalse(vs.contains("vb2"));
		assertFalse(vs.contains("c"));
		assertFalse(vs.contains("d"));
		assertFalse(vs.contains("e"));
	}

	@Test
	public void values_map1() {
		Collection<String> vs = this.map1.values();
		assertEquals(4, vs.size());
		assertTrue(vs.contains("va"));
		assertFalse(vs.contains("vb"));
		assertTrue(vs.contains("vb2"));
		assertTrue(vs.contains("vc"));
		assertTrue(vs.contains("vd"));
		assertFalse(vs.contains("ve"));
	}

	@Test
	public void values_map2() {
		Collection<String> vs = this.map2.values();
		assertEquals(4, vs.size());
		assertTrue(vs.contains("va"));
		assertTrue(vs.contains("vb"));
		assertFalse(vs.contains("vb2"));
		assertTrue(vs.contains("vc"));
		assertTrue(vs.contains("vd"));
		assertFalse(vs.contains("ve"));
	}

	@Test
	public void values_map3() {
		Collection<String> vs = this.map3.values();
		assertEquals(3, vs.size());
		assertTrue(vs.contains("va"));
		assertTrue(vs.contains("vb"));
		assertFalse(vs.contains("vb2"));
		assertTrue(vs.contains("vc"));
		assertFalse(vs.contains("vd"));
		assertFalse(vs.contains("ve"));
	}

	private void assertContains(String k, String v, Set<Entry<String, String>> set) {
		for(Entry<String, String> entry : set) {
			if (Objects.equal(entry.getKey(), k)
				&& Objects.equal(entry.getValue(), v)) {
				return;
			}
		}
		fail("Entry with key '" + k + "' and value '" + v + "' is not found");
	}
	
	private void assertNotContains(String k, Set<Entry<String, String>> set) {
		for(Entry<String, String> entry : set) {
			if (Objects.equal(entry.getKey(), k)) {
				fail("Entry with key '" + k + "' is found");
				return;
			}
		}
	}

	@Test
	public void entrySet_map0() {
		Set<Entry<String, String>> ks = this.map0.entrySet();
		assertEquals(0, ks.size());
		assertNotContains("a", ks);
		assertNotContains("b", ks);
		assertNotContains("c", ks);
		assertNotContains("d", ks);
		assertNotContains("e", ks);
	}

	@Test
	public void entrySet_map1() {
		Set<Entry<String, String>> ks = this.map1.entrySet();
		assertEquals(4, ks.size());
		assertContains("a", "va", ks);
		assertContains("b", "vb2", ks);
		assertContains("c", "vc", ks);
		assertContains("d", "vd", ks);
		assertNotContains("e", ks);
	}

	@Test
	public void entrySet_map2() {
		Set<Entry<String, String>> ks = this.map2.entrySet();
		assertEquals(4, ks.size());
		assertContains("a", "va", ks);
		assertContains("b", "vb", ks);
		assertContains("c", "vc", ks);
		assertContains("d", "vd", ks);
		assertNotContains("e", ks);
	}

	@Test
	public void entrySet_map3() {
		Set<Entry<String, String>> ks = this.map3.entrySet();
		assertEquals(3, ks.size());
		assertContains("a", "va", ks);
		assertContains("b", "vb", ks);
		assertContains("c", "vc", ks);
		assertNotContains("d", ks);
		assertNotContains("e", ks);
	}

}
