/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.standalone.incremental;

import com.google.common.io.Files;
import java.io.File;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.builder.standalone.incremental.FilesAndURIs;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class FilesAndURIsTest {
  @Test
  public void testDirsVsFiles() {
    final File tmpDir = Files.createTempDir();
    final File tmpFile = new File(tmpDir, "tmp.tmp");
    try {
      final URI dirURI = FilesAndURIs.asURI(tmpDir);
      boolean _hasTrailingPathSeparator = dirURI.hasTrailingPathSeparator();
      Assert.assertTrue(_hasTrailingPathSeparator);
      String _lastSegment = dirURI.lastSegment();
      Assert.assertEquals("", _lastSegment);
      final URI fileURI = FilesAndURIs.asURI(tmpFile);
      boolean _hasTrailingPathSeparator_1 = fileURI.hasTrailingPathSeparator();
      Assert.assertFalse(_hasTrailingPathSeparator_1);
      String _lastSegment_1 = fileURI.lastSegment();
      Assert.assertNotSame("", _lastSegment_1);
    } finally {
      tmpDir.delete();
    }
  }
  
  @Test
  public void testRelativeURI() {
    this.assertRelativeURI("bar/Foo.txt", "file:/foo/bar/Foo.txt", "file:/foo/");
    this.assertRelativeURI(null, "file:/foo/bar/Foo.txt", "file:/foo/baz/Foo.txt");
    this.assertRelativeURI(null, "file:/foo/bar/Foo.txt", "file:/foo");
    this.assertRelativeURI(null, "file:/foo/bar/Foo.txt", "file:/foo/bar/Foo.txt/");
    this.assertRelativeURI(null, "http:/foo/bar/Foo.txt", "file:/foo/bar/Foo.txt/");
    this.assertRelativeURI("Foo.txt", "file:/foo/bar/Foo.txt", "file:/foo/", "file:/foo/bar/");
    this.assertRelativeURI("Foo.txt", "file:/foo/bar/Foo.txt", "file:/foo/bar/", "file:/foo/");
  }
  
  @Test
  public void testDotInURI() {
    URI _createURI = URI.createURI("file:/Users/./Foo/bar");
    String _asPath = FilesAndURIs.asPath(_createURI);
    Assert.assertEquals("/Users/Foo/bar", _asPath);
    URI _createURI_1 = URI.createURI("file:/Users/./Foo/bar");
    File _asFile = FilesAndURIs.asFile(_createURI_1);
    String _path = _asFile.getPath();
    Assert.assertEquals("/Users/Foo/bar", _path);
    URI _asFileURI = FilesAndURIs.asFileURI("/Users/./Foo/bar");
    String _string = _asFileURI.toString();
    Assert.assertEquals("file:/Users/Foo/bar", _string);
    File _file = new File("/Users/./Foo/bar");
    URI _asURI = FilesAndURIs.asURI(_file);
    String _string_1 = _asURI.toString();
    Assert.assertEquals("file:/Users/Foo/bar", _string_1);
  }
  
  public void assertRelativeURI(final String expected, final String absoluteURI, final String... baseURIs) {
    URI _asURI = null;
    if (expected!=null) {
      _asURI=FilesAndURIs.asURI(expected);
    }
    URI _asURI_1 = FilesAndURIs.asURI(absoluteURI);
    final Function1<String, URI> _function = new Function1<String, URI>() {
      @Override
      public URI apply(final String it) {
        return FilesAndURIs.asURI(it);
      }
    };
    List<URI> _map = ListExtensions.<String, URI>map(((List<String>)Conversions.doWrapArray(baseURIs)), _function);
    URI _findRelativeURI = FilesAndURIs.findRelativeURI(_asURI_1, _map);
    Assert.assertEquals(_asURI, _findRelativeURI);
  }
}
