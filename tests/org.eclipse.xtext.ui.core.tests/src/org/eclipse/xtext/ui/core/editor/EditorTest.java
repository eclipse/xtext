/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;

import static org.eclipse.xtext.ui.core.util.ResourceUtil.*;
import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.ILogListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.ITestLanguage;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.core.editor.model.UnitOfWork;
import org.eclipse.xtext.ui.core.editor.model.XtextDocument;
import org.eclipse.xtext.ui.core.internal.XtextUITestsPlugin;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class EditorTest extends TestCase {

	private static final long STEP_DELAY = 0;
	private static final String EDITOR_ID = ITestLanguage.ID;

	protected void setUp() throws Exception {
		super.setUp();
		if (PlatformUI.getWorkbench().getIntroManager().getIntro() != null)
			PlatformUI.getWorkbench().getIntroManager().closeIntro(
					PlatformUI.getWorkbench().getIntroManager().getIntro());
		// listen to CoreLog use RuntimeLog to hear more
		XtextUITestsPlugin.getDefault().getLog().addLogListener(new ILogListener() {
			public void logging(IStatus status, String plugin) {
				if (IStatus.ERROR == status.getSeverity()) {
					fail(status.getMessage());
				}
			}
		});
	}
	
//	public void testXmlSample() throws Exception {
//		IProject p = createProject("foo");
//		IFile file = createFile(p, "x.xml", "");
//		XMLEditor openEditor = (XMLEditor) openEditor(file,"xml.editor.sample.editors.XMLEditor");
//		openEditor.close(false);
//		p = createProject("foo");
//		file = createFile(p, "x.xml", "<xml/>");
//		openEditor = (XMLEditor) openEditor(file,"xml.editor.sample.editors.XMLEditor");
//		assertEquals("<xml/>",openEditor.getContentDescription());
//	}

	public void testOpenBlankFile() throws Exception {
		IProject p = createProject("foo");
		IFile file = createFile(p, "x.testlanguage", "");
		XtextEditor openedEditor = openEditor(file);
		assertNotNull(openedEditor);
		IXtextDocument document = openedEditor.getDocument();
		document.readOnly(new UnitOfWork<Object>() {

			public Object exec(XtextResource resource) throws Exception {
				assertNotNull(resource);
				assertTrue(resource.getContents().isEmpty());
				return null;
			}
		});
		openedEditor.close(false);
	}

	public void testOpenFileReadModifyRead() throws Exception {
		IProject p = createProject("foo");
		IFile file = createFile(p, "y.testlanguage", "/* multi line */\n" +
				"stuff foo\n" +
				"stuff bar\n" +
				"// end");
		XtextEditor openEditor = openEditor(file);
		assertNotNull(openEditor);
		XtextDocument document = (XtextDocument) openEditor.getDocument();
		
		Display.getDefault().readAndDispatch();
		document.readOnly(new UnitOfWork<Object>() {

			public Object exec(XtextResource resource) throws Exception {
				assertNotNull(resource);
				EList<EObject> contents = resource.getContents();
				EObject object = contents.get(0);
				assertEquals(2, object.eContents().size());
				return null;
			}
		});
		document.replace(23, 3, "honolulu");
		System.out.println("Waiting for reconciler...");
		sleep(3000);
		document.readOnly(new UnitOfWork<Object>() {
			
			public Object exec(XtextResource resource) throws Exception {
				assertNotNull(resource);
				EList<EObject> contents = resource.getContents();
				EObject object = contents.get(0);
				assertEquals(2, object.eContents().size());
				EObject object2 = object.eContents().get(0);
				assertEquals("honolulu",object2.eGet(object2.eClass().getEStructuralFeature("name")));
				return null;
			}
		});
		openEditor.doSave(null);
		openEditor.close(true);
	}

	@SuppressWarnings("restriction")
	private XtextEditor openEditor(IFile file) throws Exception {
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

	private void sleep(long i) throws InterruptedException {
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
