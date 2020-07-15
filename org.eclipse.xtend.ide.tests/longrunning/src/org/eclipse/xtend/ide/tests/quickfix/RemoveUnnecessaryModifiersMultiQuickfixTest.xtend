/*******************************************************************************
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.quickfix

import org.eclipse.xtend.ide.tests.XtendIDEInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.editor.quickfix.QuickAssistCompletionProposal
import org.eclipse.xtext.ui.testing.AbstractMultiQuickfixTest
import org.junit.Test
import org.junit.runner.RunWith

import static extension org.eclipse.xtend.ide.tests.WorkbenchTestHelper.createPluginProject

/**
 * @author Aaron R Miller - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(XtendIDEInjectorProvider)
class RemoveUnnecessaryModifiersMultiQuickfixTest extends AbstractMultiQuickfixTest {

	static final String MODEL_WITH_UNNECESSARY_MODIFIERS = '''
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

	override String getFileName() {
		return "Foo"
	}

	override dslFile(CharSequence content) {
		super.dslFile(projectName, "src/unnecessarymodifiers/" + fileName, fileExtension, content);
	}

	override void setUp() throws Exception {
		super.setUp()

		projectName.createPluginProject()
	}

	@Test
	def void testRemoveUnnecessaryModifiersQuickfixXtend() {

		// Use Xtend style API...
		
		// TODO...
		// org.junit.ComparisonFailure: expected:<...nnecessarymodifiers
		// [class Foo {
		// 	 val A = 1
		//	 def m() {
		//		 new Runnable {
		//			 override run() {
		//				 println(A)
		//			 }
		//		 }
		//	 }
		// }
		// ------------------
		// (no markers found)]> but was:<...nnecessarymodifiers
		// [<0<public>0> class Foo {
		//	 <1<private>1> <2<final>2> val A = 1
		//	 def <3<public>3> m() {
		//		 new Runnable {
		//			 <4<public>4> override <5<def>5> run() {
		//				 println(A)
		//			 }
		//		 }
		//	 }
		// }
		// ---------------------------------------------------
		// 0: message=The public modifier is unnecessary on class Foo
		// 1: message=The private modifier is unnecessary on field A
		// 2: message=The final modifier is unnecessary on field A
		// 3: message=The public modifier is unnecessary on method m
		// 4: message=The public modifier is unnecessary on method run
		// 5: message=The def modifier is unnecessary on method run]
		MODEL_WITH_UNNECESSARY_MODIFIERS.testMultiQuickfix('''
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
			---------------------------------------------------
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
			------------------
			(no markers found)
		''')
	}

	@Test
	def void testRemoveUnnecessaryModifiersQuickfixJava() {

		// Use Java style API...
		
		val xtextEditor = openEditor(dslFile(MODEL_WITH_UNNECESSARY_MODIFIERS))

		val offset = MODEL_WITH_UNNECESSARY_MODIFIERS.indexOf("public") + 1
		val proposals = computeQuickAssistProposals(xtextEditor, offset)

		assertEquals(1, proposals.size())
		assertEquals(1, proposals.filter[it instanceof QuickAssistCompletionProposal].size())
	}
}
