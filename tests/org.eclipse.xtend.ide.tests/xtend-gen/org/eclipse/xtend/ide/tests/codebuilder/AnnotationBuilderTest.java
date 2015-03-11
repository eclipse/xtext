package org.eclipse.xtend.ide.tests.codebuilder;

import com.google.inject.Inject;
import org.eclipse.xtend.ide.codebuilder.AbstractAnnotationBuilder;
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
public class AnnotationBuilderTest extends AbstractBuilderTest {
  @Inject
  @Extension
  private CodeBuilderFactory _codeBuilderFactory;
  
  @Test
  public void testXtendAnnotation() {
    JvmDeclaredType _xtendClass = this.getXtendClass();
    AbstractAnnotationBuilder _createAnnotationBuilder = this._codeBuilderFactory.createAnnotationBuilder(_xtendClass);
    final Procedure1<AbstractAnnotationBuilder> _function = new Procedure1<AbstractAnnotationBuilder>() {
      @Override
      public void apply(final AbstractAnnotationBuilder it) {
        JvmDeclaredType _xtendClass = AnnotationBuilderTest.this.getXtendClass();
        it.setContext(_xtendClass);
        it.setAnnotationName("Bar");
        it.setVisibility(JvmVisibility.PUBLIC);
      }
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
    JvmDeclaredType _javaClass = this.getJavaClass();
    AbstractAnnotationBuilder _createAnnotationBuilder = this._codeBuilderFactory.createAnnotationBuilder(_javaClass);
    final Procedure1<AbstractAnnotationBuilder> _function = new Procedure1<AbstractAnnotationBuilder>() {
      @Override
      public void apply(final AbstractAnnotationBuilder it) {
        JvmDeclaredType _javaClass = AnnotationBuilderTest.this.getJavaClass();
        it.setContext(_javaClass);
        it.setAnnotationName("Bar");
        it.setVisibility(JvmVisibility.PUBLIC);
      }
    };
    AbstractAnnotationBuilder _doubleArrow = ObjectExtensions.<AbstractAnnotationBuilder>operator_doubleArrow(_createAnnotationBuilder, _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public @interface Bar {");
    _builder.newLine();
    _builder.append("}");
    this.assertBuilds(_doubleArrow, _builder.toString());
  }
}
