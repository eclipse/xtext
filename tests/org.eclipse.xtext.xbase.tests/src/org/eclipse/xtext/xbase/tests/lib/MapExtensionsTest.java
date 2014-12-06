/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.lib;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.eclipse.xtext.xbase.lib.Pair;

/**
 * @author Stephane Galland - Initial contribution and API
 */
public class MapExtensionsTest extends Assert {

	private Map<String, String> map;
	private String key1;
	private String key2;
	private String value1;
	private String value2;

	@Before
	public void setUp() {
		this.map = new HashMap<>();
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
	public void operator_addMapMap_0() {
		String v1 = UUID.randomUUID().toString();
		String v2 = UUID.randomUUID().toString();
		String v3 = UUID.randomUUID().toString();
		Map<String, String> o;

		Map<String, String> tmp = new HashMap<>();
		tmp.put("k3", v1);
		tmp.put("k4", v2);
		tmp.put("k5", v3);

		o = operator_add(this.map, tmp);
		assertSame(this.map, o);
		assertEquals(5, this.map.size());
		assertEquals(this.value1, this.map.get("k1"));
		assertEquals(this.value2, this.map.get("k2"));
		assertEquals(v1, this.map.get("k3"));
		assertEquals(v2, this.map.get("k4"));
		assertEquals(v3, this.map.get("k5"));
	}

	@Test
	public void operator_addMapMap_1() {
		String v1 = UUID.randomUUID().toString();
		String v2 = UUID.randomUUID().toString();
		String v3 = UUID.randomUUID().toString();
		Map<String, String> o;

		Map<String, String> tmp = new HashMap<>();
		tmp.put("k3", v1);
		tmp.put("k2", v2);
		tmp.put("k5", v3);

		o = operator_add(this.map, tmp);
		assertSame(this.map, o);
		assertEquals(4, this.map.size());
		assertEquals(this.value1, this.map.get("k1"));
		assertEquals(v2, this.map.get("k2"));
		assertEquals(v1, this.map.get("k3"));
		assertEquals(v3, this.map.get("k5"));
	}

	@Test
	public void operator_pluMapPair_0() {
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
	public void operator_pluMapPair_1() {
		String v = UUID.randomUUID().toString();
		Map<String, String> o;

		o = operator_plus(this.map, new Pair<String, String>("k2", v));
		assertNotNull(o);
		assertNotSame(this.map, o);
		assertEquals(2, this.map.size());
		assertEquals(this.value1, this.map.get("k1"));
		assertEquals(this.value2, this.map.get("k2"));
		assertEquals(2, o.size());
		assertEquals(this.value1, o.get("k1"));
		assertEquals(v, o.get("k2"));
	}

	@Test
	public void operator_plusPairMap_0() {
		String v = UUID.randomUUID().toString();
		Map<String, String> o;

		o = operator_plus(new Pair<String, String>("k3", v), this.map);
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
	public void operator_pluPairMap_1() {
		String v = UUID.randomUUID().toString();
		Map<String, String> o;

		o = operator_plus(new Pair<String, String>("k2", v), this.map);
		assertNotNull(o);
		assertNotSame(this.map, o);
		assertEquals(2, this.map.size());
		assertEquals(this.value1, this.map.get("k1"));
		assertEquals(this.value2, this.map.get("k2"));
		assertEquals(2, o.size());
		assertEquals(this.value1, o.get("k1"));
		assertEquals(v, o.get("k2"));
	}

	@Test
	public void operator_plusMapMap_0() {
		String v1 = UUID.randomUUID().toString();
		String v2 = UUID.randomUUID().toString();
		String v3 = UUID.randomUUID().toString();
		Map<String, String> o;

		Map<String, String> tmp = new HashMap<>();
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

		Map<String, String> tmp = new HashMap<>();
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
	public void operator_removeMapPair_0() {
		String o = operator_remove(this.map, new Pair<String, String>("k0", "v0"));
		assertEquals(2, this.map.size());
		assertEquals(this.value1, this.map.get("k1"));
		assertEquals(this.value2, this.map.get("k2"));
		assertSame(this.map, o);
	}

	@Test
	public void operator_removeMapPair_1() {
		String o = operator_remove(this.map, new Pair<String, String>("k1", "v0"));
		assertEquals(2, this.map.size());
		assertEquals(this.value1, this.map.get("k1"));
		assertEquals(this.value2, this.map.get("k2"));
		assertSame(this.map, o);
	}

	@Test
	public void operator_removeMapPair_2() {
		String o = operator_remove(this.map, new Pair<String, String>("k1", this.value1));
		assertEquals(1, this.map.size());
		assertNull(this.map.get("k1"));
		assertEquals(this.value2, this.map.get("k2"));
		assertSame(this.map, o);
	}

	@Test
	public void operator_removeMapMap_0() {
		Map<String, String> m = new HashMap<>();
		m.put("k0", "v0");
		m.put("k1", "v0");
		String o = operator_remove(this.map, m);
		assertEquals(2, this.map.size());
		assertEquals(this.value1, this.map.get("k1"));
		assertEquals(this.value2, this.map.get("k2"));
		assertSame(this.map, o);
	}

	@Test
	public void operator_removeMapMap_0() {
		Map<String, String> m = new HashMap<>();
		m.put("k0", "v0");
		m.put("k1", this.value1);
		String o = operator_remove(this.map, m);
		assertEquals(1, this.map.size());
		assertNull(this.map.get("k1"));
		assertEquals(this.value2, this.map.get("k2"));
		assertSame(this.map, o);
	}

	@Test
	public void operator_removeMapIterable() {
		List<String> m = new ArrayList<>();
		m.add("k0");
		m.add("k1");
		String o = operator_remove(this.map, m);
		assertEquals(1, this.map.size());
		assertNull(this.map.get("k1"));
		assertEquals(this.value2, this.map.get("k2"));
		assertSame(this.map, o);
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
