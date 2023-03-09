/*******************************************************************************
 * Copyright (c) 2021 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ide.IDE;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.testing.AbstractEditorTest;
import org.eclipse.xtext.ui.tests.ui.tests.TestLanguageUiInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(TestLanguageUiInjectorProvider.class)
@RunWith(XtextRunner.class)
public class EditorForAbsentFileTest extends AbstractEditorTest {

	@Test
	public void testOpenEditorViaIFile() throws Exception {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IEditorPart openEditor = IDE.openEditor(getActivePage(), root.getFile(root.getFullPath().append("someProject").append("absent.testlanguage")));
		assertNotNull(openEditor);
		Display display = Display.getCurrent();
		while(display.readAndDispatch()) {}
		assertTrue(openEditor instanceof XtextEditor);
		
		XtextEditor xtextEditor = (XtextEditor) openEditor;
		ISourceViewer sourceViewer = xtextEditor.getInternalSourceViewer();
		IDocument document = sourceViewer.getDocument();
		assertTrue(document instanceof XtextDocument);
		StyledText textWidget = sourceViewer.getTextWidget();
		Composite parent = textWidget.getParent();
		while(parent != null && !(parent.getLayout() instanceof StackLayout)) {
			parent = parent.getParent();
		}
		assertNotNull(parent);
		Control[] children = parent.getChildren();
		Composite errorPageControl = (Composite) children[1];
		while(errorPageControl.getChildren().length == 1) {
			errorPageControl = (Composite) errorPageControl.getChildren()[0];
		}
		Control[] errorPageChildren = errorPageControl.getChildren();
		for(Control c: errorPageChildren) {
			if (c instanceof StyledText) {
				String errorText = ((StyledText) c).getText();
				assertEquals("Resource '/someProject/absent.testlanguage' does not exist.", errorText);
				return;
			}
		}
		fail("Did not find StyledText with matching error text");
	}

}
