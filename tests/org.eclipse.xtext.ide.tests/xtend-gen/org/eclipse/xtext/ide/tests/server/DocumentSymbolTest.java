/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.server;

import io.typefox.lsapi.DocumentSymbolParamsImpl;
import io.typefox.lsapi.SymbolInformation;
import io.typefox.lsapi.util.LsapiFactories;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.tests.server.AbstractLanguageServerTest;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
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
    try {
      @Extension
      final DocumentSymbolTest.DocumentSymbolConfiguraiton configuration = new DocumentSymbolTest.DocumentSymbolConfiguraiton();
      configurator.apply(configuration);
      final String fileUri = this.operator_mappedTo(configuration.filePath, configuration.model);
      this.initialize();
      this.open(fileUri, configuration.model);
      DocumentSymbolParamsImpl _newDocumentSymbolParams = LsapiFactories.newDocumentSymbolParams(fileUri);
      final CompletableFuture<List<? extends SymbolInformation>> symbols = this.languageServer.documentSymbol(_newDocumentSymbolParams);
      List<? extends SymbolInformation> _get = symbols.get();
      final String actualSymbols = this.toExpectation(_get);
      Assert.assertEquals(configuration.expectedSymbols, actualSymbols);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
