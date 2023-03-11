/*******************************************************************************
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.quickfix

import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IMarker
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.xtend.ide.tests.XtendIDEInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.editor.quickfix.QuickAssistCompletionProposal
import org.eclipse.xtext.ui.testing.AbstractMultiQuickfixTest
import org.eclipse.xtext.ui.testing.util.TargetPlatformUtil
import org.junit.Test
import org.junit.runner.RunWith

import static extension org.eclipse.xtend.ide.tests.WorkbenchTestHelper.createPluginProject

/**
 * @author Aaron R Miller - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(XtendIDEInjectorProvider)
class RemoveUnnecessaryModifiersMultiQuickfixTest extends AbstractMultiQuickfixTest {

	@Test def remove_unnecessary_modifiers001() {
		'''
			package unnecessarymodifiers
			public class Foo {
				private final val A = 1
				def public m() {
					new Runnable {
						public override def run() {
							println(A)
						}
					}
				}
			}
		'''.testMultiQuickfix('''
			package unnecessarymodifiers
			<0<public>0> class Foo {
				<1<private>1> <2<final>2> val A = 1
				def <3<public>3> m() {
					new Runnable {
						<4<public>4> override <5<def>5> run() {
							println(A)
						}
					}
				}
			}
			-----
			0: message=The public modifier is unnecessary on class Foo
			1: message=The private modifier is unnecessary on field A
			2: message=The final modifier is unnecessary on field A
			3: message=The public modifier is unnecessary on method m
			4: message=The public modifier is unnecessary on method run
			5: message=The def modifier is unnecessary on method run
		''', '''
			package unnecessarymodifiers
			class Foo {
				val A = 1
				def m() {
					new Runnable {
						override run() {
							println(A)
						}
					}
				}
			}
			-----
			(no markers found)
		''')
	}

	@Test def remove_unnecessary_modifiers002() {
		val model = '''
			package unnecessarymodifiers
			public class Foo {
				private final val A = 1
				def public m() {
					new Runnable {
						public override def run() {
							println(A)
						}
					}
				}
			}
		'''

		val xtextEditor = model.dslFile.openEditor

		val offset = model.indexOf("public") + 1
		val proposals = xtextEditor.computeQuickAssistProposals(offset)

		assertEquals(1, proposals.size)
		assertEquals(1, proposals.filter(QuickAssistCompletionProposal).size)
		assertEquals("Remove the unnecessary modifier.", proposals.head.displayString)
	}

	override setUp() {
		super.setUp
		TargetPlatformUtil.setTargetPlatform(RemoveUnnecessaryModifiersMultiQuickfixTest)
		projectName.createPluginProject
	}

	override getFileName() {
		"Foo"
	}

	override dslFile(CharSequence content) {
		super.dslFile(projectName, "src/unnecessarymodifiers/" + fileName, fileExtension, content)
	}

	// TODO: verify why this workaround is necessary
	override protected IMarker[] getMarkers(IFile file) {
		saveAllOpenEditors
		super.getMarkers(file)
	}

	private def saveAllOpenEditors() {
		activePage.editorReferences.forEach[
			getEditor(false).doSave(new NullProgressMonitor)
		]
	}
}
