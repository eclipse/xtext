/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.mpe;

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*;

import org.eclipse.core.commands.Command;
import org.eclipse.core.resources.IFile;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.xtext.junit4.ui.AbstractEditorTest;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.junit.Test;

/**
 * @author Peter Friese
 */
public class MultipageEditorTest extends AbstractEditorTest {

	@Override
	public void tearDown() throws Exception {
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeAllEditors(false);
		super.tearDown();
	}

	@Test public void testOpenBlankFile() throws Exception {
		IFile file = createFile("foo/y.testlanguage", "/* multi line */\n" + "stuff foo\n" + "stuff bar\n" + "// end");
		XtextEditor openedEditor = openEditor(file);
		assertNotNull(openedEditor);
		
		ICommandService service = (ICommandService) PlatformUI.getWorkbench().getService(ICommandService.class);
		Command command = service.getCommand("org.eclipse.xtext.ui.editor.hyperlinking.OpenDeclaration");
		assertTrue(command.isEnabled());
		
		openedEditor.close(false);
	}
	@Override
	protected String getEditorId() {
		return "org.eclipse.xtext.ui.tests.mpe.MultiPageEditor";
	}

}
