package org.eclipse.xtend.ide.tests.codebuilder;

import com.google.inject.Inject;
import java.util.Collections;
import org.eclipse.xtend.ide.codebuilder.AbstractConstructorBuilder;
import org.eclipse.xtend.ide.codebuilder.AbstractParameterBuilder;
import org.eclipse.xtend.ide.codebuilder.CodeBuilderFactory;
import org.eclipse.xtend.ide.tests.codebuilder.AbstractBuilderTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmDeclaredType;
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
    JvmDeclaredType _xtendClass = this.getXtendClass();
    AbstractConstructorBuilder _createConstructorBuilder = this._codeBuilderFactory.createConstructorBuilder(_xtendClass);
    final Procedure1<AbstractConstructorBuilder> _function = (AbstractConstructorBuilder it) -> {
      JvmDeclaredType _xtendClass_1 = this.getXtendClass();
      it.setContext(_xtendClass_1);
      it.setVisibility(JvmVisibility.PROTECTED);
      AbstractParameterBuilder _newParameterBuilder = it.newParameterBuilder();
      JvmDeclaredType _xtendClass_2 = this.getXtendClass();
      LightweightTypeReference _createTypeRef = this.createTypeRef(_xtendClass_2);
      _newParameterBuilder.setType(_createTypeRef);
      AbstractParameterBuilder _newParameterBuilder_1 = it.newParameterBuilder();
      JvmDeclaredType _xtendClass_3 = this.getXtendClass();
      LightweightTypeReference _createTypeRef_1 = this.createTypeRef(_xtendClass_3);
      _newParameterBuilder_1.setType(_createTypeRef_1);
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
    JvmDeclaredType _javaClass = this.getJavaClass();
    AbstractConstructorBuilder _createConstructorBuilder = this._codeBuilderFactory.createConstructorBuilder(_javaClass);
    final Procedure1<AbstractConstructorBuilder> _function = (AbstractConstructorBuilder it) -> {
      JvmDeclaredType _javaClass_1 = this.getJavaClass();
      it.setContext(_javaClass_1);
      it.setVisibility(JvmVisibility.PRIVATE);
      AbstractParameterBuilder _newParameterBuilder = it.newParameterBuilder();
      JvmDeclaredType _javaClass_2 = this.getJavaClass();
      LightweightTypeReference _createTypeRef = this.createTypeRef(_javaClass_2);
      _newParameterBuilder.setType(_createTypeRef);
      AbstractParameterBuilder _newParameterBuilder_1 = it.newParameterBuilder();
      JvmDeclaredType _javaClass_3 = this.getJavaClass();
      LightweightTypeReference _createTypeRef_1 = this.createTypeRef(_javaClass_3);
      _newParameterBuilder_1.setType(_createTypeRef_1);
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
    JvmDeclaredType _xtendClass = this.getXtendClass();
    AbstractConstructorBuilder _createConstructorBuilder = this._codeBuilderFactory.createConstructorBuilder(_xtendClass);
    final Procedure1<AbstractConstructorBuilder> _function = (AbstractConstructorBuilder it) -> {
      JvmDeclaredType _xtendClass_1 = this.getXtendClass();
      it.setContext(_xtendClass_1);
      it.setVisibility(JvmVisibility.PROTECTED);
      AbstractParameterBuilder _newParameterBuilder = it.newParameterBuilder();
      final Procedure1<AbstractParameterBuilder> _function_1 = (AbstractParameterBuilder it_1) -> {
        JvmDeclaredType _xtendClass_2 = this.getXtendClass();
        LightweightTypeReference _createTypeRef = this.createTypeRef(_xtendClass_2);
        it_1.setType(_createTypeRef);
        it_1.setName("bar");
      };
      ObjectExtensions.<AbstractParameterBuilder>operator_doubleArrow(_newParameterBuilder, _function_1);
      AbstractParameterBuilder _newParameterBuilder_1 = it.newParameterBuilder();
      final Procedure1<AbstractParameterBuilder> _function_2 = (AbstractParameterBuilder it_1) -> {
        JvmDeclaredType _javaClass = this.getJavaClass();
        LightweightTypeReference _createTypeRef = this.createTypeRef(_javaClass);
        it_1.setType(_createTypeRef);
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
    JvmDeclaredType _javaClass = this.getJavaClass();
    AbstractConstructorBuilder _createConstructorBuilder = this._codeBuilderFactory.createConstructorBuilder(_javaClass);
    final Procedure1<AbstractConstructorBuilder> _function = (AbstractConstructorBuilder it) -> {
      JvmDeclaredType _javaClass_1 = this.getJavaClass();
      it.setContext(_javaClass_1);
      it.setVisibility(JvmVisibility.PRIVATE);
      AbstractParameterBuilder _newParameterBuilder = it.newParameterBuilder();
      final Procedure1<AbstractParameterBuilder> _function_1 = (AbstractParameterBuilder it_1) -> {
        JvmDeclaredType _xtendClass = this.getXtendClass();
        LightweightTypeReference _createTypeRef = this.createTypeRef(_xtendClass);
        it_1.setType(_createTypeRef);
        it_1.setName("bar");
      };
      ObjectExtensions.<AbstractParameterBuilder>operator_doubleArrow(_newParameterBuilder, _function_1);
      AbstractParameterBuilder _newParameterBuilder_1 = it.newParameterBuilder();
      final Procedure1<AbstractParameterBuilder> _function_2 = (AbstractParameterBuilder it_1) -> {
        JvmDeclaredType _javaClass_2 = this.getJavaClass();
        LightweightTypeReference _createTypeRef = this.createTypeRef(_javaClass_2);
        it_1.setType(_createTypeRef);
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
    JvmDeclaredType _xtendClass = this.getXtendClass();
    AbstractConstructorBuilder _createConstructorBuilder = this._codeBuilderFactory.createConstructorBuilder(_xtendClass);
    final Procedure1<AbstractConstructorBuilder> _function = (AbstractConstructorBuilder it) -> {
      JvmDeclaredType _xtendClass_1 = this.getXtendClass();
      it.setContext(_xtendClass_1);
      JvmDeclaredType _xtendClass_2 = this.getXtendClass();
      LightweightTypeReference _createTypeRef = this.createTypeRef(Exception.class, _xtendClass_2);
      JvmDeclaredType _xtendClass_3 = this.getXtendClass();
      LightweightTypeReference _createTypeRef_1 = this.createTypeRef(RuntimeException.class, _xtendClass_3);
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
    JvmDeclaredType _javaClass = this.getJavaClass();
    AbstractConstructorBuilder _createConstructorBuilder = this._codeBuilderFactory.createConstructorBuilder(_javaClass);
    final Procedure1<AbstractConstructorBuilder> _function = (AbstractConstructorBuilder it) -> {
      JvmDeclaredType _javaClass_1 = this.getJavaClass();
      it.setContext(_javaClass_1);
      JvmDeclaredType _javaClass_2 = this.getJavaClass();
      LightweightTypeReference _createTypeRef = this.createTypeRef(Exception.class, _javaClass_2);
      JvmDeclaredType _javaClass_3 = this.getJavaClass();
      LightweightTypeReference _createTypeRef_1 = this.createTypeRef(RuntimeException.class, _javaClass_3);
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
    JvmDeclaredType _xtendClass = this.getXtendClass();
    AbstractConstructorBuilder _createConstructorBuilder = this._codeBuilderFactory.createConstructorBuilder(_xtendClass);
    final Procedure1<AbstractConstructorBuilder> _function = (AbstractConstructorBuilder it) -> {
      JvmDeclaredType _xtendClass_1 = this.getXtendClass();
      it.setContext(_xtendClass_1);
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
    JvmDeclaredType _javaClass = this.getJavaClass();
    AbstractConstructorBuilder _createConstructorBuilder = this._codeBuilderFactory.createConstructorBuilder(_javaClass);
    final Procedure1<AbstractConstructorBuilder> _function = (AbstractConstructorBuilder it) -> {
      JvmDeclaredType _javaClass_1 = this.getJavaClass();
      it.setContext(_javaClass_1);
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
