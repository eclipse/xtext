/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.UnmodifiableIterator;
import com.google.inject.Inject;
import java.lang.ref.SoftReference;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedConstructor;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedField;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedOperation;
import org.eclipse.xtext.xbase.typesystem.override.OverrideHelper;
import org.eclipse.xtext.xbase.typesystem.override.ResolvedFeatures;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Lorenzo Bettini - https://bugs.eclipse.org/bugs/show_bug.cgi?id=454786
 */
@SuppressWarnings("all")
public class ResolvedFeaturesTest extends AbstractXbaseTestCase {
  public static class BaseClass {
    public Object baseClassMethod(final List<String> l) {
      return null;
    }
  }
  
  public static class DerivedClass extends ResolvedFeaturesTest.BaseClass {
    public Object derivedClassMethod(final List<String> l) {
      return null;
    }
  }
  
  @Inject
  private OverrideHelper overrideHelper;
  
  private final static String BASE_CLASS_METHOD_ERASED_SIGNATURE = "baseClassMethod(java.util.List)";
  
  private final static String DERIVED_CLASS_METHOD_ERASED_SIGNATURE = "derivedClassMethod(java.util.List)";
  
  public ResolvedFeatures toResolvedOperations(final Class<?> type) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("typeof(");
      String _canonicalName = type.getCanonicalName();
      _builder.append(_canonicalName, "");
      _builder.append(")");
      XExpression _expression = this.expression(_builder);
      final XTypeLiteral typeLiteral = ((XTypeLiteral) _expression);
      JvmType _type = typeLiteral.getType();
      final ResolvedFeatures result = this.overrideHelper.getResolvedFeatures(((JvmDeclaredType) _type));
      return result;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public ResolvedFeatures toResolvedOperations(final String castExpression) {
    try {
      XExpression _expression = this.expression(castExpression);
      final XCastedExpression cast = ((XCastedExpression) _expression);
      JvmTypeReference _type = cast.getType();
      final ResolvedFeatures result = this.overrideHelper.getResolvedFeatures(_type);
      return result;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAllOperationsIncludeDeclaredOperations() {
    final ResolvedFeatures resolvedOperations = this.toResolvedOperations(ResolvedFeaturesTest.DerivedClass.class);
    final List<IResolvedOperation> declared = resolvedOperations.getDeclaredOperations();
    final List<IResolvedOperation> all = resolvedOperations.getAllOperations();
    boolean _isEmpty = all.isEmpty();
    Assert.assertFalse(_isEmpty);
    int _size = declared.size();
    Assert.assertEquals(1, _size);
    IResolvedOperation _head = IterableExtensions.<IResolvedOperation>head(declared);
    IResolvedOperation _head_1 = IterableExtensions.<IResolvedOperation>head(all);
    Assert.assertSame(_head, _head_1);
  }
  
  @Test
  public void testDeclaredOperationsAreIncludedInAllOperations() {
    final ResolvedFeatures resolvedOperations = this.toResolvedOperations(ResolvedFeaturesTest.DerivedClass.class);
    final List<IResolvedOperation> all = resolvedOperations.getAllOperations();
    final List<IResolvedOperation> declared = resolvedOperations.getDeclaredOperations();
    boolean _isEmpty = all.isEmpty();
    Assert.assertFalse(_isEmpty);
    int _size = declared.size();
    Assert.assertEquals(1, _size);
    IResolvedOperation _head = IterableExtensions.<IResolvedOperation>head(declared);
    IResolvedOperation _head_1 = IterableExtensions.<IResolvedOperation>head(all);
    Assert.assertSame(_head, _head_1);
  }
  
  @Test
  public void testDeclaredAndAllOperationsErasedSignature() {
    final ResolvedFeatures resolvedOperations = this.toResolvedOperations(ResolvedFeaturesTest.DerivedClass.class);
    List<IResolvedOperation> _allOperations = resolvedOperations.getAllOperations(ResolvedFeaturesTest.BASE_CLASS_METHOD_ERASED_SIGNATURE);
    IResolvedOperation _head = IterableExtensions.<IResolvedOperation>head(_allOperations);
    Assert.assertNotNull(_head);
    List<IResolvedOperation> _declaredOperations = resolvedOperations.getDeclaredOperations(ResolvedFeaturesTest.BASE_CLASS_METHOD_ERASED_SIGNATURE);
    IResolvedOperation _head_1 = IterableExtensions.<IResolvedOperation>head(_declaredOperations);
    Assert.assertNull(_head_1);
  }
  
  @Test
  public void testDeclaredOperationsErasedSignatureAreIncludedInAllOperations() {
    final ResolvedFeatures resolvedOperations = this.toResolvedOperations(ResolvedFeaturesTest.DerivedClass.class);
    final List<IResolvedOperation> all = resolvedOperations.getAllOperations(ResolvedFeaturesTest.DERIVED_CLASS_METHOD_ERASED_SIGNATURE);
    final List<IResolvedOperation> declared = resolvedOperations.getDeclaredOperations(ResolvedFeaturesTest.DERIVED_CLASS_METHOD_ERASED_SIGNATURE);
    boolean _isEmpty = all.isEmpty();
    Assert.assertFalse(_isEmpty);
    int _size = declared.size();
    Assert.assertEquals(1, _size);
    IResolvedOperation _head = IterableExtensions.<IResolvedOperation>head(declared);
    IResolvedOperation _head_1 = IterableExtensions.<IResolvedOperation>head(all);
    Assert.assertSame(_head, _head_1);
  }
  
  @Test
  public void testAllOperationsErasedSignatureIncludeDeclaredOperations() {
    final ResolvedFeatures resolvedOperations = this.toResolvedOperations(ResolvedFeaturesTest.DerivedClass.class);
    final List<IResolvedOperation> declared = resolvedOperations.getDeclaredOperations(ResolvedFeaturesTest.DERIVED_CLASS_METHOD_ERASED_SIGNATURE);
    final List<IResolvedOperation> all = resolvedOperations.getAllOperations(ResolvedFeaturesTest.DERIVED_CLASS_METHOD_ERASED_SIGNATURE);
    boolean _isEmpty = all.isEmpty();
    Assert.assertFalse(_isEmpty);
    int _size = declared.size();
    Assert.assertEquals(1, _size);
    IResolvedOperation _head = IterableExtensions.<IResolvedOperation>head(declared);
    IResolvedOperation _head_1 = IterableExtensions.<IResolvedOperation>head(all);
    Assert.assertSame(_head, _head_1);
  }
  
  @Test
  public void testArrayListHasNoAbstractMethods() {
    final ResolvedFeatures resolvedOperations = this.toResolvedOperations(ArrayList.class);
    final List<IResolvedOperation> all = resolvedOperations.getAllOperations();
    boolean _isEmpty = all.isEmpty();
    Assert.assertFalse(_isEmpty);
    final Consumer<IResolvedOperation> _function = (IResolvedOperation it) -> {
      JvmOperation _declaration = it.getDeclaration();
      boolean _isAbstract = _declaration.isAbstract();
      Assert.assertFalse(_isAbstract);
    };
    all.forEach(_function);
  }
  
  @Test
  public void testIterableIterator() {
    final ResolvedFeatures resolvedOperations = this.toResolvedOperations(Iterable.class);
    final List<IResolvedOperation> all = resolvedOperations.getAllOperations();
    boolean _isEmpty = all.isEmpty();
    Assert.assertFalse(_isEmpty);
    final Function1<IResolvedOperation, Boolean> _function = (IResolvedOperation it) -> {
      JvmOperation _declaration = it.getDeclaration();
      return Boolean.valueOf(_declaration.isAbstract());
    };
    Iterable<IResolvedOperation> _filter = IterableExtensions.<IResolvedOperation>filter(all, _function);
    final IResolvedOperation iterator = Iterables.<IResolvedOperation>getOnlyElement(_filter);
    JvmOperation _declaration = iterator.getDeclaration();
    String _identifier = _declaration.getIdentifier();
    Assert.assertEquals("java.lang.Iterable.iterator()", _identifier);
  }
  
  @Test
  public void testUnmodifiableIterator() {
    final ResolvedFeatures resolvedOperations = this.toResolvedOperations(UnmodifiableIterator.class);
    final List<IResolvedOperation> all = resolvedOperations.getAllOperations();
    boolean _isEmpty = all.isEmpty();
    Assert.assertFalse(_isEmpty);
    String _string = all.toString();
    final Function1<IResolvedOperation, Boolean> _function = (IResolvedOperation it) -> {
      JvmOperation _declaration = it.getDeclaration();
      return Boolean.valueOf(_declaration.isAbstract());
    };
    Iterable<IResolvedOperation> _filter = IterableExtensions.<IResolvedOperation>filter(all, _function);
    int _size = IterableExtensions.size(_filter);
    Assert.assertEquals(_string, 2, _size);
    String _string_1 = all.toString();
    final Function1<IResolvedOperation, Boolean> _function_1 = (IResolvedOperation it) -> {
      JvmOperation _declaration = it.getDeclaration();
      return Boolean.valueOf(_declaration.isFinal());
    };
    Iterable<IResolvedOperation> _filter_1 = IterableExtensions.<IResolvedOperation>filter(all, _function_1);
    int _size_1 = IterableExtensions.size(_filter_1);
    Assert.assertEquals(_string_1, (1 + 6), _size_1);
    final List<IResolvedOperation> declared = resolvedOperations.getDeclaredOperations();
    int _size_2 = declared.size();
    Assert.assertEquals(1, _size_2);
  }
  
  @Test
  public void testAbstractList() {
    final ResolvedFeatures resolvedOperations = this.toResolvedOperations(AbstractList.class);
    final List<IResolvedOperation> all = resolvedOperations.getAllOperations();
    boolean _isEmpty = all.isEmpty();
    Assert.assertFalse(_isEmpty);
    String _string = all.toString();
    final Function1<IResolvedOperation, Boolean> _function = (IResolvedOperation it) -> {
      JvmOperation _declaration = it.getDeclaration();
      return Boolean.valueOf(_declaration.isAbstract());
    };
    Iterable<IResolvedOperation> _filter = IterableExtensions.<IResolvedOperation>filter(all, _function);
    int _size = IterableExtensions.size(_filter);
    Assert.assertEquals(_string, (1 + 1), _size);
    final List<IResolvedOperation> declared = resolvedOperations.getDeclaredOperations();
    final Function1<IResolvedOperation, Boolean> _function_1 = (IResolvedOperation it) -> {
      JvmOperation _declaration = it.getDeclaration();
      return Boolean.valueOf(_declaration.isAbstract());
    };
    Iterable<IResolvedOperation> _filter_1 = IterableExtensions.<IResolvedOperation>filter(declared, _function_1);
    int _size_1 = IterableExtensions.size(_filter_1);
    Assert.assertEquals(1, _size_1);
  }
  
  @Test
  public void testSoftReferenceConstructors() {
    final ResolvedFeatures resolvedOperations = this.toResolvedOperations(SoftReference.class);
    List<IResolvedOperation> _declaredOperations = resolvedOperations.getDeclaredOperations();
    int _size = _declaredOperations.size();
    Assert.assertEquals(1, _size);
    List<IResolvedConstructor> _declaredConstructors = resolvedOperations.getDeclaredConstructors();
    int _size_1 = _declaredConstructors.size();
    Assert.assertEquals(2, _size_1);
    List<IResolvedConstructor> _declaredConstructors_1 = resolvedOperations.getDeclaredConstructors();
    final Consumer<IResolvedConstructor> _function = (IResolvedConstructor it) -> {
      JvmConstructor _declaration = it.getDeclaration();
      EList<JvmFormalParameter> _parameters = _declaration.getParameters();
      int _size_2 = _parameters.size();
      switch (_size_2) {
        case 1:
          String _resolvedSignature = it.getResolvedSignature();
          Assert.assertEquals("SoftReference(T)", _resolvedSignature);
          String _resolvedErasureSignature = it.getResolvedErasureSignature();
          Assert.assertEquals("SoftReference(java.lang.Object)", _resolvedErasureSignature);
          break;
        case 2:
          String _resolvedSignature_1 = it.getResolvedSignature();
          Assert.assertEquals("SoftReference(T,java.lang.ref.ReferenceQueue<? super T>)", _resolvedSignature_1);
          String _resolvedErasureSignature_1 = it.getResolvedErasureSignature();
          Assert.assertEquals("SoftReference(java.lang.Object,java.lang.ref.ReferenceQueue)", _resolvedErasureSignature_1);
          break;
        default:
          Assert.fail(("Unexpected constructor: " + it));
          break;
      }
    };
    _declaredConstructors_1.forEach(_function);
  }
  
  @Test
  public void testSoftReferenceOfString() {
    final ResolvedFeatures resolvedOperations = this.toResolvedOperations("null as java.lang.ref.SoftReference<String>");
    List<IResolvedOperation> _declaredOperations = resolvedOperations.getDeclaredOperations();
    int _size = _declaredOperations.size();
    Assert.assertEquals(1, _size);
    List<IResolvedConstructor> _declaredConstructors = resolvedOperations.getDeclaredConstructors();
    int _size_1 = _declaredConstructors.size();
    Assert.assertEquals(2, _size_1);
    List<IResolvedConstructor> _declaredConstructors_1 = resolvedOperations.getDeclaredConstructors();
    final Consumer<IResolvedConstructor> _function = (IResolvedConstructor it) -> {
      JvmConstructor _declaration = it.getDeclaration();
      EList<JvmFormalParameter> _parameters = _declaration.getParameters();
      int _size_2 = _parameters.size();
      switch (_size_2) {
        case 1:
          String _resolvedSignature = it.getResolvedSignature();
          Assert.assertEquals("SoftReference(java.lang.String)", _resolvedSignature);
          String _resolvedErasureSignature = it.getResolvedErasureSignature();
          Assert.assertEquals("SoftReference(java.lang.String)", _resolvedErasureSignature);
          break;
        case 2:
          String _resolvedSignature_1 = it.getResolvedSignature();
          Assert.assertEquals("SoftReference(java.lang.String,java.lang.ref.ReferenceQueue<? super java.lang.String>)", _resolvedSignature_1);
          String _resolvedErasureSignature_1 = it.getResolvedErasureSignature();
          Assert.assertEquals("SoftReference(java.lang.String,java.lang.ref.ReferenceQueue)", _resolvedErasureSignature_1);
          break;
        default:
          Assert.fail(("Unexpected constructor: " + it));
          break;
      }
    };
    _declaredConstructors_1.forEach(_function);
  }
  
  @Test
  public void testReferenceOfString() {
    final ResolvedFeatures resolvedFeatures = this.toResolvedOperations("null as java.lang.ref.Reference<String>");
    List<IResolvedField> _declaredFields = resolvedFeatures.getDeclaredFields();
    final List<IResolvedField> fields = IterableExtensions.<IResolvedField>toList(_declaredFields);
    final Function1<IResolvedField, Boolean> _function = (IResolvedField it) -> {
      String _simpleSignature = it.getSimpleSignature();
      return Boolean.valueOf(Objects.equal(_simpleSignature, "referent"));
    };
    IResolvedField _findFirst = IterableExtensions.<IResolvedField>findFirst(fields, _function);
    LightweightTypeReference _resolvedType = _findFirst.getResolvedType();
    String _humanReadableName = _resolvedType.getHumanReadableName();
    Assert.assertEquals("String", _humanReadableName);
    final Function1<IResolvedField, Boolean> _function_1 = (IResolvedField it) -> {
      String _simpleSignature = it.getSimpleSignature();
      return Boolean.valueOf(Objects.equal(_simpleSignature, "queue"));
    };
    IResolvedField _findFirst_1 = IterableExtensions.<IResolvedField>findFirst(fields, _function_1);
    LightweightTypeReference _resolvedType_1 = _findFirst_1.getResolvedType();
    String _humanReadableName_1 = _resolvedType_1.getHumanReadableName();
    Assert.assertEquals("ReferenceQueue<? super String>", _humanReadableName_1);
  }
}
