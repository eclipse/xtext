/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import com.google.common.base.CharMatcher
import com.google.common.base.StandardSystemProperty
import com.google.inject.Inject
import java.io.File
import java.net.URI
import java.nio.file.Files
import java.nio.file.Paths
import org.eclipse.xtext.ide.server.UriExtensions
import org.eclipse.xtext.ide.tests.testlanguage.TestLanguageIdeInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

import static org.eclipse.emf.common.util.URI.createFileURI
import static org.eclipse.emf.common.util.URI.createURI
import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(TestLanguageIdeInjectorProvider)
class UriExtensionsTest {

	@Inject
	extension UriExtensions

	@Test
	def void test_toUri01() {
		assertEquals(
			createURI('file://path/to/resource'),
			'file://path/to/resource'.toUri
		);
	}

	@Test
	def void test_toUri_02() {
		assertEquals(
			createURI('file:///path/to/resource'),
			'file:///path/to/resource'.toUri
		);
	}

	@Test
	def void test_toUri03() {
		assertEquals(
			createURI('file://path%20with%20whitespaces/to/resource'),
			'file://path%20with%20whitespaces/to/resource'.toUri
		);
	}

	@Test
	def void test_toUri_04() {
		assertEquals(
			createURI('file:///path%20with%20whitespaces/to/resource'),
			'file:///path%20with%20whitespaces/to/resource'.toUri
		);
	}

	@Test
	def void test_toUri_05() {
		assertEquals(
			createURI('file:///dir/\u0424\u0443%20\u0411\u0430\u0440'),
			'file:///dir/%D0%A4%D1%83%20%D0%91%D0%B0%D1%80'.toUri
		);
	}

	@Test
	def void test_toUri_06() {
		assertEquals(
			createURI('file://dir/\u0424\u0443%20\u0411\u0430\u0440'),
			'file://dir/%D0%A4%D1%83%20%D0%91%D0%B0%D1%80'.toUri
		);
	}

	@Test
	def void test_toUri_07() {
		assertEquals(
			createURI('something:/path/to/resource'),
			'something:/path/to/resource'.toUri
		);
	}

	@Test
	def void test_toUri_08() {
		assertEquals(
			createURI('something://path/to/resource'),
			'something://path/to/resource'.toUri
		);
	}

	@Test
	def void test_toUri_09() {
		assertEquals(
			createURI('something:/dir/\u0424\u0443%20\u0411\u0430\u0440'),
			'something:/dir/%D0%A4%D1%83%20%D0%91%D0%B0%D1%80'.toUri
		);
	}

	@Test
	def void test_toUri_10() {
		assertEquals(
			createURI('something://dir/\u0424\u0443%20\u0411\u0430\u0440'),
			'something://dir/%D0%A4%D1%83%20%D0%91%D0%B0%D1%80'.toUri
		);
	}

	@Test
	def void test_toUri_11() {
		assertEquals(
			createURI('something:/path%20with%20whitespaces/to/resource'),
			'something:/path%20with%20whitespaces/to/resource'.toUri
		);
	}

	@Test
	def void test_toUri_12() {
		assertEquals(
			createURI('something://path%20with%20whitespaces/to/resource'),
			'something://path%20with%20whitespaces/to/resource'.toUri
		);
	}

	@Test
	def void test_toUri_13() {
		assertEquals(
			createURI('file:///c:/Users/dietrich/git/MyDSL_Imports/mydsl/workspace/src/something.mydsl'),
			'file:///c%3A/Users/dietrich/git/MyDSL_Imports/mydsl/workspace/src/something.mydsl'.toUri
		);
	}

	@Test
	def void test_toUri_14() {
		assertEquals(
			createURI('file:///c:/Users/dietrich/\u0424\u0443%20\u0411\u0430\u0440.mydsl'), 
			"file:///c%3A/Users/dietrich/%D0%A4%D1%83%20%D0%91%D0%B0%D1%80.mydsl".toUri
		);
	}

	@Test
	def void test_toUriString_01() {
		assertEquals(
			'file:///path/to/resource',
			URI.create('file:///path/to/resource').toUriString
		);
	}

	@Test
	def void test_toUriString_02() {
		assertEquals(
			'file://path/to/resource',
			URI.create('file://path/to/resource').toUriString
		);
	}

	@Test
	def void test_toUriString_03() {
		assertEquals(
			'file:///dir/\u0424\u0443%20\u0411\u0430\u0440',
			URI.create('file:/dir/\u0424\u0443%20\u0411\u0430\u0440').toUriString
		);
	}

