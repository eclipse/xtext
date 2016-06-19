/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.build

import com.google.inject.Inject
import java.util.concurrent.atomic.AtomicBoolean
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.build.BuildRequest.IPostValidationCallback
import org.eclipse.xtext.index.IndexTestLanguageInjectorProvider
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.builder.AbstractIncrementalBuilderTest
import org.eclipse.xtext.validation.Issue
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(IndexTestLanguageInjectorProvider)
class IncrementalBuilderTest extends AbstractIncrementalBuilderTest {
	
	@Inject IResourceServiceProvider.Registry resourceServiceProviderFactory
	
	override getLanguages() {
		resourceServiceProviderFactory
	}

	@Test def void testNoCleanupBuild() {
		val buildRequest = newBuildRequest [
			withOutputConfig [
				cleanUpDerivedResources = false
			]
			dirtyFiles = #[
				'src/MyFile.indextestlanguage' - '''
					foo {
						entity B {}
						entity A { foo.B myReference }
					}
				'''
			]
		]
		build(buildRequest)
		assertTrue(issues.toString, issues.isEmpty)
		assertEquals(2, generated.size)
		assertTrue(generated.values.containsSuffix('src-gen/B.txt'))
		assertTrue(generated.values.containsSuffix('src-gen/A.txt'))
		
