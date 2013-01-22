package org.eclipse.xtend.ide.tests.codebuilder;

import com.google.inject.Inject;
import java.util.ArrayList;
import org.eclipse.xtend.ide.codebuilder.AbstractMethodBuilder;
import org.eclipse.xtend.ide.codebuilder.CodeBuilderFactory;
import org.eclipse.xtend.ide.tests.codebuilder.AbstractBuilderTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;

@SuppressWarnings("all")
public class MethodBuilderTest extends AbstractBuilderTest {
  @Inject
  private CodeBuilderFactory _codeBuilderFactory;
  
  @Inject
  private TypeReferences _typeReferences;
  
  @Test
  public void testXtendMethod() {
    JvmDeclaredType _xtendClass = this.getXtendClass();
    AbstractMethodBuilder _createMethodBuilder = this._codeBuilderFactory.createMethodBuilder(_xtendClass);
    final Procedure1<AbstractMethodBuilder> _function = new Procedure1<AbstractMethodBuilder>() {
        public void apply(final AbstractMethodBuilder it) {
          JvmDeclaredType _xtendClass = MethodBuilderTest.this.getXtendClass();
          it.setContext(_xtendClass);
          it.setMethodName("foo");
          JvmDeclaredType _xtendClass_1 = MethodBuilderTest.this.getXtendClass();
          JvmParameterizedTypeReference _createTypeRef = MethodBuilderTest.this._typeReferences.createTypeRef(_xtendClass_1);
          it.setReturnType(_createTypeRef);
          it.setVisibility(JvmVisibility.PUBLIC);
          JvmDeclaredType _xtendClass_2 = MethodBuilderTest.this.getXtendClass();
          JvmParameterizedTypeReference _createTypeRef_1 = MethodBuilderTest.this._typeReferences.createTypeRef(_xtendClass_2);
          JvmDeclaredType _xtendClass_3 = MethodBuilderTest.this.getXtendClass();
          JvmParameterizedTypeReference _createTypeRef_2 = MethodBuilderTest.this._typeReferences.createTypeRef(_xtendClass_3);
          ArrayList<JvmTypeReference> _newArrayList = CollectionLiterals.<JvmTypeReference>newArrayList(_createTypeRef_1, _createTypeRef_2);
          it.setParameterTypes(_newArrayList);
        }
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
    JvmDeclaredType _javaClass = this.getJavaClass();
    AbstractMethodBuilder _createMethodBuilder = this._codeBuilderFactory.createMethodBuilder(_javaClass);
    final Procedure1<AbstractMethodBuilder> _function = new Procedure1<AbstractMethodBuilder>() {
        public void apply(final AbstractMethodBuilder it) {
          JvmDeclaredType _javaClass = MethodBuilderTest.this.getJavaClass();
          it.setContext(_javaClass);
          it.setMethodName("bar");
          JvmDeclaredType _javaClass_1 = MethodBuilderTest.this.getJavaClass();
          JvmParameterizedTypeReference _createTypeRef = MethodBuilderTest.this._typeReferences.createTypeRef(_javaClass_1);
          it.setReturnType(_createTypeRef);
          it.setVisibility(JvmVisibility.PUBLIC);
          JvmDeclaredType _javaClass_2 = MethodBuilderTest.this.getJavaClass();
          JvmParameterizedTypeReference _createTypeRef_1 = MethodBuilderTest.this._typeReferences.createTypeRef(_javaClass_2);
          JvmDeclaredType _javaClass_3 = MethodBuilderTest.this.getJavaClass();
          JvmParameterizedTypeReference _createTypeRef_2 = MethodBuilderTest.this._typeReferences.createTypeRef(_javaClass_3);
          ArrayList<JvmTypeReference> _newArrayList = CollectionLiterals.<JvmTypeReference>newArrayList(_createTypeRef_1, _createTypeRef_2);
          it.setParameterTypes(_newArrayList);
        }
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
}
