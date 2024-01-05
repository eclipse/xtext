/**
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.building;

import com.google.common.base.Stopwatch;
import com.google.inject.Inject;
import com.google.inject.Injector;
import java.util.concurrent.TimeUnit;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.build.BuildRequest;
import org.eclipse.xtext.java.JavaSourceLanguageSetup;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.builder.AbstractIncrementalBuilderTest;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Performance test for a code base mixed between Xtend and Java sources
 */
@InjectWith(XtendIncrementalBuilderPerformanceTest.InjectorProviderWithJavaSourceLang.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class XtendIncrementalBuilderPerformanceTest extends AbstractIncrementalBuilderTest {
  public static class InjectorProviderWithJavaSourceLang extends RuntimeInjectorProvider {
    @Override
    protected Injector internalCreateInjector() {
      new JavaSourceLanguageSetup().createInjectorAndDoEMFRegistration();
      return super.internalCreateInjector();
    }
  }

  @Inject
  private IResourceServiceProvider.Registry registry;

  @Override
  protected IResourceServiceProvider.Registry getLanguages() {
    return this.registry;
  }

  public void doTestPerformance(final int max) {
    final Procedure1<BuildRequest> _function = (BuildRequest it) -> {
      final Function1<Integer, URI> _function_1 = (Integer it_1) -> {
        return this.toFile((it_1).intValue(), max);
      };
      it.setDirtyFiles(IterableExtensions.<URI>toList(IterableExtensions.<Integer, URI>map(new IntegerRange(1, max), _function_1)));
    };
    final BuildRequest buildRequest = this.newBuildRequest(_function);
    final Stopwatch sw = Stopwatch.createStarted();
    this.build(buildRequest);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(max);
    _builder.append(" file took ");
    long _elapsed = sw.elapsed(TimeUnit.MILLISECONDS);
    _builder.append(_elapsed);
    _builder.append(" ms");
    InputOutput.<String>println(_builder.toString());
  }

  public URI toFile(final int number, final int max) {
    String _xifexpression = null;
    if (((number % 2) == 0)) {
      _xifexpression = ".xtend";
    } else {
      _xifexpression = ".java";
    }
    String _plus = (("demo/Demo" + Integer.valueOf(number)) + _xifexpression);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package demo;");
    _builder.newLine();
    _builder.append("public class Demo");
    _builder.append(number);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    {
      if (((number % 2) == 0)) {
        _builder.append("\t");
        _builder.append("private String x");
        _builder.newLine();
        _builder.append("\t");
        _builder.append(";");
        _builder.newLine();
      } else {
        _builder.append("\t");
        _builder.append("private String x");
        _builder.newLine();
        _builder.append("\t");
        _builder.append(";");
        _builder.newLine();
      }
    }
    {
      if ((number > 1)) {
        _builder.append("\t");
        _builder.append("private Demo");
        _builder.append((number - 1), "\t");
        _builder.append(" demoA;");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      if ((number > 2)) {
        _builder.append("\t");
        _builder.append("private Demo");
        _builder.append((number - 2), "\t");
        _builder.append(" demoB;");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      if ((number < (max - 1))) {
        _builder.append("\t");
        _builder.append("private Demo");
        _builder.append((number + 1), "\t");
        _builder.append(" demoC;");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return this.operator_minus(_plus, _builder.toString());
  }

  @Test
  public void testPerf00100() {
    this.doTestPerformance(100);
  }

  @Test(timeout = 30000)
  public void testPerf00200() {
    this.doTestPerformance(200);
  }

  @Test(timeout = 30000)
  public void testPerf00400() {
    this.doTestPerformance(400);
  }

  @Test(timeout = 30000)
  public void testPerf00800() {
    this.doTestPerformance(800);
  }

  @Test(timeout = 30000)
  public void testPerf01600() {
    this.doTestPerformance(1600);
  }

  @Test(timeout = 30000)
  public void testPerf03200() {
    this.doTestPerformance(3200);
  }

  @Test(timeout = 30000)
  public void testPerf06400() {
    this.doTestPerformance(6400);
  }

  @Test(timeout = 60000)
  public void testPerf12800() {
    this.doTestPerformance(12800);
  }

  @Test(timeout = 120000)
  public void testPerf25600() {
    this.doTestPerformance(25600);
  }

  @Test(timeout = 240000)
  public void testPerf51200() {
    this.doTestPerformance(51200);
  }
}
