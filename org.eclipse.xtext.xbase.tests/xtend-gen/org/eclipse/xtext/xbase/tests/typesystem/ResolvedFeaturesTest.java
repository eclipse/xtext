/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
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
  
  private static final String BASE_CLASS_METHOD_ERASED_SIGNATURE = "baseClassMethod(java.util.List)";
  
  private static final String DERIVED_CLASS_METHOD_ERASED_SIGNATURE = "derivedClassMethod(java.util.List)";
  
  public ResolvedFeatures toResolvedOperations(final Class<?> type) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("typeof(");
      String _canonicalName = type.getCanonicalName();
      _builder.append(_canonicalName);
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
      final ResolvedFeatures result = this.overrideHelper.getResolvedFeatures(cast.getType());
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
    Assert.assertFalse(all.isEmpty());
    Assert.assertEquals(1, declared.size());
    Assert.assertSame(IterableExtensions.<IResolvedOperation>head(declared), IterableExtensions.<IResolvedOperation>head(all));
  }
  
  @Test
  public void testDeclaredOperationsAreIncludedInAllOperations() {
    final ResolvedFeatures resolvedOperations = this.toResolvedOperations(ResolvedFeaturesTest.DerivedClass.class);
    final List<IResolvedOperation> all = resolvedOperations.getAllOperations();
    final List<IResolvedOperation> declared = resolvedOperations.getDeclaredOperations();
    Assert.assertFalse(all.isEmpty());
    Assert.assertEquals(1, declared.size());
    Assert.assertSame(IterableExtensions.<IResolvedOperation>head(declared), IterableExtensions.<IResolvedOperation>head(all));
  }
  
  @Test
  public void testDeclaredAndAllOperationsErasedSignature() {
    final ResolvedFeatures resolvedOperations = this.toResolvedOperations(ResolvedFeaturesTest.DerivedClass.class);
    Assert.assertNotNull(
      IterableExtensions.<IResolvedOperation>head(resolvedOperations.getAllOperations(ResolvedFeaturesTest.BASE_CLASS_METHOD_ERASED_SIGNATURE)));
    Assert.assertNull(
      IterableExtensions.<IResolvedOperation>head(resolvedOperations.getDeclaredOperations(ResolvedFeaturesTest.BASE_CLASS_METHOD_ERASED_SIGNATURE)));
  }
  
  @Test
  public void testDeclaredOperationsErasedSignatureAreIncludedInAllOperations() {
    final ResolvedFeatures resolvedOperations = this.toResolvedOperations(ResolvedFeaturesTest.DerivedClass.class);
    final List<IResolvedOperation> all = resolvedOperations.getAllOperations(ResolvedFeaturesTest.DERIVED_CLASS_METHOD_ERASED_SIGNATURE);
    final List<IResolvedOperation> declared = resolvedOperations.getDeclaredOperations(ResolvedFeaturesTest.DERIVED_CLASS_METHOD_ERASED_SIGNATURE);
    Assert.assertFalse(all.isEmpty());
    Assert.assertEquals(1, declared.size());
    Assert.assertSame(IterableExtensions.<IResolvedOperation>head(declared), IterableExtensions.<IResolvedOperation>head(all));
  }
  
  @Test
  public void testAllOperationsErasedSignatureIncludeDeclaredOperations() {
    final ResolvedFeatures resolvedOperations = this.toResolvedOperations(ResolvedFeaturesTest.DerivedClass.class);
    final List<IResolvedOperation> declared = resolvedOperations.getDeclaredOperations(ResolvedFeaturesTest.DERIVED_CLASS_METHOD_ERASED_SIGNATURE);
    final List<IResolvedOperation> all = resolvedOperations.getAllOperations(ResolvedFeaturesTest.DERIVED_CLASS_METHOD_ERASED_SIGNATURE);
    Assert.assertFalse(all.isEmpty());
    Assert.assertEquals(1, declared.size());
    Assert.assertSame(IterableExtensions.<IResolvedOperation>head(declared), IterableExtensions.<IResolvedOperation>head(all));
  }
  
  @Test
  public void testArrayListHasNoAbstractMethods() {
    final ResolvedFeatures resolvedOperations = this.toResolvedOperations(ArrayList.class);
    final List<IResolvedOperation> all = resolvedOperations.getAllOperations();
    Assert.assertFalse(all.isEmpty());
    final Consumer<IResolvedOperation> _function = (IResolvedOperation it) -> {
      Assert.assertFalse(it.getDeclaration().isAbstract());
    };
    all.forEach(_function);
  }
  
  @Test
  public void testIterableIterator() {
    final ResolvedFeatures resolvedOperations = this.toResolvedOperations(Iterable.class);
    final List<IResolvedOperation> all = resolvedOperations.getAllOperations();
    Assert.assertFalse(all.isEmpty());
    final Function1<IResolvedOperation, Boolean> _function = (IResolvedOperation it) -> {
      return Boolean.valueOf(it.getDeclaration().isAbstract());
    };
    final IResolvedOperation iterator = Iterables.<IResolvedOperation>getOnlyElement(IterableExtensions.<IResolvedOperation>filter(all, _function));
    Assert.assertEquals("java.lang.Iterable.iterator()", iterator.getDeclaration().getIdentifier());
  }
  
  @Test
  public void testUnmodifiableIterator() {
    final ResolvedFeatures resolvedOperations = this.toResolvedOperations(UnmodifiableIterator.class);
    final List<IResolvedOperation> all = resolvedOperations.getAllOperations();
    Assert.assertFalse(all.isEmpty());
    final Function1<IResolvedOperation, Boolean> _function = (IResolvedOperation it) -> {
      return Boolean.valueOf(it.getDeclaration().isAbstract());
    };
    Assert.assertEquals(all.toString(), 2, IterableExtensions.size(IterableExtensions.<IResolvedOperation>filter(all, _function)));
    final Function1<IResolvedOperation, Boolean> _function_1 = (IResolvedOperation it) -> {
      return Boolean.valueOf(it.getDeclaration().isFinal());
    };
    Assert.assertEquals(all.toString(), (1 + 6), IterableExtensions.size(IterableExtensions.<IResolvedOperation>filter(all, _function_1)));
    final List<IResolvedOperation> declared = resolvedOperations.getDeclaredOperations();
    Assert.assertEquals(1, declared.size());
  }
  
  @Test
  public void testAbstractList() {
    final ResolvedFeatures resolvedOperations = this.toResolvedOperations(AbstractList.class);
    final List<IResolvedOperation> all = resolvedOperations.getAllOperations();
    Assert.assertFalse(all.isEmpty());
    final Function1<IResolvedOperation, Boolean> _function = (IResolvedOperation it) -> {
      return Boolean.valueOf(it.getDeclaration().isAbstract());
    };
    Assert.assertEquals(all.toString(), (1 + 1), IterableExtensions.size(IterableExtensions.<IResolvedOperation>filter(all, _function)));
    final List<IResolvedOperation> declared = resolvedOperations.getDeclaredOperations();
    final Function1<IResolvedOperation, Boolean> _function_1 = (IResolvedOperation it) -> {
      return Boolean.valueOf(it.getDeclaration().isAbstract());
    };
    Assert.assertEquals(1, IterableExtensions.size(IterableExtensions.<IResolvedOperation>filter(declared, _function_1)));
  }
  
  @Test
  public void testSoftReferenceConstructors() {
    final ResolvedFeatures resolvedOperations = this.toResolvedOperations(SoftReference.class);
    Assert.assertEquals(1, resolvedOperations.getDeclaredOperations().size());
    Assert.assertEquals(2, resolvedOperations.getDeclaredConstructors().size());
    final Consumer<IResolvedConstructor> _function = (IResolvedConstructor it) -> {
      int _size = it.getDeclaration().getParameters().size();
      switch (_size) {
        case 1:
          Assert.assertEquals("SoftReference(T)", it.getResolvedSignature());
          Assert.assertEquals("SoftReference(java.lang.Object)", it.getResolvedErasureSignature());
          break;
        case 2:
          Assert.assertEquals("SoftReference(T,java.lang.ref.ReferenceQueue<? super T>)", it.getResolvedSignature());
          Assert.assertEquals("SoftReference(java.lang.Object,java.lang.ref.ReferenceQueue)", it.getResolvedErasureSignature());
          break;
        default:
          Assert.fail(("Unexpected constructor: " + it));
          break;
      }
    };
    resolvedOperations.getDeclaredConstructors().forEach(_function);
  }
  
  @Test
  public void testSoftReferenceOfString() {
    final ResolvedFeatures resolvedOperations = this.toResolvedOperations("null as java.lang.ref.SoftReference<String>");
    Assert.assertEquals(1, resolvedOperations.getDeclaredOperations().size());
    Assert.assertEquals(2, resolvedOperations.getDeclaredConstructors().size());
    final Consumer<IResolvedConstructor> _function = (IResolvedConstructor it) -> {
      int _size = it.getDeclaration().getParameters().size();
      switch (_size) {
        case 1:
          Assert.assertEquals("SoftReference(java.lang.String)", it.getResolvedSignature());
          Assert.assertEquals("SoftReference(java.lang.String)", it.getResolvedErasureSignature());
          break;
        case 2:
          Assert.assertEquals("SoftReference(java.lang.String,java.lang.ref.ReferenceQueue<? super java.lang.String>)", it.getResolvedSignature());
          Assert.assertEquals("SoftReference(java.lang.String,java.lang.ref.ReferenceQueue)", it.getResolvedErasureSignature());
          break;
        default:
          Assert.fail(("Unexpected constructor: " + it));
          break;
      }
    };
    resolvedOperations.getDeclaredConstructors().forEach(_function);
  }
  
  @Test
  public void testReferenceOfString() {
    final ResolvedFeatures resolvedFeatures = this.toResolvedOperations("null as java.lang.ref.Reference<String>");
    final List<IResolvedField> fields = IterableExtensions.<IResolvedField>toList(resolvedFeatures.getDeclaredFields());
    final Function1<IResolvedField, Boolean> _function = (IResolvedField it) -> {
      String _simpleSignature = it.getSimpleSignature();
      return Boolean.valueOf(Objects.equal(_simpleSignature, "referent"));
    };
    Assert.assertEquals("String", IterableExtensions.<IResolvedField>findFirst(fields, _function).getResolvedType().getHumanReadableName());
    final Function1<IResolvedField, Boolean> _function_1 = (IResolvedField it) -> {
      String _simpleSignature = it.getSimpleSignature();
      return Boolean.valueOf(Objects.equal(_simpleSignature, "queue"));
    };
    Assert.assertEquals("ReferenceQueue<? super String>", IterableExtensions.<IResolvedField>findFirst(fields, _function_1).getResolvedType().getHumanReadableName());
  }
}
