/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.findrefs;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.junit4.ui.AbstractEditorTest;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.findrefs.EditorResourceAccess;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class EditorResourceAccessTest extends AbstractEditorTest {

	private IFile file;
	private URI uri;

	@Override
	protected String getEditorId() {
		return "org.eclipse.xtext.ui.tests.refactoring.RefactoringTestLanguage";
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		IProject project = IResourcesSetupUtil.createProject("test");
		IResourcesSetupUtil.addNature(project, "org.eclipse.xtext.ui.shared.xtextNature");
		file = project.getFile("test.refactoringtestlanguage");
		file.create(new StringInputStream(""), true, null);
		uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
	}

	@Test public void testAccess() throws Exception {
		EditorResourceAccess access = Activator.getInstance().getInjector(getEditorId())
				.getInstance(EditorResourceAccess.class);
		IUnitOfWork<Boolean, ResourceSet> isEmpty = new IUnitOfWork<Boolean, ResourceSet>(){
			@Override
			public Boolean exec(ResourceSet state) throws Exception {
				return state.getResources().get(0).getContents().isEmpty();
			}
		};
		assertTrue(access.readOnly(uri, isEmpty));
		
		XtextEditor editor = openEditor(file);
		runAsyncJobs();
		assertTrue(access.readOnly(uri, isEmpty));

		editor.getDocument().set("A");
		runAsyncJobs();
		waitForReconciler(editor);
		runAsyncJobs();
		assertFalse(access.readOnly(uri, isEmpty));
		
		editor.close(false);
		runAsyncJobs();
		assertTrue(access.readOnly(uri, isEmpty));
	}

	
	protected void runAsyncJobs() {
		while (Display.getCurrent().readAndDispatch()) {
		}
	}
	
	protected void waitForReconciler(XtextEditor editor) {
		editor.getDocument().readOnly(new IUnitOfWork.Void<XtextResource>() {
			@Override
			public void process(XtextResource state) throws Exception {
			}
		});
	}

}
