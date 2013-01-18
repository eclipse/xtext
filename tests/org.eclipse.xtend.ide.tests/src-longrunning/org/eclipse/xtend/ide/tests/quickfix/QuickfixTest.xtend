package org.eclipse.xtend.ide.tests.quickfix

import com.google.inject.Inject
import static org.eclipse.xtend.core.validation.IssueCodes.*
import static org.eclipse.xtext.xbase.validation.IssueCodes.*
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.junit.After
import org.junit.Test
import org.junit.Ignore
import org.eclipse.xtext.diagnostics.Diagnostic

class QuickfixTest extends AbstractXtendUITestCase {
	
	@Inject extension QuickfixTestBuilder builder
	
	static val defaultBody = 'throw new UnsupportedOperationException("TODO: auto-generated method stub")'
	 
	@After
	override tearDown() {
		builder.tearDown
	}
	
	@Test 
	def void missingMember() {
		create('Foo.xtend', '''
			class Foo {
				def foo() {
					bar|
				}
			}
		''')
		.assertIssueCodes(FEATURECALL_LINKING_DIAGNOSTIC)
		.assertResolutionLabels("Create field 'bar'", "Create local variable 'bar'", "Create method 'bar()'", "Create method 'getBar()'")
		.assertModelAfterQuickfix("Create field 'bar'", '''
			class Foo {
				
				Object bar
				
				def foo() {
					bar
				}
			}
		''')
		.assertModelAfterQuickfix("Create local variable 'bar'", '''
			class Foo {
				def foo() {
					val bar = null
					bar
				}
			}
		''')
		.assertModelAfterQuickfix("Create method 'bar()'", '''
			class Foo {
				def foo() {
					bar
				}
				
				def bar() {
					«defaultBody»
				}
				
			}
		''')
		.assertModelAfterQuickfix("Create method 'getBar()'", '''
			class Foo {
				def foo() {
					bar
				}
				
				def getBar() {
					«defaultBody»
				}
				
			}
		''')
	}
	
	@Test 
	def void missingMethod() {
		create('Foo.xtend', '''
			class Foo {
				def foo() {
					bar|()
				}
			}
		''')
		.assertIssueCodes(FEATURECALL_LINKING_DIAGNOSTIC)
		.assertResolutionLabels("Create method 'bar()'")
		.assertModelAfterQuickfix("Create method 'bar()'", '''
			class Foo {
				def foo() {
					bar()
				}
				
				def bar() {
					«defaultBody»
				}
				
			}
		''')
	}
	
	@Test 
	def void missingMemberExplicitThis() {
		create('Foo.xtend', '''
			class Foo {
				def foo() {
					this.bar|
				}
			}
		''')
		.assertResolutionLabels("Create method 'bar()'", "Create field 'bar'", "Create method 'getBar()'")
		.assertModelAfterQuickfix("Create method 'bar()'", '''
			class Foo {
				def foo() {
					this.bar
				}
				
				def bar() {
					«defaultBody»
				}
				
			}
		''')
		.assertModelAfterQuickfix("Create field 'bar'", '''
			class Foo {
				
				Object bar
				
				def foo() {
					this.bar
				}
			}
		''')
		.assertModelAfterQuickfix("Create method 'getBar()'", '''
			class Foo {
				def foo() {
					this.bar
				}
				
				def getBar() {
					«defaultBody»
				}
				
			}
		''')
	}
	
	@Test 
	def void missingMethodExplicitThis() {
		create('Foo.xtend', '''
			class Foo {
				def foo() {
					this.bar|()
				}
			}
		''')
		.assertIssueCodes(FEATURECALL_LINKING_DIAGNOSTIC)
		.assertResolutionLabels("Create method 'bar()'")
		.assertModelAfterQuickfix("Create method 'bar()'", '''
			class Foo {
				def foo() {
					this.bar()
				}
				
				def bar() {
					«defaultBody»
				}
				
			}
		''')
	}
	
