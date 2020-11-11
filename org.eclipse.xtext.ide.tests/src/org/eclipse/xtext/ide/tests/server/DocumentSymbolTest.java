/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import org.eclipse.xtext.testing.DocumentSymbolConfiguraiton;
import org.junit.Test;

/**
 * @author kosyakov - Initial contribution and API
 */
public class DocumentSymbolTest extends AbstractTestLangLanguageServerTest {
	@Test
	public void testDocumentSymbol_01() {
		testDocumentSymbol((DocumentSymbolConfiguraiton it) -> {
			String model =
					"type Foo {\n" +
					"	int bar\n" +
					"}\n" +
					"type Bar {\n" +
					"	Foo foo\n" +
					"}\n";
			it.setModel(model);
			String expectedSymbols =
					"symbol \"Foo\" {\n" +
					"	kind: 7\n" +
					"	location: MyModel.testlang [[0, 5] .. [0, 8]]\n" +
					"}\n" +
					"symbol \"Foo.bar\" {\n" +
					"	kind: 7\n" +
					"	location: MyModel.testlang [[1, 5] .. [1, 8]]\n" +
					"	container: \"Foo\"\n" +
					"}\n" +
					"symbol \"Foo.bar.int\" {\n" +
					"	kind: 7\n" +
					"	location: MyModel.testlang [[1, 1] .. [1, 4]]\n" +
					"	container: \"Foo.bar\"\n" +
					"}\n" +
					"symbol \"Bar\" {\n" +
					"	kind: 7\n" +
					"	location: MyModel.testlang [[3, 5] .. [3, 8]]\n" +
					"}\n" +
					"symbol \"Bar.foo\" {\n" +
					"	kind: 7\n" +
					"	location: MyModel.testlang [[4, 5] .. [4, 8]]\n" +
					"	container: \"Bar\"\n" +
					"}\n";
			it.setExpectedSymbols(
					expectedSymbols);
		});
	}
}
