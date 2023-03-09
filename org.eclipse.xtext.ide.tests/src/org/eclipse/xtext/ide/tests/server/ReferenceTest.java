/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import org.eclipse.xtext.testing.ReferenceTestConfiguration;
import org.junit.Test;

import com.google.common.collect.ImmutableMap;

/**
 * @author kosyakov - Initial contribution and API
 */
public class ReferenceTest extends AbstractTestLangLanguageServerTest {
	@Test
	public void testReferences_01() {
		testReferences((ReferenceTestConfiguration it) -> {
			String model = 
					"type Foo {}\n" +
					"type Bar {\n" +
					"	Foo foo\n" +
					"}";
			it.setModel(model);
			it.setColumn("type F".length());
			it.setExpectedReferences("MyModel.testlang [[2, 1] .. [2, 4]]\n");
		});
	}

	@Test
	public void testReferences_02() {
		testReferences((ReferenceTestConfiguration it) -> {
			String model = 
					"type Foo {}\n" +
					"type Bar {\n" +
					"	Foo foo\n" +
					"}";
			it.setModel(model);
			it.setColumn("type F".length());
			it.setIncludeDeclaration(true);
			it.setExpectedReferences(
					"MyModel.testlang [[0, 5] .. [0, 8]]\n" +
					"MyModel.testlang [[2, 1] .. [2, 4]]\n");
		});
	}

	@Test
	public void testReferences_03_acrossFiles() {
		testReferences((ReferenceTestConfiguration it) -> {
			it.setFilesInScope(ImmutableMap.<String, CharSequence>builder().put("foo.testlang", "type Foo {}").build());
			String model = 
					"type Bar {\n" +
					"    Foo foo" +
					"}\n";
			it.setModel(model);
			it.setLine(1);
			it.setColumn(6);
			it.setIncludeDeclaration(true);
			it.setExpectedReferences(
					"foo.testlang [[0, 5] .. [0, 8]]\n" +
					"MyModel.testlang [[1, 4] .. [1, 7]]\n");
		});
	}
}
