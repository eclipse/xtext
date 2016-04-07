/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.findrefs

import com.google.inject.Inject
import org.eclipse.jdt.core.IField
import org.eclipse.jdt.core.IJavaElement
import org.eclipse.jdt.core.IMethod
import org.eclipse.jdt.core.IType
import org.eclipse.jdt.core.JavaCore
import org.eclipse.jdt.internal.ui.search.SearchUtil
import org.eclipse.search.ui.ISearchQuery
import org.eclipse.search.ui.SearchResultEvent
import org.eclipse.search.ui.text.AbstractTextSearchResult
import org.eclipse.search.ui.text.MatchEvent
import org.eclipse.search.ui.text.RemoveAllEvent
import org.eclipse.ui.IWorkbench
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.xbase.ui.jvmmodel.findrefs.JdtReferenceFinder
import org.eclipse.xtext.xbase.ui.jvmmodel.findrefs.JvmModelFindReferenceHandler
import org.junit.After
import org.junit.Before
import org.junit.Test

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*

class JdtFindReferencesTest extends AbstractXtendUITestCase {
	
	@Inject extension WorkbenchTestHelper

	@Inject extension JdtReferenceFinder 

	@Inject IWorkbench workbench
	
	@Inject extension JvmModelFindReferenceHandler 
	
	@Before @After def cleanup() {
		_workbenchTestHelper.tearDown
	}
	
	@Test def void testFindClassRef() {
		assertTrue(createFile("Xtend.xtend", "class Xtend { }").exists)
		assertTrue(createFile("JavaRef.java", '''
			public class JavaRef {
				private Xtend x;
				
				public Xtend foo() {
					return null;
				}

				public void bar() {
					new Xtend();
				}

				public void baz() {
					Xtend y;
				}
			}
		'''.toString).exists)
		waitForBuild;
		assertNotNull("Couldn't find 'src/Xtend.xtend'.", project.findMember("/src/Xtend.xtend"))
		assertNotNull("Couldn't find 'src/JavaRef.java'.", project.findMember("/src/JavaRef.java"))
		val member = project.findMember("/xtend-gen/Xtend.java")
		if (member == null) {
			assertNotNull("Couldn't find 'xtend-gen/Xtend.java'.", member)
		}
		var IType type = JavaCore.create(project).findType("Xtend")
		if (type == null) {
			assertNotNull("Couldn't find type 'Xtend'.", type)
		}
		val constructor = type.getMethod("Xtend", newArrayList)
		findReferences(type, constructor) => [
			assertEquals(4, size)
			assertTrue(filter(IField).exists[elementName == 'x'])
			assertTrue(filter(IMethod).exists[elementName == 'foo'])
			assertTrue(filter(IMethod).exists[elementName == 'bar'])
			assertTrue(filter(IMethod).exists[elementName == 'baz'])
		]
	}
	
	@Test def void testFindMethodRef() {
		createFile("Xtend.xtend", "class Xtend { def foo() { 0 }}")
		createFile("JavaRef.java", '''
			public class JavaRef {
				private Xtend x = new Xtend();
				
				private int y = x.foo();
				
				public int bar() {
					return x.foo();
				}
			}
		'''.toString)
		waitForBuild
		val IType type = JavaCore::create(project).findType("Xtend")
		val method = type.getMethod("foo", newArrayList)
		findReferences(method) => [
			assertEquals(2, size)
			assertTrue(exists[it instanceof IField && (it as IField).elementName == 'y'])
			assertTrue(exists[it instanceof IMethod && (it as IMethod).elementName == 'bar'])
		]
	}

