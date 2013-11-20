package org.eclipse.xtend.ide.tests.refactoring

import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.jface.text.TextSelection
import org.eclipse.ltk.core.refactoring.RefactoringStatus
import org.eclipse.xtend.ide.refactoring.ExtractMethodRefactoring
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.xbase.ui.refactoring.ExpressionUtil
import org.junit.After
import org.junit.Test

/**
 * @author Jan Koehnlein
 */
class ExtractMethodIntegrationTest extends AbstractXtendUITestCase {

	@Inject extension WorkbenchTestHelper workbenchTestHelper

	@Inject Provider<ExtractMethodRefactoring> refactoringProvider

	@Inject ExpressionUtil util

	@After def tiraMiGiu() throws Exception {
		workbenchTestHelper.tearDown()
	}

	@Test def testSimple() {
		'''
			class Foo {
				def foo() {
					$val x = 1$
				}
			}
		'''.assertAfterExtract([], '''
			class Foo {
				def foo() {
					bar()
				}
				
				def bar() {
					val x = 1
				}
			}
			''')
	}

	@Test def testStatic() {
		'''
			class Foo {
				def static foo() {
					$val x = 1$
				}
			}
		'''.assertAfterExtract([], '''
			class Foo {
				def static foo() {
					bar()
				}
				
				def static bar() {
					val x = 1
				}
			}
		''')
	}

	@Test def testParameter() {
		'''
			class Foo {
				def foo() {
					val x = 1
					$val y = x$
				}
			}
		'''.assertAfterExtract([], '''
			class Foo {
				def foo() {
					val x = 1
					bar(x)
				}
				
				def bar(int x) {
					val y = x
				}
			}
		''')
	}

	@Test def testReturnVariable() {
		'''
			class Foo {
				def foo() {
					$var x = 1$
					val y = x
				}
			}
		'''.assertAfterExtract([explicitlyDeclareReturnType = true], '''
			class Foo {
				def foo() {
					var x = bar()
					val y = x
				}
				
				def int bar() {
					var x = 1
					x
				}
			}
		''')
	}

	@Test def testReturnValue() {
		'''
			class Foo {
				def foo() {
					$val x = 1$
					val y = x
				}
			}
		'''.assertAfterExtract([explicitlyDeclareReturnType = true], '''
			class Foo {
				def foo() {
					val x = bar()
					val y = x
				}
				
				def int bar() {
					val x = 1
					x
				}
			}
		''')
	}

	@Test def testReturnStatements_0() {
		'''
			class Foo {
				def foo(int i) {
					$switch i {
						case 0: return 0
					}
					switch i {
						case 2: return ''
						case 3: return null
					}$
				}
			}
		'''.assertAfterExtract([explicitlyDeclareReturnType = true], '''
			class Foo {
				def foo(int i) {
					bar(i)
				}
				
				def Object bar(int i) {
					switch i {
						case 0: return 0
					}
					switch i {
						case 2: return ''
						case 3: return null
					}
				}
			}
			''')
	}

	@Test def testReturnStatements_1() {
		'''
			class Foo {
				def foo(int i) {
					switch i {
						case 0: return 0
					}
					$switch i {
						case 2: return ''
						case 3: return null
					}$
				}
			}
		'''.assertAfterExtract([explicitlyDeclareReturnType = true], '''
			class Foo {
				def foo(int i) {
					switch i {
						case 0: return 0
					}
					bar(i)
				}
				
				def String bar(int i) {
					switch i {
						case 2: return ''
						case 3: return null
					}
				}
			}
		''')
	}
	
	@Test def testVoidStatements() {
		'''
			class Foo {
				def foo(int x) {
					$for (i : x..45) {
						println(i)
					}$
				}
			}
		'''.assertAfterExtract([explicitlyDeclareReturnType = true], '''
			class Foo {
				def foo(int x) {
					bar(x)
				}
				
				def void bar(int x) {
					for (i : x..45) {
						println(i)
					}
				}
			}
		''')
	}
	
	@Test def testClosure_0() {
		'''
			class Foo {
				def foo(String baz) {
					newArrayList(baz).map$[toFirstUpper]$
				}
			}
		'''.assertAfterExtract([explicitlyDeclareReturnType = true], '''
			class Foo {
				def foo(String baz) {
					newArrayList(baz).map(bar())
				}
				
				def (String)=>String bar() {
					[toFirstUpper]
				}
			}
		''')
	}
	
	@Test def testClosure_1() {
		'''
			class Foo {
				def foo(String baz) {
					newArrayList(baz).map$[x|x.toFirstUpper]$
				}
			}
		'''.assertAfterExtract([explicitlyDeclareReturnType = true], '''
			class Foo {
				def foo(String baz) {
					newArrayList(baz).map(bar())
				}
				
				def (String)=>String bar() {
					[x|x.toFirstUpper]
				}
			}
		''')
	}
	
	@Test def testClosure_2() {
		'''
			class Foo {
				def foo(String baz) {
					newArrayList(baz).map$[String it|toFirstUpper]$
				}
			}
		'''.assertAfterExtract([explicitlyDeclareReturnType = true], '''
			class Foo {
				def foo(String baz) {
					newArrayList(baz).map(bar())
				}
				
				def (String)=>String bar() {
					[String it|toFirstUpper]
				}
			}
		''')
	}
	
	@Test def testClosure_3() {
		'''
			class Foo {
				def foo(String baz) {
					newArrayList(baz).map($String it|toFirstUpper$)
				}
			}
		'''.assertAfterExtract([explicitlyDeclareReturnType = true], '''
			class Foo {
				def foo(String baz) {
					newArrayList(baz).map(bar())
				}
				
				def (String)=>String bar() {
					[String it|toFirstUpper]
				}
			}
		''')
	}
	