	@Test 
	def void missingMemberSameClass() {
		create('Foo.xtend', '''
			class Foo {
				def foo(Foo foo) {
					foo.bar|
				}
			}
		''')
		.assertIssueCodes(FEATURECALL_LINKING_DIAGNOSTIC)
		.assertResolutionLabels("Create method 'bar()'", "Create field 'bar'", "Create method 'getBar()'")
		.assertModelAfterQuickfix("Create method 'bar()'", '''
			class Foo {
				def foo(Foo foo) {
					foo.bar
				}
				
				def bar() {
					«defaultBody»
				}
				
			}
		''')
		.assertModelAfterQuickfix("Create field 'bar'", '''
			class Foo {
				
				Object bar
				
				def foo(Foo foo) {
					foo.bar
				}
			}
		''')
		.assertModelAfterQuickfix("Create method 'getBar()'", '''
			class Foo {
				def foo(Foo foo) {
					foo.bar
				}
				
				def getBar() {
					«defaultBody»
				}
				
			}
		''')
	}
	
	@Test 
	def void missingMemberOtherClass() {
		create('Foo.xtend', '''
			class Foo {
			}
			
			class Bar {
				def bar(Foo foo) {
					foo.foo|
				}
			}
		''')
		.assertIssueCodes(FEATURECALL_LINKING_DIAGNOSTIC)
		.assertResolutionLabels("Create method 'foo()' in 'Foo'", "Create method 'getFoo()' in 'Foo'", 
				"Create extension method 'foo(Foo)'", "Create extension method 'getFoo(Foo)'")
		.assertModelAfterQuickfix("Create method 'foo()' in 'Foo'", '''
			class Foo {
				
				def foo() {
					«defaultBody»
				}
				
			}
			
			class Bar {
				def bar(Foo foo) {
					foo.foo
				}
			}
		''')
		.assertModelAfterQuickfix("Create method 'getFoo()' in 'Foo'", '''
			class Foo {
				
				def getFoo() {
					«defaultBody»
				}
				
			}
			
			class Bar {
				def bar(Foo foo) {
					foo.foo
				}
			}
		''')
		.assertModelAfterQuickfix("Create extension method 'foo(Foo)'", '''
			class Foo {
			}
			
			class Bar {
				def bar(Foo foo) {
					foo.foo
				}
				
				def foo(Foo foo) {
					«defaultBody»
				}
				
			}
		''')
		.assertModelAfterQuickfix("Create extension method 'getFoo(Foo)'", '''
			class Foo {
			}
			
			class Bar {
				def bar(Foo foo) {
					foo.foo
				}
				
				def getFoo(Foo foo) {
					«defaultBody»
				}
				
			}
		''')
	}
	
	@Test 
	def void missingMethodSameClass() {
		create('Foo.xtend', '''
			class Foo {
				def foo(Foo foo) {
					foo.bar|()
				}
			}
		''')
		.assertIssueCodes(FEATURECALL_LINKING_DIAGNOSTIC)
		.assertResolutionLabels("Create method 'bar()'")
		.assertModelAfterQuickfix("Create method 'bar()'", '''
			class Foo {
				def foo(Foo foo) {
					foo.bar()
				}
				
				def bar() {
					«defaultBody»
				}
				
			}
		''')
	}
	
	@Test 
	def void missingMethodOtherClass() {
		create('Foo.xtend', '''
			class Foo {
			}
			
			class Bar {
				def bar(Foo foo) {
					foo.foo|()
				}
			}
		''')
		.assertIssueCodes(FEATURECALL_LINKING_DIAGNOSTIC)
		.assertResolutionLabels("Create method 'foo()' in 'Foo'", "Create extension method 'foo(Foo)'")
		.assertModelAfterQuickfix("Create method 'foo()' in 'Foo'", '''
			class Foo {
				
				def foo() {
					«defaultBody»
				}
				
			}
			
			class Bar {
				def bar(Foo foo) {
					foo.foo()
				}
			}
		''')
		.assertModelAfterQuickfix("Create extension method 'foo(Foo)'", '''
			class Foo {
			}
			
			class Bar {
				def bar(Foo foo) {
					foo.foo()
				}
				
				def foo(Foo foo) {
					«defaultBody»
				}
				
			}
		''')
	}
	
	@Test
	def void missingConstructorSameClass() {
		create('Foo.xtend', '''
			class Foo {
				def foo() {
					new Foo(1)|
				}
			}
		''')
		.assertIssueCodes(INVALID_NUMBER_OF_ARGUMENTS)
		.assertResolutionLabels("Create constructor 'new(int)'")
		.assertModelAfterQuickfix('''
			class Foo {
				
				new(int i) {
					«defaultBody»
				}
				
				def foo() {
					new Foo(1)
				}
			}
		''')
	}
	
