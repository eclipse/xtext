/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests

import com.google.inject.Inject
import org.eclipse.core.commands.operations.OperationHistoryFactory
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEclipseEditor
import org.eclipse.swtbot.swt.finder.SWTBot
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition
import org.eclipse.text.undo.DocumentUndoManagerRegistry
import org.eclipse.ui.texteditor.ITextEditor
import org.eclipse.xtend.ide.internal.XtendActivator
import org.eclipse.xtext.ui.refactoring.ui.RenameRefactoringController
import org.junit.After
import org.junit.AfterClass
import org.junit.Assert
import org.junit.Before
import org.junit.BeforeClass

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*

import static extension org.eclipse.xtend.ide.tests.SwtBotProjectHelper.*

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
abstract class AbstractRefactoringSwtBotTest {
	
	static SWTWorkbenchBot bot
	
	@BeforeClass
	static def void initialize() {
		cleanWorkspace
		bot = new SWTWorkbenchBot
		bot.newXtendProject('test')
	}
	
	@AfterClass
	static def void terminate() {
		cleanWorkspace
	}
	
	@Before
	def setUp() {
		XtendActivator.instance.getInjector(XtendActivator.ORG_ECLIPSE_XTEND_CORE_XTEND).injectMembers(this)	
	}
 
	@After
	def void tearDown() {
		bot.clearSourceFolderContents
		bot.closeAllEditors
	}
	
	@Inject RenameRefactoringController controller
	
	protected def waitForLinkedMode() {
		new SWTBot().waitUntil(new WaitForLinkedModeCondition(controller))
	}
	
	protected def waitForRefactoring(SWTBotEclipseEditor editor) {
		new SWTBot().waitUntil(new WaitForRefactoringCondition(editor), 15000)
	}
	
	protected def getBot() {
		bot
	}
	
	protected def assertEquals(CharSequence expected, CharSequence value) {
		Assert.assertEquals(expected.toString(), value.toString())
	}
}

class WaitForLinkedModeCondition extends DefaultCondition {
	
	RenameRefactoringController controller
	
	new(RenameRefactoringController controller) {
		this.controller = controller
	}
	
	override getFailureMessage() {
		'Linked mode not entered'
	}

	override test() throws Exception {
		controller.activeLinkedMode != null
	}
}

class WaitForRefactoringCondition extends DefaultCondition {
	
	SWTBotEclipseEditor editor
	
	new(SWTBotEclipseEditor editor) {
		this.editor = editor
	}
	
	override getFailureMessage() {
		'Refactoring not performed'
	}

	override test() throws Exception {
		val label = OperationHistoryFactory.operationHistory.getUndoOperation(undoContext)?.label
		label.startsWith('Rename ')
	}

	def protected getUndoContext() {
		val ed = editor.reference.getEditor(true) as ITextEditor
		println(ed.editorInput)
		val document = ed.documentProvider.getDocument(ed.editorInput)
		val undoManager = DocumentUndoManagerRegistry.getDocumentUndoManager(document)
		println(undoManager)
		undoManager.undoContext
	}
}