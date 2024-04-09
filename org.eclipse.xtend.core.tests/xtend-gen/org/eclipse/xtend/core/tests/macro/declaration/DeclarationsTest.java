/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.macro.declaration;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.lang.reflect.AccessibleObject;
import java.util.Collections;
import java.util.function.Consumer;
import org.eclipse.xtend.core.macro.ActiveAnnotationContexts;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.JvmAnnotationReferenceImpl;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.AnnotationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.AnnotationTypeElementDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.CompilationStrategy;
import org.eclipse.xtend.lib.macro.declaration.CompilationUnit;
import org.eclipse.xtend.lib.macro.declaration.ConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.InterfaceDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableInterfaceDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.declaration.Visibility;
import org.eclipse.xtend.lib.macro.services.AnnotationReferenceBuildContext;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge
 */
@SuppressWarnings("all")
public class DeclarationsTest extends AbstractXtendTestCase {
  @Inject
  private Provider<CompilationUnitImpl> compilationUnitProvider;

  @Test
  public void testAnnotation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@testdata.stubs.StubbedSuppressWarnings(\"unused\")");
    _builder.newLine();
    _builder.append("class MyClass {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@com.google.inject.Inject(optional=true) MyClass foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<CompilationUnitImpl> _function = (CompilationUnitImpl it) -> {
      Assert.assertNull(it.getPackageName());
      TypeDeclaration _head = IterableExtensions.head(it.getSourceTypeDeclarations());
      final ClassDeclaration clazz = ((ClassDeclaration) _head);
      Assert.assertEquals("MyClass", clazz.getQualifiedName());
      final AnnotationReference suppressWarning = IterableExtensions.head(clazz.getAnnotations());
      final AnnotationTypeDeclaration supressWarningsDeclaration = suppressWarning.getAnnotationTypeDeclaration();
      Assert.assertEquals("testdata.stubs.StubbedSuppressWarnings", supressWarningsDeclaration.getQualifiedName());
      Assert.assertEquals("unused", suppressWarning.getStringArrayValue("value")[0]);
      final Iterable<? extends AnnotationReference> annotations = supressWarningsDeclaration.getAnnotations();
      final Function1<AnnotationReference, AnnotationTypeDeclaration> _function_1 = (AnnotationReference it_1) -> {
        return it_1.getAnnotationTypeDeclaration();
      };
      Assert.assertEquals(IterableExtensions.map(annotations, _function_1).toString(), 
        2, IterableExtensions.size(annotations));
      final AnnotationTypeElementDeclaration valueProperty = IterableExtensions.<AnnotationTypeElementDeclaration>head(Iterables.<AnnotationTypeElementDeclaration>filter(supressWarningsDeclaration.getDeclaredMembers(), AnnotationTypeElementDeclaration.class));
      Assert.assertEquals("String[]", valueProperty.getType().toString());
      Assert.assertEquals("value", valueProperty.getSimpleName());
      MemberDeclaration _head_1 = IterableExtensions.head(clazz.getDeclaredMembers());
      final FieldDeclaration field = ((FieldDeclaration) _head_1);
      final AnnotationReference inject = IterableExtensions.head(field.getAnnotations());
      Object _value = inject.getValue("optional");
      Assert.assertTrue((((Boolean) _value)).booleanValue());
    };
    this.asCompilationUnit(this.validFile(_builder), _function);
  }

  @Test
  public void testAnnotation2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class MyClass {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@com.google.inject.Inject() MyClass foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<CompilationUnitImpl> _function = (CompilationUnitImpl it) -> {
      TypeDeclaration _head = IterableExtensions.head(it.getSourceTypeDeclarations());
      final ClassDeclaration sourceClazz = ((ClassDeclaration) _head);
      final MutableClassDeclaration javaClass = it.getTypeLookup().findClass("MyClass");
      Assert.assertEquals(javaClass.getQualifiedName(), sourceClazz.getQualifiedName());
      final FieldDeclaration field = IterableExtensions.head(sourceClazz.getDeclaredFields());
      Assert.assertEquals(Boolean.FALSE, IterableExtensions.head(field.getAnnotations()).getValue("optional"));
      final MutableFieldDeclaration javaField = IterableExtensions.head(javaClass.getDeclaredFields());
      Object _value = IterableExtensions.head(javaField.getAnnotations()).getValue("optional");
      Assert.assertFalse((((Boolean) _value)).booleanValue());
    };
    this.asCompilationUnit(this.validFile(_builder), _function);
  }

  @Test
  public void testAnnotation3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@test.Annotation");
    _builder.newLine();
    _builder.append("class MyClass {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@test.Annotation2 String foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<CompilationUnitImpl> _function = (CompilationUnitImpl it) -> {
      final AnnotationReference anno = IterableExtensions.head(it.getTypeLookup().findClass("MyClass").getAnnotations());
      final AnnotationReference anno2 = IterableExtensions.head(IterableExtensions.head(it.getTypeLookup().findClass("MyClass").getDeclaredFields()).getAnnotations());
      final Procedure1<AnnotationReferenceBuildContext> _function_1 = (AnnotationReferenceBuildContext it_1) -> {
        it_1.set("annotation2Value", anno2);
      };
      it.getTypeLookup().findClass("MyClass").addAnnotation(it.getAnnotationReferenceProvider().newAnnotationReference(anno, _function_1));
      it.getTypeLookup().findClass("MyClass").removeAnnotation(anno);
      Object _value = anno.getValue("annotation2Value");
      Assert.assertEquals(IterableExtensions.head(IterableExtensions.head(it.getTypeLookup().findClass("MyClass").getDeclaredFields()).getAnnotations()).getAnnotationTypeDeclaration(), ((AnnotationReference) _value).getAnnotationTypeDeclaration());
    };
    this.asCompilationUnit(this.validFile(_builder), _function);
  }

  /**
   * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=465007
   */
  @Test
  public void testAnnotation4() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class MyClass {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@test.Annotation2 String foo");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@test.Annotation2(\"hubble\") String foo2");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@test.Annotation2(value=\"hubble\") String foo3");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<CompilationUnitImpl> _function = (CompilationUnitImpl it) -> {
      final AnnotationReference anno = IterableExtensions.head(IterableExtensions.head(it.getTypeLookup().findClass("MyClass").getDeclaredFields()).getAnnotations());
      final AnnotationReference copied = it.getAnnotationReferenceProvider().newAnnotationReference(anno);
      Assert.assertTrue(((JvmAnnotationReferenceImpl) copied).getDelegate().getExplicitValues().isEmpty());
      final AnnotationReference anno2 = IterableExtensions.head((((MutableFieldDeclaration[])Conversions.unwrapArray(it.getTypeLookup().findClass("MyClass").getDeclaredFields(), MutableFieldDeclaration.class))[1]).getAnnotations());
      final AnnotationReference copied2 = it.getAnnotationReferenceProvider().newAnnotationReference(anno2);
      Assert.assertEquals(1, ((JvmAnnotationReferenceImpl) copied2).getDelegate().getExplicitValues().size());
      final AnnotationReference anno3 = IterableExtensions.head((((MutableFieldDeclaration[])Conversions.unwrapArray(it.getTypeLookup().findClass("MyClass").getDeclaredFields(), MutableFieldDeclaration.class))[2]).getAnnotations());
      final AnnotationReference copied3 = it.getAnnotationReferenceProvider().newAnnotationReference(anno3);
      Assert.assertEquals(1, ((JvmAnnotationReferenceImpl) copied3).getDelegate().getExplicitValues().size());
    };
    this.asCompilationUnit(this.validFile(_builder), _function);
  }

  @Test
  public void testSimpleClassWithField() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class MyClass extends Object implements java.io.Serializable {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("MyClass foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<CompilationUnitImpl> _function = (CompilationUnitImpl it) -> {
      Assert.assertEquals("foo", it.getPackageName());
      TypeDeclaration _head = IterableExtensions.head(it.getSourceTypeDeclarations());
      final ClassDeclaration clazz = ((ClassDeclaration) _head);
      Assert.assertEquals("foo.MyClass", clazz.getQualifiedName());
      Assert.assertEquals("Object", clazz.getExtendedClass().toString());
      Assert.assertEquals("Serializable", IterableExtensions.head(clazz.getImplementedInterfaces()).toString());
      MemberDeclaration _head_1 = IterableExtensions.head(clazz.getDeclaredMembers());
      final FieldDeclaration field = ((FieldDeclaration) _head_1);
      Assert.assertEquals("foo", field.getSimpleName());
      Assert.assertSame(it.getTypeLookup().findClass("foo.MyClass"), field.getType().getType());
    };
    this.asCompilationUnit(this.validFile(_builder), _function);
  }

  @Test
  public void testNestedClass() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package p");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Outer {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static class Inner {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<CompilationUnitImpl> _function = (CompilationUnitImpl it) -> {
      Assert.assertEquals("p", it.getPackageName());
      TypeDeclaration _head = IterableExtensions.head(it.getSourceTypeDeclarations());
      final ClassDeclaration outer = ((ClassDeclaration) _head);
      Assert.assertEquals("p.Outer", outer.getQualifiedName());
      final ClassDeclaration inner = IterableExtensions.head(outer.getDeclaredClasses());
      Assert.assertEquals("Inner", inner.getSimpleName());
      Assert.assertEquals("p.Outer.Inner", inner.getQualifiedName());
      Assert.assertNotNull(it.getTypeLookup().findClass("p.Outer.Inner"));
      Assert.assertNotNull(it.getTypeLookup().findTypeGlobally("p.Outer.Inner"));
    };
    this.asCompilationUnit(this.validFile(_builder), _function);
  }

  @Test
  public void testRemove() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<CompilationUnitImpl> _function = (CompilationUnitImpl it) -> {
      TypeDeclaration _head = IterableExtensions.head(it.getSourceTypeDeclarations());
      final ClassDeclaration c = ((ClassDeclaration) _head);
      final MutableClassDeclaration mutable = it.getTypeLookup().findClass(c.getQualifiedName());
      final Consumer<MutableMemberDeclaration> _function_1 = (MutableMemberDeclaration it_1) -> {
        it_1.remove();
      };
      mutable.getDeclaredMembers().forEach(_function_1);
      Assert.assertTrue(IterableExtensions.isEmpty(mutable.getDeclaredMembers()));
    };
    this.asCompilationUnit(this.validFile(_builder), _function);
  }

  @Test
  public void testXtendClassWithMethodFieldAndConstructor() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class MyClass<T extends CharSequence> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String myField");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(String initial) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.myField = initial");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <T2 extends CharSequence> MyClass myMethod(T2 a, T b) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("myField = myField + a + b");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return this");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<CompilationUnitImpl> _function = (CompilationUnitImpl it) -> {
      Assert.assertEquals("foo", it.getPackageName());
      TypeDeclaration _head = IterableExtensions.head(it.getSourceTypeDeclarations());
      final ClassDeclaration clazz = ((ClassDeclaration) _head);
      final MutableClassDeclaration genClazz = it.getTypeLookup().findClass("foo.MyClass");
      Assert.assertEquals("foo.MyClass", clazz.getQualifiedName());
      Assert.assertNull(clazz.getExtendedClass());
      Assert.assertTrue(IterableExtensions.isEmpty(clazz.getImplementedInterfaces()));
      Assert.assertEquals(3, IterableExtensions.size(clazz.getDeclaredMembers()));
      Assert.assertEquals("T", IterableExtensions.head(clazz.getTypeParameters()).getSimpleName());
      Assert.assertEquals("CharSequence", IterableExtensions.head(IterableExtensions.head(clazz.getTypeParameters()).getUpperBounds()).toString());
      Assert.assertSame(clazz, IterableExtensions.head(clazz.getTypeParameters()).getTypeParameterDeclarator());
      final FieldDeclaration field = IterableExtensions.head(clazz.getDeclaredFields());
      Assert.assertSame(clazz, field.getDeclaringType());
      Assert.assertEquals("myField", field.getSimpleName());
      Assert.assertEquals("String", field.getType().toString());
      Assert.assertFalse(field.isFinal());
      final ConstructorDeclaration constructor = IterableExtensions.head(clazz.getDeclaredConstructors());
      Assert.assertSame(clazz, constructor.getDeclaringType());
      Assert.assertEquals("MyClass", constructor.getSimpleName());
      Assert.assertEquals("initial", IterableExtensions.head(constructor.getParameters()).getSimpleName());
      Assert.assertEquals("String", IterableExtensions.head(constructor.getParameters()).getType().toString());
      final MethodDeclaration method = IterableExtensions.head(clazz.getDeclaredMethods());
      final MutableMethodDeclaration genMethod = IterableExtensions.head(genClazz.getDeclaredMethods());
      Assert.assertSame(clazz, method.getDeclaringType());
      Assert.assertEquals("a", IterableExtensions.head(method.getParameters()).getSimpleName());
      Assert.assertEquals("T2", IterableExtensions.head(method.getParameters()).getType().toString());
      Assert.assertSame(IterableExtensions.head(genMethod.getTypeParameters()), IterableExtensions.head(method.getParameters()).getType().getType());
      Assert.assertEquals("T", (((ParameterDeclaration[])Conversions.unwrapArray(method.getParameters(), ParameterDeclaration.class))[1]).getType().toString());
      Assert.assertSame(IterableExtensions.head(genClazz.getTypeParameters()), (((ParameterDeclaration[])Conversions.unwrapArray(method.getParameters(), ParameterDeclaration.class))[1]).getType().getType());
      Assert.assertSame(genClazz, method.getReturnType().getType());
      Assert.assertEquals("T2", IterableExtensions.head(method.getTypeParameters()).getSimpleName());
      Assert.assertEquals("CharSequence", IterableExtensions.head(IterableExtensions.head(method.getTypeParameters()).getUpperBounds()).toString());
      Assert.assertSame(IterableExtensions.head(method.getTypeParameters()), IterableExtensions.head(method.getTypeParameters()));
      Assert.assertSame(method, IterableExtensions.head(method.getTypeParameters()).getTypeParameterDeclarator());
      Assert.assertSame(field, ((Object[])Conversions.unwrapArray(clazz.getDeclaredMembers(), Object.class))[0]);
      Assert.assertSame(constructor, ((Object[])Conversions.unwrapArray(clazz.getDeclaredMembers(), Object.class))[1]);
      Assert.assertSame(method, ((Object[])Conversions.unwrapArray(clazz.getDeclaredMembers(), Object.class))[2]);
    };
    this.asCompilationUnit(this.validFile(_builder), _function);
  }

  @Test
  public void testOverriddenMethodFromSource() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package p");
    _builder.newLine();
    _builder.newLine();
    _builder.append("abstract class C extends java.util.AbstractList<String> implements I {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override add(String s);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface I {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def boolean add(String s)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<CompilationUnitImpl> _function = (CompilationUnitImpl it) -> {
      Assert.assertEquals("p", it.getPackageName());
      TypeDeclaration _head = IterableExtensions.head(it.getSourceTypeDeclarations());
      final ClassDeclaration clazz = ((ClassDeclaration) _head);
      Assert.assertEquals("p.C", clazz.getQualifiedName());
      final MethodDeclaration add = IterableExtensions.head(clazz.getDeclaredMethods());
      final Iterable<? extends MethodDeclaration> allOverridden = add.getOverriddenOrImplementedMethods();
      Assert.assertEquals(2, IterableExtensions.size(allOverridden));
      final MethodDeclaration listAdd = IterableExtensions.head(allOverridden);
      Assert.assertEquals("add", listAdd.getSimpleName());
      Assert.assertEquals("E", IterableExtensions.head(listAdd.getParameters()).getType().getSimpleName());
      final MethodDeclaration intfAdd = IterableExtensions.lastOrNull(allOverridden);
      Assert.assertEquals("add", intfAdd.getSimpleName());
      Assert.assertEquals("String", IterableExtensions.head(intfAdd.getParameters()).getType().getSimpleName());
    };
    this.asCompilationUnit(this.validFile(_builder), _function);
  }

  @Test
  public void testMutableClassDeclaration() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class MyClass<T extends CharSequence> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String myField");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(String initial) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.myField = initial");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <T2 extends CharSequence> MyClass myMethod(T2 a, T b) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("myField = myField + a + b");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return this");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<CompilationUnitImpl> _function = (CompilationUnitImpl it) -> {
      final MutableClassDeclaration genClazz = it.getTypeLookup().findClass("foo.MyClass");
      final Procedure1<MutableMethodDeclaration> _function_1 = (MutableMethodDeclaration it_1) -> {
        CompilationUnit _compilationUnit = genClazz.getCompilationUnit();
        it_1.setReturnType(((CompilationUnitImpl) _compilationUnit).getTypeReferenceProvider().getString());
        it_1.setVisibility(Visibility.PRIVATE);
        final CompilationStrategy _function_2 = (CompilationStrategy.CompilationContext it_2) -> {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("return \"foo\";");
          _builder_1.newLine();
          return _builder_1;
        };
        it_1.setBody(_function_2);
      };
      genClazz.addMethod("newMethod", _function_1);
      final MutableMethodDeclaration mutableMethod = genClazz.findDeclaredMethod("newMethod");
      Assert.assertSame(mutableMethod, ((Object[])Conversions.unwrapArray(genClazz.getDeclaredMethods(), Object.class))[1]);
      Assert.assertEquals("String", mutableMethod.getReturnType().toString());
      Assert.assertEquals(Visibility.PRIVATE, mutableMethod.getVisibility());
    };
    this.asCompilationUnit(this.validFile(_builder), _function);
  }

  @Test
  public void testMutableInterfaceDeclaration() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("interface MyInterface {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<CompilationUnitImpl> _function = (CompilationUnitImpl it) -> {
      final MutableInterfaceDeclaration genInterface = it.getTypeLookup().findInterface("foo.MyInterface");
      final Procedure1<MutableMethodDeclaration> _function_1 = (MutableMethodDeclaration it_1) -> {
      };
      final MutableMethodDeclaration m = genInterface.addMethod("newMethod", _function_1);
      Assert.assertTrue(m.isAbstract());
    };
    this.asCompilationUnit(this.validFile(_builder), _function);
  }

  @Test
  public void testTypeReferences() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class MyClass {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<CompilationUnitImpl> _function = (CompilationUnitImpl it) -> {
      final TypeReference anyType = it.getTypeReferenceProvider().getAnyType();
      Assert.assertTrue(anyType.isAnyType());
      final TypeReference stringType = it.getTypeReferenceProvider().getString();
      final TypeReference charsequenceType = it.getTypeReferenceProvider().newTypeReference(CharSequence.class.getName());
      Assert.assertTrue(charsequenceType.isAssignableFrom(stringType));
      Assert.assertTrue(stringType.isAssignableFrom(anyType));
      Assert.assertFalse(stringType.isAssignableFrom(charsequenceType));
      this.checkPrimitive(it.getTypeReferenceProvider().getPrimitiveBoolean(), "java.lang.Boolean");
      this.checkPrimitive(it.getTypeReferenceProvider().getPrimitiveInt(), "java.lang.Integer");
      this.checkPrimitive(it.getTypeReferenceProvider().getPrimitiveLong(), "java.lang.Long");
      this.checkPrimitive(it.getTypeReferenceProvider().getPrimitiveShort(), "java.lang.Short");
      this.checkPrimitive(it.getTypeReferenceProvider().getPrimitiveChar(), "java.lang.Character");
      this.checkPrimitive(it.getTypeReferenceProvider().getPrimitiveByte(), "java.lang.Byte");
      this.checkPrimitive(it.getTypeReferenceProvider().getPrimitiveFloat(), "java.lang.Float");
      this.checkPrimitive(it.getTypeReferenceProvider().getPrimitiveDouble(), "java.lang.Double");
      final TypeReference primitiveVoid = it.getTypeReferenceProvider().getPrimitiveVoid();
      Assert.assertTrue(primitiveVoid.isVoid());
      final TypeReference listOfStringType = it.getTypeReferenceProvider().getList(it.getTypeReferenceProvider().getString());
      final TypeReference setOfString = it.getTypeReferenceProvider().getSet(IterableExtensions.<TypeReference>head(listOfStringType.getActualTypeArguments()));
      Assert.assertEquals("List<String>", listOfStringType.toString());
      Assert.assertEquals("String", IterableExtensions.<TypeReference>head(listOfStringType.getActualTypeArguments()).toString());
      Assert.assertEquals("Set<String>", setOfString.toString());
      Assert.assertEquals("String", IterableExtensions.<TypeReference>head(setOfString.getActualTypeArguments()).toString());
      Assert.assertEquals("Set<?>", it.getTypeReferenceProvider().getSet(it.getTypeReferenceProvider().newWildcardTypeReference()).toString());
      Assert.assertEquals("Set<? extends List<String>>", it.getTypeReferenceProvider().getSet(it.getTypeReferenceProvider().newWildcardTypeReference(listOfStringType)).toString());
      Assert.assertEquals("Set<? super List<String>>", it.getTypeReferenceProvider().getSet(it.getTypeReferenceProvider().newWildcardTypeReferenceWithLowerBound(listOfStringType)).toString());
    };
    this.asCompilationUnit(this.validFile(_builder), _function);
  }

  @Test
  public void testIsAssignable() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class BaseClass implements InterfaceA {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class SubType extends BaseClass implements InterfaceA {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface InterfaceA {}");
    _builder.newLine();
    _builder.append("interface InterfaceB {}");
    _builder.newLine();
    final Procedure1<CompilationUnitImpl> _function = (CompilationUnitImpl it) -> {
      TypeDeclaration _get = ((TypeDeclaration[])Conversions.unwrapArray(it.getSourceTypeDeclarations(), TypeDeclaration.class))[0];
      final ClassDeclaration baseClass = ((ClassDeclaration) _get);
      final MutableClassDeclaration subClass = it.getTypeLookup().findClass("foo.SubType");
      TypeDeclaration _get_1 = ((TypeDeclaration[])Conversions.unwrapArray(it.getSourceTypeDeclarations(), TypeDeclaration.class))[2];
      final InterfaceDeclaration interfaceA = ((InterfaceDeclaration) _get_1);
      TypeDeclaration _get_2 = ((TypeDeclaration[])Conversions.unwrapArray(it.getSourceTypeDeclarations(), TypeDeclaration.class))[3];
      final InterfaceDeclaration interfaceB = ((InterfaceDeclaration) _get_2);
      final Type object = it.getTypeReferenceProvider().getObject().getType();
      Assert.assertTrue(object.isAssignableFrom(baseClass));
      Assert.assertTrue(object.isAssignableFrom(subClass));
      Assert.assertTrue(object.isAssignableFrom(interfaceA));
      Assert.assertTrue(object.isAssignableFrom(interfaceB));
      Assert.assertTrue(baseClass.isAssignableFrom(baseClass));
      Assert.assertTrue(baseClass.isAssignableFrom(subClass));
      Assert.assertFalse(baseClass.isAssignableFrom(interfaceB));
      Assert.assertFalse(baseClass.isAssignableFrom(interfaceA));
      Assert.assertFalse(baseClass.isAssignableFrom(object));
      Assert.assertTrue(interfaceA.isAssignableFrom(baseClass));
      Assert.assertTrue(interfaceA.isAssignableFrom(subClass));
      Assert.assertTrue(interfaceA.isAssignableFrom(interfaceA));
      Assert.assertFalse(interfaceA.isAssignableFrom(interfaceB));
      Assert.assertFalse(interfaceA.isAssignableFrom(object));
    };
    this.asCompilationUnit(this.validFile(_builder), _function);
  }

  @Test
  public void testSetImplementedInterfaces() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class BaseClass {}");
    _builder.newLine();
    _builder.append("interface Interface {}");
    _builder.newLine();
    final Procedure1<CompilationUnitImpl> _function = (CompilationUnitImpl it) -> {
      final MutableClassDeclaration baseClass = it.getTypeLookup().findClass("BaseClass");
      final MutableInterfaceDeclaration interf = it.getTypeLookup().findInterface("Interface");
      final TypeReference objectType = baseClass.getExtendedClass();
      Assert.assertEquals("Object", objectType.getSimpleName());
      Assert.assertTrue(IterableExtensions.isEmpty(baseClass.getImplementedInterfaces()));
      final TypeReference superType = it.getTypeReferenceProvider().newTypeReference(AccessibleObject.class);
      baseClass.setExtendedClass(superType);
      Assert.assertEquals("AccessibleObject", baseClass.getExtendedClass().getSimpleName());
      Assert.assertTrue(IterableExtensions.isEmpty(baseClass.getImplementedInterfaces()));
      baseClass.setExtendedClass(null);
      Assert.assertEquals("Object", baseClass.getExtendedClass().getSimpleName());
      Assert.assertTrue(IterableExtensions.isEmpty(baseClass.getImplementedInterfaces()));
      TypeReference _newTypeReference = it.getTypeReferenceProvider().newTypeReference(interf);
      baseClass.setImplementedInterfaces(Collections.<TypeReference>unmodifiableList(CollectionLiterals.<TypeReference>newArrayList(_newTypeReference)));
      Assert.assertEquals("Interface", IterableExtensions.head(baseClass.getImplementedInterfaces()).getSimpleName());
      baseClass.setImplementedInterfaces(Collections.<TypeReference>unmodifiableList(CollectionLiterals.<TypeReference>newArrayList()));
      Assert.assertTrue(IterableExtensions.isEmpty(baseClass.getImplementedInterfaces()));
    };
    this.asCompilationUnit(this.validFile(_builder), _function);
  }

  @Test
  public void testAnnotationReferenceValues() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.append("@test.Annotation(");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("intValue = 2 / 2 + 2 * 3 - 4 % 1,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("longValue = 42 + 4 + 6 * 42 - 4 / 45,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("stringValue = \'foo\' + \'baz\',");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("booleanArrayValue = #[true, false],");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("intArrayValue = #[ -1, 34 + 45, 2 - 6 ],");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("longArrayValue = #[42, 5 * -3],");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("stringArrayValue = #[\'foo\', \'bla\' + \'buzz\'],");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("typeValue = String,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("typeArrayValue = #[String, Integer],");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("annotation2Value = @test.Annotation2(\'foo\' + \'wuppa\'),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("annotation2ArrayValue = #[@test.Annotation2, @test.Annotation2(\'foo\'+\'wuppa\')]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(") class Bar {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<CompilationUnitImpl> _function = (CompilationUnitImpl it) -> {
      final MutableClassDeclaration baseClass = it.getTypeLookup().findClass("foo.Bar");
      final AnnotationReference annoRef = IterableExtensions.head(baseClass.getAnnotations());
      Assert.assertEquals(Integer.valueOf((((2 / 2) + (2 * 3)) - (4 % 1))), annoRef.getValue("intValue"));
      Assert.assertEquals(Integer.valueOf((((42 + 4) + (6 * 42)) - (4 / 45))), annoRef.getValue("longValue"));
      Assert.assertEquals("foobaz", annoRef.getValue("stringValue"));
      Object _value = annoRef.getValue("booleanArrayValue");
      final boolean[] bools = ((boolean[]) _value);
      Assert.assertTrue(bools[0]);
      Assert.assertFalse(bools[1]);
      Object _value_1 = annoRef.getValue("intArrayValue");
      Assert.assertArrayEquals(new int[] { (-1), (34 + 45), (2 - 6) }, ((int[]) _value_1));
      Object _value_2 = annoRef.getValue("typeArrayValue");
      final TypeReference[] type = ((TypeReference[]) _value_2);
      Assert.assertEquals(it.getTypeReferenceProvider().newTypeReference(Integer.class), type[1]);
      Object _value_3 = annoRef.getValue("annotation2Value");
      final AnnotationReference anno = ((AnnotationReference) _value_3);
      Assert.assertEquals("foowuppa", anno.getValue("value"));
      Object _value_4 = annoRef.getValue("annotation2ArrayValue");
      final AnnotationReference[] annoArray = ((AnnotationReference[]) _value_4);
      Assert.assertEquals("HUBBA BUBBA!", (annoArray[0]).getValue("value"));
    };
    this.asCompilationUnit(this.validFile(_builder), _function);
  }

  @Test
  public void testAnnotationReferenceValues_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.append("@test.Annotation(");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("intValue = 2 / 2 + 2 * 3 - 4 % 1,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("longValue = 42 + 4 + 6 * 42 - 4 / 45,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("stringValue = \'foo\' + \'baz\',");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("booleanArrayValue = #[true, false],");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("intArrayValue = #[ -1, 34 + 45, 2 - 6 ],");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("longArrayValue = #[42, 5 * -3],");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("stringArrayValue = #[\'foo\', \'bla\' + \'buzz\'],");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("typeValue = String,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("typeArrayValue = #[String, Integer],");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("annotation2Value = @test.Annotation2(\'foo\' + \'wuppa\'),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("annotation2ArrayValue = #[@test.Annotation2, @test.Annotation2(\'foo\'+\'wuppa\')]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(") class Bar {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<CompilationUnitImpl> _function = (CompilationUnitImpl it) -> {
      final MutableClassDeclaration baseClass = it.getTypeLookup().findClass("foo.Bar");
      final AnnotationReference annoRef = IterableExtensions.head(baseClass.getAnnotations());
      Assert.assertEquals((((2 / 2) + (2 * 3)) - (4 % 1)), annoRef.getIntValue("intValue"));
      Assert.assertEquals((((42 + 4) + (6 * 42)) - (4 / 45)), annoRef.getLongValue("longValue"));
      Assert.assertEquals("foobaz", annoRef.getStringValue("stringValue"));
      final boolean[] bools = annoRef.getBooleanArrayValue("booleanArrayValue");
      Assert.assertTrue(bools[0]);
      Assert.assertFalse(bools[1]);
      Assert.assertArrayEquals(new int[] { (-1), (34 + 45), (2 - 6) }, annoRef.getIntArrayValue("intArrayValue"));
      final TypeReference[] type = annoRef.getClassArrayValue("typeArrayValue");
      Assert.assertEquals(it.getTypeReferenceProvider().newTypeReference(Integer.class), type[1]);
      final AnnotationReference anno = annoRef.getAnnotationValue("annotation2Value");
      Assert.assertEquals("foowuppa", anno.getStringValue("value"));
      final AnnotationReference[] annoArray = annoRef.getAnnotationArrayValue("annotation2ArrayValue");
      Assert.assertEquals("HUBBA BUBBA!", (annoArray[0]).getValue("value"));
    };
    this.asCompilationUnit(this.validFile(_builder), _function);
  }

  public void checkPrimitive(final TypeReference primitiveType, final String wrapperTypeName) {
    Assert.assertTrue(primitiveType.toString(), primitiveType.isPrimitive());
    Assert.assertEquals(wrapperTypeName, primitiveType.getWrapperIfPrimitive().getType().getQualifiedName());
  }

  public XtendFile validFile(final CharSequence code) {
    try {
      return this.file(code.toString(), true);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  public void asCompilationUnit(final XtendFile file, final Procedure1<? super CompilationUnitImpl> block) {
    final CompilationUnitImpl compilationUnit = this.compilationUnitProvider.get();
    compilationUnit.setXtendFile(file);
    compilationUnit.before(ActiveAnnotationContexts.AnnotationCallback.INFERENCE);
    block.apply(compilationUnit);
  }
}
