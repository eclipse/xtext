/*******************************************************************************
 * Copyright (c) 2021 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server;

import org.junit.Test;

/**
 * @author Mark Sujew - Initial contribution and API
 */
public class FoldingTest extends AbstractTestLangLanguageServerTest {

	@Test
	public void testFoldingService() {
		testFolding(it -> {
			it.setModel("/*\nMultiline Comment\n*/\ntype Foo {\nint bar\n}");
			String expectedText = "[comment 0..2]\n[null 3..5]\n";
			it.setExpectedFoldings(expectedText);
		});
	}
	
	@Test
	public void testFoldingService2() {
		testFolding(it -> {
			it.setModel("package a\n.b {\n\n}\n");// significate region with size > 1 line
			String expectedText = "[null 0..3]\n";
			it.setExpectedFoldings(expectedText);
		});
	}
	
}
