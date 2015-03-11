/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.lib;

import java.util.List;
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
    boolean _isAbsolute = p.isAbsolute();
    Assert.assertTrue(_isAbsolute);
    String _lastSegment = p.getLastSegment();
    Assert.assertEquals("baz.txt", _lastSegment);
    String _fileExtension = p.getFileExtension();
    Assert.assertEquals("txt", _fileExtension);
    List<String> _segments = p.getSegments();
    String _head = IterableExtensions.<String>head(_segments);
    Assert.assertEquals("foo", _head);
    List<String> _segments_1 = p.getSegments();
    String _get = _segments_1.get(1);
    Assert.assertEquals("bar", _get);
    List<String> _segments_2 = p.getSegments();
    int _size = _segments_2.size();
    Assert.assertEquals(3, _size);
    String _string = p.toString();
    Assert.assertEquals("/foo/bar/baz.txt", _string);
  }
  
  @Test
  public void testPathConstructor() {
    Path _path = new Path("/foo/bar/baz.txt");
    String _string = _path.toString();
    Assert.assertEquals("/foo/bar/baz.txt", _string);
    Path _path_1 = new Path("/foo////bar/   baz.txt");
    String _string_1 = _path_1.toString();
    Assert.assertEquals("/foo/bar/baz.txt", _string_1);
    Path _path_2 = new Path("foo/bar/baz.txt");
    String _string_2 = _path_2.toString();
    Assert.assertEquals("foo/bar/baz.txt", _string_2);
    Path _path_3 = new Path("    foo   /bar/baz.txt");
    String _string_3 = _path_3.toString();
    Assert.assertEquals("foo/bar/baz.txt", _string_3);
    Path _path_4 = new Path("/foo/../bar/baz.txt");
    String _string_4 = _path_4.toString();
    Assert.assertEquals("/bar/baz.txt", _string_4);
    Path _path_5 = new Path("foo/../bar/baz.txt");
    String _string_5 = _path_5.toString();
    Assert.assertEquals("bar/baz.txt", _string_5);
    Path _path_6 = new Path("../bar/baz.txt");
    String _string_6 = _path_6.toString();
    Assert.assertEquals("../bar/baz.txt", _string_6);
    Path _path_7 = new Path("../..");
    String _string_7 = _path_7.toString();
    Assert.assertEquals("../..", _string_7);
    Path _path_8 = new Path("../foo/.././..");
    String _string_8 = _path_8.toString();
    Assert.assertEquals("../..", _string_8);
  }
  
  @Test
  public void testPathStartsWith() {
    Path _path = new Path("/foo/bar/baz.txt");
    Path _path_1 = new Path("/");
    boolean _startsWith = _path.startsWith(_path_1);
    Assert.assertTrue(_startsWith);
    Path _path_2 = new Path("/foo/bar/baz.txt");
    Path _path_3 = new Path("/foo");
    boolean _startsWith_1 = _path_2.startsWith(_path_3);
    Assert.assertTrue(_startsWith_1);
    Path _path_4 = new Path("/foo/bar/baz.txt");
    Path _path_5 = new Path("/foo/bar");
    boolean _startsWith_2 = _path_4.startsWith(_path_5);
    Assert.assertTrue(_startsWith_2);
    Path _path_6 = new Path("/foo/bar/baz.txt");
    Path _path_7 = new Path("/foo/bar/baz.txt");
    boolean _startsWith_3 = _path_6.startsWith(_path_7);
    Assert.assertTrue(_startsWith_3);
    Path _path_8 = new Path("/foo/bar/baz.txt");
    Path _path_9 = new Path("foo");
    boolean _startsWith_4 = _path_8.startsWith(_path_9);
    Assert.assertFalse(_startsWith_4);
    Path _path_10 = new Path("/foo/bar/baz.txt");
    Path _path_11 = new Path("foo/bar/baz.txt");
    boolean _startsWith_5 = _path_10.startsWith(_path_11);
    Assert.assertFalse(_startsWith_5);
    Path _path_12 = new Path("/foo/bar/baz.txt");
    Path _path_13 = new Path("/foo/bar/baz");
    boolean _startsWith_6 = _path_12.startsWith(_path_13);
    Assert.assertFalse(_startsWith_6);
  }
  
  @Test
  public void testPathGetAbsolutePath() {
    Path _path = new Path("/foo");
    Path _path_1 = new Path("/foo/bar/baz.txt");
    Path _absolutePath = _path_1.getAbsolutePath("../..");
    Assert.assertEquals(_path, _absolutePath);
  }
  
  @Test
  public void testAppend() {
    Path _path = new Path("/foo/bar");
    Path _path_1 = new Path("/foo");
    Path _append = _path_1.append("bar");
    Assert.assertEquals(_path, _append);
    Path _path_2 = new Path("/foo/bar");
    Path _path_3 = new Path("/foo");
    Path _append_1 = _path_3.append("/bar");
    Assert.assertEquals(_path_2, _append_1);
    Path _path_4 = new Path("foo/bar");
    Path _path_5 = new Path("foo");
    Path _append_2 = _path_5.append("/bar");
    Assert.assertEquals(_path_4, _append_2);
    Path _path_6 = new Path("foo");
    Path _path_7 = new Path("foo/bar");
    Path _append_3 = _path_7.append("..");
    Assert.assertEquals(_path_6, _append_3);
    Path _path_8 = new Path("foo/file.txt");
    Path _path_9 = new Path("foo/bar");
    Path _append_4 = _path_9.append("../xfoo/../file.txt");
    Assert.assertEquals(_path_8, _append_4);
  }
  
  @Test
  public void testRelativize() {
    Path _path = new Path("foo");
    Path _path_1 = new Path("/hubba/bubba/foo");
    Path _relativize = _path_1.relativize("/hubba/bubba");
    Assert.assertEquals(_path, _relativize);
    Path _path_2 = new Path("foo");
    Path _path_3 = new Path("hubba/bubba/foo");
    Path _relativize_1 = _path_3.relativize("hubba/bubba");
    Assert.assertEquals(_path_2, _relativize_1);
    try {
      Path _path_4 = new Path("hubba/bubba/foo");
      _path_4.relativize("/hubba/bubba");
    } catch (final Throwable _t) {
      if (_t instanceof IllegalArgumentException) {
        final IllegalArgumentException e = (IllegalArgumentException)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    try {
      Path _path_5 = new Path("/hubba/bubba/foo");
      _path_5.relativize("hubba/bubba");
    } catch (final Throwable _t_1) {
      if (_t_1 instanceof IllegalArgumentException) {
        final IllegalArgumentException e_1 = (IllegalArgumentException)_t_1;
      } else {
        throw Exceptions.sneakyThrow(_t_1);
      }
    }
    Path _path_6 = new Path("/foo");
    Path _relativize_2 = _path_6.relativize("/bar");
    Assert.assertNull(_relativize_2);
  }
  
  @Test
  public void testRelativizeBothDirections() {
    final Path base = new Path("/hubba/bubba");
    final Path child = new Path("/hubba/bubba/bar");
    Path _path = new Path("bar");
    Path _relativize = base.relativize(child);
    Assert.assertEquals(_path, _relativize);
    Path _path_1 = new Path("bar");
    Path _relativize_1 = child.relativize(base);
    Assert.assertEquals(_path_1, _relativize_1);
  }
}
