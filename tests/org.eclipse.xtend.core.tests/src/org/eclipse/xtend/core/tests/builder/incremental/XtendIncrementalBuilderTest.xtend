/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.builder.incremental

import com.google.inject.Inject
import java.util.concurrent.atomic.AtomicBoolean
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider
import org.eclipse.xtext.builder.standalone.LanguageAccess
import org.eclipse.xtext.builder.tests.incremental.AbstractIncrementalBuilderTest
import org.eclipse.xtext.generator.OutputConfigurationProvider
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@InjectWith(RuntimeInjectorProvider)
@RunWith(XtextRunner)
class XtendIncrementalBuilderTest extends AbstractIncrementalBuilderTest {
	
	@Inject IResourceServiceProvider rsp
	@Inject OutputConfigurationProvider configurationProvider
	
	override getLanguages() {
		#[new LanguageAccess(configurationProvider.outputConfigurations, rsp)]
	}

	@Test def void testSimpleFullBuild() {
		val buildRequest = newBuildRequest [
			dirtyFiles = #[
				'src/MyFile.xtend' - '''
					class A {
						public String a
						public B someB
					}
					class B {
					}
				'''
			]
		]
		build(buildRequest)
		assertTrue(issues.toString, issues.isEmpty)
		assertEquals(2, generated.size)
		assertTrue(generated.values.containsSuffix('src-gen/B.java'))
		assertTrue(generated.values.containsSuffix('src-gen/A.java'))
	}

	@Test def void testDelete_01() {
		build(newBuildRequest [
			dirtyFiles = #[
				'src/A.xtend' - '''
					class A {
						public foo.B myField
					}
				''',
				'src/foo/B.xtend' - '''
					package foo
					class B {
					}
				'''
			]
		])
		
		val validateCalled = new AtomicBoolean(false)
		
		build(newBuildRequest [
			deletedFiles = #[uri('src/foo/B.xtend').delete]
			afterValidate = [ uri, issues |
				assertEquals(uri('src/A.xtend'), uri)
				assertTrue(issues.head.message, issues.head.message.contains("foo.B cannot be resolved to a type"))
				validateCalled.set(true)
				return false
			]
		])
		assertTrue(validateCalled.get)
	}

	@Test def void testIncrementalBuild() {
		build(newBuildRequest [
			dirtyFiles = #[
				'src/A.xtend' - '''
					class A extends B {
					}
				''',
				'src/B.xtend' - '''
					class B { 
						public A myReference
					}
				'''
			]
		])
		assertTrue(issues.toString, issues.isEmpty)
		assertEquals(2, generated.size)
		assertTrue(generated.values.containsSuffix('src-gen/B.java'))
		assertTrue(generated.values.containsSuffix('src-gen/A.java'))

		// non semantic change
		build(newBuildRequest [
			dirtyFiles = #[
				'src/A.xtend' - '''
					// some comment
					class A extends B { }
				'''
			]
		])
		assertTrue(issues.toString, issues.isEmpty)
		assertEquals(2, generated.size)
		assertTrue(generated.values.containsSuffix('src-gen/B.java'))
		assertTrue(generated.values.containsSuffix('src-gen/A.java'))

		// break foreign reference
		build(newBuildRequest [
			dirtyFiles = #[
				'src/A.xtend' - '''
					class X extends B { }
				'''
			]
		])
		assertEquals(issues.toString, 1, issues.size)
		assertEquals(1, generated.size)
		assertFalse(generated.values.containsSuffix('src-gen/B.java'))
		assertTrue(generated.values.containsSuffix('src-gen/X.java'))
		assertEquals(uri("src-gen/X.java"), indexState.fileMappings.getGenerated(uri('src/A.xtend')).head)
		assertEquals(1, deleted.size)
		assertTrue(deleted.containsSuffix('src-gen/A.java'))

		// fix foreign reference
		build(newBuildRequest [
			dirtyFiles = #[
				'src/A.xtend' - '''
					class A extends B {	}
				'''
			]
		])
		assertTrue(issues.toString, issues.isEmpty)
		assertEquals(2, generated.size)
		assertTrue(generated.values.containsSuffix('src-gen/B.java'))
		assertTrue(generated.values.containsSuffix('src-gen/A.java'))
		assertTrue(deleted.containsSuffix('src-gen/X.java'))
		
		// delete file
		build(newBuildRequest [
			deletedFiles = #[
				uri('src/A.xtend').delete
			]
		])
		assertEquals(issues.toString, 1, issues.size)
		assertEquals(0, generated.size)
		assertEquals(1, deleted.size)
		assertTrue(deleted.containsSuffix('src-gen/A.java'))
	}
}