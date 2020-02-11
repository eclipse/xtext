/*******************************************************************************
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.model.edit;

import static org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.widgets.Display;
import org.eclipse.text.undo.DocumentUndoManagerRegistry;
import org.eclipse.text.undo.IDocumentUndoManager;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.eclipse.xtext.ui.editor.reconciler.XtextReconciler;
import org.eclipse.xtext.ui.testing.AbstractEditorTest;
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
		
		CountDownLatch countDownLatch = new CountDownLatch(1);
		
		final CountDownLatch[] changeCounter = new CountDownLatch[] { countDownLatch };
		document.addModelListener(new IXtextModelListener() {
			@Override
			public void modelChanged(XtextResource resource) {
				changeCounter[0].countDown(); 
			}
		});
		document.modify(new IUnitOfWork.Void<XtextResource>() {
			@Override
			public void process(XtextResource state) throws Exception {
				document.replace(grammar.indexOf("Foo"), 3, "Bar");
			}
		});
		assertEquals("IXtextModelListener should not have been directly notified", 1, countDownLatch.getCount());
		document.readOnly(new IUnitOfWork.Void<XtextResource>() {
			@Override
			public void process(XtextResource state) throws Exception {
			}
		});
		
		/* Let the UI thread process any queued operation for a while so that the IXtextModelListener
		 * are called.  If processing fails too long, then give up.  */
		
		long start = System.currentTimeMillis();
		long timeout = TimeUnit.MILLISECONDS.convert(10, TimeUnit.SECONDS);
		long maxEndTime = start + timeout;
		
		boolean moreWorkForTheUiThread = true;
		boolean latchReachedZero = false;
		
		while (moreWorkForTheUiThread && !latchReachedZero && System.currentTimeMillis() < maxEndTime) {
			moreWorkForTheUiThread = Display.getDefault().readAndDispatch();
			latchReachedZero = countDownLatch.getCount() <= 0;
		}

		assertEquals("Reconciler should have notified IXtextModelListener", 0, countDownLatch.getCount());
	}
	
	// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=465082
	@Test public void testCompositeSemanticModificationProducesOnlyOneUndoableCommand() throws Exception {
		String grammar = "grammar foo.G\n" 
				+ "generate foo \"http://foo.net/foo\"\n"
				+ "Foo returns X: 'foo';\n" 
				+ "Bar returns Y: 'bar';"; 
		IXtextDocument document = createDocument(grammar);
		IDocumentUndoManager undoManager = DocumentUndoManagerRegistry.getDocumentUndoManager(document);
		document.modify(new IUnitOfWork.Void<XtextResource>() {
			@Override
			public void process(XtextResource state) throws Exception {
				Grammar grammar = (Grammar) state.getContents().get(0);
				grammar.getRules().get(0).setName("Foo1");
				grammar.getRules().get(1).setName("Bar1");
			}
		});
		assertEquals(grammar.replace("Foo", "Foo1").replace("Bar", "Bar1"), document.get());
		assertTrue(undoManager.undoable());
		undoManager.undo();
		assertEquals(grammar, document.get());
		assertFalse(undoManager.undoable());
	}

	private IXtextDocument createDocument(String grammar) throws Exception {
		IProject project = createProject("foo");
		addNature(project, XtextProjectHelper.NATURE_ID);
		IFile file = createFile("foo/Foo.xtext", grammar);
		XtextEditor editor = openEditor(file);
		return editor.getDocument();
	}
}
