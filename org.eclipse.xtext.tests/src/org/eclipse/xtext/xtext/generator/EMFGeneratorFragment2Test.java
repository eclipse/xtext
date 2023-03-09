/**
 * Copyright (c) 2015, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator;

import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xtext.generator.ecore.EMFGeneratorFragment2;
import org.junit.Assert;
import org.junit.Test;

public class EMFGeneratorFragment2Test {
	@Extension
	private final EMFGeneratorFragment2 emfGeneratorFragment2 = new EMFGeneratorFragment2();

	@Test
	public void testTrimMultiLineString_01() {
		String original = "/*foo*/\n";
		String expected = "foo";
		assertTrim(expected, original);
	}

	@Test
	public void testTrimMultiLineString_02() {
		String original =
				"/* \n" +
				" * foo*/\n";
		String expected = "foo";
		assertTrim(expected, original);
	}

	@Test
	public void testTrimMultiLineString_03() {
		String original =
				"/* \n" +
				" * \n" +
				" * foo\n" +
				" */\n";
		String expected = "foo";
		assertTrim(expected, original);
	}

	@Test
	public void testTrimMultiLineString_04() {
		String original =
				"/* \n" +
				" * multi\n" +
				" * foo\n" +
				" * \n" +
				" */\n";
		String expected =
				"multi\n" +
				"foo";
		assertTrim(expected, original);
	}

	@Test
	public void testTrimMultiLineString_05() {
		String original = "/* foo */\n";
		String expected = "foo";
		assertTrim(expected, original);
	}

	@Test
	public void testTrimMultiLineString_06() {
		assertTrim("foo", "foo");
	}

	@Test
	public void testTrimMultiLineString_07() {
		String original =
				"/**\n" +
				" * Copyright (c) 2011, 2019 itemis AG (http://www.itemis.eu) and others.\n" +
				" * This program and the accompanying materials are made available under the\n" +
				" * terms of the Eclipse Public License 2.0 which is available at\n" +
				" * http://www.eclipse.org/legal/epl-2.0.\n" +
				" * \n" +
				" * SPDX-License-Identifier: EPL-2.0\n" +
				" */";
		String expected =
				"Copyright (c) 2011, 2019 itemis AG (http://www.itemis.eu) and others.\n" +
				"This program and the accompanying materials are made available under the\n" +
				"terms of the Eclipse Public License 2.0 which is available at\n" +
				"http://www.eclipse.org/legal/epl-2.0.\n" +
				"\n" +
				"SPDX-License-Identifier: EPL-2.0";
		assertTrim(expected, original);
	}

	@Test
	public void testTrimMultiLineString_08() {
		String original =
				"/*******************************************************************************\n" +
				" * Copyright (c) 2011, 2019 itemis AG (http://www.itemis.eu) and others.\n" +
				" * This program and the accompanying materials are made available under the\n" +
				" * terms of the Eclipse Public License 2.0 which is available at\n" +
				" * http://www.eclipse.org/legal/epl-2.0.\n" +
				" * \n" +
				" * SPDX-License-Identifier: EPL-2.0\n" +
				" *******************************************************************************/";
		String expected =
				"Copyright (c) 2011, 2019 itemis AG (http://www.itemis.eu) and others.\n" +
				"This program and the accompanying materials are made available under the\n" +
				"terms of the Eclipse Public License 2.0 which is available at\n" +
				"http://www.eclipse.org/legal/epl-2.0.\n" +
				"\n" +
				"SPDX-License-Identifier: EPL-2.0";
		assertTrim(expected, original);
	}

	@Test
	public void testTrimMultiLineString_09() {
		String original =
				"/*******************************************************************************\n" +
				" * Copyright (c) 2011, 2019 itemis AG (http://www.itemis.eu) and others.\n" +
				" * This program and the accompanying materials are made available under the\n" +
				" * terms of the Eclipse Public License 2.0 which is available at\n" +
				" * http://www.eclipse.org/legal/epl-2.0.\n" +
				" *\n" +
				" * SPDX-License-Identifier: EPL-2.0\n" +
				" *******************************************************************************/";
		String expected =
				"Copyright (c) 2011, 2019 itemis AG (http://www.itemis.eu) and others.\n" +
				"This program and the accompanying materials are made available under the\n" +
				"terms of the Eclipse Public License 2.0 which is available at\n" +
				"http://www.eclipse.org/legal/epl-2.0.\n" +
				"\n" +
				"SPDX-License-Identifier: EPL-2.0";
		assertTrim(expected, original);
	}

	private void assertTrim(String expected, String original) {
		Assert.assertEquals(Strings.toPlatformLineSeparator(expected), emfGeneratorFragment2.trimMultiLineComment(Strings.toPlatformLineSeparator(original)));
	}
}
