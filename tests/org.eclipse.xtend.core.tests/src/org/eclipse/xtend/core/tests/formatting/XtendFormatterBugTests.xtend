package org.eclipse.xtend.core.tests.formatting

import org.junit.Test
import org.junit.Ignore

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
					annotatedMethods.forEach[val type = addTypeParameter('A')
						addParameter('myParam',
							compilationUnit.typeReferenceProvider.newTypeReference(type))
						setExceptions(
							newArrayList(
								compilationUnit.typeReferenceProvider.
									newTypeReference('java.lang.Exception')))[]]
			
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
	@Ignore
	@Test
	def testBug400025(){
		assertFormattedExpression('''
		{
			// foo
		}
		''')
	}
	@Ignore
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
	@Ignore
	@Test
	def testBug400025_2(){
		assertFormattedExpression('''
		{
			// foo
			val foo = 42
		}
		''')
	}
	@Ignore
	@Test
	def testBug400024(){
		assertFormatted('''
		class Foo {

			def bar() {
				typeof(XtextAntlrGeneratorFragment).getInstance => [
					// options = new AntlrOptions => [
					//  backtrack = true
					// ]
				]
			}
		}
		''')
	}
	@Ignore
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


}