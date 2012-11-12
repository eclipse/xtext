package org.eclipse.xtend.ide.tests.refactoring

import javax.inject.Inject
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.junit.Test
import org.eclipse.xtext.xbase.ui.refactoring.ExpressionUtil
import com.google.inject.Provider
import org.eclipse.xtext.xbase.ui.refactoring.ExtractVariableRefactoring
import org.eclipse.jface.text.TextSelection
import org.eclipse.core.runtime.NullProgressMonitor
import org.junit.After

class ExtractVariableIntegrationTest extends AbstractXtendUITestCase {
	
	@Inject extension WorkbenchTestHelper workbenchTestHelper
	
	@Inject Provider<ExtractVariableRefactoring> refactoringProvider
	 
	@Inject ExpressionUtil util
	
	@After
	def myTearDown() throws Exception {
		workbenchTestHelper.tearDown()
	}
	
	@Test
	def void testValInBlock() throws Exception {
		'''
			class Foo {
				def bar() {
					22 + $33$
				}
			}
		'''.assertAfterExtract('''
			class Foo {
				def bar() {
					val i = 33
					22 + i
				}
			}
		''', true)
	}
	
	@Test
	def void testVarInBlock() throws Exception {
		'''
			class Foo {
				def bar() {
					22 + $33$
				}
			}
		'''.assertAfterExtract('''
			class Foo {
				def bar() {
					var i = 33
					22 + i
				}
			}
		''', false)
	}
	
	@Test
	def void testInsertBlock() throws Exception {
		'''
			class Foo {
				def bar() {
					if(true)
						22 + $33$
				}
			}
		'''.assertAfterExtract('''
			class Foo {
				def bar() {
					if(true) {
						val i = 33
						22 + i
					}
				}
			}
		''', true)
	}
	
	@Test
	def void testGoUpControlStructure() throws Exception {
		'''
			class Foo {
				def bar() {
					if($true$)
						22 + 33
				}
			}
		'''.assertAfterExtract('''
			class Foo {
				def bar() {
					var b = true
					if(b)
						22 + 33
				}
			}
		''', false)
	}
	
	@Test
	def void testGetterName() throws Exception {
		'''
			class Foo {
				def bar() {
					$getFoo('bar')$
				}
				
				def getFoo(String x) {
					x
				}
			}
		'''.assertAfterExtract('''
			class Foo {
				def bar() {
					foo = getFoo('bar')
					foo
				}
				
				def getFoo(String x) {
					x
				}
		''', true)
	}
	
	@Test
	def void testTypeName() throws Exception {
		'''
			import java.util.Date
			class Foo {
				def bar() {
					$new Date()$
				}
			}
		'''.assertAfterExtract('''
			import java.util.Date
			class Foo {
				def bar() {
					val date = new Date()
					date
				}
			}
		''', true)
	}
	
	def protected assertAfterExtract(CharSequence input, CharSequence expected, boolean isFinal) {
		val inputString = input.toString
		val editor = openEditor('Foo', inputString.replace('$',''))
		editor.document.readOnly[
			val selection = util.findSelectedExpression(it, 
				new TextSelection(inputString.indexOf('$'), inputString.lastIndexOf('$') - inputString.indexOf('$') - 1)
			)
			val refactoring = refactoringProvider.get()
			refactoring.final = isFinal
			refactoring.initialize(editor.document, selection)
			refactoring.checkAllConditions(new NullProgressMonitor)
			refactoring.createChange(new NullProgressMonitor).perform(new NullProgressMonitor)
		]
		editor.close(false)
	}		
}