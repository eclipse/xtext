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
import org.eclipse.xtext.ui.testing.util.LineDelimiters;
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
    Assert.assertEquals("", content.toString());
    StringBuilder _stringBuilder = new StringBuilder();
    content = _stringBuilder;
    factory.addToBuildProperties(content, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList()), "key");
    Assert.assertEquals("", content.toString());
    StringBuilder _stringBuilder_1 = new StringBuilder();
    content = _stringBuilder_1;
    factory.addToBuildProperties(content, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("entry1")), "key");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("key = entry1");
    Assert.assertEquals(_builder.toString(), content.toString());
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
    Assert.assertEquals(_builder_1.toString(), LineDelimiters.toPlatform(content.toString()));
  }
}
