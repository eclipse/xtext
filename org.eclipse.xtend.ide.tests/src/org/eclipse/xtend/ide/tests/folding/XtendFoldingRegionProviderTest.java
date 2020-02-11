/*******************************************************************************
 * Copyright (c) 2011, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.folding;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.folding.DefaultFoldedPosition;
import org.eclipse.xtext.ui.editor.folding.FoldedPosition;
import org.eclipse.xtext.ui.editor.folding.IFoldingRegionProvider;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 * @author Christian Dietrich
 */
public class XtendFoldingRegionProviderTest extends AbstractXtendUITestCase {

	@Inject
	private WorkbenchTestHelper testHelper;

	@Inject
	private IFoldingRegionProvider foldingRegionProvider;

	@Test public void testNoFoldingIfOnlyOneImport() throws Exception {
		String content = "package test\nimport java.util.List\nclass Bar{}";

		Collection<FoldedPosition> foldingRegions = calculateFoldingRegions("test/Bar", content);
		
		assertTrue(foldingRegions.isEmpty());
	}

	@Test public void testFoldingOfMoreThanOneImports() throws Exception {
		String content = "package test\nimport java.util.List\nimport java.util.Set\nclass Bar{}";

		Collection<FoldedPosition> foldingRegions = calculateFoldingRegions("test/Bar", content);

		assertEquals(1, foldingRegions.size());
		FoldedPosition first = foldingRegions.iterator().next();
		assertEquals(13, first.getOffset());
		assertEquals(43, first.length);
	}

	@Test public void testFoldCopyrightHeader() throws Exception {
		String content = "/**\n * \n * Hello Copyright\n * \n */\npackage test\nimport java.util.List\nimport java.util.Set\nclass Bar{}";

		Collection<FoldedPosition> foldingRegions = calculateFoldingRegions("test/Bar", content);

		assertEquals(2, foldingRegions.size());
		Iterator<FoldedPosition> iterator = foldingRegions.iterator();
		FoldedPosition first = iterator.next();
		assertEquals(48, first.getOffset());
		assertEquals(43, first.length);
		assertTrue(((DefaultFoldedPosition)first).isInitiallyFolded());
		FoldedPosition second = iterator.next();
		assertEquals(0, second.getOffset());
		assertEquals(35, second.length);
		assertTrue(((DefaultFoldedPosition)second).isInitiallyFolded());
	}

	@Test public void testFoldCopyrightHeader2() throws Exception {
		String content = "package test\n/**\n * \n * Hello Copyright\n * \n */\nimport java.util.List\nimport java.util.Set\nclass Bar{}";

		Collection<FoldedPosition> foldingRegions = calculateFoldingRegions("test/Bar", content);

		assertEquals(2, foldingRegions.size());
		Iterator<FoldedPosition> iterator = foldingRegions.iterator();
		FoldedPosition first = iterator.next();
		assertEquals(48, first.getOffset());
		assertEquals(43, first.length);
		assertTrue(((DefaultFoldedPosition)first).isInitiallyFolded());
		FoldedPosition second = iterator.next();
		assertEquals(13, second.getOffset());
		assertEquals(35, second.length);
		assertFalse(((DefaultFoldedPosition)second).isInitiallyFolded());
	}

	@Test public void testFoldAnonymousClass() throws Exception {
		String content = "class Foo {\n"
				+ " val foo = new Runnable() {\n"
				+ "   override run() {\n"
				+ "   }\n"
				+ " }\n"
				+ "}";

		Collection<FoldedPosition> foldingRegions = calculateFoldingRegions("test/Bar", content);

		assertEquals(3, foldingRegions.size());
		Iterator<FoldedPosition> iterator = foldingRegions.iterator();
		FoldedPosition next = iterator.next();
		assertEquals(0, next.offset);
		assertEquals(69, next.length);
		next = iterator.next();
		assertEquals(12, next.offset);
		assertEquals(56, next.length);
		next = iterator.next();
		assertEquals(40, next.offset);
		assertEquals(25, next.length);
	}

	@Test public void testFoldClosure_01() throws Exception {
		String content = "class Foo {\n"
				+ "  def void xxx() {\n"
				+ "    #[1,2,3].filter [\n"
				+ "      println(it)\n"
				+ "      it%2==0\n"
				+ "    ]\n"
				+ "  }\n"
				+ "}";

		Collection<FoldedPosition> foldingRegions = calculateFoldingRegions("test/Foo",content);

		assertEquals(3, foldingRegions.size());
		Iterator<FoldedPosition> iterator = foldingRegions.iterator();
		FoldedPosition next = iterator.next();
		assertEquals(0, next.offset);
		assertEquals(96, next.length);
		next = iterator.next();
		assertEquals(12, next.offset);
		assertEquals(83, next.length);
		next = iterator.next();
		assertEquals(31, next.offset);
		assertEquals(60, next.length);
	}

	@Test public void testFoldClosure_02() throws Exception {
		String content = "class Foo {\n"
				+ "  def void xxx() {\n"
				+ "    #[1,2,3].filter [ i % 2 == 0 ]\n"
				+ "  }\n"
				+ "}";

		Collection<FoldedPosition> foldingRegions = calculateFoldingRegions("test/Foo", content);

		assertEquals(2, foldingRegions.size());
		Iterator<FoldedPosition> iterator = foldingRegions.iterator();
		FoldedPosition next = iterator.next();
		assertEquals(0, next.offset);
		assertEquals(71, next.length);
		next = iterator.next();
		assertEquals(12, next.offset);
		assertEquals(58, next.length);
	}