	@Test def void testFindFieldRef() {
		createFile("Xtend.xtend", "class Xtend { public int foo = 0 }")
		createFile("JavaRef.java", '''
			public class JavaRef extends Xtend {
				
				private int bar = foo;
				
				public int baz() {
					return foo;
				}
				
				public void fooBar_0() {
					return new Xtend().foo;
				}
				
				public void fooBar_1() {
					return new JavaRef().foo;
				}
			}
		'''.toString)
		waitForBuild
		val IType type = JavaCore::create(project).findType("Xtend")
		val field = type.getField("foo")
		findReferences(field) => [
			assertEquals(4, size)
			assertTrue(exists[it instanceof IField && (it as IField).elementName == 'bar'])
			assertTrue(exists[it instanceof IMethod && (it as IMethod).elementName == 'baz'])
			assertTrue(exists[it instanceof IMethod && (it as IMethod).elementName == 'fooBar_0'])
			assertTrue(exists[it instanceof IMethod && (it as IMethod).elementName == 'fooBar_1'])
		]
	}

	@Test def void testFindPropertyRef() {
		createFile("Xtend.xtend", "class Xtend { @Property public int foo = 0 }")
		createFile("JavaRef.java", '''
			public class JavaRef {
				
				private Xtend x = new Xtend();
				
				private int bar = x.getFoo();
				
				public void baz() {
					x.setFoo(1);
				}
				
				public int fooBar() {
					return x._foo;
				}
			}
		'''.toString)
		waitForBuild
		val IType type = JavaCore::create(project).findType("Xtend")
		val field = type.getField("_foo")
		val getter = type.getMethod("getFoo", newArrayList())
		val setter = type.getMethod("setFoo", newArrayList("I"))
		findReferences(field, getter, setter) => [
			assertEquals(5, size)
			assertTrue(exists[it instanceof IField && (it as IField).elementName == 'bar'])
			assertTrue(exists[it instanceof IMethod && (it as IMethod).elementName == 'baz'])
			assertTrue(exists[it instanceof IMethod && (it as IMethod).elementName == 'fooBar'])
			assertTrue(exists[it instanceof IMethod && (it as IMethod).elementName == 'getFoo'])
			assertTrue(exists[it instanceof IMethod && (it as IMethod).elementName == 'setFoo'])
		]
	}

	@Test def void testDispatchMethodRef() {
		createFile("Xtend.xtend", '''
			class Xtend { 
					def dispatch foo(String x) {}
					def dispatch foo(Number x) {}
			}
		'''.toString)
		createFile("JavaRef.java", '''
			public class JavaRef {
				
				private Xtend x = new Xtend();
				
				public void foo_1() {
					x._foo("");
				}
				
				public void bar() {
					x._foo(1);
				}
				
				public void baz() {
					x.foo(null);
				}
			}
		'''.toString)
		waitForBuild
		val IType type = JavaCore::create(project).findType("Xtend")
		val dispatcher = type.getMethod("foo", newArrayList("QSerializable;"))
		assertTrue(dispatcher.exists)
		val caseMethod = type.getMethod("_foo", newArrayList("QString;"))
		assertTrue(caseMethod.exists)
		findReferences(dispatcher, caseMethod) => [
			assertEquals(3, size)
			assertTrue(exists[it instanceof IMethod && (it as IMethod).elementName == 'foo_1'])
			assertTrue(exists[it instanceof IMethod && (it as IMethod).elementName == 'baz'])
			assertTrue(exists[it instanceof IMethod && (it as IMethod).elementName == 'foo'])
		]
	}
	
	@Test def void testJavaClassRef() {
		createFile("Xtend.xtend", '''
			class Xtend { 
				Java foo
				
				def Java bar() { 
					null
				}

				def void baz() { 
					new Java()
				}
			}
		'''.toString)
		createFile("Java.java", '''
			public class Java {
			}
		'''.toString)
		waitForBuild
		val IType javaType = JavaCore::create(project).findType("Java")
				findReferences(javaType) => [
			assertEquals(3, size)
			assertTrue(exists[it instanceof IField && (it as IField).elementName == 'foo'])
			assertTrue(exists[it instanceof IMethod && (it as IMethod).elementName == 'bar'])
			assertTrue(exists[it instanceof IMethod && (it as IMethod).elementName == 'baz'])
		]
	}

