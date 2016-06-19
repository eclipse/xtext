package org.eclipse.xtend.ide.tests.codebuilder;

import com.google.inject.Inject;
import org.eclipse.xtend.ide.codebuilder.AbstractFieldBuilder;
import org.eclipse.xtend.ide.codebuilder.CodeBuilderFactory;
import org.eclipse.xtend.ide.tests.codebuilder.AbstractBuilderTest;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Test;

@SuppressWarnings("all")
public class FieldBuilderTest extends AbstractBuilderTest {
  @Inject
  @Extension
  private CodeBuilderFactory _codeBuilderFactory;
  
  @Test
  public void testXtendField() {
    JvmDeclaredType _xtendClass = this.getXtendClass();
    AbstractFieldBuilder _createFieldBuilder = this._codeBuilderFactory.createFieldBuilder(_xtendClass);
    final Procedure1<AbstractFieldBuilder> _function = (AbstractFieldBuilder it) -> {
      JvmDeclaredType _xtendClass_1 = this.getXtendClass();
      it.setContext(_xtendClass_1);
      it.setFieldName("foo");
      JvmDeclaredType _xtendClass_2 = this.getXtendClass();
      LightweightTypeReference _createTypeRef = this.createTypeRef(_xtendClass_2);
      it.setFieldType(_createTypeRef);
    };
    AbstractFieldBuilder _doubleArrow = ObjectExtensions.<AbstractFieldBuilder>operator_doubleArrow(_createFieldBuilder, _function);
    this.assertBuilds(_doubleArrow, "Foo foo");
  }
  
  @Test
  public void testPublicXtendField() {
    JvmDeclaredType _xtendClass = this.getXtendClass();
    AbstractFieldBuilder _createFieldBuilder = this._codeBuilderFactory.createFieldBuilder(_xtendClass);
    final Procedure1<AbstractFieldBuilder> _function = (AbstractFieldBuilder it) -> {
      JvmDeclaredType _xtendClass_1 = this.getXtendClass();
      it.setContext(_xtendClass_1);
      it.setFieldName("foo");
      JvmDeclaredType _xtendClass_2 = this.getXtendClass();
      LightweightTypeReference _createTypeRef = this.createTypeRef(_xtendClass_2);
      it.setFieldType(_createTypeRef);
      it.setVisibility(JvmVisibility.PUBLIC);
    };
    AbstractFieldBuilder _doubleArrow = ObjectExtensions.<AbstractFieldBuilder>operator_doubleArrow(_createFieldBuilder, _function);
    this.assertBuilds(_doubleArrow, "public Foo foo");
  }
  
  @Test
  public void testStaticXtendField() {
    JvmDeclaredType _xtendClass = this.getXtendClass();
    AbstractFieldBuilder _createFieldBuilder = this._codeBuilderFactory.createFieldBuilder(_xtendClass);
    final Procedure1<AbstractFieldBuilder> _function = (AbstractFieldBuilder it) -> {
      JvmDeclaredType _xtendClass_1 = this.getXtendClass();
      it.setContext(_xtendClass_1);
      it.setFieldName("foo");
      JvmDeclaredType _xtendClass_2 = this.getXtendClass();
      LightweightTypeReference _createTypeRef = this.createTypeRef(_xtendClass_2);
      it.setFieldType(_createTypeRef);
      it.setVisibility(JvmVisibility.PROTECTED);
      it.setStaticFlag(true);
    };
    AbstractFieldBuilder _doubleArrow = ObjectExtensions.<AbstractFieldBuilder>operator_doubleArrow(_createFieldBuilder, _function);
    this.assertBuilds(_doubleArrow, "protected static Foo foo");
  }
  
  @Test
  public void testJavaField() {
    JvmDeclaredType _javaClass = this.getJavaClass();
    AbstractFieldBuilder _createFieldBuilder = this._codeBuilderFactory.createFieldBuilder(_javaClass);
    final Procedure1<AbstractFieldBuilder> _function = (AbstractFieldBuilder it) -> {
      JvmDeclaredType _javaClass_1 = this.getJavaClass();
      it.setContext(_javaClass_1);
      it.setFieldName("bar");
      JvmDeclaredType _javaClass_2 = this.getJavaClass();
      LightweightTypeReference _createTypeRef = this.createTypeRef(_javaClass_2);
      it.setFieldType(_createTypeRef);
    };
    AbstractFieldBuilder _doubleArrow = ObjectExtensions.<AbstractFieldBuilder>operator_doubleArrow(_createFieldBuilder, _function);
    this.assertBuilds(_doubleArrow, "Bar bar;");
  }
  
  @Test
  public void testPublicJavaField() {
    JvmDeclaredType _javaClass = this.getJavaClass();
    AbstractFieldBuilder _createFieldBuilder = this._codeBuilderFactory.createFieldBuilder(_javaClass);
    final Procedure1<AbstractFieldBuilder> _function = (AbstractFieldBuilder it) -> {
      JvmDeclaredType _javaClass_1 = this.getJavaClass();
      it.setContext(_javaClass_1);
      it.setFieldName("bar");
      JvmDeclaredType _javaClass_2 = this.getJavaClass();
      LightweightTypeReference _createTypeRef = this.createTypeRef(_javaClass_2);
      it.setFieldType(_createTypeRef);
      it.setVisibility(JvmVisibility.PUBLIC);
    };
    AbstractFieldBuilder _doubleArrow = ObjectExtensions.<AbstractFieldBuilder>operator_doubleArrow(_createFieldBuilder, _function);
    this.assertBuilds(_doubleArrow, "public Bar bar;");
  }
  
  @Test
  public void testStaticJavaField() {
    JvmDeclaredType _javaClass = this.getJavaClass();
    AbstractFieldBuilder _createFieldBuilder = this._codeBuilderFactory.createFieldBuilder(_javaClass);
    final Procedure1<AbstractFieldBuilder> _function = (AbstractFieldBuilder it) -> {
      JvmDeclaredType _javaClass_1 = this.getJavaClass();
      it.setContext(_javaClass_1);
      it.setFieldName("bar");
      JvmDeclaredType _javaClass_2 = this.getJavaClass();
      LightweightTypeReference _createTypeRef = this.createTypeRef(_javaClass_2);
      it.setFieldType(_createTypeRef);
      it.setVisibility(JvmVisibility.PROTECTED);
      it.setStaticFlag(true);
    };
    AbstractFieldBuilder _doubleArrow = ObjectExtensions.<AbstractFieldBuilder>operator_doubleArrow(_createFieldBuilder, _function);
    this.assertBuilds(_doubleArrow, "protected static Bar bar;");
  }
}
