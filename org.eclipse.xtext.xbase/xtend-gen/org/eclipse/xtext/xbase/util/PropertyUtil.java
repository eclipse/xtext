/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.util;

import java.beans.Introspector;
import java.util.Locale;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.util.Strings;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class PropertyUtil {
  public static String getPropertyName(final JvmFeature feature) {
    String _xifexpression = null;
    boolean _isStatic = feature.isStatic();
    if (_isStatic) {
      _xifexpression = PropertyUtil.getPropertyName(feature, feature.getSimpleName(), 1, 2);
    } else {
      _xifexpression = PropertyUtil.getPropertyName(feature, feature.getSimpleName(), 0, 1);
    }
    return _xifexpression;
  }
  
  public static String getPropertyName(final JvmFeature feature, final String methodName, final int getterParams, final int setterParams) {
    String _xifexpression = null;
    if ((feature instanceof JvmOperation)) {
      String _elvis = null;
      String _elvis_1 = null;
      String _propertyName = PropertyUtil.getPropertyName(((JvmOperation)feature), methodName, "get", getterParams);
      if (_propertyName != null) {
        _elvis_1 = _propertyName;
      } else {
        String _propertyName_1 = PropertyUtil.getPropertyName(((JvmOperation)feature), methodName, "set", setterParams);
        _elvis_1 = _propertyName_1;
      }
      if (_elvis_1 != null) {
        _elvis = _elvis_1;
      } else {
        String _propertyName_2 = PropertyUtil.getPropertyName(((JvmOperation)feature), methodName, "is", getterParams);
        _elvis = _propertyName_2;
      }
      _xifexpression = _elvis;
    }
    return _xifexpression;
  }
  
  protected static String getPropertyName(final JvmOperation operation, final String methodName, final String prefix, final int params) {
    String _xblockexpression = null;
    {
      final int prefixLength = prefix.length();
      String _xifexpression = null;
      if ((PropertyUtil.startsWithPrefix(methodName, prefix, prefixLength) && (operation.getParameters().size() == params))) {
        _xifexpression = Introspector.decapitalize(methodName.substring(prefixLength));
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected static boolean startsWithPrefix(final String methodName, final String prefix, final int prefixLength) {
    return (((methodName.length() > prefixLength) && methodName.startsWith(prefix)) && Character.isUpperCase(methodName.charAt(prefixLength)));
  }
  
  /**
   * @Nullable
   */
  public static String tryGetShorthandName(final String fullName) {
    String _xifexpression = null;
    if ((fullName.startsWith("get") || fullName.startsWith("set"))) {
      _xifexpression = fullName.substring(3);
    } else {
      String _xifexpression_1 = null;
      boolean _startsWith = fullName.startsWith("is");
      if (_startsWith) {
        _xifexpression_1 = fullName.substring(2);
      } else {
        return null;
      }
      _xifexpression = _xifexpression_1;
    }
    final String name = _xifexpression;
    int _length = name.length();
    boolean _equals = (_length == 1);
    if (_equals) {
      return name.toLowerCase(Locale.ENGLISH);
    } else {
      int _length_1 = name.length();
      boolean _greaterThan = (_length_1 > 1);
      if (_greaterThan) {
        boolean _isUpperCase = Character.isUpperCase(name.charAt(1));
        if (_isUpperCase) {
          boolean _isUpperCase_1 = Character.isUpperCase(name.charAt(0));
          if (_isUpperCase_1) {
            return name;
          }
          return null;
        } else {
          return Strings.toFirstLower(name);
        }
      }
    }
    return null;
  }
}
