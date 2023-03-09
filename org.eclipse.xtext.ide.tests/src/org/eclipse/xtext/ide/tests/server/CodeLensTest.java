/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import java.util.List;

import org.eclipse.lsp4j.CodeLens;
import org.eclipse.lsp4j.Position;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Iterables;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class CodeLensTest extends AbstractTestLangLanguageServerTest {
	@Test
	public void testCodeLens() {
		testCodeLens((TestCodeLensConfiguration cfg) -> {
			String model = 
					"type Foo {}\n" +
					"type Bar {\n" +
					"	Foo foo\n" +
					"}";
			cfg.setModel(model);
			cfg.setAssertCodeLenses((List<? extends CodeLens> result) -> {
				CodeLens first = Iterables.getFirst(result, null);
				assertEquals("Do Awesome Stuff(RESOLVED)", first.getCommand().getTitle());
				Assert.assertEquals(1, ((Position) first.getData()).getLine());
			});
		});
	}
}
