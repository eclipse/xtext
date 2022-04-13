/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.lib;

import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class PathTest {
  @Test
  public void testPath() {
    final Path p = new Path("/foo/bar/baz.txt");
    Assert.assertTrue(p.isAbsolute());
    Assert.assertEquals("baz.txt", p.getLastSegment());
    Assert.assertEquals("txt", p.getFileExtension());
    Assert.assertEquals("foo", IterableExtensions.<String>head(p.getSegments()));
    Assert.assertEquals("bar", p.getSegments().get(1));
    Assert.assertEquals(3, p.getSegments().size());
    Assert.assertEquals("/foo/bar/baz.txt", p.toString());
  }

  @Test
  public void testPathConstructor() {
    Assert.assertEquals("/foo/bar/baz.txt", new Path("/foo/bar/baz.txt").toString());
    Assert.assertEquals("/foo/bar/baz.txt", new Path("/foo////bar/   baz.txt").toString());
    Assert.assertEquals("foo/bar/baz.txt", new Path("foo/bar/baz.txt").toString());
    Assert.assertEquals("foo/bar/baz.txt", new Path("    foo   /bar/baz.txt").toString());
    Assert.assertEquals("/bar/baz.txt", new Path("/foo/../bar/baz.txt").toString());
    Assert.assertEquals("bar/baz.txt", new Path("foo/../bar/baz.txt").toString());
    Assert.assertEquals("../bar/baz.txt", new Path("../bar/baz.txt").toString());
    Assert.assertEquals("../..", new Path("../..").toString());
    Assert.assertEquals("../..", new Path("../foo/.././..").toString());
  }

  @Test
  public void testPathStartsWith() {
    Path _path = new Path("/foo/bar/baz.txt");
    Path _path_1 = new Path("/");
    Assert.assertTrue(_path.startsWith(_path_1));
    Path _path_2 = new Path("/foo/bar/baz.txt");
    Path _path_3 = new Path("/foo");
    Assert.assertTrue(_path_2.startsWith(_path_3));
    Path _path_4 = new Path("/foo/bar/baz.txt");
    Path _path_5 = new Path("/foo/bar");
    Assert.assertTrue(_path_4.startsWith(_path_5));
    Path _path_6 = new Path("/foo/bar/baz.txt");
    Path _path_7 = new Path("/foo/bar/baz.txt");
    Assert.assertTrue(_path_6.startsWith(_path_7));
    Path _path_8 = new Path("/foo/bar/baz.txt");
    Path _path_9 = new Path("foo");
    Assert.assertFalse(_path_8.startsWith(_path_9));
    Path _path_10 = new Path("/foo/bar/baz.txt");
    Path _path_11 = new Path("foo/bar/baz.txt");
    Assert.assertFalse(_path_10.startsWith(_path_11));
    Path _path_12 = new Path("/foo/bar/baz.txt");
    Path _path_13 = new Path("/foo/bar/baz");
    Assert.assertFalse(_path_12.startsWith(_path_13));
  }

  @Test
  public void testPathGetAbsolutePath() {
    Path _path = new Path("/foo");
    Assert.assertEquals(_path, new Path("/foo/bar/baz.txt").getAbsolutePath("../.."));
  }

  @Test
  public void testAppend() {
    Path _path = new Path("/foo/bar");
    Assert.assertEquals(_path, new Path("/foo").append("bar"));
    Path _path_1 = new Path("/foo/bar");
    Assert.assertEquals(_path_1, new Path("/foo").append("/bar"));
    Path _path_2 = new Path("foo/bar");
    Assert.assertEquals(_path_2, new Path("foo").append("/bar"));
    Path _path_3 = new Path("foo");
    Assert.assertEquals(_path_3, new Path("foo/bar").append(".."));
    Path _path_4 = new Path("foo/file.txt");
    Assert.assertEquals(_path_4, new Path("foo/bar").append("../xfoo/../file.txt"));
  }

  @Test
  public void testRelativize() {
    Path _path = new Path("foo");
    Assert.assertEquals(_path, new Path("/hubba/bubba/foo").relativize("/hubba/bubba"));
    Path _path_1 = new Path("foo");
    Assert.assertEquals(_path_1, new Path("hubba/bubba/foo").relativize("hubba/bubba"));
    try {
      new Path("hubba/bubba/foo").relativize("/hubba/bubba");
    } catch (final Throwable _t) {
      if (_t instanceof IllegalArgumentException) {
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    try {
      new Path("/hubba/bubba/foo").relativize("hubba/bubba");
    } catch (final Throwable _t) {
      if (_t instanceof IllegalArgumentException) {
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    Assert.assertNull(new Path("/foo").relativize("/bar"));
  }

  @Test
  public void testRelativizeBothDirections() {
    final Path base = new Path("/hubba/bubba");
    final Path child = new Path("/hubba/bubba/bar");
    Path _path = new Path("bar");
    Assert.assertEquals(_path, base.relativize(child));
    Path _path_1 = new Path("bar");
    Assert.assertEquals(_path_1, child.relativize(base));
  }
}
