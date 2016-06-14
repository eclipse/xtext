/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.util;

import java.beans.Introspector;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmOperation;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class PropertyUtil {
  public static String getPropertyName(final JvmFeature feature) {
    String _xifexpression = null;
    boolean _isStatic = feature.isStatic();
    if (_isStatic) {
      String _simpleName = feature.getSimpleName();
      _xifexpression = PropertyUtil.getPropertyName(feature, _simpleName, 1, 2);
    } else {
      String _simpleName_1 = feature.getSimpleName();
      _xifexpression = PropertyUtil.getPropertyName(feature, _simpleName_1, 0, 1);
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
        String _substring = methodName.substring(prefixLength);
        _xifexpression = Introspector.decapitalize(_substring);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected static boolean startsWithPrefix(final String methodName, final String prefix, final int prefixLength) {
    return (((methodName.length() > prefixLength) && methodName.startsWith(prefix)) && Character.isUpperCase(methodName.charAt(prefixLength)));
  }
}
