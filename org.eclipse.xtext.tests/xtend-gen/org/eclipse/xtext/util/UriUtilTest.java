/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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
    Assert.assertTrue(UriUtil.isPrefixOf(prefix, uri));
  }
  
  @Test
  public void testPrefixRequiresSameScheme() {
    final URI prefix = URI.createURI("platform:/foo/");
    final URI uri = URI.createURI("file:/foo/bar");
    Assert.assertFalse(UriUtil.isPrefixOf(prefix, uri));
  }
  
  @Test
  public void testPrefixRequiresTrailingSeparator() {
    final URI prefix = URI.createURI("file:/foo");
    final URI uri = URI.createURI("file:/foo/bar");
    Assert.assertFalse(UriUtil.isPrefixOf(prefix, uri));
  }
  
  @Test
  public void testPrefixRequiresSegmentsToMatch() {
    final URI prefix = URI.createURI("file:/foo");
    final URI uri = URI.createURI("file:/buzz/bar");
    Assert.assertFalse(UriUtil.isPrefixOf(prefix, uri));
  }
  
  @Test
  public void testFolderUriHasTrailingSeparator() {
    final File folder = new File(".");
    final URI uri = UriUtil.createFolderURI(folder);
    Assert.assertTrue(uri.hasTrailingPathSeparator());
    int _segmentCount = uri.segmentCount();
    int _minus = (_segmentCount - 2);
    Assert.assertEquals(".", uri.segment(_minus));
  }
}
