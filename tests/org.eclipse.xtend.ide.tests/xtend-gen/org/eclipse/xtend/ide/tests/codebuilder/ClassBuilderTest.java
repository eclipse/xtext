package org.eclipse.xtend.ide.tests.codebuilder;

import com.google.inject.Inject;
import org.eclipse.xtend.ide.codebuilder.AbstractClassBuilder;
import org.eclipse.xtend.ide.codebuilder.CodeBuilderFactory;
import org.eclipse.xtend.ide.tests.codebuilder.AbstractBuilderTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmDeclaredType;
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
    JvmDeclaredType _xtendClass = this.getXtendClass();
    AbstractClassBuilder _createClassBuilder = this._codeBuilderFactory.createClassBuilder(_xtendClass);
    final Procedure1<AbstractClassBuilder> _function = new Procedure1<AbstractClassBuilder>() {
      @Override
      public void apply(final AbstractClassBuilder it) {
        JvmDeclaredType _xtendClass = ClassBuilderTest.this.getXtendClass();
        it.setContext(_xtendClass);
        it.setClassName("Bar");
        it.setVisibility(JvmVisibility.PUBLIC);
      }
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
    JvmDeclaredType _javaClass = this.getJavaClass();
    AbstractClassBuilder _createClassBuilder = this._codeBuilderFactory.createClassBuilder(_javaClass);
    final Procedure1<AbstractClassBuilder> _function = new Procedure1<AbstractClassBuilder>() {
      @Override
      public void apply(final AbstractClassBuilder it) {
        JvmDeclaredType _javaClass = ClassBuilderTest.this.getJavaClass();
        it.setContext(_javaClass);
        it.setClassName("Bar");
        it.setVisibility(JvmVisibility.PUBLIC);
      }
    };
    AbstractClassBuilder _doubleArrow = ObjectExtensions.<AbstractClassBuilder>operator_doubleArrow(_createClassBuilder, _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class Bar {");
    _builder.newLine();
    _builder.append("}");
    this.assertBuilds(_doubleArrow, _builder.toString());
  }
}
