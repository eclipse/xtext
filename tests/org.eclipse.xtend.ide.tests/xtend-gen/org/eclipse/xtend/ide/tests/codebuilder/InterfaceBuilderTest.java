package org.eclipse.xtend.ide.tests.codebuilder;

import com.google.inject.Inject;
import org.eclipse.xtend.ide.codebuilder.AbstractInterfaceBuilder;
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
public class InterfaceBuilderTest extends AbstractBuilderTest {
  @Inject
  @Extension
  private CodeBuilderFactory _codeBuilderFactory;
  
  @Test
  public void testXtendInterface() {
    JvmDeclaredType _xtendClass = this.getXtendClass();
    AbstractInterfaceBuilder _createInterfaceBuilder = this._codeBuilderFactory.createInterfaceBuilder(_xtendClass);
    final Procedure1<AbstractInterfaceBuilder> _function = new Procedure1<AbstractInterfaceBuilder>() {
      @Override
      public void apply(final AbstractInterfaceBuilder it) {
        JvmDeclaredType _xtendClass = InterfaceBuilderTest.this.getXtendClass();
        it.setContext(_xtendClass);
        it.setInterfaceName("Bar");
        it.setVisibility(JvmVisibility.PUBLIC);
      }
    };
    AbstractInterfaceBuilder _doubleArrow = ObjectExtensions.<AbstractInterfaceBuilder>operator_doubleArrow(_createInterfaceBuilder, _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("interface Bar {");
    _builder.newLine();
    _builder.append("}");
    this.assertBuilds(_doubleArrow, _builder.toString());
  }
  
  @Test
  public void testJavaClass() {
    JvmDeclaredType _javaClass = this.getJavaClass();
    AbstractInterfaceBuilder _createInterfaceBuilder = this._codeBuilderFactory.createInterfaceBuilder(_javaClass);
    final Procedure1<AbstractInterfaceBuilder> _function = new Procedure1<AbstractInterfaceBuilder>() {
      @Override
      public void apply(final AbstractInterfaceBuilder it) {
        JvmDeclaredType _javaClass = InterfaceBuilderTest.this.getJavaClass();
        it.setContext(_javaClass);
        it.setInterfaceName("Bar");
        it.setVisibility(JvmVisibility.PUBLIC);
      }
    };
    AbstractInterfaceBuilder _doubleArrow = ObjectExtensions.<AbstractInterfaceBuilder>operator_doubleArrow(_createInterfaceBuilder, _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public interface Bar {");
    _builder.newLine();
    _builder.append("}");
    this.assertBuilds(_doubleArrow, _builder.toString());
  }
}