	@Test
	def void test_toUriString_04() {
		assertEquals(
			'file://dir/\u0424\u0443%20\u0411\u0430\u0440',
			URI.create('file://dir/\u0424\u0443%20\u0411\u0430\u0440').toUriString
		);
	}


	@Test
	def void test_toUriString_05() {
		assertEquals(
			'file://path/to/resource/',
			URI.create('file://path/to/resource/').toUriString
		);
	}

	@Test
	def void test_toUriString_06() {
		assertEquals(
			'file:///path/to/resource/',
			URI.create('file:/path/to/resource/').toUriString
		);
	}
	
	@Test
	def void test_toUriString_07() {
		assertEquals(
			'file:///path/to/resource/',
			URI.create('file:///path/to/resource/').toUriString
		);
	}

	@Test
	def void test_symmetric_01() {
		assertEquals(
			createURI('file:///path/to/resource'),
			URI.create('file:///path/to/resource').toUriString.toUri
		);
	}

	@Test
	def void test_symmetric_02() {
		assertEquals(
			createURI('file://path/to/resource'),
			URI.create('file://path/to/resource').toUriString.toUri
		)
	}
	
	@Test
	def void test_symmetric_03() {
		assertEquals(
			createURI('something:/path/to/resource'),
			URI.create('something:/path/to/resource').toUriString.toUri
		);
	}
	
	@Test
	def void test_symmetric_04() {
		assertEquals(
			createURI('something://path/to/resource'),
			URI.create('something://path/to/resource').toUriString.toUri
		);
	}
	
	@Test
	def void testConversion() {
		assertEquals("file:///dir/name.ext", "file:///dir/name.ext".toUri.toUriString)
	}

	@Test
	def void testFileUriConversion() {
		val expected = Paths.get(new File('.').canonicalPath).resolve('dir').resolve('name.ext').toUri.toString;
		assertEquals(expected, createFileURI(new File('dir/name.ext').absolutePath).toUriString)
	}

	@Test
	def void testFilesWithSpaces() {
		val x = "file:///dir/Foo%20Bar.testlang".toUri
		val y = x.toUriString
		assertEquals("file:///dir/Foo%20Bar.testlang", y)
	}

	@Test
	def void testFilesWithCyrillicSymbols() {
		assertEquals("file:///dir/\u0424\u0443%20\u0411\u0430\u0440.testlang",
			"file:///dir/%D0%A4%D1%83%20%D0%91%D0%B0%D1%80.testlang".toUri.toUriString)
	}

	@Test
	def void testFolderIsPrefix() {
		var directory = new File("./test-data2/test-project")
		directory.mkdirs
		assertTrue(directory.exists)
		assertTrue(directory.directory)
		var uri = createFileURI(directory.absolutePath + "/").toUriString.toUri
		assertTrue(uri.isPrefix)
	}
	
	@Test
	def void testFolderIsPrefixWithWhitespace() {
		var directory = createTempDir('some name with whitespaces').toFile;
		assertTrue(directory.exists)
		assertTrue(directory.directory)
		assertTrue(CharMatcher.whitespace.matchesAnyOf(directory.name));
		var uri = createFileURI(directory.absolutePath + "/").toUriString.toUri
		assertTrue(uri.isPrefix)
	}
	
	@Test
	def void test_withEmptyAuthority () {
		val uriWithoutAuthority = org.eclipse.emf.common.util.URI.createURI("file:/path/to/resource/")
		assertNull(uriWithoutAuthority.authority)
		val uriWithEmptyAuthority = uriWithoutAuthority.withEmptyAuthority
		assertNotSame(uriWithoutAuthority, uriWithEmptyAuthority)
		assertEquals("Returned URI is expected to have an empty instead of null authority", "", uriWithEmptyAuthority.authority)
		
		val uriWithAuthority = org.eclipse.emf.common.util.URI.createURI("https://xtext.org/path/to/resource/")
		assertNotNull(uriWithAuthority.authority)
		assertEquals("xtext.org", uriWithAuthority.authority)
		assertSame(uriWithAuthority, uriWithAuthority.withEmptyAuthority)
	}

	private def createTempDir(String prefix) {
		return Files.createTempDirectory(tempDirPath, prefix);
	}
	
	private def getTempDirPath() {
		return Paths.get(StandardSystemProperty.JAVA_IO_TMPDIR.value);
	}
	

}
