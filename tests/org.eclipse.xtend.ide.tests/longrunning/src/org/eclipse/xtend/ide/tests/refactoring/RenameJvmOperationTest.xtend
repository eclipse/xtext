/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.refactoring

import com.google.inject.Inject
import org.eclipse.jdt.core.IField
import org.eclipse.jdt.core.IMethod
import org.eclipse.jdt.core.IType
import org.eclipse.jdt.core.JavaCore
import org.eclipse.jdt.ui.refactoring.RenameSupport
import org.eclipse.ui.IWorkbench
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.common.types.ui.refactoring.participant.CompositeRefactoringProcessor
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil
import org.junit.Test
import org.junit.Ignore

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class RenameJvmOperationTest extends AbstractXtendUITestCase {

	@Inject
	SyncUtil syncUtil

	@Inject
	IWorkbench workbench

	@Inject
	extension FileAsserts

	@Inject
	extension WorkbenchTestHelper testHelper

	@Inject
	CompositeRefactoringProcessor.Access compositeRefactoringProcessorAccess

	override tearDown() throws Exception {
		testHelper.tearDown
		super.tearDown()
	}

	@Test def void renameUnusedMethod() {
		renameUnusedMethod(false)
	}

	@Test def void renameUnusedMethod_2() {
		renameUnusedMethod(true)
	}

	def void renameUnusedMethod(boolean ^extension) {
		'foo/Foo.java'.createFile(
			'''
				package foo;
				
				public class Foo {
				
					public static void foo() {}
				
				}
			''')

		val xtendFile = 'bar/Bar.xtend'.createFile(
			'''
				package bar
				
				import static «IF extension»extension «ENDIF»foo.Foo.foo
				
				class Bar {}
			''')

		'foo.Foo'.findJavaType.getMethod("foo", #[]).renameJavaElement("newFoo")

		xtendFile.assertFileContains(
			'''
				package bar
				
				import static «IF extension»extension «ENDIF»foo.Foo.newFoo
				
				class Bar {}
			''')
	}

	@Test def void renameSingleMethod() {
		renameSingleMethod(false, false, false)
	}

	@Test def void renameSingleMethod_2() {
		renameSingleMethod(false, true, false)
	}

	@Test def void renameSingleMethod_3() {
		renameSingleMethod(false, true, true)
	}

	@Test def void renameSingleMethod_4() {
		renameSingleMethod(true, false, false)
	}

	@Test def void renameSingleMethod_5() {
		renameSingleMethod(true, true, false)
	}

	@Test def void renameSingleMethod_6() {
		renameSingleMethod(true, true, true)
	}

	def void renameSingleMethod(boolean wildcard, boolean ^extension, boolean extensionAccess) {
		assertTrue('extension access is not possible without extension import', extension || !extensionAccess)

		'foo/Foo.java'.createFile(
			'''
				package foo;
				
				public class Foo {
				
					public static void foo(int i) {}
				
				}
			''')

		val xtendFile = 'bar/Bar.xtend'.createFile(
			'''
				package bar
				
				import static «IF extension»extension «ENDIF»foo.Foo.«IF wildcard»*«ELSE»foo«ENDIF»
				
				class Bar {
				
					def bar() {
						«IF extensionAccess»1.foo«ELSE»foo(1)«ENDIF»
					}
				
				}
			''')

		'foo.Foo'.findJavaType.getMethod("foo", #["I"]).renameJavaElement("newFoo")

		xtendFile.assertFileContains(
			'''
				package bar
				
				import static «IF extension»extension «ENDIF»foo.Foo.«IF wildcard»*«ELSE»newFoo«ENDIF»
				
				class Bar {
				
					def bar() {
						«IF extensionAccess»1.newFoo«ELSE»newFoo(1)«ENDIF»
					}
				
				}
			''')
	}

	@Test def void renameOverloadedMethod() {
		renameOverloadedMethod(false, false, false)
	}

	@Test def void renameOverloadedMethod_2() {
		renameOverloadedMethod(false, true, false)
	}

	@Test def void renameOverloadedMethod_3() {
		renameOverloadedMethod(false, true, true)
	}

	@Test def void renameOverloadedMethod_4() {
		renameOverloadedMethod(true, false, false)
	}

	@Test def void renameOverloadedMethod_5() {
		renameOverloadedMethod(true, true, false)
	}

	@Test def void renameOverloadedMethod_6() {
		renameOverloadedMethod(true, true, true)
	}

	def void renameOverloadedMethod(boolean wildcard, boolean ^extension, boolean extensionAccess) {
		assertTrue('extension access is not possible without extension import', extension || !extensionAccess)
		
		'foo/Foo.java'.createFile(
			'''
				package foo;
				
				public class Foo {
				
					public static void foo(int i) {}
					
					public static void foo(String i) {}
				
				}
			''')

		val xtendFile = 'bar/Bar.xtend'.createFile(
			'''
				package bar
				
				import static «IF extension»extension «ENDIF»foo.Foo.«IF wildcard»*«ELSE»foo«ENDIF»
				
				class Bar {
				
					def withInteger() {
						«IF extensionAccess»1.foo«ELSE»foo(1)«ENDIF»
					}
				
					def withString() {
						«IF extensionAccess»"lalala".foo«ELSE»foo("lalala")«ENDIF»
					}
				
				}
			''')

		'foo.Foo'.findJavaType.getMethod("foo", #["I"]).renameJavaElement("newFoo")

		xtendFile.assertFileContains(
			'''
				package bar
				
				«IF wildcard»
				import static «IF extension»extension «ENDIF»foo.Foo.*
				«ELSE»
				import static «IF extension»extension «ENDIF»foo.Foo.foo
				import static «IF extension»extension «ENDIF»foo.Foo.newFoo
				«ENDIF»
				
				class Bar {
				
					def withInteger() {
						«IF extensionAccess»1.newFoo«ELSE»newFoo(1)«ENDIF»
					}
				
					def withString() {
						«IF extensionAccess»"lalala".foo«ELSE»foo("lalala")«ENDIF»
					}
				
				}
			''')
	}
	
	@Ignore
	@Test def void renameToOverloadedImport() {
		renameToOverloadedImport(false, false, false, false)
	}
	
	@Ignore
	@Test def void renameToOverloadedImport_2() {
		renameToOverloadedImport(false, false, true, false)
	}
	
	@Ignore
	@Test def void renameToOverloadedImport_3() {
		renameToOverloadedImport(false, false, true, true)
	}
	
	@Ignore
	@Test def void renameToOverloadedImport_4() {
		renameToOverloadedImport(true, false, false, false)
	}
	
	@Ignore
	@Test def void renameToOverloadedImport_5() {
		renameToOverloadedImport(true, false, true, false)
	}
	
	@Ignore
	@Test def void renameToOverloadedImport_6() {
		renameToOverloadedImport(true, false, true, true)
	}
	
	@Ignore
	@Test def void renameToOverloadedImport_7() {
		renameToOverloadedImport(true, true, false, false)
	}
	
	@Ignore
	@Test def void renameToOverloadedImport_8() {
		renameToOverloadedImport(true, true, true, false)
	}
	
	@Ignore
	@Test def void renameToOverloadedImport_9() {
		renameToOverloadedImport(true, true, true, true)
	}

	def void renameToOverloadedImport(boolean ^extension, boolean extensionAccess, boolean ^extension2, boolean extensionAccess2) {
		assertTrue('extension access is not possible without extension import', extension || !extensionAccess)
		assertTrue('extension access is not possible without extension import', ^extension2 || !extensionAccess2)
		
		'foo/Foo.java'.createFile(
			'''
				package foo;
				
				public class Foo {
				
					public static void newFoo(int i) {}
					
					public static void foo(String i) {}
				
				}
			''')

		val xtendFile = 'bar/Bar.xtend'.createFile(
			'''
				package bar
				
				import static «IF extension»extension «ENDIF»foo.Foo.foo
				import static «IF extension2»extension «ENDIF»foo.Foo.newFoo
				
				class Bar {
				
					def withInteger() {
						«IF extensionAccess2»1.newFoo«ELSE»newFoo(1)«ENDIF»
					}
				
					def withString() {
						«IF extensionAccess»"lalala".foo«ELSE»foo("lalala")«ENDIF»
					}
				
				}
			''')

		'foo.Foo'.findJavaType.getMethod("newFoo", #["I"]).renameJavaElement("foo")

		xtendFile.assertFileContains(
			'''
				package bar
				
				import static «IF extension || extension2»extension «ENDIF»foo.Foo.foo
				
				class Bar {
				
					def withInteger() {
						«IF extensionAccess2»1.foo«ELSE»foo(1)«ENDIF»
					}
				
					def withString() {
						«IF extensionAccess»"lalala".foo«ELSE»foo("lalala")«ENDIF»
					}
				
				}
			''')
	}
	
	@Test def void renameFeatureNameConflicts() {
		renameFeatureNameConflicts(false, false, false, false)
	}
	
	@Test def void renameFeatureNameConflicts_2() {
		renameFeatureNameConflicts(false, false, true, false)
	}
	
	@Test def void renameFeatureNameConflicts_3() {
		renameFeatureNameConflicts(false, false, true, true)
	}
	
	@Test def void renameFeatureNameConflicts_4() {
		renameFeatureNameConflicts(true, false, false, false)
	}
	
	@Test def void renameFeatureNameConflicts_5() {
		renameFeatureNameConflicts(true, false, true, false)
	}
	
	@Test def void renameFeatureNameConflicts_6() {
		renameFeatureNameConflicts(true, false, true, true)
	}
	
	@Test def void renameFeatureNameConflicts_7() {
		renameFeatureNameConflicts(true, true, false, false)
	}
	
	@Ignore("Invalid extension access")
	@Test def void renameFeatureNameConflicts_8() {
		renameFeatureNameConflicts(true, true, true, false)
	}
	
	@Ignore("Invalid extension access")
	@Test def void renameFeatureNameConflicts_9() {
		renameFeatureNameConflicts(true, true, true, true)
	}

	def void renameFeatureNameConflicts(boolean ^extension, boolean extensionAccess, boolean ^extension2, boolean extensionAccess2) {
		assertTrue('extension access is not possible without extension import', extension || !extensionAccess)
		assertTrue('extension access is not possible without extension import', extension2 || !extensionAccess2)
		
		'a/A.java'.createFile(
			'''
				package a;
				
				public class A {
				
					public static void a(int i) {}
				
				}
			''')

		'b/B.java'.createFile(
			'''
				package b;
				
				public class B {
				
					public static void b(int i) {}
				
				}
			''')

		val xtendFile = 'bar/Bar.xtend'.createFile(
			'''
				package bar
				
				import static «IF extension2»extension «ENDIF»a.A.a
				import static «IF extension»extension «ENDIF»b.B.b
				
				class Bar {
				
					def withA() {
						«IF extensionAccess2»1.a«ELSE»a(1)«ENDIF»
					}
				
					def withB() {
						«IF extensionAccess»1.b«ELSE»b(1)«ENDIF»
					}
				
				}
			''')

		'b.B'.findJavaType.getMethod("b", #["I"]).renameJavaElement("a")

		xtendFile.assertFileContains(
			'''
				package bar
				
				import static «IF extension2»extension «ENDIF»a.A.a
				«IF extension == extension2 || extensionAccess == extensionAccess2»
				import b.B
				«ELSE»
				import static «IF extensionAccess»extension «ENDIF»b.B.a
				«ENDIF»
				
				class Bar {
				
					def withA() {
						«IF extensionAccess2»1.a«ELSE»a(1)«ENDIF»
					}
				
					def withB() {
						«IF extension == extension2 || extensionAccess == extensionAccess2»
						B.a(1)
						«ELSE»
						«IF extensionAccess»1.a«ELSE»a(1)«ENDIF»
						«ENDIF»
					}
				
				}
			''')
	}

	@Test def void renameTypeNameConflict() {
		'a/A.java'.createFile(
			'''
				package a;
				
				public class A {
				
					public static void a(int i) {}
				
				}
			''')

		'b/B.java'.createFile(
			'''
				package b;
				
				public class B {
				
					public static void b(int i) {}
				
				}
			''')

		'c/B.java'.createFile(
			'''
				package b;
				
				public class B {}
			''')

		val xtendFile = 'bar/Bar.xtend'.createFile(
			'''
				package bar
				
				import static a.A.a
				import static b.B.b
				import c.B
				
				class Bar {
				
					def withA() {
						a(1)
					}
				
					def withB() {
						b(1)
					}
				
				}
			''')

		'b.B'.findJavaType.getMethod("b", #["I"]).renameJavaElement("a")

		xtendFile.assertFileContains(
			'''
				package bar
				
				import static a.A.a
				import c.B
				
				class Bar {
				
					def withA() {
						a(1)
					}
				
					def withB() {
						b.B.a(1)
					}
				
				}
			''')
	}

	@Test def void renameTypeNameConflict_2() {
		'a/A.java'.createFile(
			'''
				package a;
				
				public class A {
				
					public static void a(int i) {}
				
				}
			''')

		'b/B.java'.createFile(
			'''
				package b;
				
				public class B {
				
					public static void b(int i) {}
				
				}
			''')

		val xtendFile = 'bar/Bar.xtend'.createFile(
			'''
				package bar
				
				import static a.A.a
				import static b.B.b
				import b.B
				
				class Bar {
				
					def withA() {
						a(1)
					}
				
					def withB() {
						b(1)
					}
				
				}
			''')

		'b.B'.findJavaType.getMethod("b", #["I"]).renameJavaElement("a")

		xtendFile.assertFileContains(
			'''
				package bar
				
				import static a.A.a
				import b.B
				
				class Bar {
				
					def withA() {
						a(1)
					}
				
					def withB() {
						B.a(1)
					}
				
				}
			''')
	}

	@Test def void renameTypeNameConflict_3() {
		'a/A.java'.createFile(
			'''
				package a;
				
				public class A {
				
					public static void a(int i) {}
				
				}
			''')

		'b/B.java'.createFile(
			'''
				package b;
				
				public class B {
					
					public static class D {
				
						public static void d(int i) {}
				
					}
				
				}
			''')
			
		'd/D.java'.createFile(
			'''
				package d;
				
				public class D {}
			''')

		val xtendFile = 'bar/Bar.xtend'.createFile(
			'''
				package bar
				
				import static a.A.a
				import static b.B.D.d
				import d.D
				
				class Bar {
				
					def withA() {
						a(1)
					}
				
					def withD() {
						d(1)
					}
				
				}
			''')

		'b.B.D'.findJavaType.getMethod("d", #["I"]).renameJavaElement("a")

		xtendFile.assertFileContains(
			'''
				package bar
				
				import static a.A.a
				import d.D
				import b.B
				
				class Bar {
				
					def withA() {
						a(1)
					}
				
					def withD() {
						B.D.a(1)
					}
				
				}
			''')
	}

	@Test def void renameTypeNameConflict_4() {
		'a/A.java'.createFile(
			'''
				package a;
				
				public class A {
				
					public static void a(int i) {}
				
				}
			''')

		'b/B.java'.createFile(
			'''
				package b;
				
				public class B {
					
					public static class D {
				
						public static void d(int i) {}
				
					}
				
				}
			''')

		val xtendFile = 'bar/Bar.xtend'.createFile(
			'''
				package bar
				
				import static a.A.a
				import static b.B.D.d
				import b.B
				
				class Bar {
				
					def withA() {
						a(1)
					}
				
					def withD() {
						d(1)
					}
				
				}
			''')

		'b.B.D'.findJavaType.getMethod("d", #["I"]).renameJavaElement("a")

		xtendFile.assertFileContains(
			'''
				package bar
				
				import static a.A.a
				import b.B
				import b.B.D
				
				class Bar {
				
					def withA() {
						a(1)
					}
				
					def withD() {
						D.a(1)
					}
				
				}
			''')
	}

	@Test def void renameTypeNameConflict_5() {
		'a/A.java'.createFile(
			'''
				package a;
				
				public class A {
				
					public static void a(int i) {}
				
				}
			''')

		'b/B.java'.createFile(
			'''
				package b;
				
				public class B {
					
					public static class D {
				
						public static void d(int i) {}
				
					}
				
				}
			''')

		val xtendFile = 'bar/Bar.xtend'.createFile(
			'''
				package bar
				
				import static a.A.a
				import static b.B.D.d
				import b.B.D
				
				class Bar {
				
					def withA() {
						a(1)
					}
				
					def withD() {
						d(1)
					}
				
				}
			''')

		'b.B.D'.findJavaType.getMethod("d", #["I"]).renameJavaElement("a")

		xtendFile.assertFileContains(
			'''
				package bar
				
				import static a.A.a
				import b.B.D
				
				class Bar {
				
					def withA() {
						a(1)
					}
				
					def withD() {
						D.a(1)
					}
				
				}
			''')
	}

	def findJavaType(String typeName) throws Exception {
		syncUtil.totalSync(false)
		JavaCore.create(testHelper.project).findType(typeName)
	}

	def void renameJavaElement(IType javaElement, String newName) throws Exception {
		syncUtil.totalSync(false)
		val renameSupport = RenameSupport.create(javaElement, newName, RenameSupport.UPDATE_REFERENCES)
		renameSupport.perform(workbench.activeWorkbenchWindow.shell, workbench.activeWorkbenchWindow)
		syncUtil.totalSync(false)
		assertTrue(compositeRefactoringProcessorAccess.disposed)
	}

	def void renameJavaElement(IMethod javaElement, String newName) throws Exception {
		syncUtil.totalSync(false)
		val renameSupport = RenameSupport.create(javaElement, newName, RenameSupport.UPDATE_REFERENCES)
		renameSupport.perform(workbench.activeWorkbenchWindow.shell, workbench.activeWorkbenchWindow)
		syncUtil.totalSync(false);
		assertTrue(compositeRefactoringProcessorAccess.disposed)
	}

	def void renameJavaElement(IField javaElement, String newName) throws Exception {
		syncUtil.totalSync(false)
		val renameSupport = RenameSupport.create(javaElement, newName, RenameSupport.UPDATE_REFERENCES)
		renameSupport.perform(workbench.activeWorkbenchWindow.shell, workbench.activeWorkbenchWindow)
		syncUtil.totalSync(false);
		assertTrue(compositeRefactoringProcessorAccess.disposed)
	}

}