		newBuildRequest [
			withOutputConfig [
				cleanUpDerivedResources = false
			]
			deletedFiles = #[
				uri('src/A.indextestlanguage').delete
			]
		]
		assertTrue(issues.toString, issues.isEmpty)
		assertEquals(2, generated.size)
		assertTrue(generated.values.containsSuffix('src-gen/B.txt'))
		assertTrue(generated.values.containsSuffix('src-gen/A.txt'))
		
	}
	
	@Test def void testGeneratedOnceBuild() {
		val buildRequest = newBuildRequest [
			withOutputConfig [
				overrideExistingResources = false
			]
			dirtyFiles = #[
				'src/MyFile.indextestlanguage' - '''
					foo {
						entity B {}
						entity A { foo.B myReference }
					}
				'''
			]
			
		]
		build(buildRequest)
		assertTrue(issues.toString, issues.isEmpty)
		assertEquals(2, generated.size)
		assertTrue(generated.values.containsSuffix('src-gen/B.txt'))
		assertTrue(generated.values.containsSuffix('src-gen/A.txt'))
		newBuildRequest [
			withOutputConfig [
				overrideExistingResources = false
			]
			dirtyFiles = #[
				'src/MyFile.indextestlanguage' - '''
					foo {
						entity B {}
						entity A { foo.B someReference }
					}
				'''
			]
			afterGenerateFile = [
				// no generation expected
				fail
			]
		]
	}
	

	
	@Test def void testSimpleFullBuild() {
		val buildRequest = newBuildRequest [
			dirtyFiles = #[
				'src/MyFile.indextestlanguage' - '''
					foo {
						entity B {}
						entity A { foo.B myReference }
					}
				'''
			]
		]
		build(buildRequest)
		assertTrue(issues.toString, issues.isEmpty)
		assertEquals(2, generated.size)
		assertTrue(generated.values.containsSuffix('src-gen/B.txt'))
		assertTrue(generated.values.containsSuffix('src-gen/A.txt'))
	}
	
	@Test(expected = OperationCanceledException)
	def void testCancellation() {
		val cancelOnFirstModel = new CancelOnFirstModel
		val buildRequest = newBuildRequest [
			dirtyFiles = #[
				'src/MyFile.indextestlanguage' - '''
					foo {
						entity A { foo.B myReference }
					}
				''',
				'src/MyFile2.indextestlanguage' - '''
					foo {
						entity B {}
					}
				'''
			]
			cancelIndicator = cancelOnFirstModel
			afterValidate = cancelOnFirstModel
		]
		build(buildRequest)
	}
	
	@Test
	def void testIndexOnly() {
		val buildRequest = newBuildRequest [
			indexOnly = true
			dirtyFiles = #[
				'src/MyFile.indextestlanguage' - '''
					foo {
						entity A {}
					}
				'''
			]
			afterValidate = [throw new IllegalStateException]
			afterGenerateFile = [throw new IllegalStateException]
		]
		val result = build(buildRequest)
		assertEquals(1, result.resourceDescriptions.allResourceDescriptions.size)
	}
	
	private static class CancelOnFirstModel implements IPostValidationCallback, CancelIndicator {
		
		boolean canceled
	
		override afterValidate(URI validated, Iterable<Issue> issues) {
			if (canceled)
				fail("Builder didn't cancel")
			canceled = true
		}
		
		override isCanceled() {
			canceled
		}
		
	}
	
	@Test def void testDelete_01() {
		build(newBuildRequest [
			dirtyFiles = #[
				'src/A.indextestlanguage' - '''
					foo {
						entity A {foo.B references}
					}
				''',
				'src/B.indextestlanguage' - '''
					foo {
						entity B
					}
				'''
			]
		])
		
		val validateCalled = new AtomicBoolean(false)
		
		build(newBuildRequest [
			deletedFiles = #[uri('src/B.indextestlanguage')]
			afterValidate = [ uri, issues |
				assertEquals(uri('src/A.indextestlanguage'), uri)
				assertTrue(issues.toString, issues.head.message.contains("Couldn't resolve reference to Type 'foo.B'"))
				validateCalled.set(true)
				return false
			]
		])
		assertTrue(validateCalled.get)
	}

	@Test def void testIncrementalBuild() {
		build(newBuildRequest [
			dirtyFiles = #[
				'src/A.indextestlanguage' - '''
					foo {
						entity A {foo.B reference}
					}
				''',
				'src/B.indextestlanguage' - '''
					foo {
						entity B {foo.A reference}
					}
				'''
			]
		])
		assertTrue(issues.toString, issues.isEmpty)
		assertEquals(2, generated.size)
		assertTrue(generated.values.containsSuffix('src-gen/B.txt'))
		assertTrue(generated.values.containsSuffix('src-gen/A.txt'))

		// non semantic change
		build(newBuildRequest [
			dirtyFiles = #[
				'src/A.indextestlanguage' - '''
					foo {
						entity A {foo.B reference}
					}
				'''
			]
		])
		assertTrue(issues.toString, issues.isEmpty)
		assertEquals(1, generated.size)
		assertFalse(generated.values.containsSuffix('src-gen/B.txt'))
		assertTrue(generated.values.containsSuffix('src-gen/A.txt'))

		// break foreign reference
		build(newBuildRequest [
			dirtyFiles = #[
				'src/A.indextestlanguage' - '''
					foo {
						entity X { foo.B reference }
					}
				'''
			]
		])
		assertEquals(issues.toString, 1, issues.size)
		assertEquals(1, generated.size)
		assertFalse(generated.values.containsSuffix('src-gen/B.txt'))
		assertTrue(generated.values.containsSuffix('src-gen/X.txt'))
		assertEquals(1, indexState.fileMappings.getGenerated(uri('src/A.indextestlanguage')).size)
		assertEquals(1, deleted.size)
		assertTrue(deleted.containsSuffix('src-gen/A.txt'))

		// fix foreign reference
		build(newBuildRequest [
			dirtyFiles = #[
				'src/A.indextestlanguage' - '''
					foo {
						entity A { foo.B reference }
					}
				'''
			]
		])
		assertTrue(issues.toString, issues.isEmpty)
		assertEquals(2, generated.size)
		assertTrue(generated.values.containsSuffix('src-gen/B.txt'))
		assertTrue(generated.values.containsSuffix('src-gen/A.txt'))
		assertTrue(deleted.containsSuffix('src-gen/X.txt'))
		
		// delete file
		build(newBuildRequest [
			deletedFiles = #[
				uri('src/A.indextestlanguage').delete
			]
		])
		assertEquals(issues.toString, 1, issues.size)
		assertEquals(0, generated.size)
		assertEquals(1, deleted.size)
		assertTrue(deleted.containsSuffix('src-gen/A.txt'))
	}

	
}
