/**
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.compiler;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.ArrayList;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.generator.IFilePostProcessor;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.compiler.DisableCodeGenerationAdapter;
import org.eclipse.xtext.xbase.compiler.GeneratorConfig;
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.testing.CompilationTestHelper;
import org.junit.Assert;
import org.junit.Before;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractXtendCompilerTest extends AbstractXtendTestCase {
  @Inject
  protected JvmModelGenerator generator;

  @Inject
  protected IGeneratorConfigProvider generatorConfigProvider;

  @Inject
  protected IFilePostProcessor postProcessor;

  @Inject
  @Extension
  protected CompilationTestHelper compilationTestHelper;

  protected boolean useJavaCompiler = false;

  @Before
  public void setupCompiler() {
    this.compilationTestHelper.setJavaCompilerClassPath(this.getClass().getClassLoader());
  }

  public void assertCompilesTo(final CharSequence input, final CharSequence expected) {
    this.doAssertCompilesTo(input, expected, this.generatorConfigProvider.get(null), false);
  }

  protected XtendFile doAssertCompilesTo(final CharSequence input, final CharSequence expected, final GeneratorConfig config, final boolean serializeAllTypes) {
    try {
      final XtendFile file = this.file(input.toString(), true);
      final ArrayList<CharSequence> results = this.compile(file, input, config);
      if (serializeAllTypes) {
        Assert.assertEquals(expected.toString(), IterableExtensions.join(results, "\n"));
      } else {
        Assert.assertEquals(expected.toString(), IterableExtensions.<CharSequence>head(results).toString());
      }
      return file;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  public void assertFilesCompileTo(final Iterable<XtendFile> xtendFiles, final CharSequence... expected) {
    final GeneratorConfig config = this.generatorConfigProvider.get(null);
    int i = 0;
    for (final XtendFile file : xtendFiles) {
      {
        final ArrayList<CharSequence> results = this.compile(file, null, config);
        Assert.assertEquals((expected[i]).toString(), IterableExtensions.<CharSequence>head(results).toString());
        i++;
      }
    }
  }

  private ArrayList<CharSequence> compile(final XtendFile file, final CharSequence input, final GeneratorConfig config) {
    try {
      final ArrayList<CharSequence> results = CollectionLiterals.<CharSequence>newArrayList();
      Iterable<JvmDeclaredType> _filter = Iterables.<JvmDeclaredType>filter(file.eResource().getContents(), JvmDeclaredType.class);
      for (final JvmDeclaredType inferredType : _filter) {
        {
          Assert.assertFalse(DisableCodeGenerationAdapter.isDisabled(inferredType));
          CharSequence javaCode = this.generator.generateType(inferredType, config);
          javaCode = this.postProcessor.postProcess(null, javaCode);
          results.add(javaCode);
          if ((this.useJavaCompiler && (input != null))) {
            final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
              it.getCompiledClass();
            };
            this.compilationTestHelper.compile(input, _function);
          }
        }
      }
      return results;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
