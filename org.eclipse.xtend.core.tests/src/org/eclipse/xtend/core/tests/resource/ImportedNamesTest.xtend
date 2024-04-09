/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.resource

import com.google.inject.Inject
import java.util.Comparator
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtext.resource.IResourceDescription
import org.junit.Assert
import org.junit.Test

class ImportedNamesTest extends AbstractXtendTestCase {
	@Inject
	IResourceDescription.Manager resourceDescriptionManager
	
	val primitives = #["boolean", "int", "char", "byte", "short", "long", "float", "double", "void"]
		
	@Test
	def void testPrimitivesNotIncluded () {
		val file = this.file('''
			package testPackage
			
			import hubbabubba.*
			import java.util.*
			
			class TestCase {
				String x;
				int i;
				boolean b;
				char c;
				short s;
				long l;
				byte t;
				float f;
				double d;
				
				List<Object> l;
				
				def void foo() {
					if (x == i == b == c == s == l == t == f == d) {
						println("never happens")
					}
				}
			}
		''')
		val description = resourceDescriptionManager.getResourceDescription(file.eResource)
//		println(description.getImportedNames.toString().replace(',','\n'))
		assertFalse(description.importedNames.exists[ primitives.contains(it.lastSegment) ]);
	}
	
	@Test
	def void testExtendedInterfaces() {
		val file = file('''
			package foo
			
			import java.util.List
			
			class Foo implements List {
			
			}
		''')
		val description = resourceDescriptionManager.getResourceDescription(file.eResource)
		val importedNames = description.importedNames
		assertTrue('' + importedNames, importedNames.exists[it.lastSegment.equals('collection')]);
	}
	
	@Test
	def void testAnonymousClass() {
		val file = file('''
			package foo
			
			class Foo {
				val foo = new Runnable() {
					override run() {}
				}
			}
		''')
		val description = resourceDescriptionManager.getResourceDescription(file.eResource)
		val importedNames = description.importedNames
		assertTrue('' + importedNames, importedNames.exists[it.lastSegment.equals('runnable')]);
	}
	
	@Test
	def void testNestedTypesIncluded() {
		val file = file('''
			package foo
			
			class Foo {
				val foo = types.StaticOuterClass.StaticMiddleClass.StaticInnerClass.CONSTANT
			}
		''')
		val description = resourceDescriptionManager.getResourceDescription(file.eResource)
		val importedNames = description.importedNames
		assertTrue('' + importedNames, importedNames.exists[toString == 'types.StaticOuterClass$StaticMiddleClass$StaticInnerClass'.toLowerCase]);
	}
	
	@Test
	def void testNestedTypesIncludedOnUnresolvedFeatures() {
		val file = file('''
			package foo
			
			class Foo {
				val foo = types.StaticOuterClass.Unknown.StaticInnerClass.CONSTANT
			}
		''')
		val description = resourceDescriptionManager.getResourceDescription(file.eResource)
		val importedNames = description.importedNames
		assertTrue('' + importedNames, importedNames.exists[toString == 'types.StaticOuterClass$Unknown'.toLowerCase]);
	}
	
	@Test
	def void testNestedTypesIncludedOnUnresolvedFeatures_02() {
		val file = file('''
			package foo
			
			class Foo {
				val foo = types.StaticOuterClass.StaticMiddleClass.Unknown
			}
		''')
		val description = resourceDescriptionManager.getResourceDescription(file.eResource)
		val importedNames = description.importedNames
		assertTrue('' + importedNames, importedNames.exists[toString == 'types.StaticOuterClass$StaticMiddleClass$Unknown'.toLowerCase]);
	}
	
	@Test
	def void testExhaustiveList() {
		val file = file('''
			package my.pack
			
			import java.util.Map;
			import java.util.AbstractMap.*;
			
			class C {
				val list = new testdata.stubs.StubbedArrayList<Map.Entry>
				val entry = new SimpleEntry(null, null)
				val int i = 0
			}
		''', true)
		val description = resourceDescriptionManager.getResourceDescription(file.eResource)
		val importedNames = description.importedNames
		Assert.assertEquals('''
				java.io.serializable
				java.lang.cloneable
				java.lang.iterable
				java.lang.object
				java.lang.testdata$stubs$stubbedarraylist
				java.util.abstractcollection
				java.util.abstractmap
				java.util.abstractmap.simpleentry
				java.util.abstractmap.testdata$stubs$stubbedarraylist
				java.util.abstractmap$simpleentry
				java.util.abstractmap$testdata$stubs$stubbedarraylist
				java.util.collection
				java.util.map
				java.util.map$entry
				java.util.randomaccess
				java.util$abstractmap$testdata$stubs$stubbedarraylist
				java$util$abstractmap$testdata$stubs$stubbedarraylist
				my.pack.c
				my.pack.testdata$stubs$stubbedarraylist
				org.eclipse.xtext.xbase.lib.testdata$stubs$stubbedarraylist
				testdata.stubs.stubbedabstractlist
				testdata.stubs.stubbedarraylist
				testdata.stubs.stubbedlist'''.toString.replace("\r", ""),
				importedNames.toList.sortWith(Comparator.naturalOrder).join("\n"));
	}
}