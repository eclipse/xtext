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
import org.eclipse.xtext.generator.trace.LocationData;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.generator.trace.node.CompositeGeneratorNode;
import org.eclipse.xtext.generator.trace.node.GeneratorNodeExtensions;
import org.eclipse.xtext.generator.trace.node.GeneratorNodeProcessor;
import org.eclipse.xtext.generator.trace.node.IndentNode;
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
  private GeneratorNodeExtensions exts = new GeneratorNodeExtensions();
  
  @Test
  public void testBasicCreationAndProcessing() {
    final LocationData root = this.loc(0);
    CompositeGeneratorNode node = this.exts.appendNewLine(this.exts.append(this.exts.trace(root), "notindented"));
    this.exts.append(this.exts.appendNewLine(this.exts.append(this.exts.trace(this.exts.indent(node), this.loc(1)), "indented1")), "indented2");
    this.exts.append(this.exts.appendNewLine(node), "dedented");
    final GeneratorNodeProcessor processor = new GeneratorNodeProcessor();
    final GeneratorNodeProcessor.Result result = processor.process(node);
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
    this.assertEquals(_builder.toString(), result.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("CompletableTraceRegion [myOffset=0, myLength=44, useForDebugging=false] associations={");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("LocationData [TextRegionWithLineInformation [0:100][lineNumber=0, endLineNumber=0]][path=foo/mymodel.dsl]");
    _builder_1.newLine();
    _builder_1.append("} nestedRegions={");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("CompletableTraceRegion [myOffset=14, myLength=21, useForDebugging=false] associations={");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("LocationData [TextRegionWithLineInformation [1:99][lineNumber=0, endLineNumber=0]][path=foo/mymodel.dsl]");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    this.assertEquals(_builder_1.toString(), result.getTraceRegion().toString());
  }
  
  @Test
  public void testEmptyIndent() {
    final LocationData root = this.loc(0);
    CompositeGeneratorNode node = this.exts.appendNewLine(this.exts.append(this.exts.trace(root), "Hallo"));
    this.exts.indent(node);
    this.exts.appendNewLine(this.exts.append(node, "noindent"));
    IndentNode _indentNode = new IndentNode("  ", true, true);
    this.exts.append(node, _indentNode);
    this.exts.appendNewLine(this.exts.append(node, "noindent"));
    final GeneratorNodeProcessor processor = new GeneratorNodeProcessor();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Hallo");
    _builder.newLine();
    _builder.append("noindent");
    _builder.newLine();
    _builder.append("noindent");
    _builder.newLine();
    this.assertEquals(_builder.toString(), processor.process(node).toString());
  }
  
  @Test
  public void testTemplateProcessing() {
    final LocationData root = this.loc(0);
    CompositeGeneratorNode _trace = this.exts.trace(root);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        StringConcatenationClient _someCodeGen = GeneratorNodeTest.this.someCodeGen(2);
        _builder.append(_someCodeGen);
        _builder.newLineIfNotEmpty();
      }
    };
    final CompositeGeneratorNode node = this.exts.appendTemplate(_trace, _client);
    final GeneratorNodeProcessor processor = new GeneratorNodeProcessor();
    final GeneratorNodeProcessor.Result result = processor.process(node);
    this.assertEquals(this.someCodeGen_noTrace(2).toString(), result.toString());
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("CompletableTraceRegion [myOffset=0, myLength=80, useForDebugging=false] associations={");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("LocationData [TextRegionWithLineInformation [0:100][lineNumber=0, endLineNumber=0]][path=foo/mymodel.dsl]");
    _builder.newLine();
    _builder.append("} nestedRegions={");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("CompletableTraceRegion [myOffset=7, myLength=5, useForDebugging=false] associations={");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("LocationData [TextRegionWithLineInformation [10:90][lineNumber=0, endLineNumber=0]][path=foo/mymodel.dsl]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("CompletableTraceRegion [myOffset=28, myLength=5, useForDebugging=false] associations={");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("LocationData [TextRegionWithLineInformation [10:90][lineNumber=0, endLineNumber=0]][path=foo/mymodel.dsl]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("CompletableTraceRegion [myOffset=47, myLength=5, useForDebugging=false] associations={");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("LocationData [TextRegionWithLineInformation [11:89][lineNumber=0, endLineNumber=0]][path=foo/mymodel.dsl]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("CompletableTraceRegion [myOffset=68, myLength=5, useForDebugging=false] associations={");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("LocationData [TextRegionWithLineInformation [10:90][lineNumber=0, endLineNumber=0]][path=foo/mymodel.dsl]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    this.assertEquals(_builder.toString(), result.getTraceRegion().toString());
  }
  
  private StringConcatenationClient someCodeGen(final int n) {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        {
          ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, n, true);
          for(final Integer i : _doubleDotLessThan) {
            _builder.append("before ");
            CompositeGeneratorNode _append = GeneratorNodeTest.this.exts.append(GeneratorNodeTest.this.exts.trace(GeneratorNodeTest.this.loc((10 + (i).intValue()))), "Hello");
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
  
  private String someCodeGen_noTrace(final int n) {
    StringConcatenation _builder = new StringConcatenation();
    {
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, n, true);
      for(final Integer i : _doubleDotLessThan) {
        _builder.append("before ");
        _builder.append("Hello");
        _builder.append(" after");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        String _someCodeGen_noTrace = this.someCodeGen_noTrace((n - 1));
        _builder.append(_someCodeGen_noTrace, "  ");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  private LocationData loc(final int idx) {
    SourceRelativeURI _sourceRelativeURI = new SourceRelativeURI("foo/mymodel.dsl");
    return new LocationData(idx, (100 - idx), 0, 0, _sourceRelativeURI);
  }
  
  @Test
  public void testAppendVariants() {
    final CompositeGeneratorNode node = new CompositeGeneratorNode();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("* a simple string");
    final String string = _builder.toString();
    this.exts.append(node, string);
    this.exts.appendNewLine(node);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("* a multi-line string concatenation embedding");
    _builder_1.newLine();
    _builder_1.append("  \t");
    _builder_1.append(string, "  \t");
    _builder_1.newLineIfNotEmpty();
    final StringConcatenation stringConcat1 = _builder_1;
    this.exts.append(node, stringConcat1);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("* a string concatentation client embedding");
        _builder.newLine();
        _builder.append("  \t");
        _builder.append(stringConcat1, "  \t");
        _builder.newLineIfNotEmpty();
      }
    };
    final StringConcatenationClient client = _client;
    this.exts.append(node, client);
    final CompositeGeneratorNode nestedNode = new CompositeGeneratorNode();
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("* I can even embed");
    _builder_2.newLine();
    _builder_2.append("  \t");
    _builder_2.append(client, "  \t");
    _builder_2.newLineIfNotEmpty();
    _builder_2.append("  ");
    _builder_2.append("in a string concatenation");
    _builder_2.newLine();
    final StringConcatenation stringConcat2 = _builder_2;
    this.exts.append(nestedNode, stringConcat2);
    this.exts.append(node, nestedNode);
    final GeneratorNodeProcessor processor = new GeneratorNodeProcessor();
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("* a simple string");
    _builder_3.newLine();
    _builder_3.append("* a multi-line string concatenation embedding");
    _builder_3.newLine();
    _builder_3.append("  \t");
    _builder_3.append("* a simple string");
    _builder_3.newLine();
    _builder_3.append("* a string concatentation client embedding");
    _builder_3.newLine();
    _builder_3.append("  \t");
    _builder_3.append("* a multi-line string concatenation embedding");
    _builder_3.newLine();
    _builder_3.append("  \t  \t");
    _builder_3.append("* a simple string");
    _builder_3.newLine();
    _builder_3.append("* I can even embed");
    _builder_3.newLine();
    _builder_3.append("  \t");
    _builder_3.append("* a string concatentation client embedding");
    _builder_3.newLine();
    _builder_3.append("  \t  \t");
    _builder_3.append("* a multi-line string concatenation embedding");
    _builder_3.newLine();
    _builder_3.append("  \t  \t  \t");
    _builder_3.append("* a simple string");
    _builder_3.newLine();
    _builder_3.append("  ");
    _builder_3.append("in a string concatenation");
    _builder_3.newLine();
    this.assertEquals(_builder_3.toString(), processor.process(node).toString());
  }
  
  @Test
  public void testIndentVariants() {
    final CompositeGeneratorNode node = new CompositeGeneratorNode();
    this.doIndent(node, false, false);
    this.doIndent(node, true, false);
    this.doIndent(node, false, true);
    this.doIndent(node, true, true);
    final GeneratorNodeProcessor processor = new GeneratorNodeProcessor();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// indentImmediately: false, indentEmptyLines: false");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("a");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("bc");
    _builder.newLine();
    _builder.newLine();
    _builder.append("d");
    _builder.newLine();
    _builder.append("// indentImmediately: true, indentEmptyLines: false");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("a");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("b  c");
    _builder.newLine();
    _builder.newLine();
    _builder.append("d  ");
    _builder.newLine();
    _builder.append("// indentImmediately: false, indentEmptyLines: true");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("a");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("bc");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("d");
    _builder.newLine();
    _builder.append("// indentImmediately: true, indentEmptyLines: true");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("a");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("b  c");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("d  ");
    _builder.newLine();
    this.assertEquals(_builder.toString(), processor.process(node).toString());
  }
  
  private void doIndent(final CompositeGeneratorNode parent, final boolean indentImmediately, final boolean indentEmptyLines) {
    this.exts.append(this.exts.append(parent, "// indentImmediately: "), Boolean.valueOf(indentImmediately));
    this.exts.appendNewLine(this.exts.append(this.exts.append(parent, ", indentEmptyLines: "), Boolean.valueOf(indentEmptyLines)));
    this.exts.append(parent, this.exts.append(this.exts.appendNewLine(this.exts.appendNewLine(this.exts.append(new IndentNode("  ", indentImmediately, indentEmptyLines), "a"))), "b"));
    this.exts.appendNewLine(this.exts.append(parent, this.exts.append(new IndentNode("  ", indentImmediately, indentEmptyLines), "c")));
    this.exts.append(parent, this.exts.appendNewLine(new IndentNode("  ", indentImmediately, indentEmptyLines)));
    this.exts.append(this.exts.append(parent, "d"), this.exts.appendNewLine(new IndentNode("  ", indentImmediately, indentEmptyLines)));
  }
  
  private void assertEquals(final String expected, final String actual) {
    final String expectedM = expected.toString().replaceAll(System.lineSeparator(), "\n");
    final String actualM = actual.toString().replaceAll(System.lineSeparator(), "\n");
    Assert.assertEquals(expectedM, actualM);
  }
}
