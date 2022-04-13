/**
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.codebuilder;

import com.google.inject.Inject;
import java.util.Collections;
import org.eclipse.xtend.ide.codebuilder.AbstractMethodBuilder;
import org.eclipse.xtend.ide.codebuilder.AbstractParameterBuilder;
import org.eclipse.xtend.ide.codebuilder.CodeBuilderFactory;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.compiler.ISourceAppender;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class MethodBuilderTest extends AbstractBuilderTest {
  @Inject
  @Extension
  private CodeBuilderFactory _codeBuilderFactory;

  @Inject
  @Extension
  private TypesFactory _typesFactory;

  @Test
  public void testXtendMethod() {
    AbstractMethodBuilder _createMethodBuilder = this._codeBuilderFactory.createMethodBuilder(this.getXtendClass());
    final Procedure1<AbstractMethodBuilder> _function = (AbstractMethodBuilder it) -> {
      it.setContext(this.getXtendClass());
      it.setMethodName("foo");
      it.setReturnType(this.createTypeRef(this.getXtendClass()));
      it.setVisibility(JvmVisibility.PUBLIC);
      AbstractParameterBuilder _newParameterBuilder = it.newParameterBuilder();
      _newParameterBuilder.setType(this.createTypeRef(this.getXtendClass()));
      AbstractParameterBuilder _newParameterBuilder_1 = it.newParameterBuilder();
      _newParameterBuilder_1.setType(this.createTypeRef(this.getXtendClass()));
    };
    AbstractMethodBuilder _doubleArrow = ObjectExtensions.<AbstractMethodBuilder>operator_doubleArrow(_createMethodBuilder, _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("def foo(Foo foo, Foo foo2) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append(AbstractBuilderTest.DEFAULT_BODY, "  ");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    this.assertBuilds(_doubleArrow, _builder.toString());
  }

  @Test
  public void testJavaMethod() {
    AbstractMethodBuilder _createMethodBuilder = this._codeBuilderFactory.createMethodBuilder(this.getJavaClass());
    final Procedure1<AbstractMethodBuilder> _function = (AbstractMethodBuilder it) -> {
      it.setContext(this.getJavaClass());
      it.setMethodName("bar");
      it.setReturnType(this.createTypeRef(this.getJavaClass()));
      it.setVisibility(JvmVisibility.PUBLIC);
      AbstractParameterBuilder _newParameterBuilder = it.newParameterBuilder();
      _newParameterBuilder.setType(this.createTypeRef(this.getJavaClass()));
      AbstractParameterBuilder _newParameterBuilder_1 = it.newParameterBuilder();
      _newParameterBuilder_1.setType(this.createTypeRef(this.getJavaClass()));
    };
    AbstractMethodBuilder _doubleArrow = ObjectExtensions.<AbstractMethodBuilder>operator_doubleArrow(_createMethodBuilder, _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public Bar bar(Bar bar, Bar bar2) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append(AbstractBuilderTest.DEFAULT_BODY, "  ");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    this.assertBuilds(_doubleArrow, _builder.toString());
  }

  @Test
  public void testStaticXtendMethod() {
    AbstractMethodBuilder _createMethodBuilder = this._codeBuilderFactory.createMethodBuilder(this.getXtendClass());
    final Procedure1<AbstractMethodBuilder> _function = (AbstractMethodBuilder it) -> {
      it.setContext(this.getXtendClass());
      it.setMethodName("foo");
      it.setReturnType(this.createTypeRef(this.getXtendClass()));
      it.setVisibility(JvmVisibility.PROTECTED);
      it.setStaticFlag(true);
      AbstractParameterBuilder _newParameterBuilder = it.newParameterBuilder();
      _newParameterBuilder.setType(this.createTypeRef(this.getXtendClass()));
    };
    AbstractMethodBuilder _doubleArrow = ObjectExtensions.<AbstractMethodBuilder>operator_doubleArrow(_createMethodBuilder, _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("def protected static foo(Foo foo) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append(AbstractBuilderTest.DEFAULT_BODY, "  ");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    this.assertBuilds(_doubleArrow, _builder.toString());
  }

  @Test
  public void testStaticJavaMethod() {
    AbstractMethodBuilder _createMethodBuilder = this._codeBuilderFactory.createMethodBuilder(this.getJavaClass());
    final Procedure1<AbstractMethodBuilder> _function = (AbstractMethodBuilder it) -> {
      it.setContext(this.getJavaClass());
      it.setMethodName("bar");
      it.setReturnType(this.createTypeRef(this.getJavaClass()));
      it.setVisibility(JvmVisibility.PRIVATE);
      it.setStaticFlag(true);
      AbstractParameterBuilder _newParameterBuilder = it.newParameterBuilder();
      _newParameterBuilder.setType(this.createTypeRef(this.getJavaClass()));
    };
    AbstractMethodBuilder _doubleArrow = ObjectExtensions.<AbstractMethodBuilder>operator_doubleArrow(_createMethodBuilder, _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("private static Bar bar(Bar bar) {");
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
    AbstractMethodBuilder _createMethodBuilder = this._codeBuilderFactory.createMethodBuilder(this.getXtendClass());
    final Procedure1<AbstractMethodBuilder> _function = (AbstractMethodBuilder it) -> {
      it.setContext(this.getXtendClass());
      it.setMethodName("foo");
      final Procedure1<ISourceAppender> _function_1 = (ISourceAppender it_1) -> {
        it_1.append("return");
      };
      it.setBodyGenerator(_function_1);
    };
    AbstractMethodBuilder _doubleArrow = ObjectExtensions.<AbstractMethodBuilder>operator_doubleArrow(_createMethodBuilder, _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("return");
    _builder.newLine();
    _builder.append("}");
    this.assertBuilds(_doubleArrow, _builder.toString());
  }

  @Test
  public void testJavaCustomBody() {
    AbstractMethodBuilder _createMethodBuilder = this._codeBuilderFactory.createMethodBuilder(this.getJavaClass());
    final Procedure1<AbstractMethodBuilder> _function = (AbstractMethodBuilder it) -> {
      it.setContext(this.getJavaClass());
      it.setMethodName("foo");
      final Procedure1<ISourceAppender> _function_1 = (ISourceAppender it_1) -> {
        it_1.append("return");
      };
      it.setBodyGenerator(_function_1);
    };
    AbstractMethodBuilder _doubleArrow = ObjectExtensions.<AbstractMethodBuilder>operator_doubleArrow(_createMethodBuilder, _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("void foo() {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("return;");
    _builder.newLine();
    _builder.append("}");
    this.assertBuilds(_doubleArrow, _builder.toString());
  }

  @Test
  public void testXtendAbstractBody() {
    AbstractMethodBuilder _createMethodBuilder = this._codeBuilderFactory.createMethodBuilder(this.getXtendClass());
    final Procedure1<AbstractMethodBuilder> _function = (AbstractMethodBuilder it) -> {
      it.setContext(this.getXtendClass());
      it.setAbstractFlag(true);
      it.setMethodName("foo");
    };
    AbstractMethodBuilder _doubleArrow = ObjectExtensions.<AbstractMethodBuilder>operator_doubleArrow(_createMethodBuilder, _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("def void foo()");
    this.assertBuilds(_doubleArrow, _builder.toString());
  }

  @Test
  public void testJavaAbstractBody() {
    AbstractMethodBuilder _createMethodBuilder = this._codeBuilderFactory.createMethodBuilder(this.getJavaClass());
    final Procedure1<AbstractMethodBuilder> _function = (AbstractMethodBuilder it) -> {
      it.setContext(this.getJavaClass());
      it.setAbstractFlag(true);
      it.setMethodName("foo");
    };
    AbstractMethodBuilder _doubleArrow = ObjectExtensions.<AbstractMethodBuilder>operator_doubleArrow(_createMethodBuilder, _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("abstract void foo();");
    this.assertBuilds(_doubleArrow, _builder.toString());
  }

  @Test
  public void testXtendOverrride() {
    AbstractMethodBuilder _createMethodBuilder = this._codeBuilderFactory.createMethodBuilder(this.getXtendClass());
    final Procedure1<AbstractMethodBuilder> _function = (AbstractMethodBuilder it) -> {
      it.setContext(this.getXtendClass());
      it.setMethodName("foo");
      it.setOverrideFlag(true);
    };
    AbstractMethodBuilder _doubleArrow = ObjectExtensions.<AbstractMethodBuilder>operator_doubleArrow(_createMethodBuilder, _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("override foo() {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append(AbstractBuilderTest.DEFAULT_BODY, "  ");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    this.assertBuilds(_doubleArrow, _builder.toString());
  }

  @Test
  public void testJavaOverride() {
    AbstractMethodBuilder _createMethodBuilder = this._codeBuilderFactory.createMethodBuilder(this.getJavaClass());
    final Procedure1<AbstractMethodBuilder> _function = (AbstractMethodBuilder it) -> {
      it.setContext(this.getJavaClass());
      it.setMethodName("foo");
      it.setOverrideFlag(true);
    };
    AbstractMethodBuilder _doubleArrow = ObjectExtensions.<AbstractMethodBuilder>operator_doubleArrow(_createMethodBuilder, _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("void foo() {");
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
    AbstractMethodBuilder _createMethodBuilder = this._codeBuilderFactory.createMethodBuilder(this.getXtendClass());
    final Procedure1<AbstractMethodBuilder> _function = (AbstractMethodBuilder it) -> {
      it.setContext(this.getXtendClass());
      it.setMethodName("foo");
      LightweightTypeReference _createTypeRef = this.createTypeRef(Exception.class, this.getXtendClass());
      LightweightTypeReference _createTypeRef_1 = this.createTypeRef(RuntimeException.class, this.getXtendClass());
      it.setExceptions(Collections.<LightweightTypeReference>unmodifiableList(CollectionLiterals.<LightweightTypeReference>newArrayList(_createTypeRef, _createTypeRef_1)));
    };
    AbstractMethodBuilder _doubleArrow = ObjectExtensions.<AbstractMethodBuilder>operator_doubleArrow(_createMethodBuilder, _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("def foo() throws Exception, RuntimeException {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append(AbstractBuilderTest.DEFAULT_BODY, "  ");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    this.assertBuilds(_doubleArrow, _builder.toString());
  }

  @Test
  public void testJavaException() {
    AbstractMethodBuilder _createMethodBuilder = this._codeBuilderFactory.createMethodBuilder(this.getJavaClass());
    final Procedure1<AbstractMethodBuilder> _function = (AbstractMethodBuilder it) -> {
      it.setContext(this.getJavaClass());
      it.setMethodName("foo");
      LightweightTypeReference _createTypeRef = this.createTypeRef(Exception.class, this.getJavaClass());
      LightweightTypeReference _createTypeRef_1 = this.createTypeRef(RuntimeException.class, this.getJavaClass());
      it.setExceptions(Collections.<LightweightTypeReference>unmodifiableList(CollectionLiterals.<LightweightTypeReference>newArrayList(_createTypeRef, _createTypeRef_1)));
    };
    AbstractMethodBuilder _doubleArrow = ObjectExtensions.<AbstractMethodBuilder>operator_doubleArrow(_createMethodBuilder, _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("void foo() throws Exception, RuntimeException {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append(AbstractBuilderTest.DEFAULT_BODY, "  ");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    this.assertBuilds(_doubleArrow, _builder.toString());
  }

  @Test
  public void testXtendNamedParameter() {
    AbstractMethodBuilder _createMethodBuilder = this._codeBuilderFactory.createMethodBuilder(this.getXtendClass());
    final Procedure1<AbstractMethodBuilder> _function = (AbstractMethodBuilder it) -> {
      it.setContext(this.getXtendClass());
      it.setMethodName("foo");
      AbstractParameterBuilder _newParameterBuilder = it.newParameterBuilder();
      final Procedure1<AbstractParameterBuilder> _function_1 = (AbstractParameterBuilder it_1) -> {
        it_1.setName("bar");
        it_1.setType(this.createTypeRef(this.getXtendClass()));
      };
      ObjectExtensions.<AbstractParameterBuilder>operator_doubleArrow(_newParameterBuilder, _function_1);
      AbstractParameterBuilder _newParameterBuilder_1 = it.newParameterBuilder();
      final Procedure1<AbstractParameterBuilder> _function_2 = (AbstractParameterBuilder it_1) -> {
        it_1.setName("baz");
        it_1.setType(this.createTypeRef(this.getXtendClass()));
      };
      ObjectExtensions.<AbstractParameterBuilder>operator_doubleArrow(_newParameterBuilder_1, _function_2);
    };
    AbstractMethodBuilder _doubleArrow = ObjectExtensions.<AbstractMethodBuilder>operator_doubleArrow(_createMethodBuilder, _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("def foo(Foo bar, Foo baz) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append(AbstractBuilderTest.DEFAULT_BODY, "  ");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    this.assertBuilds(_doubleArrow, _builder.toString());
  }

  @Test
  public void testJavaNamedParameter() {
    AbstractMethodBuilder _createMethodBuilder = this._codeBuilderFactory.createMethodBuilder(this.getJavaClass());
    final Procedure1<AbstractMethodBuilder> _function = (AbstractMethodBuilder it) -> {
      it.setContext(this.getJavaClass());
      it.setMethodName("foo");
      AbstractParameterBuilder _newParameterBuilder = it.newParameterBuilder();
      final Procedure1<AbstractParameterBuilder> _function_1 = (AbstractParameterBuilder it_1) -> {
        it_1.setName("bar");
        it_1.setType(this.createTypeRef(this.getXtendClass()));
      };
      ObjectExtensions.<AbstractParameterBuilder>operator_doubleArrow(_newParameterBuilder, _function_1);
      AbstractParameterBuilder _newParameterBuilder_1 = it.newParameterBuilder();
      final Procedure1<AbstractParameterBuilder> _function_2 = (AbstractParameterBuilder it_1) -> {
        it_1.setName("baz");
        it_1.setType(this.createTypeRef(this.getXtendClass()));
      };
      ObjectExtensions.<AbstractParameterBuilder>operator_doubleArrow(_newParameterBuilder_1, _function_2);
    };
    AbstractMethodBuilder _doubleArrow = ObjectExtensions.<AbstractMethodBuilder>operator_doubleArrow(_createMethodBuilder, _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("void foo(Foo bar, Foo baz) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append(AbstractBuilderTest.DEFAULT_BODY, "  ");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    this.assertBuilds(_doubleArrow, _builder.toString());
  }

  @Test
  public void testXtendTypeParameter() {
    AbstractMethodBuilder _createMethodBuilder = this._codeBuilderFactory.createMethodBuilder(this.getXtendClass());
    final Procedure1<AbstractMethodBuilder> _function = (AbstractMethodBuilder it) -> {
      it.setContext(this.getXtendClass());
      it.setMethodName("foo");
      JvmTypeParameter _createJvmTypeParameter = this._typesFactory.createJvmTypeParameter();
      final Procedure1<JvmTypeParameter> _function_1 = (JvmTypeParameter it_1) -> {
        it_1.setName("T");
      };
      JvmTypeParameter _doubleArrow = ObjectExtensions.<JvmTypeParameter>operator_doubleArrow(_createJvmTypeParameter, _function_1);
      JvmTypeParameter _createJvmTypeParameter_1 = this._typesFactory.createJvmTypeParameter();
      final Procedure1<JvmTypeParameter> _function_2 = (JvmTypeParameter it_1) -> {
        it_1.setName("U");
      };
      JvmTypeParameter _doubleArrow_1 = ObjectExtensions.<JvmTypeParameter>operator_doubleArrow(_createJvmTypeParameter_1, _function_2);
      it.setTypeParameters(Collections.<JvmTypeParameter>unmodifiableList(CollectionLiterals.<JvmTypeParameter>newArrayList(_doubleArrow, _doubleArrow_1)));
    };
    AbstractMethodBuilder _doubleArrow = ObjectExtensions.<AbstractMethodBuilder>operator_doubleArrow(_createMethodBuilder, _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("def <T,U> foo() {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append(AbstractBuilderTest.DEFAULT_BODY, "  ");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    this.assertBuilds(_doubleArrow, _builder.toString());
  }

  @Test
  public void testJavaTypeParameter() {
    AbstractMethodBuilder _createMethodBuilder = this._codeBuilderFactory.createMethodBuilder(this.getJavaClass());
    final Procedure1<AbstractMethodBuilder> _function = (AbstractMethodBuilder it) -> {
      it.setContext(this.getJavaClass());
      it.setMethodName("foo");
      JvmTypeParameter _createJvmTypeParameter = this._typesFactory.createJvmTypeParameter();
      final Procedure1<JvmTypeParameter> _function_1 = (JvmTypeParameter it_1) -> {
        it_1.setName("T");
      };
      JvmTypeParameter _doubleArrow = ObjectExtensions.<JvmTypeParameter>operator_doubleArrow(_createJvmTypeParameter, _function_1);
      JvmTypeParameter _createJvmTypeParameter_1 = this._typesFactory.createJvmTypeParameter();
      final Procedure1<JvmTypeParameter> _function_2 = (JvmTypeParameter it_1) -> {
        it_1.setName("U");
      };
      JvmTypeParameter _doubleArrow_1 = ObjectExtensions.<JvmTypeParameter>operator_doubleArrow(_createJvmTypeParameter_1, _function_2);
      it.setTypeParameters(Collections.<JvmTypeParameter>unmodifiableList(CollectionLiterals.<JvmTypeParameter>newArrayList(_doubleArrow, _doubleArrow_1)));
    };
    AbstractMethodBuilder _doubleArrow = ObjectExtensions.<AbstractMethodBuilder>operator_doubleArrow(_createMethodBuilder, _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<T,U> void foo() {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append(AbstractBuilderTest.DEFAULT_BODY, "  ");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    this.assertBuilds(_doubleArrow, _builder.toString());
  }

  @Test
  public void testXtendSynchronized() {
    AbstractMethodBuilder _createMethodBuilder = this._codeBuilderFactory.createMethodBuilder(this.getXtendClass());
    final Procedure1<AbstractMethodBuilder> _function = (AbstractMethodBuilder it) -> {
      it.setContext(this.getXtendClass());
      it.setMethodName("foo");
      it.setReturnType(this.createTypeRef(this.getXtendClass()));
      it.setVisibility(JvmVisibility.PUBLIC);
      it.setSynchronizedFlag(true);
    };
    AbstractMethodBuilder _doubleArrow = ObjectExtensions.<AbstractMethodBuilder>operator_doubleArrow(_createMethodBuilder, _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("def synchronized foo() {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append(AbstractBuilderTest.DEFAULT_BODY, "  ");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    this.assertBuilds(_doubleArrow, _builder.toString());
  }

  @Test
  public void testJavaSynchronized() {
    AbstractMethodBuilder _createMethodBuilder = this._codeBuilderFactory.createMethodBuilder(this.getJavaClass());
    final Procedure1<AbstractMethodBuilder> _function = (AbstractMethodBuilder it) -> {
      it.setContext(this.getJavaClass());
      it.setMethodName("bar");
      it.setReturnType(this.createTypeRef(this.getJavaClass()));
      it.setVisibility(JvmVisibility.PUBLIC);
      it.setSynchronizedFlag(true);
    };
    AbstractMethodBuilder _doubleArrow = ObjectExtensions.<AbstractMethodBuilder>operator_doubleArrow(_createMethodBuilder, _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public synchronized Bar bar() {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append(AbstractBuilderTest.DEFAULT_BODY, "  ");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    this.assertBuilds(_doubleArrow, _builder.toString());
  }

  @Test
  public void testSetContextOnParameters() {
    AbstractMethodBuilder _createMethodBuilder = this._codeBuilderFactory.createMethodBuilder(this.getXtendClass());
    final Procedure1<AbstractMethodBuilder> _function = (AbstractMethodBuilder it) -> {
      final AbstractParameterBuilder builder = it.newParameterBuilder();
      Assert.assertNull(builder.getContext());
      it.setContext(this.getXtendClass());
      Assert.assertEquals(this.getXtendClass(), builder.getContext());
    };
    ObjectExtensions.<AbstractMethodBuilder>operator_doubleArrow(_createMethodBuilder, _function);
  }
}