	@Test public void testFoldRichString_01() throws Exception {
		String content = "class Foo {\n"
				+ "  def void xxx() {\n"
				+ "    println('''\n"
				+ "      x\n"
				+ "      y\n"
				+ "    ''')\n"
				+ "  }\n"
				+ "}";

		Collection<FoldedPosition> foldingRegions = calculateFoldingRegions("test/Foo", content);

		assertEquals(3, foldingRegions.size());
		Iterator<FoldedPosition> iterator = foldingRegions.iterator();
		FoldedPosition next = iterator.next();
		assertEquals(0, next.offset);
		assertEquals(77, next.length);
		next = iterator.next();
		assertEquals(12, next.offset);
		assertEquals(64, next.length);
		next = iterator.next();
		assertEquals(31, next.offset);
		assertEquals(41, next.length);
	}

	@Test public void testRichString_02() throws Exception {
		String content = "class Foo {\n"
				+ "  def void xxx() {\n"
				+ "    println('''x y''')\n"
				+ "  }\n"
				+ "}";

		Collection<FoldedPosition> foldingRegions = calculateFoldingRegions("test/Foo", content);

		assertEquals(2, foldingRegions.size());
		Iterator<FoldedPosition> iterator = foldingRegions.iterator();
		FoldedPosition next = iterator.next();
		assertEquals(0, next.offset);
		assertEquals(59, next.length);
		next = iterator.next();
		assertEquals(12, next.offset);
		assertEquals(46, next.length);
	}

	@Test public void testFoldListLiteral_01() throws Exception {
		String content = "class Foo {\n"
				+ "  def xxx() {\n"
				+ "    #[\n"
				+ "      1,\n"
				+ "      2\n"
				+ "    ]\n"
				+ "  }\n"
				+ "}";

		Collection<FoldedPosition> foldingRegions = calculateFoldingRegions("test/Foo", content);

		assertEquals(3, foldingRegions.size());
		Iterator<FoldedPosition> iterator = foldingRegions.iterator();
		FoldedPosition next = iterator.next();
		assertEquals(0, next.offset);
		assertEquals(61, next.length);
		next = iterator.next();
		assertEquals(12, next.offset);
		assertEquals(48, next.length);
		next = iterator.next();
		assertEquals(26, next.offset);
		assertEquals(30, next.length);
	}

	@Test public void testFoldListLiteral_02() throws Exception {
		String content = "class Foo {\n"
				+ "  def xxx() {\n"
				+ "    #[1,2]\n"
				+ "  }\n"
				+ "}";

		Collection<FoldedPosition> foldingRegions = calculateFoldingRegions("test/Foo", content);

		assertEquals(2, foldingRegions.size());
		Iterator<FoldedPosition> iterator = foldingRegions.iterator();
		FoldedPosition next = iterator.next();
		assertEquals(0, next.offset);
		assertEquals(42, next.length);
		next = iterator.next();
		assertEquals(12, next.offset);
		assertEquals(29, next.length);
	}

	@Test public void testFoldSetLiteral_01() throws Exception {
		String content = "class Foo {\n"
				+ "  def xxx() {\n"
				+ "    #{\n"
				+ "      1,\n"
				+ "      2\n"
				+ "    }\n"
				+ "  }\n"
				+ "}";

		Collection<FoldedPosition> foldingRegions = calculateFoldingRegions("test/Foo", content);

		assertEquals(3, foldingRegions.size());
		Iterator<FoldedPosition> iterator = foldingRegions.iterator();
		FoldedPosition next = iterator.next();
		assertEquals(0, next.offset);
		assertEquals(61, next.length);
		next = iterator.next();
		assertEquals(12, next.offset);
		assertEquals(48, next.length);
		next = iterator.next();
		assertEquals(26, next.offset);
		assertEquals(30, next.length);
	}

	@Test public void testFoldSetLiteral_02() throws Exception {
		String content = "class Foo {\n"
				+ "  def xxx() {\n"
				+ "    #{1,2}\n"
				+ "  }\n"
				+ "}";

		Collection<FoldedPosition> foldingRegions = calculateFoldingRegions("test/Foo", content);
		assertEquals(2, foldingRegions.size());
		Iterator<FoldedPosition> iterator = foldingRegions.iterator();
		FoldedPosition next = iterator.next();
		assertEquals(0, next.offset);
		assertEquals(42, next.length);
		next = iterator.next();
		assertEquals(12, next.offset);
		assertEquals(29, next.length);
	}

	private Collection<FoldedPosition> calculateFoldingRegions(String fileName, String content) throws Exception {
		IFile iFile = testHelper.createFile(fileName, content);
		XtextEditor editor = testHelper.openEditor(iFile);
		IXtextDocument document = editor.getDocument();
		return foldingRegionProvider.getFoldingRegions(document);
	}

	@Override
	public void tearDown() throws Exception {
		testHelper.tearDown();
		super.tearDown();
	}
}
