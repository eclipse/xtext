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
import org.eclipse.xtext.util.TextRegion

/**
 * @author Dennis Huebner - Initial contribution and API
 */
class ImportsCollectorTests extends AbstractXtendTestCase {

	@Inject
	ImportsCollector importsCollector

	@Test
	def void testUnknownType() {
		'''
			class C implements |Serializable {
			}
		'''.assertTypeImport()
	}

	@Test
	def void testPackageSelected() {
		'''
			|package foo
			import java.io.Serializable
			class C implements Serializable| {
			}
		'''.assertTypeImport('java.io.Serializable')
	}

	@Test
	def void testImportSelected() {
		'''
			|package foo
			import java.io.Serializable|
			class C {
			}
		'''.assertTypeImport()
	}

	@Test
	def void testSimpleName_01() {
		'''
			import java.io.Serializable
			class C implements |Serializable {
			}
		'''.assertTypeImport('java.io.Serializable')
	}

	@Test
	def void testSimpleName_02() {
		'''
			import java.io.Serializable
			|class C implements Serializable {
			}
		'''.assertTypeImport('java.io.Serializable')
	}

	@Test
	def void testSimpleName_03() {
		'''
			import com.google.common.base.Strings
			
			class C {
				|var h = Strings::isNullOrEmpty('')|
			}
		'''.assertTypeImport('com.google.common.base.Strings').assertStaticImport().assertExtensionImport()
	}

	@Test
	def void testJavadoc_01() {
		'''
			import java.io.Serializable
			|class C  {
				/** 
				* @see java.util.List - fqn doesn't need an import
				* @see Serializable
				*/
				val l = null
			}
		'''.assertTypeImport('java.io.Serializable')
	}

	@Test
	def void testJavadoc_02() {
		'''
			import java.io.Serializable
			import java.util.List
			import javax.sound.sampled.Line
			class C  {
				/** 
				* {@link Line}
				* @see List
				* @see |Serializable|
				*/
				def void doStuff(){}
			}
		'''.assertTypeImport('java.io.Serializable').assertStaticImport().assertExtensionImport()
	}

	@Test
	def void testJavadoc_03() {
		'''
			import java.io.Serializable
			import java.util.List
			import javax.sound.sampled.Line
			class C  {
				/** 
				* @see |List
				* {@link Line}
				* @see java.io.Serializable|
				*/
				def void doStuff(){}
			}
		'''.assertTypeImport('java.util.List', 'javax.sound.sampled.Line').assertStaticImport().assertExtensionImport()
	}

	@Test
	def void testJavadoc_04() {
		'''
			import java.io.Serializable
			import java.util.List
			class C  {
				/** 
				* @see List
				* @see java.io.Serializable
				*/
				|def void doStuff(){}|
			}
		'''.assertTypeImport().assertStaticImport().assertExtensionImport()
	}

	@Test
	def void testSimpleConstructorCall() {
		'''
			import java.util.HashMap
			class C {
				|var Object h = new HashMap()|
			}
		'''.assertTypeImport('java.lang.Object', 'java.util.HashMap')
	}

	@Test
	def void testSimpleStaticImport_02() {
		'''
			import static com.google.common.base.Strings.isNullOrEmpty
			
			class C {
				|var h = isNullOrEmpty('')|
			}
		'''.assertStaticImport('com.google.common.base.Strings.isNullOrEmpty').assertTypeImport.assertExtensionImport
	}

	@Test
	def void testWildcardStaticImport() {
		'''
			import static com.google.common.base.Strings.*
			
			class C {
				|var h = isNullOrEmpty('')|
			}
		'''.assertStaticImport('com.google.common.base.Strings.isNullOrEmpty')
	}

	@Test
	def void testSimpleExtension() {
		'''
			import static extension com.google.common.base.Strings.isNullOrEmpty
			
			class C {
				|var h = ''.nullOrEmpty|
			}
		'''.assertExtensionImport('com.google.common.base.Strings.isNullOrEmpty')
	}

	@Test
	def void testLibExtension() {
		'''
			class C {
				|var h = ''.nullOrEmpty|
			}
		'''.assertExtensionImport('org.eclipse.xtext.xbase.lib.StringExtensions.isNullOrEmpty')
	}

	@Test
	def void testOperatorOverloading() {
		'''
			class C {
				|var h = '1'+'2'|
			}
		'''.assertExtensionImport('org.eclipse.xtext.xbase.lib.StringExtensions.operator_plus')
	}

	@Test
	def void testTypeLiteral() {
		'''
			import java.util.Map
			class C {
				|var h = typeof(Map)|
			}
		'''.assertTypeImport('java.util.Map')
	}

