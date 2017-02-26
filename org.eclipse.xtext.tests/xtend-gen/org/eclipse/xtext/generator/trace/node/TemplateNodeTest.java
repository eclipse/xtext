/**
 * Copyright (c) 2017 TypeFox (https://typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.trace.node;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.generator.trace.node.CompositeGeneratorNode;
import org.eclipse.xtext.generator.trace.node.GeneratorNodeExtensions;
import org.eclipse.xtext.generator.trace.node.GeneratorNodeProcessor;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class TemplateNodeTest {
  @Test
  public void testSimpleString() {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("fooo bar");
        _builder.newLine();
      }
    };
    this.assertEquals(_client);
  }
  
  @Test
  public void testSimpleTemplate_01() {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        String _multiLineString = TemplateNodeTest.this.multiLineString();
        _builder.append(_multiLineString);
        _builder.append(" ");
        String _multiLineString_1 = TemplateNodeTest.this.multiLineString();
        _builder.append(_multiLineString_1);
        _builder.newLineIfNotEmpty();
      }
    };
    this.assertEquals(_client);
  }
  
  @Test
  public void testString() {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("fooo bar");
        _builder.newLine();
        {
          if ((2 > 1)) {
            {
              IntegerRange _upTo = new IntegerRange(1, 4);
              for(final Integer i : _upTo) {
                CharSequence _other = TemplateNodeTest.this.other();
                _builder.append(_other);
                _builder.append(" ");
                _builder.append(i);
                _builder.newLineIfNotEmpty();
                String _multiLineString = TemplateNodeTest.this.multiLineString();
                _builder.append(_multiLineString);
                _builder.append(" ");
                String _multiLineString_1 = TemplateNodeTest.this.multiLineString();
                _builder.append(_multiLineString_1);
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    };
    this.assertEquals(_client);
  }
  
  private CharSequence other() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("foo ");
    _builder.append(("dfdf" + Integer.valueOf(23)));
    _builder.append(" bar");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private String multiLineString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("test ");
    _builder.newLine();
    _builder.append("bar");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _other = this.other();
    _builder.append(_other, "\t");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public void assertEquals(final StringConcatenationClient c) {
    final GeneratorNodeExtensions ext = new GeneratorNodeExtensions();
    StringBuilder _stringBuilder = new StringBuilder();
    final GeneratorNodeProcessor processor = new GeneratorNodeProcessor(_stringBuilder, "  ", "\n");
    final CompositeGeneratorNode root = new CompositeGeneratorNode();
    ext.appendTemplate(root, c);
    processor.process(root);
    final StringConcatenation expected = new StringConcatenation();
    expected.append(c);
    Assert.assertEquals(expected.toString(), processor.getContents().toString());
  }
}
