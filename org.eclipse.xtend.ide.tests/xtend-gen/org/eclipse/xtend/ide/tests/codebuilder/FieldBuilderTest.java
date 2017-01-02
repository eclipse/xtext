package org.eclipse.xtend.ide.tests.codebuilder;

import com.google.inject.Inject;
import org.eclipse.xtend.ide.codebuilder.AbstractFieldBuilder;
import org.eclipse.xtend.ide.codebuilder.CodeBuilderFactory;
import org.eclipse.xtend.ide.tests.codebuilder.AbstractBuilderTest;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;

@SuppressWarnings("all")
public class FieldBuilderTest extends AbstractBuilderTest {
  @Inject
  @Extension
  private CodeBuilderFactory _codeBuilderFactory;
  
  @Test
  public void testXtendField() {
    AbstractFieldBuilder _createFieldBuilder = this._codeBuilderFactory.createFieldBuilder(this.getXtendClass());
    final Procedure1<AbstractFieldBuilder> _function = (AbstractFieldBuilder it) -> {
      it.setContext(this.getXtendClass());
      it.setFieldName("foo");
      it.setFieldType(this.createTypeRef(this.getXtendClass()));
    };
    this.assertBuilds(ObjectExtensions.<AbstractFieldBuilder>operator_doubleArrow(_createFieldBuilder, _function), "Foo foo");
  }
  
  @Test
  public void testPublicXtendField() {
    AbstractFieldBuilder _createFieldBuilder = this._codeBuilderFactory.createFieldBuilder(this.getXtendClass());
    final Procedure1<AbstractFieldBuilder> _function = (AbstractFieldBuilder it) -> {
      it.setContext(this.getXtendClass());
      it.setFieldName("foo");
      it.setFieldType(this.createTypeRef(this.getXtendClass()));
      it.setVisibility(JvmVisibility.PUBLIC);
    };
    this.assertBuilds(ObjectExtensions.<AbstractFieldBuilder>operator_doubleArrow(_createFieldBuilder, _function), "public Foo foo");
  }
  
  @Test
  public void testStaticXtendField() {
    AbstractFieldBuilder _createFieldBuilder = this._codeBuilderFactory.createFieldBuilder(this.getXtendClass());
    final Procedure1<AbstractFieldBuilder> _function = (AbstractFieldBuilder it) -> {
      it.setContext(this.getXtendClass());
      it.setFieldName("foo");
      it.setFieldType(this.createTypeRef(this.getXtendClass()));
      it.setVisibility(JvmVisibility.PROTECTED);
      it.setStaticFlag(true);
    };
    this.assertBuilds(ObjectExtensions.<AbstractFieldBuilder>operator_doubleArrow(_createFieldBuilder, _function), "protected static Foo foo");
  }
  
  @Test
  public void testJavaField() {
    AbstractFieldBuilder _createFieldBuilder = this._codeBuilderFactory.createFieldBuilder(this.getJavaClass());
    final Procedure1<AbstractFieldBuilder> _function = (AbstractFieldBuilder it) -> {
      it.setContext(this.getJavaClass());
      it.setFieldName("bar");
      it.setFieldType(this.createTypeRef(this.getJavaClass()));
    };
    this.assertBuilds(ObjectExtensions.<AbstractFieldBuilder>operator_doubleArrow(_createFieldBuilder, _function), "Bar bar;");
  }
  
  @Test
  public void testPublicJavaField() {
    AbstractFieldBuilder _createFieldBuilder = this._codeBuilderFactory.createFieldBuilder(this.getJavaClass());
    final Procedure1<AbstractFieldBuilder> _function = (AbstractFieldBuilder it) -> {
      it.setContext(this.getJavaClass());
      it.setFieldName("bar");
      it.setFieldType(this.createTypeRef(this.getJavaClass()));
      it.setVisibility(JvmVisibility.PUBLIC);
    };
    this.assertBuilds(ObjectExtensions.<AbstractFieldBuilder>operator_doubleArrow(_createFieldBuilder, _function), "public Bar bar;");
  }
  
  @Test
  public void testStaticJavaField() {
    AbstractFieldBuilder _createFieldBuilder = this._codeBuilderFactory.createFieldBuilder(this.getJavaClass());
    final Procedure1<AbstractFieldBuilder> _function = (AbstractFieldBuilder it) -> {
      it.setContext(this.getJavaClass());
      it.setFieldName("bar");
      it.setFieldType(this.createTypeRef(this.getJavaClass()));
      it.setVisibility(JvmVisibility.PROTECTED);
      it.setStaticFlag(true);
    };
    this.assertBuilds(ObjectExtensions.<AbstractFieldBuilder>operator_doubleArrow(_createFieldBuilder, _function), "protected static Bar bar;");
  }
}
