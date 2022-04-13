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
import java.util.Collections;
import org.eclipse.xtend.ide.codebuilder.AbstractConstructorBuilder;
import org.eclipse.xtend.ide.codebuilder.AbstractParameterBuilder;
import org.eclipse.xtend.ide.codebuilder.CodeBuilderFactory;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.compiler.ISourceAppender;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Test;

@SuppressWarnings("all")
public class ConstructorBuilderTest extends AbstractBuilderTest {
  @Inject
  @Extension
  private CodeBuilderFactory _codeBuilderFactory;

  @Test
  public void testXtendConstructor() {
    AbstractConstructorBuilder _createConstructorBuilder = this._codeBuilderFactory.createConstructorBuilder(this.getXtendClass());
    final Procedure1<AbstractConstructorBuilder> _function = (AbstractConstructorBuilder it) -> {
      it.setContext(this.getXtendClass());
      it.setVisibility(JvmVisibility.PROTECTED);
      AbstractParameterBuilder _newParameterBuilder = it.newParameterBuilder();
      _newParameterBuilder.setType(this.createTypeRef(this.getXtendClass()));
      AbstractParameterBuilder _newParameterBuilder_1 = it.newParameterBuilder();
      _newParameterBuilder_1.setType(this.createTypeRef(this.getXtendClass()));
    };
    AbstractConstructorBuilder _doubleArrow = ObjectExtensions.<AbstractConstructorBuilder>operator_doubleArrow(_createConstructorBuilder, _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("protected new(Foo foo, Foo foo2) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append(AbstractBuilderTest.DEFAULT_BODY, "  ");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    this.assertBuilds(_doubleArrow, _builder.toString());
  }

  @Test
  public void testJavaConstructor() {
    AbstractConstructorBuilder _createConstructorBuilder = this._codeBuilderFactory.createConstructorBuilder(this.getJavaClass());
    final Procedure1<AbstractConstructorBuilder> _function = (AbstractConstructorBuilder it) -> {
      it.setContext(this.getJavaClass());
      it.setVisibility(JvmVisibility.PRIVATE);
      AbstractParameterBuilder _newParameterBuilder = it.newParameterBuilder();
      _newParameterBuilder.setType(this.createTypeRef(this.getJavaClass()));
      AbstractParameterBuilder _newParameterBuilder_1 = it.newParameterBuilder();
      _newParameterBuilder_1.setType(this.createTypeRef(this.getJavaClass()));
    };
    AbstractConstructorBuilder _doubleArrow = ObjectExtensions.<AbstractConstructorBuilder>operator_doubleArrow(_createConstructorBuilder, _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("private Bar(Bar bar, Bar bar2) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append(AbstractBuilderTest.DEFAULT_BODY, "  ");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    this.assertBuilds(_doubleArrow, _builder.toString());
  }

  @Test
  public void testXtendParameterNames() {
    AbstractConstructorBuilder _createConstructorBuilder = this._codeBuilderFactory.createConstructorBuilder(this.getXtendClass());
    final Procedure1<AbstractConstructorBuilder> _function = (AbstractConstructorBuilder it) -> {
      it.setContext(this.getXtendClass());
      it.setVisibility(JvmVisibility.PROTECTED);
      AbstractParameterBuilder _newParameterBuilder = it.newParameterBuilder();
      final Procedure1<AbstractParameterBuilder> _function_1 = (AbstractParameterBuilder it_1) -> {
        it_1.setType(this.createTypeRef(this.getXtendClass()));
        it_1.setName("bar");
      };
      ObjectExtensions.<AbstractParameterBuilder>operator_doubleArrow(_newParameterBuilder, _function_1);
      AbstractParameterBuilder _newParameterBuilder_1 = it.newParameterBuilder();
      final Procedure1<AbstractParameterBuilder> _function_2 = (AbstractParameterBuilder it_1) -> {
        it_1.setType(this.createTypeRef(this.getJavaClass()));
        it_1.setName("foo");
      };
      ObjectExtensions.<AbstractParameterBuilder>operator_doubleArrow(_newParameterBuilder_1, _function_2);
    };
    AbstractConstructorBuilder _doubleArrow = ObjectExtensions.<AbstractConstructorBuilder>operator_doubleArrow(_createConstructorBuilder, _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("protected new(Foo bar, Bar foo) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append(AbstractBuilderTest.DEFAULT_BODY, "  ");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    this.assertBuilds(_doubleArrow, _builder.toString());
  }

  @Test
  public void testJavaParameterNames() {
    AbstractConstructorBuilder _createConstructorBuilder = this._codeBuilderFactory.createConstructorBuilder(this.getJavaClass());
    final Procedure1<AbstractConstructorBuilder> _function = (AbstractConstructorBuilder it) -> {
      it.setContext(this.getJavaClass());
      it.setVisibility(JvmVisibility.PRIVATE);
      AbstractParameterBuilder _newParameterBuilder = it.newParameterBuilder();
      final Procedure1<AbstractParameterBuilder> _function_1 = (AbstractParameterBuilder it_1) -> {
        it_1.setType(this.createTypeRef(this.getXtendClass()));
        it_1.setName("bar");
      };
      ObjectExtensions.<AbstractParameterBuilder>operator_doubleArrow(_newParameterBuilder, _function_1);
      AbstractParameterBuilder _newParameterBuilder_1 = it.newParameterBuilder();
      final Procedure1<AbstractParameterBuilder> _function_2 = (AbstractParameterBuilder it_1) -> {
        it_1.setType(this.createTypeRef(this.getJavaClass()));
        it_1.setName("foo");
      };
      ObjectExtensions.<AbstractParameterBuilder>operator_doubleArrow(_newParameterBuilder_1, _function_2);
    };
    AbstractConstructorBuilder _doubleArrow = ObjectExtensions.<AbstractConstructorBuilder>operator_doubleArrow(_createConstructorBuilder, _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("private Bar(Foo bar, Bar foo) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append(AbstractBuilderTest.DEFAULT_BODY, "  ");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    this.assertBuilds(_doubleArrow, _builder.toString());
  }

  @Test
  public void testXtendExceptions() {
    AbstractConstructorBuilder _createConstructorBuilder = this._codeBuilderFactory.createConstructorBuilder(this.getXtendClass());
    final Procedure1<AbstractConstructorBuilder> _function = (AbstractConstructorBuilder it) -> {
      it.setContext(this.getXtendClass());
      LightweightTypeReference _createTypeRef = this.createTypeRef(Exception.class, this.getXtendClass());
      LightweightTypeReference _createTypeRef_1 = this.createTypeRef(RuntimeException.class, this.getXtendClass());
      it.setExceptions(Collections.<LightweightTypeReference>unmodifiableList(CollectionLiterals.<LightweightTypeReference>newArrayList(_createTypeRef, _createTypeRef_1)));
    };
    AbstractConstructorBuilder _doubleArrow = ObjectExtensions.<AbstractConstructorBuilder>operator_doubleArrow(_createConstructorBuilder, _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new() throws Exception, RuntimeException {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append(AbstractBuilderTest.DEFAULT_BODY, "  ");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    this.assertBuilds(_doubleArrow, _builder.toString());
  }

  @Test
  public void testJavaException() {
    AbstractConstructorBuilder _createConstructorBuilder = this._codeBuilderFactory.createConstructorBuilder(this.getJavaClass());
    final Procedure1<AbstractConstructorBuilder> _function = (AbstractConstructorBuilder it) -> {
      it.setContext(this.getJavaClass());
      LightweightTypeReference _createTypeRef = this.createTypeRef(Exception.class, this.getJavaClass());
      LightweightTypeReference _createTypeRef_1 = this.createTypeRef(RuntimeException.class, this.getJavaClass());
      it.setExceptions(Collections.<LightweightTypeReference>unmodifiableList(CollectionLiterals.<LightweightTypeReference>newArrayList(_createTypeRef, _createTypeRef_1)));
    };
    AbstractConstructorBuilder _doubleArrow = ObjectExtensions.<AbstractConstructorBuilder>operator_doubleArrow(_createConstructorBuilder, _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Bar() throws Exception, RuntimeException {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append(AbstractBuilderTest.DEFAULT_BODY, "  ");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    this.assertBuilds(_doubleArrow, _builder.toString());
  }

  @Test
  public void testXtendCustomBody() {
    AbstractConstructorBuilder _createConstructorBuilder = this._codeBuilderFactory.createConstructorBuilder(this.getXtendClass());
    final Procedure1<AbstractConstructorBuilder> _function = (AbstractConstructorBuilder it) -> {
      it.setContext(this.getXtendClass());
      final Procedure1<ISourceAppender> _function_1 = (ISourceAppender it_1) -> {
        it_1.append("return");
      };
      it.setBodyGenerator(_function_1);
    };
    AbstractConstructorBuilder _doubleArrow = ObjectExtensions.<AbstractConstructorBuilder>operator_doubleArrow(_createConstructorBuilder, _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new() {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("return");
    _builder.newLine();
    _builder.append("}");
    this.assertBuilds(_doubleArrow, _builder.toString());
  }

  @Test
  public void testJavaCustomBody() {
    AbstractConstructorBuilder _createConstructorBuilder = this._codeBuilderFactory.createConstructorBuilder(this.getJavaClass());
    final Procedure1<AbstractConstructorBuilder> _function = (AbstractConstructorBuilder it) -> {
      it.setContext(this.getJavaClass());
      final Procedure1<ISourceAppender> _function_1 = (ISourceAppender it_1) -> {
        it_1.append("return");
      };
      it.setBodyGenerator(_function_1);
    };
    AbstractConstructorBuilder _doubleArrow = ObjectExtensions.<AbstractConstructorBuilder>operator_doubleArrow(_createConstructorBuilder, _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Bar() {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("return;");
    _builder.newLine();
    _builder.append("}");
    this.assertBuilds(_doubleArrow, _builder.toString());
  }
}
