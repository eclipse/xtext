/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.completion

import org.eclipse.xtend.idea.LightXtendTest

class XtendCompletionTest extends LightXtendTest {

	def void testClassKeyword() {
		complete("cl<caret>")
		assertLookupStrings("class")
	}
	
	def void testExtendsKeyword() {
		complete("class Foo ex<caret>")
		assertLookupStrings("extends")
	}
	
	def void testEmptyFile() {
		complete("")
		assertLookupStrings(
			"annotation",
			"class",
			"enum",
			"import",
			"interface",
			"package"
		)
	}
	
	def void testJvmParameterizedTypeReference_Type() {
		"class Foo extends Array<caret>".complete
		val lookupElementStrings = myFixture.lookupElementStrings
		assertTrue(lookupElementStrings.toString, lookupElementStrings.contains("ArrayList"))
	}
	
	def void testTypeReferenceNoTypeArgs_Type() {
		'''
		   class Foo {
		   		def Array<caret> foo() {}
		   }
		'''.toString.complete
		val lookupElementStrings = myFixture.lookupElementStrings
		assertTrue(lookupElementStrings.toString, lookupElementStrings.contains("ArrayList"))
	}
	
	def void testJvmParameterizedTypeReference_Type_03() {
		"class Foo <caret> {".complete
		assertLookupStrings(
			"extends",
			"implements"
		)
	}
	
	def void testXRelationalExpression_Type() {
		'''
		   class Foo {
		   		def foo(Object foo) {
		   			foo instanceof Array<caret>
		   		}
		   }
		'''.toString.complete
		val lookupElementStrings = myFixture.lookupElementStrings
		assertTrue(lookupElementStrings.toString, lookupElementStrings.contains("ArrayList"))
	}
	
	def void testXImportDeclaration_ImportedType() {
		"import <caret>".complete
		val lookupElementStrings = myFixture.lookupElementStrings
		assertTrue(lookupElementStrings.toString, lookupElementStrings.contains("ArrayList"))
	}
	
	def void testXImportDeclaration_ImportedType_02() {
		"import java.util.Array<caret>".complete
		val lookupElementStrings = myFixture.lookupElementStrings
		assertTrue(lookupElementStrings.toString, lookupElementStrings.contains("ArrayList"))
	}
	
	def void testAppliedXImportDeclaration() {
		"import java.util.Array<caret>".complete
		myFixture.type('\n')
		assertEquals('import java.util.ArrayList',myFixture.editor.document.text.toString)
	}
	
	def void testAppliedXImportDeclaration_01() {
		"import ArrayLis<caret>".complete
		myFixture.type('\n')
		assertEquals('import java.util.ArrayList',myFixture.editor.document.text.toString)
	}
	
	def void testAppliedTypeReferenceImportsType_01() {
		'''
			class MyClass extends Observa<caret> {
				
			}
		'''.toString.complete
		myFixture.type('\n')
		assertEquals('''
			import java.util.Observable
			
			class MyClass extends Observable {
				
			}
		'''.toString,myFixture.editor.document.text.toString)
	}
	
	def void testAppliedTypeReferenceImportsType_02() {
		'''
			import java.util.Observable
			
			class MyClass extends Observab<caret> {
				
			}
		'''.toString.complete
		myFixture.type('\n')
		assertEquals('''
			import java.util.Observable
			
			class MyClass extends Observable {
				
			}
		'''.toString,myFixture.editor.document.text.toString)
	}
	
	def void testAppliedTypeReferenceImportsType_03() {
		'''
			class MyClass extends LocalCl<caret> {
				
			}
			class LocalClass {}
		'''.toString.complete
		myFixture.type('\n')
		assertEquals('''
			class MyClass extends LocalClass {
				
			}
			class LocalClass {}
		'''.toString,myFixture.editor.document.text.toString)
	}
	
