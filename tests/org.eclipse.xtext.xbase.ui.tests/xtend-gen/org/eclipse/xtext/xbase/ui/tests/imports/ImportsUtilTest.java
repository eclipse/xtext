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
    Pair<String, String> _create = Tuples.<String, String>create("java.util.Collections", "*");
    Pair<String, String> _splitInTypeAndMember = util.splitInTypeAndMember("java.util.Collections.*");
    Assert.assertEquals(_create, _splitInTypeAndMember);
    Pair<String, String> _create_1 = Tuples.<String, String>create("java.util.Collections", "sort");
    Pair<String, String> _splitInTypeAndMember_1 = util.splitInTypeAndMember("java.util.Collections.sort");
    Assert.assertEquals(_create_1, _splitInTypeAndMember_1);
    Pair<String, String> _create_2 = Tuples.<String, String>create("java.util.Collections", "sort");
    Pair<String, String> _splitInTypeAndMember_2 = util.splitInTypeAndMember("java.util.Collections.sort()");
    Assert.assertEquals(_create_2, _splitInTypeAndMember_2);
    Pair<String, String> _create_3 = Tuples.<String, String>create("java.util.Collections", "sort");
    Pair<String, String> _splitInTypeAndMember_3 = util.splitInTypeAndMember("java.util.Collections.sort(Object)");
    Assert.assertEquals(_create_3, _splitInTypeAndMember_3);
    Pair<String, String> _create_4 = Tuples.<String, String>create("java.util.Collections", "");
    Pair<String, String> _splitInTypeAndMember_4 = util.splitInTypeAndMember("java.util.Collections.(");
    Assert.assertEquals(_create_4, _splitInTypeAndMember_4);
    Pair<String, String> _create_5 = Tuples.<String, String>create("java.util.Collections", "");
    Pair<String, String> _splitInTypeAndMember_5 = util.splitInTypeAndMember("java.util.Collections.");
    Assert.assertEquals(_create_5, _splitInTypeAndMember_5);
    Pair<String, String> _create_6 = Tuples.<String, String>create("java.util", "Collections");
    Pair<String, String> _splitInTypeAndMember_6 = util.splitInTypeAndMember("java.util.Collections");
    Assert.assertEquals(_create_6, _splitInTypeAndMember_6);
  }
}
