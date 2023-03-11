/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class ConditionUtils {
  public static void notRemoved(final EObject object, final String name) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(name);
    _builder.append(" cannot be null");
    Preconditions.checkArgument((object != null), _builder);
    Resource _eResource = object.eResource();
    boolean _tripleNotEquals = (_eResource != null);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(name);
    _builder_1.append(" cannot be removed");
    Preconditions.checkArgument(_tripleNotEquals, _builder_1);
  }

  public static void checkInferredTypeReferences(final String typeName, final TypeReference... types) {
    for (final TypeReference type : types) {
      if (((type != null) && type.isInferred())) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Cannot use inferred type as ");
        _builder.append(typeName);
        _builder.append(".");
        throw new IllegalArgumentException(_builder.toString());
      }
    }
  }

  public static void checkIterable(final Iterable<?> values, final String name) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(name);
    _builder.append(" cannot be null");
    Preconditions.checkArgument((values != null), _builder);
    for (final Object value : values) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(name);
      _builder_1.append(" cannot contain null");
      Preconditions.checkArgument((value != null), _builder_1);
    }
  }

  public static void checkQualifiedName(final String qualifiedName, final String name) {
    boolean _isValidQualifiedName = ConditionUtils.isValidQualifiedName(qualifiedName);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(name);
    _builder.append(" has to be a valid qualified name");
    Preconditions.checkArgument(_isValidQualifiedName, _builder);
  }

  public static void checkJavaIdentifier(final String string, final String name) {
    boolean _isValidJavaIdentifier = ConditionUtils.isValidJavaIdentifier(string);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(name);
    _builder.append(" has to be a valid java identifier");
    Preconditions.checkArgument(_isValidJavaIdentifier, _builder);
  }

  public static void checkTypeName(final String typeName, final String valueType) {
    boolean _equals = Objects.equal(typeName, valueType);
    Preconditions.checkArgument(_equals, ConditionUtils.isNotApplicableMessage(valueType, typeName));
  }

  public static String isNotApplicableMessage(final String valueType, final String typeName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(valueType);
    _builder.append(" is not applicable at this location. Expected ");
    _builder.append(typeName);
    return _builder.toString();
  }

  public static boolean isValidQualifiedName(final String string) {
    boolean _xblockexpression = false;
    {
      if (((string == null) || (string.length() == 0))) {
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
      if (((string == null) || (string.length() == 0))) {
        return false;
      }
      final char[] charArray = string.toCharArray();
      boolean _isJavaIdentifierStart = Character.isJavaIdentifierStart((IterableExtensions.<Character>head(((Iterable<Character>)Conversions.doWrapArray(charArray)))).charValue());
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
