/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.ui.tests.imports;

import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.ui.imports.ImportsUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class ImportsUtilTest {
  public static class ImportUtilExtension extends ImportsUtil {
    @Override
    protected Pair<String, String> splitInTypeAndMember(final String featuresQName) {
      return super.splitInTypeAndMember(featuresQName);
    }
  }
  
  @Test
  public void testQnameSplitting() {
    final ImportsUtilTest.ImportUtilExtension util = new ImportsUtilTest.ImportUtilExtension();
    Assert.assertEquals(Tuples.<String, String>create("java.util.Collections", "*"), util.splitInTypeAndMember("java.util.Collections.*"));
    Assert.assertEquals(Tuples.<String, String>create("java.util.Collections", "sort"), util.splitInTypeAndMember("java.util.Collections.sort"));
    Assert.assertEquals(Tuples.<String, String>create("java.util.Collections", "sort"), util.splitInTypeAndMember("java.util.Collections.sort()"));
    Assert.assertEquals(Tuples.<String, String>create("java.util.Collections", "sort"), 
      util.splitInTypeAndMember("java.util.Collections.sort(Object)"));
    Assert.assertEquals(Tuples.<String, String>create("java.util.Collections", ""), util.splitInTypeAndMember("java.util.Collections.("));
    Assert.assertEquals(Tuples.<String, String>create("java.util.Collections", ""), util.splitInTypeAndMember("java.util.Collections."));
    Assert.assertEquals(Tuples.<String, String>create("java.util", "Collections"), util.splitInTypeAndMember("java.util.Collections"));
  }
}