	@Test
	def void missingConstructorOtherClass() {
		create('Foo.xtend', '''
			class Foo {
			}
			
			class Bar {
				def foo() {
					new Foo(1)|
				}
			}
		''')
		.assertIssueCodes(INVALID_NUMBER_OF_ARGUMENTS)
		.assertResolutionLabels("Create constructor 'new(int)' in 'Foo'")
		.assertModelAfterQuickfix('''
			class Foo {
				
				new(int i) {
					«defaultBody»
				}
				
			}
			
			class Bar {
				def foo() {
					new Foo(1)
				}
			}
		''')
	}
	
	@Test
	def void invalidNumberOfArguments() {
		create('Foo.xtend', '''
			class Foo {
				def foo() {
					bar|(1)
				}
				def bar() {}
			}
		''')
		.assertIssueCodes(INVALID_NUMBER_OF_ARGUMENTS)
//		.assertResolutionLabels("Make class abstract")
//		.assertModelAfterQuickfix(0, '''
//			abstract class Foo {
//				def void bar()
//			}
//		''')
	}

	@Test
	def void missingConcreteMembers() {
		create('Foo.xtend', '''
			abstract class Foo {
				def void bar()
			}
			
			class Bar| extends Foo {
			}
		''')
		.assertIssueCodes(CLASS_MUST_BE_ABSTRACT)
		.assertResolutionLabels("Add unimplemented methods", "Make class abstract")
		.assertModelAfterQuickfix("Add unimplemented methods", '''
			abstract class Foo {
				def void bar()
			}
			
			class Bar extends Foo {
			
				override bar() {
					«defaultBody»
				}
				
			}
		''')
		.assertModelAfterQuickfix("Make class abstract", '''
			abstract class Foo {
				def void bar()
			}
			
			abstract class Bar extends Foo {
			}
		''')
	}
	
	@Test
	def void missingConcreteMembers2() {
		create('Foo.xtend', '''
			class Foo| implements Comparable<Foo> {
			}
		''')
		.assertIssueCodes(CLASS_MUST_BE_ABSTRACT)
		.assertResolutionLabels("Add unimplemented methods", "Make class abstract")
		.assertModelAfterQuickfix("Add unimplemented methods", '''
			class Foo implements Comparable<Foo> {
			
				override compareTo(Foo o) {
					«defaultBody»
				}
				
			}
		''')
		.assertModelAfterQuickfix("Make class abstract", '''
			abstract class Foo implements Comparable<Foo> {
			}
		''')
	}
	
	@Test 
	def void missingOperatorSameClass() {
		create('Foo.xtend', '''
			class Foo {
			}
			
			class Bar {
				def bar(Foo foo) {
					this *| foo
				}
			}
		''')
		.assertIssueCodes(Diagnostic::LINKING_DIAGNOSTIC)
		.assertResolutionLabels("Create method 'operator_multiply(Foo)'", "Change to '+'")
		.assertModelAfterQuickfix("Create method 'operator_multiply(Foo)'", '''
			class Foo {
			}
			
			class Bar {
				def bar(Foo foo) {
					this * foo
				}
				
				def operator_multiply(Foo foo) {
					«defaultBody»
				}
				
			}
		''')
	}
	
	@Test 
	def void missingOperatorOtherClass() {
		create('Foo.xtend', '''
			class Foo {
			}
			
			class Bar {
				def bar(Foo foo) {
					foo *| this
				}
			}
		''')
		.assertIssueCodes(Diagnostic::LINKING_DIAGNOSTIC)
		.assertResolutionLabels("Create extension method 'operator_multiply(Foo, Bar)'", "Create method 'operator_multiply(Bar)' in 'Foo'", "Change to '+'")
		.assertModelAfterQuickfix("Create extension method 'operator_multiply(Foo, Bar)'", '''
			class Foo {
			}
			
			class Bar {
				def bar(Foo foo) {
					foo * this
				}
				
				def operator_multiply(Foo foo, Bar bar) {
					«defaultBody»
				}
				
			}
		''')
		.assertModelAfterQuickfix("Create method 'operator_multiply(Bar)' in 'Foo'", '''
			class Foo {
				
				def operator_multiply(Bar bar) {
					«defaultBody»
				}
				
			}
			
			class Bar {
				def bar(Foo foo) {
					this * foo
				}
			}
		''')
	}
	
