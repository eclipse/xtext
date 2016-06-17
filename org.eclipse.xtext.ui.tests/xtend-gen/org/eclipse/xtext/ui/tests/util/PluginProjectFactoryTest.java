/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.tests.util;

import java.util.Collections;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.tests.util.TestablePluginProjectFactory;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class PluginProjectFactoryTest {
  @Test
  public void testAddToBuildProperties() {
    final TestablePluginProjectFactory factory = new TestablePluginProjectFactory();
    StringBuilder content = new StringBuilder();
    factory.addToBuildProperties(content, null, "key");
    String _string = content.toString();
    Assert.assertEquals("", _string);
    StringBuilder _stringBuilder = new StringBuilder();
    content = _stringBuilder;
    factory.addToBuildProperties(content, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList()), "key");
    String _string_1 = content.toString();
    Assert.assertEquals("", _string_1);
    StringBuilder _stringBuilder_1 = new StringBuilder();
    content = _stringBuilder_1;
    factory.addToBuildProperties(content, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("entry1")), "key");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("key = entry1");
    String _string_2 = _builder.toString();
    String _string_3 = content.toString();
    Assert.assertEquals(_string_2, _string_3);
    StringBuilder _stringBuilder_2 = new StringBuilder();
    content = _stringBuilder_2;
    factory.addToBuildProperties(content, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("entry1", "entry2", "entry3")), "key");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("key = entry1,\\");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("entry2,\\");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("entry3");
    String _string_4 = _builder_1.toString();
    String _string_5 = content.toString();
    Assert.assertEquals(_string_4, _string_5);
  }
}
