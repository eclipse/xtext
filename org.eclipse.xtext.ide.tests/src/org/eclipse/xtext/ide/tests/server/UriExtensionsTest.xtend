/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import java.io.File
import java.net.URI
import javax.inject.Inject
import org.eclipse.xtext.ide.server.UriExtensions
import org.eclipse.xtext.ide.tests.testlanguage.TestLanguageIdeInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*
import java.nio.file.Paths
import com.google.common.base.StandardSystemProperty
import java.nio.file.Files
import com.google.common.base.CharMatcher

@RunWith(XtextRunner)
@InjectWith(TestLanguageIdeInjectorProvider)
class UriExtensionsTest {

	@Inject
	extension UriExtensions

	@Test
	def void test_toUri01() {
		assertEquals(
			createEmfURI('file:///path/to/resource'),
			'file://path/to/resource'.toUri
		);
	}

	@Test
	def void test_toUri_02() {
		assertEquals(
			createEmfURI('file:///path/to/resource'),
			'file:///path/to/resource'.toUri
		);
	}

	@Test
	def void test_toUri03() {
		assertEquals(
			createEmfURI('file:///path with whitespaces/to/resource'),
			'file://path with whitespaces/to/resource'.toUri
		);
	}

	@Test
	def void test_toUri_04() {
		assertEquals(
			createEmfURI('file:///path with whitespaces/to/resource'),
			'file:///path with whitespaces/to/resource'.toUri
		);
	}

	@Test
	def void test_toUri_05() {
		assertEquals(
			createEmfURI('file:///dir/\u0424\u0443 \u0411\u0430\u0440'),
			'file:///dir/\u0424\u0443 \u0411\u0430\u0440'.toUri
		);
	}

	@Test
	def void test_toUri_06() {
		assertEquals(
			createEmfURI('file:///dir/\u0424\u0443 \u0411\u0430\u0440'),
			'file://dir/\u0424\u0443 \u0411\u0430\u0440'.toUri
		);
	}

	@Test
	def void test_toUri_07() {
		assertEquals(
			createEmfURI('file:///path/to/resource'),
			'file://localhost/path/to/resource'.toUri
		);
	}

	@Test
	def void test_toUri_08() {
		assertEquals(
			createEmfURI('file:///dir/\u0424\u0443 \u0411\u0430\u0440'),
			'file://localhost/dir/\u0424\u0443 \u0411\u0430\u0440'.toUri
		);
	}

	@Test
	def void test_toUri_09() {
		assertEquals(
			createEmfURI('something:/path/to/resource'),
			'something:/path/to/resource'.toUri
		);
	}

	@Test
	def void test_toUri_10() {
		assertEquals(
			createEmfURI('something://path/to/resource'),
			'something://path/to/resource'.toUri
		);
	}

	@Test
	def void test_toUri_11() {
		assertEquals(
			createEmfURI('something:/dir/\u0424\u0443 \u0411\u0430\u0440'),
			'something:/dir/\u0424\u0443 \u0411\u0430\u0440'.toUri
		);
	}

	@Test
	def void test_toUri_12() {
		assertEquals(
			createEmfURI('something://dir/\u0424\u0443 \u0411\u0430\u0440'),
			'something://dir/\u0424\u0443 \u0411\u0430\u0440'.toUri
		);
	}

	@Test
	def void test_toUri_13() {
		assertEquals(
			createEmfURI('something:/path with whitespaces/to/resource'),
			'something:/path with whitespaces/to/resource'.toUri
		);
	}

	@Test
	def void test_toUri_14() {
		assertEquals(
			createEmfURI('something://path with whitespaces/to/resource'),
			'something://path with whitespaces/to/resource'.toUri
		);
	}

	@Test
	def void test_toPath_01() {
		assertEquals(
			'file:///path/to/resource',
			URI.create('file:///path/to/resource').toPath
		);
	}

	@Test
	def void test_toPath_02() {
		assertEquals(
			'file:///path/to/resource',
			URI.create('file://path/to/resource').toPath
		);
	}

