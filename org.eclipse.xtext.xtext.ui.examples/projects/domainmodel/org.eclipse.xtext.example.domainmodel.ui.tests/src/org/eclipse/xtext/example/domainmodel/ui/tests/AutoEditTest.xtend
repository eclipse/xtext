/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel.ui.tests

import com.google.inject.Inject
import org.eclipse.xtext.resource.FileExtensionProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.XtextProjectHelper
import org.eclipse.xtext.ui.editor.XtextEditor
import org.eclipse.xtext.ui.testing.AbstractAutoEditTest
import org.junit.Test
import org.junit.runner.RunWith

import static extension org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil.addNature
import static extension org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil.createProject

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(DomainmodelUiInjectorProvider)
class AutoEditTest extends AbstractAutoEditTest {

	@Inject extension FileExtensionProvider

	override setUp() {
		super.setUp
		createTestProjectWithXtextNature
	}

	@Test def fantasting_autoedit() {
		'''
			Xtex|
		'''.testAutoEdit('t', '''
		«""»



					MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM  MMMMMMMMM
					MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM      MMMMMMMM
					MMMMMM   MMMMMMMMMMMMMMMMMMMMMMMMMMMMMM     MMMMMMMM
					MMMM       MMMMMMMMMMMMMMMMMMMMMMMMMMMMM    MMMMMMMM
					MMM          MMMMMMMMMMMMMMMMMMMMMMMMMMMM   MMMMMMMM
					M              MMMMMMMMMMMMMMMMMMMMMMMMM   MMMMMMMMM
					MM                MMMMMMMMMMMMMMMMMMMMM   MMMMMMMMMM
					MMMM                 MMMMMMMMMMMMMMMM   MMMMMMMMMMMM
					MMMMMM                   MMMMMMMMM     MMMMMMMMMMMMM
					MMMMMMMM                             MMMMMMMMMMMMMMM
					MMMMMMMMMM                        MMMMMMMMMMMMMMMMMM
					MMMMMMMMMMMMMM                MMMMMMMMMMMMMMMMMMMMMM
					MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
					MMMMMMMMMMMMMMMMMMMM            MMMMMMMMMMMMMMMMMMMM
					MMMMMMMMMMMMMMMMM                     MMMMMMMMMMMMMM
					MMMMMMMMMMMMMM                           MMMMMMMMMMM
					MMMMMMMMMMMM       MMM                      MMMMMMMM
					MMMMMMMMMM    MMMMMMMMMMMMMMM                 MMMMMM
					MMMMMMMMM   MMMMMMMMMMMMMMMMMMMM                MMMM
					MMMMMMMM  MMMMMMMMMMMMMMMMMMMMMMMMM               MM
					MMMMMMM   MMMMMMMMMMMMMMMMMMMMMMMMMMM            MMM
					MMMMMM    MMMMMMMMMMMMMMMMMMMMMMMMMMMMM        MMMMM
					MMMMMM      MMMMMMMMMMMMMMMMMMMMMMMMMMMMM    MMMMMMM
					MMMMMM      MMMMMMMMMMMMMMMMMMMMMMMMMMMMMM  MMMMMMMM
					MMMMMMM    MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
					MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM|
		''')
	}

	private def testAutoEdit(CharSequence it, char key, CharSequence newContent) {
		// given
		dslFile.
		// when
		press(key).
		// then
		dslFileHasContent(newContent)
	}

	private def dslFile(CharSequence it) {
		toString.openEditor
	}

	private def press(XtextEditor it, char c) {
		pressKey(c)
		it
	}

	private def dslFileHasContent(XtextEditor editor, CharSequence it) {
		toString.assertState(editor)
	}

	private def createTestProjectWithXtextNature() {
		"foo".createProject.addNature(XtextProjectHelper.NATURE_ID)
	}

	override protected getFileExtension() {
		primaryFileExtension
	}
}