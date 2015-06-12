/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.builder.incremental

import com.google.inject.Guice
import com.google.inject.Inject
import java.util.concurrent.atomic.AtomicBoolean
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider
import org.eclipse.xtext.builder.standalone.LanguageAccess
import org.eclipse.xtext.builder.tests.incremental.AbstractIncrementalBuilderTest
import org.eclipse.xtext.generator.OutputConfigurationProvider
import org.eclipse.xtext.java.resource.JavaRuntimeModule
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
	
	IResourceServiceProvider javaResourceServiceProvider
	
	override setUp() {
		val injector = Guice.createInjector(new JavaRuntimeModule)
		javaResourceServiceProvider = injector.getInstance(IResourceServiceProvider)
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put('java', injector.getInstance(Resource.Factory))
		super.setUp()
	}
	
	override getLanguages() {
		#[new LanguageAccess(configurationProvider.outputConfigurations, rsp), new LanguageAccess(emptySet, javaResourceServiceProvider)]
	}
	
	@Test def void testSimpleMixedBuild() {
		val buildRequest = newBuildRequest [
			dirtyFiles = #[
				'src/MyFile.xtend' - '''
					class A {
						public mypack.MyClass someField
					}
				''',
				'src/mypack/MyClass.java' - '''
					package mypack;
					class MyClass {
						public String a;
					}
				'''
			]
		]
		build(buildRequest)
		assertTrue(issues.toString, issues.isEmpty)
		assertEquals(1, generated.size)
		assertTrue(generated.values.containsSuffix('src-gen/A.java'))
	}
	
	@Test def void testSimpleMixedBuild_02() {
		val buildRequest = newBuildRequest [
			dirtyFiles = #[
				'src/MyFile.xtend' - '''
					class A {
						def void doStuff(mypack.MyClass obj) {
							val A x = obj.a
							println("Juhu "+x)
						}
					}
				''',
				'src/mypack/MyClass.java' - '''
					package mypack;
					class MyClass {
						public A a;
					}
				'''
			]
		]
		build(buildRequest)
		assertTrue(issues.toString, issues.isEmpty)
		assertEquals(1, generated.size)
		assertTrue(generated.values.containsSuffix('src-gen/A.java'))
	}
	
	@Test def void testSimpleMixedBuild_03() {
		val buildRequest = newBuildRequest [
			dirtyFiles = #[
				'src/MyFile.xtend' - '''
					class A extends mypack.MyClass {
						def void doStuff(A obj) {
							val A x = obj.a
							val mypack.MyClass x2 = obj.myClass
							println("Juhu "+x+' - '+x2.a)
						}
					}
				''',
				'src/mypack/MyClass.java' - '''
					package mypack;
					class MyClass extends Third {
						public A a;
					}
				''',
				'src/mypack/Third.xtend' - '''
					package mypack
					class Third {
						public MyClass myClass
					}
				'''
			]
		]
		build(buildRequest)
		assertTrue(issues.toString, issues.isEmpty)
		assertEquals(2, generated.size)
		assertTrue(generated.values.containsSuffix('src-gen/A.java'))
		assertTrue(generated.values.containsSuffix('src-gen/mypack/Third.java'))
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