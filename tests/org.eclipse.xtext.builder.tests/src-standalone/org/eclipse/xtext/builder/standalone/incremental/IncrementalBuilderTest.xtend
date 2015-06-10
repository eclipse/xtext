/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.incremental

import com.google.common.collect.ArrayListMultimap
import com.google.common.collect.Multimap
import com.google.common.io.Files
import com.google.inject.Inject
import java.io.File
import java.nio.charset.Charset
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.builder.standalone.LanguageAccessFactory
import org.eclipse.xtext.builder.standalone.StandaloneBuilderInjectorProvider
import org.eclipse.xtext.builder.standalone.StandaloneBuilderTest.TestLanguageConfiguration
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.TemporaryFolder
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.validation.Issue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

import static extension org.eclipse.xtext.builder.standalone.incremental.FilesAndURIs.*
import com.google.inject.Provider
import org.eclipse.xtext.resource.XtextResourceSet

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(StandaloneBuilderInjectorProvider)
class IncrementalBuilderTest {

	@Rule @Inject public TemporaryFolder temporaryFolder

	@Inject IncrementalBuilder incrementalBuilder
	@Inject LanguageAccessFactory languageAccessFactory
	@Inject IndexState indexState
	@Inject Provider<XtextResourceSet> resourceSetProvider

	File tempDir
	Multimap<URI, URI> generated
	List<URI> deleted
	List<Issue> issues

	@Before def void setUp() {
		tempDir = temporaryFolder.newFolder
		clean()
	}

	protected def clean() {
		generated = ArrayListMultimap.create
		deleted = newArrayList
		issues = newArrayList
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
				uri('src/A.buildertestlanguage')
			]
		])
		assertTrue(issues.toString, issues.isEmpty)
		assertEquals(0, generated.size)
		assertEquals(1, deleted.size)
		assertTrue(deleted.containsSuffix('src-gen/A.txt'))
	}

	protected def IndexState build(BuildRequest buildRequest) {
		clean()
		val languages = languageAccessFactory.createLanguageAccess(#[new TestLanguageConfiguration(false)],
			class.getClassLoader)
		this.indexState = incrementalBuilder.build(buildRequest, languages).indexState
		return indexState
	}

	protected def newBuildRequest((BuildRequest)=>void init) {
		val result = new BuildRequest => [
			baseDir = tempDir.asURI
			resourceSet = resourceSetProvider.get
			classPath = #[]
			outputs = #[new File(tempDir, "out").asURI]
			sourceRoots = #[new File(tempDir, "src").asURI]
			dirtyFiles = #[]
			deletedFiles = #[]
			
			afterValidate = [ uri, issues |
				this.issues.addAll(issues)
				return issues.empty
			]
			
			afterDeleteFile = [
				deleted += it
			]
			
			afterGenerateFile = [ source, target |
				generated.put(source, target)
			]
			
			previousState = indexState
			
			failOnValidationError = false
		]
		init.apply(result)
		return result
	}

	protected def uri(String path) {
		new File(tempDir, path).asURI
	}

	protected def URI -(String path, String content) {
		val file = new File(tempDir, path)
		if (file.exists) {
			file.delete
		}
		file.parentFile.mkdirIfNeccessary
		file.createNewFile
		Files.write(content, file, Charset.forName("UTF-8"))
		return file.asURI
	}
	
	protected def boolean containsSuffix(Iterable<? extends URI> uris, String...suffixes) {
		suffixes.forall[ suffix |
			uris.exists[ uri | uri.toString.endsWith(suffix)]
		]
	}

	private def void mkdirIfNeccessary(File file) {
		if (file == null || file.exists) {
			return;
		}
		mkdirIfNeccessary(file.parentFile)
		file.mkdir
	}

}