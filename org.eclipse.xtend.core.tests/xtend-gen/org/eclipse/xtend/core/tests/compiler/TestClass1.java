/**
 * Copyright (c) 2012, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.compiler;

@SuppressWarnings("all")
public class TestClass1 {
  public int testFunction1() {
    return 42;
  }

  public int testFunction2() {
    return 42;
  }

  public Integer testFunction3() {
    return Integer.valueOf((40 + 2));
  }

  public Integer testFunction4() {
    return Integer.valueOf((6 * 7));
  }
}
