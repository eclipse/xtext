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
import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.tests.compiler.XtendCompilerTest;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.generator.IFilePostProcessor;
import org.eclipse.xtext.generator.trace.ITraceRegionProvider;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.DisableCodeGenerationAdapter;
import org.eclipse.xtext.xbase.compiler.GeneratorConfig;
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.compiler.OnTheFlyJavaCompiler;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
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
  protected OnTheFlyJavaCompiler compiler;
  
  @Inject
  protected IFilePostProcessor postProcessor;
  
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
      boolean _and = false;
      if (!this.useJavaCompiler) {
        _and = false;
      } else {
        EList<XtendTypeDeclaration> _xtendTypes = file.getXtendTypes();
        int _size = _xtendTypes.size();
        boolean _equals = (_size == 1);
        _and = (this.useJavaCompiler && _equals);
      }
      if (_and) {
        String _xifexpression = null;
        String _package = file.getPackage();
        boolean _notEquals = (!Objects.equal(_package, null));
        if (_notEquals) {
          String _package_1 = file.getPackage();
          String _plus = (_package_1 + ".");
          EList<XtendTypeDeclaration> _xtendTypes_1 = file.getXtendTypes();
          XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes_1);
          String _name = _head.getName();
          _xifexpression = (_plus + _name);
        } else {
          EList<XtendTypeDeclaration> _xtendTypes_2 = file.getXtendTypes();
          XtendTypeDeclaration _head_1 = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes_2);
          _xifexpression = _head_1.getName();
        }
        final String typeName = _xifexpression;
        String _string_3 = expected.toString();
        this.compiler.compileToClass(typeName, _string_3);
      }
      return file;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
