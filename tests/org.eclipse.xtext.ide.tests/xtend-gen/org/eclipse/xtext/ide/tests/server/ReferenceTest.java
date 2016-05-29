/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.server;

import io.typefox.lsapi.Location;
import io.typefox.lsapi.PositionImpl;
import io.typefox.lsapi.ReferenceContextImpl;
import io.typefox.lsapi.ReferenceParamsImpl;
import io.typefox.lsapi.TextDocumentIdentifierImpl;
import io.typefox.lsapi.util.LsapiFactories;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.tests.server.AbstractLanguageServerTest;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class ReferenceTest extends AbstractLanguageServerTest {
  @Accessors
  public static class ReferenceTestConfiguration {
    private String model = "";
    
    private String filePath = "MyModel.testlang";
    
    private int line = 0;
    
    private int column = 0;
    
    private boolean includeDeclaration = false;
    
    private String expectedReferences = "";
    
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
    public boolean isIncludeDeclaration() {
      return this.includeDeclaration;
    }
    
    public void setIncludeDeclaration(final boolean includeDeclaration) {
      this.includeDeclaration = includeDeclaration;
    }
    
    @Pure
    public String getExpectedReferences() {
      return this.expectedReferences;
    }
    
    public void setExpectedReferences(final String expectedReferences) {
      this.expectedReferences = expectedReferences;
    }
  }
  
  @Test
  public void testReferences_01() {
    final Procedure1<ReferenceTest.ReferenceTestConfiguration> _function = (ReferenceTest.ReferenceTestConfiguration it) -> {
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
      int _length = "type F".length();
      it.column = _length;
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("MyModel.testlang [[2, 1] .. [2, 4]]");
      _builder_1.newLine();
      it.expectedReferences = _builder_1.toString();
    };
    this.testReferences(_function);
  }
  
  @Test
  public void testReferences_02() {
    final Procedure1<ReferenceTest.ReferenceTestConfiguration> _function = (ReferenceTest.ReferenceTestConfiguration it) -> {
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
      int _length = "type F".length();
      it.column = _length;
      it.includeDeclaration = true;
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("MyModel.testlang [[0, 5] .. [0, 8]]");
      _builder_1.newLine();
      _builder_1.append("MyModel.testlang [[2, 1] .. [2, 4]]");
      _builder_1.newLine();
      it.expectedReferences = _builder_1.toString();
    };
    this.testReferences(_function);
  }
  
  protected void testReferences(final Procedure1<? super ReferenceTest.ReferenceTestConfiguration> configurator) {
    @Extension
    final ReferenceTest.ReferenceTestConfiguration configuration = new ReferenceTest.ReferenceTestConfiguration();
    configurator.apply(configuration);
    final String fileUri = this.operator_mappedTo(configuration.filePath, configuration.model);
    this.initialize();
    this.open(fileUri, configuration.model);
    final ReferenceContextImpl referenceContext = new ReferenceContextImpl();
    referenceContext.setIncludeDeclaration(configuration.includeDeclaration);
    ReferenceParamsImpl _referenceParamsImpl = new ReferenceParamsImpl();
    final Procedure1<ReferenceParamsImpl> _function = (ReferenceParamsImpl it) -> {
      TextDocumentIdentifierImpl _newIdentifier = this.newIdentifier(fileUri);
      it.setTextDocument(_newIdentifier);
      PositionImpl _newPosition = LsapiFactories.newPosition(configuration.line, configuration.column);
      it.setPosition(_newPosition);
      it.setContext(referenceContext);
    };
    ReferenceParamsImpl _doubleArrow = ObjectExtensions.<ReferenceParamsImpl>operator_doubleArrow(_referenceParamsImpl, _function);
    final List<? extends Location> definitions = this.languageServer.references(_doubleArrow);
    final String actualDefinitions = this.toExpectation(definitions);
    Assert.assertEquals(configuration.expectedReferences, actualDefinitions);
  }
}
