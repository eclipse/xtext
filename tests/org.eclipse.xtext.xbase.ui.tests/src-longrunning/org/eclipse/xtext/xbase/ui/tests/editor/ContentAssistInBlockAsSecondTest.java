/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.tests.editor;

import static org.eclipse.xtext.ui.junit.util.JavaProjectSetupUtil.*;
import junit.extensions.TestSetup;
import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.core.resources.IProject;
import org.eclipse.xtext.ui.junit.editor.contentassist.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.xbase.ui.tests.AbstractXbaseUITestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ContentAssistInBlockAsSecondTest extends ContentAssistInBlockTest {

	@Override
	protected ContentAssistProcessorTestBuilder newBuilder() throws Exception {
		ContentAssistProcessorTestBuilder builder = new ContentAssistProcessorTestBuilder(getInjector(), this) {
			@Override
			public ContentAssistProcessorTestBuilder assertTextAtCursorPosition(int cursorPosition,
					String... expectedText) throws Exception {
				append("\n}");
				return super.assertTextAtCursorPosition(cursorPosition, expectedText);
			}
			
			@Override
			public ContentAssistProcessorTestBuilder assertTextAtCursorPosition(
					String cursorPosition, String... expectedText) throws Exception {
				return assertTextAtCursorPosition(getModel().indexOf(cursorPosition, "{ doesNotExist()".length()), expectedText);
			}
			
			@Override
			public ContentAssistProcessorTestBuilder assertTextAtCursorPosition(
					String cursorPosition, int offset, String... expectedText) throws Exception {
				return assertTextAtCursorPosition(getModel().indexOf(cursorPosition, "{ doesNotExist()".length()) + offset, expectedText);
			}
		};
		return builder.appendNl("{ doesNotExist()");
	}
	
	@Override
	public void testEmptyInput() throws Exception {
		newBuilder().assertText(expect(getKeywordsAndStatics(), VARIABLE_DECL, CAST_INSTANCEOF));
	}
	
	public static Test suite() {
		return new TestSetup(new TestSuite(ContentAssistInBlockAsSecondTest.class)) {
			private IProject project;

			@Override
			protected void setUp() throws Exception {
				super.setUp();
				project = AbstractXbaseUITestCase.createPluginProject(PROJECT_NAME);
				
			}
			
			@Override
			protected void tearDown() throws Exception {
				deleteProject(project);
				super.tearDown();
			}
		};
	}
}
