/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.data.highlighting;

import org.junit.Test;

@Deprecated
public class TestClassDeprecated {
	@Deprecated
	public static String DEPRECATED_CONSTANT = "foo";
	
	@Deprecated
	public static String CONSTANT = "foo";

	@Deprecated
	@Test
	public void testMethodDeprecated() {
	}

	@Test
	public void testMethodNotDeprecated() {
	}

	@Deprecated
	public static void testMethodStaticDeprecated() {
	}

	public static void testMethodStaticNotDeprecated() {
	}
};