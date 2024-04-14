/**
 * Copyright (c) 2012, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.smoke;

import java.util.Objects;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class Case_2 {
  public String aOrB(final String a, final String b) {
    String _xifexpression = null;
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(a);
    if (_isNullOrEmpty) {
      _xifexpression = b;
    } else {
      _xifexpression = a;
    }
    return _xifexpression;
  }

  public String returnInIf(final char c) {
    boolean _notEquals = (!Objects.equals("x", Character.valueOf(c)));
    if (_notEquals) {
      return "xx";
    } else {
      return "yy";
    }
  }
}
