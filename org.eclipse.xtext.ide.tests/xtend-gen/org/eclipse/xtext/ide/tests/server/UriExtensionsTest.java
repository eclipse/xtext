/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import com.google.common.base.CharMatcher;
import com.google.common.base.StandardSystemProperty;
import com.google.inject.Inject;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ide.server.UriExtensions;
import org.eclipse.xtext.ide.tests.testlanguage.TestLanguageIdeInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(TestLanguageIdeInjectorProvider.class)
@SuppressWarnings("all")
public class UriExtensionsTest {
  @Inject
  @Extension
  private UriExtensions _uriExtensions;
  
  @Test
  public void test_toUri01() {
    Assert.assertEquals(
      URI.createURI("file://path/to/resource"), 
      this._uriExtensions.toUri("file://path/to/resource"));
  }
  
  @Test
  public void test_toUri_02() {
    Assert.assertEquals(
      URI.createURI("file:///path/to/resource"), 
      this._uriExtensions.toUri("file:///path/to/resource"));
  }
  
  @Test
  public void test_toUri03() {
    Assert.assertEquals(
      URI.createURI("file://path%20with%20whitespaces/to/resource"), 
      this._uriExtensions.toUri("file://path%20with%20whitespaces/to/resource"));
  }
  
  @Test
  public void test_toUri_04() {
    Assert.assertEquals(
      URI.createURI("file:///path%20with%20whitespaces/to/resource"), 
      this._uriExtensions.toUri("file:///path%20with%20whitespaces/to/resource"));
  }
  
  @Test
  public void test_toUri_05() {
    Assert.assertEquals(
      URI.createURI("file:///dir/\u0424\u0443%20\u0411\u0430\u0440"), 
      this._uriExtensions.toUri("file:///dir/%D0%A4%D1%83%20%D0%91%D0%B0%D1%80"));
  }
  
  @Test
  public void test_toUri_06() {
    Assert.assertEquals(
      URI.createURI("file://dir/\u0424\u0443%20\u0411\u0430\u0440"), 
      this._uriExtensions.toUri("file://dir/%D0%A4%D1%83%20%D0%91%D0%B0%D1%80"));
  }
  
  @Test
  public void test_toUri_07() {
    Assert.assertEquals(
      URI.createURI("something:/path/to/resource"), 
      this._uriExtensions.toUri("something:/path/to/resource"));
  }
  
  @Test
  public void test_toUri_08() {
    Assert.assertEquals(
      URI.createURI("something://path/to/resource"), 
      this._uriExtensions.toUri("something://path/to/resource"));
  }
  
  @Test
  public void test_toUri_09() {
    Assert.assertEquals(
      URI.createURI("something:/dir/\u0424\u0443%20\u0411\u0430\u0440"), 
      this._uriExtensions.toUri("something:/dir/%D0%A4%D1%83%20%D0%91%D0%B0%D1%80"));
  }
  
  @Test
  public void test_toUri_10() {
    Assert.assertEquals(
      URI.createURI("something://dir/\u0424\u0443%20\u0411\u0430\u0440"), 
      this._uriExtensions.toUri("something://dir/%D0%A4%D1%83%20%D0%91%D0%B0%D1%80"));
  }
  
  @Test
  public void test_toUri_11() {
    Assert.assertEquals(
      URI.createURI("something:/path%20with%20whitespaces/to/resource"), 
      this._uriExtensions.toUri("something:/path%20with%20whitespaces/to/resource"));
  }
  
  @Test
  public void test_toUri_12() {
    Assert.assertEquals(
      URI.createURI("something://path%20with%20whitespaces/to/resource"), 
      this._uriExtensions.toUri("something://path%20with%20whitespaces/to/resource"));
  }
  
  @Test
  public void test_toUri_13() {
    Assert.assertEquals(
      URI.createURI("file:///c:/Users/dietrich/git/MyDSL_Imports/mydsl/workspace/src/something.mydsl"), 
      this._uriExtensions.toUri("file:///c%3A/Users/dietrich/git/MyDSL_Imports/mydsl/workspace/src/something.mydsl"));
  }
  
  @Test
  public void test_toUri_14() {
    Assert.assertEquals(
      URI.createURI("file:///c:/Users/dietrich/\u0424\u0443%20\u0411\u0430\u0440.mydsl"), 
      this._uriExtensions.toUri("file:///c%3A/Users/dietrich/%D0%A4%D1%83%20%D0%91%D0%B0%D1%80.mydsl"));
  }
  
  @Test
  public void test_toUriString_01() {
    Assert.assertEquals(
      "file:///path/to/resource", 
      this._uriExtensions.toUriString(java.net.URI.create("file:///path/to/resource")));
  }
  
  @Test
  public void test_toUriString_02() {
    Assert.assertEquals(
      "file://path/to/resource", 
      this._uriExtensions.toUriString(java.net.URI.create("file://path/to/resource")));
  }
  
  @Test
  public void test_toUriString_03() {
    Assert.assertEquals(
      "file:///dir/\u0424\u0443%20\u0411\u0430\u0440", 
      this._uriExtensions.toUriString(java.net.URI.create("file:/dir/\u0424\u0443%20\u0411\u0430\u0440")));
  }
  
