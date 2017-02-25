/**
 * Copyright (c) 2017 TypeFox (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.trace.node;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.generator.trace.LocationData;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.generator.trace.node.CompositeNode;
import org.eclipse.xtext.generator.trace.node.GeneratorNodeExtensions;
import org.eclipse.xtext.generator.trace.node.GeneratorNodeProcessor;
import org.eclipse.xtext.generator.trace.node.IGeneratorNode;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class GeneratorNodeTest {
  @Extension
  private GeneratorNodeExtensions exts = new GeneratorNodeExtensions("  ");
  
  @Test
  public void testBasicCreationAndProcessing() {
    final LocationData root = this.loc(0);
    CompositeNode node = this.exts.appendNewLine(this.exts.append(this.exts.startTrace(root), "notindented"));
    this.exts.append(this.exts.appendNewLine(this.exts.append(this.exts.trace(this.exts.indent(node), this.loc(1)), "indented1")), "indented2");
    this.exts.append(this.exts.appendNewLine(node), "dedented");
    StringBuilder _stringBuilder = new StringBuilder();
    final GeneratorNodeProcessor processor = new GeneratorNodeProcessor(_stringBuilder, "  ", "\n");
    processor.process(node);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("notindented");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("indented1");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("indented2");
    _builder.newLine();
    _builder.append("dedented");
    Assert.assertEquals(_builder.toString(), processor.getContents().toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("CompletableTraceRegion [myOffset=0, myLength=44] associations={");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("LocationData [TextRegionWithLineInformation [0:100][lineNumber=0, endLineNumber=0]][path=foo/mymodel.dsl]");
    _builder_1.newLine();
    _builder_1.append("} nestedRegions={");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("CompletableTraceRegion [myOffset=14, myLength=21] associations={");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("LocationData [TextRegionWithLineInformation [1:99][lineNumber=0, endLineNumber=0]][path=foo/mymodel.dsl]");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    Assert.assertEquals(_builder_1.toString(), processor.getCurrentRegion().toString());
  }
  
  @Test
  public void testTemplateProcessing() {
    final LocationData root = this.loc(0);
    CompositeNode _startTrace = this.exts.startTrace(root);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        StringConcatenationClient _someCodeGen = GeneratorNodeTest.this.someCodeGen(2);
        _builder.append(_someCodeGen);
        _builder.newLineIfNotEmpty();
      }
    };
    IGeneratorNode node = this.exts.appendTemplate(_startTrace, _client);
    StringBuilder _stringBuilder = new StringBuilder();
    final GeneratorNodeProcessor processor = new GeneratorNodeProcessor(_stringBuilder, "  ", "\n");
    processor.process(node);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("before Hello after");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("before Hello after");
    _builder.newLine();
    _builder.append("      ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("before Hello after");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.newLine();
    _builder.append("before Hello after");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("before Hello after");
    _builder.newLine();
    _builder.append("      ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("before Hello after");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    Assert.assertEquals(_builder.toString(), processor.getContents().toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("CompletableTraceRegion [myOffset=0, myLength=153] associations={");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("LocationData [TextRegionWithLineInformation [0:100][lineNumber=0, endLineNumber=0]][path=foo/mymodel.dsl]");
    _builder_1.newLine();
    _builder_1.append("} nestedRegions={");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("CompletableTraceRegion [myOffset=7, myLength=5] associations={");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("LocationData [TextRegionWithLineInformation [10:90][lineNumber=0, endLineNumber=0]][path=foo/mymodel.dsl]");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("CompletableTraceRegion [myOffset=30, myLength=5] associations={");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("LocationData [TextRegionWithLineInformation [10:90][lineNumber=0, endLineNumber=0]][path=foo/mymodel.dsl]");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("CompletableTraceRegion [myOffset=58, myLength=5] associations={");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("LocationData [TextRegionWithLineInformation [10:90][lineNumber=0, endLineNumber=0]][path=foo/mymodel.dsl]");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("CompletableTraceRegion [myOffset=83, myLength=5] associations={");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("LocationData [TextRegionWithLineInformation [11:89][lineNumber=0, endLineNumber=0]][path=foo/mymodel.dsl]");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("CompletableTraceRegion [myOffset=106, myLength=5] associations={");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("LocationData [TextRegionWithLineInformation [10:90][lineNumber=0, endLineNumber=0]][path=foo/mymodel.dsl]");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("CompletableTraceRegion [myOffset=134, myLength=5] associations={");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("LocationData [TextRegionWithLineInformation [10:90][lineNumber=0, endLineNumber=0]][path=foo/mymodel.dsl]");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    Assert.assertEquals(_builder_1.toString(), processor.getCurrentRegion().toString());
  }
  
  public StringConcatenationClient someCodeGen(final int n) {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        {
          ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, n, true);
          for(final Integer i : _doubleDotLessThan) {
            _builder.append("before ");
            CompositeNode _append = GeneratorNodeTest.this.exts.append(GeneratorNodeTest.this.exts.startTrace(GeneratorNodeTest.this.loc((10 + (i).intValue()))), "Hello");
            _builder.append(_append);
            _builder.append(" after");
            _builder.newLineIfNotEmpty();
            _builder.append("  ");
            StringConcatenationClient _someCodeGen = GeneratorNodeTest.this.someCodeGen((n - 1));
            _builder.append(_someCodeGen, "  ");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    };
    return _client;
  }
  
  public LocationData loc(final int idx) {
    SourceRelativeURI _sourceRelativeURI = new SourceRelativeURI("foo/mymodel.dsl");
    return new LocationData(idx, (100 - idx), 0, 0, _sourceRelativeURI);
  }
}
