package org.eclipse.xtend.ide.tests.quickfix

import com.google.inject.Inject
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.diagnostics.Diagnostic
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil
import org.eclipse.xtext.xbase.compiler.JavaVersion
import org.eclipse.xtext.xbase.validation.IssueCodes
import org.junit.After
import org.junit.Ignore
import org.junit.Test

import static org.eclipse.xtend.core.validation.IssueCodes.*
import static org.eclipse.xtext.xbase.validation.IssueCodes.*

class QuickfixTest extends AbstractXtendUITestCase {
	
	@Inject extension QuickfixTestBuilder builder
	
	@Inject extension WorkbenchTestHelper

	@Inject extension SyncUtil

	static val defaultBody = 'throw new UnsupportedOperationException("TODO: auto-generated method stub")'
	
	@After
	override tearDown() {
		builder.tearDown
	}

	@Test
	def void testBug456803(){
		createFile("bar/Foo.xtend",'''
			package bar
			class Outer {
				static class Inner{}
			}
		''')
		waitForBuild(new NullProgressMonitor)
		create("bar/Bar.xtend",'''
			package bar
			class X {
			  var Inner| inner
			}
		''').assertResolutionLabelsSubset("Import 'Inner' (bar.Outer)")
			.assertModelAfterQuickfix("Import 'Inner' (bar.Outer)",'''
			package bar

			import bar.Outer.Inner

			class X {
			  var Inner inner
			}
			''')


	}

	@Test
	def void obsoletCast() {
		setSeverity(IssueCodes.OBSOLETE_CAST, "warning")
		create('Foo.xtend', '''
			class Foo {
				String s = "" as String|
			}
		''').assertIssueCodes(OBSOLETE_CAST).assertResolutionLabels("Remove unnecessary cast").
			assertModelAfterQuickfix('''
				class Foo {
					String s = ""
				}
			''')
	}