	@Test def void testClassJavaElements() {
		val clazz= xtendFile("Xtend.xtend", '''
			class Xtend {
			}
		'''.toString).xtendTypes.head
		waitForBuild
		getJavaElements(clazz) => [
			assertEquals(1, size)
			assertTrue(exists[it instanceof IType && (it as IType).elementName == 'Xtend'])
		]
	}

	@Test def void testMethodJavaElements() {
		val method = xtendFile("Xtend.xtend", '''
			class Xtend {
				def foo() {
				}
			}
		'''.toString).xtendTypes.filter(typeof(XtendClass)).head.members.head
		waitForBuild
		getJavaElements(method) => [
			assertEquals(1, size)
			assertTrue(exists[it instanceof IMethod && (it as IMethod).elementName == 'foo'])
		]
	}

	@Test def void testFieldJavaElements() {
		val field = xtendFile("Xtend.xtend", '''
			class Xtend {
				int foo
			}
		'''.toString).xtendTypes.filter(typeof(XtendClass)).head.members.head
		waitForBuild
		getJavaElements(field) => [
			assertEquals(1, size)
			assertTrue(exists[it instanceof IField && (it as IField).elementName == 'foo'])
		]
	}
	
	@Test def void testPropertyJavaElements() {
		val field = xtendFile("Xtend.xtend", '''
			class Xtend {
				@Property int foo
			}
		'''.toString).xtendTypes.filter(typeof(XtendClass)).head.members.head
		waitForBuild
		
		getJavaElements(field) => [
			assertEquals(3, size)
			assertTrue(exists[it instanceof IMethod && (it as IMethod).elementName == 'getFoo'])
			assertTrue(exists[it instanceof IMethod && (it as IMethod).elementName == 'setFoo'])
			assertTrue(exists[it instanceof IField && (it as IField).elementName == '_foo'])
		]
	}

	@Test def void testDispatchMethodJavaElements() {
		val method = xtendFile("Xtend.xtend", '''
			class Xtend {
				def dispatch foo(String x) {
				}
			
				def dispatch foo(Number x) {
				}
			}
		'''.toString).xtendTypes.filter(typeof(XtendClass)).head.members.head
		waitForBuild
		getJavaElements(method) => [
			assertEquals(2, size)
			assertTrue(exists[it instanceof IMethod && (it as IMethod).elementName == '_foo'])
			assertTrue(exists[it instanceof IMethod && (it as IMethod).elementName == 'foo'])
		]
	}

	def findReferences(IJavaElement... targets) {
		val ISearchQuery query = createCompositeQuery("test", newArrayList(targets))
		val events = <SearchResultEvent>newArrayList()
		val elements = newArrayList()
		val searchResult = query.searchResult
		val filters = (searchResult as AbstractTextSearchResult).activeMatchFilters
		searchResult.addListener[
			events += it 
			if(it instanceof MatchEvent) {
				val matches = matches.filter[m|filters.forall[!filters(m)]]
				if (kind == MatchEvent::ADDED) {
					for (it : matches) {
						elements += element
					}
				} else {
					for (it : matches) {
						elements.remove(element)
					}
				}
			}
		]
		SearchUtil::runQueryInForeground(workbench.activeWorkbenchWindow, query)
		assertTrue(events.head instanceof RemoveAllEvent)
		for(event: events.tail)
			assertTrue(event instanceof MatchEvent)
		elements
	}
	
	@Test def void testBug387230() {
		val cls = xtendFile("Xtend.xtend", "@Data class Xtend { String field }").xtendTypes.filter(typeof(XtendClass)).head
		waitForBuild
		getJavaElements(cls) => [
			assertEquals(2, size)
			assertTrue(exists[it instanceof IType && (it as IType).elementName == 'Xtend'])
			assertTrue(exists[it instanceof IMethod && (it as IMethod).elementName == 'Xtend'])
		]
	}
}
