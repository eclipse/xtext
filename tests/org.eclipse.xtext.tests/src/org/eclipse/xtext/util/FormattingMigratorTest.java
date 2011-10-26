/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.util.regex.Pattern;

import junit.framework.TestCase;

import org.eclipse.xtext.util.internal.FormattingMigrator;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class FormattingMigratorTest extends TestCase {

	private FormattingMigrator mig = new FormattingMigrator();

	private Pattern ws = Pattern.compile("\\s+");

	public void testRobust1() {
		String act = mig.migrate("  foo  bar  ", null, ws);
		assertNull(act);
	}

	public void testRobust2() {
		String act = mig.migrate("  foo  bar  ", "", ws);
		assertEquals("", act);
	}

	public void testRobust3() {
		String act = mig.migrate(null, "  foo  bar  ", ws);
		assertEquals("  foo  bar  ", act);
	}

	public void testRobust4() {
		String act = mig.migrate("", "  foo  bar  ", ws);
		assertEquals("  foo  bar  ", act);
	}

	public void testKeepFormatting() {
		String act = mig.migrate("  foo  bar  ", "  foo  bar  ", ws);
		assertEquals("  foo  bar  ", act);
	}

	public void testKeepFormatting2() {
		String act = mig.migrate("  foo  bar  ", "  foo bar  ", ws);
		assertEquals("  foo  bar  ", act);
	}

	public void testKeepFormatting3() {
		String act = mig.migrate("  foo   bar    baz  ", "foo baar baz", ws);
		assertEquals("  foo   baar    baz  ", act);
	}

	public void testInfix() {
		String act = mig.migrate("foo  z  bar", "xoo z bax", ws);
		assertEquals("xoo  z  bax", act);
	}

	public void testPrefix() {
		String act = mig.migrate("  foo xx", "foo yy", ws);
		assertEquals("  foo yy", act);
	}

	public void testPostfix() {
		String act = mig.migrate("xx foo  ", "yy foo", ws);
		assertEquals("yy foo  ", act);
	}

	public void testNoMatch1() {
		String act = mig.migrate("  x  y  z  ", "a b c", ws);
		assertEquals("a b c", act);
	}

	public void testPartialMatch() {
		String act = mig.migrate("  xxx zzz  ", "xxx  yyy  zzz", ws);
		assertEquals("  xxx  yyy  zzz  ", act);
	}

}