	@Test
	def void obsoletCast_01() {
		setSeverity(IssueCodes.OBSOLETE_CAST, "warning")
		create('Foo.xtend', '''
			class Foo {
				String s = /*comment*/"" /*comment*/ as /*comment*/ String|
			}
		''').assertIssueCodes(OBSOLETE_CAST).assertResolutionLabels("Remove unnecessary cast").
			assertModelAfterQuickfix('''
				class Foo {
					String s = /*comment*/""
				}
			''')
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
			package test
			
			class Foo {
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
	def void fixPackageName_3() {
		create('test/Foo.xtend', '''
			|import static C.D.*
			class Foo {
				def void m() {
					staticM
				}
			}
			class C {
				static class D {
					static def void staticM() {}
				}
			}
		''')
		.assertIssueCodes(WRONG_PACKAGE)
		.assertResolutionLabels("Change package declaration to 'test'")
		// TODO formatting is wrong but this is currently expected
		.assertModelAfterQuickfix('''
			package test
			
			import static test.C.D.*
			class Foo {
				def void m() {
					staticM
				}
			}
			class C {
				static class D {
					static def void staticM() {}
				}
			}
		''')
	}
		
	@Test 
	def void fixPackageName_4() {
		create('test/Foo.xtend', '''
			package bar|
			
			import static bar.C.D.*
			
			class Foo {
				def void m() {
					staticM
				}
			}
			class C {
				static class D {
					static def void staticM() {}
				}
			}
		''')
		.assertIssueCodes(WRONG_PACKAGE)
		.assertResolutionLabels("Change package declaration to 'test'")
		.assertModelAfterQuickfix('''
			package test
			
			import static test.C.D.*
			
			class Foo {
				def void m() {
					staticM
				}
			}
			class C {
				static class D {
					static def void staticM() {}
				}
			}
		''')
	}
		
	@Test 
	def void fixPackageName_5() {
		create('Foo.xtend', '''
			package bar|
			
			import static bar.C.D.*
			class Foo {
				def void m() {
					staticM
				}
			}
			class C {
				static class D {
					static def void staticM() {}
				}
			}
		''')
		.assertIssueCodes(WRONG_PACKAGE)
		.assertResolutionLabels("Change package declaration to ''")
		.assertModelAfterQuickfix('''
			import static C.D.*
			class Foo {
				def void m() {
					staticM
				}
			}
			class C {
				static class D {
					static def void staticM() {}
				}
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
		.assertFatureCallLinkingIssue
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
		.assertFatureCallLinkingIssue
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
		.assertFatureCallLinkingIssue
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
		.assertFatureCallLinkingIssue
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
		.assertFatureCallLinkingIssue
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
		.assertFatureCallLinkingIssue
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
		.assertFatureCallLinkingIssue
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
		.assertFatureCallLinkingIssue
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
		.assertFatureCallLinkingIssue
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
		.assertFatureCallLinkingIssue
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
		.assertFatureCallLinkingIssue
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
		.assertFatureCallLinkingIssue
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
		.assertFatureCallLinkingIssue
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
		.assertFatureCallLinkingIssue
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
	def void missingConstructorOtherClassTwoFiles() {
		create('Foo.xtend', '''
			class Foo| {
			}
		''')
		val myEditor = editor
		create('Bar.xtend', '''
			class Bar {
				def foo() {
					new Foo(1)|
				}
			}
		''')
		.assertIssueCodes(INVALID_NUMBER_OF_ARGUMENTS)
		.assertResolutionLabels("Create constructor 'new(int)' in 'Foo'")
		.assertModelAfterQuickfix('''
			class Bar {
				def foo() {
					new Foo(1)
				}
			}
		''')
		assertEquals('''
			class Foo {
				
				new(int i) {
					«defaultBody»
				}
				
			}
		'''.toString, myEditor.document.get)
	}
	
	@Test
	def void missingConstructorCallParentheses() {
		create('Foo.xtend', '''
			class TopLevelClassWithDefaultconstructor {
				def foo() {}
			}
			
			class Bar {
				def bar() {
					new TopLevelClassWithDefaultconstructor.foo|
				}
			}
		''')
		.assertIssueCodes(Diagnostic.LINKING_DIAGNOSTIC)
		.assertResolutionLabels("Change to constructor call 'new TopLevelClassWithDefaultconstructor()'")
		.assertModelAfterQuickfix('''
			class TopLevelClassWithDefaultconstructor {
				def foo() {}
			}
			
			class Bar {
				def bar() {
					new TopLevelClassWithDefaultconstructor().foo
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
	def void missingConstructorCallParentheses_2() {
		create('Foo.xtend', '''
			class Foo {
				def foo() {
					new ArrayList|
				}
			}
		''')
		.assertIssueCodes(Diagnostic.LINKING_DIAGNOSTIC)
		.assertResolutionLabelsSubset("Import 'ArrayList' (java.util)")
		.assertModelAfterQuickfix("Import 'ArrayList' (java.util)", '''
			import java.util.ArrayList
			
			class Foo {
				def foo() {
					new ArrayList
				}
			}
		''')
	}
	
	@Test
	def void missingConstructorCallParentheses_3() {
		create('Foo.xtend', '''
			class Foo {
				def foo() {
					new ArrayList|()
				}
			}
		''')
		.assertIssueCodes(Diagnostic.LINKING_DIAGNOSTIC)
		.assertResolutionLabelsSubset("Import 'ArrayList' (java.util)")
		.assertModelAfterQuickfix("Import 'ArrayList' (java.util)", '''
			import java.util.ArrayList
			
			class Foo {
				def foo() {
					new ArrayList()
				}
			}
		''')
	}
	
	@Test
	def void missingConstructorCallParentheses_4() {
		create('Foo.xtend', '''
			class Foo {
				def foo() {
					new ArrayList|().size
				}
			}
		''')
		.assertIssueCodes(Diagnostic.LINKING_DIAGNOSTIC)
		.assertResolutionLabelsSubset("Import 'ArrayList' (java.util)")
		.assertModelAfterQuickfix("Import 'ArrayList' (java.util)", '''
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
	def void missingConcreteMembers3() {
		create('C.xtend', '''
			class C {
				val r = new Runnab|le {
				}
			}
		''')
		.assertIssueCodes(ANONYMOUS_CLASS_MISSING_MEMBERS)
		.assertResolutionLabels("Add unimplemented methods")
		.assertModelAfterQuickfix("Add unimplemented methods", '''
			class C {
				val r = new Runnable {
					
					override run() {
						«defaultBody»
					}
					
				}
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
		.assertResolutionLabels("Create method 'operator_multiply(Foo)'", "Change to '+'") /* last proposal does not make much sense */
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
		.assertResolutionLabels("Create extension method 'operator_multiply(Foo, Bar)'", "Create method 'operator_multiply(Bar)' in 'Foo'", "Change to '+'") /* last proposal does not make much sense */
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
	def void missingOperatorOtherClass_02() {
		create('Foo.xtend', '''
			class Foo {
				def +(Bar b) {}
			}
			
			class Bar {
				def bar(Foo foo) {
					foo *| this
				}
			}
		''')
		.assertIssueCodes(Diagnostic.LINKING_DIAGNOSTIC)
		.assertResolutionLabels("Create extension method 'operator_multiply(Foo, Bar)'", "Create method 'operator_multiply(Bar)' in 'Foo'", "Change to '+'")
		.assertModelAfterQuickfix("Change to '+'", '''
			class Foo {
				def +(Bar b) {}
			}
			
			class Bar {
				def bar(Foo foo) {
					foo + this
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
	def void unhandledCheckedExceptionForJvmConstructor() {
		setSeverity(IssueCodes.UNHANDLED_EXCEPTION, "error")
		create('Foo.xtend', '''
			class Foo {
				new() {
					this|('lalala')
				}
			
				new(String foo) throws Exception {
				}
			}
		''')
		.assertIssueCodes(UNHANDLED_EXCEPTION)
		.assertResolutionLabels("Add throws declaration")
		.assertModelAfterQuickfix("Add throws declaration", '''
			class Foo {
				new() throws Exception {
					this('lalala')
				}
			
				new(String foo) throws Exception {
				}
			}
		''')
	}
	
	@Test 
	def void unhandledCheckedExceptionForJvmConstructor2() {
		setSeverity(IssueCodes.UNHANDLED_EXCEPTION, "error")
		create('Foo.xtend', '''
			class Foo {
				new() {
					super()
					foo|()
				}
			
				def foo() throws Exception {
				}
			}
		''')
		.assertIssueCodes(UNHANDLED_EXCEPTION)
		.assertResolutionLabels("Add throws declaration", "Surround with try/catch block")
		.assertModelAfterQuickfix("Add throws declaration", '''
			class Foo {
				new() throws Exception {
					super()
					foo()
				}
			
				def foo() throws Exception {
				}
			}
		''')
		.assertModelAfterQuickfix("Surround with try/catch block", '''
			class Foo {
				new() {
					super()
					try {
						foo()
					} catch (Exception exc) {
						throw new RuntimeException("auto-generated try/catch", exc)
					}
				}
			
				def foo() throws Exception {
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
	def void duplicateImport_0() {
		create('Foo.xtend', '''
			import static java.lang.String.valueOf
			import static java.lang.String.valueOf|
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
			
			}
		''')
		.assertIssueCodes(IMPORT_UNUSED)
		.assertResolutionLabels("Organize imports")
		.assertModelAfterQuickfix('''
			import static java.lang.String.valueOf
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
			
			}
		''')
	}

	@Test
	def void duplicateImport_1() {
		create('Foo.xtend', '''
			import static java.lang.String.valueOf
			import static java.lang.String.*|
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
			
			}
		''')
		.assertIssueCodes(IMPORT_UNUSED)
		.assertResolutionLabels("Organize imports")
		.assertModelAfterQuickfix('''
			import static java.lang.String.valueOf
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
			
			}
		''')
	}

	@Test
	def void duplicateImport_2() {
		create('Foo.xtend', '''
			import static java.lang.String.valueOf
			import static extension java.lang.String.valueOf|
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
			
			}
		''')
		.assertIssueCodes(IMPORT_UNUSED)
		.assertResolutionLabels("Organize imports")
		.assertModelAfterQuickfix('''
			import static java.lang.String.valueOf
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
			
			}
		''')
	}

	@Test
	def void duplicateImport_3() {
		create('Foo.xtend', '''
			import static java.lang.String.valueOf
			import static extension java.lang.String.*|
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
			
			}
		''')
		.assertIssueCodes(IMPORT_UNUSED)
		.assertResolutionLabels("Organize imports")
		.assertModelAfterQuickfix('''
			import static java.lang.String.valueOf
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
			
			}
		''')
	}

	@Test
	def void duplicateImport_4() {
		create('Foo.xtend', '''
			import static java.lang.String.*
			import static java.lang.String.*|
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
			
			}
		''')
		.assertIssueCodes(IMPORT_UNUSED)
		.assertResolutionLabels("Organize imports")
		.assertModelAfterQuickfix('''
			import static java.lang.String.*
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
			
			}
		''')
	}

	@Test
	def void duplicateImport_5() {
		create('Foo.xtend', '''
			import static java.lang.String.valueOf
			import static java.lang.String.valueOf
			import static java.la|ng.String.format
			import static java.lang.String.*
			import static java.lang.String.*
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
				
				def bar() {
					copyValueOf(null as char[])
				}
			
			}
		''')
		.assertIssueCodes(IMPORT_UNUSED)
		.assertResolutionLabels("Organize imports")
		.assertModelAfterQuickfix('''
			import static java.lang.String.*
			import static java.lang.String.valueOf
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
				
				def bar() {
					copyValueOf(null as char[])
				}
			
			}
		''')
	}

	@Test
	def void duplicateImport_6() {
		create('Foo.xtend', '''
			import static java.lang.String.valueOf
			import static java.lang.String.valueOf|
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
				
				def bar() {
					valueOf(2)
				}
			
			}
		''')
		.assertIssueCodes(IMPORT_UNUSED)
		.assertResolutionLabels("Organize imports")
		.assertModelAfterQuickfix('''
			import static java.lang.String.valueOf
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
				
				def bar() {
					valueOf(2)
				}
			
			}
		''')
	}

	@Test
	def void duplicateImport_7() {
		create('Foo.xtend', '''
			import static java.lang.String.*
			import static java.lang.String.*|
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
				
				def bar() {
					valueOf(2)
				}
			
			}
		''')
		.assertIssueCodes(IMPORT_UNUSED)
		.assertResolutionLabels("Organize imports")
		.assertModelAfterQuickfix('''
			import static java.lang.String.*
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
				
				def bar() {
					valueOf(2)
				}
			
			}
		''')
	}

	@Test
	def void duplicateImport_8() {
		create('Foo.xtend', '''
			import static java.lang.String.*
			import static extension java.lang.String.valueOf|
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
			
			}
		''')
		.assertIssueCodes(IMPORT_UNUSED)
		.assertResolutionLabels("Organize imports")
		.assertModelAfterQuickfix('''
			import static java.lang.String.*
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
			
			}
		''')
	}

	@Test
	def void duplicateImport_9() {
		create('Foo.xtend', '''
			import static java.lang.String.*
			import static extension java.lang.String.*|
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
			
			}
		''')
		.assertIssueCodes(IMPORT_UNUSED)
		.assertResolutionLabels("Organize imports")
		.assertModelAfterQuickfix('''
			import static java.lang.String.*
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
			
			}
		''')
	}

	@Test
	def void duplicateImport_10() {
		create('Foo.xtend', '''
			import static extension java.lang.String.*
			import static extension java.lang.String.*|
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
			
			}
		''')
		.assertIssueCodes(IMPORT_UNUSED)
		.assertResolutionLabels("Organize imports")
		.assertModelAfterQuickfix('''
			import static java.lang.String.*
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
			
			}
		''')
	}

	@Test
	def void duplicateImport_11() {
		create('Foo.xtend', '''
			import static java.lang.String.valueOf|
			import static extension java.lang.String.valueOf
			
			class Foo {
			
				def foo() {
					1.valueOf
				}
			
			}
		''')
		.assertIssueCodes(IMPORT_UNUSED)
		.assertResolutionLabels("Organize imports")
		.assertModelAfterQuickfix('''
			import static extension java.lang.String.valueOf
			
			class Foo {
			
				def foo() {
					1.valueOf
				}
			
			}
		''')
	}

	@Test
	def void duplicateImport_12() {
		create('Foo.xtend', '''
			import static java.lang.String.valueOf|
			import static extension java.lang.String.*
			
			class Foo {
			
				def foo() {
					1.valueOf
				}
			
			}
		''')
		.assertIssueCodes(IMPORT_UNUSED)
		.assertResolutionLabels("Organize imports")
		.assertModelAfterQuickfix('''
			import static extension java.lang.String.*
			
			class Foo {
			
				def foo() {
					1.valueOf
				}
			
			}
		''')
	}

	@Test
	def void duplicateImport_13() {
		create('Foo.xtend', '''
			import static java.lang.String.*|
			import static extension java.lang.String.valueOf
			
			class Foo {
			
				def foo() {
					1.valueOf
				}
			
			}
		''')
		.assertIssueCodes(IMPORT_UNUSED)
		.assertResolutionLabels("Organize imports")
		.assertModelAfterQuickfix('''
			import static extension java.lang.String.valueOf
			
			class Foo {
			
				def foo() {
					1.valueOf
				}
			
			}
		''')
	}

	@Test
	def void duplicateImport_14() {
		create('Foo.xtend', '''
			import static java.lang.String.*|
			import static extension java.lang.String.*
			
			class Foo {
			
				def foo() {
					1.valueOf
				}
			
			}
		''')
		.assertIssueCodes(IMPORT_UNUSED)
		.assertResolutionLabels("Organize imports")
		.assertModelAfterQuickfix('''
			import static extension java.lang.String.*
			
			class Foo {
			
				def foo() {
					1.valueOf
				}
			
			}
		''')
	}

	@Test
	def void duplicateImport_15() {
		create('Foo.xtend', '''
			import static extension java.lang.String.*
			import static extension java.lang.String.*|
			
			class Foo {
			
				def foo() {
					1.valueOf
				}
			
			}
		''')
		.assertIssueCodes(IMPORT_UNUSED)
		.assertResolutionLabels("Organize imports")
		.assertModelAfterQuickfix('''
			import static extension java.lang.String.*
			
			class Foo {
			
				def foo() {
					1.valueOf
				}
			
			}
		''')
	}
	
	@Test
	def void duplicateImport_16() {
		create('Foo.xtend', '''
			import static java.lang.Integer.valueOf
			import static java.lang.Integer.valueOf
			import static java.lang.Integer.MIN_VALUE
			import static java.lang.In|teger.MIN_VALUE
			import static java.lang.Integer.parseInt
			import static java.lang.Integer.parseInt
			import static java.lang.Integer.*
			import static java.lang.Integer.*
			
			class C {
				def m() {
					parseInt('')
					valueOf('')
					MAX_VALUE
				}
			}
		''')
		.assertIssueCodes(IMPORT_UNUSED)
		.assertResolutionLabels("Organize imports")
		.assertModelAfterQuickfix('''
			import static java.lang.Integer.*
			import static java.lang.Integer.parseInt
			import static java.lang.Integer.valueOf
			
			class C {
				def m() {
					parseInt('')
					valueOf('')
					MAX_VALUE
				}
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
	def void missingTypeInstanceAccess() {
		create('Foo.xtend', '''
			class Foo {
				def foo() {
					Collections|.sort
				}
			}
		''')
		.assertTypeLiteralLinkingIssue
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
		.assertTypeLiteralLinkingIssue
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
		.assertFatureCallLinkingIssue
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
	
	@Test
	def void ambiguousImplicitMethodCall() {
		create('Foo.xtend', '''
			class Foo {
				
				def foo() {
					|name
				}
				
				def String name() {
					null
				}
				
				def String getName() {
					null
				}
			}
		''')
		.assertIssueCodes(AMBIGUOUS_FEATURE_CALL)
		.assertResolutionLabels("Change to 'name()'", "Change to 'getName()'")
		.assertModelAfterQuickfix("Change to 'name()'",'''
			class Foo {
				
				def foo() {
					name()
				}
				
				def String name() {
					null
				}
				
				def String getName() {
					null
				}
			}
		''')
		.assertModelAfterQuickfix("Change to 'getName()'",'''
			class Foo {
				
				def foo() {
					getName()
				}
				
				def String name() {
					null
				}
				
				def String getName() {
					null
				}
			}
		''')
	}
	
	@Test
	def void ambiguousImplicitMethodCallWithExtensionMethod() {
		create('Foo.xtend', '''
			class Foo {
			
				extension FooExtension
			
				def foo(String it) {
					|name
				}
			
				def name(String it) {
					it
				}
			
				def getName(String it) {
					it
				}
			
			}
			
			class FooExtension {
			
				def name(String it) {
					it
				}
			
				def getName(String it) {
					it
				}
			
			}
		''')
		.assertIssueCodes(AMBIGUOUS_FEATURE_CALL)
		.assertResolutionLabels("Change to 'name()'", "Change to 'getName()'")
		.assertModelAfterQuickfix("Change to 'name()'",'''
			class Foo {
			
				extension FooExtension
			
				def foo(String it) {
					name()
				}
			
				def name(String it) {
					it
				}
			
				def getName(String it) {
					it
				}
			
			}
			
			class FooExtension {
			
				def name(String it) {
					it
				}
			
				def getName(String it) {
					it
				}
			
			}
		''')
		.assertModelAfterQuickfix("Change to 'getName()'",'''
			class Foo {
			
				extension FooExtension
			
				def foo(String it) {
					getName()
				}
			
				def name(String it) {
					it
				}
			
				def getName(String it) {
					it
				}
			
			}
			
			class FooExtension {
			
				def name(String it) {
					it
				}
			
				def getName(String it) {
					it
				}
			
			}
		''')
	}
	
	@Test
	def void ambiguousImplicitMethodCallWithIsAndGet() {
		create('Foo.xtend', '''
			class Foo {
				
				def foo() {
					|name
				}
				
				def boolean isName() {
					true
				}
				
				def String getName() {
					null
				}
			}
		''')
		.assertIssueCodes(AMBIGUOUS_FEATURE_CALL)
		.assertResolutionLabels("Change to 'isName()'", "Change to 'getName()'")
		.assertModelAfterQuickfix("Change to 'isName()'",'''
			class Foo {
				
				def foo() {
					isName()
				}
				
				def boolean isName() {
					true
				}
				
				def String getName() {
					null
				}
			}
		''')
		.assertModelAfterQuickfix("Change to 'getName()'",'''
			class Foo {
				
				def foo() {
					getName()
				}
				
				def boolean isName() {
					true
				}
				
				def String getName() {
					null
				}
			}
		''')
	}
	
	@Test def void unreachableCase() {
		create('Foo.xtend', '''
		class Foo {
		
			def foo() {
				switch x : new Exception {
					Exception: 1
					java.io.IOExce|ption: 2
					java.io.FileNotFoundException: 3
				}
			}
		
		}
		''')
		.assertIssueCodes(UNREACHABLE_CASE)
		.assertResolutionLabels('Remove case', 'Move case up')
		.assertModelAfterQuickfix('Remove case', '''
		class Foo {
		
			def foo() {
				switch x : new Exception {
					Exception: 1
					java.io.FileNotFoundException: 3
				}
			}
		
		}
		''')
		.assertModelAfterQuickfix('Move case up', '''
		class Foo {
		
			def foo() {
				switch x : new Exception {
					java.io.IOException: 2
					Exception: 1
					java.io.FileNotFoundException: 3
				}
			}
		
		}
		''')
	}
	
	@Test def void unreachableCase_2() {
		create('Foo.xtend', '''
		class Foo {
		
			def foo() {
				switch x : new Exception {
					Exception: 1
					java.io.IOException: 2
					java.io.FileNo|tFoundException: 3
				}
			}
		
		}
		''')
		.assertIssueCodes(UNREACHABLE_CASE)
		.assertResolutionLabels('Remove case', 'Move case up')
		.assertModelAfterQuickfix('Remove case', '''
		class Foo {
		
			def foo() {
				switch x : new Exception {
					Exception: 1
					java.io.IOException: 2
				}
			}
		
		}
		''')
		.assertModelAfterQuickfix('Move case up', '''
		class Foo {
		
			def foo() {
				switch x : new Exception {
					java.io.FileNotFoundException: 3
					Exception: 1
					java.io.IOException: 2
				}
			}
		
		}
		''')
	}
	
	@Test def void unreachableCatchBlock() {
		create('Foo.xtend', '''
		class Foo {
		
			def foo() {
				try {
				
				} catch (Exception e) {
					
				} catch (java.io.IOExc|eption e) {
					
				} catch (java.io.FileNotFoundException e) {
					
				}
			}
		
		}
		''')
		.assertIssueCodes(UNREACHABLE_CATCH_BLOCK)
		.assertResolutionLabels('Remove catch block', 'Move catch block up')
		.assertModelAfterQuickfix('Remove catch block', '''
		class Foo {
		
			def foo() {
				try {
				
				} catch (Exception e) {
					
				} catch (java.io.FileNotFoundException e) {
					
				}
			}
		
		}
		''')
		.assertModelAfterQuickfix('Move catch block up', '''
		class Foo {
		
			def foo() {
				try {
				
				} catch (java.io.IOException e) {
					
				} catch (Exception e) {
					
				} catch (java.io.FileNotFoundException e) {
					
				}
			}
		
		}
		''')
	}
	
	@Test def void unreachableCatchBlock_2() {
		create('Foo.xtend', '''
		class Foo {
		
			def foo() {
				try {
				
				} catch (Exception e) {
					
				} catch (java.io.IOException e) {
					
				} catch (java.io.FileNo|tFoundException e) {
					
				}
			}
		
		}
		''')
		.assertIssueCodes(UNREACHABLE_CATCH_BLOCK)
		.assertResolutionLabels('Remove catch block', 'Move catch block up')
		.assertModelAfterQuickfix('Remove catch block', '''
		class Foo {
		
			def foo() {
				try {
				
				} catch (Exception e) {
					
				} catch (java.io.IOException e) {
					
				}
			}
		
		}
		''')
		.assertModelAfterQuickfix('Move catch block up', '''
		class Foo {
		
			def foo() {
				try {
				
				} catch (java.io.FileNotFoundException e) {
					
				} catch (Exception e) {
					
				} catch (java.io.IOException e) {
					
				}
			}
		
		}
		''')
	}
	
	@Test def void unreachableIfBlock() {
		create('Foo.xtend', '''
		class Foo {
		
			def foo() {
				val x = new Object
				if (x instanceof Exception) {
					
				} else if (x instanceof java.io.IOExc|eption) {
					
				} else if (x instanceof java.io.FileNotFoundException) {
					
				}
			}
		
		}
		''')
		.assertIssueCodes(UNREACHABLE_IF_BLOCK)
		.assertResolutionLabels("Remove if block", "Move if block up")
		.assertModelAfterQuickfix("Remove if block", '''
		class Foo {
		
			def foo() {
				val x = new Object
				if (x instanceof Exception) {
					
				} else if (x instanceof java.io.FileNotFoundException) {
					
				}
			}
		
		}
		''')
		.assertModelAfterQuickfix("Move if block up", '''
		class Foo {
		
			def foo() {
				val x = new Object
				if (x instanceof java.io.IOException) {
					
				} else if (x instanceof Exception) {
					
				} else if (x instanceof java.io.FileNotFoundException) {
					
				}
			}
		
		}
		''')
	}
	
	@Test def void unreachableIfBlock_2() {
		create('Foo.xtend', '''
		class Foo {
		
			def foo() {
				val x = new Object
				if (x instanceof Exception) {
					
				} else if (x instanceof java.io.IOException) {
					
				} else if (x instanceof java.io.FileNo|tFoundException) {
					
				}
			}
		
		}
		''')
		.assertIssueCodes(UNREACHABLE_IF_BLOCK)
		.assertResolutionLabels("Remove if block", "Move if block up")
		.assertModelAfterQuickfix("Remove if block", '''
		class Foo {
		
			def foo() {
				val x = new Object
				if (x instanceof Exception) {
					
				} else if (x instanceof java.io.IOException) {
					
				}
			}
		
		}
		''')
		.assertModelAfterQuickfix("Move if block up", '''
		class Foo {
		
			def foo() {
				val x = new Object
				if (x instanceof java.io.FileNotFoundException) {
					
				} else if (x instanceof Exception) {
					
				} else if (x instanceof java.io.IOException) {
					
				}
			}
		
		}
		''')
	}
	
	@Test def void unreachableIfBlock_3() {
		create('Foo.xtend', '''
		import java.io.IOException

		class Foo {
		
			Object y
		
			def foo(Object x) {
				if (x instanceof Exception) {
					1
				} else if (y instanceof Exception) {
					2
				} else if (Bar.z instanceof Exception) {
					1
				} else if (x instanceof IOExc|eption) {
					2
				} else if (y instanceof IOException) {
					2
				} else if (Bar.z instanceof IOException) {
					2
				}
			}
		
		}
		
		class Bar {
			public static Object z
		}
		''')
		.assertIssueCodes(UNREACHABLE_IF_BLOCK)
		.assertResolutionLabels("Remove if block", "Move if block up")
		.assertModelAfterQuickfix("Move if block up", '''
		import java.io.IOException

		class Foo {
		
			Object y
		
			def foo(Object x) {
				if (x instanceof IOException) {
					2
				} else if (x instanceof Exception) {
					1
				} else if (y instanceof Exception) {
					2
				} else if (Bar.z instanceof Exception) {
					1
				} else if (y instanceof IOException) {
					2
				} else if (Bar.z instanceof IOException) {
					2
				}
			}
		
		}
		
		class Bar {
			public static Object z
		}
		''')
	}
	
	@Test def void unreachableIfBlock_4() {
		create('Foo.xtend', '''
		import java.io.IOException

		class Foo {
		
			Object y
		
			def foo(Object x) {
				if (x instanceof Exception) {
					1
				} else if (y instanceof Exception) {
					2
				} else if (Bar.z instanceof Exception) {
					1
				} else if (x instanceof IOException) {
					2
				} else if (y instanceof IOExc|eption) {
					2
				} else if (Bar.z instanceof IOException) {
					2
				}
			}
		
		}
		
		class Bar {
			public static Object z
		}
		''')
		.assertIssueCodes(UNREACHABLE_IF_BLOCK)
		.assertResolutionLabels("Remove if block", "Move if block up")
		.assertModelAfterQuickfix("Move if block up", '''
		import java.io.IOException

		class Foo {
		
			Object y
		
			def foo(Object x) {
				if (x instanceof Exception) {
					1
				} else if (y instanceof IOException) {
					2
				} else if (y instanceof Exception) {
					2
				} else if (Bar.z instanceof Exception) {
					1
				} else if (x instanceof IOException) {
					2
				} else if (Bar.z instanceof IOException) {
					2
				}
			}
		
		}
		
		class Bar {
			public static Object z
		}
		''')
	}
	
	@Test def void unreachableIfBlock_5() {
		create('Foo.xtend', '''
		import java.io.IOException

		class Foo {
		
			Object y
		
			def foo(Object x) {
				if (x instanceof Exception) {
					1
				} else if (y instanceof Exception) {
					2
				} else if (Bar.z instanceof Exception) {
					1
				} else if (x instanceof IOException) {
					2
				} else if (y instanceof IOException) {
					2
				} else if (Bar.z instanceof IOExc|eption) {
					2
				}
			}
		
		}
		
		class Bar {
			public static Object z
		}
		''')
		.assertIssueCodes(UNREACHABLE_IF_BLOCK)
		.assertResolutionLabels("Remove if block", "Move if block up")
		.assertModelAfterQuickfix("Move if block up", '''
		import java.io.IOException

		class Foo {
		
			Object y
		
			def foo(Object x) {
				if (x instanceof Exception) {
					1
				} else if (y instanceof Exception) {
					2
				} else if (Bar.z instanceof IOException) {
					2
				} else if (Bar.z instanceof Exception) {
					1
				} else if (x instanceof IOException) {
					2
				} else if (y instanceof IOException) {
					2
				}
			}
		
		}
		
		class Bar {
			public static Object z
		}
		''')
	}
	
	@Test def void invalidTypeArgsOnTypeLiteral_01() {
		create('Foo.xtend', 
		'''
		class C {
			def Object m() {
				<String, |String>Iterable
			}
		}
		''')
		.assertIssueCodes(INVALID_TYPE_ARGUMENTS_ON_TYPE_LITERAL)
		.assertResolutionLabels("Remove invalid type arguments")
		.assertModelAfterQuickfix("Remove invalid type arguments",
		'''
		class C {
			def Object m() {
				Iterable
			}
		}
		''')
	}
	
	@Test def void invalidTypeArgsOnTypeLiteral_02() {
		create('Foo.xtend', 
		'''
		class C {
			def Object m() {
				java.util.  < /* |comments are not preserved, WS not removed */ String>List
			}
		}
		''')
		.assertIssueCodes(INVALID_TYPE_ARGUMENTS_ON_TYPE_LITERAL)
		.assertResolutionLabels("Remove invalid type argument")
		.assertModelAfterQuickfix("Remove invalid type argument",
		'''
		class C {
			def Object m() {
				java.util.  List
			}
		}
		''')
	}
	
	@Test def void incompleteCasesOnEnum() {
		create('Foo.xtend', 
		'''
		class Foo {
		
			def foo(Color x) {
				switch |x {
					case RED: {
					}
				}
			}
		
		}
		
		enum Color {
			RED, GREEN, BLUE
		}
		''')
		.assertIssueCodes(INCOMPLETE_CASES_ON_ENUM)
		.assertResolutionLabels("Add 'default' case", "Add missing cases")
		.assertModelAfterQuickfix("Add 'default' case",
		'''
		class Foo {
		
			def foo(Color x) {
				switch x {
					case RED: {
					}
					default: {
					}
				}
			}
		
		}
		
		enum Color {
			RED, GREEN, BLUE
		}
		''')
		.assertModelAfterQuickfix("Add missing cases",
		'''
		class Foo {
		
			def foo(Color x) {
				switch x {
					case RED: {
					}
					case GREEN: {
					}
					case BLUE: {
					}
				}
			}
		
		}
		
		enum Color {
			RED, GREEN, BLUE
		}
		''')
	}
	
	@Test def void incompleteCasesOnEnum_2() {
		create('Foo.xtend', 
		'''
		class Foo {
		
			def foo(Color x) {
				switch |x {
				}
			}
		
		}
		
		enum Color {
			RED, GREEN, BLUE
		}
		''')
		.assertIssueCodes(INCOMPLETE_CASES_ON_ENUM)
		.assertResolutionLabels("Add 'default' case", "Add missing cases")
		.assertModelAfterQuickfix("Add 'default' case",
		'''
		class Foo {
		
			def foo(Color x) {
				switch x {
					default: {
					}
				}
			}
		
		}
		
		enum Color {
			RED, GREEN, BLUE
		}
		''')
		.assertModelAfterQuickfix("Add missing cases",
		'''
		class Foo {
		
			def foo(Color x) {
				switch x {
					case RED: {
					}
					case GREEN: {
					}
					case BLUE: {
					}
				}
			}
		
		}
		
		enum Color {
			RED, GREEN, BLUE
		}
		''')
	}

	@Test def void implicitReturn() {
		setSeverity(IMPLICIT_RETURN, "error")
		create("Foo.xtend",
		'''
			class Foo {
				def foo() {
					|1
				}
			}
		'''
		)
		.assertIssueCodes(IMPLICIT_RETURN)
		.assertResolutionLabels('''Add "return" keyword''')
		.assertModelAfterQuickfix(
		'''
			class Foo {
				def foo() {
					return 1
				}
			}
		''')
	}
	
	@Test def void apiTypeInference01() {
		setSeverity(API_TYPE_INFERENCE, "error")
		create("Foo.xtend",
		'''
			class Foo {
				def <T> |foo() {
					<T>newArrayList
				}
			}
		'''
		)
		.assertIssueCodes(API_TYPE_INFERENCE)
		.assertResolutionLabels('''Infer type''')
		.assertModelAfterQuickfix(
		'''
			import java.util.ArrayList
			
			class Foo {
				def <T> ArrayList<T> foo() {
					<T>newArrayList
				}
			}
		''')
	}

	@Test def void apiTypeInference02() {
		setSeverity(API_TYPE_INFERENCE, "error")
		create("Foo.xtend",
		'''
			class Foo<T> {
				public val |foo = <T>newArrayList
			}
		'''
		)
		.assertIssueCodes(API_TYPE_INFERENCE)
		.assertResolutionLabels('''Infer type''')
		.assertModelAfterQuickfix(
		'''
			import java.util.ArrayList
			
			class Foo<T> {
				public val ArrayList<T> foo = <T>newArrayList
			}
		''')
	}
		
	@Test def void apiTypeInference03() {
		setSeverity(API_TYPE_INFERENCE, "error")
		create("Foo.xtend",
		'''
			class Foo {
				def <T> create {<T>newArrayList} |foo() {}
			}
		'''
		)
		.assertIssueCodes(API_TYPE_INFERENCE)
		.assertResolutionLabels('''Infer type''')
		.assertModelAfterQuickfix(
		'''
			import java.util.ArrayList
			
			class Foo {
				def <T> ArrayList<T> create {<T>newArrayList} foo() {}
			}
		''')
	}
	
	@Test def void featureCallWithoutParentheses() {
		setSeverity(OPERATION_WITHOUT_PARENTHESES, "error")
		create("Foo.xtend",
		'''
			class Foo {
				val foo = newArrayList|
			}
		'''
		)
		.assertIssueCodes(OPERATION_WITHOUT_PARENTHESES)
		.assertResolutionLabels('''Add parentheses''')
		.assertModelAfterQuickfix(
		'''
			class Foo {
				val foo = newArrayList()
			}
		''')
	}
	
	@Test def void memberFeatureCallWithoutParentheses() {
		setSeverity(OPERATION_WITHOUT_PARENTHESES, "error")
		create("Foo.xtend",
		'''
			class Foo {
				def int foo() {
					this.foo|
				}
			}
		'''
		)
		.assertIssueCodes(OPERATION_WITHOUT_PARENTHESES)
		.assertResolutionLabels('''Add parentheses''')
		.assertModelAfterQuickfix(
		'''
			class Foo {
				def int foo() {
					this.foo()
				}
			}
		''')
	}
	
	@Test def void constructorCallWithoutParentheses() {
		setSeverity(OPERATION_WITHOUT_PARENTHESES, "error")
		create("Foo.xtend",
		'''
			import java.util.ArrayList
			
			class Foo {
				val foo = new ArrayList|
			}
		'''
		)
		.assertIssueCodes(OPERATION_WITHOUT_PARENTHESES)
		.assertResolutionLabels('''Add parentheses''')
		.assertModelAfterQuickfix(
		'''
			import java.util.ArrayList
			
			class Foo {
				val foo = new ArrayList()
			}
		''')
	}
	
	@Test def void constructorCallWithoutParentheses02() {
		setSeverity(OPERATION_WITHOUT_PARENTHESES, "error")
		create("Foo.xtend",
		'''
			import java.util.ArrayList
			
			class Foo {
				val foo = new ArrayList<String   >|
			}
		'''
		)
		.assertIssueCodes(OPERATION_WITHOUT_PARENTHESES)
		.assertResolutionLabels('''Add parentheses''')
		.assertModelAfterQuickfix(
		'''
			import java.util.ArrayList
			
			class Foo {
				val foo = new ArrayList<String   >()
			}
		''')
	}
	
	@Test def void fixRedundantCase_01() {
		create("Foo.xtend",
		'''
			class Foo {
				def foo() {
					switch i : 1 {
						cas|e 1,
					}
				}
			}
		'''
		)
		.assertIssueCodes(REDUNDANT_CASE)
		.assertResolutionLabels("Remove redundant case.", "Assign empty expression.")
		.assertModelAfterQuickfix("Remove redundant case.",
		'''
			class Foo {
				def foo() {
					switch i : 1 {
						
					}
				}
			}
		''')
		.assertModelAfterQuickfix("Assign empty expression.",
		'''
			class Foo {
				def foo() {
					switch i : 1 {
						case 1: {
							
						}
					}
				}
			}
		''')
	}
	
	@Test def void fixRedundantCase_02() {
		create("Foo.xtend",
		'''
			class Foo {
				def foo() {
					switch i : 1 {
						case 1,
						cas|e 2,
					}
				}
			}
		'''
		)
		.assertIssueCodes(REDUNDANT_CASE)
		.assertResolutionLabels("Remove redundant case.", "Assign empty expression.")
		.assertModelAfterQuickfix("Remove redundant case.",
		'''
			class Foo {
				def foo() {
					switch i : 1 {
						case 1,
						
					}
				}
			}
		''')
		.assertModelAfterQuickfix("Assign empty expression.",
		'''
			class Foo {
				def foo() {
					switch i : 1 {
						case 1,
						case 2: {
							
						}
					}
				}
			}
		''')
	}
	
	@Test def void fixRedundantCase_03() {
		create("Foo.xtend",
		'''
			class Foo {
				def foo() {
					switch i : 1 {
						case 1,
						cas|e 2,
						default: 1
					}
				}
			}
		'''
		)
		.assertIssueCodes(REDUNDANT_CASE)
		.assertResolutionLabels("Remove redundant case.", "Assign empty expression.")
		.assertModelAfterQuickfix("Remove redundant case.",
		'''
			class Foo {
				def foo() {
					switch i : 1 {
						case 1,
						
						default: 1
					}
				}
			}
		''')
		.assertModelAfterQuickfix("Assign empty expression.",
		'''
			class Foo {
				def foo() {
					switch i : 1 {
						case 1,
						case 2: {
							
						}
						default: 1
					}
				}
			}
		''')
	}

	/**
	 * This test is disabled due to https://bugs.eclipse.org/bugs/show_bug.cgi?id=463547
	 * ({@link AbstractXtendUITestCase#setJavaVersion(JavaVersion)} uses {@link org.junit.Assume})
	 */
	@Ignore @Test
	def void conflictingDefaultMethods() {
		javaVersion = JavaVersion.JAVA8
		create('Foo.xtend', '''
			interface A {
				def void foo() { }
			}
			interface B {
				def void foo() { }
			}
			class |Foo implements A, B {
			}
		''')
		.assertIssueCodes(CONFLICTING_DEFAULT_METHODS)
		.assertResolutionLabels("Override conflicting method of type A", "Override conflicting method of type B")
	}

	@Test
	def void privateFeatureFromSubclass_1() {
		create('Foo.xtend', '''
			class Foo {
				private int x
				def foo() {
					val bar = new Bar
					println(bar.|x)
				}
			}
			class Bar extends Foo {
			}
		''')
		.assertIssueCodes(FEATURE_NOT_VISIBLE)
		.assertResolutionLabels("Add cast to Foo.")
	}

	@Test
	def void privateFeatureFromSubclass_2() {
		create('Foo.xtend', '''
			class Foo {
				private int x
				def foo() {
					val bar = new Bar
					bar.|x = 2
				}
			}
			class Bar extends Foo {
			}
		''')
		.assertIssueCodes(FEATURE_NOT_VISIBLE)
		.assertResolutionLabels("Add cast to Foo.")
	}

	@Test
	def void privateFeatureFromSubclass_3() {
		create('Foo.xtend', '''
			class Foo {
				private int x
				def foo() {
					#[new Bar].map[|x]
				}
			}
			class Bar extends Foo {
			}
		''')
		.assertIssueCodes(FEATURE_NOT_VISIBLE)
		.assertResolutionLabels("Add cast to Foo.")
	}

	@Test
	def void privateFeatureFromSubclass_4() {
		create('Foo.xtend', '''
			class Foo {
				private def void exec() {}
				def foo() {
					val bar = new Bar
					bar.|exec
				}
			}
			class Bar extends Foo {
			}
		''')
		.assertIssueCodes(FEATURE_NOT_VISIBLE)
		.assertResolutionLabels("Add cast to Foo.")
	}

	@Test
	def void privateFeatureFromSubclass_5() {
		create('Foo.xtend', '''
			class Foo {
				private def exec() { "" }
				def foo() {
					#[new Bar].map[|exec]
				}
			}
			class Bar extends Foo {
			}
		''')
		.assertIssueCodes(FEATURE_NOT_VISIBLE)
		.assertResolutionLabels("Add cast to Foo.")
	}

}