	@Test
	def void test_toPath_03() {
		assertEquals(
			'file:///dir/\u0424\u0443%20\u0411\u0430\u0440',
			URI.create('file:///dir/\u0424\u0443%20\u0411\u0430\u0440').toPath
		);
	}

	@Test
	def void test_toPath_04() {
		assertEquals(
			'file:///dir/\u0424\u0443%20\u0411\u0430\u0440',
			URI.create('file://dir/\u0424\u0443%20\u0411\u0430\u0440').toPath
		);
	}

	@Test
	def void test_toPath_05() {
		assertEquals(
			'file:///path/to/resource',
			URI.create('file://localhost/path/to/resource').toPath
		);
	}

	@Test
	def void test_toPath_06() {
		assertEquals(
			'file:///path/to/resource/',
			URI.create('file://path/to/resource/').toPath
		);
	}

	@Test
	def void test_toPath_07() {
		assertEquals(
			'file:///path/to/resource/',
			URI.create('file:///path/to/resource/').toPath
		);
	}

	@Test
	def void test_symmetric_01() {
		assertEquals(
			createEmfURI('file:///path/to/resource'),
			URI.create('file:///path/to/resource').toPath.toUri
		);
	}

	@Test
	def void test_symmetric_02() {
		assertEquals(
			createEmfURI('file:///path/to/resource'),
			URI.create('file://path/to/resource').toPath.toUri
		);
	}
	
	@Test
	def void test_symmetric_03() {
		assertEquals(
			createEmfURI('something:/path/to/resource'),
			URI.create('something:/path/to/resource').toPath.toUri
		);
	}
	
	@Test
	def void test_symmetric_04() {
		assertEquals(
			createEmfURI('something://path/to/resource'),
			URI.create('something://path/to/resource').toPath.toUri
		);
	}
	
	@Test
	def void testConversion() {
		assertEquals("file:///dir/name.ext", "file:///dir/name.ext".toUri.toPath)
	}

	@Test
	def void testFileUriConversion() {
		assertEquals("file:///dir/name.ext", createEmfFileURI("/dir/name.ext").toPath)
	}

	@Test
	def void testFilesWithSpaces() {
		assertEquals("file:///dir/Foo Bar.testlang", "file:///dir/Foo Bar.testlang".toUri.toPath)
	}

	@Test
	def void testFilesWithCyrillicSymbols() {
		assertEquals("file:///dir/\u0424\u0443 \u0411\u0430\u0440.testlang",
			"file:///dir/\u0424\u0443 \u0411\u0430\u0440.testlang".toUri.toPath)
	}

	@Test
	def void testFolderIsPrefix() {
		var directory = new File("./test-data/test-project")
		assertTrue(directory.exists)
		assertTrue(directory.directory)
		var uri = createEmfFileURI(directory.canonicalPath).toPath.toUri
		assertTrue(uri.isPrefix)
	}
	
	@Test
	def void testFolderIsPrefixWithExplicitSuffix() {
		var directory = new File("./test-data/test-project")
		assertTrue(directory.exists)
		assertTrue(directory.directory)
		var uri = createEmfFileURI(directory.canonicalPath + "/").toPath.toUri
		assertTrue(uri.isPrefix)
	}
	
	@Test
	def void testFolderIsPrefixWithWhitespace() {
		var directory = createTempDir('some name with whitespaces').toFile;
		assertTrue(directory.exists)
		assertTrue(directory.directory)
		assertTrue(CharMatcher.WHITESPACE.matchesAnyOf(directory.name));
		var uri = createEmfFileURI(directory.canonicalPath).toPath.toUri
		assertTrue(uri.isPrefix)
	}

	private def createEmfURI(String uri) {
		return org.eclipse.emf.common.util.URI.createURI(uri);
	}
	
	private def createEmfFileURI(String uri) {
		return org.eclipse.emf.common.util.URI.createFileURI(uri);
	}
	
	private def createTempDir(String prefix) {
		return Files.createTempDirectory(tempDirPath, prefix);
	}
	
	private def getTempDirPath() {
		return Paths.get(StandardSystemProperty.JAVA_IO_TMPDIR.value);
	}
	

}