	@Test
	def void inconsistentIndentation() {
		val tripleQuotes = "'''"
		create('Foo.xtend', '''
			class Foo {
				def bar() «tripleQuotes»
					tab
			        |space
				«tripleQuotes»
			}
		''')
		.assertIssueCodes(INCONSISTENT_INDENTATION)
		.assertResolutionLabels("Correct indentation")
		.assertModelAfterQuickfix('''
			class Foo {
				def bar() «tripleQuotes»
					tab
					space
				«tripleQuotes»
			}
		''')
	}
	
	@Test 
	def void missingOverride() {
		create('Foo.xtend', '''
			class Foo implements Comparable<Foo> {
				def comp|areTo(Foo o) {
					1
				}
			}
		''')
		.assertIssueCodes(MISSING_OVERRIDE)
		.assertResolutionLabels("Change 'def' to 'override'")
		.assertModelAfterQuickfix('''
			class Foo implements Comparable<Foo> {
				override compareTo(Foo o) {
					1
				}
			}
		''')
	}

	@Test 
	def void obsoleteOverride() {
		create('Foo.xtend', '''
			class Foo {
				override| bar() {
				}
			}
		''')
		.assertIssueCodes(OBSOLETE_OVERRIDE)
		.assertResolutionLabels("Change 'override' to 'def'")
		.assertModelAfterQuickfix('''
			class Foo {
				def bar() {
				}
			}
		''')
	}
	
	@Test 
	def void missingConstructorFromSuper() {
		create('Foo.xtend', '''
			class Foo {
				new(int i) {
				}
			}
			
			class Bar| extends Foo {
			}
		''')
		.assertIssueCodes(MISSING_CONSTRUCTOR)
		.assertResolutionLabels("Add constructor new(int)")
		.assertModelAfterQuickfix('''
			class Foo {
				new(int i) {
				}
			}
			
			class Bar extends Foo {

				new(int i) {
					super(i)
				}
			}
		''')
	}

	@Test
	def void missingAbstract() {
		create('Foo.xtend', '''
			class Foo {
				def void bar|()
			}
		''')
		.assertIssueCodes(MISSING_ABSTRACT)
		.assertResolutionLabels("Make class abstract")
		.assertModelAfterQuickfix('''
			abstract class Foo {
				def void bar()
			}
		''')
	}
	
	// TODO: reenable when exception validation can be switched on
	// https://bugs.eclipse.org/bugs/show_bug.cgi?id=398273))
	@Ignore@Test 
	def void unhandledCheckedException() {
		create('Foo.xtend', '''
			class Foo {
				def void bar|() {
					throw new Exception()
				}
			}
		''')
		.assertIssueCodes(UNHANDLED_EXCEPTION)
		.assertResolutionLabels("Add throws declaration", "Surround with try/catch block")
		.assertModelAfterQuickfix("Add throws declaration", '''
			class Foo {
				def void bar() throws Exception {
					throw new Exception()
				}
			}
		''')
		.assertModelAfterQuickfix("Surround with try/catch block", '''
			class Foo {
				def void bar() {
					try {
						throw new Exception()
					} catch(Exception exc) {
						throw new RuntimeException("auto-generated try/catch")
					}
				}
			}
		''')
	}
	
	@Test
	def void unusedImport() {
		create('Foo.xtend', '''
			import java.util.List|
			
			class Foo {
			}
		''')
		.assertIssueCodes(IMPORT_UNUSED)
		.assertResolutionLabels("Organize imports")
		.assertModelAfterQuickfix('''
			class Foo {
			}
		''')
	}

	@Test
	def void duplicateImport() {
		create('Foo.xtend', '''
			import java.util.List
			import java.util.List|
			
			class Foo {
				List foo
			}
		''')
		.assertIssueCodes(IMPORT_DUPLICATE)
		.assertResolutionLabels("Organize imports")
		.assertModelAfterQuickfix('''
			import java.util.List
			
			class Foo {
				List foo
			}
		''')
	}
	
	@Test
	def void wildcardImport() {
		create('Foo.xtend', '''
			import java.util.*|
			
			class Foo {
				List foo
			}
		''')
		.assertIssueCodes(IMPORT_WILDCARD_DEPRECATED)
		.assertResolutionLabels("Organize imports")
		.assertModelAfterQuickfix('''
			import java.util.List
			
			class Foo {
				List foo
			}
		''')
	}
	
}

