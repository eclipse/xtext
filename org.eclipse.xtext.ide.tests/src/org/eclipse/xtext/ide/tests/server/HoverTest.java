/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import org.eclipse.xtext.testing.HoverTestConfiguration;
import org.junit.Test;

import com.google.common.collect.ImmutableMap;

/**
 * @author kosyakov - Initial contribution and API
 */
public class HoverTest extends AbstractTestLangLanguageServerTest {
	@Test
	public void testHover_01() {
		testHover((HoverTestConfiguration it) -> {
			String model =
					"/**\n" +
					" * Some documentation.\n" +
					" */\n" +
					"type Foo {\n" +
					"}\n";
			it.setModel(model);
			it.setLine(3);
			it.setColumn("type F".length());
			String expectedHover =
					"[[3, 5] .. [3, 8]]\n" +
					"kind: markdown\n" +
					"value: Some documentation.\n";
			it.setExpectedHover(expectedHover);
		});
	}

	@Test
	public void testHover_02() {
		testHover((HoverTestConfiguration it) -> {
			String model =
					"/**\n" +
					" * Some documentation.\n" +
					" */\n" +
					"type Foo {}\n";
			it.setModel(model);
			it.setLine(3);
			it.setColumn("{".length());
			String expectedHover =
					"kind: markdown\n" +
					"value: \n";
			it.setExpectedHover(expectedHover);
		});
	}

	@Test
	public void testHover_03() {
		testHover((HoverTestConfiguration it) -> {
			String model =
					"/**\n" +
					" * Some documentation.\n" +
					" */\n" +
					"type Foo {\n" +
					"	Foo foo\n" +
					"}\n";
			it.setModel(model);
			it.setLine(4);
			it.setColumn("	F".length());
			String expectedHover =
					"[[4, 1] .. [4, 4]]\n" +
					"kind: markdown\n" +
					"value: Some documentation.\n";
			it.setExpectedHover(expectedHover);
		});
	}

	@Test
	public void testHover_04() {
		testHover((HoverTestConfiguration it) -> {
			String model =
					"/**\n" +
					" * Some documentation.\n" +
					" */\n" +
					"type Foo {\n" +
					"}\n" +
					"type Bar extends Foo {\n" +
					"}\n";
			it.setModel(model);
			it.setLine(5);
			it.setColumn("type Bar extends F".length());
			String expectedHover =
					"[[5, 17] .. [5, 20]]\n" +
					"kind: markdown\n" +
					"value: Some documentation.\n";
			it.setExpectedHover(expectedHover);
		});
	}

	@Test
	public void testHover_05() {
		testHover((HoverTestConfiguration it) -> {
			String otherModel =
					"/**\n" +
					" * Some documentation.\n" +
					" */\n" +
					"type Foo {\n" +
					"}\n";
			it.setFilesInScope(
					ImmutableMap.<String, CharSequence>builder().put("MyModel2." + fileExtension, otherModel).build());
			String model =
					"type Bar extends Foo {\n" +
					"}\n";
			it.setModel(model);
			it.setColumn("type Bar extends F".length());
			String expectedHover =
					"[[0, 17] .. [0, 20]]\n" +
					"kind: markdown\n" +
					"value: Some documentation.\n";
			it.setExpectedHover(expectedHover);
		});
	}
}
