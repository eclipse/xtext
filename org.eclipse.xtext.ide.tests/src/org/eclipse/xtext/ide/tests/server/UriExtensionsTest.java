/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import static org.junit.Assert.*;

import java.io.File;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ide.server.UriExtensions;
import org.eclipse.xtext.ide.tests.testlanguage.TestLanguageIdeInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.base.CharMatcher;
import com.google.common.base.StandardSystemProperty;
import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(TestLanguageIdeInjectorProvider.class)
public class UriExtensionsTest {
	@Inject
	@Extension
	private UriExtensions uriExtensions;

	@Test
	public void test_toUri01() throws Exception {
		assertEquals(URI.createURI("file://path/to/resource"), uriExtensions.toUri("file://path/to/resource"));
	}

	@Test
	public void test_toUri_02() throws Exception {
		assertEquals(URI.createURI("file:///path/to/resource"), uriExtensions.toUri("file:///path/to/resource"));
	}

	@Test
	public void test_toUri03() throws Exception {
		assertEquals(URI.createURI("file://path%20with%20whitespaces/to/resource"),
				uriExtensions.toUri("file://path%20with%20whitespaces/to/resource"));
	}

	@Test
	public void test_toUri_04() throws Exception {
		assertEquals(URI.createURI("file:///path%20with%20whitespaces/to/resource"),
				uriExtensions.toUri("file:///path%20with%20whitespaces/to/resource"));
	}

	@Test
	public void test_toUri_05() throws Exception {
		assertEquals(URI.createURI("file:///dir/\u0424\u0443%20\u0411\u0430\u0440"),
				uriExtensions.toUri("file:///dir/%D0%A4%D1%83%20%D0%91%D0%B0%D1%80"));
	}

	@Test
	public void test_toUri_06() throws Exception {
		assertEquals(URI.createURI("file://dir/\u0424\u0443%20\u0411\u0430\u0440"),
				uriExtensions.toUri("file://dir/%D0%A4%D1%83%20%D0%91%D0%B0%D1%80"));
	}

	@Test
	public void test_toUri_07() throws Exception {
		assertEquals(URI.createURI("something:/path/to/resource"), uriExtensions.toUri("something:/path/to/resource"));
	}

	@Test
	public void test_toUri_08() throws Exception {
		assertEquals(URI.createURI("something://path/to/resource"),
				uriExtensions.toUri("something://path/to/resource"));
	}

	@Test
	public void test_toUri_09() throws Exception {
		assertEquals(URI.createURI("something:/dir/\u0424\u0443%20\u0411\u0430\u0440"),
				uriExtensions.toUri("something:/dir/%D0%A4%D1%83%20%D0%91%D0%B0%D1%80"));
	}

	@Test
	public void test_toUri_10() throws Exception {
		assertEquals(URI.createURI("something://dir/\u0424\u0443%20\u0411\u0430\u0440"),
				uriExtensions.toUri("something://dir/%D0%A4%D1%83%20%D0%91%D0%B0%D1%80"));
	}

	@Test
	public void test_toUri_11() throws Exception {
		assertEquals(URI.createURI("something:/path%20with%20whitespaces/to/resource"),
				uriExtensions.toUri("something:/path%20with%20whitespaces/to/resource"));
	}

	@Test
	public void test_toUri_12() throws Exception {
		assertEquals(URI.createURI("something://path%20with%20whitespaces/to/resource"),
				uriExtensions.toUri("something://path%20with%20whitespaces/to/resource"));
	}

	@Test
	public void test_toUri_13() throws Exception {
		assertEquals(URI.createURI("file:///c:/Users/dietrich/git/MyDSL_Imports/mydsl/workspace/src/something.mydsl"),
				uriExtensions
						.toUri("file:///c%3A/Users/dietrich/git/MyDSL_Imports/mydsl/workspace/src/something.mydsl"));
	}

	@Test
	public void test_toUri_14() throws Exception {
		assertEquals(URI.createURI("file:///c:/Users/dietrich/\u0424\u0443%20\u0411\u0430\u0440.mydsl"),
				uriExtensions.toUri("file:///c%3A/Users/dietrich/%D0%A4%D1%83%20%D0%91%D0%B0%D1%80.mydsl"));
	}

