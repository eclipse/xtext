package org.eclipse.xtend.core.tests.macro;

import com.google.common.base.Objects;
import java.io.Serializable;
import org.eclipse.xtend.core.compiler.batch.XtendCompilerTester;
import org.eclipse.xtend.core.tests.macro.AbstractActiveAnnotationTest;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class AccessObjectProcessorTest extends AbstractActiveAnnotationTest {
  @Test
  public void testWithoutPackage() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.eclipse.xtend.core.tests.macro.Accessors");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@org.eclipse.xtend.core.tests.macro.AccessObjectAnn");
    _builder.newLine();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String field");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final IAcceptor<XtendCompilerTester.CompilationResult> _function = new IAcceptor<XtendCompilerTester.CompilationResult>() {
      public void accept(final XtendCompilerTester.CompilationResult it) {
        final TransformationContext ctx = it.getTransformationContext();
        final MutableClassDeclaration classA = ctx.findClass("A");
        MutableMethodDeclaration _findDeclaredMethod = classA.findDeclaredMethod("getField");
        Assert.assertNotNull(_findDeclaredMethod);
        final MutableClassDeclaration classPA = ctx.findClass("PA");
        Iterable<? extends TypeReference> _implementedInterfaces = classPA.getImplementedInterfaces();
        final Function1<TypeReference, Boolean> _function = new Function1<TypeReference, Boolean>() {
          public Boolean apply(final TypeReference it) {
            Type _type = it.getType();
            TypeReference _newTypeReference = ctx.newTypeReference(Serializable.class);
            Type _type_1 = _newTypeReference.getType();
            return Boolean.valueOf(Objects.equal(_type, _type_1));
          }
        };
        TypeReference _findFirst = IterableExtensions.findFirst(_implementedInterfaces, _function);
        Assert.assertNotNull(_findFirst);
        final MutableClassDeclaration classGA = ctx.findClass("GA");
        Iterable<? extends TypeReference> _implementedInterfaces_1 = classGA.getImplementedInterfaces();
        final Function1<TypeReference, Boolean> _function_1 = new Function1<TypeReference, Boolean>() {
          public Boolean apply(final TypeReference it) {
            Type _type = it.getType();
            TypeReference _newTypeReference = ctx.newTypeReference(Serializable.class);
            Type _type_1 = _newTypeReference.getType();
            return Boolean.valueOf(Objects.equal(_type, _type_1));
          }
        };
        TypeReference _findFirst_1 = IterableExtensions.findFirst(_implementedInterfaces_1, _function_1);
        Assert.assertNotNull(_findFirst_1);
      }
    };
    this._xtendCompilerTester.compile(_builder, _function);
  }
  
  @Test
  public void testWithPackage() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package my.pack");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.core.tests.macro.Accessors");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@org.eclipse.xtend.core.tests.macro.AccessObjectAnn");
    _builder.newLine();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String field");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final IAcceptor<XtendCompilerTester.CompilationResult> _function = new IAcceptor<XtendCompilerTester.CompilationResult>() {
      public void accept(final XtendCompilerTester.CompilationResult it) {
        final TransformationContext ctx = it.getTransformationContext();
        final MutableClassDeclaration classA = ctx.findClass("my.pack.A");
        MutableMethodDeclaration _findDeclaredMethod = classA.findDeclaredMethod("getField");
        Assert.assertNotNull(_findDeclaredMethod);
        final MutableClassDeclaration classPA = ctx.findClass("my.pack.PA");
        Iterable<? extends TypeReference> _implementedInterfaces = classPA.getImplementedInterfaces();
        final Function1<TypeReference, Boolean> _function = new Function1<TypeReference, Boolean>() {
          public Boolean apply(final TypeReference it) {
            Type _type = it.getType();
            TypeReference _newTypeReference = ctx.newTypeReference(Serializable.class);
            Type _type_1 = _newTypeReference.getType();
            return Boolean.valueOf(Objects.equal(_type, _type_1));
          }
        };
        TypeReference _findFirst = IterableExtensions.findFirst(_implementedInterfaces, _function);
        Assert.assertNotNull(_findFirst);
        final MutableClassDeclaration classGA = ctx.findClass("my.pack.GA");
        Iterable<? extends TypeReference> _implementedInterfaces_1 = classGA.getImplementedInterfaces();
        final Function1<TypeReference, Boolean> _function_1 = new Function1<TypeReference, Boolean>() {
          public Boolean apply(final TypeReference it) {
            Type _type = it.getType();
            TypeReference _newTypeReference = ctx.newTypeReference(Serializable.class);
            Type _type_1 = _newTypeReference.getType();
            return Boolean.valueOf(Objects.equal(_type, _type_1));
          }
        };
        TypeReference _findFirst_1 = IterableExtensions.findFirst(_implementedInterfaces_1, _function_1);
        Assert.assertNotNull(_findFirst_1);
      }
    };
    this._xtendCompilerTester.compile(_builder, _function);
  }
}
