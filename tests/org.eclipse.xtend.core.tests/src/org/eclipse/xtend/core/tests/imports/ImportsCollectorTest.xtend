/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.imports

import com.google.inject.Inject
import java.util.Set
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.xbase.imports.ImportsAcceptor.DefaultImportsAcceptor
import org.eclipse.xtext.xbase.imports.ImportsCollector
import org.junit.Test

/**
 * @author Dennis Huebner - Initial contribution and API
 */
class ImportsCollectorTests extends AbstractXtendTestCase {

	@Inject
	ImportsCollector importsCollector

	@Test
	def void testSimpleName_01() {
		'''
			import java.io.Serializable
			class C implements |Serializable {
			}
		'''.hasTypeImport('java.io.Serializable')
	}

	@Test
	def void testSimpleName_02() {
		'''
			import java.io.Serializable
			|class C implements Serializable {
			}
		'''.hasTypeImport('java.io.Serializable')
	}

	@Test
	def void testJavadoc_01() {
		'''
			import java.io.Serializable
			|class C  {
				/** 
				* @see java.io.Serializable
				*/
				val l = null
			}
		'''.hasTypeImport('java.io.Serializable')
	}

	@Test
	def void testJavadoc_02() {
		'''
			import java.io.Serializable
			class C  {
				/** 
				* |@see java.io.Serializable|
				*/
				def void doStuff(){}
			}
		'''.hasTypeImport('java.io.Serializable')
	}

	@Test
	def void testSimpleConstructorCall() {
		'''
			import java.util.HashMap
			class C {
				|var h = new HashMap()|
			}
		'''.hasTypeImport('java.util.HashMap')
	}

	@Test
	def void testSimpleStaticImport() {
		'''
			import static com.google.common.base.Strings.isNullOrEmpty
			
			class C {
				|var h = isNullOrEmpty('')|
			}
		'''.hasStaticImport('com.google.common.base.Strings.isNullOrEmpty')
	}

	@Test
	def void testWildcardStaticImport() {
		'''
			import static com.google.common.base.Strings.*
			
			class C {
				|var h = isNullOrEmpty('')|
			}
		'''.hasStaticImport('com.google.common.base.Strings.isNullOrEmpty')
	}

	@Test
	def void testSimpleExtension() {
		'''
			import static extension com.google.common.base.Strings.isNullOrEmpty
			
			class C {
				|var h = ''.nullOrEmpty|
			}
		'''.hasExtensionImport('com.google.common.base.Strings.isNullOrEmpty')
	}

	@Test
	def void testLibExtension() {
		'''
			class C {
				|var h = ''.nullOrEmpty|
			}
		'''.hasExtensionImport('org.eclipse.xtext.xbase.lib.StringExtensions.isNullOrEmpty')
	}

	@Test
	def void testOperatorOverloading() {
		'''
			class C {
				|var h = '1'+'2'|
			}
		'''.hasExtensionImport('org.eclipse.xtext.xbase.lib.StringExtensions.operator_plus')
	}

	@Test
	def void testTypeLiteral() {
		'''
			import java.util.Map
			class C {
				|var h = typeof(Map)|
			}
		'''.hasTypeImport('java.util.Map')
	}

	@Test
	def void testNestedType_01() {
		'''
			import java.util.Map
			class C implements |Map.Entry| {}
		'''.hasTypeImport('java.util.Map')
	}

	@Test
	def void testNestedType_02() {
		'''
			import java.util.Map.Entry
			|class C implements Entry| {}
		'''.hasTypeImport('java.util.Map$Entry')
	}

	@Test
	def void testNestedType_03() {
		'''
			import java.util.Map
			class C implements |Map$Entry| {}
		'''.hasTypeImport('java.util.Map')
	}

	@Test
	def void testNestedTypeLiteral_01() {
		'''
			import java.util.Map
			class C {
				val entry = |typeof(Map.Entry)|
			}
		'''.hasTypeImport('java.util.Map')
	}

	@Test
	def void testNestedTypeLiteral_02() {
		'''
			import java.util.Map.Entry
			class C {
				val entry = |typeof(Entry)|
			}
		'''.hasTypeImport('java.util.Map$Entry')
	}

	@Test
	def void testTypeParameter_01() {
		'''
			import java.io.Serializable
			import java.util.List
			abstract class C implements |List<Serializable>|{
			}
		'''.hasTypeImport('java.io.Serializable', 'java.util.List')
	}

	@Test
	def void testTypeParameter_02() {
		'''
			import java.io.Serializable
			import java.util.List
			abstract class C {
				|val v = null as List<Serializable>|
			}
		'''.hasTypeImport('java.io.Serializable', 'java.util.List')
	}

	@Test
	def void testAnnotation_01() {
		'''
			import com.google.common.eventbus.AllowConcurrentEvents
			abstract class C {
				|@AllowConcurrentEvents
				def int annotated(){
				}|
			}
		'''.hasTypeImport('com.google.common.eventbus.AllowConcurrentEvents')
	}

	private def void hasTypeImport(CharSequence xtendFile, String... typeNames) {
		xtendFile.has([DefaultImportsAcceptor ia|ia.types], typeNames)
	}

	private def void has(CharSequence xtendFile, (DefaultImportsAcceptor)=>Set<String> set, String... typeNames) {
		var contentAsString = xtendFile.toString
		var start = 0
		var end = contentAsString.length
		var selector = contentAsString.indexOf('|')
		if (selector != -1) {
			start = selector
			contentAsString = contentAsString.replaceFirst('\\|', '')
			selector = contentAsString.indexOf('|')
			end = contentAsString.length
			if (selector != -1) {
				end = selector
				contentAsString = contentAsString.replaceFirst('\\|', '')
			}
		}
		val resource = file(contentAsString).eResource
		val acceptor = new DefaultImportsAcceptor
		importsCollector.collectImports(resource as XtextResource, start, start + end, acceptor)
		val actual = set.apply(acceptor)
		assertEquals(typeNames.toSet, actual)
	}

	private def void hasExtensionImport(CharSequence xtendFile, String... typeNames) {
		xtendFile.has([extensions], typeNames)
	}

	private def void hasStaticImport(CharSequence xtendFile, String... typeNames) {
		xtendFile.has([staticImport], typeNames)
	}

}