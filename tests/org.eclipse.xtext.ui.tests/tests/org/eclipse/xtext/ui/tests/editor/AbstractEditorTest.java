/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.tests.workbench.AbstractWorkbenchTest;

/**
 * @author Peter Friese - Initial contribution and API
 */
public abstract class AbstractEditorTest extends AbstractWorkbenchTest {

	static final long STEP_DELAY = 0;
	
	protected abstract String getEditorId();

	public AbstractEditorTest() {
		super();
	}

	public AbstractEditorTest(String name) {
		super(name);
	}

	@SuppressWarnings("restriction")
	protected XtextEditor openEditor(IFile file) throws Exception {
		IEditorPart openEditor = openEditor(file, getEditorId());
		if (openEditor instanceof XtextEditor) {
			waitForJobCompletion();
			sleep(STEP_DELAY);
			return (XtextEditor) openEditor;
		}
		else if (openEditor instanceof org.eclipse.ui.internal.ErrorEditorPart) {
			fail("Could not open XtextEditor. Editor produced errors during initialization.");
		}
		else {
			fail("Opened Editor with id:" + getEditorId() + ", is not a BaseXtextEditor");
		}
		return null;
	}

	private IEditorPart openEditor(IFile file, String editorId) throws PartInitException {
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(
				new FileEditorInput(file), editorId);
	}

	private void waitForJobCompletion() throws InterruptedException {
		while (Job.getJobManager().currentJob() != null) {
			sleep(500);
		}
	}

}