/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.integration.editor;

import static org.eclipse.xtext.ui.integration.util.ResourceUtil.*;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.ILogListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.concurrent.IUnitOfWork;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.editor.XtextEditor;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.core.editor.model.XtextDocument;
import org.eclipse.xtext.ui.integration.TestLanguage;
import org.eclipse.xtext.ui.integration.XtextUIIntegrationTestsPlugin;

/**
 * A test for the Xtext editor.
 * 
 * @author Dennis Hübner - Initial contribution and API
 * @author Peter Friese
 */
public class NotReallyAbstractEditorTest extends AbstractEditorTest {

	private static final Logger logger = Logger.getLogger(NotReallyAbstractEditorTest.class);
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		// listen to CoreLog use RuntimeLog to hear more
		XtextUIIntegrationTestsPlugin.getDefault().getLog().addLogListener(new ILogListener() {
			public void logging(IStatus status, String plugin) {
				if (IStatus.ERROR == status.getSeverity()) {
					fail(status.getMessage());
				}
			}
		});
		
	}
	
	public void testOpenBlankFile() throws Exception {
		IProject p = createProject("foo");
		IFile file = createFile(p, "x." + TestLanguage.fileExtension, "");
		XtextEditor openedEditor = openEditor(file);
		assertNotNull(openedEditor);
		IXtextDocument document = openedEditor.getDocument();
		document.readOnly(new IUnitOfWork.Void<XtextResource>() {

			@Override
			public void process(XtextResource resource) throws Exception {
				assertNotNull(resource);
				assertTrue(resource.getContents().isEmpty());
			}
		});
		openedEditor.close(false);
	}

	public void testOpenFileReadModifyRead() throws Exception {
		IProject p = createProject("foo");
		IFile file = createFile(p, "y." + TestLanguage.fileExtension, "/* multi line */\n" +
				"stuff foo\n" +
				"stuff bar\n" +
				"// end");
		XtextEditor openEditor = openEditor(file);
		assertNotNull(openEditor);
		XtextDocument document = (XtextDocument) openEditor.getDocument();
		
		Display.getDefault().readAndDispatch();
		document.readOnly(new IUnitOfWork.Void<XtextResource>() {

			@Override
			public void process(XtextResource resource) throws Exception {
				assertNotNull(resource);
				EList<EObject> contents = resource.getContents();
				EObject object = contents.get(0);
				assertEquals(2, object.eContents().size());
			}
		});
		document.replace(23, 3, "honolulu");
		logger.debug("Waiting for reconciler...");
		sleep(3000);
		document.readOnly(new IUnitOfWork.Void<XtextResource>() {

			@Override
			public void process(XtextResource resource) throws Exception {
				assertNotNull(resource);
				EList<EObject> contents = resource.getContents();
				EObject object = contents.get(0);
				assertEquals(2, object.eContents().size());
				EObject object2 = object.eContents().get(0);
				assertEquals("honolulu",object2.eGet(object2.eClass().getEStructuralFeature("name")));
			}
		});
		openEditor.doSave(null);
		openEditor.close(true);
	}

	public void testOpenFileReadModifyReadSecond() throws Exception {
		IProject p = createProject("foo");
		IFile file = createFile(p, "z." + TestLanguage.fileExtension, "/* multi line */\n" +
				"stuff foo\n" +
				"stuff bar\n" +
				"// end");
		XtextEditor openEditor = openEditor(file);
		assertNotNull(openEditor);
		XtextDocument document = (XtextDocument) openEditor.getDocument();
		
		Display.getDefault().readAndDispatch();
		document.readOnly(new IUnitOfWork.Void<XtextResource>() {

			@Override
			public void process(XtextResource resource) throws Exception {
				assertNotNull(resource);
				EList<EObject> contents = resource.getContents();
				EObject object = contents.get(0);
				assertEquals(2, object.eContents().size());
			}
		});
		document.replace(36, 0, "a");
		logger.debug("Waiting for reconciler...");
		sleep(3000);
		document.readOnly(new IUnitOfWork.Void<XtextResource>() {

			@Override
			public void process(XtextResource resource) throws Exception {
				assertNotNull(resource);
				EList<EObject> contents = resource.getContents();
				
				EObject object = contents.get(0);
				assertEquals(2, object.eContents().size());
				
				EObject object2 = object.eContents().get(0);
				assertEquals("foo",object2.eGet(object2.eClass().getEStructuralFeature("name")));
				
				EObject object3 = object.eContents().get(1);
				Object name = object3.eGet(object3.eClass().getEStructuralFeature("name"));
				assertEquals("bara", name);
				
			}
		});
		openEditor.doSave(null);
		openEditor.close(true);
	}

	@Override
	protected String getEditorId() {
		return "org.eclipse.xtext.ui.integration.TestLanguage";
	}

}
