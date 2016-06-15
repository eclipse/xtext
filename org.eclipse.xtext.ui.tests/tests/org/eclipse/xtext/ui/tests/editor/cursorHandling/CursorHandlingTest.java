/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.cursorHandling;

import org.eclipse.xtext.junit4.ui.AbstractCursorHandlingTest;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CursorHandlingTest extends AbstractCursorHandlingTest {

	@Override
	protected String getEditorId() {
		return "org.eclipse.xtext.ui.tests.editor.bracketmatching.BmTestLanguage";
	}

	@Override
	protected String getFileExtension() {
		return "bmtestlanguage";
	}
	
	@Test public void testToLineStart_01() throws Exception {
		XtextEditor editor = openEditor("  begin en|d");
		toLineStart(editor);
		assertState("  |begin end", editor);
	}
	
	@Test public void testToLineStartInSlComment_01() throws Exception {
		XtextEditor editor = openEditor("  // begin en|d");
		toLineStart(editor);
		assertState("  // |begin end", editor);
		toLineStart(editor);
		assertState("|  // begin end", editor);
		toLineStart(editor);
		assertState("  // |begin end", editor);
	}
	
	@Test public void testToLineStartInSlComment_02() throws Exception {
		XtextEditor editor = openEditor("// begin en|d");
		toLineStart(editor);
		assertState("// |begin end", editor);
		toLineStart(editor);
		assertState("|// begin end", editor);
		toLineStart(editor);
		assertState("// |begin end", editor);
	}
	
	@Test public void testToLineStartInMlComment_01() throws Exception {
		XtextEditor editor = openEditor("  /* begin en|d */");
		toLineStart(editor);
		assertState("  /* |begin end */", editor);
		toLineStart(editor);
		assertState("|  /* begin end */", editor);
		toLineStart(editor);
		assertState("  /* |begin end */", editor);
	}
	
	@Test public void testToLineStartInMlComment_02() throws Exception {
		XtextEditor editor = openEditor("/* begin en|d */");
		toLineStart(editor);
		assertState("/* |begin end */", editor);
		toLineStart(editor);
		assertState("|/* begin end */", editor);
		toLineStart(editor);
		assertState("/* |begin end */", editor);
	}
	
	@Test public void testToLineStartInMlComment_03() throws Exception {
		XtextEditor editor = openEditor(
				"  /* \n" +
				"   * begin en|d\n" +
				"   */");
		toLineStart(editor);
		assertState(
				"  /* \n" +
				"   * |begin end\n" +
				"   */", editor);
		toLineStart(editor);
		assertState(
				"  /* \n" +
				"|   * begin end\n" +
				"   */", editor);
		toLineStart(editor);
		assertState(
				"  /* \n" +
				"   * |begin end\n" +
				"   */", editor);
	}
	
	@Test public void testToLineStartInMlComment_04() throws Exception { 
		XtextEditor editor = openEditor("  /** beg|in\n" + 
				"*/");
		toLineStart(editor);
		assertState("  /** |begin\n" +
				"*/", editor);
		toLineStart(editor);
		assertState("  |/** begin\n" +
				"*/", editor);
		toLineStart(editor);
		assertState("|  /** begin\n" +
				"*/", editor);
		toLineStart(editor);
		assertState("  |/** begin\n" +
				"*/", editor);
	}
	
	@Test public void testToLineStartInMlComment_05() throws Exception { 
		XtextEditor editor = openEditor("\n\n  /** beg|in\n" + 
				"*/");
		toLineStart(editor);
		assertState("\n\n  /** |begin\n" +
				"*/", editor);
		toLineStart(editor);
		assertState("\n\n  |/** begin\n" +
				"*/", editor);
		toLineStart(editor);
		assertState("\n\n|  /** begin\n" +
				"*/", editor);
		toLineStart(editor);
		assertState("\n\n  |/** begin\n" +
				"*/", editor);
	}
	
	@Test public void testNavigateLeft_01() throws Exception {
		XtextEditor editor = openEditor(" CamelCaseWo|rd ");
		navigateLeft(editor);
		assertState(" CamelCase|Word ", editor);
		navigateLeft(editor);
		assertState(" Camel|CaseWord ", editor);
		navigateLeft(editor);
		assertState(" |CamelCaseWord ", editor);
		navigateLeft(editor);
		assertState("| CamelCaseWord ", editor);
	}
	
	@Test public void testNavigateLeft_02() throws Exception {
		XtextEditor editor = openEditor("  \n two |words ");
		navigateLeft(editor);
		assertState("  \n |two words ", editor);
		navigateLeft(editor);
		assertState("  \n| two words ", editor);
		navigateLeft(editor);
		assertState("  |\n two words ", editor);
		navigateLeft(editor);
		assertState("|  \n two words ", editor);
	}
	
	@Test public void testNavigateRight_01() throws Exception {
		XtextEditor editor = openEditor(" Ca|melCaseWord ");
		navigateRight(editor);
		assertState(" Camel|CaseWord ", editor);
		navigateRight(editor);
		assertState(" CamelCase|Word ", editor);
		navigateRight(editor);
		assertState(" CamelCaseWord |", editor);
		navigateRight(editor);
		assertState(" CamelCaseWord |", editor);
	}
	
	@Test public void testNavigateRight_02() throws Exception {
		XtextEditor editor = openEditor("|  \n two words ");
		navigateRight(editor);
		assertState("  |\n two words ", editor);
		navigateRight(editor);
		assertState("  \n| two words ", editor);
		navigateRight(editor);
		assertState("  \n |two words ", editor);
		navigateRight(editor);
		assertState("  \n two |words ", editor);
		navigateRight(editor);
		assertState("  \n two words |", editor);
	}
	
}
