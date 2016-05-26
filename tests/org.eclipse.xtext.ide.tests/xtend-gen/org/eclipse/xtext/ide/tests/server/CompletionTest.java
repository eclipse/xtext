/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.server;

import com.google.common.base.Objects;
import io.typefox.lsapi.CompletionItem;
import io.typefox.lsapi.PositionImpl;
import io.typefox.lsapi.TextDocumentIdentifierImpl;
import io.typefox.lsapi.TextDocumentPositionParamsImpl;
import io.typefox.lsapi.util.LsapiFactories;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.tests.server.AbstractLanguageServerTest;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class CompletionTest extends AbstractLanguageServerTest {
  @Accessors
  public static class TestCompletionConfiguration {
    private String model = "";
    
    private String filePath = "MyModel.testlang";
    
    private int line = 0;
    
    private int column = 0;
    
    private String expectedCompletionItems = "";
    
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
    public String getExpectedCompletionItems() {
      return this.expectedCompletionItems;
    }
    
    public void setExpectedCompletionItems(final String expectedCompletionItems) {
      this.expectedCompletionItems = expectedCompletionItems;
    }
  }
  
  @Test
  public void testCompletion_01() {
    final Procedure1<CompletionTest.TestCompletionConfiguration> _function = new Procedure1<CompletionTest.TestCompletionConfiguration>() {
      @Override
      public void apply(final CompletionTest.TestCompletionConfiguration it) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("type");
        _builder.newLine();
        it.expectedCompletionItems = _builder.toString();
      }
    };
    this.testCompletion(_function);
  }
  
  @Test
  public void testCompletion_02() {
    final Procedure1<CompletionTest.TestCompletionConfiguration> _function = new Procedure1<CompletionTest.TestCompletionConfiguration>() {
      @Override
      public void apply(final CompletionTest.TestCompletionConfiguration it) {
        it.model = "type ";
        it.column = 5;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("name (ID)");
        _builder.newLine();
        it.expectedCompletionItems = _builder.toString();
      }
    };
    this.testCompletion(_function);
  }
  
  @Test
  public void testCompletion_03() {
    final Procedure1<CompletionTest.TestCompletionConfiguration> _function = new Procedure1<CompletionTest.TestCompletionConfiguration>() {
      @Override
      public void apply(final CompletionTest.TestCompletionConfiguration it) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("type Foo {}");
        _builder.newLine();
        _builder.append("type Bar {}");
        _builder.newLine();
        it.model = _builder.toString();
        it.line = 1;
        int _length = "type Bar {".length();
        it.column = _length;
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("Bar (TypeDeclaration)");
        _builder_1.newLine();
        _builder_1.append("Foo (TypeDeclaration)");
        _builder_1.newLine();
        _builder_1.append("boolean");
        _builder_1.newLine();
        _builder_1.append("int");
        _builder_1.newLine();
        _builder_1.append("string");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("{");
        _builder_1.newLine();
        it.expectedCompletionItems = _builder_1.toString();
      }
    };
    this.testCompletion(_function);
  }
  
  protected void testCompletion(final Procedure1<? super CompletionTest.TestCompletionConfiguration> configurator) {
    @Extension
    final CompletionTest.TestCompletionConfiguration configuration = new CompletionTest.TestCompletionConfiguration();
    configurator.apply(configuration);
    final String fileUri = this.operator_mappedTo(configuration.filePath, configuration.model);
    this.initialize();
    this.open(fileUri, configuration.model);
    TextDocumentPositionParamsImpl _textDocumentPositionParamsImpl = new TextDocumentPositionParamsImpl();
    final Procedure1<TextDocumentPositionParamsImpl> _function = new Procedure1<TextDocumentPositionParamsImpl>() {
      @Override
      public void apply(final TextDocumentPositionParamsImpl it) {
        TextDocumentIdentifierImpl _createIdentifier = CompletionTest.this.createIdentifier(fileUri);
        it.setTextDocument(_createIdentifier);
        PositionImpl _newPosition = LsapiFactories.newPosition(configuration.line, configuration.column);
        it.setPosition(_newPosition);
      }
    };
    TextDocumentPositionParamsImpl _doubleArrow = ObjectExtensions.<TextDocumentPositionParamsImpl>operator_doubleArrow(_textDocumentPositionParamsImpl, _function);
    final List<? extends CompletionItem> completionItems = this.languageServer.completion(_doubleArrow);
    final String actualCompletionItems = this.toExpectation(completionItems);
    Assert.assertEquals(configuration.expectedCompletionItems, actualCompletionItems);
  }
  
  protected String toExpectation(final List<? extends CompletionItem> completionItems) {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final CompletionItem completionItem : completionItems) {
        String _expectation = this.<CompletionItem>toExpectation(completionItem);
        _builder.append(_expectation, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  protected <T extends CompletionItem> String toExpectation(final T it) {
    StringConcatenation _builder = new StringConcatenation();
    String _label = it.getLabel();
    _builder.append(_label, "");
    {
      String _detail = it.getDetail();
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_detail);
      boolean _not = (!_isNullOrEmpty);
      if (_not) {
        _builder.append(" (");
        String _detail_1 = it.getDetail();
        _builder.append(_detail_1, "");
        _builder.append(")");
      }
    }
    {
      String _insertText = it.getInsertText();
      String _label_1 = it.getLabel();
      boolean _notEquals = (!Objects.equal(_insertText, _label_1));
      if (_notEquals) {
        _builder.append(" -> ");
        String _insertText_1 = it.getInsertText();
        _builder.append(_insertText_1, "");
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
}
