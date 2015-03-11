/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.model.edit;

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.xtext.junit4.ui.AbstractEditorTest;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.eclipse.xtext.ui.editor.reconciler.XtextReconciler;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.junit.Test;

/**
 * @author koehnlein - Initial contribution and API
 */
public class RealXtextDocumentModifyTest extends AbstractEditorTest {
	
	@Override
	protected String getEditorId() {
		return "org.eclipse.xtext.Xtext";
	}
	
	// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=406811
	@Test public void testModelListenerNotNotified() throws Exception {
		final String grammar = "grammar foo.Foo\n" 
				+ "generate foo \"http://foo.net/foo\"\n"
				+ "Foo: 'foo';"; 
		final IXtextDocument document = createDocument(grammar);
		// wait for the forced reconcile operation to finish
		Job.getJobManager().join(XtextReconciler.class.getName(), null);
		
		final int[] changeCounter = new int[] { 0 };
		document.addModelListener(new IXtextModelListener() {
			@Override
			public void modelChanged(XtextResource resource) {
				++changeCounter[0]; 
			}
		});
		document.modify(new IUnitOfWork.Void<XtextResource>() {
			@Override
			public void process(XtextResource state) throws Exception {
				document.replace(grammar.indexOf("Foo"), 3, "Bar");
			}
		});
		assertEquals("IXtextModelListener should not have been directly notified", 0, changeCounter[0]);
		document.readOnly(new IUnitOfWork.Void<XtextResource>() {
			@Override
			public void process(XtextResource state) throws Exception {
			}
		});
		assertEquals("Reconciler should have notified IXtextModelListener", 1, changeCounter[0]);
	}

	private IXtextDocument createDocument(String grammar) throws Exception {
		IProject project = createProject("foo");
		addNature(project, XtextProjectHelper.NATURE_ID);
		IFile file = createFile("foo/Foo.xtext", grammar);
		XtextEditor editor = openEditor(file);
		return editor.getDocument();
	}
}
