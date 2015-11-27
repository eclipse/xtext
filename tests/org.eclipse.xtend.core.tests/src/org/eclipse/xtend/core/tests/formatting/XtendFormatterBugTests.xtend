package org.eclipse.xtend.core.tests.formatting

import org.eclipse.xtext.formatting2.FormatterPreferenceKeys
import org.junit.Ignore
import org.junit.Test

class XtendFormatterBugTests extends AbstractXtendFormatterTest {

	@Test
	def testBug398718(){
		assertFormatted('''
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
		'''.decode, '''
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
		assertFormatted('''
			class Foo {
				def bar() {
					new Baz[]
				}
			}
		''')
	}
	
	@Test
	def testBug398625(){
		assertFormatted('''
			package foo
			
			class bar {
				def modify(List<? extends MutableMethodDeclaration> annotatedMethods,
					ModifyContext context) {
			
					setExceptions("42", [])
				}
			}
		''')	
	}
	@Test
	def testBug398625_2(){
		assertFormatted('''
			package foo
			
			class bar {
				def modify(List<? extends MutableMethodDeclaration> annotatedMethods,
					ModifyContext context) {
			
					setExceptions("42")[]
				}
			}
		''')	
	}
	
	@Test
	def testBug398625_3(){
		assertFormatted('''
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
		''')	
	}

	@Test
	def testBug400030(){
		assertFormatted('''
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
		assertFormatted('''
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
		assertFormatted('''
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
		assertFormatted('''
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
	def testBug455582() {
		assertFormatted('''
		abstract package class XtendTest {
			static final def void foo() {
			}
		}
		''', '''  abstract  package  class  XtendTest  {  static  final  def  void  foo  (  )  {  }  }''')
	}
	
	@Test def bug462628() {
		tester.assertFormatted [
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
	
	@Test def testBug482665() {
		assertFormatted('''
			class Foo {
				def void someMethod() {
				}
			}
		''','''
			class Foo { 
				def void someMethod() {
				}
		}''')
	}
}