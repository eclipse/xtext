/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions

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
				if (uri('src/A.indextestlanguage') == uri) {
					assertTrue(issues.toString, issues.head.message.contains("Couldn't resolve reference to Type 'foo.B'"))
					validateCalled.set(true)
					return false
				} else if (uri('src/B.indextestlanguage') == uri) {
					assertEquals("zero issues expected", 0, issues.size)
					return true
				} else {
					throw new IllegalStateException("unexpected issues for " + uri)
				}
			]
		])
		assertTrue(validateCalled.get)
	}
	
	@Test def void testDeleteClearsReusedResourceSet() {
        val req = newBuildRequest [
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
        ]
        val resourceSet = req.resourceSet
        build(req)
        
        val validateCalled = new AtomicBoolean(false)
        
        build(newBuildRequest [
            deletedFiles = #[uri('src/B.indextestlanguage')]
            afterValidate = [ uri, issues |
                if (uri('src/A.indextestlanguage') == uri) {	
	                assertTrue(issues.toString, !issues.isEmpty && issues.head.message.contains("Couldn't resolve reference to Type 'foo.B'"))
	                validateCalled.set(true)
	                return false
                } else if (uri('src/B.indextestlanguage') == uri) {
                    assertEquals("zero issues expected", 0, issues.size)
                    return true
                } else {
                    throw new IllegalStateException("unexpected issues for " + uri)
                }
            ]
            it.resourceSet = resourceSet
            val desc = ChunkedResourceDescriptions.findInEmfObject(it.resourceSet)
            desc.setContainer('test-project', it.state.resourceDescriptions)
        ])
        assertTrue(validateCalled.get)
        assertNull(resourceSet.getResource(uri('src/B.indextestlanguage'), false));
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
