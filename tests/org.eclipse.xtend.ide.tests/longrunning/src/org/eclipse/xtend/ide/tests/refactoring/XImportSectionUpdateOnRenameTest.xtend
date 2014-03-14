/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.refactoring

import com.google.inject.Inject
import org.eclipse.core.runtime.NullProgressMonitor
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
import org.junit.Ignore
import org.junit.Test

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class XImportSectionUpdateOnRenameTest extends AbstractXtendUITestCase {

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

	@Test def void renameUnusedType() {
		try {
			'foo/Foo.java'.createFile(
				'''
					package foo;
					
					public class Foo {}
				''')

			val xtendFile = 'bar/Bar.xtend'.createFile(
				'''
					package bar
					
					import foo.Foo
					
					class Bar {}
				''')

			'foo.Foo'.findJavaType.renameJavaElement("NewFoo")

			xtendFile.assertFileContains(
				'''
					package bar
					
					import foo.NewFoo
					
					class Bar {}
				''')
		} finally {
			project.getFile("src/foo/NewFoo.java").delete(true, new NullProgressMonitor)
		}
	}

	@Ignore
	@Test def void renameUnusedType_2() {
		try {
			'foo/Foo.java'.createFile(
				'''
					package foo;
					
					public class Foo {}
				''')

			val xtendFile = 'bar/Bar.xtend'.createFile(
				'''
					package bar
					
					import foo.Foo.*
					
					class Bar {}
				''')

			'foo.Foo'.findJavaType.renameJavaElement("NewFoo")

			xtendFile.assertFileContains(
				'''
					package bar
					
					import foo.NewFoo.*
					
					class Bar {}
				''')
		} finally {
			project.getFile("src/foo/NewFoo.java").delete(true, new NullProgressMonitor)
		}
	}

	@Test def void renameUnusedType_3() {
		try {
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
					
					import static foo.Foo.foo
					
					class Bar {}
				''')

			'foo.Foo'.findJavaType.renameJavaElement("NewFoo")

			xtendFile.assertFileContains(
				'''
					package bar
					
					import static foo.NewFoo.foo
					
					class Bar {}
				''')
		} finally {
			project.getFile("src/foo/NewFoo.java").delete(true, new NullProgressMonitor)
		}
	}

	@Test def void renameUnusedType_4() {
		try {
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
					
					import static extension foo.Foo.foo
					
					class Bar {}
				''')

			'foo.Foo'.findJavaType.renameJavaElement("NewFoo")

			xtendFile.assertFileContains(
				'''
					package bar
					
					import static extension foo.NewFoo.foo
					
					class Bar {}
				''')
		} finally {
			project.getFile("src/foo/NewFoo.java").delete(true, new NullProgressMonitor)
		}
	}

	@Test def void renameUnusedType_5() {
		try {
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
					
					import static foo.Foo.*
					
					class Bar {}
				''')

			'foo.Foo'.findJavaType.renameJavaElement("NewFoo")

			xtendFile.assertFileContains(
				'''
					package bar
					
					import static foo.NewFoo.*
					
					class Bar {}
				''')
		} finally {
			project.getFile("src/foo/NewFoo.java").delete(true, new NullProgressMonitor)
		}
	}

	@Test def void renameUnusedType_6() {
		try {
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
					
					import static extension foo.Foo.*
					
					class Bar {}
				''')

			'foo.Foo'.findJavaType.renameJavaElement("NewFoo")

			xtendFile.assertFileContains(
				'''
					package bar
					
					import static extension foo.NewFoo.*
					
					class Bar {}
				''')
		} finally {
			project.getFile("src/foo/NewFoo.java").delete(true, new NullProgressMonitor)
		}
	}
	
	@Test def void renameUnusedField() {
		'foo/Foo.java'.createFile(
			'''
				package foo;
				
				public class Foo {
				
					public static String foo;
				
				}
			''')

		val xtendFile = 'bar/Bar.xtend'.createFile(
			'''
				package bar
				
				import static foo.Foo.foo
				
				class Bar {}
			''')

		'foo.Foo'.findJavaType.getField("foo").renameJavaElement("newFoo")

		xtendFile.assertFileContains(
			'''
				package bar
				
				import static foo.Foo.newFoo
				
				class Bar {}
			''')
	}

	@Test def void renameUnusedField_2() {
		'foo/Foo.java'.createFile(
			'''
				package foo;
				
				public class Foo {
				
					public static String foo;
				
				}
			''')

		val xtendFile = 'bar/Bar.xtend'.createFile(
			'''
				package bar
				
				import static extension foo.Foo.foo
				
				class Bar {}
			''')

		'foo.Foo'.findJavaType.getField("foo").renameJavaElement("newFoo")

		xtendFile.assertFileContains(
			'''
				package bar
				
				import static extension foo.Foo.newFoo
				
				class Bar {}
			''')
	}

	@Test def void renameUsedType() {
		try {
			'foo/Foo.java'.createFile(
				'''
					package foo;
					
					public class Foo {}
				''')

			val xtendFile = 'bar/Bar.xtend'.createFile(
				'''
					package bar
					
					import foo.Foo
					
					class Bar extends Foo {}
				''')

			'foo.Foo'.findJavaType.renameJavaElement("NewFoo")

			xtendFile.assertFileContains(
				'''
					package bar
					
					import foo.NewFoo
					
					class Bar extends NewFoo {}
				''')
		} finally {
			project.getFile("src/foo/NewFoo.java").delete(true, new NullProgressMonitor)
		}
	}

	@Ignore
	@Test def void renameUsedType_2() {
		try {
			'foo/Foo.java'.createFile(
				'''
					package foo;
					
					public class Foo {

						public static class Inner {}
					
					}
				''')

			val xtendFile = 'bar/Bar.xtend'.createFile(
				'''
					package bar
					
					import foo.Foo.*
					
					class Bar extends Inner {}
				''')

			'foo.Foo'.findJavaType.renameJavaElement("NewFoo")

			xtendFile.assertFileContains(
				'''
					package bar
					
					import foo.NewFoo.*
					
					class Bar extends Inner {}
				''')
		} finally {
			project.getFile("src/foo/NewFoo.java").delete(true, new NullProgressMonitor)
		}
	}

	@Test def void renameUsedType_3() {
		try {
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
					
					import static foo.Foo.foo
					
					class Bar {
					
						def bar() {
							foo(1)
						}
					
					}
				''')

			'foo.Foo'.findJavaType.renameJavaElement("NewFoo")

			xtendFile.assertFileContains(
				'''
					package bar
					
					import static foo.NewFoo.foo
					
					class Bar {
					
						def bar() {
							foo(1)
						}
					
					}
				''')
		} finally {
			project.getFile("src/foo/NewFoo.java").delete(true, new NullProgressMonitor)
		}
	}

	@Test def void renameUsedType_4() {
		try {
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
					
					import static extension foo.Foo.foo
					
					class Bar {
					
						def bar() {
							1.foo
						}
					
					}
				''')

			'foo.Foo'.findJavaType.renameJavaElement("NewFoo")

			xtendFile.assertFileContains(
				'''
					package bar
					
					import static extension foo.NewFoo.foo
					
					class Bar {
					
						def bar() {
							1.foo
						}
					
					}
				''')
		} finally {
			project.getFile("src/foo/NewFoo.java").delete(true, new NullProgressMonitor)
		}
	}

	@Test def void renameUsedType_5() {
		try {
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
					
					import static foo.Foo.*
					
					class Bar {
					
						def bar() {
							foo(1)
						}
					
					}
				''')

			'foo.Foo'.findJavaType.renameJavaElement("NewFoo")

			xtendFile.assertFileContains(
				'''
					package bar
					
					import static foo.NewFoo.*
					
					class Bar {
					
						def bar() {
							foo(1)
						}
					
					}
				''')
		} finally {
			project.getFile("src/foo/NewFoo.java").delete(true, new NullProgressMonitor)
		}
	}

	@Test def void renameUsedType_6() {
		try {
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
					
					import static extension foo.Foo.*
					
					class Bar {
					
						def bar() {
							1.foo
						}
					
					}
				''')

			'foo.Foo'.findJavaType.renameJavaElement("NewFoo")

			xtendFile.assertFileContains(
				'''
					package bar
					
					import static extension foo.NewFoo.*
					
					class Bar {
					
						def bar() {
							1.foo
						}
					
					}
				''')
		} finally {
			project.getFile("src/foo/NewFoo.java").delete(true, new NullProgressMonitor)
		}
	}
	
	@Ignore
	@Test def void renameUsedType_7() {
		try {
			'a/A.java'.createFile(
				'''
					package a;
					
					public class A {}
				''')
				
			'b/B.java'.createFile(
				'''
					package b;
					
					public class B {}
				''')

			val xtendFile = 'foo/Foo.xtend'.createFile(
				'''
					package foo
					
					import a.A
					import b.B
					
					class Foo extends A {
					
						def foo() {
							return new B
						}
					
					}
				''')

			'a.A'.findJavaType.renameJavaElement("B")

			xtendFile.assertFileContains(
				'''
					package foo
					
					import b.B
					
					class Foo extends a.B {
					
						def foo() {
							return new B
						}
					
					}
				''')
		} finally {
			project.getFile("src/a/B.java").delete(true, new NullProgressMonitor)
		}
	}
	
	@Ignore
	@Test def void renameUsedType_8() {
		try {
			'a/A.java'.createFile(
				'''
					package a;
					
					public class A {}
				''')
				
			'b/B.java'.createFile(
				'''
					package b;
					
					public class B {}
				''')

			val xtendFile = 'foo/Foo.xtend'.createFile(
				'''
					package foo
					
					import b.B
					import a.A
					
					class Foo extends A {
					
						def foo() {
							return new B
						}
					
					}
				''')

			'a.A'.findJavaType.renameJavaElement("B")

			xtendFile.assertFileContains(
				'''
					package foo
					
					import b.B
					
					class Foo extends a.B {
					
						def foo() {
							return new B
						}
					
					}
				''')
		} finally {
			project.getFile("src/a/B.java").delete(true, new NullProgressMonitor)
		}
	}
	
	@Ignore
	@Test def void renameUsedType_9() {
		try {
			'a/A.java'.createFile(
				'''
					package a;
					
					public class A {}
				''')
				
			'b/B.java'.createFile(
				'''
					package b;
					
					public class B {}
				''')

			val xtendFile = 'foo/Foo.xtend'.createFile(
				'''
					package foo
					
					import a.A
					import b.B
					
					class Foo extends B {
					
						def foo() {
							A
						}
					
					}
				''')

			'a.A'.findJavaType.renameJavaElement("B")

			xtendFile.assertFileContains(
				'''
					package foo
					
					import b.B
					
					class Foo extends B {
					
						def foo() {
							a.B
						}
					
					}
				''')
		} finally {
			project.getFile("src/a/B.java").delete(true, new NullProgressMonitor)
		}
	}
	
	@Ignore
	@Test def void renameUsedType_10() {
		try {
			'a/A.java'.createFile(
				'''
					package a;
					
					public class A {}
				''')
				
			'b/B.java'.createFile(
				'''
					package b;
					
					public class B {}
				''')

			val xtendFile = 'foo/Foo.xtend'.createFile(
				'''
					package foo
					
					import a.A
					import b.B
					
					class Foo extends B {
					
						def foo() {
							new A
						}
					
					}
				''')

			'a.A'.findJavaType.renameJavaElement("B")

			xtendFile.assertFileContains(
				'''
					package foo
					
					import b.B
					
					class Foo extends B {
					
						def foo() {
							new a.B
						}
					
					}
				''')
		} finally {
			project.getFile("src/a/B.java").delete(true, new NullProgressMonitor)
		}
	}

	@Test def void renameUsedField() {
		'foo/Foo.java'.createFile(
			'''
				package foo;
				
				public class Foo {
				
					public static String foo;
				
				}
			''')

		val xtendFile = 'bar/Bar.xtend'.createFile(
			'''
				package bar
				
				import static foo.Foo.foo
				
				class Bar {
				
					def bar() {
						foo
					}
				
				}
			''')

		'foo.Foo'.findJavaType.getField("foo").renameJavaElement("newFoo")

		xtendFile.assertFileContains(
			'''
				package bar
				
				import static foo.Foo.newFoo
				
				class Bar {
				
					def bar() {
						newFoo
					}
				
				}
			''')
	}

	@Test def void renameUsedField_2() {
		'foo/Foo.java'.createFile(
			'''
				package foo;
				
				public class Foo {
				
					public static String foo;
				
				}
			''')

		val xtendFile = 'bar/Bar.xtend'.createFile(
			'''
				package bar
				
				import static extension foo.Foo.foo
				
				class Bar {
				
					def bar() {
						foo
					}
				
				}
			''')

		'foo.Foo'.findJavaType.getField("foo").renameJavaElement("newFoo")

		xtendFile.assertFileContains(
			'''
				package bar
				
				import static extension foo.Foo.newFoo
				
				class Bar {
				
					def bar() {
						newFoo
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
