/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests

import com.google.inject.Inject
import java.util.Collection
import org.eclipse.jdt.internal.ui.JavaPlugin
import org.eclipse.jdt.ui.PreferenceConstants
import org.eclipse.swt.widgets.Display
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEclipseEditor
import org.eclipse.xtext.ui.refactoring.ui.RefactoringPreferences
import org.junit.After
import org.junit.Test
import org.junit.runners.Parameterized.Parameters

import static org.junit.Assert.*

import static extension org.eclipse.xtend.ide.tests.SwtBotProjectHelper.*

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class JavaRefactoringIntegrationSwtBotTest extends AbstractRefactoringSwtBotTest {

	@Parameters
	def static Collection<Object[]> data() {
		#[ #[true], #[false] ]
	}

	boolean useLinkedEditing
	
	@Inject RefactoringPreferences preferences

	new(boolean useLinkedEditing) {
		this.useLinkedEditing = useLinkedEditing
	}
	
	@After
	def resetPrefs() {
		preferences.useLinkedEditing = true
	}
	
	@Inject
	def initialize(RefactoringPreferences prefs) {
		this.preferences = prefs 
		prefs.useLinkedEditing = useLinkedEditing
	}
	
	protected def setUseLinkedEditing(RefactoringPreferences prefs, boolean useLinkedEditing) {
		Display.getDefault.syncExec[|
			prefs.setUseInlineRefactoring(useLinkedEditing)
			JavaPlugin.getDefault.preferenceStore.setValue(PreferenceConstants.REFACTOR_LIGHTWEIGHT, useLinkedEditing)
		]
	}

	@Test 
	def void renameJavaClass() {
		val xtendEditor = bot.newXtendEditor('XtendClass') => [
			content = '''
				class XtendClass extends JavaClass {
				}
			'''
		]
		val javaEditor = bot.newJavaEditor('JavaClass') => [
			content = '''
				public class ?JavaClass? {}
			'''
			renameFromJava('NewJavaClass', 'Rename Type')
		]
		assertEquals('''
			class XtendClass extends NewJavaClass {
			}
		''', xtendEditor.text)
		assertFalse(xtendEditor.dirty)
		assertEquals('''
			public class NewJavaClass {}
		''', javaEditor.text)
		assertFalse(javaEditor.dirty)
		assertEquals('NewJavaClass.java', javaEditor.title)
	}
	
	@Test 
	def void renameJavaClassXtendReference() {
		val javaEditor = bot.newJavaEditor('JavaClass') => [
			content = '''
				public class JavaClass {}
			'''
		]
		val xtendEditor = bot.newXtendEditor('XtendClass') => [
			content = '''
				class XtendClass extends ?JavaClass? {
				}
			'''
			renameFromXtend('NewJavaClass', 'Rename Type')
		]
		assertEquals('''
			class XtendClass extends NewJavaClass {
			}
		''', xtendEditor.text)
		assertFalse(xtendEditor.dirty)
		assertEquals('''
			public class NewJavaClass {}
		''', javaEditor.text)
		assertFalse(javaEditor.dirty)
		assertEquals('NewJavaClass.java', javaEditor.title)
	}
	
	def renameFromXtend(SWTBotEclipseEditor it, String newName, String dialogName) {
		val renameMenuItem = clickableContextMenu('Rename Element')
		renameMenuItem.click
		if(useLinkedEditing) {
			waitForLinkedMode
			typeText(newName + '\n')			
		} else {
			bot.shell(dialogName).activate.bot => [
				textWithLabel('New name:').text = newName
				button('Finish').click
			]
		}
		waitForRefactoring
	}
	
	def renameFromJava(SWTBotEclipseEditor it, String newName, String dialogName) {
		val renameMenuItem = clickableContextMenu('Refactor', 'Rename...')
		renameMenuItem.click
		if(useLinkedEditing) {
			typeText(newName + '\n')			
		} else {
			bot.shell(dialogName).activate.bot => [
				textWithLabel('New name:').text = newName
				button('Finish').click
			]
		}
		waitForRefactoring
	}	
}