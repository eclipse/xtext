package org.eclipse.xtend.ide.tests.quickfix

import com.google.inject.Inject
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtext.diagnostics.Diagnostic
import org.eclipse.xtext.xbase.validation.IssueCodes
import org.junit.After
import org.junit.Test

import static org.eclipse.xtend.core.validation.IssueCodes.*
import static org.eclipse.xtext.xbase.validation.IssueCodes.*

class QuickfixTest extends AbstractXtendUITestCase {
	
	@Inject extension QuickfixTestBuilder builder
	
	static val defaultBody = 'throw new UnsupportedOperationException("TODO: auto-generated method stub")'
	 
	@After
	override tearDown() {
		builder.tearDown
	}

	@Test 
	def void fixPackageName_0() {
		create('test/Foo.xtend', '''
			|class Foo {
			}
		''')
		.assertIssueCodes(WRONG_PACKAGE)
		.assertResolutionLabels("Change package declaration to 'test'")
		.assertModelAfterQuickfix('''
			package test class Foo {
			}
		''')
	}
		
	@Test 
	def void fixPackageName_1() {
		create('test/Foo.xtend', '''
			package bar|
			
			class Foo {
			}
		''')
		.assertIssueCodes(WRONG_PACKAGE)
		.assertResolutionLabels("Change package declaration to 'test'")
		.assertModelAfterQuickfix('''
			package test
			
			class Foo {
			}
		''')
	}
		