	@Test
	def void testNestedType_01() {
		'''
			import java.util.Map
			class C implements |Map.Entry| {}
		'''.assertTypeImport('java.util.Map')
	}

	@Test
	def void testNestedType_02() {
		'''
			import java.util.Map.Entry
			|class C implements Entry| {}
		'''.assertTypeImport('java.util.Map.Entry')
	}

	@Test
	def void testNestedType_03() {
		'''
			import java.util.Map
			class C implements |Map$Entry| {}
		'''.assertTypeImport('java.util.Map')
	}

	@Test
	def void testNestedTypeLiteral_01() {
		'''
			import java.util.Map
			class C {
				val entry = |typeof(Map.Entry)|
			}
		'''.assertTypeImport('java.util.Map')
	}

	@Test
	def void testNestedTypeLiteral_02() {
		'''
			import java.util.Map.Entry
			class C {
				val entry = |typeof(Entry)|
			}
		'''.assertTypeImport('java.util.Map.Entry')
	}

	@Test
	def void testNestedTypeLiteral_03() {
		'''
			import java.util.Map
			class C {
				val entry = |Map.Entry|
			}
		'''.assertTypeImport('java.util.Map')
	}

	@Test
	def void testTypeParameter_01() {
		'''
			import java.io.Serializable
			import java.util.List
			abstract class C implements |List<Serializable>|{
			}
		'''.assertTypeImport('java.io.Serializable', 'java.util.List')
	}

	@Test
	def void testTypeParameter_02() {
		'''
			import java.io.Serializable
			import java.util.List
			abstract class C {
				|val v = null as List<Serializable>|
			}
		'''.assertTypeImport('java.io.Serializable', 'java.util.List')
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
		'''.assertTypeImport('com.google.common.eventbus.AllowConcurrentEvents')
	}

	@Test
	def void testEnum_01() {
		'''
			import javax.annotation.Resource
			import static javax.annotation.Resource.AuthenticationType.*
			class C {
				|val en =  CONTAINER
				var en2 = Resource.AuthenticationType.APPLICATION|
			}
		'''.assertTypeImport('javax.annotation.Resource').assertStaticImport(
			'javax.annotation.Resource.AuthenticationType.CONTAINER').assertExtensionImport
	}

	@Test
	def void testAnonymousClass_01() {
		'''
			import java.util.ArrayList
			class C {
				|val l = new ArrayList() {
					override clear() {
						super.clear()
					}
				}|
			}
		'''.assertTypeImport('java.util.ArrayList').assertStaticImport.assertExtensionImport
	}
	
	@Test
	def void testAnonymousClass_02() {
		'''
			import java.util.ArrayList
			class C {
				static String foo
				|val l = new ArrayList() {
					override clear() {
						val i = foo
						super.clear()
					}
				}|
			}
		'''.assertTypeImport('java.util.ArrayList').assertStaticImport('C.foo').assertExtensionImport
	}

	@Test
	def void testImplicitReciever_01() {
		'''
			class C {
				|def void doStuff(String it) {
					return substring(length)
				} 
				|
			}
		'''.assertTypeImport('java.lang.String').assertStaticImport.assertExtensionImport
	}

	private def DefaultImportsAcceptor assertTypeImport(CharSequence xtendFile, String... typeNames) {
		xtendFile.collect.assertTypeImport(typeNames)
	}

	private def DefaultImportsAcceptor assertTypeImport(DefaultImportsAcceptor acceptor, String... typeNames) {
		return acceptor.has([acceptor.types], typeNames)
	}

	private def DefaultImportsAcceptor assertExtensionImport(CharSequence xtendFile, String... typeNames) {
		xtendFile.collect.assertExtensionImport(typeNames)
	}

	private def DefaultImportsAcceptor assertExtensionImport(DefaultImportsAcceptor acceptor, String... typeNames) {
		return acceptor.has([acceptor.extensions], typeNames)
	}

	private def DefaultImportsAcceptor assertStaticImport(CharSequence xtendFile, String... typeNames) {
		xtendFile.collect.assertStaticImport(typeNames)
	}

	private def DefaultImportsAcceptor assertStaticImport(DefaultImportsAcceptor acceptor, String... typeNames) {
		return acceptor.has([acceptor.staticImport], typeNames)
	}

	private def has(DefaultImportsAcceptor acceptor, (DefaultImportsAcceptor)=>Set<String> getter,
		String... typeNames) {
		assertEquals(typeNames.toSet, getter.apply(acceptor))
		return acceptor
	}

	private def collect(CharSequence xtendFile) {
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
		importsCollector.collectImports(resource as XtextResource, new TextRegion(start, end - start), acceptor)
		return acceptor
	}

}