/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.ui.core.ITestLanguage;

import junit.framework.TestCase;

/**
 * @author Peter Friese - Initial contribution and API
 */
public abstract class AbstractEditorTest extends TestCase {
	
	static final long STEP_DELAY = 0;
	static final String EDITOR_ID = ITestLanguage.ID;	

	public AbstractEditorTest() {
		super();
	}

	public AbstractEditorTest(String name) {
		super(name);
	}

	@SuppressWarnings("restriction")
	protected XtextEditor openEditor(IFile file) throws Exception {
		IEditorPart openEditor = openEditor(file,EDITOR_ID);
		if (openEditor instanceof XtextEditor) {
			waitForJobCompletion();
			sleep(STEP_DELAY);
			return (XtextEditor) openEditor;
		} else if (openEditor instanceof org.eclipse.ui.internal.ErrorEditorPart) {
			fail("Could not open XtextEditor. Editor produced errors during initialization.");
		} else {
			fail("Opened Editor with id:" + EDITOR_ID + ", is not a BaseXtextEditor");
		}
		return null;
	}

	private IEditorPart openEditor(IFile file, String editorId) throws PartInitException {
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(
				new FileEditorInput(file),editorId);
	}

	private void waitForJobCompletion() throws InterruptedException {
		while (Job.getJobManager().currentJob() != null)
			sleep(500);
	}

	protected void sleep(long i) throws InterruptedException {
		Display displ = Display.getCurrent();
		if (displ != null) {
			long timeToGo = System.currentTimeMillis() + i;
			while (System.currentTimeMillis() < timeToGo) {
				if (!displ.readAndDispatch())
					displ.sleep();
			}
			displ.update();
		} else {
			Thread.sleep(i);
		}
	
	}

}