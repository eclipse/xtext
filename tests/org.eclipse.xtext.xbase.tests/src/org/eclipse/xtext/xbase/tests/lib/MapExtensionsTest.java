/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.lib;

import static org.eclipse.xtext.xbase.lib.MapExtensions.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import junit.framework.TestSuite;

import org.eclipse.xtext.xbase.lib.MapExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.testing.MapTestSuiteBuilder;
import com.google.common.collect.testing.TestStringMapGenerator;
import com.google.common.collect.testing.features.MapFeature;

/**
 * @author Stephane Galland - Initial contribution and API
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	MapExtensionsTest.DirectOperatorInvocationTests.class,
	MapExtensionsTest.UnionTests.class,
	MapExtensionsTest.OperatorPlusMapGuavaTests.class,
	MapExtensionsTest.OperatorPlusPairGuavaTests.class,
})
@SuppressWarnings("all")
public class MapExtensionsTest extends Assert {

	/**
	 * @author Stephane Galland - Initial contribution and API
	 */
	public class DirectOperatorInvocationTests {

		private Map<String, String> map;
		private String key1;
		private String key2;
		private String value1;
		private String value2;

		@Before
		public void setUp() {
			this.map = Maps.newHashMap();
			this.key1 = "k1"; //$NON-NLS-1$
			this.key2 = "k2"; //$NON-NLS-1$
			this.value1 = UUID.randomUUID().toString();
			this.value2 = UUID.randomUUID().toString();
			this.map.put(this.key1, this.value1);
			this.map.put(this.key2, this.value2);
		}

		@After
		public void tearDown() {
			this.key1 = this.value1 = null;
			this.key2 = this.value2 = null;
			this.map = null;
		}

		@Test
		public void operator_addMapPair_0() {
			String v = UUID.randomUUID().toString();
			String o;

			o = operator_add(this.map, new Pair<String, String>("k3", v));
			assertNull(o);
			assertEquals(3, this.map.size());
			assertEquals(this.value1, this.map.get("k1"));
			assertEquals(this.value2, this.map.get("k2"));
			assertEquals(v, this.map.get("k3"));
		}

		@Test
		public void operator_addMapPair_1() {
			String v = UUID.randomUUID().toString();
			String o;

			o = operator_add(this.map, new Pair<String, String>("k2", v));
			assertEquals(this.value2, o);
			assertEquals(2, this.map.size());
			assertEquals(this.value1, this.map.get("k1"));
			assertEquals(v, this.map.get("k2"));
		}

		@Test
		public void operator_plusMapPair_0() {
			String v = UUID.randomUUID().toString();
			Map<String, String> o;

			o = operator_plus(this.map, new Pair<String, String>("k3", v));
			assertNotNull(o);
			assertNotSame(this.map, o);
			assertEquals(2, this.map.size());
			assertEquals(this.value1, this.map.get("k1"));
			assertEquals(this.value2, this.map.get("k2"));
			assertEquals(3, o.size());
			assertEquals(this.value1, o.get("k1"));
			assertEquals(this.value2, o.get("k2"));
			assertEquals(v, o.get("k3"));
		}

		@Test
		public void operator_plusMapPair_1() {
			String v = UUID.randomUUID().toString();
			Map<String, String> o = operator_plus(this.map, new Pair<String, String>("k2", v));
			assertNotNull(o);
			assertNotSame(this.map, o);
			assertEquals(2, this.map.size());
			assertEquals(this.value1, this.map.get("k1"));
			assertEquals(this.value2, this.map.get("k2"));
			assertNull(this.map.get("k3"));
			assertEquals(2, o.size());
			assertEquals(this.value1, o.get("k1"));
			assertEquals(v, o.get("k2"));
			assertNull(o.get("k3"));
		}

		@Test
		public void operator_plusMapMap_0() {
			String v1 = UUID.randomUUID().toString();
			String v2 = UUID.randomUUID().toString();
			String v3 = UUID.randomUUID().toString();
			Map<String, String> o;

			Map<String, String> tmp = Maps.newHashMap();
			tmp.put("k3", v1);
			tmp.put("k4", v2);
			tmp.put("k5", v3);

			o = operator_plus(this.map, tmp);
			assertNotNull(o);
			assertNotSame(this.map, o);
			assertNotSame(tmp, o);
			assertEquals(2, this.map.size());
			assertEquals(this.value1, this.map.get("k1"));
			assertEquals(this.value2, this.map.get("k2"));
			assertEquals(3, tmp.size());
			assertEquals(v1, tmp.get("k3"));
			assertEquals(v2, tmp.get("k4"));
			assertEquals(v3, tmp.get("k5"));
			assertEquals(5, o.size());
			assertEquals(this.value1, o.get("k1"));
			assertEquals(this.value2, o.get("k2"));
			assertEquals(v1, o.get("k3"));
			assertEquals(v2, o.get("k4"));
			assertEquals(v3, o.get("k5"));
		}

		@Test
		public void operator_plusMapMap_1() {
			String v1 = UUID.randomUUID().toString();
			String v2 = UUID.randomUUID().toString();
			String v3 = UUID.randomUUID().toString();
			Map<String, String> o;

			Map<String, String> tmp = Maps.newHashMap();
			tmp.put("k3", v1);
			tmp.put("k4", v2);
			tmp.put("k5", v3);

			o = operator_plus(tmp, this.map);
			assertNotNull(o);
			assertNotSame(this.map, o);
			assertNotSame(tmp, o);
			assertEquals(2, this.map.size());
			assertEquals(this.value1, this.map.get("k1"));
			assertEquals(this.value2, this.map.get("k2"));
			assertEquals(3, tmp.size());
			assertEquals(v1, tmp.get("k3"));
			assertEquals(v2, tmp.get("k4"));
			assertEquals(v3, tmp.get("k5"));
			assertEquals(5, o.size());
			assertEquals(this.value1, o.get("k1"));
			assertEquals(this.value2, o.get("k2"));
			assertEquals(v1, o.get("k3"));
			assertEquals(v2, o.get("k4"));
			assertEquals(v3, o.get("k5"));
		}

		@Test
		public void operator_plusMapMap_2() {
			String v1 = UUID.randomUUID().toString();
			String v2 = UUID.randomUUID().toString();
			String v3 = UUID.randomUUID().toString();
			Map<String, String> o;

			Map<String, String> tmp = Maps.newHashMap();
			tmp.put("k3", v1);
			tmp.put("k1", v2);
			tmp.put("k5", v3);

			o = operator_plus(this.map, tmp);
			assertNotNull(o);
			assertEquals(4, o.size());
			assertEquals(v2, o.get("k1"));
			assertEquals(this.value2, o.get("k2"));
			assertEquals(v1, o.get("k3"));
			assertNull(o.get("k4"));
			assertEquals(v3, o.get("k5"));
		}

		@Test
		public void operator_plusMapMap_3() {
			String v1 = UUID.randomUUID().toString();
			String v2 = UUID.randomUUID().toString();
			String v3 = UUID.randomUUID().toString();
			Map<String, String> o;

			Map<String, String> tmp = Maps.newHashMap();
			tmp.put("k3", v1);
			tmp.put("k1", v2);
			tmp.put("k5", v3);

			o = operator_plus(tmp, this.map);
			assertNotNull(o);
			assertEquals(4, o.size());
			assertEquals(this.value1, o.get("k1"));
			assertEquals(this.value2, o.get("k2"));
			assertEquals(v1, o.get("k3"));
			assertNull(o.get("k4"));
			assertEquals(v3, o.get("k5"));
		}

		@Test
		public void operator_removeMapK_0() {
			String o = operator_remove(this.map, "k0");
			assertEquals(2, this.map.size());
			assertEquals(this.value1, this.map.get("k1"));
			assertEquals(this.value2, this.map.get("k2"));
			assertNull(o);
		}

		@Test
		public void operator_removeMapK_1() {
			String o = operator_remove(this.map, "k1");
			assertEquals(1, this.map.size());
			assertNull(this.map.get("k1"));
			assertEquals(this.value2, this.map.get("k2"));
			assertEquals(this.value1, o);
		}

		@Test
		public void operator_removeMapK_2() {
			String o = operator_remove(this.map, "k2");
			assertEquals(1, this.map.size());
			assertEquals(this.value1, this.map.get("k1"));
			assertNull(this.map.get("k2"));
			assertEquals(this.value2, o);
		}

		@Test
		public void operator_removeMapK_3() {
			String o1 = operator_remove(this.map, "k2");
			String o2 = operator_remove(this.map, "k1");
			assertEquals(0, this.map.size());
			assertNull(this.map.get("k1"));
			assertNull(this.map.get("k2"));
			assertEquals(this.value2, o1);
			assertEquals(this.value1, o2);
		}

		@Test
		public void operator_removeMapIterable() {
			List<String> m = Lists.newArrayList();
			m.add("k0");
			m.add("k1");
			operator_remove(this.map, m);
			assertEquals(1, this.map.size());
			assertNull(this.map.get("k1"));
			assertEquals(this.value2, this.map.get("k2"));
		}

		@Test
		public void operator_minusMapK_0() {
			Map<String, String> o = operator_minus(this.map, "k0");
			assertEquals(2, this.map.size());
			assertEquals(this.value1, this.map.get("k1"));
			assertEquals(this.value2, this.map.get("k2"));
			assertNotNull(o);
			assertNotSame(this.map, o);
			assertEquals(2, o.size());
			assertEquals(this.value1, o.get("k1"));
			assertEquals(this.value2, o.get("k2"));
		}

		@Test
		public void operator_minusMapK_1() {
			Map<String, String> o = operator_minus(this.map, "k2");
			assertEquals(2, this.map.size());
			assertEquals(this.value1, this.map.get("k1"));
			assertEquals(this.value2, this.map.get("k2"));
			assertNotNull(o);
			assertNotSame(this.map, o);
			assertEquals(1, o.size());
			assertEquals(this.value1, o.get("k1"));
			assertNull(o.get("k2"));
		}

		@Test
		public void operator_minusMapK_2() {
			Map<String, String> o1 = operator_minus(this.map, "k2");
			Map<String, String> o2 = operator_minus(o1, "k1");
			assertEquals(2, this.map.size());
			assertEquals(this.value1, this.map.get("k1"));
			assertEquals(this.value2, this.map.get("k2"));
			assertNotNull(o1);
			assertNotSame(this.map, o1);
			assertEquals(1, o1.size());
			assertEquals(this.value1, o1.get("k1"));
			assertNull(o1.get("k2"));
			assertNotNull(o2);
			assertNotSame(this.map, o2);
			assertEquals(0, o2.size());
			assertNull(o2.get("k1"));
			assertNull(o2.get("k2"));
		}

	}
	
	/**
	 * @author Stephane Galland - Initial contribution and API
	 */
	public class UnionTests {

		private Map<String, String> left;
		private Map<String, String> right1;
		private Map<String, String> right2;
		private Map<String, String> map0;
		private Map<String, String> map1;
		private Map<String, String> map2;
		private Map<String, String> map3;

		@Before
		public void setUp() {
			this.left = Maps.newHashMap();
			this.left.put("a", "va");
			this.left.put("b", "vb");
			this.left.put("c", "vc");
			this.right1 = Maps.newHashMap();
			this.right1.put("d", "vd");
			this.right1.put("b", "vb2");
			this.right2 = Maps.newHashMap();
			this.right2.put("d", "vd");
			this.map0 = MapExtensions.union(Collections.<String, String>emptyMap(), Collections.<String, String>emptyMap());
			this.map1 = MapExtensions.union(this.left, this.right1);
			this.map2 = MapExtensions.union(this.left, this.right2);
			this.map3 = MapExtensions.union(this.left, Collections.<String, String>emptyMap());
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

	/**
	 * @author Stephane Galland - Initial contribution and API
	 */
	public static class OperatorPlusMapGuavaTests {

		public static TestSuite suite() {
			return MapTestSuiteBuilder
					// The create method is called with an array of elements
					// that should populate the collection.
					.using(new TestStringMapGenerator() {
						@Override
						protected Map<String, String> create(Entry<String, String>[] arg0) {
							Map<String, String> left = Maps.newHashMap();
							Map<String, String> right = Maps.newHashMap();
							int i;
							for(i = 0; i < arg0.length/2; ++i) {
								left.put(arg0[i].getKey(), arg0[i].getValue());
							}
							for(; i < arg0.length; ++i) {
								right.put(arg0[i].getKey(), arg0[i].getValue());
							}
							return MapExtensions.operator_plus(left, right);
						}


					})
					.named("Map+Map Guava tests")
					.withFeatures(
							MapFeature.GENERAL_PURPOSE,
							MapFeature.ALLOWS_NULL_VALUES,
							MapFeature.ALLOWS_NULL_KEYS
							).createTestSuite();
		}

	}

	/**
	 * @author Stephane Galland - Initial contribution and API
	 */
	public static class OperatorPlusPairGuavaTests {

		public static TestSuite suite() {
			return MapTestSuiteBuilder
					// The create method is called with an array of elements
					// that should populate the collection.
					.using(new TestStringMapGenerator() {
						@Override
						protected Map<String, String> create(Entry<String, String>[] arg0) {
							Map<String, String> left = Maps.newHashMap();
							if (arg0.length > 0) {
								Map<String, String> right = Maps.newHashMap();
								for(int i = 0; i < arg0.length - 1; ++i) {
									left.put(arg0[i].getKey(), arg0[i].getValue());
								}
								Pair<String, String> pair = new Pair<String, String>(arg0[arg0.length-1].getKey(), arg0[arg0.length-1].getValue());
								return MapExtensions.operator_plus(left, right);
							}
							return left;
						}


					})
					.named("Map+Pair Guava tests")
					.withFeatures(
							MapFeature.GENERAL_PURPOSE,
							MapFeature.ALLOWS_NULL_VALUES,
							MapFeature.ALLOWS_NULL_KEYS
							).createTestSuite();
		}

	}

	/**
	 * @author Stephane Galland - Initial contribution and API
	 */
	public class ViewTests {

		private Map<String, String> map1;
		private Map<String, String> map2;
		private Pair<String, String> pair;
		private String key11;
		private String key12;
		private String key21;
		private String value11;
		private String value12;
		private String value21;
		private String newKey;
		private String newValue;

		@Before
		public void setUp() {
			this.map1 = Maps.newHashMap();
			this.key11 = "k11"; //$NON-NLS-1$
			this.key12 = "k12"; //$NON-NLS-1$
			this.value11 = UUID.randomUUID().toString();
			this.value12 = UUID.randomUUID().toString();
			this.map1.put(this.key11, this.value11);
			this.map1.put(this.key12, this.value12);
			this.map2 = Maps.newHashMap();
			this.key21 = "k21"; //$NON-NLS-1$
			this.value21 = UUID.randomUUID().toString();
			this.map2.put(this.key21, this.value21);
			this.pair = new Pair<String, String>(this.key21, this.value21);
			this.newKey = UUID.randomUUID().toString();
			this.newValue = UUID.randomUUID().toString();
		}

		@After
		public void tearDown() {
			this.key11 = this.key12 = this.key21 = null;
			this.value11 = this.value12 = this.value21 = null;
			this.newKey = null;
			this.newValue = null;
			this.pair = null;
			this.map1 = this.map2 = null;
		}

		@Test
		public void operator_plusMapPair_remove() {
			Map<String, String> m = MapExtensions.operator_plus(this.map1, this.pair);
			assertNotNull(m);
			assertNotSame(this.map1, m);
			assertNotSame(this.pair, m);
			// Remove an element from the background map
			this.map1.remove(this.key12);
			// Check the view
			assertEquals(2, m.size());
			assertTrue(m.containsKey(this.key11));
			assertEquals(this.value11, m.get(this.key11));
			assertFalse(m.containsKey(this.key12));
			assertNull(m.get(this.key12));
			assertTrue(m.containsKey(this.key21));
			assertEquals(this.value21, m.get(this.key21));
			assertFalse(m.containsKey(this.newKey));
			assertNull(m.get(this.newKey));
		}

		@Test
		public void operator_plusMapPair_add() {
			Map<String, String> m = MapExtensions.operator_plus(this.map1, this.pair);
			assertNotNull(m);
			assertNotSame(this.map1, m);
			assertNotSame(this.pair, m);
			// Add an element in the background map
			this.map1.put(this.newKey, this.newValue);
			// Check the view
			assertEquals(4, m.size());
			assertTrue(m.containsKey(this.key11));
			assertEquals(this.value11, m.get(this.key11));
			assertTrue(m.containsKey(this.key12));
			assertEquals(this.value12, m.get(this.key12));
			assertTrue(m.containsKey(this.key21));
			assertEquals(this.value21, m.get(this.key21));
			assertTrue(m.containsKey(this.newKey));
			assertEquals(this.newValue, m.get(this.newKey));
		}

		@Test
		public void operator_plusMapPair_replace() {
			Map<String, String> m = MapExtensions.operator_plus(this.map1, this.pair);
			assertNotNull(m);
			assertNotSame(this.map1, m);
			assertNotSame(this.pair, m);
			// Replace an element in the background map
			this.map1.put(this.key11, this.newValue);
			// Check the view
			assertEquals(4, m.size());
			assertTrue(m.containsKey(this.key11));
			assertEquals(this.value11, m.get(this.newValue));
			assertTrue(m.containsKey(this.key12));
			assertEquals(this.value12, m.get(this.key12));
			assertTrue(m.containsKey(this.key21));
			assertEquals(this.value21, m.get(this.key21));
			assertFalse(m.containsKey(this.newKey));
			assertNull(m.get(this.newKey));
		}

		@Test
		public void operator_plusMapMap_removeIn1() {
			Map<String, String> m = MapExtensions.operator_plus(this.map1, this.map2);
			assertNotNull(m);
			assertNotSame(this.map1, m);
			assertNotSame(this.map2, m);
			// Remove an element from the background map
			this.map1.remove(this.key12);
			// Check the view
			assertEquals(2, m.size());
			assertTrue(m.containsKey(this.key11));
			assertEquals(this.value11, m.get(this.key11));
			assertFalse(m.containsKey(this.key12));
			assertNull(m.get(this.key12));
			assertTrue(m.containsKey(this.key21));
			assertEquals(this.value21, m.get(this.key21));
			assertFalse(m.containsKey(this.newKey));
			assertNull(m.get(this.newKey));
		}

		@Test
		public void operator_plusMapMap_addIn1() {
			Map<String, String> m = MapExtensions.operator_plus(this.map1, this.map2);
			assertNotNull(m);
			assertNotSame(this.map1, m);
			assertNotSame(this.map2, m);
			// Add an element in the background map
			this.map1.put(this.newKey, this.newValue);
			// Check the view
			assertEquals(4, m.size());
			assertTrue(m.containsKey(this.key11));
			assertEquals(this.value11, m.get(this.key11));
			assertTrue(m.containsKey(this.key12));
			assertEquals(this.value12, m.get(this.key12));
			assertTrue(m.containsKey(this.key21));
			assertEquals(this.value21, m.get(this.key21));
			assertTrue(m.containsKey(this.newKey));
			assertEquals(this.newValue, m.get(this.newKey));
		}

		@Test
		public void operator_plusMapMap_replaceIn1() {
			Map<String, String> m = MapExtensions.operator_plus(this.map1, this.map2);
			assertNotNull(m);
			assertNotSame(this.map1, m);
			assertNotSame(this.map2, m);
			// Replace an element in the background map
			this.map1.put(this.key11, this.newValue);
			// Check the view
			assertEquals(4, m.size());
			assertTrue(m.containsKey(this.key11));
			assertEquals(this.newValue, m.get(this.key11));
			assertTrue(m.containsKey(this.key12));
			assertEquals(this.value12, m.get(this.key12));
			assertTrue(m.containsKey(this.key21));
			assertEquals(this.value21, m.get(this.key21));
			assertFalse(m.containsKey(this.newKey));
			assertNull(m.get(this.newKey));
		}

		@Test
		public void operator_plusMapMap_removeIn2() {
			Map<String, String> m = MapExtensions.operator_plus(this.map1, this.map2);
			assertNotNull(m);
			assertNotSame(this.map1, m);
			assertNotSame(this.map2, m);
			// Remove an element from the background map
			this.map2.remove(this.key21);
			// Check the view
			assertEquals(2, m.size());
			assertTrue(m.containsKey(this.key11));
			assertEquals(this.value11, m.get(this.key11));
			assertTrue(m.containsKey(this.key12));
			assertEquals(this.value12, m.get(this.key12));
			assertFalse(m.containsKey(this.key21));
			assertNull(m.get(this.key21));
			assertFalse(m.containsKey(this.newKey));
			assertNull(m.get(this.newKey));
		}

		@Test
		public void operator_plusMapMap_addIn2() {
			Map<String, String> m = MapExtensions.operator_plus(this.map1, this.map2);
			assertNotNull(m);
			assertNotSame(this.map1, m);
			assertNotSame(this.map2, m);
			// Add an element in the background map
			this.map2.put(this.newKey, this.newValue);
			// Check the view
			assertEquals(4, m.size());
			assertTrue(m.containsKey(this.key11));
			assertEquals(this.value11, m.get(this.key11));
			assertTrue(m.containsKey(this.key12));
			assertEquals(this.value12, m.get(this.key12));
			assertTrue(m.containsKey(this.key21));
			assertEquals(this.value21, m.get(this.key21));
			assertTrue(m.containsKey(this.newKey));
			assertEquals(this.newValue, m.get(this.newKey));
		}

		@Test
		public void operator_plusMapMap_replaceIn2() {
			Map<String, String> m = MapExtensions.operator_plus(this.map1, this.map2);
			assertNotNull(m);
			assertNotSame(this.map1, m);
			assertNotSame(this.map2, m);
			// Replace an element in the background map
			this.map2.put(this.key21, this.newValue);
			// Check the view
			assertEquals(4, m.size());
			assertTrue(m.containsKey(this.key11));
			assertEquals(this.value11, m.get(this.key11));
			assertTrue(m.containsKey(this.key12));
			assertEquals(this.value12, m.get(this.key12));
			assertTrue(m.containsKey(this.key21));
			assertEquals(this.newValue, m.get(this.key21));
			assertFalse(m.containsKey(this.newKey));
			assertNull(m.get(this.newKey));
		}

		@Test
		public void operator_plusMapMap_addExistingKeyIn2() {
			Map<String, String> m = MapExtensions.operator_plus(this.map1, this.map2);
			assertNotNull(m);
			assertNotSame(this.map1, m);
			assertNotSame(this.map2, m);
			// Add an element in the background map
			this.map2.put(this.key11, this.newValue);
			// Check the view
			assertEquals(4, m.size());
			assertTrue(m.containsKey(this.key11));
			assertEquals(this.newValue, m.get(this.key11));
			assertTrue(m.containsKey(this.key12));
			assertEquals(this.value12, m.get(this.key12));
			assertTrue(m.containsKey(this.key21));
			assertEquals(this.value21, m.get(this.key21));
			assertFalse(m.containsKey(this.newKey));
			assertNull(m.get(this.newKey));
		}

		@Test
		public void operator_minusMapK_remove() {
			Map<String, String> m = MapExtensions.operator_minus(this.map1, this.key12);
			assertNotNull(m);
			assertNotSame(this.map1, m);
			// Remove an element from the background map
			this.map1.remove(this.key11);
			// Check the view
			assertEquals(0, m.size());
			assertFalse(m.containsKey(this.key11));
			assertNull(m.get(this.key11));
			assertFalse(m.containsKey(this.key12));
			assertNull(m.get(this.key12));
			assertFalse(m.containsKey(this.key21));
			assertNull(m.get(this.key21));
			assertFalse(m.containsKey(this.newKey));
			assertNull(m.get(this.newKey));
		}

		@Test
		public void operator_minusMapK_add() {
			Map<String, String> m = MapExtensions.operator_minus(this.map1, this.key12);
			assertNotNull(m);
			assertNotSame(this.map1, m);
			// Add an element in the background map
			this.map1.put(this.newKey, this.newValue);
			// Check the view
			assertEquals(2, m.size());
			assertTrue(m.containsKey(this.key11));
			assertEquals(this.value11, m.get(this.key11));
			assertFalse(m.containsKey(this.key12));
			assertNull(m.get(this.key12));
			assertFalse(m.containsKey(this.key21));
			assertNull(this.value21, m.get(this.key21));
			assertTrue(m.containsKey(this.newKey));
			assertEquals(this.newValue, m.get(this.newKey));
		}

		@Test
		public void operator_minusMapK_replace() {
			Map<String, String> m = MapExtensions.operator_minus(this.map1, this.key12);
			assertNotNull(m);
			assertNotSame(this.map1, m);
			// Replace an element in the background map
			this.map1.put(this.key11, this.newValue);
			// Check the view
			assertEquals(1, m.size());
			assertTrue(m.containsKey(this.key11));
			assertEquals(this.newValue, m.get(this.newValue));
			assertFalse(m.containsKey(this.key12));
			assertNull(m.get(this.key12));
			assertFalse(m.containsKey(this.key21));
			assertNull(m.get(this.key21));
			assertFalse(m.containsKey(this.newKey));
			assertNull(m.get(this.newKey));
		}

		@Test
		public void operator_minusMapMap_removeIn1() {
			this.map2.put(this.key12, UUID.randomUUID().toString());
			Map<String, String> m = MapExtensions.operator_minus(this.map1, this.map2);
			assertNotNull(m);
			assertNotSame(this.map1, m);
			assertNotSame(this.map2, m);
			// Remove an element from the background map
			this.map1.remove(this.key11);
			// Check the view
			assertEquals(0, m.size());
			assertFalse(m.containsKey(this.key11));
			assertNull(m.get(this.key11));
			assertFalse(m.containsKey(this.key12));
			assertNull(m.get(this.key12));
			assertFalse(m.containsKey(this.key21));
			assertNull(m.get(this.key21));
			assertFalse(m.containsKey(this.newKey));
			assertNull(m.get(this.newKey));
		}

		@Test
		public void operator_minusMapMap_addIn1() {
			this.map2.put(this.key12, UUID.randomUUID().toString());
			Map<String, String> m = MapExtensions.operator_minus(this.map1, this.map2);
			assertNotNull(m);
			assertNotSame(this.map1, m);
			assertNotSame(this.map2, m);
			// Add an element in the background map
			this.map1.put(this.newKey, this.newValue);
			// Check the view
			assertEquals(2, m.size());
			assertTrue(m.containsKey(this.key11));
			assertEquals(this.value11, m.get(this.key11));
			assertFalse(m.containsKey(this.key12));
			assertNull(m.get(this.key12));
			assertFalse(m.containsKey(this.key21));
			assertNull(m.get(this.key21));
			assertTrue(m.containsKey(this.newKey));
			assertEquals(this.newValue, m.get(this.newKey));
		}

		@Test
		public void operator_minusMapMap_replaceIn1() {
			this.map2.put(this.key12, UUID.randomUUID().toString());
			Map<String, String> m = MapExtensions.operator_minus(this.map1, this.map2);
			assertNotNull(m);
			assertNotSame(this.map1, m);
			assertNotSame(this.map2, m);
			// Replace an element in the background map
			this.map1.put(this.key11, this.newValue);
			// Check the view
			assertEquals(1, m.size());
			assertTrue(m.containsKey(this.key11));
			assertEquals(this.newValue, m.get(this.key11));
			assertFalse(m.containsKey(this.key12));
			assertNull(m.get(this.key12));
			assertFalse(m.containsKey(this.key21));
			assertNull(m.get(this.key21));
			assertFalse(m.containsKey(this.newKey));
			assertNull(m.get(this.newKey));
		}

		@Test
		public void operator_minusMapMap_removeIn2() {
			this.map2.put(this.key12, UUID.randomUUID().toString());
			Map<String, String> m = MapExtensions.operator_minus(this.map1, this.map2);
			assertNotNull(m);
			assertNotSame(this.map1, m);
			assertNotSame(this.map2, m);
			// Remove an element from the background map
			this.map2.remove(this.key12);
			// Check the view
			assertEquals(2, m.size());
			assertTrue(m.containsKey(this.key11));
			assertEquals(this.value11, m.get(this.key11));
			assertTrue(m.containsKey(this.key12));
			assertEquals(this.value12, m.get(this.key12));
			assertFalse(m.containsKey(this.key21));
			assertNull(m.get(this.key21));
			assertFalse(m.containsKey(this.newKey));
			assertNull(m.get(this.newKey));
		}

		@Test
		public void operator_minusMapMap_addIn2() {
			this.map2.put(this.key12, UUID.randomUUID().toString());
			Map<String, String> m = MapExtensions.operator_minus(this.map1, this.map2);
			assertNotNull(m);
			assertNotSame(this.map1, m);
			assertNotSame(this.map2, m);
			// Add an element in the background map
			this.map2.put(this.newKey, this.newValue);
			// Check the view
			assertEquals(1, m.size());
			assertTrue(m.containsKey(this.key11));
			assertEquals(this.value11, m.get(this.key11));
			assertFalse(m.containsKey(this.key12));
			assertNull(m.get(this.key12));
			assertFalse(m.containsKey(this.key21));
			assertNull(m.get(this.key21));
			assertFalse(m.containsKey(this.newKey));
			assertNull(m.get(this.newKey));
		}

		@Test
		public void operator_minusMapMap_replaceIn2() {
			this.map2.put(this.key12, UUID.randomUUID().toString());
			Map<String, String> m = MapExtensions.operator_minus(this.map1, this.map2);
			assertNotNull(m);
			assertNotSame(this.map1, m);
			assertNotSame(this.map2, m);
			// Replace an element in the background map
			this.map2.put(this.key12, UUID.randomUUID().toString());
			// Check the view
			assertEquals(2, m.size());
			assertTrue(m.containsKey(this.key11));
			assertEquals(this.value11, m.get(this.key11));
			assertTrue(m.containsKey(this.key12));
			assertEquals(this.value12, m.get(this.key12));
			assertFalse(m.containsKey(this.key21));
			assertNull(this.newValue, m.get(this.key21));
			assertFalse(m.containsKey(this.newKey));
			assertNull(m.get(this.newKey));
		}

		@Test
		public void operator_minusMapMap_addExistingKeyIn2() {
			this.map2.put(this.key12, UUID.randomUUID().toString());
			Map<String, String> m = MapExtensions.operator_minus(this.map1, this.map2);
			assertNotNull(m);
			assertNotSame(this.map1, m);
			assertNotSame(this.map2, m);
			// Add an element in the background map
			this.map2.put(this.key12, this.newValue);
			// Check the view
			assertEquals(1, m.size());
			assertTrue(m.containsKey(this.key11));
			assertEquals(this.newValue, m.get(this.key11));
			assertFalse(m.containsKey(this.key12));
			assertNull(m.get(this.key12));
			assertFalse(m.containsKey(this.key21));
			assertNull(m.get(this.key21));
			assertFalse(m.containsKey(this.newKey));
			assertNull(m.get(this.newKey));
		}

		@Test
		public void operator_minusMapIterable_removeIn1() {
			this.map2.put(this.key12, UUID.randomUUID().toString());
			Map<String, String> m = MapExtensions.operator_minus(this.map1, this.map2.keySet());
			assertNotNull(m);
			assertNotSame(this.map1, m);
			assertNotSame(this.map2, m);
			// Remove an element from the background map
			this.map1.remove(this.key11);
			// Check the view
			assertEquals(0, m.size());
			assertFalse(m.containsKey(this.key11));
			assertNull(m.get(this.key11));
			assertFalse(m.containsKey(this.key12));
			assertNull(m.get(this.key12));
			assertFalse(m.containsKey(this.key21));
			assertNull(m.get(this.key21));
			assertFalse(m.containsKey(this.newKey));
			assertNull(m.get(this.newKey));
		}

		@Test
		public void operator_minusMapIterable_addIn1() {
			this.map2.put(this.key12, UUID.randomUUID().toString());
			Map<String, String> m = MapExtensions.operator_minus(this.map1, this.map2.keySet());
			assertNotNull(m);
			assertNotSame(this.map1, m);
			assertNotSame(this.map2, m);
			// Add an element in the background map
			this.map1.put(this.newKey, this.newValue);
			// Check the view
			assertEquals(2, m.size());
			assertTrue(m.containsKey(this.key11));
			assertEquals(this.value11, m.get(this.key11));
			assertFalse(m.containsKey(this.key12));
			assertNull(m.get(this.key12));
			assertFalse(m.containsKey(this.key21));
			assertNull(m.get(this.key21));
			assertTrue(m.containsKey(this.newKey));
			assertEquals(this.newValue, m.get(this.newKey));
		}

		@Test
		public void operator_minusMapIterable_replaceIn1() {
			this.map2.put(this.key12, UUID.randomUUID().toString());
			Map<String, String> m = MapExtensions.operator_minus(this.map1, this.map2.keySet());
			assertNotNull(m);
			assertNotSame(this.map1, m);
			assertNotSame(this.map2, m);
			// Replace an element in the background map
			this.map1.put(this.key11, this.newValue);
			// Check the view
			assertEquals(1, m.size());
			assertTrue(m.containsKey(this.key11));
			assertEquals(this.newValue, m.get(this.key11));
			assertFalse(m.containsKey(this.key12));
			assertNull(m.get(this.key12));
			assertFalse(m.containsKey(this.key21));
			assertNull(m.get(this.key21));
			assertFalse(m.containsKey(this.newKey));
			assertNull(m.get(this.newKey));
		}

		@Test
		public void operator_minusMapIterable_removeIn2() {
			this.map2.put(this.key12, UUID.randomUUID().toString());
			Map<String, String> m = MapExtensions.operator_minus(this.map1, this.map2.keySet());
			assertNotNull(m);
			assertNotSame(this.map1, m);
			assertNotSame(this.map2, m);
			// Remove an element from the background map
			this.map2.remove(this.key12);
			// Check the view
			assertEquals(2, m.size());
			assertTrue(m.containsKey(this.key11));
			assertEquals(this.value11, m.get(this.key11));
			assertTrue(m.containsKey(this.key12));
			assertEquals(this.value12, m.get(this.key12));
			assertFalse(m.containsKey(this.key21));
			assertNull(m.get(this.key21));
			assertFalse(m.containsKey(this.newKey));
			assertNull(m.get(this.newKey));
		}

		@Test
		public void operator_minusMapIterable_addIn2() {
			this.map2.put(this.key12, UUID.randomUUID().toString());
			Map<String, String> m = MapExtensions.operator_minus(this.map1, this.map2.keySet());
			assertNotNull(m);
			assertNotSame(this.map1, m);
			assertNotSame(this.map2, m);
			// Add an element in the background map
			this.map2.put(this.newKey, this.newValue);
			// Check the view
			assertEquals(1, m.size());
			assertTrue(m.containsKey(this.key11));
			assertEquals(this.value11, m.get(this.key11));
			assertFalse(m.containsKey(this.key12));
			assertNull(m.get(this.key12));
			assertFalse(m.containsKey(this.key21));
			assertNull(m.get(this.key21));
			assertFalse(m.containsKey(this.newKey));
			assertNull(m.get(this.newKey));
		}

		@Test
		public void operator_minusMapIterable_replaceIn2() {
			this.map2.put(this.key12, UUID.randomUUID().toString());
			Map<String, String> m = MapExtensions.operator_minus(this.map1, this.map2.keySet());
			assertNotNull(m);
			assertNotSame(this.map1, m);
			assertNotSame(this.map2, m);
			// Replace an element in the background map
			this.map2.put(this.key12, UUID.randomUUID().toString());
			// Check the view
			assertEquals(2, m.size());
			assertTrue(m.containsKey(this.key11));
			assertEquals(this.value11, m.get(this.key11));
			assertTrue(m.containsKey(this.key12));
			assertEquals(this.value12, m.get(this.key12));
			assertFalse(m.containsKey(this.key21));
			assertNull(this.newValue, m.get(this.key21));
			assertFalse(m.containsKey(this.newKey));
			assertNull(m.get(this.newKey));
		}

		@Test
		public void operator_minusMapIterable_addExistingKeyIn2() {
			this.map2.put(this.key12, UUID.randomUUID().toString());
			Map<String, String> m = MapExtensions.operator_minus(this.map1, this.map2.keySet());
			assertNotNull(m);
			assertNotSame(this.map1, m);
			assertNotSame(this.map2, m);
			// Add an element in the background map
			this.map2.put(this.key12, this.newValue);
			// Check the view
			assertEquals(1, m.size());
			assertTrue(m.containsKey(this.key11));
			assertEquals(this.newValue, m.get(this.key11));
			assertFalse(m.containsKey(this.key12));
			assertNull(m.get(this.key12));
			assertFalse(m.containsKey(this.key21));
			assertNull(m.get(this.key21));
			assertFalse(m.containsKey(this.newKey));
			assertNull(m.get(this.newKey));
		}

		@Test
		public void unionMapMap_removeIn1() {
			Map<String, String> m = MapExtensions.union(this.map1, this.map2);
			assertNotNull(m);
			assertNotSame(this.map1, m);
			assertNotSame(this.map2, m);
			// Remove an element from the background map
			this.map1.remove(this.key12);
			// Check the view
			assertEquals(2, m.size());
			assertTrue(m.containsKey(this.key11));
			assertEquals(this.value11, m.get(this.key11));
			assertFalse(m.containsKey(this.key12));
			assertNull(m.get(this.key12));
			assertTrue(m.containsKey(this.key21));
			assertEquals(this.value21, m.get(this.key21));
			assertFalse(m.containsKey(this.newKey));
			assertNull(m.get(this.newKey));
		}

		@Test
		public void unionMapMap_addIn1() {
			Map<String, String> m = MapExtensions.union(this.map1, this.map2);
			assertNotNull(m);
			assertNotSame(this.map1, m);
			assertNotSame(this.map2, m);
			// Add an element in the background map
			this.map1.put(this.newKey, this.newValue);
			// Check the view
			assertEquals(4, m.size());
			assertTrue(m.containsKey(this.key11));
			assertEquals(this.value11, m.get(this.key11));
			assertTrue(m.containsKey(this.key12));
			assertEquals(this.value12, m.get(this.key12));
			assertTrue(m.containsKey(this.key21));
			assertEquals(this.value21, m.get(this.key21));
			assertTrue(m.containsKey(this.newKey));
			assertEquals(this.newValue, m.get(this.newKey));
		}

		@Test
		public void unionMapMap_replaceIn1() {
			Map<String, String> m = MapExtensions.union(this.map1, this.map2);
			assertNotNull(m);
			assertNotSame(this.map1, m);
			assertNotSame(this.map2, m);
			// Replace an element in the background map
			this.map1.put(this.key11, this.newValue);
			// Check the view
			assertEquals(4, m.size());
			assertTrue(m.containsKey(this.key11));
			assertEquals(this.newValue, m.get(this.key11));
			assertTrue(m.containsKey(this.key12));
			assertEquals(this.value12, m.get(this.key12));
			assertTrue(m.containsKey(this.key21));
			assertEquals(this.value21, m.get(this.key21));
			assertFalse(m.containsKey(this.newKey));
			assertNull(m.get(this.newKey));
		}

		@Test
		public void unionMapMap_removeIn2() {
			Map<String, String> m = MapExtensions.union(this.map1, this.map2);
			assertNotNull(m);
			assertNotSame(this.map1, m);
			assertNotSame(this.map2, m);
			// Remove an element from the background map
			this.map2.remove(this.key21);
			// Check the view
			assertEquals(2, m.size());
			assertTrue(m.containsKey(this.key11));
			assertEquals(this.value11, m.get(this.key11));
			assertTrue(m.containsKey(this.key12));
			assertEquals(this.value12, m.get(this.key12));
			assertFalse(m.containsKey(this.key21));
			assertNull(m.get(this.key21));
			assertFalse(m.containsKey(this.newKey));
			assertNull(m.get(this.newKey));
		}

		@Test
		public void unionMapMap_addIn2() {
			Map<String, String> m = MapExtensions.union(this.map1, this.map2);
			assertNotNull(m);
			assertNotSame(this.map1, m);
			assertNotSame(this.map2, m);
			// Add an element in the background map
			this.map2.put(this.newKey, this.newValue);
			// Check the view
			assertEquals(4, m.size());
			assertTrue(m.containsKey(this.key11));
			assertEquals(this.value11, m.get(this.key11));
			assertTrue(m.containsKey(this.key12));
			assertEquals(this.value12, m.get(this.key12));
			assertTrue(m.containsKey(this.key21));
			assertEquals(this.value21, m.get(this.key21));
			assertTrue(m.containsKey(this.newKey));
			assertEquals(this.newValue, m.get(this.newKey));
		}

		@Test
		public void unionMapMap_replaceIn2() {
			Map<String, String> m = MapExtensions.union(this.map1, this.map2);
			assertNotNull(m);
			assertNotSame(this.map1, m);
			assertNotSame(this.map2, m);
			// Replace an element in the background map
			this.map2.put(this.key21, this.newValue);
			// Check the view
			assertEquals(4, m.size());
			assertTrue(m.containsKey(this.key11));
			assertEquals(this.value11, m.get(this.key11));
			assertTrue(m.containsKey(this.key12));
			assertEquals(this.value12, m.get(this.key12));
			assertTrue(m.containsKey(this.key21));
			assertEquals(this.newValue, m.get(this.key21));
			assertFalse(m.containsKey(this.newKey));
			assertNull(m.get(this.newKey));
		}

		@Test
		public void unionMapMap_addExistingKeyIn2() {
			Map<String, String> m = MapExtensions.union(this.map1, this.map2);
			assertNotNull(m);
			assertNotSame(this.map1, m);
			assertNotSame(this.map2, m);
			// Add an element in the background map
			this.map2.put(this.key11, this.newValue);
			// Check the view
			assertEquals(4, m.size());
			assertTrue(m.containsKey(this.key11));
			assertEquals(this.newValue, m.get(this.key11));
			assertTrue(m.containsKey(this.key12));
			assertEquals(this.value12, m.get(this.key12));
			assertTrue(m.containsKey(this.key21));
			assertEquals(this.value21, m.get(this.key21));
			assertFalse(m.containsKey(this.newKey));
			assertNull(m.get(this.newKey));
		}
		
	}
	
}