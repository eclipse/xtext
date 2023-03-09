/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.RenameParams;
import org.eclipse.lsp4j.TextDocumentIdentifier;
import org.eclipse.lsp4j.WorkspaceEdit;
import org.junit.Before;
import org.junit.Test;

/**
 * @author koehnlein - Initial contribution and API
 */
public class RenameTest extends AbstractTestLangLanguageServerTest {
	private String firstFile;

	private String secondFile;

	@Before
	public void setUp() {
		String first =
				"type Test {\n" +
				"    Test foo\n" +
				"}\n";
		firstFile = writeFile("MyType1.testlang", first);
		String second =
				"type Test2 {\n" +
				"    Test foo\n" +
				"}\n";
		secondFile = writeFile("MyType2.testlang", second);
		initialize();
	}

	@Test
	public void testRenameBeforeDeclaration() throws Exception {
		doTest(firstFile, new Position(0, 5));
	}

	@Test
	public void testRenameOnDeclaration() throws Exception {
		doTest(firstFile, new Position(0, 6));
	}

	@Test
	public void testRenameAfterDeclaration() throws Exception {
		doTest(firstFile, new Position(0, 8));
	}

	@Test
	public void testRenameOnReference() throws Exception {
		doTest(firstFile, new Position(1, 5));
	}

	@Test
	public void testRenameAfterReference() throws Exception {
		doTest(firstFile, new Position(1, 8));
	}

	@Test
	public void testRenameOnReferenceInOtherFile() throws Exception {
		doTest(secondFile, new Position(1, 5));
	}

	@Test
	public void testRenameAfterReferenceInOtherFile() throws Exception {
		doTest(secondFile, new Position(1, 8));
	}

	protected void doTest(String fileName, Position position) throws Exception {
		RenameParams params = new RenameParams(new TextDocumentIdentifier(fileName), position, "Tescht");
		WorkspaceEdit workspaceEdit = languageServer.rename(params).get();
		String expected = 
				"changes :\n" +
				"	MyType1.testlang : Tescht [[0, 5] .. [0, 9]]\n" +
				"	Tescht [[1, 4] .. [1, 8]]\n" +
				"	MyType2.testlang : Tescht [[1, 4] .. [1, 8]]\n" +
				"documentChanges : \n";
		assertEquals(expected, toExpectation(workspaceEdit));
	}
}
