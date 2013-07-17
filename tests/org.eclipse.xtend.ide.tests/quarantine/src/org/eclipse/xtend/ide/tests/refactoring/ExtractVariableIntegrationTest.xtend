package org.eclipse.xtend.ide.tests.refactoring

import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.jface.text.TextSelection
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.xbase.ui.refactoring.ExpressionUtil
import org.eclipse.xtext.xbase.ui.refactoring.ExtractVariableRefactoring
import org.junit.After
import org.junit.Test

class ExtractVariableIntegrationTest extends AbstractXtendUITestCase {
	
	@Inject extension WorkbenchTestHelper workbenchTestHelper
	
	@Inject Provider<ExtractVariableRefactoring> refactoringProvider
	 
	@Inject ExpressionUtil util
	
	@After
	def tiraMiGiu() throws Exception {
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
					val foo = getFoo('bar')
					foo
				}
				
				def getFoo(String x) {
					x
				}
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
	
	@Test
	def void testClosureBody() throws Exception {
		'''
			class Foo {
				def bar() {
					newArrayList('jan','hein','claas','pit').map[
						$toFirstUpper$
					]
				}
			}
		'''.assertAfterExtract('''
			class Foo {
				def bar() {
					newArrayList('jan','hein','claas','pit').map[
						val toFirstUpper1 = toFirstUpper
						toFirstUpper1
					]
				}
			}
		''', true)
	}
	
	@Test
	def void testClosure() throws Exception {
		'''
			class Foo {
				def bar() {
					newArrayList('jan','hein','claas','pit').map[$toFirstUpper]$
				}
			}
		'''.assertAfterExtract('''
			class Foo {
				def bar() {
					val function = [String it | toFirstUpper]
					newArrayList('jan','hein','claas','pit').map(function)
				}
			}
		''', true)
	}
	
	@Test
	def void testClosure_1() throws Exception {
		'''
			class Foo {
				def bar() {
					newArrayList('jan','hein','claas','pit').map[$it|toFirstUpper]$
				}
			}
		'''.assertAfterExtract('''
			class Foo {
				def bar() {
					val function = [String it | toFirstUpper]
					newArrayList('jan','hein','claas','pit').map(function)
				}
			}
		''', true)
	}
	
	@Test
	def void testClosure_2() throws Exception {
		'''
			class Foo {
				def bar() {
					newArrayList('jan','hein','claas','pit').map[$String it|toFirstUpper]$
				}
			}
		'''.assertAfterExtract('''
			class Foo {
				def bar() {
					val function = [String it | toFirstUpper]
					newArrayList('jan','hein','claas','pit').map(function)
				}
			}
		''', true)
	}
	
	@Test
	def void testClosure_3() throws Exception {
		'''
			class Foo {
				def bar() {
					newArrayList('jan','hein','claas','pit').map($String it|toFirstUpper$)
				}
			}
		'''.assertAfterExtract('''
			class Foo {
				def bar() {
					val function = [String it | toFirstUpper]
					newArrayList('jan','hein','claas','pit').map(function)
				}
			}
		''', true)
	}
	
	def protected assertAfterExtract(CharSequence input, CharSequence expected, boolean isFinal) {
		val inputString = input.toString
		val model = inputString.replace('$','')
		val file = createFile('Foo', model)
		val editor = openEditor(file)
		try {
			editor.document.readOnly[
				val int offset = inputString.indexOf('$')
				val length = inputString.lastIndexOf('$') - 1 - offset
				val textSelection = new TextSelection(offset, length)
				val selection = util.findSelectedExpression(it, textSelection)
				val refactoring = refactoringProvider.get()
				refactoring.final = isFinal
				refactoring.initialize(editor.document, selection)
				val status = refactoring.checkAllConditions(new NullProgressMonitor)
				assertTrue(status.toString, status.OK)
				refactoring.createChange(new NullProgressMonitor).perform(new NullProgressMonitor)
			]
			assertEquals(expected.toString, editor.document.get)
		} finally {
			editor.close(false)
		}
	}		
}