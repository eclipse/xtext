/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.server;

import io.typefox.lsapi.Hover;
import io.typefox.lsapi.Location;
import io.typefox.lsapi.MarkedString;
import io.typefox.lsapi.Position;
import io.typefox.lsapi.Range;
import io.typefox.lsapi.SymbolInformation;
import io.typefox.lsapi.TextDocumentPositionParamsImpl;
import io.typefox.lsapi.util.LsapiFactories;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.tests.server.AbstractLanguageServerTest;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class HoverTest extends AbstractLanguageServerTest {
  @Accessors
  public static class HoverTestConfiguration {
    private String model = "";
    
    private String filePath = "MyModel.testlang";
    
    private int line = 0;
    
    private int column = 0;
    
    private String expectedHover = "";
    
    @Pure
    public String getModel() {
      return this.model;
    }
    
    public void setModel(final String model) {
      this.model = model;
    }
    
    @Pure
    public String getFilePath() {
      return this.filePath;
    }
    
    public void setFilePath(final String filePath) {
      this.filePath = filePath;
    }
    
    @Pure
    public int getLine() {
      return this.line;
    }
    
    public void setLine(final int line) {
      this.line = line;
    }
    
    @Pure
    public int getColumn() {
      return this.column;
    }
    
    public void setColumn(final int column) {
      this.column = column;
    }
    
    @Pure
    public String getExpectedHover() {
      return this.expectedHover;
    }
    
    public void setExpectedHover(final String expectedHover) {
      this.expectedHover = expectedHover;
    }
  }
  
  @Test
  public void testHover_01() {
    final Procedure1<HoverTest.HoverTestConfiguration> _function = new Procedure1<HoverTest.HoverTestConfiguration>() {
      @Override
      public void apply(final HoverTest.HoverTestConfiguration it) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Some documentation.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("type Foo {");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        it.model = _builder.toString();
        it.line = 3;
        int _length = "type F".length();
        it.column = _length;
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("[[3, 5] .. [3, 8]]");
        _builder_1.newLine();
        _builder_1.append("Some documentation.");
        _builder_1.newLine();
        it.expectedHover = _builder_1.toString();
      }
    };
    this.testHover(_function);
  }
  
  @Test
  public void testHover_02() {
    final Procedure1<HoverTest.HoverTestConfiguration> _function = new Procedure1<HoverTest.HoverTestConfiguration>() {
      @Override
      public void apply(final HoverTest.HoverTestConfiguration it) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Some documentation.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("type Foo {}");
        _builder.newLine();
        it.model = _builder.toString();
        it.line = 3;
        int _length = "{".length();
        it.column = _length;
      }
    };
    this.testHover(_function);
  }
  
  @Test
  public void testHover_03() {
    final Procedure1<HoverTest.HoverTestConfiguration> _function = new Procedure1<HoverTest.HoverTestConfiguration>() {
      @Override
      public void apply(final HoverTest.HoverTestConfiguration it) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Some documentation.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("type Foo {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("Foo foo");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        it.model = _builder.toString();
        it.line = 4;
        int _length = "\tF".length();
        it.column = _length;
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("[[4, 1] .. [4, 4]]");
        _builder_1.newLine();
        _builder_1.append("Some documentation.");
        _builder_1.newLine();
        it.expectedHover = _builder_1.toString();
      }
    };
    this.testHover(_function);
  }
  
  protected void testHover(final Procedure1<? super HoverTest.HoverTestConfiguration> configurator) {
    try {
      @Extension
      final HoverTest.HoverTestConfiguration configuration = new HoverTest.HoverTestConfiguration();
      configurator.apply(configuration);
      final String fileUri = this.operator_mappedTo(configuration.filePath, configuration.model);
      this.initialize();
      this.open(fileUri, configuration.model);
      TextDocumentPositionParamsImpl _newTextDocumentPositionParams = LsapiFactories.newTextDocumentPositionParams(fileUri, configuration.line, configuration.column);
      final CompletableFuture<Hover> hover = this.languageServer.hover(_newTextDocumentPositionParams);
      Hover _get = hover.get();
      final String actualHover = this.toExpectation(_get);
      Assert.assertEquals(configuration.expectedHover, actualHover);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected String _toExpectation(final Hover it) {
    StringConcatenation _builder = new StringConcatenation();
    Range _range = it.getRange();
    String _expectation = this.toExpectation(_range);
    _builder.append(_expectation, "");
    _builder.newLineIfNotEmpty();
    {
      List<? extends MarkedString> _contents = it.getContents();
      for(final MarkedString content : _contents) {
        String _expectation_1 = this.toExpectation(content);
        _builder.append(_expectation_1, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  protected String _toExpectation(final MarkedString it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      String _language = it.getLanguage();
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_language);
      boolean _not = (!_isNullOrEmpty);
      if (_not) {
        String _language_1 = it.getLanguage();
        _builder.append(_language_1, "");
        _builder.append(" -> ");
      }
    }
    String _value = it.getValue();
    _builder.append(_value, "");
    return _builder.toString();
  }
  
  protected String toExpectation(final Object it) {
    if (it instanceof List) {
      return _toExpectation((List<?>)it);
    } else if (it instanceof Hover) {
      return _toExpectation((Hover)it);
    } else if (it instanceof Location) {
      return _toExpectation((Location)it);
    } else if (it instanceof MarkedString) {
      return _toExpectation((MarkedString)it);
    } else if (it instanceof Position) {
      return _toExpectation((Position)it);
    } else if (it instanceof Range) {
      return _toExpectation((Range)it);
    } else if (it instanceof SymbolInformation) {
      return _toExpectation((SymbolInformation)it);
    } else if (it == null) {
      return _toExpectation((Void)null);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
}
