/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.tests.incremental

import com.google.inject.Inject
import java.util.concurrent.atomic.AtomicBoolean
import org.eclipse.xtext.builder.standalone.LanguageAccessFactory
import org.eclipse.xtext.builder.standalone.StandaloneBuilderInjectorProvider
import org.eclipse.xtext.builder.standalone.StandaloneBuilderTest.TestLanguageConfiguration
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(StandaloneBuilderInjectorProvider)
class IncrementalBuilderTest extends AbstractIncrementalBuilderTest {
	
	@Inject protected LanguageAccessFactory languageAccessFactory
	
	override getLanguages() {
		languageAccessFactory.createLanguageAccess(#[new TestLanguageConfiguration(false)], class.classLoader).values.toList
	}

	@Test def void testSimpleFullBuild() {
		val buildRequest = newBuildRequest [
			dirtyFiles = #[
				'src/MyFile.buildertestlanguage' - '''
					namespace foo {
						object B
						object A references foo.B
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
	
	@Test def void testDelete_01() {
		build(newBuildRequest [
			dirtyFiles = #[
				'src/A.buildertestlanguage' - '''
					namespace foo {
						object A references foo.B
					}
				''',
				'src/B.buildertestlanguage' - '''
					namespace foo {
						object B
					}
				'''
			]
		])
		
		val validateCalled = new AtomicBoolean(false)
		
		build(newBuildRequest [
			deletedFiles = #[uri('src/B.buildertestlanguage')]
			afterValidate = [ uri, issues |
				assertEquals(uri('src/A.buildertestlanguage'), uri)
				assertTrue(issues.head.message.contains("Couldn't resolve reference to Element 'foo.B'"))
				validateCalled.set(true)
				return false
			]
		])
		assertTrue(validateCalled.get)
	}

	@Test def void testIncrementalBuild() {
		build(newBuildRequest [
			dirtyFiles = #[
				'src/A.buildertestlanguage' - '''
					namespace foo {
						object A references foo.B
					}
				''',
				'src/B.buildertestlanguage' - '''
					namespace foo {
						object B references foo.A
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
				'src/A.buildertestlanguage' - '''
					namespace foo {
						object A references foo.B
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
				'src/A.buildertestlanguage' - '''
					namespace foo {
						object X references foo.B
					}
				'''
			]
		])
		assertEquals(issues.toString, 1, issues.size)
		assertEquals(1, generated.size)
		assertFalse(generated.values.containsSuffix('src-gen/B.txt'))
		assertTrue(generated.values.containsSuffix('src-gen/X.txt'))
		assertEquals(1, indexState.fileMappings.getGenerated(uri('src/A.buildertestlanguage')).size)
		assertEquals(1, deleted.size)
		assertTrue(deleted.containsSuffix('src-gen/A.txt'))

		// fix foreign reference
		build(newBuildRequest [
			dirtyFiles = #[
				'src/A.buildertestlanguage' - '''
					namespace foo {
						object A references foo.B
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
				uri('src/A.buildertestlanguage').delete
			]
		])
		assertEquals(issues.toString, 1, issues.size)
		assertEquals(0, generated.size)
		assertEquals(1, deleted.size)
		assertTrue(deleted.containsSuffix('src-gen/A.txt'))
	}

	
}