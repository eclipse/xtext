/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.naming;

import junit.framework.TestCase;

/**
 * @author koehnlein - Initial contribution and API
 */
public class QualifiedNameTest extends TestCase {

	public void testCreateNull() {
		assertNull(QualifiedName.create());
		assertNull(QualifiedName.create((String[]) null));
		assertNull(QualifiedName.create((String) null));
		assertNull(QualifiedName.create(new String[0]));
	}

	public void testSegments() {
		QualifiedName qn = QualifiedName.create("foo", "bar", "baz");
		assertEquals(3, qn.getSegmentCount());
		assertEquals("foo", qn.getSegment(0));
		assertEquals("bar", qn.getSegment(1));
		assertEquals("baz", qn.getSegment(2));
		assertEquals("foo", qn.getFirstSegment());
		assertEquals("baz", qn.getLastSegment());
	}

	public void testStartsWith() {
		QualifiedName qn = QualifiedName.create("foo", "bar", "baz");
		QualifiedName qn1 = QualifiedName.create("foo", "bar");
		assertTrue(qn.startsWith(qn1));
		assertFalse(qn1.startsWith(qn));
		assertTrue(qn.startsWith(qn));

		assertTrue(qn.startsWithIgnoreCase(qn));
		QualifiedName qn2 = QualifiedName.create("FoO", "bAr");
		assertFalse(qn.startsWith(qn2));
		assertTrue(qn.startsWithIgnoreCase(qn2));
		assertFalse(qn2.startsWithIgnoreCase(qn));
	}

	public void testSkip() throws Exception {
		QualifiedName qn = QualifiedName.create("foo", "bar", "baz");
		QualifiedName baz = qn.skipFirst(2);
		assertEquals(1, baz.getSegmentCount());
		assertEquals("baz", baz.getSegment(0));
		assertNull(qn.skipFirst(3));
		
		QualifiedName foo = qn.skipLast(2);
		assertEquals(1, foo.getSegmentCount());
		assertEquals("foo", foo.getSegment(0));
		assertNull(qn.skipLast(3));
	}

	public void testAppend() {
		QualifiedName qn = QualifiedName.create("foo");
		QualifiedName fooBar = qn.append("bar");
		assertEquals(2, fooBar.getSegmentCount());
		assertEquals("foo", fooBar.getSegment(0));
		assertEquals("bar", fooBar.getSegment(1));

		QualifiedName fooBarFooBar = fooBar.append(fooBar);
		assertEquals(4, fooBarFooBar.getSegmentCount());
		assertEquals("foo", fooBarFooBar.getSegment(0));
		assertEquals("bar", fooBarFooBar.getSegment(1));
		assertEquals("foo", fooBarFooBar.getSegment(2));
		assertEquals("bar", fooBarFooBar.getSegment(3));
	}

	public void testEquals() {
		QualifiedName qn = QualifiedName.create("foo", "bar");
		assertEquals(qn, qn);
		assertNotSame(qn, qn.skipFirst(1));
		assertNotSame(qn, qn.skipLast(1));
		assertNotSame(qn, qn.append("baz"));
		
		QualifiedName qn1 = QualifiedName.create("Foo", "BAR");
		assertNotSame(qn, qn1);
		assertTrue(qn.equalsIgnoreCase(qn1));
		assertTrue(qn1.equalsIgnoreCase(qn));
		assertTrue(qn.equalsIgnoreCase(qn));
	}
	
	
	public void testCompare() throws Exception {
		QualifiedName a = QualifiedName.create("a");
		QualifiedName b = QualifiedName.create("b");
		assertTrue(a.compareTo(b) < 0);
		assertEquals(0, a.compareTo(a));
		assertTrue(b.compareTo(a) > 0);
		assertTrue(a.compareToIgnoreCase(b) < 0);
		assertEquals(0, a.compareToIgnoreCase(a));
		assertTrue(b.compareToIgnoreCase(a) > 0);
		
		QualifiedName aa = a.append("a");
		assertTrue(a.compareTo(aa) < 0);
		assertEquals(0, aa.compareTo(aa));
		assertTrue(aa.compareTo(a) > 0);
		assertTrue(a.compareToIgnoreCase(aa) < 0);
		assertEquals(0, aa.compareToIgnoreCase(aa));
		assertTrue(aa.compareToIgnoreCase(a) > 0);
		assertTrue(aa.compareTo(b) < 0);
		assertTrue(b.compareTo(aa) > 0);
		assertTrue(aa.compareToIgnoreCase(b) < 0);
		assertTrue(b.compareToIgnoreCase(aa) > 0);

		QualifiedName aA = a.append("A");
		assertTrue(aA.compareTo(aa) < 0);
		assertTrue(aa.compareTo(aA) > 0);
		assertEquals(0, aa.compareToIgnoreCase(aA));
	}
	
	public void testToString() throws Exception {
		QualifiedName qn = QualifiedName.create("foo", "bar");
		assertEquals("foo.bar", qn.toString());
	}
	
	public void testToCase() throws Exception {
		QualifiedName qn = QualifiedName.create("foo", "bar");
		QualifiedName qnUpper = qn.toUpperCase();
		assertFalse(qnUpper.equals(qn));
		assertTrue(qnUpper.equalsIgnoreCase(qn));
		assertEquals(qnUpper.toLowerCase(), qn);
		assertEquals(qn.toString().toUpperCase(), qnUpper.toString());
		assertEquals(qn.toString(), qnUpper.toLowerCase().toString());
	}
}
