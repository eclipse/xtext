/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.server;

import io.typefox.lsapi.Location;
import io.typefox.lsapi.TextDocumentPositionParamsImpl;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.tests.server.AbstractLanguageServerTest;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class DefinitionTest extends AbstractLanguageServerTest {
  @Accessors
  public static class DefinitionTestConfiguration {
    private String model = "";
    
    private String filePath = "MyModel.testlang";
    
    private int line = 0;
    
    private int column = 0;
    
    private String expectedDefinitions = "";
    
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
    public String getExpectedDefinitions() {
      return this.expectedDefinitions;
    }
    
    public void setExpectedDefinitions(final String expectedDefinitions) {
      this.expectedDefinitions = expectedDefinitions;
    }
  }
  
  @Test
  public void testDefinition_01() {
    final Procedure1<DefinitionTest.DefinitionTestConfiguration> _function = (DefinitionTest.DefinitionTestConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type Foo {}");
      _builder.newLine();
      _builder.append("type Bar {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Foo foo");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      it.model = _builder.toString();
      it.line = 2;
      it.column = 3;
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("MyModel.testlang [[0, 5] .. [0, 8]]");
      _builder_1.newLine();
      it.expectedDefinitions = _builder_1.toString();
    };
    this.testDefinition(_function);
  }
  
  protected void testDefinition(final Procedure1<? super DefinitionTest.DefinitionTestConfiguration> configurator) {
    @Extension
    final DefinitionTest.DefinitionTestConfiguration configuration = new DefinitionTest.DefinitionTestConfiguration();
    configurator.apply(configuration);
    final String fileUri = this.operator_mappedTo(configuration.filePath, configuration.model);
    this.initialize();
    this.open(fileUri, configuration.model);
    TextDocumentPositionParamsImpl _newPosition = this.newPosition(fileUri, configuration.line, configuration.column);
    final List<? extends Location> definitions = this.languageServer.definition(_newPosition);
    final String actualDefinitions = this.toExpectation(definitions);
    Assert.assertEquals(configuration.expectedDefinitions, actualDefinitions);
  }
}
