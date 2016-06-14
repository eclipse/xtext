/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.imports

import com.google.inject.Inject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.xbase.imports.TypeUsageCollector
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class TypeUsageCollectorTest extends AbstractXtendTestCase {
	
	@Inject
	TypeUsageCollector typeUsageCollector
	
	private def void hasUnresolvedType(CharSequence xtendFile, String... typeNames) {
		val resource = file(xtendFile.toString).eResource
		resource.hasUnresolvedType(typeNames)
	}
	
	private def void hasUnresolvedType(Resource resource, String... typeNames) {
		val typeUsages = typeUsageCollector.collectTypeUsages(resource as XtextResource)
		val usedNames = typeUsages.unresolvedTypeUsages.map[it.usedTypeName].toSet
		assertEquals(typeNames.toSet, usedNames)
	}
	
	private def void hasUnresolvedTypesWithErrors(CharSequence xtendFile, String... typeNames) {
		val resource = fileWithErrors(xtendFile.toString).eResource
		resource.hasUnresolvedType(typeNames)
	}
	
	private def void hasUnresolvedTypeSuffix(CharSequence xtendFile, String... suffix) {
		val resource = file(xtendFile.toString).eResource
		val typeUsages = typeUsageCollector.collectTypeUsages(resource as XtextResource)
		val foundSuffix = typeUsages.unresolvedTypeUsages.map[it.suffix].toSet
		assertEquals(suffix.toSet, foundSuffix)
	}
	
	@Test
	def void testSimpleName() {
		'''
			class C implements Serializable {
			}
		'''.hasUnresolvedType('Serializable')
	}
	
	@Test
	def void testNestedType_01() {
		'''
			class C implements Map$Entry {}
		'''.hasUnresolvedType('Map')
	}
	
	@Test
	def void testNestedType_02() {
		'''
			class C implements Map.Entry {}
		'''.hasUnresolvedType('Map')
	}
	
	@Test
	def void testNestedType_03() {
		'''
			class C {
				val entry = Map::Entry::DoesNotMatter
			}
		'''.hasUnresolvedType('Map')
	}
	
	@Test
	def void testNestedType_04() {
		'''
			class C {
				val entry = Map.Entry::DoesNotMatter
			}
		'''.hasUnresolvedType('Map')
	}
	
	@Test
	def void testNestedType_05() {
		'''
			class C {
				val entry = Map$Entry::DoesNotMatter
			}
		'''.hasUnresolvedType('Map')
	}
	
	@Test
	def void testNestedType_06() {
		'''
			class C {
				val entry = new Map.Entry
			}
		'''.hasUnresolvedType('Map')
	}
	
	@Test
	def void testNestedType_07() {
		'''
			class C {
				val entry = new Map$Entry
			}
		'''.hasUnresolvedType('Map')
	}
	
	@Test
	def void testSuffixSimpleName() {
		'''
			class C implements Serializable {
			}
		'''.hasUnresolvedTypeSuffix('')
	}
	
	@Test
	def void testSuffixNestedType_01() {
		'''
			class C implements Map$Entry {}
		'''.hasUnresolvedTypeSuffix('$Entry')
	}
	
	@Test
	def void testSuffixNestedType_02() {
		'''
			class C implements Map.Entry {}
		'''.hasUnresolvedTypeSuffix('.Entry')
	}
	
	@Test
	def void testSuffixNestedType_03() {
		'''
			class C {
				val entry = Map::Entry::DoesNotMatter
			}
		'''.hasUnresolvedTypeSuffix('::Entry')
	}
	
	@Test
	def void testSuffixNestedType_04() {
		'''
			class C {
				val entry = Map::Entry::A::DoesNotMatter
			}
		'''.hasUnresolvedTypeSuffix('::Entry::A')
	}
	
	@Test
	def void testSuffixNestedType_05() {
		'''
			class C {
				val entry = Map.Entry.A::DoesNotMatter
			}
		'''.hasUnresolvedTypeSuffix('.Entry.A')
	}
	
	@Test
	def void testSuffixNestedType_06() {
		'''
			class C {
				val entry = Map.Entry::DoesNotMatter
			}
		'''.hasUnresolvedTypeSuffix('.Entry')
	}
	
	@Test
	def void testSuffixNestedType_07() {
		'''
			class C {
				val entry = Map$Entry::DoesNotMatter
			}
		'''.hasUnresolvedTypeSuffix('$Entry')
	}
	
	@Test
	def void testSuffixNestedType_08() {
		'''
			class C {
				val entry = new Map.Entry
			}
		'''.hasUnresolvedTypeSuffix('.Entry')
	}
	
	@Test
	def void testSuffixNestedType_09() {
		'''
			class C {
				val entry = new Map$Entry
			}
		'''.hasUnresolvedTypeSuffix('$Entry')
	}
	
	@Test
	def void testBug470235() {
		'''
			class C {
				Object o = new () { // missing type is intentional
					List list = null
				} 
			}
		'''.hasUnresolvedTypesWithErrors('List') // assert no empty name was recorded
	}
	
}