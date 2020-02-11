/**
 * Copyright (c) 2017 TypeFox (https://typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.trace.node;

import java.util.Collections;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.generator.trace.node.CompositeGeneratorNode;
import org.eclipse.xtext.generator.trace.node.GeneratorNodeExtensions;
import org.eclipse.xtext.generator.trace.node.GeneratorNodeProcessor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class TemplateNodeTest {
  @Test
  public void testNull() {
    final Object x = null;
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("fooo ");
        _builder.append(x);
        _builder.append("bar");
        _builder.newLineIfNotEmpty();
      }
    };
    this.assertEquals(_client);
  }
  
  @Test
  public void testNull_02() {
    final Object x = null;
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("fooo");
        _builder.newLine();
        _builder.append("\t");
        _builder.append(x, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append(" ");
        _builder.append("bar");
        _builder.newLine();
      }
    };
    this.assertEquals(_client);
  }
  
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
  public void testWeirdTemplateString() {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("fooo bar");
        _builder.newLine();
        _builder.append("d   ");
        {
          if ((2 > 1)) {
            _builder.append("s");
            _builder.newLineIfNotEmpty();
            _builder.append("\t  ");
            _builder.append("ee  ");
            {
              IntegerRange _upTo = new IntegerRange(1, 4);
              for(final Integer i : _upTo) {
                _builder.newLineIfNotEmpty();
                _builder.newLineIfNotEmpty();
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
  
  @Test
  public void testSeparatorLoop() {
    final List<String> strings = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("a", "b", "c"));
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        {
          boolean _hasElements = false;
          for(final String s : strings) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(", ", "");
            }
            _builder.append("\"");
            _builder.append(s);
            _builder.append("\"");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    };
    this.assertEquals(_client);
  }
  
  @Test
  public void testSeparatorLoopWithWhitespace() {
    final List<String> strings = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("a", "b", "c"));
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        {
          boolean _hasElements = false;
          for(final String s : strings) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(", ", "");
            }
            _builder.append(s);
            _builder.append(" ");
            _builder.append(s);
          }
        }
        _builder.newLineIfNotEmpty();
      }
    };
    this.assertEquals(_client);
  }
  
  @Test
  public void testSeparatorLoopWithWhitespace2() {
    final List<String> strings = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("a", "b", "c"));
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        {
          boolean _hasElements = false;
          for(final String s : strings) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(",", "");
            }
            _builder.append(s);
            _builder.append(" ");
            _builder.append(s);
            _builder.newLineIfNotEmpty();
          }
        }
      }
    };
    this.assertEquals(_client);
  }
  
  @Test
  public void testSeparatorLoopWithWhitespace3() {
    final List<String> strings = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("a", "b", "c"));
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        {
          boolean _hasElements = false;
          for(final String s : strings) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(",", "");
            }
            _builder.newLine();
            _builder.append(s);
            _builder.append(" ");
            _builder.newLineIfNotEmpty();
            _builder.newLine();
          }
        }
      }
    };
    this.assertEquals(_client);
  }
  
  @Test
  public void testIndentedIf() {
    final boolean condition = true;
    final String string = "foo";
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("Very wise:");
        _builder.newLine();
        {
          if (condition) {
            _builder.append("\t");
            _builder.append("who ");
            _builder.append(string, "\t");
            _builder.append(" do");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    };
    this.assertEquals(_client);
  }
  
  @Test
  public void testIndentedFor() {
    final List<String> list = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("foo", "bar"));
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("Very wise:");
        _builder.newLine();
        _builder.append("\t");
        {
          for(final String s : list) {
            _builder.append("\t");
            _builder.append(s, "\t");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    };
    this.assertEquals(_client);
  }
  
  @Test
  public void testIndentedTemplate() {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("sometimes foo");
        _builder.newLine();
        _builder.newLine();
        _builder.append("and sometimes bar");
        _builder.newLine();
      }
    };
    final StringConcatenationClient template = _client;
    StringConcatenationClient _client_1 = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("Very wise:");
        _builder.newLine();
        _builder.append("\t");
        _builder.append(template, "\t");
        _builder.newLineIfNotEmpty();
      }
    };
    this.assertEquals(_client_1);
  }
  
  @Test
  public void testIfNotEmpty() {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.newLineIfNotEmpty();
        _builder.append("foo");
        _builder.newLine();
      }
    };
    final StringConcatenationClient template = _client;
    StringConcatenationClient _client_1 = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("Very wise:");
        _builder.newLine();
        _builder.append("\t");
        _builder.append(template, "\t");
        _builder.newLineIfNotEmpty();
      }
    };
    this.assertEquals(_client_1);
  }
  
  protected void assertEquals(final StringConcatenationClient c) {
    final GeneratorNodeExtensions ext = new GeneratorNodeExtensions();
    final GeneratorNodeProcessor processor = new GeneratorNodeProcessor();
    final CompositeGeneratorNode root = new CompositeGeneratorNode();
    ext.appendTemplate(root, c);
    final GeneratorNodeProcessor.Result result = processor.process(root);
    final StringConcatenation expected = new StringConcatenation();
    expected.append(c);
    final String expectedM = expected.toString().replaceAll(System.lineSeparator(), "\n");
    final String resultM = result.toString().replaceAll(System.lineSeparator(), "\n");
    Assert.assertEquals(expectedM, resultM);
  }
}
