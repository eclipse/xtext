/**
 * Copyright (c) 2016, 2022 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import org.eclipse.xtext.testing.DefinitionTestConfiguration;
import org.junit.Test;

/**
 * @author kosyakov - Initial contribution and API
 * 
 * Contributors: 
 *   Rubén Porras Campo (Avaloq Evolution AG) - Add test for definitions on elements without identifiers.
 */
public class DefinitionTest extends AbstractTestLangLanguageServerTest {
	@Test
	public void testDefinition_01() {
		testDefinition((DefinitionTestConfiguration cfg) -> {
			String model = 
					"type Foo {}\n" +
					"type Bar {\n" +
					"	Foo foo\n" +
					"}";
			cfg.setModel(model);
			cfg.setLine(2);
			cfg.setColumn(3);
			cfg.setExpectedDefinitions("MyModel.testlang [[0, 5] .. [0, 8]]\n");
		});
	}

	@Test
	public void testDefinition_02() {
		testDefinition((DefinitionTestConfiguration cfg) -> {
			String model = 
					"type Foo {}\n" +
					"type Bar {\n" +
					"	Foo foo\n" +
					"}";
			cfg.setModel(model);
			cfg.setLine(0);
			cfg.setColumn(5);
			cfg.setExpectedDefinitions("MyModel.testlang [[0, 5] .. [0, 8]]\n");
		});
	}

	@Test
	public void testDefinition_03() {
		testDefinition((DefinitionTestConfiguration cfg) -> {
			String model = 
					"type Foo {} // One comment\n" +
					"type Bar {\n" +
					"	Foo foo\n" +
					"}";
			cfg.setModel(model);
			cfg.setLine(0);
			cfg.setColumn(15);
			cfg.setExpectedDefinitions("");
		});
	}

	@Test
	public void testDefinition_04() {
		testDefinition((DefinitionTestConfiguration cfg) -> {
			String model = 
					"type Foo {} // One comment\n" +
					"type Bar {\n" +
					"	Foo foo\n" +
					"}";
			cfg.setModel(model);
			cfg.setLine(0);
			cfg.setColumn(0);
			cfg.setExpectedDefinitions("");
		});
	}
}