	@Test
	public void test_toUri_15() throws Exception {
		String uri = "something:/path/to/" + URI.encodeSegment("res ource", false);
		assertEquals(URI.createURI(uri), uriExtensions.toUri(uri));
	}
	
	@Test
	public void test_toUri_15b() throws Exception {
		String uri = "file:/path/to/" + URI.encodeSegment("res ource", false);
		assertEquals(uriExtensions.withEmptyAuthority(URI.createURI(uri)), uriExtensions.toUri(uri));
	}

	@Test
	public void test_toUri_16() throws Exception {
		String uri = "something:/path/to/" + URI.encodeSegment("res#ource", false);
		assertEquals(URI.createURI(uri), uriExtensions.toUri(uri));
	}

	@Test
	public void test_toUri_16b() throws Exception {
		String uri = "file:/path/to/" + URI.encodeSegment("res#ource", false);
		assertEquals(uriExtensions.withEmptyAuthority(URI.createURI(uri)), uriExtensions.toUri(uri));
	}
	
	@Test
	public void test_toUri_17() throws Exception {
		assertEquals(URI.createURI("file:///c:"), uriExtensions.toUri("file:///c%3A"));
	}

	@Test
	public void test_toUri_18() throws Exception {
		assertEquals(URI.createURI("file:///c:/"), uriExtensions.toUri("file:///c%3A/"));
	}

	@Test
	public void test_toUri_19() throws Exception {
		assertEquals(URI.createURI("file:///c:"), uriExtensions.toUri("file:///c:"));
	}

	@Test
	public void test_toUri_20() throws Exception {
		assertEquals(URI.createURI("file:///c:/"), uriExtensions.toUri("file:///c:/"));
	}
	
	@Test
	public void test_toUri_21() throws Exception {
		assertEquals(URI.createURI("file:///c:"), uriExtensions.toUri("file:/c:"));
	}

	@Test
	public void test_toUri_22() throws Exception {
		assertEquals(URI.createURI("file:///c:/"), uriExtensions.toUri("file:/c:/"));
	}
	
	@Test
	public void test_toUri_23() throws Exception {
		assertEquals(URI.createURI("file:///c:/a/path"), uriExtensions.toUri("file:/c:/a/path"));
	}
	
	@Test
	public void test_toUri_24() throws Exception {
		assertEquals(URI.createURI("file://c:"), uriExtensions.toUri("file://c:"));
	}

	@Test
	public void test_toUri_25() throws Exception {
		assertEquals(URI.createURI("file://c:/"), uriExtensions.toUri("file://c:/"));
	}
	
	@Test
	public void test_toUri_26() throws Exception {
		assertEquals(URI.createURI("file://c:/a/path"), uriExtensions.toUri("file://c:/a/path"));
	}
	
	@Test
	public void test_toUriString_01() throws Exception {
		assertEquals("file:///path/to/resource",
				uriExtensions.toUriString(java.net.URI.create("file:///path/to/resource")));
	}

	@Test
	public void test_toUriString_02() throws Exception {
		assertEquals("file://path/to/resource",
				uriExtensions.toUriString(java.net.URI.create("file://path/to/resource")));
	}

	@Test
	public void test_toUriString_03() throws Exception {
		assertEquals("file:///dir/\u0424\u0443%20\u0411\u0430\u0440",
				uriExtensions.toUriString(java.net.URI.create("file:/dir/\u0424\u0443%20\u0411\u0430\u0440")));
	}

	@Test
	public void test_toUriString_04() throws Exception {
		assertEquals("file://dir/\u0424\u0443%20\u0411\u0430\u0440",
				uriExtensions.toUriString(java.net.URI.create("file://dir/\u0424\u0443%20\u0411\u0430\u0440")));
	}

	@Test
	public void test_toUriString_05() throws Exception {
		assertEquals("file://path/to/resource/",
				uriExtensions.toUriString(java.net.URI.create("file://path/to/resource/")));
	}

	@Test
	public void test_toUriString_06() throws Exception {
		assertEquals("file:///path/to/resource/",
				uriExtensions.toUriString(java.net.URI.create("file:/path/to/resource/")));
	}

	@Test
	public void test_toUriString_07() throws Exception {
		assertEquals("file:///path/to/resource/",
				uriExtensions.toUriString(java.net.URI.create("file:///path/to/resource/")));
	}

