/*******************************************************************************
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.findrefs;


import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.findrefs.OpenDocumentTracker;
import org.eclipse.xtext.ui.testing.AbstractEditorTest;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.tests.internal.TestsActivator;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class OpenDocumentTrackerTests extends AbstractEditorTest {

	private OpenDocumentTracker tracker;
	private IFile file;
	private URI uri;

	@Override
	protected String getEditorId() {
		return "org.eclipse.xtext.ui.tests.TestLanguage";
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		tracker = TestsActivator.getInstance().getInjector(getEditorId()).getInstance(OpenDocumentTracker.class);
		IProject project = IResourcesSetupUtil.createProject("test");
		file = project.getFile("test.testlanguage");
		file.create(new StringInputStream("dummdidumm"), true, null);
		uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
	}
	
	@Test public void testTracker() throws Exception {
		assertNull(tracker.getOpenDocument(uri));
		XtextEditor editor = openEditor(file);
		runAsyncJobs();
		assertNotNull(tracker.getOpenDocument(uri));
		editor.close(false);
		runAsyncJobs();
		assertNull(tracker.getOpenDocument(uri));
		editor = openEditor(file);
		runAsyncJobs();
		assertNotNull(tracker.getOpenDocument(uri));
	}

	protected void runAsyncJobs() {
		while(Display.getCurrent().readAndDispatch()) {}
	}
	
}