	def void testAppliedTypeReferenceImportsType_04() {
		'''
			class MyClass {
				Observ<caret> myField
			}
		'''.toString.complete
		myFixture.type('\n')
		assertEquals('''
			import java.util.Observable
			
			class MyClass {
				Observable myField
			}
		'''.toString,myFixture.editor.document.text.toString)
	}
	
	def void testAppliedTypeReferenceImportsType_05() {
		'''
			class MyClass {
				def Observ<caret> myMethod() {
				}
			}
		'''.toString.complete
		myFixture.type('\n')
		assertEquals('''
			import java.util.Observable
			
			class MyClass {
				def Observable myMethod() {
				}
			}
		'''.toString,myFixture.editor.document.text.toString)
	}
	
		
	def void testAppliedTypeReferenceImportsType_06() {
		'''
			class MyClass {
				def void myMethod() {
					new Observ<caret>
				}
			}
		'''.toString.complete
		myFixture.type('\n')
		assertEquals('''
			import java.util.Observable
			
			class MyClass {
				def void myMethod() {
					new Observable
				}
			}
		'''.toString,myFixture.editor.document.text.toString)
	}
	
	def void testXConstructorCall_Constructor() {
		'''
		   class Foo {
		   		def foo() {
		   			new <caret>
		   		}
		   }
		   
		   class Bar {}
		   
		   abstract class AbstractBar {}
		   
		   interface InterfaceBar {}
		'''.toString.complete
		val lookupElementStrings = myFixture.lookupElementStrings
		assertTrue(lookupElementStrings.toString, lookupElementStrings.contains("ArrayList"))
		assertTrue(lookupElementStrings.toString, lookupElementStrings.contains("Bar"))
		assertFalse(lookupElementStrings.toString, lookupElementStrings.contains("AbstractBar"))
		assertFalse(lookupElementStrings.toString, lookupElementStrings.contains("InterfaceBar"))
	}
	
	def void testXTypeLiteral_Type() {
		'''
		   class Foo {
		   		def foo() {
		   			typeof(<caret>
		   		}
		   }
		'''.toString.complete
		val lookupElementStrings = myFixture.lookupElementStrings
		assertTrue(lookupElementStrings.toString, lookupElementStrings.contains("ArrayList"))
		assertTrue(lookupElementStrings.toString, lookupElementStrings.contains("Foo"))
	}
	
	def void testXAnnotation_AnnotationType() {
		'''
		   @Deprecat<caret>
		   class Foo {
		   }
		'''.toString.complete
		val lookupElementStrings = myFixture.lookupElementStrings
		assertTrue(lookupElementStrings.toString, lookupElementStrings.contains("Deprecated"))
	}
	
	def void testXAnnotation_AnnotationType_02() {
		'''
		   @Array<caret>
		   class Foo {
		   }
		'''.toString.complete
		val lookupElementStrings = myFixture.lookupElementStrings
		assertFalse(lookupElementStrings.toString, lookupElementStrings.contains("ArrayList"))
	}
	
	def void testXAnnotation_Value() {
		'''
		   @org.eclipse.xtend.lib.macro.Active(Array<caret>)
		   class Foo {
		   }
		'''.toString.complete
		val lookupElementStrings = myFixture.lookupElementStrings
		assertTrue(lookupElementStrings.toString, lookupElementStrings.contains("ArrayList"))
	}
	
	def void testOverrideCompletion_01() {
		'''
		   class Foo {
		     overr<caret>
		   }
		'''.toString.complete
		val lookupElementStrings = myFixture.lookupElementStrings
		assertTrue(lookupElementStrings.toString, lookupElementStrings.contains("override equals(Object)"))
		assertTrue(lookupElementStrings.toString, lookupElementStrings.contains("override hashCode()"))
		assertTrue(lookupElementStrings.toString, lookupElementStrings.contains("override toString()"))
		assertTrue(lookupElementStrings.toString, lookupElementStrings.contains("override clone()"))
		assertTrue(lookupElementStrings.toString, lookupElementStrings.contains("override finalize()"))
	}
	
