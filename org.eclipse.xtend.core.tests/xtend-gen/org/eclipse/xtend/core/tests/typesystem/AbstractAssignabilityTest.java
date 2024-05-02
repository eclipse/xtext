/**
 * Copyright (c) 2012, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.typesystem;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.typesystem.references.CompoundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;
import org.junit.Assert;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public abstract class AbstractAssignabilityTest extends AbstractTestingTypeReferenceOwner {
  @Inject
  @Extension
  protected IXtendJvmAssociations _iXtendJvmAssociations;

  public void isAssignableFrom(final Class<?> lhs, final String rhs) {
    String _canonicalName = lhs.getCanonicalName();
    this.isAssignableFrom(Pair.<String, String>of(_canonicalName, null), rhs, true);
  }

  public void isAssignableFrom(final Class<?> lhs, final Class<?> rhs) {
    String _canonicalName = lhs.getCanonicalName();
    this.isAssignableFrom(Pair.<String, String>of(_canonicalName, null), rhs.getCanonicalName(), true);
  }

  public void isAssignableFrom(final String lhs, final String rhs) {
    this.isAssignableFrom(Pair.<String, String>of(lhs, null), rhs, true);
  }

  public void isAssignableFromAny(final String lhs) {
    this.isAssignableFrom(Pair.<String, String>of(lhs, null), null, true);
  }

  public void isAssignableFrom(final String lhs, final Class<?> rhs) {
    this.isAssignableFrom(Pair.<String, String>of(lhs, null), rhs.getCanonicalName(), true);
  }

  public void isNotAssignableFrom(final Class<?> lhs, final String rhs) {
    String _canonicalName = lhs.getCanonicalName();
    this.isAssignableFrom(Pair.<String, String>of(_canonicalName, null), rhs, false);
  }

  public void isNotAssignableFrom(final String lhs, final String rhs) {
    this.isAssignableFrom(Pair.<String, String>of(lhs, null), rhs, false);
  }

  public void isNotAssignableFromAny(final String lhs) {
    this.isAssignableFrom(Pair.<String, String>of(lhs, null), null, false);
  }

  public void isAssignableFrom(final Pair<String, String> lhsAndParams, final String rhs) {
    this.isAssignableFrom(lhsAndParams, rhs, true);
  }

  public void isNotAssignableFrom(final Pair<String, String> lhsAndParams, final String rhs) {
    this.isAssignableFrom(lhsAndParams, rhs, false);
  }

  public void isAssignableFrom(final Pair<String, String> lhsAndParams, final String rhs, final boolean expectation) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("def ");
      {
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(lhsAndParams.getValue());
        boolean _not = (!_isNullOrEmpty);
        if (_not) {
          _builder.append("<");
          String _value = lhsAndParams.getValue();
          _builder.append(_value);
          _builder.append("> ");
        }
      }
      _builder.append("void method(");
      String _fixup = this.fixup(lhsAndParams.getKey());
      _builder.append(_fixup);
      _builder.append(" lhs, ");
      String _fixup_1 = this.fixup(rhs);
      _builder.append(_fixup_1);
      _builder.append(" rhs) {}");
      final String signature = _builder.toString();
      final XtendFunction function = this.function(signature.toString());
      final JvmOperation operation = this._iXtendJvmAssociations.getDirectlyInferredOperation(function);
      LightweightTypeReference _xifexpression = null;
      String _key = lhsAndParams.getKey();
      boolean _tripleNotEquals = (_key != null);
      if (_tripleNotEquals) {
        _xifexpression = this.toLightweightTypeReference(IterableExtensions.<JvmFormalParameter>head(operation.getParameters()).getParameterType());
      } else {
        _xifexpression = this.getOwner().newAnyTypeReference();
      }
      final LightweightTypeReference lhsType = _xifexpression;
      LightweightTypeReference _xifexpression_1 = null;
      if ((rhs != null)) {
        _xifexpression_1 = this.toLightweightTypeReference(IterableExtensions.<JvmFormalParameter>lastOrNull(operation.getParameters()).getParameterType());
      } else {
        _xifexpression_1 = this.getOwner().newAnyTypeReference();
      }
      final LightweightTypeReference rhsType = _xifexpression_1;
      String _simpleName = lhsType.getSimpleName();
      String _plus = (_simpleName + " := ");
      String _simpleName_1 = rhsType.getSimpleName();
      String _plus_1 = (_plus + _simpleName_1);
      Assert.assertEquals(_plus_1, Boolean.valueOf(expectation), Boolean.valueOf(this.testIsAssignable(lhsType, rhsType)));
      if (expectation) {
        List<LightweightTypeReference> _allSuperTypes = lhsType.getAllSuperTypes();
        for (final LightweightTypeReference superType : _allSuperTypes) {
          if (((superType.isArray() == lhsType.isArray()) || (lhsType.isArray() == rhsType.isArray()))) {
            Assert.assertEquals(superType.toString(), Boolean.valueOf(expectation), Boolean.valueOf(this.testIsAssignable(superType, rhsType)));
          }
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  protected String fixup(final String type) {
    String _elvis = null;
    String _replace = null;
    if (type!=null) {
      _replace=type.replace("$$Procedure", "org.eclipse.xtext.xbase.lib.Procedures.Procedure");
    }
    String _replace_1 = null;
    if (_replace!=null) {
      _replace_1=_replace.replace("$Procedure", "org.eclipse.xtext.xbase.lib.Procedures$Procedure");
    }
    String _replace_2 = null;
    if (_replace_1!=null) {
      _replace_2=_replace_1.replace("$Function<", "com.google.common.base.Function<");
    }
    String _replace_3 = null;
    if (_replace_2!=null) {
      _replace_3=_replace_2.replace("$Predicate<", "com.google.common.base.Predicate<");
    }
    String _replace_4 = null;
    if (_replace_3!=null) {
      _replace_4=_replace_3.replace("$$Function", "org.eclipse.xtext.xbase.lib.Functions.Function");
    }
    String _replace_5 = null;
    if (_replace_4!=null) {
      _replace_5=_replace_4.replace("$Function", "org.eclipse.xtext.xbase.lib.Functions$Function");
    }
    if (_replace_5 != null) {
      _elvis = _replace_5;
    } else {
      _elvis = "Object";
    }
    return _elvis;
  }

  public boolean testIsAssignable(final LightweightTypeReference lhs, final LightweightTypeReference rhs) {
    Assert.assertTrue(this.doIsAssignable(lhs, lhs));
    Assert.assertTrue(this.doIsAssignable(lhs, this.toLightweightTypeReference(lhs.toTypeReference())));
    Assert.assertTrue(this.doIsAssignable(rhs, this.toLightweightTypeReference(rhs.toTypeReference())));
    final boolean result = this.doIsAssignable(lhs, rhs);
    boolean _isPrimitiveVoid = rhs.isPrimitiveVoid();
    boolean _not = (!_isPrimitiveVoid);
    if (_not) {
      final WildcardTypeReference wcRhs = this.getOwner().newWildcardTypeReference();
      wcRhs.addUpperBound(rhs.getWrapperTypeIfPrimitive());
      Assert.assertEquals(Boolean.valueOf(result), Boolean.valueOf(this.doIsAssignable(lhs, wcRhs)));
      final CompoundTypeReference compoundRhs = this.getOwner().newCompoundTypeReference(true);
      compoundRhs.addComponent(rhs);
      final JvmType object = rhs.getOwner().getServices().getTypeReferences().findDeclaredType(Object.class, rhs.getOwner().getContextResourceSet());
      compoundRhs.addComponent(rhs.getOwner().newParameterizedTypeReference(object));
      String _plus = (lhs + " := ");
      String _string = compoundRhs.toString();
      String _plus_1 = (_plus + _string);
      Assert.assertEquals(_plus_1, Boolean.valueOf(result), Boolean.valueOf(this.doIsAssignable(lhs, compoundRhs)));
    }
    return result;
  }

  public boolean doIsAssignable(final LightweightTypeReference lhs, final LightweightTypeReference rhs) {
    return lhs.isAssignableFrom(rhs);
  }
}
