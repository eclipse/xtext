/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.util.regex.Pattern;

import org.eclipse.xtext.util.internal.FormattingMigrator;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class FormattingMigratorTest extends Assert {

	private FormattingMigrator mig = new FormattingMigrator();

	private Pattern ws = Pattern.compile("\\s+");

	@Test public void testRobust1() {
		String act = mig.migrate("  foo  bar  ", null, ws);
		assertNull(act);
	}

	@Test public void testRobust2() {
		String act = mig.migrate("  foo  bar  ", "", ws);
		assertEquals("", act);
	}

	@Test public void testRobust3() {
		String act = mig.migrate(null, "  foo  bar  ", ws);
		assertEquals("  foo  bar  ", act);
	}

	@Test public void testRobust4() {
		String act = mig.migrate("", "  foo  bar  ", ws);
		assertEquals("  foo  bar  ", act);
	}

	@Test public void testKeepFormatting() {
		String act = mig.migrate("  foo  bar  ", "  foo  bar  ", ws);
		assertEquals("  foo  bar  ", act);
	}

	@Test public void testKeepFormatting2() {
		String act = mig.migrate("  foo  bar  ", "  foo bar  ", ws);
		assertEquals("  foo  bar  ", act);
	}

	@Test public void testKeepFormatting3() {
		String act = mig.migrate("  foo   bar    baz  ", "foo baar baz", ws);
		assertEquals("  foo   baar    baz  ", act);
	}

	@Test public void testInfix() {
		String act = mig.migrate("foo  z  bar", "xoo z bax", ws);
		assertEquals("xoo  z  bax", act);
	}

	@Test public void testPrefix() {
		String act = mig.migrate("  foo xx", "foo yy", ws);
		assertEquals("  foo yy", act);
	}

	@Test public void testPostfix() {
		String act = mig.migrate("xx foo  ", "yy foo", ws);
		assertEquals("yy foo  ", act);
	}

	@Test public void testNoMatch1() {
		String act = mig.migrate("  x  y  z  ", "a b c", ws);
		assertEquals("a b c", act);
	}

	@Test public void testPartialMatch() {
		String act = mig.migrate("  xxx zzz  ", "xxx  yyy  zzz", ws);
		assertEquals("  xxx  yyy  zzz  ", act);
	}

}
