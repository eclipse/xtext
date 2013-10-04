package org.eclipse.xtend.core.tests.macro;

import com.google.common.base.Objects;
import java.io.Serializable;
import org.eclipse.xtend.core.compiler.batch.XtendCompilerTester.CompilationResult;
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
    final IAcceptor<CompilationResult> _function = new IAcceptor<CompilationResult>() {
      public void accept(final CompilationResult it) {
        final TransformationContext ctx = it.getTransformationContext();
        final MutableClassDeclaration classA = ctx.findClass("A");
        MutableMethodDeclaration _findDeclaredMethod = classA.findDeclaredMethod("getField");
        Assert.assertNotNull(_findDeclaredMethod);
        final MutableClassDeclaration classPA = ctx.findClass("PA");
        Iterable<TypeReference> _implementedInterfaces = classPA.getImplementedInterfaces();
        final Function1<TypeReference,Boolean> _function = new Function1<TypeReference,Boolean>() {
          public Boolean apply(final TypeReference it) {
            Type _type = it.getType();
            TypeReference _newTypeReference = ctx.newTypeReference(Serializable.class);
            Type _type_1 = _newTypeReference.getType();
            boolean _equals = Objects.equal(_type, _type_1);
            return Boolean.valueOf(_equals);
          }
        };
        TypeReference _findFirst = IterableExtensions.<TypeReference>findFirst(_implementedInterfaces, _function);
        Assert.assertNotNull(_findFirst);
        final MutableClassDeclaration classGA = ctx.findClass("GA");
        Iterable<TypeReference> _implementedInterfaces_1 = classGA.getImplementedInterfaces();
        final Function1<TypeReference,Boolean> _function_1 = new Function1<TypeReference,Boolean>() {
          public Boolean apply(final TypeReference it) {
            Type _type = it.getType();
            TypeReference _newTypeReference = ctx.newTypeReference(Serializable.class);
            Type _type_1 = _newTypeReference.getType();
            boolean _equals = Objects.equal(_type, _type_1);
            return Boolean.valueOf(_equals);
          }
        };
        TypeReference _findFirst_1 = IterableExtensions.<TypeReference>findFirst(_implementedInterfaces_1, _function_1);
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
    final IAcceptor<CompilationResult> _function = new IAcceptor<CompilationResult>() {
      public void accept(final CompilationResult it) {
        final TransformationContext ctx = it.getTransformationContext();
        final MutableClassDeclaration classA = ctx.findClass("my.pack.A");
        MutableMethodDeclaration _findDeclaredMethod = classA.findDeclaredMethod("getField");
        Assert.assertNotNull(_findDeclaredMethod);
        final MutableClassDeclaration classPA = ctx.findClass("my.pack.PA");
        Iterable<TypeReference> _implementedInterfaces = classPA.getImplementedInterfaces();
        final Function1<TypeReference,Boolean> _function = new Function1<TypeReference,Boolean>() {
          public Boolean apply(final TypeReference it) {
            Type _type = it.getType();
            TypeReference _newTypeReference = ctx.newTypeReference(Serializable.class);
            Type _type_1 = _newTypeReference.getType();
            boolean _equals = Objects.equal(_type, _type_1);
            return Boolean.valueOf(_equals);
          }
        };
        TypeReference _findFirst = IterableExtensions.<TypeReference>findFirst(_implementedInterfaces, _function);
        Assert.assertNotNull(_findFirst);
        final MutableClassDeclaration classGA = ctx.findClass("my.pack.GA");
        Iterable<TypeReference> _implementedInterfaces_1 = classGA.getImplementedInterfaces();
        final Function1<TypeReference,Boolean> _function_1 = new Function1<TypeReference,Boolean>() {
          public Boolean apply(final TypeReference it) {
            Type _type = it.getType();
            TypeReference _newTypeReference = ctx.newTypeReference(Serializable.class);
            Type _type_1 = _newTypeReference.getType();
            boolean _equals = Objects.equal(_type, _type_1);
            return Boolean.valueOf(_equals);
          }
        };
        TypeReference _findFirst_1 = IterableExtensions.<TypeReference>findFirst(_implementedInterfaces_1, _function_1);
        Assert.assertNotNull(_findFirst_1);
      }
    };
    this._xtendCompilerTester.compile(_builder, _function);
  }
}
