/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.test;

import com.google.common.collect.Iterables;
import com.google.inject.Module;
import java.io.File;
import java.util.Collections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGenerator2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.web.example.statemachine.StatemachineRuntimeModule;
import org.eclipse.xtext.web.example.statemachine.statemachine.State;
import org.eclipse.xtext.web.example.statemachine.statemachine.Statemachine;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.web.server.XtextServiceDispatcher;
import org.eclipse.xtext.web.server.generator.GeneratorResult;
import org.eclipse.xtext.web.server.generator.GeneratorService;
import org.eclipse.xtext.web.server.test.AbstractWebServerTest;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class GeneratorTest extends AbstractWebServerTest {
  public static class Generator extends AbstractGenerator {
    private int invocationCount = 0;
    
    public Generator() {
      GeneratorTest.generatorInstance = this;
    }
    
    @Override
    public void doGenerate(final Resource input, final IFileSystemAccess2 fsa, final IGeneratorContext ctx) {
      this.invocationCount++;
      final Statemachine statemachine = IterableExtensions.<Statemachine>head(Iterables.<Statemachine>filter(input.getContents(), Statemachine.class));
      StringConcatenation _builder = new StringConcatenation();
      {
        EList<State> _states = statemachine.getStates();
        boolean _hasElements = false;
        for(final State state : _states) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate(",", "");
          }
          String _name = state.getName();
          _builder.append(_name);
        }
      }
      _builder.newLineIfNotEmpty();
      fsa.generateFile("/DEFAULT_ARTIFACT", _builder);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("hello, world!");
      fsa.generateFile("/test.txt", _builder_1);
    }
  }
  
  private static GeneratorTest.Generator generatorInstance;
  
  @Override
  protected Module getRuntimeModule() {
    return new StatemachineRuntimeModule() {
      @Override
      public Class<? extends IGenerator2> bindIGenerator2() {
        return GeneratorTest.Generator.class;
      }
    };
  }
  
  @Test
  public void testGenerateText() {
    final File file = this.createFile("state foo end state bar end");
    Pair<String, String> _mappedTo = Pair.<String, String>of("serviceType", "generate");
    String _name = file.getName();
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("resource", _name);
    final XtextServiceDispatcher.ServiceDescriptor generate = this.getService(Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1)));
    Assert.assertFalse(generate.isHasSideEffects());
    IServiceResult _apply = generate.getService().apply();
    final GeneratorResult result = ((GeneratorResult) _apply);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("GeneratorResult [");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("name = \"DEFAULT_OUTPUT/DEFAULT_ARTIFACT\"");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("content = \"foo,bar\\n\"");
    _builder.newLine();
    _builder.append("]");
    final String expectedResult = _builder.toString();
    Assert.assertEquals(expectedResult, result.toString());
  }
  
  @Test
  public void testGenerateAdditionalText() {
    final File file = this.createFile("state foo end state bar end");
    Pair<String, String> _mappedTo = Pair.<String, String>of("serviceType", "generate");
    String _name = file.getName();
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("resource", _name);
    Pair<String, String> _mappedTo_2 = Pair.<String, String>of("artifact", "DEFAULT_OUTPUT/test.txt");
    final XtextServiceDispatcher.ServiceDescriptor generate = this.getService(Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2)));
    Assert.assertFalse(generate.isHasSideEffects());
    IServiceResult _apply = generate.getService().apply();
    final GeneratorResult result = ((GeneratorResult) _apply);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("GeneratorResult [");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("name = \"DEFAULT_OUTPUT/test.txt\"");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("contentType = \"text/plain\"");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("content = \"hello, world!\"");
    _builder.newLine();
    _builder.append("]");
    final String expectedResult = _builder.toString();
    Assert.assertEquals(expectedResult, result.toString());
  }
  
  @Test
  public void testInvokedOnce() {
    if ((GeneratorTest.generatorInstance != null)) {
      GeneratorTest.generatorInstance.invocationCount = 0;
    }
    final File file = this.createFile("state foo end state bar end");
    Pair<String, String> _mappedTo = Pair.<String, String>of("serviceType", "generate");
    String _name = file.getName();
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("resource", _name);
    final XtextServiceDispatcher.ServiceDescriptor generate = this.getService(Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1)));
    generate.getService().apply();
    Assert.assertEquals(1, GeneratorTest.generatorInstance.invocationCount);
    generate.getService().apply();
    Assert.assertEquals(1, GeneratorTest.generatorInstance.invocationCount);
  }
  
  @Test
  public void testGetResultWithoutContent() {
    final File file = this.createFile("state foo end state bar end");
    Pair<String, String> _mappedTo = Pair.<String, String>of("serviceType", "generate");
    String _name = file.getName();
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("resource", _name);
    Pair<String, String> _mappedTo_2 = Pair.<String, String>of("artifact", "DEFAULT_OUTPUT/test.txt");
    Pair<String, String> _mappedTo_3 = Pair.<String, String>of("includeContent", "false");
    final XtextServiceDispatcher.ServiceDescriptor generate = this.getService(Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3)));
    IServiceResult _apply = generate.getService().apply();
    final GeneratorResult result = ((GeneratorResult) _apply);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("GeneratorResult [");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("name = \"DEFAULT_OUTPUT/test.txt\"");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("contentType = \"text/plain\"");
    _builder.newLine();
    _builder.append("]");
    final String expectedResult = _builder.toString();
    Assert.assertEquals(expectedResult, result.toString());
  }
  
  @Test
  public void testGetAllResults() {
    final File file = this.createFile("state foo end state bar end");
    Pair<String, String> _mappedTo = Pair.<String, String>of("serviceType", "generate");
    String _name = file.getName();
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("resource", _name);
    Pair<String, String> _mappedTo_2 = Pair.<String, String>of("allArtifacts", "true");
    final XtextServiceDispatcher.ServiceDescriptor generate = this.getService(Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2)));
    IServiceResult _apply = generate.getService().apply();
    final GeneratorService.GeneratedArtifacts result = ((GeneratorService.GeneratedArtifacts) _apply);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("GeneratedArtifacts [");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("artifacts = ArrayList (");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("GeneratorResult [");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("name = \"DEFAULT_OUTPUT/DEFAULT_ARTIFACT\"");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("content = \"foo,bar\\n\"");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("],");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("GeneratorResult [");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("name = \"DEFAULT_OUTPUT/test.txt\"");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("contentType = \"text/plain\"");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("content = \"hello, world!\"");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append(")");
    _builder.newLine();
    _builder.append("]");
    final String expectedResult = _builder.toString();
    Assert.assertEquals(expectedResult, result.toString());
  }
  
  @Test
  public void testGetAllResultsWithoutContent() {
    final File file = this.createFile("state foo end state bar end");
    Pair<String, String> _mappedTo = Pair.<String, String>of("serviceType", "generate");
    String _name = file.getName();
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("resource", _name);
    Pair<String, String> _mappedTo_2 = Pair.<String, String>of("allArtifacts", "true");
    Pair<String, String> _mappedTo_3 = Pair.<String, String>of("includeContent", "false");
    final XtextServiceDispatcher.ServiceDescriptor generate = this.getService(Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3)));
    IServiceResult _apply = generate.getService().apply();
    final GeneratorService.GeneratedArtifacts result = ((GeneratorService.GeneratedArtifacts) _apply);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("GeneratedArtifacts [");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("artifacts = ArrayList (");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("GeneratorResult [");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("name = \"DEFAULT_OUTPUT/DEFAULT_ARTIFACT\"");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("],");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("GeneratorResult [");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("name = \"DEFAULT_OUTPUT/test.txt\"");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("contentType = \"text/plain\"");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append(")");
    _builder.newLine();
    _builder.append("]");
    final String expectedResult = _builder.toString();
    Assert.assertEquals(expectedResult, result.toString());
  }
}