	def void testOverrideCompletion_02() {
		'''
		   class Foo {
		   	override toString() {
		   		'foo'
		   	}
		    overr<caret>
		   }
		'''.toString.complete
		val lookupElementStrings = myFixture.lookupElementStrings
		assertFalse(lookupElementStrings.toString, lookupElementStrings.contains("override toString()"))
	}
	
	def void testOverrideCompletion_03() {
		'''
		   class Foo {
		   	def void equals() {
		   		'foo'
		   	}
		    overr<caret>
		   }
		'''.toString.complete
		val lookupElementStrings = myFixture.lookupElementStrings
		assertTrue(lookupElementStrings.toString, lookupElementStrings.contains("override equals(Object)"))
	}
	
	def void testOverrideCompletion_04() {
		'''
			class MyClass {
				
				toString<caret>
			}
		'''.toString.complete
		myFixture.type('\n')
		assertEquals('''
			class MyClass {
			
				override toString() {
					throw new UnsupportedOperationException()
				}
			
			}
		'''.toString, myFixture.editor.document.text.toString)
		assertEquals("throw new UnsupportedOperationException()",myFixture.editor.selectionModel.selectedText)
	}
	
	def void testOverrideCompletion_05() {
		'''
			class MyClass extends MySuperClass<String> {
				
				doStuff<caret>
			}
			
			class MySuperClass<T> {
				def <X> T doStuff(java.util.List<T> myArg, X x) throws java.io.IOException {
					return null
				}
			}
		'''.toString.complete
		myFixture.type('\n')
		assertEquals('''
			import java.util.List
			import java.io.IOException
			
			class MyClass extends MySuperClass<String> {
			
				override <X> doStuff(List<String> myArg, X x) throws IOException {
					throw new UnsupportedOperationException()
				}
			
			}

			class MySuperClass<T> {
				def <X> T doStuff(java.util.List<T> myArg, X x) throws java.io.IOException {
					return null
				}
			}
		'''.toString, myFixture.editor.document.text.toString)
		assertEquals("throw new UnsupportedOperationException()",myFixture.editor.selectionModel.selectedText)
	}
	
	def void testOverrideCompletion_06() {
		'''
			class MyClass extends MySuperClass<String> {
				
				ne<caret>
			}
			
			class MySuperClass<T> {
				new (java.util.List<T> myArg) throws java.io.IOException {
				}
			}
		'''.toString.complete
		myFixture.type('\n')
		assertEquals('''
			import java.util.List
			import java.io.IOException
			
			class MyClass extends MySuperClass<String> {
			
				new (List<String> myArg) throws IOException {
					super(myArg)
				}
			
			}
			
			class MySuperClass<T> {
				new (java.util.List<T> myArg) throws java.io.IOException {
				}
			}
		'''.toString, myFixture.editor.document.text.toString)
		
		val offset = myFixture.editor.document.text.indexOf("super(myArg)") + "super(myArg)".length
		
		assertEquals(offset,myFixture.editor.caretModel.currentCaret.offset)
	}
	
	def void testOverrideCompletion_07() {
		'''
			class Foo {
				def void myMethods() {
					val runnable = new MySuperClass<String>() {
						doStuff<caret>
					}
					runnable.run()
				}
			}
			
			class MySuperClass<T> {
				def <X> T doStuff(java.util.List<T> myArg, X x) throws java.io.IOException {
					return null
				}
			}
		'''.toString.complete
		myFixture.type('\n')
		assertEquals('''
			import java.util.List
			import java.io.IOException
			
			class Foo {
				def void myMethods() {
					val runnable = new MySuperClass<String>() {
						override <X> doStuff(List<String> myArg, X x) throws IOException {
							throw new UnsupportedOperationException()
						}
			
					}
					runnable.run()
				}
			}
			
			class MySuperClass<T> {
				def <X> T doStuff(java.util.List<T> myArg, X x) throws java.io.IOException {
					return null
				}
			}
		'''.toString, myFixture.editor.document.text.toString)
		
		assertEquals("throw new UnsupportedOperationException()",myFixture.editor.selectionModel.selectedText)
	}
	