  @Test
  public void test_toUriString_04() {
    Assert.assertEquals(
      "file://dir/\u0424\u0443%20\u0411\u0430\u0440", 
      this._uriExtensions.toUriString(java.net.URI.create("file://dir/\u0424\u0443%20\u0411\u0430\u0440")));
  }
  
  @Test
  public void test_toUriString_05() {
    Assert.assertEquals(
      "file://path/to/resource/", 
      this._uriExtensions.toUriString(java.net.URI.create("file://path/to/resource/")));
  }
  
  @Test
  public void test_toUriString_06() {
    Assert.assertEquals(
      "file:///path/to/resource/", 
      this._uriExtensions.toUriString(java.net.URI.create("file:/path/to/resource/")));
  }
  
  @Test
  public void test_toUriString_07() {
    Assert.assertEquals(
      "file:///path/to/resource/", 
      this._uriExtensions.toUriString(java.net.URI.create("file:///path/to/resource/")));
  }
  
  @Test
  public void test_symmetric_01() {
    Assert.assertEquals(
      URI.createURI("file:///path/to/resource"), 
      this._uriExtensions.toUri(this._uriExtensions.toUriString(java.net.URI.create("file:///path/to/resource"))));
  }
  
  @Test
  public void test_symmetric_02() {
    Assert.assertEquals(
      URI.createURI("file://path/to/resource"), 
      this._uriExtensions.toUri(this._uriExtensions.toUriString(java.net.URI.create("file://path/to/resource"))));
  }
  
  @Test
  public void test_symmetric_03() {
    Assert.assertEquals(
      URI.createURI("something:/path/to/resource"), 
      this._uriExtensions.toUri(this._uriExtensions.toUriString(java.net.URI.create("something:/path/to/resource"))));
  }
  
  @Test
  public void test_symmetric_04() {
    Assert.assertEquals(
      URI.createURI("something://path/to/resource"), 
      this._uriExtensions.toUri(this._uriExtensions.toUriString(java.net.URI.create("something://path/to/resource"))));
  }
  
  @Test
  public void testConversion() {
    Assert.assertEquals("file:///dir/name.ext", this._uriExtensions.toUriString(this._uriExtensions.toUri("file:///dir/name.ext")));
  }
  
  @Test
  public void testFileUriConversion() {
    try {
      final String expected = Paths.get(new File(".").getCanonicalPath()).resolve("dir").resolve("name.ext").toUri().toString();
      Assert.assertEquals(expected, this._uriExtensions.toUriString(URI.createFileURI(new File("dir/name.ext").getAbsolutePath())));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFilesWithSpaces() {
    final URI x = this._uriExtensions.toUri("file:///dir/Foo%20Bar.testlang");
    final String y = this._uriExtensions.toUriString(x);
    Assert.assertEquals("file:///dir/Foo%20Bar.testlang", y);
  }
  
  @Test
  public void testFilesWithCyrillicSymbols() {
    Assert.assertEquals("file:///dir/\u0424\u0443%20\u0411\u0430\u0440.testlang", 
      this._uriExtensions.toUriString(this._uriExtensions.toUri("file:///dir/%D0%A4%D1%83%20%D0%91%D0%B0%D1%80.testlang")));
  }
  
  @Test
  public void testFolderIsPrefix() {
    File directory = new File("./test-data2/test-project");
    directory.mkdirs();
    Assert.assertTrue(directory.exists());
    Assert.assertTrue(directory.isDirectory());
    String _absolutePath = directory.getAbsolutePath();
    String _plus = (_absolutePath + "/");
    URI uri = this._uriExtensions.toUri(this._uriExtensions.toUriString(URI.createFileURI(_plus)));
    Assert.assertTrue(uri.isPrefix());
  }
  
  @Test
  public void testFolderIsPrefixWithWhitespace() {
    File directory = this.createTempDir("some name with whitespaces").toFile();
    Assert.assertTrue(directory.exists());
    Assert.assertTrue(directory.isDirectory());
    Assert.assertTrue(CharMatcher.whitespace().matchesAnyOf(directory.getName()));
    String _absolutePath = directory.getAbsolutePath();
    String _plus = (_absolutePath + "/");
    URI uri = this._uriExtensions.toUri(this._uriExtensions.toUriString(URI.createFileURI(_plus)));
    Assert.assertTrue(uri.isPrefix());
  }
  
  @Test
  public void test_withEmptyAuthority() {
    final URI uriWithoutAuthority = URI.createURI("file:/path/to/resource/");
    Assert.assertNull(uriWithoutAuthority.authority());
    final URI uriWithEmptyAuthority = this._uriExtensions.withEmptyAuthority(uriWithoutAuthority);
    Assert.assertNotSame(uriWithoutAuthority, uriWithEmptyAuthority);
    Assert.assertEquals("Returned URI is expected to have an empty instead of null authority", "", uriWithEmptyAuthority.authority());
    final URI uriWithAuthority = URI.createURI("https://xtext.org/path/to/resource/");
    Assert.assertNotNull(uriWithAuthority.authority());
    Assert.assertEquals("xtext.org", uriWithAuthority.authority());
    Assert.assertSame(uriWithAuthority, this._uriExtensions.withEmptyAuthority(uriWithAuthority));
  }
  
  private Path createTempDir(final String prefix) {
    try {
      return Files.createTempDirectory(this.getTempDirPath(), prefix);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private Path getTempDirPath() {
    return Paths.get(StandardSystemProperty.JAVA_IO_TMPDIR.value());
  }
}
