/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.compiler

import com.google.inject.Inject
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.junit.After
import org.junit.Before
import org.junit.Test

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IResource
import org.eclipse.ui.texteditor.MarkerUtilities

/**
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=473833
 * 
 * @author efftinge - Initial contribution and API
 */
class Bug473833Test extends AbstractXtendUITestCase {
	
	@Inject 
	private WorkbenchTestHelper workbenchTestHelper;
	
	@Before @After def void cleanUp() {
		workbenchTestHelper.tearDown
	}
	
	@Test def void testInheritedNestedTypes_01() {
		workbenchTestHelper.createFile('somePackage/Outer.xtend', '''
			package somePackage
			
			class Outer {
			  static class Inner {}
			}
		''')
		workbenchTestHelper.createFile('somePackage/Outer2.xtend', '''
			package somePackage
			
			class Outer2 extends Outer {
			}
		''')
		val file = workbenchTestHelper.createFile('myPackage/MyClass.xtend', '''
			package myPackage
			
			import somePackage.Outer2.Inner
			
			class AnonymousClassTest extends Inner {
			  Inner inner
			}
		''')
		waitForBuild()
		file.assertNoErrors
	}
	
	@Test def void testInheritedNestedTypes_02() {
		workbenchTestHelper.createFile('somePackage/Outer.xtend', '''
			package somePackage
			
			class Outer {
			  static class Inner {
			  	static class MoreInner {}
			  }
			}
		''')
		workbenchTestHelper.createFile('somePackage/Outer2.xtend', '''
			package somePackage
			
			class Outer2 extends Outer {
			}
		''')
		val file = workbenchTestHelper.createFile('myPackage/MyClass.xtend', '''
			package myPackage
			
			import somePackage.Outer2.Inner.MoreInner
			
			class AnonymousClassTest extends MoreInner {
			  MoreInner moreInner
			}
		''')
		waitForBuild()
		file.assertNoErrors
	}
	
	@Test def void testInheritedNestedTypes_03() {
		workbenchTestHelper.createFile('somePackage/Outer.xtend', '''
			package somePackage
			
			class Outer {
			  static class Inner implements Foo{}
			}
			
			interface Foo {
				static interface InnerFoo {}
			}
		''')
		workbenchTestHelper.createFile('somePackage/Outer2.xtend', '''
			package somePackage
			
			class Outer2 extends Outer {
			}
		''')
		val file = workbenchTestHelper.createFile('myPackage/MyClass.xtend', '''
			package myPackage
			
			import somePackage.Outer2.Inner.InnerFoo
			
			class AnonymousClassTest implements InnerFoo {
			  InnerFoo inner
			}
		''')
		waitForBuild()
		file.assertNoErrors
	}
	
	@Test def void testInheritedNestedTypes_withJava() {
		workbenchTestHelper.createFile('somePackage/Outer.java', '''
			package somePackage;
			
			public class Outer {
			  public static class Inner implements Foo {}
			}
		''')
		workbenchTestHelper.createFile('somePackage/Foo.java', '''
			package somePackage;
			
			public interface Foo {
			  public static interface InnerFoo {}
			}
		''')
		workbenchTestHelper.createFile('somePackage/Outer2.xtend', '''
			package somePackage
			
			class Outer2 extends Outer {
			}
		''')
		val file = workbenchTestHelper.createFile('myPackage/MyClass.xtend', '''
			package myPackage
			
			import somePackage.Outer2.Inner.InnerFoo
			
			class AnonymousClassTest implements InnerFoo {
			  InnerFoo inner
			}
		''')
		waitForBuild()
		file.assertNoErrors
	}
	
	private def void assertNoErrors(IFile file) {
		val findMarkers = file.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE)
		for (iMarker : findMarkers) {
			assertFalse(MarkerUtilities.getMessage(iMarker), MarkerUtilities.getSeverity(iMarker) == IMarker::SEVERITY_ERROR)
		}
	}
}