/*******************************************************************************
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractContentAssistTest;
import org.eclipse.xtext.ui.testing.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.tests.Bug360834TestLanguageUiInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@InjectWith(Bug360834TestLanguageUiInjectorProvider.class)
@RunWith(XtextRunner.class)
public class Bug360834Test extends AbstractContentAssistTest {
	
	@Test public void testEmptyDocument() throws Exception {
		newBuilder().assertText(
				"alternative", "unordered");
	}
	
	@Test public void testAlternative_package() throws Exception {
		newBuilder("alternative").assertText(
				"package");
	}
	
	@Test public void testAlternative_ClassModifiers() throws Exception {
		newBuilder("alternative package zonk;").assertText(
				"abstract", "final",
				"extern",
				"public", "protected", "private",
				"class");
	}
	
	@Test public void testAlternative_Class() throws Exception {
		newBuilder("alternative package zonk; class ").assertText(
				"Name");
	}
	
	@Test public void testAlternative_Visibility() throws Exception {
		newBuilder("alternative package zonk; protected ").assertText(
				"class");
	}
	
	@Test public void testUnordered_package() throws Exception {
		newBuilder("unordered").assertText(
				"package");
	}
	
	@Test public void testUnordered_ClassModifiers() throws Exception {
		newBuilder("unordered package zonk;").assertText(
				"abstract", "final",
				"extern",
				"public", "protected", "private",
				"class");
	}
	
	@Test public void testUnordered_Class() throws Exception {
		newBuilder("unordered package zonk; class ").assertText(
				"Name");
	}
	
	@Test public void testUnordered_Visibility_01() throws Exception {
		newBuilder("unordered package zonk; protected ").assertText(
				"class",
				"abstract", "final", "extern");
	}
	
	@Test public void testUnordered_Visibility_02() throws Exception {
		newBuilder("unordered package zonk; protected abstract ").assertText(
				"class",
				"final", "extern");
	}
	
	@Test public void testUnordered_Visibility_03() throws Exception {
		newBuilder("unordered package zonk; protected abstract final ").assertText(
				"class",
				"extern");
	}
	
	public ContentAssistProcessorTestBuilder newBuilder(String initial) throws Exception {
		return newBuilder().appendNl(initial);
	}

}
