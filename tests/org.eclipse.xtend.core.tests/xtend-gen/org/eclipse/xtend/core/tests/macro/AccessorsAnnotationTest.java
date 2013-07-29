package org.eclipse.xtend.core.tests.macro;

import org.eclipse.xtend.core.compiler.batch.XtendCompilerTester.CompilationResult;
import org.eclipse.xtend.core.tests.macro.AbstractActiveAnnotationTest;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.declaration.Visibility;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class AccessorsAnnotationTest extends AbstractActiveAnnotationTest {
  @Test
  public void testProperty() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.eclipse.xtend.core.tests.macro.Accessors");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Accessors String field");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Accessors val String finalField = \'foo\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final IAcceptor<CompilationResult> _function = new IAcceptor<CompilationResult>() {
      public void accept(final CompilationResult it) {
        final TransformationContext ctx = it.getTransformationContext();
        final MutableClassDeclaration classA = ctx.findClass("A");
        MutableMethodDeclaration _findMethod = classA.findMethod("getField");
        Visibility _visibility = _findMethod.getVisibility();
        Assert.assertEquals(Visibility.PUBLIC, _visibility);
        TypeReference _string = ctx.getString();
        MutableMethodDeclaration _findMethod_1 = classA.findMethod("setField", _string);
        Visibility _visibility_1 = _findMethod_1.getVisibility();
        Assert.assertEquals(Visibility.PUBLIC, _visibility_1);
        MutableMethodDeclaration _findMethod_2 = classA.findMethod("getFinalField");
        Visibility _visibility_2 = _findMethod_2.getVisibility();
        Assert.assertEquals(Visibility.PUBLIC, _visibility_2);
        TypeReference _string_1 = ctx.getString();
        MutableMethodDeclaration _findMethod_3 = classA.findMethod("setFinalField", _string_1);
        Assert.assertNull(_findMethod_3);
      }
    };
    this._xtendCompilerTester.compile(_builder, _function);
  }
  
  @Test
  public void testProperty2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.eclipse.xtend.core.tests.macro.Accessors");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Accessors String field");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private def String getField() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return null");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} ");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final IAcceptor<CompilationResult> _function = new IAcceptor<CompilationResult>() {
      public void accept(final CompilationResult it) {
        final TransformationContext ctx = it.getTransformationContext();
        final MutableClassDeclaration classA = ctx.findClass("A");
        MutableMethodDeclaration _findMethod = classA.findMethod("getField");
        Visibility _visibility = _findMethod.getVisibility();
        Assert.assertEquals(Visibility.PRIVATE, _visibility);
        TypeReference _string = ctx.getString();
        MutableMethodDeclaration _findMethod_1 = classA.findMethod("setField", _string);
        Visibility _visibility_1 = _findMethod_1.getVisibility();
        Assert.assertEquals(Visibility.PUBLIC, _visibility_1);
        Iterable<? extends MutableMethodDeclaration> _declaredMethods = classA.getDeclaredMethods();
        int _size = IterableExtensions.size(_declaredMethods);
        Assert.assertEquals(2, _size);
      }
    };
    this._xtendCompilerTester.compile(_builder, _function);
  }
}
