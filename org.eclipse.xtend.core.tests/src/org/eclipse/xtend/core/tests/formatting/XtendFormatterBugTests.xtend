/*******************************************************************************
 * Copyright (c) 2013, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.formatting

import org.eclipse.xtend.core.formatting2.XtendFormatterPreferenceKeys
import org.eclipse.xtext.formatting2.FormatterPreferenceKeys
import org.junit.Ignore
import org.junit.Test

class XtendFormatterBugTests extends AbstractXtendFormatterTest {
	
	@Test
	def testCoreIssue527_01() {
		assertUnformattedEqualsFormatted('''
		class test {
			val static SUPER_LONG_LIST_TO_TEST_IF_FORMATTING_WORKS_HERE_AND_SUCH = #[]
		
			def fn() {
				return SUPER_LONG_LIST_TO_TEST_IF_FORMATTING_WORKS_HERE_AND_SUCH.map [ l |
					SUPER_LONG_LIST_TO_TEST_IF_FORMATTING_WORKS_HERE_AND_SUCH
				]
			}
		}
		''')
	}
	@Test
	def testtestCoreIssue527_02() {
		formatterTestHelper.assertFormatted [
			preferences[
				put(FormatterPreferenceKeys.maxLineWidth, 80)
			]
			toBeFormatted = '''
				class ModuleDeclaration {
					public List<Object> moduleComponents
				}
				
				class AbstractTypeDeclaration {
				}
				
				class AliasDeclaration extends AbstractTypeDeclaration {
				}
				
				class JavaGenerator {
					def void generateCommon(String projectSourceRootPath,
						ModuleDeclaration module) {
						for (element : module.moduleComponents.filter(AbstractTypeDeclaration).
							filter [ e |
								!(e instanceof AliasDeclaration)
							]) {
						}
				
					}
				}
			'''
		]
	}

	@Test
	def testBug402917_01() {
		assertUnformattedEqualsFormatted(
			'''
			package foo
			
			class Dully {
			
				@Deprecated extension IntegerExtensions y
				@Deprecated extension IntegerExtensions x
			
				def all(@Deprecated extension IntegerExtensions x) {
					val extension IntegerExtensions foo = null
					val c = [ extension IntegerExtensions p |
						123.bitwiseAnd(1)
					]
				}
			}
			'''
		)
	}

	@Test
	def testBug402917_02() {
		'''
			package foo
			
			class Dully {
			
				@Deprecated 
				extension 
				IntegerExtensions y
				@Deprecated   extension    IntegerExtensions x
			
				def all(@Deprecated   extension    IntegerExtensions x) {
					val extension    IntegerExtensions foo = null
					val c = [ extension    IntegerExtensions p |
						123.bitwiseAnd(1)
					]
				}
				def all2(   extension  @Deprecated  IntegerExtensions x) {
				}	
			}
		'''.assertFormattedTo('''
			package foo
			
			class Dully {
			
				@Deprecated
				extension IntegerExtensions y
				@Deprecated extension IntegerExtensions x
			
				def all(@Deprecated extension IntegerExtensions x) {
					val extension IntegerExtensions foo = null
					val c = [ extension IntegerExtensions p |
						123.bitwiseAnd(1)
					]
				}
			
				def all2(extension @Deprecated IntegerExtensions x) {
				}
			}
		''')
	}

	@Test
	def testBug398718(){
		'''
			package foo
			class bar {
				def testVisibilityOfDispatchMethods() {
					```
					package foo;

					import java.util.Arrays;

					@SuppressWarnings("all")
					public class NoSuchElementException {

					  }
					}
					```

					}
			}
		'''.decode.assertFormattedTo('''
			package foo

			class bar {
				def testVisibilityOfDispatchMethods() {
					```
						package foo;
						
						import java.util.Arrays;
						
						@SuppressWarnings("all")
						public class NoSuchElementException {
						
						  }
						}
					```

				}
			}
		'''.decode)
	}

	@Test
	def testBug434976(){
		assertUnformattedEqualsFormatted('''
			class Foo {
				def bar() {
					new Baz[]
				}
			}
		''')
	}
	
	@Test
	def testBug398625(){
		assertUnformattedEqualsFormatted('''
			package foo
			
			class bar {
				def modify(List<? extends MutableMethodDeclaration> annotatedMethods,
					ModifyContext context) {
			
					setExceptions("42", [])
				}
			}
		''', [put(FormatterPreferenceKeys.maxLineWidth, 80)])	
	}
	@Test
	def testBug398625_2(){
		assertUnformattedEqualsFormatted('''
			package foo
			
			class bar {
				def modify(List<? extends MutableMethodDeclaration> annotatedMethods,
					ModifyContext context) {
			
					setExceptions("42")[]
				}
			}
		''', [put(FormatterPreferenceKeys.maxLineWidth, 80)])	
	}
	
	@Test
	def testBug398625_3(){
		assertUnformattedEqualsFormatted('''
			package foo

			class bar {
				def modify(List<? extends MutableMethodDeclaration> annotatedMethods,
					ModifyContext context) {
					ctx = context
					annotatedMethods.forEach [
						val type = addTypeParameter('A')
						addParameter('myParam',
							compilationUnit.typeReferenceProvider.newTypeReference(type))
						setExceptions(
							newArrayList(
								compilationUnit.typeReferenceProvider.newTypeReference(
									'java.lang.Exception')))[]
					]
				}
			}
		''', [put(FormatterPreferenceKeys.maxLineWidth, 80)])	
	}

	@Test
	def testBug400030(){
		assertUnformattedEqualsFormatted('''
		class Foo {

			/** foo */
			val bar = 3
		}
		''')
	}

	@Test
	def testBug400025(){
		assertFormattedExpression('''
		{
			// foo
		}
		''')
	}

	@Test
	def testBug400025_11(){
		assertFormattedExpression('''
		{ // foo
		}
		''')
	}

	@Test
	def testBug400025_1(){
		assertFormattedExpression('''
		{
			/*
			 * foo
			 */
		}
		''')
	}

	@Test
	def testBug400025_2(){
		assertUnformattedEqualsFormatted('''
		class bar {
			// foo
		}
		''')
	}
	
	@Ignore("Conflict")
	@Test
	def testBug400025_3(){
		assertFormattedExpression('''
		{
			val foo = 42
			// foo
		}
		val bar = 42
		''')
	}


	@Test
	def testBug400024(){
		assertUnformattedEqualsFormatted('''
		class Foo {

			def bar() {
				typeof(XtextAntlrGeneratorFragment).getInstance => [
		// 			options = new AntlrOptions => [
		// 				backtrack = true
		// 			]
				]
			}
		}
		''')
	}

	@Test
	def testBug400024_1(){
		assertUnformattedEqualsFormatted('''
		class Foo {

			def bar() {
				typeof(XtextAntlrGeneratorFragment).getInstance => [
					/*
					 * Foo.
					 */
				]
			}
		}
		''')
	}
	
	@Test
	def testBug_xtext_xtend_194(){
		assertUnformattedEqualsFormatted('''
			class Foo {
			
				static val SOME_MULTI_LINE_THINGY = new StringBuilder('a').append('b').
					append('c').append('d').append('e').append('f').append('g').append('h').
					append('i').append('j').append('k').append('l').append('m').toString;
			
				var bar = new Object
			
			}
		''', [put(FormatterPreferenceKeys.maxLineWidth, 80)])
	}
	
	@Test
	def testBug455582() {
		'''
			  abstract  package  class  XtendTest  {  static  final  def  void  foo  (  )  {  }  }
		'''.assertFormattedTo('''
			abstract package class XtendTest {
				static final def void foo() {
				}
			}
		''', [put(XtendFormatterPreferenceKeys.keepOneLineMethods, false)])
	}
	
	@Test def bug462628() {
		formatterTestHelper.assertFormatted [
			preferences[
				put(FormatterPreferenceKeys.maxLineWidth, 120)
			]
			toBeFormatted = '''
				class Foo {
					def void format() {
						mmmmmmmmmmmmmmmcontainsBlockExprmmmmmmmexprcasesemptymmmmexprmmdefaultmmmmmmmm &&
							mexprmcasesmexists[multiline] && mexprmmdefaultmmultilineOrInNewLine
					}
				}
			'''
		]
	}
	
	@Test def bug403823() {
		formatterTestHelper.assertFormatted [
			preferences[
				put(FormatterPreferenceKeys.maxLineWidth, 120)
			]
			toBeFormatted = '''
				class Foo {
					def void format(String a, String b, String c) {
						if (a != b)
							«"'"»«"'"»«"'"»(«"\u00AB"»c«"\u00BB"»)«"'"»«"'"»«"'"»
						else
							''
					}
				}
			'''
		]
	}
	
	@Test def bug403823_1() {
		formatterTestHelper.assertFormatted [
			preferences[
				put(FormatterPreferenceKeys.maxLineWidth, 120)
			]
			toBeFormatted = '''
				class Foo {
					def void format(String a, String b, String c) {
						if (a != b) «"'"»«"'"»«"'"»(«"\u00AB"»c«"\u00BB"»)«"'"»«"'"»«"'"» else ''
					}
				}
			'''
		]
	}
	
	@Test def bug403340() {
		formatterTestHelper.assertFormatted [
			preferences[
				put(FormatterPreferenceKeys.maxLineWidth, 120)
			]
			toBeFormatted = '''
				class Foo {
					def void format(String v1, String v2) {
						if (v1 === v2)
							«"'"»«"'"»«"'"»Same«"'"»«"'"»«"'"»
						else
							«"'"»«"'"»«"'"»Not the Same«"'"»«"'"»«"'"»
					}
				}
			'''
		]
	}
	
	@Test def bug403340_1() {
		formatterTestHelper.assertFormatted [
			preferences[
				put(FormatterPreferenceKeys.maxLineWidth, 120)
			]
			toBeFormatted = '''
				class Foo {
					def void format(String v1, String v2) {
						if (v1 === v2) «"'"»«"'"»«"'"»Same«"'"»«"'"»«"'"» else «"'"»«"'"»«"'"»Not the Same«"'"»«"'"»«"'"»
					}
				}
			'''
		]
	}
}