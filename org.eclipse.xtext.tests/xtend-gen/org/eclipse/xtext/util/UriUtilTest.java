/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.util;

import java.io.File;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.util.UriUtil;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class UriUtilTest {
  @Test
  public void testPrefix() {
    final URI prefix = URI.createURI("file:/foo/");
    final URI uri = URI.createURI("file:/foo/bar");
    boolean _isPrefixOf = UriUtil.isPrefixOf(prefix, uri);
    Assert.assertTrue(_isPrefixOf);
  }
  
  @Test
  public void testPrefixRequiresSameScheme() {
    final URI prefix = URI.createURI("platform:/foo/");
    final URI uri = URI.createURI("file:/foo/bar");
    boolean _isPrefixOf = UriUtil.isPrefixOf(prefix, uri);
    Assert.assertFalse(_isPrefixOf);
  }
  
  @Test
  public void testPrefixRequiresTrailingSeparator() {
    final URI prefix = URI.createURI("file:/foo");
    final URI uri = URI.createURI("file:/foo/bar");
    boolean _isPrefixOf = UriUtil.isPrefixOf(prefix, uri);
    Assert.assertFalse(_isPrefixOf);
  }
  
  @Test
  public void testPrefixRequiresSegmentsToMatch() {
    final URI prefix = URI.createURI("file:/foo");
    final URI uri = URI.createURI("file:/buzz/bar");
    boolean _isPrefixOf = UriUtil.isPrefixOf(prefix, uri);
    Assert.assertFalse(_isPrefixOf);
  }
  
  @Test
  public void testFolderUriHasTrailingSeparator() {
    final File folder = new File(".");
    final URI uri = UriUtil.createFolderURI(folder);
    boolean _hasTrailingPathSeparator = uri.hasTrailingPathSeparator();
    Assert.assertTrue(_hasTrailingPathSeparator);
    int _segmentCount = uri.segmentCount();
    int _minus = (_segmentCount - 2);
    String _segment = uri.segment(_minus);
    Assert.assertEquals(".", _segment);
  }
}
