/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.server;

import io.typefox.lsapi.DocumentSymbolParamsImpl;
import io.typefox.lsapi.Location;
import io.typefox.lsapi.Position;
import io.typefox.lsapi.Range;
import io.typefox.lsapi.SymbolInformation;
import io.typefox.lsapi.TextDocumentIdentifierImpl;
import java.util.Arrays;
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
public class DocumentSymbolTest extends AbstractLanguageServerTest {
  @Accessors
  public static class DocumentSymbolConfiguraiton {
    private String model = "";
    
    private String filePath = "MyModel.testlang";
    
    private String expectedSymbols = "";
    
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
    public String getExpectedSymbols() {
      return this.expectedSymbols;
    }
    
    public void setExpectedSymbols(final String expectedSymbols) {
      this.expectedSymbols = expectedSymbols;
    }
  }
  
  @Test
  public void testDocumentSymbol_01() {
    final Procedure1<DocumentSymbolTest.DocumentSymbolConfiguraiton> _function = new Procedure1<DocumentSymbolTest.DocumentSymbolConfiguraiton>() {
      @Override
      public void apply(final DocumentSymbolTest.DocumentSymbolConfiguraiton it) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("type Foo {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("int bar");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("type Bar {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("Foo foo");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        it.model = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("symbol \"Foo\" {");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("kind: 0");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("location: MyModel.testlang [[0, 5] .. [0, 8]]");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("symbol \"Foo.bar\" {");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("kind: 0");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("location: MyModel.testlang [[1, 5] .. [1, 8]]");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("container: \"Foo\"");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("symbol \"Foo.bar.int\" {");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("kind: 0");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("location: MyModel.testlang [[1, 1] .. [1, 4]]");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("container: \"Foo.bar\"");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("symbol \"Bar\" {");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("kind: 0");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("location: MyModel.testlang [[3, 5] .. [3, 8]]");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("symbol \"Bar.foo\" {");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("kind: 0");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("location: MyModel.testlang [[4, 5] .. [4, 8]]");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("container: \"Bar\"");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        it.expectedSymbols = _builder_1.toString();
      }
    };
    this.testDocumentSymbol(_function);
  }
  
  protected void testDocumentSymbol(final Procedure1<? super DocumentSymbolTest.DocumentSymbolConfiguraiton> configurator) {
    @Extension
    final DocumentSymbolTest.DocumentSymbolConfiguraiton configuration = new DocumentSymbolTest.DocumentSymbolConfiguraiton();
    configurator.apply(configuration);
    final String fileUri = this.operator_mappedTo(configuration.filePath, configuration.model);
    this.initialize();
    this.open(fileUri, configuration.model);
    DocumentSymbolParamsImpl _documentSymbolParamsImpl = new DocumentSymbolParamsImpl();
    final Procedure1<DocumentSymbolParamsImpl> _function = new Procedure1<DocumentSymbolParamsImpl>() {
      @Override
      public void apply(final DocumentSymbolParamsImpl it) {
        TextDocumentIdentifierImpl _newIdentifier = DocumentSymbolTest.this.newIdentifier(fileUri);
        it.setTextDocument(_newIdentifier);
      }
    };
    DocumentSymbolParamsImpl _doubleArrow = ObjectExtensions.<DocumentSymbolParamsImpl>operator_doubleArrow(_documentSymbolParamsImpl, _function);
    final List<? extends SymbolInformation> symbols = this.languageServer.documentSymbol(_doubleArrow);
    final String actualSymbols = this.toExpectation(symbols);
    Assert.assertEquals(configuration.expectedSymbols, actualSymbols);
  }
  
  protected String _toExpectation(final SymbolInformation it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("symbol \"");
    String _name = it.getName();
    _builder.append(_name, "");
    _builder.append("\" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("kind: ");
    int _kind = it.getKind();
    _builder.append(_kind, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("location: ");
    Location _location = it.getLocation();
    String _expectation = this.toExpectation(_location);
    _builder.append(_expectation, "\t");
    _builder.newLineIfNotEmpty();
    {
      String _container = it.getContainer();
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_container);
      boolean _not = (!_isNullOrEmpty);
      if (_not) {
        _builder.append("\t");
        _builder.append("container: \"");
        String _container_1 = it.getContainer();
        _builder.append(_container_1, "\t");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  protected String toExpectation(final Object it) {
    if (it instanceof List) {
      return _toExpectation((List<?>)it);
    } else if (it instanceof Location) {
      return _toExpectation((Location)it);
    } else if (it instanceof Position) {
      return _toExpectation((Position)it);
    } else if (it instanceof Range) {
      return _toExpectation((Range)it);
    } else if (it instanceof SymbolInformation) {
      return _toExpectation((SymbolInformation)it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
}