	@Test
	public void test_symmetric_01() throws Exception {
		assertEquals(URI.createURI("file:///path/to/resource"),
				uriExtensions.toUri(uriExtensions.toUriString(java.net.URI.create("file:///path/to/resource"))));
	}

	@Test
	public void test_symmetric_02() throws Exception {
		assertEquals(URI.createURI("file://path/to/resource"),
				uriExtensions.toUri(uriExtensions.toUriString(java.net.URI.create("file://path/to/resource"))));
	}

	@Test
	public void test_symmetric_03() throws Exception {
		assertEquals(URI.createURI("something:/path/to/resource"),
				uriExtensions.toUri(uriExtensions.toUriString(java.net.URI.create("something:/path/to/resource"))));
	}

	@Test
	public void test_symmetric_04() throws Exception {
		assertEquals(URI.createURI("something://path/to/resource"),
				uriExtensions.toUri(uriExtensions.toUriString(java.net.URI.create("something://path/to/resource"))));
	}

	@Test
	public void testConversion() throws Exception {
		assertEquals("file:///dir/name.ext", uriExtensions.toUriString(uriExtensions.toUri("file:///dir/name.ext")));
	}

	@Test
	public void testFileUriConversion() throws Exception {
		final String expected = Paths.get(new File(".").getCanonicalPath()).resolve("dir").resolve("name.ext").toUri()
				.toString();
		assertEquals(expected,
				uriExtensions.toUriString(URI.createFileURI(new File("dir/name.ext").getAbsolutePath())));
	}

	@Test
	public void testFilesWithSpaces() throws Exception {
		final URI x = uriExtensions.toUri("file:///dir/Foo%20Bar.testlang");
		final String y = uriExtensions.toUriString(x);
		assertEquals("file:///dir/Foo%20Bar.testlang", y);
	}

	@Test
	public void testFilesWithCyrillicSymbols() throws Exception {
		assertEquals("file:///dir/\u0424\u0443%20\u0411\u0430\u0440.testlang", uriExtensions
				.toUriString(uriExtensions.toUri("file:///dir/%D0%A4%D1%83%20%D0%91%D0%B0%D1%80.testlang")));
	}

	@Test
	public void testFolderIsPrefix() throws Exception {
		File directory = new File("./test-data2/test-project");
		directory.mkdirs();
		assertTrue(directory.exists());
		assertTrue(directory.isDirectory());
		URI uri = uriExtensions.toUri(uriExtensions.toUriString(URI.createFileURI(directory.getAbsolutePath() + "/")));
		assertTrue(uri.isPrefix());
	}

	@Test
	public void testFolderIsPrefixWithWhitespace() throws Exception {
		File directory = createTempDir("some name with whitespaces").toFile();
		assertTrue(directory.exists());
		assertTrue(directory.isDirectory());
		assertTrue(CharMatcher.whitespace().matchesAnyOf(directory.getName()));
		URI uri = uriExtensions.toUri(uriExtensions.toUriString(URI.createFileURI(directory.getAbsolutePath() + "/")));
		assertTrue(uri.isPrefix());
	}

	@Test
	public void test_withEmptyAuthority() throws Exception {
		final URI uriWithoutAuthority = URI.createURI("file:/path/to/resource/");
		assertNull(uriWithoutAuthority.authority());
		final URI uriWithEmptyAuthority = uriExtensions.withEmptyAuthority(uriWithoutAuthority);
		assertNotSame(uriWithoutAuthority, uriWithEmptyAuthority);
		assertEquals("Returned URI is expected to have an empty instead of null authority", "",
				uriWithEmptyAuthority.authority());
		final URI uriWithAuthority = URI.createURI("https://xtext.org/path/to/resource/");
		assertNotNull(uriWithAuthority.authority());
		assertEquals("xtext.org", uriWithAuthority.authority());
		assertSame(uriWithAuthority, uriExtensions.withEmptyAuthority(uriWithAuthority));
	}

	private Path createTempDir(final String prefix) throws Exception {
		return Files.createTempDirectory(getTempDirPath(), prefix);
	}

	private Path getTempDirPath() {
		return Paths.get(StandardSystemProperty.JAVA_IO_TMPDIR.value());
	}
}