	@Test 
	def void fixPackageName_2() {
		create('Foo.xtend', '''
			package bar|
			
			class Foo {
			}
		''')
		.assertIssueCodes(WRONG_PACKAGE)
		.assertResolutionLabels("Change package declaration to ''")
		.assertModelAfterQuickfix('''
			class Foo {
			}
		''')
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
	def void missingMethodInAbstractClass() {
		create('Foo.xtend', '''
			abstract class Foo {
				def String foo() {
					bar|()
				}
			}
		''')
		.assertIssueCodes(FEATURECALL_LINKING_DIAGNOSTIC)
		.assertResolutionLabels("Create method 'bar()'")
		.assertModelAfterQuickfix("Create method 'bar()'", '''
			abstract class Foo {
				def String foo() {
					bar()
				}
				
				def String bar()
				
			}
		''')
	}
	
	@Test 
	def void missingMethodInInterface() {
		create('Foo.xtend', '''
			class Foo {
				def foo(Bar bar) {
					bar.bar|()
				}
			}
			
			interface Bar {
			}
		''')
		.assertIssueCodes(FEATURECALL_LINKING_DIAGNOSTIC)
		.assertResolutionLabelsSubset("Create method 'bar()' in 'Bar'")
		.assertModelAfterQuickfix("Create method 'bar()' in 'Bar'", '''
			class Foo {
				def foo(Bar bar) {
					bar.bar()
				}
			}
			
			interface Bar {
				
				def void bar()
				
			}
		''')
	}
	
	@Test
	def void missingMemberWithAssigmentExplicitThis() {
		create('Foo.xtend', '''
			class Foo {
				def foo() {
					this.bar| = 0L
				}
			}
		''')
		.assertResolutionLabels("Create method 'setBar(long)'", "Create field 'bar'")
		.assertModelAfterQuickfix("Create method 'setBar(long)'", '''
			class Foo {
				def foo() {
					this.bar = 0L
				}
				
				def setBar(long l) {
					«defaultBody»
				}
				
			}
		''')
		.assertModelAfterQuickfix("Create field 'bar'", '''
			class Foo {
				
				long bar
				
				def foo() {
					this.bar = 0L
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
			class Foo {}
			
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
			class Foo {}
			
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
			class Foo {}
			
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
	def void missingStaticMemberOtherClass() {
		create('Foo.xtend', '''
			class Foo {}
			
			class Bar {
				def bar() {
					Foo.foo|
				}
			}
		''')
		.assertIssueCodes(FEATURECALL_LINKING_DIAGNOSTIC)
		.assertResolutionLabels("Create static method 'foo()' in 'Foo'", "Create static method 'getFoo()' in 'Foo'")
		.assertModelAfterQuickfix("Create static method 'foo()' in 'Foo'", '''
			class Foo {
				
				def static foo() {
					«defaultBody»
				}
				
				}
			
			class Bar {
				def bar() {
					Foo.foo
				}
			}
		''')
		.assertModelAfterQuickfix("Create static method 'getFoo()' in 'Foo'", '''
			class Foo {
				
				def static getFoo() {
					«defaultBody»
				}
				
				}
			
			class Bar {
				def bar() {
					Foo.foo
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
	def void missingStaticMethodOtherClass() {
		create('Foo.xtend', '''
			class Foo {
			}
			
			class Bar {
				def bar() {
					Foo.foo|()
				}
			}
		''')
		.assertIssueCodes(FEATURECALL_LINKING_DIAGNOSTIC)
		.assertResolutionLabels("Create static method 'foo()' in 'Foo'")
		.assertModelAfterQuickfix('''
			class Foo {
				
				def static foo() {
					«defaultBody»
				}
				
			}
			
			class Bar {
				def bar() {
					Foo.foo()
				}
			}
		''')
	}
	
	@Test 
	def void missingMemberStaticOperationContext() {
		create('Foo.xtend', '''
			class Foo {
				def static foo() {
					bar|
				}
			}
		''')
		.assertIssueCodes(FEATURECALL_LINKING_DIAGNOSTIC)
		.assertResolutionLabels("Create local variable 'bar'", "Create static method 'bar()'", "Create static method 'getBar()'", "Create static field 'bar'")
		.assertModelAfterQuickfix("Create static method 'getBar()'", '''
			class Foo {
				def static foo() {
					bar
				}
				
				def static getBar() {
					«defaultBody»
				}
				
			}
		''')
		.assertModelAfterQuickfix("Create static method 'bar()'", '''
			class Foo {
				def static foo() {
					bar
				}
				
				def static bar() {
					«defaultBody»
				}
				
			}
		''')
		.assertModelAfterQuickfix("Create static field 'bar'", '''
			class Foo {
				
				static Object bar
				
				def static foo() {
					bar
				}
			}
		''')
	}
	
	@Test 
	def void missingMemberStaticFieldContext() {
		create('Foo.xtend', '''
			class Foo {
				static Object foo = bar|
			}
		''')
		.assertIssueCodes(FEATURECALL_LINKING_DIAGNOSTIC)
		.assertResolutionLabels("Create static method 'bar()'", "Create static method 'getBar()'", "Create static field 'bar'")
		.assertModelAfterQuickfix("Create static method 'getBar()'", '''
			class Foo {
				static Object foo = bar
				
				def static getBar() {
					«defaultBody»
				}
				
			}
		''')
		.assertModelAfterQuickfix("Create static method 'bar()'", '''
			class Foo {
				static Object foo = bar
				
				def static bar() {
					«defaultBody»
				}
				
			}
		''')
		.assertModelAfterQuickfix("Create static field 'bar'", '''
			class Foo {
				static Object foo = bar
				
				static Object bar
				
			}
		''')
	}
	
	@Test 
	def void missingMemberFieldContext() {
		create('Foo.xtend', '''
			class Foo {
				Object foo = bar|
			}
		''')
		.assertIssueCodes(FEATURECALL_LINKING_DIAGNOSTIC)
		.assertResolutionLabels("Create method 'bar()'", "Create method 'getBar()'", "Create field 'bar'")
		.assertModelAfterQuickfix("Create method 'getBar()'", '''
			class Foo {
				Object foo = bar
				
				def getBar() {
					«defaultBody»
				}
				
			}
		''')
		.assertModelAfterQuickfix("Create method 'bar()'", '''
			class Foo {
				Object foo = bar
				
				def bar() {
					«defaultBody»
				}
				
			}
		''')
		.assertModelAfterQuickfix("Create field 'bar'", '''
			class Foo {
				Object foo = bar
				
				Object bar
				
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
	def void missingConstructorSameClass_1() {
		create('Foo.xtend', '''
			class Foo {
				new() {
					this|(1)
				}
			}
		''')
		.assertIssueCodes(INVALID_NUMBER_OF_ARGUMENTS, CIRCULAR_CONSTRUCTOR_INVOCATION)
		.assertResolutionLabels("Create constructor 'new(int)'")
		.assertModelAfterQuickfix('''
			class Foo {
				new() {
					this(1)
				}
				
				new(int i) {
					«defaultBody»
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
	def void missingConstructorCallParentheses() {
		create('Foo.xtend', '''
			class Foo {
				def foo() {}
			}
			
			class Bar {
				def bar() {
					new Foo.foo|
				}
			}
		''')
		.assertIssueCodes(Diagnostic.LINKING_DIAGNOSTIC)
		.assertResolutionLabels("Change to constructor call 'new Foo()'")
		.assertModelAfterQuickfix('''
			class Foo {
				def foo() {}
			}
			
			class Bar {
				def bar() {
					new Foo().foo
				}
			}
		''')
	}
	
	@Test
	def void missingConstructorCallParentheses_1() {
		create('Foo.xtend', '''
			class Foo {
				def foo() {
					new ArrayList.size|
				}
			}
		''')
		.assertIssueCodes(Diagnostic.LINKING_DIAGNOSTIC)
		.assertResolutionLabelsSubset("Change to constructor call 'new ArrayList()' (java.util)")
		.assertModelAfterQuickfix("Change to constructor call 'new ArrayList()' (java.util)", '''
			import java.util.ArrayList
			
			class Foo {
				def foo() {
					new ArrayList().size
				}
			}
		''')
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
		.assertIssueCodes(Diagnostic.LINKING_DIAGNOSTIC)
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
		.assertIssueCodes(Diagnostic.LINKING_DIAGNOSTIC)
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
					foo * this
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
	
	@Test 
	def void unhandledCheckedException() {
		setSeverity(IssueCodes.UNHANDLED_EXCEPTION, "error")
		create('Foo.xtend', '''
			class Foo {
				def void bar() {
					throw new Exception|()
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
					} catch (Exception exc) {
						throw new RuntimeException("auto-generated try/catch", exc)
					}
				}
			}
		''')
	}
	
	@Test 
	def void unhandledCheckedExceptions() {
		setSeverity(IssueCodes.UNHANDLED_EXCEPTION, "warning")
		create('Foo.xtend', '''
			class Foo {
				def void bar() {
					m|
				}
				def void m() throws java.io.IOException, java.net.URISyntaxException {}
			}
		''')
		.assertIssueCodes(UNHANDLED_EXCEPTION)
		.assertResolutionLabels("Add throws declaration", "Surround with try/catch block")
		.assertModelAfterQuickfix("Add throws declaration", '''
			import java.io.IOException
			import java.net.URISyntaxException
			
			class Foo {
				def void bar() throws IOException, URISyntaxException {
					m
				}
				def void m() throws java.io.IOException, java.net.URISyntaxException {}
			}
		''')
		.assertModelAfterQuickfix("Surround with try/catch block", '''
			import java.io.IOException
			import java.net.URISyntaxException
			
			class Foo {
				def void bar() {
					try {
						m
					} catch (IOException exc) {
						throw new RuntimeException("auto-generated try/catch", exc)
					} catch (URISyntaxException exc) {
						throw new RuntimeException("auto-generated try/catch", exc)
					}
				}
				def void m() throws java.io.IOException, java.net.URISyntaxException {}
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
	
	@Test
	def void missingClass() {
		create('Foo.xtend', '''
			class Foo {
				Bar| bar
			}
		''')
		.assertIssueCodes(Diagnostic.LINKING_DIAGNOSTIC)
		.assertResolutionLabelsSubset("Create Xtend class 'Bar'", "Create Java class 'Bar'", "Create Java interface 'Bar'", 
				"Create local Xtend class 'Bar'", "Create local Xtend interface 'Bar'")
		.assertModelAfterQuickfix("Create local Xtend class 'Bar'", '''
			class Foo {
				Bar bar
			}
			
			class Bar {
			}
		''')
		.assertModelAfterQuickfix("Create local Xtend interface 'Bar'", '''
			class Foo {
				Bar bar
			}
			
			interface Bar {
			}
		''')
	}
	
	@Test
	def void missingClassOtherPackage() {
		create('Foo.xtend', '''
			class Foo {
				bar.Bar| bar
			}
		''')
		.assertIssueCodes(Diagnostic.LINKING_DIAGNOSTIC)
		.assertResolutionLabelsSubset("Create Xtend class 'Bar' in package 'bar'", "Create Java class 'Bar' in package 'bar'", "Create Java interface 'Bar' in package 'bar'")
	}
	
	@Test
	def void missingClassAndConstructor() {
		create('Foo.xtend', '''
			class Foo {
				def foo() {
					new Bar|
				}
			}
		''')
		.assertIssueCodes(Diagnostic.LINKING_DIAGNOSTIC)
		.assertResolutionLabelsSubset("Create Xtend class 'Bar'", "Create Java class 'Bar'", "Create local Xtend class 'Bar'")
		.assertModelAfterQuickfix("Create local Xtend class 'Bar'", '''
			class Foo {
				def foo() {
					new Bar
				}
			}
			
			class Bar {
			}
		''')
	}

	@Test
	def void missingClassAndConstructorOtherPackage() {
		create('Foo.xtend', '''
			class Foo {
				def foo() {
					new bar.Bar|
				}
			}
		''')
		.assertIssueCodes(Diagnostic.LINKING_DIAGNOSTIC)
		.assertResolutionLabelsSubset("Create Xtend class 'Bar' in package 'bar'", "Create Java class 'Bar' in package 'bar'")
	}

	@Test
	def void missingSuperClass() {
		create('Foo.xtend', '''
			class Foo extends Bar| {
			}
		''')
		.assertIssueCodes(Diagnostic.LINKING_DIAGNOSTIC, CLASS_EXPECTED)
		.assertResolutionLabelsSubset("Create Xtend class 'Bar'", "Create Java class 'Bar'", "Create local Xtend class 'Bar'")
		.assertNoResolutionLabels("Create Java interface 'Bar'", "Create Xtend interface 'Bar'", "Create local Xtend interface 'Bar'")
	}

	@Test
	def void missingImplementedInterface() {
		create('Foo.xtend', '''
			class Foo implements Bar| {
			}
		''')
		.assertIssueCodes(Diagnostic.LINKING_DIAGNOSTIC, INTERFACE_EXPECTED)
		.assertResolutionLabelsSubset("Create Java interface 'Bar'", "Create Xtend interface 'Bar'", "Create local Xtend interface 'Bar'")
		.assertNoResolutionLabels("Create Xtend class 'Bar'", "Create Java class 'Bar'", "Create local Xtend class 'Bar'")
	}

	@Test
	def void missingSuperInterface() {
		create('Foo.xtend', '''
			interface Foo extends Bar| {
			}
		''')
		.assertIssueCodes(Diagnostic.LINKING_DIAGNOSTIC, INTERFACE_EXPECTED)
		.assertResolutionLabelsSubset("Create Java interface 'Bar'", "Create Xtend interface 'Bar'", "Create local Xtend interface 'Bar'")
		.assertNoResolutionLabels("Create Java class 'Bar'", "Create Xtend class 'Bar'", "Create local Xtend class 'Bar'")
		.assertModelAfterQuickfix("Create local Xtend interface 'Bar'", '''
			interface Foo extends Bar {
			}
			
			interface Bar {
			}
		''')
	}

	@Test
	def void missingTypeAsAnnotationValue() {
		create('Foo.xtend', '''
			import org.eclipse.xtend.lib.macro.Active

			@Active(typeof(Bar|)) 
				annotation Foo {
			}
		''')
		.assertIssueCodes(Diagnostic.LINKING_DIAGNOSTIC)
		.assertResolutionLabelsSubset("Create Java interface 'Bar'", "Create Xtend interface 'Bar'", "Create local Xtend interface 'Bar'", 
			"Create Java class 'Bar'", "Create Xtend class 'Bar'", "Create local Xtend class 'Bar'")
		.assertModelAfterQuickfix("Create local Xtend interface 'Bar'", '''
			import org.eclipse.xtend.lib.macro.Active

			@Active(typeof(Bar)) 
				annotation Foo {
			}
			
			interface Bar {
			}
		''')
		.assertModelAfterQuickfix("Create local Xtend class 'Bar'", '''
			import org.eclipse.xtend.lib.macro.Active

			@Active(typeof(Bar)) 
				annotation Foo {
			}
			
			class Bar {
			}
		''')
	}

	@Test
	def void missingTypeStaticAccess() {
		create('Foo.xtend', '''
			class Foo {
				def foo() {
					Collections|.sort
				}
			}
		''')
		.assertIssueCodes(Diagnostic.LINKING_DIAGNOSTIC)
		.assertResolutionLabelsSubset("Import 'Collections' (java.util)")
		.assertModelAfterQuickfix('''
			import java.util.Collections
			
			class Foo {
				def foo() {
					Collections.sort
				}
			}
		''')	
	}

	@Test
	def void missingTypeInstanceAccess() {
		create('Foo.xtend', '''
			class Foo {
				def foo() {
					Collections|.sort
				}
			}
		''')
		.assertIssueCodes(FEATURECALL_LINKING_DIAGNOSTIC)
		.assertResolutionLabelsSubset("Import 'Collections' (java.util)")
		.assertModelAfterQuickfix('''
			import java.util.Collections
			
			class Foo {
				def foo() {
					Collections.sort
				}
			}
		''')	
	}

	@Test
	def void missingTypeLiteralAccess() {
		create('Foo.xtend', '''
			class Foo {
				def foo() {
					Collections|.newInstance
				}
			}
		''')
		.assertIssueCodes(FEATURECALL_LINKING_DIAGNOSTIC)
		.assertResolutionLabelsSubset("Import 'Collections' (java.util)")
		.assertModelAfterQuickfix('''
			import java.util.Collections
			
			class Foo {
				def foo() {
					Collections.newInstance
				}
			}
		''')	
	}
	
	@Test
	def void missingAnnotationImport() {
		create('Foo.xtend', '''
			@QuickFixMe|
			class Foo {}
		''')
		.assertIssueCodes(Diagnostic.LINKING_DIAGNOSTIC)
		.assertResolutionLabelsSubset("Import 'QuickFixMe' (org.eclipse.xtend.ide.tests.data.quickfix)")
		.assertModelAfterQuickfix('''
			import org.eclipse.xtend.ide.tests.data.quickfix.QuickFixMe
			
			@QuickFixMe
			class Foo {}
		''')
	}
	
	
	@Test
	def void missingAnnotation() {
		create('Foo.xtend', '''
			@Bar|
			class Foo {
			}
		''')
		.assertIssueCodes(Diagnostic.LINKING_DIAGNOSTIC)
		.assertResolutionLabelsSubset("Create local Xtend annotation '@Bar'", "Create Java annotation '@Bar'")
		.assertModelAfterQuickfix("Create local Xtend annotation '@Bar'", '''
			@Bar
			class Foo {
			}
			
			annotation Bar {
			}
		''')
	}
	
	@Test 
	def void useObjectForUnknownParams() {
		create('Foo.xtend', '''
			class Foo {
				def foo(int x) {
					bar|(x,y)
				}
			}
		''')
		.assertIssueCodes(FEATURECALL_LINKING_DIAGNOSTIC)
		.assertResolutionLabelsSubset("Create method 'bar(int, Object)'")
		.assertModelAfterQuickfix('''
			class Foo {
				def foo(int x) {
					bar(x,y)
				}
				
				def bar(int i, Object object) {
					«defaultBody»
				}
				
			}
		''')
	}
	
	@Test
	// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=378817
	def void overrideSuperMethodWithComplicatedSignature() {
		create('Foo.xtend', '''
			import java.util.List
			
			abstract class A {
				def <T extends Object> T test(List<T> t, (Object)=>String a)
			}
			
			class B| extends A {
			}
		''')
		.assertIssueCodes(CLASS_MUST_BE_ABSTRACT)
		.assertResolutionLabels('Add unimplemented methods', 'Make class abstract')
		.assertModelAfterQuickfix('Add unimplemented methods','''
			import java.util.List
			
			abstract class A {
				def <T extends Object> T test(List<T> t, (Object)=>String a)
			}
			
			class B extends A {
				
				override <T> test(List<T> t, (Object)=>String a) {
					«defaultBody»
				}
				
			}
		''')
	}

}

