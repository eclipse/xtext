/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.compiler;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.tests.compiler.XtendCompilerTest;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.xbase.compiler.DisableCodeGenerationAdapter;
import org.eclipse.xtext.xbase.compiler.GeneratorConfig;
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractXtendCompilerTest extends AbstractXtendTestCase {
  @Inject
  protected JvmModelGenerator generator;
  
  @Inject
  protected IGeneratorConfigProvider generatorConfigProvider;
  
  public void assertCompilesTo(final CharSequence input, final CharSequence expected) {
    GeneratorConfig _get = this.generatorConfigProvider.get(null);
    this.assertCompilesTo(input, expected, _get);
  }
  
  public void assertCompilesTo(final CharSequence input, final CharSequence expected, final GeneratorConfig config) {
    try {
      String _string = input.toString();
      final XtendFile file = this.file(_string, true);
      Resource _eResource = file.eResource();
      EList<EObject> _contents = _eResource.getContents();
      Iterable<JvmDeclaredType> _filter = Iterables.<JvmDeclaredType>filter(_contents, JvmDeclaredType.class);
      final JvmDeclaredType inferredType = IterableExtensions.<JvmDeclaredType>head(_filter);
      boolean _isDisabled = DisableCodeGenerationAdapter.isDisabled(inferredType);
      Assert.assertFalse(_isDisabled);
      final CharSequence javaCode = this.generator.generateType(inferredType, config);
      String _string_1 = expected.toString();
      String _string_2 = javaCode.toString();
      XtendCompilerTest.assertEquals(_string_1, _string_2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
