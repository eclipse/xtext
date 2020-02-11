/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.launching

import com.google.inject.Inject
import org.eclipse.core.resources.IFile
import org.eclipse.jdt.core.IJavaElement
import org.eclipse.xtend.ide.launching.XtendJavaElementDelegateJunitLaunch
import org.eclipse.xtend.ide.tests.XtendIDEInjectorProvider
import org.eclipse.xtext.resource.FileExtensionProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.XtextProjectHelper
import org.eclipse.xtext.ui.editor.XtextEditor
import org.eclipse.xtext.ui.testing.AbstractEditorTest
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil
import org.eclipse.xtext.xbase.ui.launching.JavaElementDelegateJunitLaunch
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import static extension org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil.addNature
import static extension org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil.createJavaProject

/**
 * @author miklossy - Initial contribution and API
 * 
 * Test cases for the {@link XtendJavaElementDelegateJunitLaunch} class.
 */
@RunWith(XtextRunner)
@InjectWith(XtendIDEInjectorProvider)
class XtendJavaElementDelegateJunitLaunchTest extends AbstractEditorTest {

	// cursor position marker
	val c = '''<|>'''

	@Inject extension FileExtensionProvider
	@Inject JavaElementDelegateJunitLaunch launcher

	@Before def void setup() {
		/*
		 * Xbase-based languages require java project
		 */
		projectName.createJavaProject
	}

	@Test def test_class_is_recognized_if_cursor_is_located_before_the_class() {
		'''
			«c»package foo

			import org.junit.Test
			import static org.junit.Assert.assertTrue

			class FooTest {

				@Test def a() {
					assertTrue(true)
				}

				@Test def b() {
					assertTrue(false)
				}

			}
		'''.junitTestClassIsRecognized
	}

	@Test def test_class_is_recognized_if_cursor_is_located_in_the_class() {
		'''
			package foo

			import org.junit.Test
			import static org.junit.Assert.assertTrue

			class FooTest {
			«c»
				@Test def a() {
					assertTrue(true)
				}

				@Test def b() {
					assertTrue(false)
				}

			}
		'''.junitTestClassIsRecognized
	}

	@Test def test_class_is_recognized_if_cursor_is_located_after_the_class() {
		'''
			package foo

			import org.junit.Test
			import static org.junit.Assert.assertTrue

			class FooTest {

				@Test def a() {
					assertTrue(true)
				}

				@Test def b() {
					assertTrue(false)
				}

			}«c»
		'''.junitTestClassIsRecognized
	}

	@Test def test_class_is_recognized_if_cursor_is_located_in_comment() {
		'''
			package foo

			import org.junit.Test
			import static org.junit.Assert.assertTrue
			
			/** xx«c»x */
			@ExtendWith(InjectionExtension)
			@InjectWith(MyDslInjectorProvider)
			class FooTest {

				@Test def a() {
					assertTrue(true)
				}

				@Test def b() {
					assertTrue(false)
				}

			}
		'''.junitTestClassIsRecognized
	}

	@Test def no_test_class_is_recognized_if_two_classes_are_defined001() {
		'''
			package foo
			class First {
			  @Test def void m() { }
			}
			«c»
			class Second {
			  @Test def void m() { }
			}
		'''.noJunitTestClassIsRecognized
	}

	@Test def no_test_class_is_recognized_if_two_classes_are_defined002() {
		'''
			package foo
			class Utils {
			  // not tests in that class
			}
			«c»
			class Second {
			  @Test def void m() { }
			}
		'''.noJunitTestClassIsRecognized
	}

	private def junitTestClassIsRecognized(CharSequence text) {
		text.junitTestClassIsRecognized("FooTest")
	}

	private def void noJunitTestClassIsRecognized(CharSequence text) {
		text.junitTestClassIsRecognized(null)
	}

	private def junitTestClassIsRecognized(CharSequence it, String expected) {
		// given
		dslFile.
		// when
		openEditor(cursorPosition).
		// then
		junitTestClassIsRecognized(expected)
	}

	private def IFile dslFile(CharSequence text) {
		val file = IResourcesSetupUtil.createFile(projectName, "src/foo/FooTest", primaryFileExtension, text.content)

		/*
		 * TODO: find a better (with good performance) solution
		 * to set the Xtext nature on the test project.
		 */
		val project = file.project
		if (!project.hasNature(XtextProjectHelper.NATURE_ID)) {
			project.addNature(XtextProjectHelper.NATURE_ID)
		}

		IResourcesSetupUtil.fullBuild
		file
	}

	private def openEditor(IFile it, int cursorPosition) {
		val xtextEditor = openEditor

		// set the cursor position
		xtextEditor.internalSourceViewer.setSelectedRange(cursorPosition, 0)

		xtextEditor
	}

	private def void junitTestClassIsRecognized(XtextEditor xtextEditor, String expectedJavaElementName) {
		launcher.initializeWith(xtextEditor)
		val javaElement = launcher.getAdapter(IJavaElement)
		if (expectedJavaElementName === null) {
			javaElement.assertNull
		} else {
			javaElement.assertNotNull
			assertEquals(expectedJavaElementName, javaElement.elementName)
		}
	}

	private def String getProjectName() {
		"XtendJavaElementDelegateJunitLaunchTest"
	}

	private def String getContent(CharSequence text) {
		 text.toString.replace(c, "")
	}

	private def int getCursorPosition(CharSequence text) {
		val cursorPosition = text.toString.indexOf(c)
		if(cursorPosition == -1) {
			fail('''
				The input text
				«text»
				must contain the '«c»' special symbol indicating the current cursor position!
			''')
		}
		cursorPosition
	}
}