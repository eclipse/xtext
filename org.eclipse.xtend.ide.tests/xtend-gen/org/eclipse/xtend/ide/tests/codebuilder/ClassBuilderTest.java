/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.codebuilder;

import com.google.inject.Inject;
import org.eclipse.xtend.ide.codebuilder.AbstractClassBuilder;
import org.eclipse.xtend.ide.codebuilder.CodeBuilderFactory;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;

@SuppressWarnings("all")
public class ClassBuilderTest extends AbstractBuilderTest {
  @Inject
  @Extension
  private CodeBuilderFactory _codeBuilderFactory;

  @Test
  public void testXtendClass() {
    AbstractClassBuilder _createClassBuilder = this._codeBuilderFactory.createClassBuilder(this.getXtendClass());
    final Procedure1<AbstractClassBuilder> _function = (AbstractClassBuilder it) -> {
      it.setContext(this.getXtendClass());
      it.setClassName("Bar");
      it.setVisibility(JvmVisibility.PUBLIC);
    };
    AbstractClassBuilder _doubleArrow = ObjectExtensions.<AbstractClassBuilder>operator_doubleArrow(_createClassBuilder, _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Bar {");
    _builder.newLine();
    _builder.append("}");
    this.assertBuilds(_doubleArrow, _builder.toString());
  }

  @Test
  public void testJavaClass() {
    AbstractClassBuilder _createClassBuilder = this._codeBuilderFactory.createClassBuilder(this.getJavaClass());
    final Procedure1<AbstractClassBuilder> _function = (AbstractClassBuilder it) -> {
      it.setContext(this.getJavaClass());
      it.setClassName("Bar");
      it.setVisibility(JvmVisibility.PUBLIC);
    };
    AbstractClassBuilder _doubleArrow = ObjectExtensions.<AbstractClassBuilder>operator_doubleArrow(_createClassBuilder, _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class Bar {");
    _builder.newLine();
    _builder.append("}");
    this.assertBuilds(_doubleArrow, _builder.toString());
  }
}