	def void testOverrideCompletion_08() {
		'''
		   class Foo {
		   	def foo() {
		   		'foo'
		    overr<caret>
		   	}
		   }
		'''.toString.complete
		val lookupElementStrings = myFixture.lookupElementStrings
		assertFalse(lookupElementStrings.toString, lookupElementStrings.contains("override toString()"))
	}
	
	def void testOverrideCompletion_09() {
		'''
		   class Foo {
		   	def foo() {
		   		'foo'
		   	}
		   }
		    overr<caret>
		'''.toString.complete
		val lookupElementStrings = myFixture.lookupElementStrings
		assertFalse(lookupElementStrings.toString, lookupElementStrings.contains("override toString()"))
	}
	
	def void testOverrideCompletion_10() {
		'''
		   class Foo {
		   	def foo(overr<caret>) {
		   		'foo'
		   	}
		   }
		    
		'''.toString.complete
		val lookupElementStrings = myFixture.lookupElementStrings
		assertFalse(lookupElementStrings.toString, lookupElementStrings.contains("override toString()"))
	}
	
	def void testOverrideCompletion_11() {
		'''
		   class Foo {
		   	def overr<caret> foo(overr<caret>) {
		   		'foo'
		   	}
		   }
		    
		'''.toString.complete
		val lookupElementStrings = myFixture.lookupElementStrings
		assertFalse(lookupElementStrings.toString, lookupElementStrings.contains("override toString()"))
	}
	
	def void testSingleLineComment() {
		'''
			// Array<caret>
			class Foo {}
		'''.toString.complete
		val lookupElementStrings = myFixture.lookupElementStrings
		assertFalse(lookupElementStrings.toString, lookupElementStrings.contains("ArrayList"))
	}
	
	def void testMultiLineComment() {
		'''
			/* Array<caret> */
			class Foo {}
		'''.toString.complete
		val lookupElementStrings = myFixture.lookupElementStrings
		assertTrue(lookupElementStrings.toString, lookupElementStrings.contains("ArrayList"))
	}
	
	def void testStringLiteral_01() {
		'''
			class Foo {
				def foo() {
					'Array<caret>'
				}
			}
		'''.toString.complete
		val lookupElementStrings = myFixture.lookupElementStrings
		assertFalse(lookupElementStrings.toString, lookupElementStrings.contains("ArrayList"))
	}
	
	def void testStringLiteral_02() {
		'''
			class Foo {
				def foo() {
					"Array<caret>"
				}
			}
		'''.toString.complete
		val lookupElementStrings = myFixture.lookupElementStrings
		assertFalse(lookupElementStrings.toString, lookupElementStrings.contains("ArrayList"))
	}
	
	def void testRichString_01() {
		'''
			class Foo {
				def foo() '«»''
					Array<caret>
				'«»''
			}
		'''.toString.complete
		val lookupElementStrings = myFixture.lookupElementStrings
		assertFalse(lookupElementStrings.toString, lookupElementStrings.contains("ArrayList"))
	}
	
	def void testRichString_02() {
		'''
			class Foo {
				def foo() '«»''
					<caret>
				'«»''
			}
		'''.toString.complete
		myFixture.type('\n')
		assertEquals('''
			class Foo {
				def foo() '«»''
					«'«'»«'»'»
				'«»''
			}
		'''.toString,myFixture.editor.document.text.toString)
	}
	
	def void testJavaTypeInExpressionContext() {
		'''
			class Foo {

				def foo() {
					<caret>
				}

				def zzz() {
				}
			}
		'''.toString.complete
		val lookupElementStrings = myFixture.lookupElementStrings.indexed
		
		val methodProposal = lookupElementStrings.findFirst[value == 'zzz']
		assertNotNull(methodProposal)
		
		val typeProposal = lookupElementStrings.findFirst[value == 'ArrayList']
		assertNotNull(typeProposal)
		
		assertTrue(methodProposal.key < typeProposal.key)
	}
	
}