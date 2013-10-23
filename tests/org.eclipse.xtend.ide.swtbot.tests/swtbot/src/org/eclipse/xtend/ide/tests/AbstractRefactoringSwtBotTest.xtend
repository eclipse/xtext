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
import org.eclipse.jface.bindings.keys.KeyStroke
import org.eclipse.swt.SWT
import org.eclipse.swt.widgets.Display
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEclipseEditor
import org.eclipse.swtbot.swt.finder.SWTBot
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition
import org.eclipse.text.undo.DocumentUndoManagerRegistry
import org.eclipse.ui.texteditor.ITextEditor
import org.eclipse.xtend.ide.internal.XtendActivator
import org.eclipse.xtext.ui.refactoring.ui.RefactoringPreferences
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
		bot.closeAllEditors
		cleanWorkspace
	}
	
	@Inject RefactoringPreferences preferences

	@Inject RenameRefactoringController controller

	protected RefactoringTestParameters testParams

	@Before
	def void setUp() {
		XtendActivator.instance.getInjector(XtendActivator.ORG_ECLIPSE_XTEND_CORE_XTEND).injectMembers(this)
		bot.closeAllEditors
		bot.clearSourceFolderContents
	}
 
 	@After
	def void tearDown() {
		Display.getDefault.syncExec[|
			preferences.useInlineRefactoring = true
			preferences.saveAllBeforeRefactoring = true
		]
	}

	new () {
		this.testParams = new RefactoringTestParameters
	}
	
	new(RefactoringTestParameters testParams) {
		this.testParams = testParams
	}
	
	@Inject
	def initialize(RefactoringPreferences preferences) {
		this.preferences = preferences 
		Display.getDefault.syncExec[|
			preferences.useInlineRefactoring = testParams.useInlineRefactoring
			preferences.saveAllBeforeRefactoring = testParams.saveAllBeforeRefactoring
		]
	}	
	
	def renameInXtendEditor(SWTBotEclipseEditor xtendEditor, String newName, String dialogName) {
		val renameMenuItem = xtendEditor.clickableContextMenu('Rename Element')
		renameMenuItem.click
		if(testParams.useInlineRefactoring) {
			waitForLinkedMode
			xtendEditor.typeText(newName)
			if(testParams.usePreview) {
				xtendEditor.pressShortcut(SWT.MOD4, SWT.CR)
				bot.shell(dialogName).activate
				bot.button('OK').click
			} else {
				xtendEditor.pressShortcut(KeyStroke.getInstance(SWT.LF))
			}
		} else {
			bot.shell(dialogName).activate.bot => [
				textWithLabel('New name:').text = newName
				if(testParams.usePreview)
					button('Preview >').click
				button('OK').click
			]
		}
		xtendEditor.waitForRefactoring
	}
	
	def renameInJavaEditor(SWTBotEclipseEditor javaEditor, String newName, String dialogName) {
		val renameMenuItem = javaEditor.clickableContextMenu('Refactor', 'Rename...')
		renameMenuItem.click
		if(testParams.useInlineRefactoring) {
			javaEditor.typeText(newName)
			if(testParams.usePreview) {
				javaEditor.pressShortcut(SWT.MOD4, SWT.CR)
				bot.shell(dialogName).activate
				bot.button('OK').click
			} else {
				javaEditor.pressShortcut(KeyStroke.getInstance(SWT.LF))
			}
		} else {
			bot.shell(dialogName).activate.bot => [
				textWithLabel('New name:').text = newName
				if(testParams.usePreview)
					button('Next').click
				button('Finish').click
			]
		}
		javaEditor.waitForRefactoring
	}	
	
	
	def undo(SWTBotEclipseEditor editor) {
		editor.setFocus
		editor.pressShortcut(SWT.MOD1, 'Z')
		bot.shell("Undo").activate()
		bot.button("OK").click
		new SWTBot().waitUntil(new WaitForRefactoringCondition(editor, true), 15000)
	} 
	
	protected def waitForLinkedMode() {
		new SWTBot().waitUntil(new WaitForLinkedModeCondition(controller))
	}
	
	protected def waitForRefactoring(SWTBotEclipseEditor editor) {
		new SWTBot().waitUntil(new WaitForRefactoringCondition(editor, false), 15000)
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
	
	boolean isRedo
	
	new(SWTBotEclipseEditor editor, boolean isRedo) {
		this.editor = editor
		this.isRedo = isRedo
	}
	
	override getFailureMessage() {
		'Refactoring not performed'
	}

	override test() throws Exception {
		val operationHistory = OperationHistoryFactory.operationHistory
		val label = (if(isRedo) 
			operationHistory.getRedoOperation(undoContext)
				else 
			operationHistory.getUndoOperation(undoContext))?.label
		label.startsWith('Rename ')
	}

	def protected getUndoContext() {
		val ed = editor.reference.getEditor(true) as ITextEditor
		val document = ed.documentProvider.getDocument(ed.editorInput)
		val undoManager = DocumentUndoManagerRegistry.getDocumentUndoManager(document)
		undoManager.undoContext
	}
}

class RefactoringTestParameters {

	@Property boolean useInlineRefactoring = true
	@Property boolean saveAllBeforeRefactoring = true
	@Property boolean usePreview = false
	
	override toString() {
		'''(«
			IF useInlineRefactoring
				»inline«
			ELSE
				»dialog«
			ENDIF», «
			IF saveAllBeforeRefactoring
				»save all«
			ELSE
				»no save«
			ENDIF», «
			IF usePreview
				»preview«
			ELSE
				»no preview«
			ENDIF»)'''
	}
	
}