	@Test def testRenameParameter() {
		'''
			class Foo {
				def foo(int shrinkMe, int expandMe) {
					$shrinkMe + expandMe - shrinkMe-  expandMe$
				}
			}
		'''.assertAfterExtract([
			parameterInfos.get(0).newName = 's'
			parameterInfos.get(1).newName = 'expandMeMore'
		], '''
			class Foo {
				def foo(int shrinkMe, int expandMe) {
					bar(shrinkMe, expandMe)
				}
				
				def bar(int s, int expandMeMore) {
					s + expandMeMore - s-  expandMeMore
				}
			}
		''')
	}
	
	@Test def testSwapParameterNames() {
		'''
			class Foo {
				def foo(int i, int j) {
					$i-j$
				}
			}
		'''.assertAfterExtract([
			parameterInfos.get(0).newName = 'j'
			parameterInfos.get(1).newName = 'i'
		], '''
			class Foo {
				def foo(int i, int j) {
					bar(i, j)
				}
				
				def bar(int j, int i) {
					j-i
				}
			}
		''')
	}
	
	@Test def testTypeParameter_0() {
		'''
			class Foo {
				def <T> foo() {
					$<T>newArrayList$
				}
			}
		'''.assertAfterExtract([
		], '''
			class Foo {
				def <T> foo() {
					bar()
				}
				
				def <T> bar() {
					<T>newArrayList
				}
			}
		''')
	}
	
	@Test def testTypeParameter_1() {
		'''
			class Foo {
				def <T, U> foo() {
					if(true) 
						$<T>newArrayList$
					else
						<U>newArrayList
				}
			}
		'''.assertAfterExtract([
		], '''
			class Foo {
				def <T, U> foo() {
					if(true) 
						bar()
					else
						<U>newArrayList
				}
				
				def <T> bar() {
					<T>newArrayList
				}
			}
		''')
	}
	
	@Test def testTypeParameter_2() {
		'''
			class Foo {
				def <T, U> foo() {
					$if(true) 
						<T>newArrayList
					else
						<U>newArrayList$
				}
			}
		'''.assertAfterExtract([
		], '''
			class Foo {
				def <T, U> foo() {
					bar()
				}
				
				def <T, U> bar() {
					if(true) 
						<T>newArrayList
					else
						<U>newArrayList
				}
			}
		''')
	}
	
	@Test def testFailOnMultipleCallins() {
		'''
			class Foo {
				def foo() {
					$val x=42
					val y=42$
					x+y
				}
			}
		'''.assertExtractForbidden([], 'ambiguous')
	}

	@Test def testFailOnReturns() {
		'''
			class Foo {
				def foo() {
					$if(true) 
						return
					else 
						val y=42$
					y
				}
			}
		'''.assertExtractForbidden([], 'control flow')
	}

	@Test def testFailOnDuplicateMethodName() {
		'''
			class Foo {
				def foo() {
					$val x = 4$
				}
			}
		'''.assertExtractForbidden([methodName = 'foo'], 'already defined')
	}

	@Test def testFailOnDuplicateParameterName() {
		'''
			class Foo {
				def foo() {
					val x = 4
					val y = 2
					$x+y$
				}
			}
		'''.assertExtractForbidden([parameterInfos.get(1).newName = 'x'], 'duplicate')
	}

	def protected assertAfterExtract(CharSequence input, (ExtractMethodRefactoring)=>void initializer,
		CharSequence expected) {
		val inputString = input.toString
		val file = createFile('Foo', inputString.replace('$', ''))
		val editor = openEditor(file)
		try {
			editor.document.readOnly [
				val selection = util.findSelectedSiblingExpressions(
					it,
					new TextSelection(inputString.indexOf('$'),
						inputString.lastIndexOf('$') - inputString.indexOf('$') - 1)
				)
				val refactoring = refactoringProvider.get()
				refactoring.initialize(editor, selection, true)
				refactoring.setMethodName('bar')
				var status = refactoring.checkInitialConditions(new NullProgressMonitor)
				assertTrue(status.toString, status.OK)
				initializer.apply(refactoring)
				status = refactoring.checkFinalConditions(new NullProgressMonitor)
				assertTrue(status.toString, status.OK)
				refactoring.createChange(new NullProgressMonitor).perform(new NullProgressMonitor)
			]
			assertEquals(expected.toString, editor.document.get)
		} finally {
			editor.close(false)
		}
	}

	def protected void assertExtractForbidden(CharSequence input, (ExtractMethodRefactoring)=>void initializer, String messageFragment) {
		val inputString = input.toString
		val file = createFile('Foo', inputString.replace('$', ''))
		val editor = openEditor(file)
		try {
			editor.document.readOnly [
				val selection = util.findSelectedSiblingExpressions(
					it,
					new TextSelection(inputString.indexOf('$'),
						inputString.lastIndexOf('$') - inputString.indexOf('$') - 1)
				)
				val refactoring = refactoringProvider.get()
				refactoring.initialize(editor, selection, true)
				refactoring.setMethodName('bar')
				val status = refactoring.checkInitialConditions(new NullProgressMonitor)
				initializer.apply(refactoring)
				status.merge(refactoring.checkFinalConditions(new NullProgressMonitor))
				assertTrue(status.toString, status.hasError)
				val message = status.getMessageMatchingSeverity(RefactoringStatus::ERROR)
				assertTrue(message, message.toLowerCase.contains(messageFragment.toLowerCase))
				''
			]
		} finally {
			editor.close(false)
		}
	}

}
