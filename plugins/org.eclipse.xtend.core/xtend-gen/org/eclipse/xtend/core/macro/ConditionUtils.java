/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class ConditionUtils {
  public static void checkInferredTypeReferences(final String typeName, final TypeReference... types) {
    for (final TypeReference type : types) {
      boolean _and = false;
      boolean _notEquals = (!Objects.equal(type, null));
      if (!_notEquals) {
        _and = false;
      } else {
        boolean _isInferred = type.isInferred();
        _and = _isInferred;
      }
      if (_and) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Cannot use inferred type as ");
        _builder.append(typeName, "");
        _builder.append(".");
        throw new IllegalArgumentException(_builder.toString());
      }
    }
  }
  
  public static void checkIterable(final Iterable<?> values, final String name) {
    boolean _notEquals = (!Objects.equal(values, null));
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(name, "");
    _builder.append(" cannot be null");
    Preconditions.checkArgument(_notEquals, _builder);
    for (final Object value : values) {
      boolean _notEquals_1 = (!Objects.equal(value, null));
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(name, "");
      _builder_1.append(" cannot contain null");
      Preconditions.checkArgument(_notEquals_1, _builder_1);
    }
  }
  
  public static void checkQualifiedName(final String qualifiedName, final String name) {
    boolean _isValidQualifiedName = ConditionUtils.isValidQualifiedName(qualifiedName);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(name, "");
    _builder.append(" has to be a valid qualified name");
    Preconditions.checkArgument(_isValidQualifiedName, _builder);
  }
  
  public static void checkJavaIdentifier(final String string, final String name) {
    boolean _isValidJavaIdentifier = ConditionUtils.isValidJavaIdentifier(string);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(name, "");
    _builder.append(" has to be a valid java identifier");
    Preconditions.checkArgument(_isValidJavaIdentifier, _builder);
  }
  
  public static void checkTypeName(final String typeName, final String valueType) {
    boolean _equals = Objects.equal(typeName, valueType);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(valueType, "");
    _builder.append(" is not applicable at this location. Expected ");
    _builder.append(typeName, "");
    Preconditions.checkArgument(_equals, _builder);
  }
  
  public static boolean isValidQualifiedName(final String string) {
    boolean _xblockexpression = false;
    {
      boolean _or = false;
      boolean _equals = Objects.equal(string, null);
      if (_equals) {
        _or = true;
      } else {
        int _length = string.length();
        boolean _equals_1 = (_length == 0);
        _or = _equals_1;
      }
      if (_or) {
        return false;
      }
      String[] _split = string.split("\\.");
      for (final String identifier : _split) {
        boolean _isValidJavaIdentifier = ConditionUtils.isValidJavaIdentifier(identifier);
        boolean _not = (!_isValidJavaIdentifier);
        if (_not) {
          return false;
        }
      }
      _xblockexpression = true;
    }
    return _xblockexpression;
  }
  
  public static boolean isValidJavaIdentifier(final String string) {
    boolean _xblockexpression = false;
    {
      boolean _or = false;
      boolean _equals = Objects.equal(string, null);
      if (_equals) {
        _or = true;
      } else {
        int _length = string.length();
        boolean _equals_1 = (_length == 0);
        _or = _equals_1;
      }
      if (_or) {
        return false;
      }
      final char[] charArray = string.toCharArray();
      Character _head = IterableExtensions.<Character>head(((Iterable<Character>)Conversions.doWrapArray(charArray)));
      boolean _isJavaIdentifierStart = Character.isJavaIdentifierStart((_head).charValue());
      boolean _not = (!_isJavaIdentifierStart);
      if (_not) {
        return false;
      }
      Iterable<Character> _tail = IterableExtensions.<Character>tail(((Iterable<Character>)Conversions.doWrapArray(charArray)));
      for (final Character ch : _tail) {
        boolean _isJavaIdentifierPart = Character.isJavaIdentifierPart((ch).charValue());
        boolean _not_1 = (!_isJavaIdentifierPart);
        if (_not_1) {
          return false;
        }
      }
      _xblockexpression = true;
    }
    return _xblockexpression;
  }
}
