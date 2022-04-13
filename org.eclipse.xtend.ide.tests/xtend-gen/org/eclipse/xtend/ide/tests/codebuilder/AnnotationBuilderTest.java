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
import org.eclipse.xtend.ide.codebuilder.AbstractAnnotationBuilder;
import org.eclipse.xtend.ide.codebuilder.CodeBuilderFactory;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;

@SuppressWarnings("all")
public class AnnotationBuilderTest extends AbstractBuilderTest {
  @Inject
  @Extension
  private CodeBuilderFactory _codeBuilderFactory;

  @Test
  public void testXtendAnnotation() {
    AbstractAnnotationBuilder _createAnnotationBuilder = this._codeBuilderFactory.createAnnotationBuilder(this.getXtendClass());
    final Procedure1<AbstractAnnotationBuilder> _function = (AbstractAnnotationBuilder it) -> {
      it.setContext(this.getXtendClass());
      it.setAnnotationName("Bar");
      it.setVisibility(JvmVisibility.PUBLIC);
    };
    AbstractAnnotationBuilder _doubleArrow = ObjectExtensions.<AbstractAnnotationBuilder>operator_doubleArrow(_createAnnotationBuilder, _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("annotation Bar {");
    _builder.newLine();
    _builder.append("}");
    this.assertBuilds(_doubleArrow, _builder.toString());
  }

  @Test
  public void testJavaAnnotation() {
    AbstractAnnotationBuilder _createAnnotationBuilder = this._codeBuilderFactory.createAnnotationBuilder(this.getJavaClass());
    final Procedure1<AbstractAnnotationBuilder> _function = (AbstractAnnotationBuilder it) -> {
      it.setContext(this.getJavaClass());
      it.setAnnotationName("Bar");
      it.setVisibility(JvmVisibility.PUBLIC);
    };
    AbstractAnnotationBuilder _doubleArrow = ObjectExtensions.<AbstractAnnotationBuilder>operator_doubleArrow(_createAnnotationBuilder, _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public @interface Bar {");
    _builder.newLine();
    _builder.append("}");
    this.assertBuilds(_doubleArrow, _builder.toString());
  }
}
