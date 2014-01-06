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
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedConstructor;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedOperation;
import org.eclipse.xtext.xbase.typesystem.override.OverrideHelper;
import org.eclipse.xtext.xbase.typesystem.override.ResolvedOperations;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class ResolvedOperationsTest extends AbstractXbaseTestCase {
  @Inject
  private OverrideHelper overrideHelper;
  
  public ResolvedOperations toResolvedOperations(final Class<? extends Object> type) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("typeof(");
      String _canonicalName = type.getCanonicalName();
      _builder.append(_canonicalName, "");
      _builder.append(")");
      XExpression _expression = this.expression(_builder);
      final XTypeLiteral typeLiteral = ((XTypeLiteral) _expression);
      JvmType _type = typeLiteral.getType();
      final ResolvedOperations result = this.overrideHelper.getResolvedOperations(((JvmDeclaredType) _type));
      return result;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public ResolvedOperations toResolvedOperations(final String castExpression) {
    try {
      XExpression _expression = this.expression(castExpression);
      final XCastedExpression cast = ((XCastedExpression) _expression);
      JvmTypeReference _type = cast.getType();
      final ResolvedOperations result = this.overrideHelper.getResolvedOperations(_type);
      return result;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testArrayListHasNoAbstractMethods() {
    final ResolvedOperations resolvedOperations = this.toResolvedOperations(ArrayList.class);
    final List<IResolvedOperation> all = resolvedOperations.getAllOperations();
    boolean _isEmpty = all.isEmpty();
    Assert.assertFalse(_isEmpty);
    final Procedure1<IResolvedOperation> _function = new Procedure1<IResolvedOperation>() {
      public void apply(final IResolvedOperation it) {
        JvmOperation _declaration = it.getDeclaration();
        boolean _isAbstract = _declaration.isAbstract();
        Assert.assertFalse(_isAbstract);
      }
    };
    IterableExtensions.<IResolvedOperation>forEach(all, _function);
  }
  
  @Test
  public void testIterableIterator() {
    final ResolvedOperations resolvedOperations = this.toResolvedOperations(Iterable.class);
    final List<IResolvedOperation> all = resolvedOperations.getAllOperations();
    boolean _isEmpty = all.isEmpty();
    Assert.assertFalse(_isEmpty);
    final Function1<IResolvedOperation,Boolean> _function = new Function1<IResolvedOperation,Boolean>() {
      public Boolean apply(final IResolvedOperation it) {
        JvmOperation _declaration = it.getDeclaration();
        return Boolean.valueOf(_declaration.isAbstract());
      }
    };
    Iterable<IResolvedOperation> _filter = IterableExtensions.<IResolvedOperation>filter(all, _function);
    final IResolvedOperation iterator = Iterables.<IResolvedOperation>getOnlyElement(_filter);
    JvmOperation _declaration = iterator.getDeclaration();
    String _identifier = _declaration.getIdentifier();
    Assert.assertEquals("java.lang.Iterable.iterator()", _identifier);
  }
  
  @Test
  public void testUnmodifiableIterator() {
    final ResolvedOperations resolvedOperations = this.toResolvedOperations(UnmodifiableIterator.class);
    final List<IResolvedOperation> all = resolvedOperations.getAllOperations();
    boolean _isEmpty = all.isEmpty();
    Assert.assertFalse(_isEmpty);
    String _string = all.toString();
    final Function1<IResolvedOperation,Boolean> _function = new Function1<IResolvedOperation,Boolean>() {
      public Boolean apply(final IResolvedOperation it) {
        JvmOperation _declaration = it.getDeclaration();
        return Boolean.valueOf(_declaration.isAbstract());
      }
    };
    Iterable<IResolvedOperation> _filter = IterableExtensions.<IResolvedOperation>filter(all, _function);
    int _size = IterableExtensions.size(_filter);
    Assert.assertEquals(_string, 2, _size);
    String _string_1 = all.toString();
    final Function1<IResolvedOperation,Boolean> _function_1 = new Function1<IResolvedOperation,Boolean>() {
      public Boolean apply(final IResolvedOperation it) {
        JvmOperation _declaration = it.getDeclaration();
        return Boolean.valueOf(_declaration.isFinal());
      }
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
    final ResolvedOperations resolvedOperations = this.toResolvedOperations(AbstractList.class);
    final List<IResolvedOperation> all = resolvedOperations.getAllOperations();
    boolean _isEmpty = all.isEmpty();
    Assert.assertFalse(_isEmpty);
    String _string = all.toString();
    final Function1<IResolvedOperation,Boolean> _function = new Function1<IResolvedOperation,Boolean>() {
      public Boolean apply(final IResolvedOperation it) {
        JvmOperation _declaration = it.getDeclaration();
        return Boolean.valueOf(_declaration.isAbstract());
      }
    };
    Iterable<IResolvedOperation> _filter = IterableExtensions.<IResolvedOperation>filter(all, _function);
    int _size = IterableExtensions.size(_filter);
    Assert.assertEquals(_string, (1 + 1), _size);
    final List<IResolvedOperation> declared = resolvedOperations.getDeclaredOperations();
    final Function1<IResolvedOperation,Boolean> _function_1 = new Function1<IResolvedOperation,Boolean>() {
      public Boolean apply(final IResolvedOperation it) {
        JvmOperation _declaration = it.getDeclaration();
        return Boolean.valueOf(_declaration.isAbstract());
      }
    };
    Iterable<IResolvedOperation> _filter_1 = IterableExtensions.<IResolvedOperation>filter(declared, _function_1);
    int _size_1 = IterableExtensions.size(_filter_1);
    Assert.assertEquals(1, _size_1);
  }
  
  @Test
  public void testSoftReferenceConstructors() {
    final ResolvedOperations resolvedOperations = this.toResolvedOperations(SoftReference.class);
    List<IResolvedOperation> _declaredOperations = resolvedOperations.getDeclaredOperations();
    int _size = _declaredOperations.size();
    Assert.assertEquals(1, _size);
    List<IResolvedConstructor> _declaredConstructors = resolvedOperations.getDeclaredConstructors();
    int _size_1 = _declaredConstructors.size();
    Assert.assertEquals(2, _size_1);
    List<IResolvedConstructor> _declaredConstructors_1 = resolvedOperations.getDeclaredConstructors();
    final Procedure1<IResolvedConstructor> _function = new Procedure1<IResolvedConstructor>() {
      public void apply(final IResolvedConstructor it) {
        JvmConstructor _declaration = it.getDeclaration();
        EList<JvmFormalParameter> _parameters = _declaration.getParameters();
        int _size = _parameters.size();
        final int _switchValue = _size;
        boolean _matched = false;
        if (!_matched) {
          if (Objects.equal(_switchValue,1)) {
            _matched=true;
            String _resolvedSignature = it.getResolvedSignature();
            Assert.assertEquals("SoftReference(T)", _resolvedSignature);
            String _resolvedErasureSignature = it.getResolvedErasureSignature();
            Assert.assertEquals("SoftReference(java.lang.Object)", _resolvedErasureSignature);
          }
        }
        if (!_matched) {
          if (Objects.equal(_switchValue,2)) {
            _matched=true;
            String _resolvedSignature_1 = it.getResolvedSignature();
            Assert.assertEquals("SoftReference(T,java.lang.ref.ReferenceQueue<? super T>)", _resolvedSignature_1);
            String _resolvedErasureSignature_1 = it.getResolvedErasureSignature();
            Assert.assertEquals("SoftReference(java.lang.Object,java.lang.ref.ReferenceQueue)", _resolvedErasureSignature_1);
          }
        }
        if (!_matched) {
          Assert.fail(("Unexpected constructor: " + it));
        }
      }
    };
    IterableExtensions.<IResolvedConstructor>forEach(_declaredConstructors_1, _function);
  }
  
  @Test
  public void testSoftReferenceOfString() {
    final ResolvedOperations resolvedOperations = this.toResolvedOperations("null as java.lang.ref.SoftReference<String>");
    List<IResolvedOperation> _declaredOperations = resolvedOperations.getDeclaredOperations();
    int _size = _declaredOperations.size();
    Assert.assertEquals(1, _size);
    List<IResolvedConstructor> _declaredConstructors = resolvedOperations.getDeclaredConstructors();
    int _size_1 = _declaredConstructors.size();
    Assert.assertEquals(2, _size_1);
    List<IResolvedConstructor> _declaredConstructors_1 = resolvedOperations.getDeclaredConstructors();
    final Procedure1<IResolvedConstructor> _function = new Procedure1<IResolvedConstructor>() {
      public void apply(final IResolvedConstructor it) {
        JvmConstructor _declaration = it.getDeclaration();
        EList<JvmFormalParameter> _parameters = _declaration.getParameters();
        int _size = _parameters.size();
        final int _switchValue = _size;
        boolean _matched = false;
        if (!_matched) {
          if (Objects.equal(_switchValue,1)) {
            _matched=true;
            String _resolvedSignature = it.getResolvedSignature();
            Assert.assertEquals("SoftReference(java.lang.String)", _resolvedSignature);
            String _resolvedErasureSignature = it.getResolvedErasureSignature();
            Assert.assertEquals("SoftReference(java.lang.String)", _resolvedErasureSignature);
          }
        }
        if (!_matched) {
          if (Objects.equal(_switchValue,2)) {
            _matched=true;
            String _resolvedSignature_1 = it.getResolvedSignature();
            Assert.assertEquals("SoftReference(java.lang.String,java.lang.ref.ReferenceQueue<? super java.lang.String>)", _resolvedSignature_1);
            String _resolvedErasureSignature_1 = it.getResolvedErasureSignature();
            Assert.assertEquals("SoftReference(java.lang.String,java.lang.ref.ReferenceQueue)", _resolvedErasureSignature_1);
          }
        }
        if (!_matched) {
          Assert.fail(("Unexpected constructor: " + it));
        }
      }
    };
    IterableExtensions.<IResolvedConstructor>forEach(_declaredConstructors_1, _function);
  }
}
