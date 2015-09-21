/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.contentassist

import com.google.inject.Inject
import org.eclipse.jface.text.BadLocationException
import org.eclipse.jface.text.contentassist.ICompletionProposal
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.ui.editor.XtextEditor
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil
import org.junit.After
import org.junit.Before
import org.junit.Test

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*

/**
 * @author Holger Schill - Initial contribution and API
 */
class DirtyEditorFilteringContentAssistTests extends AbstractXtendUITestCase{

	@Inject extension WorkbenchTestHelper

	@Inject SyncUtil syncUtil;

	@Before def void start() {
		closeWelcomePage
	}

	@After def void close() {
		_workbenchTestHelper.tearDown
	}

	@Test
	def testFilteringExtends(){
		val fooEditor = openEditor("foo/Foo.xtend",'''
			package foo
			class MyDirtyType {}
		''')
		val clientModel = '''
			package foo
			class Client extends MyDirtyType|{
			}
		'''
		waitForBuild
		val clientEditor = openEditor("foo/Client.xtend",clientModel)
		fooEditor.document.set('''
			package foo
			class MyDirtyType2 {}
		''')
		val proposals = computeCompletionProposals(clientEditor,fooEditor,clientModel.indexOf("|"))
		assertEquals(1,proposals.size)
		assertTrue(!proposals.exists[e | e.toString.startsWith("Proposal: MyDirtyType - ")])
		assertTrue(proposals.exists[e | e.toString.startsWith("Proposal: MyDirtyType2 - ")])
	}

	@Test
	def testFilteringConstructor(){
		val fooEditor = openEditor("foo/Foo.xtend",'''
			package foo
			class MyDirtyType {}
		''')
		val clientModel = '''
			package foo
			class Client {
				def foo(){
					new MyDirtyType|
				}
			}
		'''
		waitForBuild
		val clientEditor = openEditor("foo/Client.xtend",clientModel)
		fooEditor.document.set('''
			package foo
			class MyDirtyType2 {}
		''')
		val proposals = computeCompletionProposals(clientEditor,fooEditor,clientModel.indexOf("|"))
		assertTrue(!proposals.exists[e | e.toString.startsWith("Proposal: MyDirtyType - ")])
		assertTrue(proposals.exists[e | e.toString.startsWith("Proposal: MyDirtyType2 - ")])
	}

	def ICompletionProposal[] computeCompletionProposals(XtextEditor editorForCompletion , XtextEditor dirtyEditor, int cursorPosition) throws BadLocationException {
		syncUtil.waitForReconciler(dirtyEditor)
		val sourceViewer = editorForCompletion.internalSourceViewer
		val contentAssistant = editorForCompletion.getXtextSourceViewerConfiguration().getContentAssistant(sourceViewer);
		val contentType = editorForCompletion.document.getContentType(cursorPosition);
		val processor = contentAssistant.getContentAssistProcessor(contentType);
		if (processor != null) {
			return processor.computeCompletionProposals(sourceViewer, cursorPosition);
		}
		return null;
	}

}