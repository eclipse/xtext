/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class CodeActionTest extends AbstractTestLangLanguageServerTest {
	@Test
	public void testCodeAction() {
		testCodeAction((TestCodeActionConfiguration it) -> {
			String model =
					"type foo {\n" +
					"	\n" +
					"}\n";
			it.setModel(model);
			// contains quickfix and edit command
			String expectedCodeActions =
					"title : Change element name to first upper using object modification\n" +
					"kind : quickfix\n" +
					"command : \n" +
					"codes : invalidName\n" +
					"edit : changes :\n" +
					"    MyModel.testlang : Foo [[0, 5] .. [0, 8]]\n" +
					"documentChanges : \n" +
					"title : Change element name to first upper using text replacement\n" +
					"kind : quickfix\n" +
					"command : \n" +
					"codes : invalidName\n" +
					"edit : changes :\n" +
					"    MyModel.testlang : type Foo {\n" +
					"    } [[0, 5] .. [0, 8]]\n" +
					"documentChanges : \n" +
					"command : my.textedit.command\n" +
					"title : Make \'foo\' upper case (Command)\n" +
					"args : \n" +
					"    changes :\n" +
					"        MyModel.testlang : Foo [[0, 5] .. [0, 8]]\n" +
					"    documentChanges : \n";
			it.setExpectedCodeActions(expectedCodeActions);
		});
	}

	@Test
	public void testSemanticCodeAction() {
		testCodeAction((TestCodeActionConfiguration it) -> {
			String model =
					"type Foo {\n" +
					"	String ccc\n" +
					"	String aaa\n" +
					"}\n" +
					"type String {}\n";
			it.setModel(model);
			String expectedCodeActions =
					"title : Sort Members\n" +
					"kind : \n" +
					"command : \n" +
					"codes : unsorted_members\n" +
					"edit : changes :\n" +
					"    MyModel.testlang : \n" +
					"        String aaa\n" +
					"     [[0, 10] .. [0, 10]]\n" +
					"    \n" +
					"     [[1, 11] .. [3, 0]]\n" +
					"documentChanges : \n";
			it.setExpectedCodeActions(expectedCodeActions);
		});
	}
}
