package org.eclipse.xtend.ide.tests.codebuilder;

import com.google.inject.Inject;
import java.util.Collections;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.ide.codebuilder.AbstractMethodBuilder;
import org.eclipse.xtend.ide.codebuilder.AbstractParameterBuilder;
import org.eclipse.xtend.ide.codebuilder.CodeBuilderFactory;
import org.eclipse.xtend.ide.tests.codebuilder.AbstractBuilderTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmDeclaredType;
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
    JvmDeclaredType _xtendClass = this.getXtendClass();
    AbstractMethodBuilder _createMethodBuilder = this._codeBuilderFactory.createMethodBuilder(_xtendClass);
    final Procedure1<AbstractMethodBuilder> _function = (AbstractMethodBuilder it) -> {
      JvmDeclaredType _xtendClass_1 = this.getXtendClass();
      it.setContext(_xtendClass_1);
      it.setMethodName("foo");
      JvmDeclaredType _xtendClass_2 = this.getXtendClass();
      LightweightTypeReference _createTypeRef = this.createTypeRef(_xtendClass_2);
      it.setReturnType(_createTypeRef);
      it.setVisibility(JvmVisibility.PUBLIC);
      AbstractParameterBuilder _newParameterBuilder = it.newParameterBuilder();
      JvmDeclaredType _xtendClass_3 = this.getXtendClass();
      LightweightTypeReference _createTypeRef_1 = this.createTypeRef(_xtendClass_3);
      _newParameterBuilder.setType(_createTypeRef_1);
      AbstractParameterBuilder _newParameterBuilder_1 = it.newParameterBuilder();
      JvmDeclaredType _xtendClass_4 = this.getXtendClass();
      LightweightTypeReference _createTypeRef_2 = this.createTypeRef(_xtendClass_4);
      _newParameterBuilder_1.setType(_createTypeRef_2);
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
    final Procedure1<AbstractMethodBuilder> _function = (AbstractMethodBuilder it) -> {
      JvmDeclaredType _javaClass_1 = this.getJavaClass();
      it.setContext(_javaClass_1);
      it.setMethodName("bar");
      JvmDeclaredType _javaClass_2 = this.getJavaClass();
      LightweightTypeReference _createTypeRef = this.createTypeRef(_javaClass_2);
      it.setReturnType(_createTypeRef);
      it.setVisibility(JvmVisibility.PUBLIC);
      AbstractParameterBuilder _newParameterBuilder = it.newParameterBuilder();
      JvmDeclaredType _javaClass_3 = this.getJavaClass();
      LightweightTypeReference _createTypeRef_1 = this.createTypeRef(_javaClass_3);
      _newParameterBuilder.setType(_createTypeRef_1);
      AbstractParameterBuilder _newParameterBuilder_1 = it.newParameterBuilder();
      JvmDeclaredType _javaClass_4 = this.getJavaClass();
      LightweightTypeReference _createTypeRef_2 = this.createTypeRef(_javaClass_4);
      _newParameterBuilder_1.setType(_createTypeRef_2);
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
    JvmDeclaredType _xtendClass = this.getXtendClass();
    AbstractMethodBuilder _createMethodBuilder = this._codeBuilderFactory.createMethodBuilder(_xtendClass);
    final Procedure1<AbstractMethodBuilder> _function = (AbstractMethodBuilder it) -> {
      JvmDeclaredType _xtendClass_1 = this.getXtendClass();
      it.setContext(_xtendClass_1);
      it.setMethodName("foo");
      JvmDeclaredType _xtendClass_2 = this.getXtendClass();
      LightweightTypeReference _createTypeRef = this.createTypeRef(_xtendClass_2);
      it.setReturnType(_createTypeRef);
      it.setVisibility(JvmVisibility.PROTECTED);
      it.setStaticFlag(true);
      AbstractParameterBuilder _newParameterBuilder = it.newParameterBuilder();
      JvmDeclaredType _xtendClass_3 = this.getXtendClass();
      LightweightTypeReference _createTypeRef_1 = this.createTypeRef(_xtendClass_3);
      _newParameterBuilder.setType(_createTypeRef_1);
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
    JvmDeclaredType _javaClass = this.getJavaClass();
    AbstractMethodBuilder _createMethodBuilder = this._codeBuilderFactory.createMethodBuilder(_javaClass);
    final Procedure1<AbstractMethodBuilder> _function = (AbstractMethodBuilder it) -> {
      JvmDeclaredType _javaClass_1 = this.getJavaClass();
      it.setContext(_javaClass_1);
      it.setMethodName("bar");
      JvmDeclaredType _javaClass_2 = this.getJavaClass();
      LightweightTypeReference _createTypeRef = this.createTypeRef(_javaClass_2);
      it.setReturnType(_createTypeRef);
      it.setVisibility(JvmVisibility.PRIVATE);
      it.setStaticFlag(true);
      AbstractParameterBuilder _newParameterBuilder = it.newParameterBuilder();
      JvmDeclaredType _javaClass_3 = this.getJavaClass();
      LightweightTypeReference _createTypeRef_1 = this.createTypeRef(_javaClass_3);
      _newParameterBuilder.setType(_createTypeRef_1);
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
    JvmDeclaredType _xtendClass = this.getXtendClass();
    AbstractMethodBuilder _createMethodBuilder = this._codeBuilderFactory.createMethodBuilder(_xtendClass);
    final Procedure1<AbstractMethodBuilder> _function = (AbstractMethodBuilder it) -> {
      JvmDeclaredType _xtendClass_1 = this.getXtendClass();
      it.setContext(_xtendClass_1);
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
    JvmDeclaredType _javaClass = this.getJavaClass();
    AbstractMethodBuilder _createMethodBuilder = this._codeBuilderFactory.createMethodBuilder(_javaClass);
    final Procedure1<AbstractMethodBuilder> _function = (AbstractMethodBuilder it) -> {
      JvmDeclaredType _javaClass_1 = this.getJavaClass();
      it.setContext(_javaClass_1);
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
    JvmDeclaredType _xtendClass = this.getXtendClass();
    AbstractMethodBuilder _createMethodBuilder = this._codeBuilderFactory.createMethodBuilder(_xtendClass);
    final Procedure1<AbstractMethodBuilder> _function = (AbstractMethodBuilder it) -> {
      JvmDeclaredType _xtendClass_1 = this.getXtendClass();
      it.setContext(_xtendClass_1);
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
    JvmDeclaredType _javaClass = this.getJavaClass();
    AbstractMethodBuilder _createMethodBuilder = this._codeBuilderFactory.createMethodBuilder(_javaClass);
    final Procedure1<AbstractMethodBuilder> _function = (AbstractMethodBuilder it) -> {
      JvmDeclaredType _javaClass_1 = this.getJavaClass();
      it.setContext(_javaClass_1);
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
    JvmDeclaredType _xtendClass = this.getXtendClass();
    AbstractMethodBuilder _createMethodBuilder = this._codeBuilderFactory.createMethodBuilder(_xtendClass);
    final Procedure1<AbstractMethodBuilder> _function = (AbstractMethodBuilder it) -> {
      JvmDeclaredType _xtendClass_1 = this.getXtendClass();
      it.setContext(_xtendClass_1);
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
    JvmDeclaredType _javaClass = this.getJavaClass();
    AbstractMethodBuilder _createMethodBuilder = this._codeBuilderFactory.createMethodBuilder(_javaClass);
    final Procedure1<AbstractMethodBuilder> _function = (AbstractMethodBuilder it) -> {
      JvmDeclaredType _javaClass_1 = this.getJavaClass();
      it.setContext(_javaClass_1);
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
    JvmDeclaredType _xtendClass = this.getXtendClass();
    AbstractMethodBuilder _createMethodBuilder = this._codeBuilderFactory.createMethodBuilder(_xtendClass);
    final Procedure1<AbstractMethodBuilder> _function = (AbstractMethodBuilder it) -> {
      JvmDeclaredType _xtendClass_1 = this.getXtendClass();
      it.setContext(_xtendClass_1);
      it.setMethodName("foo");
      JvmDeclaredType _xtendClass_2 = this.getXtendClass();
      LightweightTypeReference _createTypeRef = this.createTypeRef(Exception.class, _xtendClass_2);
      JvmDeclaredType _xtendClass_3 = this.getXtendClass();
      LightweightTypeReference _createTypeRef_1 = this.createTypeRef(RuntimeException.class, _xtendClass_3);
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
    JvmDeclaredType _javaClass = this.getJavaClass();
    AbstractMethodBuilder _createMethodBuilder = this._codeBuilderFactory.createMethodBuilder(_javaClass);
    final Procedure1<AbstractMethodBuilder> _function = (AbstractMethodBuilder it) -> {
      JvmDeclaredType _javaClass_1 = this.getJavaClass();
      it.setContext(_javaClass_1);
      it.setMethodName("foo");
      JvmDeclaredType _javaClass_2 = this.getJavaClass();
      LightweightTypeReference _createTypeRef = this.createTypeRef(Exception.class, _javaClass_2);
      JvmDeclaredType _javaClass_3 = this.getJavaClass();
      LightweightTypeReference _createTypeRef_1 = this.createTypeRef(RuntimeException.class, _javaClass_3);
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
    JvmDeclaredType _xtendClass = this.getXtendClass();
    AbstractMethodBuilder _createMethodBuilder = this._codeBuilderFactory.createMethodBuilder(_xtendClass);
    final Procedure1<AbstractMethodBuilder> _function = (AbstractMethodBuilder it) -> {
      JvmDeclaredType _xtendClass_1 = this.getXtendClass();
      it.setContext(_xtendClass_1);
      it.setMethodName("foo");
      AbstractParameterBuilder _newParameterBuilder = it.newParameterBuilder();
      final Procedure1<AbstractParameterBuilder> _function_1 = (AbstractParameterBuilder it_1) -> {
        it_1.setName("bar");
        JvmDeclaredType _xtendClass_2 = this.getXtendClass();
        LightweightTypeReference _createTypeRef = this.createTypeRef(_xtendClass_2);
        it_1.setType(_createTypeRef);
      };
      ObjectExtensions.<AbstractParameterBuilder>operator_doubleArrow(_newParameterBuilder, _function_1);
      AbstractParameterBuilder _newParameterBuilder_1 = it.newParameterBuilder();
      final Procedure1<AbstractParameterBuilder> _function_2 = (AbstractParameterBuilder it_1) -> {
        it_1.setName("baz");
        JvmDeclaredType _xtendClass_2 = this.getXtendClass();
        LightweightTypeReference _createTypeRef = this.createTypeRef(_xtendClass_2);
        it_1.setType(_createTypeRef);
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
    JvmDeclaredType _javaClass = this.getJavaClass();
    AbstractMethodBuilder _createMethodBuilder = this._codeBuilderFactory.createMethodBuilder(_javaClass);
    final Procedure1<AbstractMethodBuilder> _function = (AbstractMethodBuilder it) -> {
      JvmDeclaredType _javaClass_1 = this.getJavaClass();
      it.setContext(_javaClass_1);
      it.setMethodName("foo");
      AbstractParameterBuilder _newParameterBuilder = it.newParameterBuilder();
      final Procedure1<AbstractParameterBuilder> _function_1 = (AbstractParameterBuilder it_1) -> {
        it_1.setName("bar");
        JvmDeclaredType _xtendClass = this.getXtendClass();
        LightweightTypeReference _createTypeRef = this.createTypeRef(_xtendClass);
        it_1.setType(_createTypeRef);
      };
      ObjectExtensions.<AbstractParameterBuilder>operator_doubleArrow(_newParameterBuilder, _function_1);
      AbstractParameterBuilder _newParameterBuilder_1 = it.newParameterBuilder();
      final Procedure1<AbstractParameterBuilder> _function_2 = (AbstractParameterBuilder it_1) -> {
        it_1.setName("baz");
        JvmDeclaredType _xtendClass = this.getXtendClass();
        LightweightTypeReference _createTypeRef = this.createTypeRef(_xtendClass);
        it_1.setType(_createTypeRef);
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
    JvmDeclaredType _xtendClass = this.getXtendClass();
    AbstractMethodBuilder _createMethodBuilder = this._codeBuilderFactory.createMethodBuilder(_xtendClass);
    final Procedure1<AbstractMethodBuilder> _function = (AbstractMethodBuilder it) -> {
      JvmDeclaredType _xtendClass_1 = this.getXtendClass();
      it.setContext(_xtendClass_1);
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
    JvmDeclaredType _javaClass = this.getJavaClass();
    AbstractMethodBuilder _createMethodBuilder = this._codeBuilderFactory.createMethodBuilder(_javaClass);
    final Procedure1<AbstractMethodBuilder> _function = (AbstractMethodBuilder it) -> {
      JvmDeclaredType _javaClass_1 = this.getJavaClass();
      it.setContext(_javaClass_1);
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
  public void testSetContextOnParameters() {
    JvmDeclaredType _xtendClass = this.getXtendClass();
    AbstractMethodBuilder _createMethodBuilder = this._codeBuilderFactory.createMethodBuilder(_xtendClass);
    final Procedure1<AbstractMethodBuilder> _function = (AbstractMethodBuilder it) -> {
      final AbstractParameterBuilder builder = it.newParameterBuilder();
      EObject _context = builder.getContext();
      Assert.assertNull(_context);
      JvmDeclaredType _xtendClass_1 = this.getXtendClass();
      it.setContext(_xtendClass_1);
      JvmDeclaredType _xtendClass_2 = this.getXtendClass();
      EObject _context_1 = builder.getContext();
      Assert.assertEquals(_xtendClass_2, _context_1);
    };
    ObjectExtensions.<AbstractMethodBuilder>operator_doubleArrow(_createMethodBuilder, _function);
  }
}
