/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.macro.declaration;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.lang.reflect.AccessibleObject;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.macro.ActiveAnnotationContexts;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.JvmAnnotationReferenceImpl;
import org.eclipse.xtend.core.macro.declaration.TypeLookupImpl;
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
import org.eclipse.xtend.lib.macro.declaration.MutableTypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclarator;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.declaration.Visibility;
import org.eclipse.xtend.lib.macro.services.AnnotationReferenceBuildContext;
import org.eclipse.xtend.lib.macro.services.AnnotationReferenceProvider;
import org.eclipse.xtend.lib.macro.services.TypeReferenceProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
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
    _builder.append("@SuppressWarnings(\"unused\")");
    _builder.newLine();
    _builder.append("class MyClass {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@com.google.inject.Inject(optional=true) MyClass foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    XtendFile _validFile = this.validFile(_builder);
    final Procedure1<CompilationUnitImpl> _function = new Procedure1<CompilationUnitImpl>() {
      @Override
      public void apply(final CompilationUnitImpl it) {
        String _packageName = it.getPackageName();
        Assert.assertNull(_packageName);
        Iterable<? extends TypeDeclaration> _sourceTypeDeclarations = it.getSourceTypeDeclarations();
        TypeDeclaration _head = IterableExtensions.head(_sourceTypeDeclarations);
        final ClassDeclaration clazz = ((ClassDeclaration) _head);
        String _qualifiedName = clazz.getQualifiedName();
        Assert.assertEquals("MyClass", _qualifiedName);
        Iterable<? extends AnnotationReference> _annotations = clazz.getAnnotations();
        final AnnotationReference suppressWarning = IterableExtensions.head(_annotations);
        final AnnotationTypeDeclaration supressWarningsDeclaration = suppressWarning.getAnnotationTypeDeclaration();
        String _qualifiedName_1 = supressWarningsDeclaration.getQualifiedName();
        Assert.assertEquals("java.lang.SuppressWarnings", _qualifiedName_1);
        String[] _stringArrayValue = suppressWarning.getStringArrayValue("value");
        Object _get = _stringArrayValue[0];
        Assert.assertEquals("unused", _get);
        Iterable<? extends AnnotationReference> _annotations_1 = supressWarningsDeclaration.getAnnotations();
        int _size = IterableExtensions.size(_annotations_1);
        Assert.assertEquals(2, _size);
        Iterable<? extends MemberDeclaration> _declaredMembers = supressWarningsDeclaration.getDeclaredMembers();
        Iterable<AnnotationTypeElementDeclaration> _filter = Iterables.<AnnotationTypeElementDeclaration>filter(_declaredMembers, AnnotationTypeElementDeclaration.class);
        final AnnotationTypeElementDeclaration valueProperty = IterableExtensions.<AnnotationTypeElementDeclaration>head(_filter);
        TypeReference _type = valueProperty.getType();
        String _string = _type.toString();
        Assert.assertEquals("String[]", _string);
        String _simpleName = valueProperty.getSimpleName();
        Assert.assertEquals("value", _simpleName);
        Iterable<? extends MemberDeclaration> _declaredMembers_1 = clazz.getDeclaredMembers();
        MemberDeclaration _head_1 = IterableExtensions.head(_declaredMembers_1);
        final FieldDeclaration field = ((FieldDeclaration) _head_1);
        Iterable<? extends AnnotationReference> _annotations_2 = field.getAnnotations();
        final AnnotationReference inject = IterableExtensions.head(_annotations_2);
        Object _value = inject.getValue("optional");
        Assert.assertTrue((((Boolean) _value)).booleanValue());
      }
    };
    this.asCompilationUnit(_validFile, _function);
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
    XtendFile _validFile = this.validFile(_builder);
    final Procedure1<CompilationUnitImpl> _function = new Procedure1<CompilationUnitImpl>() {
      @Override
      public void apply(final CompilationUnitImpl it) {
        Iterable<? extends TypeDeclaration> _sourceTypeDeclarations = it.getSourceTypeDeclarations();
        TypeDeclaration _head = IterableExtensions.head(_sourceTypeDeclarations);
        final ClassDeclaration sourceClazz = ((ClassDeclaration) _head);
        TypeLookupImpl _typeLookup = it.getTypeLookup();
        final MutableClassDeclaration javaClass = _typeLookup.findClass("MyClass");
        String _qualifiedName = javaClass.getQualifiedName();
        String _qualifiedName_1 = sourceClazz.getQualifiedName();
        Assert.assertEquals(_qualifiedName, _qualifiedName_1);
        Iterable<? extends FieldDeclaration> _declaredFields = sourceClazz.getDeclaredFields();
        final FieldDeclaration field = IterableExtensions.head(_declaredFields);
        Iterable<? extends AnnotationReference> _annotations = field.getAnnotations();
        AnnotationReference _head_1 = IterableExtensions.head(_annotations);
        Object _value = _head_1.getValue("optional");
        Assert.assertEquals(Boolean.FALSE, _value);
        Iterable<? extends MutableFieldDeclaration> _declaredFields_1 = javaClass.getDeclaredFields();
        final MutableFieldDeclaration javaField = IterableExtensions.head(_declaredFields_1);
        Iterable<? extends AnnotationReference> _annotations_1 = javaField.getAnnotations();
        AnnotationReference _head_2 = IterableExtensions.head(_annotations_1);
        Object _value_1 = _head_2.getValue("optional");
        Assert.assertFalse((((Boolean) _value_1)).booleanValue());
      }
    };
    this.asCompilationUnit(_validFile, _function);
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
    XtendFile _validFile = this.validFile(_builder);
    final Procedure1<CompilationUnitImpl> _function = new Procedure1<CompilationUnitImpl>() {
      @Override
      public void apply(final CompilationUnitImpl it) {
        TypeLookupImpl _typeLookup = it.getTypeLookup();
        MutableClassDeclaration _findClass = _typeLookup.findClass("MyClass");
        Iterable<? extends AnnotationReference> _annotations = _findClass.getAnnotations();
        final AnnotationReference anno = IterableExtensions.head(_annotations);
        TypeLookupImpl _typeLookup_1 = it.getTypeLookup();
        MutableClassDeclaration _findClass_1 = _typeLookup_1.findClass("MyClass");
        Iterable<? extends MutableFieldDeclaration> _declaredFields = _findClass_1.getDeclaredFields();
        MutableFieldDeclaration _head = IterableExtensions.head(_declaredFields);
        Iterable<? extends AnnotationReference> _annotations_1 = _head.getAnnotations();
        final AnnotationReference anno2 = IterableExtensions.head(_annotations_1);
        TypeLookupImpl _typeLookup_2 = it.getTypeLookup();
        MutableClassDeclaration _findClass_2 = _typeLookup_2.findClass("MyClass");
        AnnotationReferenceProvider _annotationReferenceProvider = it.getAnnotationReferenceProvider();
        final Procedure1<AnnotationReferenceBuildContext> _function = new Procedure1<AnnotationReferenceBuildContext>() {
          @Override
          public void apply(final AnnotationReferenceBuildContext it) {
            it.set("annotation2Value", anno2);
          }
        };
        AnnotationReference _newAnnotationReference = _annotationReferenceProvider.newAnnotationReference(anno, _function);
        _findClass_2.addAnnotation(_newAnnotationReference);
        TypeLookupImpl _typeLookup_3 = it.getTypeLookup();
        MutableClassDeclaration _findClass_3 = _typeLookup_3.findClass("MyClass");
        _findClass_3.removeAnnotation(anno);
        TypeLookupImpl _typeLookup_4 = it.getTypeLookup();
        MutableClassDeclaration _findClass_4 = _typeLookup_4.findClass("MyClass");
        Iterable<? extends MutableFieldDeclaration> _declaredFields_1 = _findClass_4.getDeclaredFields();
        MutableFieldDeclaration _head_1 = IterableExtensions.head(_declaredFields_1);
        Iterable<? extends AnnotationReference> _annotations_2 = _head_1.getAnnotations();
        AnnotationReference _head_2 = IterableExtensions.head(_annotations_2);
        AnnotationTypeDeclaration _annotationTypeDeclaration = _head_2.getAnnotationTypeDeclaration();
        Object _value = anno.getValue("annotation2Value");
        AnnotationTypeDeclaration _annotationTypeDeclaration_1 = ((AnnotationReference) _value).getAnnotationTypeDeclaration();
        Assert.assertEquals(_annotationTypeDeclaration, _annotationTypeDeclaration_1);
      }
    };
    this.asCompilationUnit(_validFile, _function);
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
    XtendFile _validFile = this.validFile(_builder);
    final Procedure1<CompilationUnitImpl> _function = new Procedure1<CompilationUnitImpl>() {
      @Override
      public void apply(final CompilationUnitImpl it) {
        TypeLookupImpl _typeLookup = it.getTypeLookup();
        MutableClassDeclaration _findClass = _typeLookup.findClass("MyClass");
        Iterable<? extends MutableFieldDeclaration> _declaredFields = _findClass.getDeclaredFields();
        MutableFieldDeclaration _head = IterableExtensions.head(_declaredFields);
        Iterable<? extends AnnotationReference> _annotations = _head.getAnnotations();
        final AnnotationReference anno = IterableExtensions.head(_annotations);
        AnnotationReferenceProvider _annotationReferenceProvider = it.getAnnotationReferenceProvider();
        final AnnotationReference copied = _annotationReferenceProvider.newAnnotationReference(anno);
        JvmAnnotationReference _delegate = ((JvmAnnotationReferenceImpl) copied).getDelegate();
        EList<JvmAnnotationValue> _explicitValues = _delegate.getExplicitValues();
        boolean _isEmpty = _explicitValues.isEmpty();
        Assert.assertTrue(_isEmpty);
        TypeLookupImpl _typeLookup_1 = it.getTypeLookup();
        MutableClassDeclaration _findClass_1 = _typeLookup_1.findClass("MyClass");
        Iterable<? extends MutableFieldDeclaration> _declaredFields_1 = _findClass_1.getDeclaredFields();
        MutableFieldDeclaration _get = ((MutableFieldDeclaration[])Conversions.unwrapArray(_declaredFields_1, MutableFieldDeclaration.class))[1];
        Iterable<? extends AnnotationReference> _annotations_1 = _get.getAnnotations();
        final AnnotationReference anno2 = IterableExtensions.head(_annotations_1);
        AnnotationReferenceProvider _annotationReferenceProvider_1 = it.getAnnotationReferenceProvider();
        final AnnotationReference copied2 = _annotationReferenceProvider_1.newAnnotationReference(anno2);
        JvmAnnotationReference _delegate_1 = ((JvmAnnotationReferenceImpl) copied2).getDelegate();
        EList<JvmAnnotationValue> _explicitValues_1 = _delegate_1.getExplicitValues();
        int _size = _explicitValues_1.size();
        Assert.assertEquals(1, _size);
        TypeLookupImpl _typeLookup_2 = it.getTypeLookup();
        MutableClassDeclaration _findClass_2 = _typeLookup_2.findClass("MyClass");
        Iterable<? extends MutableFieldDeclaration> _declaredFields_2 = _findClass_2.getDeclaredFields();
        MutableFieldDeclaration _get_1 = ((MutableFieldDeclaration[])Conversions.unwrapArray(_declaredFields_2, MutableFieldDeclaration.class))[2];
        Iterable<? extends AnnotationReference> _annotations_2 = _get_1.getAnnotations();
        final AnnotationReference anno3 = IterableExtensions.head(_annotations_2);
        AnnotationReferenceProvider _annotationReferenceProvider_2 = it.getAnnotationReferenceProvider();
        final AnnotationReference copied3 = _annotationReferenceProvider_2.newAnnotationReference(anno3);
        JvmAnnotationReference _delegate_2 = ((JvmAnnotationReferenceImpl) copied3).getDelegate();
        EList<JvmAnnotationValue> _explicitValues_2 = _delegate_2.getExplicitValues();
        int _size_1 = _explicitValues_2.size();
        Assert.assertEquals(1, _size_1);
      }
    };
    this.asCompilationUnit(_validFile, _function);
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
    XtendFile _validFile = this.validFile(_builder);
    final Procedure1<CompilationUnitImpl> _function = new Procedure1<CompilationUnitImpl>() {
      @Override
      public void apply(final CompilationUnitImpl it) {
        String _packageName = it.getPackageName();
        Assert.assertEquals("foo", _packageName);
        Iterable<? extends TypeDeclaration> _sourceTypeDeclarations = it.getSourceTypeDeclarations();
        TypeDeclaration _head = IterableExtensions.head(_sourceTypeDeclarations);
        final ClassDeclaration clazz = ((ClassDeclaration) _head);
        String _qualifiedName = clazz.getQualifiedName();
        Assert.assertEquals("foo.MyClass", _qualifiedName);
        TypeReference _extendedClass = clazz.getExtendedClass();
        String _string = _extendedClass.toString();
        Assert.assertEquals("Object", _string);
        Iterable<? extends TypeReference> _implementedInterfaces = clazz.getImplementedInterfaces();
        TypeReference _head_1 = IterableExtensions.head(_implementedInterfaces);
        String _string_1 = _head_1.toString();
        Assert.assertEquals("Serializable", _string_1);
        Iterable<? extends MemberDeclaration> _declaredMembers = clazz.getDeclaredMembers();
        MemberDeclaration _head_2 = IterableExtensions.head(_declaredMembers);
        final FieldDeclaration field = ((FieldDeclaration) _head_2);
        String _simpleName = field.getSimpleName();
        Assert.assertEquals("foo", _simpleName);
        TypeLookupImpl _typeLookup = it.getTypeLookup();
        MutableClassDeclaration _findClass = _typeLookup.findClass("foo.MyClass");
        TypeReference _type = field.getType();
        Type _type_1 = _type.getType();
        Assert.assertSame(_findClass, _type_1);
      }
    };
    this.asCompilationUnit(_validFile, _function);
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
    XtendFile _validFile = this.validFile(_builder);
    final Procedure1<CompilationUnitImpl> _function = new Procedure1<CompilationUnitImpl>() {
      @Override
      public void apply(final CompilationUnitImpl it) {
        String _packageName = it.getPackageName();
        Assert.assertEquals("p", _packageName);
        Iterable<? extends TypeDeclaration> _sourceTypeDeclarations = it.getSourceTypeDeclarations();
        TypeDeclaration _head = IterableExtensions.head(_sourceTypeDeclarations);
        final ClassDeclaration outer = ((ClassDeclaration) _head);
        String _qualifiedName = outer.getQualifiedName();
        Assert.assertEquals("p.Outer", _qualifiedName);
        Iterable<? extends ClassDeclaration> _declaredClasses = outer.getDeclaredClasses();
        final ClassDeclaration inner = IterableExtensions.head(_declaredClasses);
        String _simpleName = inner.getSimpleName();
        Assert.assertEquals("Inner", _simpleName);
        String _qualifiedName_1 = inner.getQualifiedName();
        Assert.assertEquals("p.Outer.Inner", _qualifiedName_1);
        TypeLookupImpl _typeLookup = it.getTypeLookup();
        MutableClassDeclaration _findClass = _typeLookup.findClass("p.Outer.Inner");
        Assert.assertNotNull(_findClass);
        TypeLookupImpl _typeLookup_1 = it.getTypeLookup();
        Type _findTypeGlobally = _typeLookup_1.findTypeGlobally("p.Outer.Inner");
        Assert.assertNotNull(_findTypeGlobally);
      }
    };
    this.asCompilationUnit(_validFile, _function);
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
    XtendFile _validFile = this.validFile(_builder);
    final Procedure1<CompilationUnitImpl> _function = new Procedure1<CompilationUnitImpl>() {
      @Override
      public void apply(final CompilationUnitImpl it) {
        Iterable<? extends TypeDeclaration> _sourceTypeDeclarations = it.getSourceTypeDeclarations();
        TypeDeclaration _head = IterableExtensions.head(_sourceTypeDeclarations);
        final ClassDeclaration c = ((ClassDeclaration) _head);
        TypeLookupImpl _typeLookup = it.getTypeLookup();
        String _qualifiedName = c.getQualifiedName();
        final MutableClassDeclaration mutable = _typeLookup.findClass(_qualifiedName);
        Iterable<? extends MutableMemberDeclaration> _declaredMembers = mutable.getDeclaredMembers();
        for (final MutableMemberDeclaration it_1 : _declaredMembers) {
          it_1.remove();
        }
        Iterable<? extends MutableMemberDeclaration> _declaredMembers_1 = mutable.getDeclaredMembers();
        boolean _isEmpty = IterableExtensions.isEmpty(_declaredMembers_1);
        Assert.assertTrue(_isEmpty);
      }
    };
    this.asCompilationUnit(_validFile, _function);
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
    XtendFile _validFile = this.validFile(_builder);
    final Procedure1<CompilationUnitImpl> _function = new Procedure1<CompilationUnitImpl>() {
      @Override
      public void apply(final CompilationUnitImpl it) {
        String _packageName = it.getPackageName();
        Assert.assertEquals("foo", _packageName);
        Iterable<? extends TypeDeclaration> _sourceTypeDeclarations = it.getSourceTypeDeclarations();
        TypeDeclaration _head = IterableExtensions.head(_sourceTypeDeclarations);
        final ClassDeclaration clazz = ((ClassDeclaration) _head);
        TypeLookupImpl _typeLookup = it.getTypeLookup();
        final MutableClassDeclaration genClazz = _typeLookup.findClass("foo.MyClass");
        String _qualifiedName = clazz.getQualifiedName();
        Assert.assertEquals("foo.MyClass", _qualifiedName);
        TypeReference _extendedClass = clazz.getExtendedClass();
        Assert.assertNull(_extendedClass);
        Iterable<? extends TypeReference> _implementedInterfaces = clazz.getImplementedInterfaces();
        boolean _isEmpty = IterableExtensions.isEmpty(_implementedInterfaces);
        Assert.assertTrue(_isEmpty);
        Iterable<? extends MemberDeclaration> _declaredMembers = clazz.getDeclaredMembers();
        int _size = IterableExtensions.size(_declaredMembers);
        Assert.assertEquals(3, _size);
        Iterable<? extends TypeParameterDeclaration> _typeParameters = clazz.getTypeParameters();
        TypeParameterDeclaration _head_1 = IterableExtensions.head(_typeParameters);
        String _simpleName = _head_1.getSimpleName();
        Assert.assertEquals("T", _simpleName);
        Iterable<? extends TypeParameterDeclaration> _typeParameters_1 = clazz.getTypeParameters();
        TypeParameterDeclaration _head_2 = IterableExtensions.head(_typeParameters_1);
        Iterable<? extends TypeReference> _upperBounds = _head_2.getUpperBounds();
        TypeReference _head_3 = IterableExtensions.head(_upperBounds);
        String _string = _head_3.toString();
        Assert.assertEquals("CharSequence", _string);
        Iterable<? extends TypeParameterDeclaration> _typeParameters_2 = clazz.getTypeParameters();
        TypeParameterDeclaration _head_4 = IterableExtensions.head(_typeParameters_2);
        TypeParameterDeclarator _typeParameterDeclarator = _head_4.getTypeParameterDeclarator();
        Assert.assertSame(clazz, _typeParameterDeclarator);
        Iterable<? extends FieldDeclaration> _declaredFields = clazz.getDeclaredFields();
        final FieldDeclaration field = IterableExtensions.head(_declaredFields);
        TypeDeclaration _declaringType = field.getDeclaringType();
        Assert.assertSame(clazz, _declaringType);
        String _simpleName_1 = field.getSimpleName();
        Assert.assertEquals("myField", _simpleName_1);
        TypeReference _type = field.getType();
        String _string_1 = _type.toString();
        Assert.assertEquals("String", _string_1);
        boolean _isFinal = field.isFinal();
        Assert.assertFalse(_isFinal);
        Iterable<? extends ConstructorDeclaration> _declaredConstructors = clazz.getDeclaredConstructors();
        final ConstructorDeclaration constructor = IterableExtensions.head(_declaredConstructors);
        TypeDeclaration _declaringType_1 = constructor.getDeclaringType();
        Assert.assertSame(clazz, _declaringType_1);
        String _simpleName_2 = constructor.getSimpleName();
        Assert.assertEquals("MyClass", _simpleName_2);
        Iterable<? extends ParameterDeclaration> _parameters = constructor.getParameters();
        ParameterDeclaration _head_5 = IterableExtensions.head(_parameters);
        String _simpleName_3 = _head_5.getSimpleName();
        Assert.assertEquals("initial", _simpleName_3);
        Iterable<? extends ParameterDeclaration> _parameters_1 = constructor.getParameters();
        ParameterDeclaration _head_6 = IterableExtensions.head(_parameters_1);
        TypeReference _type_1 = _head_6.getType();
        String _string_2 = _type_1.toString();
        Assert.assertEquals("String", _string_2);
        Iterable<? extends MethodDeclaration> _declaredMethods = clazz.getDeclaredMethods();
        final MethodDeclaration method = IterableExtensions.head(_declaredMethods);
        Iterable<? extends MutableMethodDeclaration> _declaredMethods_1 = genClazz.getDeclaredMethods();
        final MutableMethodDeclaration genMethod = IterableExtensions.head(_declaredMethods_1);
        TypeDeclaration _declaringType_2 = method.getDeclaringType();
        Assert.assertSame(clazz, _declaringType_2);
        Iterable<? extends ParameterDeclaration> _parameters_2 = method.getParameters();
        ParameterDeclaration _head_7 = IterableExtensions.head(_parameters_2);
        String _simpleName_4 = _head_7.getSimpleName();
        Assert.assertEquals("a", _simpleName_4);
        Iterable<? extends ParameterDeclaration> _parameters_3 = method.getParameters();
        ParameterDeclaration _head_8 = IterableExtensions.head(_parameters_3);
        TypeReference _type_2 = _head_8.getType();
        String _string_3 = _type_2.toString();
        Assert.assertEquals("T2", _string_3);
        Iterable<? extends MutableTypeParameterDeclaration> _typeParameters_3 = genMethod.getTypeParameters();
        MutableTypeParameterDeclaration _head_9 = IterableExtensions.head(_typeParameters_3);
        Iterable<? extends ParameterDeclaration> _parameters_4 = method.getParameters();
        ParameterDeclaration _head_10 = IterableExtensions.head(_parameters_4);
        TypeReference _type_3 = _head_10.getType();
        Type _type_4 = _type_3.getType();
        Assert.assertSame(_head_9, _type_4);
        Iterable<? extends ParameterDeclaration> _parameters_5 = method.getParameters();
        ParameterDeclaration _get = ((ParameterDeclaration[])Conversions.unwrapArray(_parameters_5, ParameterDeclaration.class))[1];
        TypeReference _type_5 = _get.getType();
        String _string_4 = _type_5.toString();
        Assert.assertEquals("T", _string_4);
        Iterable<? extends MutableTypeParameterDeclaration> _typeParameters_4 = genClazz.getTypeParameters();
        MutableTypeParameterDeclaration _head_11 = IterableExtensions.head(_typeParameters_4);
        Iterable<? extends ParameterDeclaration> _parameters_6 = method.getParameters();
        ParameterDeclaration _get_1 = ((ParameterDeclaration[])Conversions.unwrapArray(_parameters_6, ParameterDeclaration.class))[1];
        TypeReference _type_6 = _get_1.getType();
        Type _type_7 = _type_6.getType();
        Assert.assertSame(_head_11, _type_7);
        TypeReference _returnType = method.getReturnType();
        Type _type_8 = _returnType.getType();
        Assert.assertSame(genClazz, _type_8);
        Iterable<? extends TypeParameterDeclaration> _typeParameters_5 = method.getTypeParameters();
        TypeParameterDeclaration _head_12 = IterableExtensions.head(_typeParameters_5);
        String _simpleName_5 = _head_12.getSimpleName();
        Assert.assertEquals("T2", _simpleName_5);
        Iterable<? extends TypeParameterDeclaration> _typeParameters_6 = method.getTypeParameters();
        TypeParameterDeclaration _head_13 = IterableExtensions.head(_typeParameters_6);
        Iterable<? extends TypeReference> _upperBounds_1 = _head_13.getUpperBounds();
        TypeReference _head_14 = IterableExtensions.head(_upperBounds_1);
        String _string_5 = _head_14.toString();
        Assert.assertEquals("CharSequence", _string_5);
        Iterable<? extends TypeParameterDeclaration> _typeParameters_7 = method.getTypeParameters();
        TypeParameterDeclaration _head_15 = IterableExtensions.head(_typeParameters_7);
        Iterable<? extends TypeParameterDeclaration> _typeParameters_8 = method.getTypeParameters();
        TypeParameterDeclaration _head_16 = IterableExtensions.head(_typeParameters_8);
        Assert.assertSame(_head_15, _head_16);
        Iterable<? extends TypeParameterDeclaration> _typeParameters_9 = method.getTypeParameters();
        TypeParameterDeclaration _head_17 = IterableExtensions.head(_typeParameters_9);
        TypeParameterDeclarator _typeParameterDeclarator_1 = _head_17.getTypeParameterDeclarator();
        Assert.assertSame(method, _typeParameterDeclarator_1);
        Iterable<? extends MemberDeclaration> _declaredMembers_1 = clazz.getDeclaredMembers();
        Object _get_2 = ((Object[])Conversions.unwrapArray(_declaredMembers_1, Object.class))[0];
        Assert.assertSame(field, _get_2);
        Iterable<? extends MemberDeclaration> _declaredMembers_2 = clazz.getDeclaredMembers();
        Object _get_3 = ((Object[])Conversions.unwrapArray(_declaredMembers_2, Object.class))[1];
        Assert.assertSame(constructor, _get_3);
        Iterable<? extends MemberDeclaration> _declaredMembers_3 = clazz.getDeclaredMembers();
        Object _get_4 = ((Object[])Conversions.unwrapArray(_declaredMembers_3, Object.class))[2];
        Assert.assertSame(method, _get_4);
      }
    };
    this.asCompilationUnit(_validFile, _function);
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
    XtendFile _validFile = this.validFile(_builder);
    final Procedure1<CompilationUnitImpl> _function = new Procedure1<CompilationUnitImpl>() {
      @Override
      public void apply(final CompilationUnitImpl it) {
        TypeLookupImpl _typeLookup = it.getTypeLookup();
        final MutableClassDeclaration genClazz = _typeLookup.findClass("foo.MyClass");
        final Procedure1<MutableMethodDeclaration> _function = new Procedure1<MutableMethodDeclaration>() {
          @Override
          public void apply(final MutableMethodDeclaration it) {
            CompilationUnit _compilationUnit = genClazz.getCompilationUnit();
            TypeReferenceProvider _typeReferenceProvider = ((CompilationUnitImpl) _compilationUnit).getTypeReferenceProvider();
            TypeReference _string = _typeReferenceProvider.getString();
            it.setReturnType(_string);
            it.setVisibility(Visibility.PRIVATE);
            final CompilationStrategy _function = new CompilationStrategy() {
              @Override
              public CharSequence compile(final CompilationStrategy.CompilationContext it) {
                StringConcatenation _builder = new StringConcatenation();
                _builder.append("return \"foo\";");
                _builder.newLine();
                return _builder;
              }
            };
            it.setBody(_function);
          }
        };
        genClazz.addMethod("newMethod", _function);
        final MutableMethodDeclaration mutableMethod = genClazz.findDeclaredMethod("newMethod");
        Iterable<? extends MutableMethodDeclaration> _declaredMethods = genClazz.getDeclaredMethods();
        Object _get = ((Object[])Conversions.unwrapArray(_declaredMethods, Object.class))[1];
        Assert.assertSame(mutableMethod, _get);
        TypeReference _returnType = mutableMethod.getReturnType();
        String _string = _returnType.toString();
        Assert.assertEquals("String", _string);
        Visibility _visibility = mutableMethod.getVisibility();
        Assert.assertEquals(Visibility.PRIVATE, _visibility);
      }
    };
    this.asCompilationUnit(_validFile, _function);
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
    XtendFile _validFile = this.validFile(_builder);
    final Procedure1<CompilationUnitImpl> _function = new Procedure1<CompilationUnitImpl>() {
      @Override
      public void apply(final CompilationUnitImpl it) {
        TypeLookupImpl _typeLookup = it.getTypeLookup();
        final MutableInterfaceDeclaration genInterface = _typeLookup.findInterface("foo.MyInterface");
        final Procedure1<MutableMethodDeclaration> _function = new Procedure1<MutableMethodDeclaration>() {
          @Override
          public void apply(final MutableMethodDeclaration it) {
          }
        };
        final MutableMethodDeclaration m = genInterface.addMethod("newMethod", _function);
        boolean _isAbstract = m.isAbstract();
        Assert.assertTrue(_isAbstract);
      }
    };
    this.asCompilationUnit(_validFile, _function);
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
    XtendFile _validFile = this.validFile(_builder);
    final Procedure1<CompilationUnitImpl> _function = new Procedure1<CompilationUnitImpl>() {
      @Override
      public void apply(final CompilationUnitImpl it) {
        TypeReferenceProvider _typeReferenceProvider = it.getTypeReferenceProvider();
        final TypeReference anyType = _typeReferenceProvider.getAnyType();
        boolean _isAnyType = anyType.isAnyType();
        Assert.assertTrue(_isAnyType);
        TypeReferenceProvider _typeReferenceProvider_1 = it.getTypeReferenceProvider();
        final TypeReference stringType = _typeReferenceProvider_1.getString();
        TypeReferenceProvider _typeReferenceProvider_2 = it.getTypeReferenceProvider();
        String _name = CharSequence.class.getName();
        final TypeReference charsequenceType = _typeReferenceProvider_2.newTypeReference(_name);
        boolean _isAssignableFrom = charsequenceType.isAssignableFrom(stringType);
        Assert.assertTrue(_isAssignableFrom);
        boolean _isAssignableFrom_1 = stringType.isAssignableFrom(anyType);
        Assert.assertTrue(_isAssignableFrom_1);
        boolean _isAssignableFrom_2 = stringType.isAssignableFrom(charsequenceType);
        Assert.assertFalse(_isAssignableFrom_2);
        TypeReferenceProvider _typeReferenceProvider_3 = it.getTypeReferenceProvider();
        TypeReference _primitiveBoolean = _typeReferenceProvider_3.getPrimitiveBoolean();
        DeclarationsTest.this.checkPrimitive(_primitiveBoolean, "java.lang.Boolean");
        TypeReferenceProvider _typeReferenceProvider_4 = it.getTypeReferenceProvider();
        TypeReference _primitiveInt = _typeReferenceProvider_4.getPrimitiveInt();
        DeclarationsTest.this.checkPrimitive(_primitiveInt, "java.lang.Integer");
        TypeReferenceProvider _typeReferenceProvider_5 = it.getTypeReferenceProvider();
        TypeReference _primitiveLong = _typeReferenceProvider_5.getPrimitiveLong();
        DeclarationsTest.this.checkPrimitive(_primitiveLong, "java.lang.Long");
        TypeReferenceProvider _typeReferenceProvider_6 = it.getTypeReferenceProvider();
        TypeReference _primitiveShort = _typeReferenceProvider_6.getPrimitiveShort();
        DeclarationsTest.this.checkPrimitive(_primitiveShort, "java.lang.Short");
        TypeReferenceProvider _typeReferenceProvider_7 = it.getTypeReferenceProvider();
        TypeReference _primitiveChar = _typeReferenceProvider_7.getPrimitiveChar();
        DeclarationsTest.this.checkPrimitive(_primitiveChar, "java.lang.Character");
        TypeReferenceProvider _typeReferenceProvider_8 = it.getTypeReferenceProvider();
        TypeReference _primitiveByte = _typeReferenceProvider_8.getPrimitiveByte();
        DeclarationsTest.this.checkPrimitive(_primitiveByte, "java.lang.Byte");
        TypeReferenceProvider _typeReferenceProvider_9 = it.getTypeReferenceProvider();
        TypeReference _primitiveFloat = _typeReferenceProvider_9.getPrimitiveFloat();
        DeclarationsTest.this.checkPrimitive(_primitiveFloat, "java.lang.Float");
        TypeReferenceProvider _typeReferenceProvider_10 = it.getTypeReferenceProvider();
        TypeReference _primitiveDouble = _typeReferenceProvider_10.getPrimitiveDouble();
        DeclarationsTest.this.checkPrimitive(_primitiveDouble, "java.lang.Double");
        TypeReferenceProvider _typeReferenceProvider_11 = it.getTypeReferenceProvider();
        final TypeReference primitiveVoid = _typeReferenceProvider_11.getPrimitiveVoid();
        boolean _isVoid = primitiveVoid.isVoid();
        Assert.assertTrue(_isVoid);
        TypeReferenceProvider _typeReferenceProvider_12 = it.getTypeReferenceProvider();
        TypeReferenceProvider _typeReferenceProvider_13 = it.getTypeReferenceProvider();
        TypeReference _string = _typeReferenceProvider_13.getString();
        final TypeReference listOfStringType = _typeReferenceProvider_12.getList(_string);
        TypeReferenceProvider _typeReferenceProvider_14 = it.getTypeReferenceProvider();
        List<TypeReference> _actualTypeArguments = listOfStringType.getActualTypeArguments();
        TypeReference _head = IterableExtensions.<TypeReference>head(_actualTypeArguments);
        final TypeReference setOfString = _typeReferenceProvider_14.getSet(_head);
        String _string_1 = listOfStringType.toString();
        Assert.assertEquals("List<String>", _string_1);
        List<TypeReference> _actualTypeArguments_1 = listOfStringType.getActualTypeArguments();
        TypeReference _head_1 = IterableExtensions.<TypeReference>head(_actualTypeArguments_1);
        String _string_2 = _head_1.toString();
        Assert.assertEquals("String", _string_2);
        String _string_3 = setOfString.toString();
        Assert.assertEquals("Set<String>", _string_3);
        List<TypeReference> _actualTypeArguments_2 = setOfString.getActualTypeArguments();
        TypeReference _head_2 = IterableExtensions.<TypeReference>head(_actualTypeArguments_2);
        String _string_4 = _head_2.toString();
        Assert.assertEquals("String", _string_4);
        TypeReferenceProvider _typeReferenceProvider_15 = it.getTypeReferenceProvider();
        TypeReferenceProvider _typeReferenceProvider_16 = it.getTypeReferenceProvider();
        TypeReference _newWildcardTypeReference = _typeReferenceProvider_16.newWildcardTypeReference();
        TypeReference _set = _typeReferenceProvider_15.getSet(_newWildcardTypeReference);
        String _string_5 = _set.toString();
        Assert.assertEquals("Set<?>", _string_5);
        TypeReferenceProvider _typeReferenceProvider_17 = it.getTypeReferenceProvider();
        TypeReferenceProvider _typeReferenceProvider_18 = it.getTypeReferenceProvider();
        TypeReference _newWildcardTypeReference_1 = _typeReferenceProvider_18.newWildcardTypeReference(listOfStringType);
        TypeReference _set_1 = _typeReferenceProvider_17.getSet(_newWildcardTypeReference_1);
        String _string_6 = _set_1.toString();
        Assert.assertEquals("Set<? extends List<String>>", _string_6);
        TypeReferenceProvider _typeReferenceProvider_19 = it.getTypeReferenceProvider();
        TypeReferenceProvider _typeReferenceProvider_20 = it.getTypeReferenceProvider();
        TypeReference _newWildcardTypeReferenceWithLowerBound = _typeReferenceProvider_20.newWildcardTypeReferenceWithLowerBound(listOfStringType);
        TypeReference _set_2 = _typeReferenceProvider_19.getSet(_newWildcardTypeReferenceWithLowerBound);
        String _string_7 = _set_2.toString();
        Assert.assertEquals("Set<? super List<String>>", _string_7);
      }
    };
    this.asCompilationUnit(_validFile, _function);
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
    XtendFile _validFile = this.validFile(_builder);
    final Procedure1<CompilationUnitImpl> _function = new Procedure1<CompilationUnitImpl>() {
      @Override
      public void apply(final CompilationUnitImpl it) {
        Iterable<? extends TypeDeclaration> _sourceTypeDeclarations = it.getSourceTypeDeclarations();
        TypeDeclaration _get = ((TypeDeclaration[])Conversions.unwrapArray(_sourceTypeDeclarations, TypeDeclaration.class))[0];
        final ClassDeclaration baseClass = ((ClassDeclaration) _get);
        TypeLookupImpl _typeLookup = it.getTypeLookup();
        final MutableClassDeclaration subClass = _typeLookup.findClass("foo.SubType");
        Iterable<? extends TypeDeclaration> _sourceTypeDeclarations_1 = it.getSourceTypeDeclarations();
        TypeDeclaration _get_1 = ((TypeDeclaration[])Conversions.unwrapArray(_sourceTypeDeclarations_1, TypeDeclaration.class))[2];
        final InterfaceDeclaration interfaceA = ((InterfaceDeclaration) _get_1);
        Iterable<? extends TypeDeclaration> _sourceTypeDeclarations_2 = it.getSourceTypeDeclarations();
        TypeDeclaration _get_2 = ((TypeDeclaration[])Conversions.unwrapArray(_sourceTypeDeclarations_2, TypeDeclaration.class))[3];
        final InterfaceDeclaration interfaceB = ((InterfaceDeclaration) _get_2);
        TypeReferenceProvider _typeReferenceProvider = it.getTypeReferenceProvider();
        TypeReference _object = _typeReferenceProvider.getObject();
        final Type object = _object.getType();
        boolean _isAssignableFrom = object.isAssignableFrom(baseClass);
        Assert.assertTrue(_isAssignableFrom);
        boolean _isAssignableFrom_1 = object.isAssignableFrom(subClass);
        Assert.assertTrue(_isAssignableFrom_1);
        boolean _isAssignableFrom_2 = object.isAssignableFrom(interfaceA);
        Assert.assertTrue(_isAssignableFrom_2);
        boolean _isAssignableFrom_3 = object.isAssignableFrom(interfaceB);
        Assert.assertTrue(_isAssignableFrom_3);
        boolean _isAssignableFrom_4 = baseClass.isAssignableFrom(baseClass);
        Assert.assertTrue(_isAssignableFrom_4);
        boolean _isAssignableFrom_5 = baseClass.isAssignableFrom(subClass);
        Assert.assertTrue(_isAssignableFrom_5);
        boolean _isAssignableFrom_6 = baseClass.isAssignableFrom(interfaceB);
        Assert.assertFalse(_isAssignableFrom_6);
        boolean _isAssignableFrom_7 = baseClass.isAssignableFrom(interfaceA);
        Assert.assertFalse(_isAssignableFrom_7);
        boolean _isAssignableFrom_8 = baseClass.isAssignableFrom(object);
        Assert.assertFalse(_isAssignableFrom_8);
        boolean _isAssignableFrom_9 = interfaceA.isAssignableFrom(baseClass);
        Assert.assertTrue(_isAssignableFrom_9);
        boolean _isAssignableFrom_10 = interfaceA.isAssignableFrom(subClass);
        Assert.assertTrue(_isAssignableFrom_10);
        boolean _isAssignableFrom_11 = interfaceA.isAssignableFrom(interfaceA);
        Assert.assertTrue(_isAssignableFrom_11);
        boolean _isAssignableFrom_12 = interfaceA.isAssignableFrom(interfaceB);
        Assert.assertFalse(_isAssignableFrom_12);
        boolean _isAssignableFrom_13 = interfaceA.isAssignableFrom(object);
        Assert.assertFalse(_isAssignableFrom_13);
      }
    };
    this.asCompilationUnit(_validFile, _function);
  }
  
  @Test
  public void testSetImplementedInterfaces() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class BaseClass {}");
    _builder.newLine();
    _builder.append("interface Interface {}");
    _builder.newLine();
    XtendFile _validFile = this.validFile(_builder);
    final Procedure1<CompilationUnitImpl> _function = new Procedure1<CompilationUnitImpl>() {
      @Override
      public void apply(final CompilationUnitImpl it) {
        TypeLookupImpl _typeLookup = it.getTypeLookup();
        final MutableClassDeclaration baseClass = _typeLookup.findClass("BaseClass");
        TypeLookupImpl _typeLookup_1 = it.getTypeLookup();
        final MutableInterfaceDeclaration interf = _typeLookup_1.findInterface("Interface");
        final TypeReference objectType = baseClass.getExtendedClass();
        String _simpleName = objectType.getSimpleName();
        Assert.assertEquals("Object", _simpleName);
        Iterable<? extends TypeReference> _implementedInterfaces = baseClass.getImplementedInterfaces();
        boolean _isEmpty = IterableExtensions.isEmpty(_implementedInterfaces);
        Assert.assertTrue(_isEmpty);
        TypeReferenceProvider _typeReferenceProvider = it.getTypeReferenceProvider();
        final TypeReference superType = _typeReferenceProvider.newTypeReference(AccessibleObject.class);
        baseClass.setExtendedClass(superType);
        TypeReference _extendedClass = baseClass.getExtendedClass();
        String _simpleName_1 = _extendedClass.getSimpleName();
        Assert.assertEquals("AccessibleObject", _simpleName_1);
        Iterable<? extends TypeReference> _implementedInterfaces_1 = baseClass.getImplementedInterfaces();
        boolean _isEmpty_1 = IterableExtensions.isEmpty(_implementedInterfaces_1);
        Assert.assertTrue(_isEmpty_1);
        baseClass.setExtendedClass(null);
        TypeReference _extendedClass_1 = baseClass.getExtendedClass();
        String _simpleName_2 = _extendedClass_1.getSimpleName();
        Assert.assertEquals("Object", _simpleName_2);
        Iterable<? extends TypeReference> _implementedInterfaces_2 = baseClass.getImplementedInterfaces();
        boolean _isEmpty_2 = IterableExtensions.isEmpty(_implementedInterfaces_2);
        Assert.assertTrue(_isEmpty_2);
        TypeReferenceProvider _typeReferenceProvider_1 = it.getTypeReferenceProvider();
        TypeReference _newTypeReference = _typeReferenceProvider_1.newTypeReference(interf);
        baseClass.setImplementedInterfaces(Collections.<TypeReference>unmodifiableList(CollectionLiterals.<TypeReference>newArrayList(_newTypeReference)));
        Iterable<? extends TypeReference> _implementedInterfaces_3 = baseClass.getImplementedInterfaces();
        TypeReference _head = IterableExtensions.head(_implementedInterfaces_3);
        String _simpleName_3 = _head.getSimpleName();
        Assert.assertEquals("Interface", _simpleName_3);
        baseClass.setImplementedInterfaces(Collections.<TypeReference>unmodifiableList(CollectionLiterals.<TypeReference>newArrayList()));
        Iterable<? extends TypeReference> _implementedInterfaces_4 = baseClass.getImplementedInterfaces();
        boolean _isEmpty_3 = IterableExtensions.isEmpty(_implementedInterfaces_4);
        Assert.assertTrue(_isEmpty_3);
      }
    };
    this.asCompilationUnit(_validFile, _function);
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
    XtendFile _validFile = this.validFile(_builder);
    final Procedure1<CompilationUnitImpl> _function = new Procedure1<CompilationUnitImpl>() {
      @Override
      public void apply(final CompilationUnitImpl it) {
        TypeLookupImpl _typeLookup = it.getTypeLookup();
        final MutableClassDeclaration baseClass = _typeLookup.findClass("foo.Bar");
        Iterable<? extends AnnotationReference> _annotations = baseClass.getAnnotations();
        final AnnotationReference annoRef = IterableExtensions.head(_annotations);
        Object _value = annoRef.getValue("intValue");
        Assert.assertEquals(Integer.valueOf((((2 / 2) + (2 * 3)) - (4 % 1))), _value);
        Object _value_1 = annoRef.getValue("longValue");
        Assert.assertEquals(Integer.valueOf((((42 + 4) + (6 * 42)) - (4 / 45))), _value_1);
        Object _value_2 = annoRef.getValue("stringValue");
        Assert.assertEquals("foobaz", _value_2);
        Object _value_3 = annoRef.getValue("booleanArrayValue");
        final boolean[] bools = ((boolean[]) _value_3);
        boolean _get = bools[0];
        Assert.assertTrue(_get);
        boolean _get_1 = bools[1];
        Assert.assertFalse(_get_1);
        Object _value_4 = annoRef.getValue("intArrayValue");
        Assert.assertArrayEquals(new int[] { (-1), (34 + 45), (2 - 6) }, ((int[]) _value_4));
        Object _value_5 = annoRef.getValue("typeArrayValue");
        final TypeReference[] type = ((TypeReference[]) _value_5);
        TypeReferenceProvider _typeReferenceProvider = it.getTypeReferenceProvider();
        TypeReference _newTypeReference = _typeReferenceProvider.newTypeReference(Integer.class);
        Object _get_2 = type[1];
        Assert.assertEquals(_newTypeReference, _get_2);
        Object _value_6 = annoRef.getValue("annotation2Value");
        final AnnotationReference anno = ((AnnotationReference) _value_6);
        Object _value_7 = anno.getValue("value");
        Assert.assertEquals("foowuppa", _value_7);
        Object _value_8 = annoRef.getValue("annotation2ArrayValue");
        final AnnotationReference[] annoArray = ((AnnotationReference[]) _value_8);
        AnnotationReference _get_3 = annoArray[0];
        Object _value_9 = _get_3.getValue("value");
        Assert.assertEquals("HUBBA BUBBA!", _value_9);
      }
    };
    this.asCompilationUnit(_validFile, _function);
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
    XtendFile _validFile = this.validFile(_builder);
    final Procedure1<CompilationUnitImpl> _function = new Procedure1<CompilationUnitImpl>() {
      @Override
      public void apply(final CompilationUnitImpl it) {
        TypeLookupImpl _typeLookup = it.getTypeLookup();
        final MutableClassDeclaration baseClass = _typeLookup.findClass("foo.Bar");
        Iterable<? extends AnnotationReference> _annotations = baseClass.getAnnotations();
        final AnnotationReference annoRef = IterableExtensions.head(_annotations);
        int _intValue = annoRef.getIntValue("intValue");
        Assert.assertEquals((((2 / 2) + (2 * 3)) - (4 % 1)), _intValue);
        long _longValue = annoRef.getLongValue("longValue");
        Assert.assertEquals((((42 + 4) + (6 * 42)) - (4 / 45)), _longValue);
        String _stringValue = annoRef.getStringValue("stringValue");
        Assert.assertEquals("foobaz", _stringValue);
        final boolean[] bools = annoRef.getBooleanArrayValue("booleanArrayValue");
        boolean _get = bools[0];
        Assert.assertTrue(_get);
        boolean _get_1 = bools[1];
        Assert.assertFalse(_get_1);
        int[] _intArrayValue = annoRef.getIntArrayValue("intArrayValue");
        Assert.assertArrayEquals(new int[] { (-1), (34 + 45), (2 - 6) }, _intArrayValue);
        final TypeReference[] type = annoRef.getClassArrayValue("typeArrayValue");
        TypeReferenceProvider _typeReferenceProvider = it.getTypeReferenceProvider();
        TypeReference _newTypeReference = _typeReferenceProvider.newTypeReference(Integer.class);
        Object _get_2 = type[1];
        Assert.assertEquals(_newTypeReference, _get_2);
        final AnnotationReference anno = annoRef.getAnnotationValue("annotation2Value");
        String _stringValue_1 = anno.getStringValue("value");
        Assert.assertEquals("foowuppa", _stringValue_1);
        final AnnotationReference[] annoArray = annoRef.getAnnotationArrayValue("annotation2ArrayValue");
        AnnotationReference _get_3 = annoArray[0];
        Object _value = _get_3.getValue("value");
        Assert.assertEquals("HUBBA BUBBA!", _value);
      }
    };
    this.asCompilationUnit(_validFile, _function);
  }
  
  public void checkPrimitive(final TypeReference primitiveType, final String wrapperTypeName) {
    String _string = primitiveType.toString();
    boolean _isPrimitive = primitiveType.isPrimitive();
    Assert.assertTrue(_string, _isPrimitive);
    TypeReference _wrapperIfPrimitive = primitiveType.getWrapperIfPrimitive();
    Type _type = _wrapperIfPrimitive.getType();
    String _qualifiedName = _type.getQualifiedName();
    Assert.assertEquals(wrapperTypeName, _qualifiedName);
  }
  
  public XtendFile validFile(final CharSequence code) {
    try {
      String _string = code.toString();
      return this.file(_string, true);
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
