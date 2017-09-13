/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.server;

import com.google.common.base.CharMatcher;
import com.google.common.base.StandardSystemProperty;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.inject.Inject;
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
      URI.createURI("file:///path/to/resource"), 
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
      URI.createURI("file:///path with whitespaces/to/resource"), 
      this._uriExtensions.toUri("file://path with whitespaces/to/resource"));
  }
  
  @Test
  public void test_toUri_04() {
    Assert.assertEquals(
      URI.createURI("file:///path with whitespaces/to/resource"), 
      this._uriExtensions.toUri("file:///path with whitespaces/to/resource"));
  }
  
  @Test
  public void test_toUri_05() {
    Assert.assertEquals(
      URI.createURI("file:///dir/\u0424\u0443 \u0411\u0430\u0440"), 
      this._uriExtensions.toUri("file:///dir/\u0424\u0443 \u0411\u0430\u0440"));
  }
  
  @Test
  public void test_toUri_06() {
    Assert.assertEquals(
      URI.createURI("file:///dir/\u0424\u0443 \u0411\u0430\u0440"), 
      this._uriExtensions.toUri("file://dir/\u0424\u0443 \u0411\u0430\u0440"));
  }
  
  @Test
  public void test_toUri_07() {
    Assert.assertEquals(
      URI.createURI("file:///path/to/resource"), 
      this._uriExtensions.toUri("file://localhost/path/to/resource"));
  }
  
  @Test
  public void test_toUri_08() {
    Assert.assertEquals(
      URI.createURI("file:///dir/\u0424\u0443 \u0411\u0430\u0440"), 
      this._uriExtensions.toUri("file://localhost/dir/\u0424\u0443 \u0411\u0430\u0440"));
  }
  
  @Test
  public void test_toUri_09() {
    Assert.assertEquals(
      URI.createURI("something:/path/to/resource"), 
      this._uriExtensions.toUri("something:/path/to/resource"));
  }
  
  @Test
  public void test_toUri_10() {
    Assert.assertEquals(
      URI.createURI("something://path/to/resource"), 
      this._uriExtensions.toUri("something://path/to/resource"));
  }
  
  @Test
  public void test_toUri_11() {
    Assert.assertEquals(
      URI.createURI("something:/dir/\u0424\u0443 \u0411\u0430\u0440"), 
      this._uriExtensions.toUri("something:/dir/\u0424\u0443 \u0411\u0430\u0440"));
  }
  
  @Test
  public void test_toUri_12() {
    Assert.assertEquals(
      URI.createURI("something://dir/\u0424\u0443 \u0411\u0430\u0440"), 
      this._uriExtensions.toUri("something://dir/\u0424\u0443 \u0411\u0430\u0440"));
  }
  
  @Test
  public void test_toUri_13() {
    Assert.assertEquals(
      URI.createURI("something:/path with whitespaces/to/resource"), 
      this._uriExtensions.toUri("something:/path with whitespaces/to/resource"));
  }
  
  @Test
  public void test_toUri_14() {
    Assert.assertEquals(
      URI.createURI("something://path with whitespaces/to/resource"), 
      this._uriExtensions.toUri("something://path with whitespaces/to/resource"));
  }
  
  @Test
  public void test_toPath_01() {
    Assert.assertEquals(
      "file:///path/to/resource", 
      this._uriExtensions.toPath(java.net.URI.create("file:///path/to/resource")));
  }
  
  @Test
  public void test_toPath_02() {
    Assert.assertEquals(
      "file:///path/to/resource", 
      this._uriExtensions.toPath(java.net.URI.create("file://path/to/resource")));
  }
  
  @Test
  public void test_toPath_03() {
    Assert.assertEquals(
      "file:///dir/\u0424\u0443%20\u0411\u0430\u0440", 
      this._uriExtensions.toPath(java.net.URI.create("file:///dir/\u0424\u0443%20\u0411\u0430\u0440")));
  }
  
  @Test
  public void test_toPath_04() {
    Assert.assertEquals(
      "file:///dir/\u0424\u0443%20\u0411\u0430\u0440", 
      this._uriExtensions.toPath(java.net.URI.create("file://dir/\u0424\u0443%20\u0411\u0430\u0440")));
  }
  
  @Test
  public void test_toPath_05() {
    Assert.assertEquals(
      "file:///path/to/resource", 
      this._uriExtensions.toPath(java.net.URI.create("file://localhost/path/to/resource")));
  }
  
  @Test
  public void test_toPath_06() {
    Assert.assertEquals(
      "file:///path/to/resource/", 
      this._uriExtensions.toPath(java.net.URI.create("file://path/to/resource/")));
  }
  
  @Test
  public void test_toPath_07() {
    Assert.assertEquals(
      "file:///path/to/resource/", 
      this._uriExtensions.toPath(java.net.URI.create("file:///path/to/resource/")));
  }
  
  @Test
  public void test_symmetric_01() {
    Assert.assertEquals(
      URI.createURI("file:///path/to/resource"), 
      this._uriExtensions.toUri(this._uriExtensions.toPath(java.net.URI.create("file:///path/to/resource"))));
  }
  
  @Test
  public void test_symmetric_02() {
    Assert.assertEquals(
      URI.createURI("file:///path/to/resource"), 
      this._uriExtensions.toUri(this._uriExtensions.toPath(java.net.URI.create("file://path/to/resource"))));
  }
  
  @Test
  public void test_symmetric_03() {
    Assert.assertEquals(
      URI.createURI("something:/path/to/resource"), 
      this._uriExtensions.toUri(this._uriExtensions.toPath(java.net.URI.create("something:/path/to/resource"))));
  }
  
  @Test
  public void test_symmetric_04() {
    Assert.assertEquals(
      URI.createURI("something://path/to/resource"), 
      this._uriExtensions.toUri(this._uriExtensions.toPath(java.net.URI.create("something://path/to/resource"))));
  }
  
  @Test
  public void testConversion() {
    Assert.assertEquals("file:///dir/name.ext", this._uriExtensions.toPath(this._uriExtensions.toUri("file:///dir/name.ext")));
  }
  
  @Test
  public void testFileUriConversion() {
    Assert.assertEquals("file:///dir/name.ext", this._uriExtensions.toPath(URI.createFileURI("/dir/name.ext")));
  }
  
  @Test
  public void testFilesWithSpaces() {
    Assert.assertEquals("file:///dir/Foo Bar.testlang", this._uriExtensions.toPath(this._uriExtensions.toUri("file:///dir/Foo Bar.testlang")));
  }
  
  @Test
  public void testFilesWithCyrillicSymbols() {
    Assert.assertEquals("file:///dir/\u0424\u0443 \u0411\u0430\u0440.testlang", 
      this._uriExtensions.toPath(this._uriExtensions.toUri("file:///dir/\u0424\u0443 \u0411\u0430\u0440.testlang")));
  }
  
  @Test
  public void testFolderIsPrefix() {
    File directory = new File("./test-data/test-project");
    Assert.assertTrue(directory.exists());
    Assert.assertTrue(directory.isDirectory());
    URI uri = this._uriExtensions.toUri(this._uriExtensions.toPath(URI.createFileURI(directory.getAbsolutePath())));
    Assert.assertTrue(uri.isPrefix());
  }
  
  @Test
  public void testFolderIsPrefixWithExplicitSuffix() {
    File directory = new File("./test-data/test-project");
    Assert.assertTrue(directory.exists());
    Assert.assertTrue(directory.isDirectory());
    String _absolutePath = directory.getAbsolutePath();
    String _plus = (_absolutePath + "/");
    URI uri = this._uriExtensions.toUri(this._uriExtensions.toPath(URI.createFileURI(_plus)));
    Assert.assertTrue(uri.isPrefix());
  }
  
  @Test
  public void testFolderIsPrefixWithWhitespace() {
    File directory = this.createTempDir("some name with whitespaces").toFile();
    Assert.assertTrue(directory.exists());
    Assert.assertTrue(directory.isDirectory());
    Assert.assertTrue(CharMatcher.WHITESPACE.matchesAnyOf(directory.getName()));
    URI uri = this._uriExtensions.toUri(this._uriExtensions.toPath(URI.createFileURI(directory.getAbsolutePath())));
    Assert.assertTrue(uri.isPrefix());
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
