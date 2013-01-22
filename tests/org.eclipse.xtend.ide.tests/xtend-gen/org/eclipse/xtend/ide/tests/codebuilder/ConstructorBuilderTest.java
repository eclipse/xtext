package org.eclipse.xtend.ide.tests.codebuilder;

import com.google.inject.Inject;
import java.util.ArrayList;
import org.eclipse.xtend.ide.codebuilder.AbstractConstructorBuilder;
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
public class ConstructorBuilderTest extends AbstractBuilderTest {
  @Inject
  private CodeBuilderFactory _codeBuilderFactory;
  
  @Inject
  private TypeReferences _typeReferences;
  
  @Test
  public void testXtendMethod() {
    JvmDeclaredType _xtendClass = this.getXtendClass();
    AbstractConstructorBuilder _createConstructorBuilder = this._codeBuilderFactory.createConstructorBuilder(_xtendClass);
    final Procedure1<AbstractConstructorBuilder> _function = new Procedure1<AbstractConstructorBuilder>() {
        public void apply(final AbstractConstructorBuilder it) {
          JvmDeclaredType _xtendClass = ConstructorBuilderTest.this.getXtendClass();
          it.setContext(_xtendClass);
          it.setVisibility(JvmVisibility.PROTECTED);
          JvmDeclaredType _xtendClass_1 = ConstructorBuilderTest.this.getXtendClass();
          JvmParameterizedTypeReference _createTypeRef = ConstructorBuilderTest.this._typeReferences.createTypeRef(_xtendClass_1);
          JvmDeclaredType _xtendClass_2 = ConstructorBuilderTest.this.getXtendClass();
          JvmParameterizedTypeReference _createTypeRef_1 = ConstructorBuilderTest.this._typeReferences.createTypeRef(_xtendClass_2);
          ArrayList<JvmTypeReference> _newArrayList = CollectionLiterals.<JvmTypeReference>newArrayList(_createTypeRef, _createTypeRef_1);
          it.setParameterTypes(_newArrayList);
        }
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
  public void testJavaMethod() {
    JvmDeclaredType _javaClass = this.getJavaClass();
    AbstractConstructorBuilder _createConstructorBuilder = this._codeBuilderFactory.createConstructorBuilder(_javaClass);
    final Procedure1<AbstractConstructorBuilder> _function = new Procedure1<AbstractConstructorBuilder>() {
        public void apply(final AbstractConstructorBuilder it) {
          JvmDeclaredType _javaClass = ConstructorBuilderTest.this.getJavaClass();
          it.setContext(_javaClass);
          it.setVisibility(JvmVisibility.PRIVATE);
          JvmDeclaredType _javaClass_1 = ConstructorBuilderTest.this.getJavaClass();
          JvmParameterizedTypeReference _createTypeRef = ConstructorBuilderTest.this._typeReferences.createTypeRef(_javaClass_1);
          JvmDeclaredType _javaClass_2 = ConstructorBuilderTest.this.getJavaClass();
          JvmParameterizedTypeReference _createTypeRef_1 = ConstructorBuilderTest.this._typeReferences.createTypeRef(_javaClass_2);
          ArrayList<JvmTypeReference> _newArrayList = CollectionLiterals.<JvmTypeReference>newArrayList(_createTypeRef, _createTypeRef_1);
          it.setParameterTypes(_newArrayList);
        }
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
}
