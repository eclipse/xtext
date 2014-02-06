/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.compiler;

import bug380058.Amount;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.tests.compiler.XtendCompilerTest;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.generator.IFilePostProcessor;
import org.eclipse.xtext.generator.trace.ITraceRegionProvider;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper;
import org.eclipse.xtext.xbase.compiler.DisableCodeGenerationAdapter;
import org.eclipse.xtext.xbase.compiler.GeneratorConfig;
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.compiler.OnTheFlyJavaCompiler;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.hamcrest.Matcher;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import testdata.Annotation1;

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
  protected OnTheFlyJavaCompiler compiler;
  
  @Inject
  protected IFilePostProcessor postProcessor;
  
  @Inject
  private CompilationTestHelper compilationTestHelper;
  
  protected boolean useJavaCompiler = false;
  
  @Before
  public void setupCompiler() {
    Class<? extends AbstractXtendCompilerTest> _class = this.getClass();
    this.compiler.addClassPathOfClass(_class);
    this.compiler.addClassPathOfClass(Amount.class);
    this.compiler.addClassPathOfClass(Data.class);
    this.compiler.addClassPathOfClass(Inject.class);
    this.compiler.addClassPathOfClass(CollectionLiterals.class);
    this.compiler.addClassPathOfClass(JvmTypeParameter.class);
    this.compiler.addClassPathOfClass(ITraceRegionProvider.class);
    this.compiler.addClassPathOfClass(XExpression.class);
    this.compiler.addClassPathOfClass(Objects.class);
    Class<? extends AbstractXtendCompilerTest> _class_1 = this.getClass();
    ClassLoader _classLoader = _class_1.getClassLoader();
    this.compiler.setParentClassLoader(_classLoader);
    Class<? extends AbstractXtendCompilerTest> _class_2 = this.getClass();
    this.compilationTestHelper.setJavaCompilerClassPath(_class_2, 
      Amount.class, 
      Data.class, 
      Inject.class, 
      CollectionLiterals.class, 
      JvmTypeParameter.class, 
      ITraceRegionProvider.class, 
      XExpression.class, 
      Object.class, 
      Annotation1.class, 
      Lists.class, 
      EObject.class, 
      Matcher.class, 
      Is.class, 
      Assert.class);
  }
  
  public void assertCompilesTo(final CharSequence input, final CharSequence expected) {
    GeneratorConfig _get = this.generatorConfigProvider.get(null);
    this.assertCompilesTo(input, expected, _get);
  }
  
  public void assertCompilesTo(final CharSequence input, final CharSequence expected, final GeneratorConfig config) {
    this.doAssertCompilesTo(input, expected, config);
  }
  
  protected XtendFile doAssertCompilesTo(final CharSequence input, final CharSequence expected, final GeneratorConfig config) {
    try {
      String _string = input.toString();
      final XtendFile file = this.file(_string, true);
      Resource _eResource = file.eResource();
      EList<EObject> _contents = _eResource.getContents();
      Iterable<JvmDeclaredType> _filter = Iterables.<JvmDeclaredType>filter(_contents, JvmDeclaredType.class);
      final JvmDeclaredType inferredType = IterableExtensions.<JvmDeclaredType>head(_filter);
      boolean _isDisabled = DisableCodeGenerationAdapter.isDisabled(inferredType);
      Assert.assertFalse(_isDisabled);
      CharSequence javaCode = this.generator.generateType(inferredType, config);
      CharSequence _postProcess = this.postProcessor.postProcess(null, javaCode);
      javaCode = _postProcess;
      String _string_1 = expected.toString();
      String _string_2 = javaCode.toString();
      XtendCompilerTest.assertEquals(_string_1, _string_2);
      if (this.useJavaCompiler) {
        final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
          public void accept(final CompilationTestHelper.Result it) {
            it.getCompiledClass();
          }
        };
        this.compilationTestHelper.compile(input, _function);
      }
      return file;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
