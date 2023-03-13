/**
 * Copyright (c) 2012, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.smoke;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class Case_1 {
  @Accessors
  private int id;

  public int testFunction1() {
    return 42;
  }

  public int testFunction2() {
    return 42;
  }

  public Integer testFunction3() {
    return Integer.valueOf(42);
  }

  @Pure
  public int getId() {
    return this.id;
  }

  public void setId(final int id) {
    this.id = id;
  }
}
